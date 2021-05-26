package ru.geekbrains.erpsystem.data;

import ru.geekbrains.erpsystem.entities.User;

public class UserData {
    private Long id;
    private String name;
    private RoleData roleData;

    public UserData() {
    }

    public UserData(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.roleData = new RoleData(user.getRole());
    }
}
