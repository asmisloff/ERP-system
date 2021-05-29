package ru.geekbrains.erpsystem.data;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.geekbrains.erpsystem.entities.Role;

@Getter
@Setter
@NoArgsConstructor
public class RoleData {
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
