package ru.geekbrains.erpsystem.services.impl;

import org.springframework.stereotype.Service;
import ru.geekbrains.erpsystem.data.RoleData;
import ru.geekbrains.erpsystem.repositories.RoleRepository;
import ru.geekbrains.erpsystem.services.RoleService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleData insert(RoleData roleData) {

        if( roleData.getId() != null ){
            throw new RuntimeException("Role with id - "+ roleData.getId() +"is not empty");
        }
        return new RoleData(roleRepository.save(roleData.getRoleEntity()));
    }

    @Override
    public RoleData update(RoleData roleData) {

        if( roleRepository.findById(roleData.getId()).isEmpty() ){
            throw new RuntimeException("Role with id - "+ roleData.getId() +"is empty");
        }

        return new RoleData(roleRepository.save(roleData.getRoleEntity()));
    }

    @Override
    public void delete(Long id) {
        roleRepository.delete(roleRepository.findById(id)
                .orElseThrow(()->new RuntimeException("no Role with id - " +id)));
    }

    @Override
    public Optional<RoleData> getById(Long id) {
        return roleRepository.findById(id).map(RoleData::new);
    }

    @Override
    public List<RoleData> getAll() {
        return roleRepository.findAll().stream()
                .map(RoleData::new)
                .collect(Collectors.toUnmodifiableList());
    }

}
