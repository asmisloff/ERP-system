package ru.geekbrains.erpsystem.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.erpsystem.entities.BPlannerModelData;
import ru.geekbrains.erpsystem.repositories.BPlannerModelDataRepository;

import java.util.List;

@Service
public class BPlannerModelDataService {

    private final BPlannerModelDataRepository repository;
    
    public BPlannerModelDataService(BPlannerModelDataRepository repository) {
        this.repository = repository;
    }

    public void save(BPlannerModelData data) {
        repository.save(data);
    }

    public List<BPlannerModelData> getAll() {
        return repository.findAll();
    }

}
