package ru.geekbrains.erpsystem.services.impl;

import org.springframework.stereotype.Service;
import ru.geekbrains.erpsystem.data.MaterialData;
import ru.geekbrains.erpsystem.entities.Material;
import ru.geekbrains.erpsystem.repositories.MaterialRepository;
import ru.geekbrains.erpsystem.services.MaterialService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;

    public MaterialServiceImpl(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }


    @Override
    public MaterialData insert(MaterialData materialData) {
        if(materialData.getId() != null){
            throw new RuntimeException("Material with id - "+ materialData.getId() +" is not empty");
        }

        Material material = dataToEntity(materialData);

        return new MaterialData(materialRepository.save(material));
    }

    @Override
    public MaterialData update(MaterialData materialData) {
        if (materialRepository.findById(materialData.getId()).isEmpty()){
            throw new RuntimeException("Material with id - "+materialData.getId() +" is empty");
        }

        Material material = dataToEntity(materialData);

        return new MaterialData(materialRepository.save(material));
    }

    @Override
    public void delete(Long id) {
        materialRepository.delete(materialRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Material with id - "+ id +" not found")));
    }

    @Override
    public Optional<MaterialData> getById(Long id) {
        return materialRepository.findById(id).map(MaterialData::new);
    }

    @Override
    public List<MaterialData> getAll() {
        return materialRepository.findAll().stream()
                .map(MaterialData::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private Material dataToEntity(MaterialData materialData){

        Material material = new Material();

        material.setId(materialData.getId());
        material.setArt(materialData.getArt());
        material.setName(materialData.getName());
        material.setDescription(materialData.getDescription());
        material.setUnitOfMeasurement(materialData.getUnitOfMeasurement());

        return material;
    }
}
