package ru.geekbrains.erpsystem.services;

import ru.geekbrains.erpsystem.data.OperationEntryData;
import ru.geekbrains.erpsystem.entities.OperationEntry;
import ru.geekbrains.erpsystem.exeptions.NotFoundException;

import java.util.List;

public interface OperationEntryService extends CrudService<OperationEntryData,Long> {

    List<OperationEntryData> insertOrUpdateAll(List<OperationEntryData> datas) throws NotFoundException;

    OperationEntry toEntity(OperationEntryData data);

    List<OperationEntryData> findAllById(List<Long> ids);

    List<OperationEntryData> findAllByTechnologyId(Long id);

    void deleteByTechnologyId(Long id);

}
