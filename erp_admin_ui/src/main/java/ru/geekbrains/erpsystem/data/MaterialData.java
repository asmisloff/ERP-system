package ru.geekbrains.erpsystem.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.geekbrains.erpsystem.entities.Material;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MaterialData implements Serializable {
    private Long id;
    private String art;
    private String name;
    private String description;
    private String unitOfMeasurement;

    public MaterialData(Material material){
        this.id = material.getId();
        this.art = material.getArt();
        this.name = material.getName();
        this.description = material.getDescription();
        this.unitOfMeasurement = material.getUnitOfMeasurement();
    }
}
