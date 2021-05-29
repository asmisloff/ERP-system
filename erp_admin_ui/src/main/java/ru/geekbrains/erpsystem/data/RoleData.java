package ru.geekbrains.erpsystem.data;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.geekbrains.erpsystem.entities.Role;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class RoleData implements Serializable {

    private Long id;
    private String name;


    public RoleData(Role role){
        this.id = role.getId();
        this.name = role.getName();
    }

    public Role getRoleEntity(){
        Role initRole = new Role();
        initRole.setId(this.id);
        initRole.setName(this.name);

        return initRole;
    }
}
