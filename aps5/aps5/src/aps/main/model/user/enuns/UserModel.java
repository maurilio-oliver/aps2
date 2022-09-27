package aps.main.model.user.enuns;

import java.util.List;
import java.util.Objects;

public class UserModel {
    private Long id;
    private String name;
    private String lestName;
    private String UserName;
    private String email;
    private String password;
    private int phoneNumber;

    private List<String> permission;

    public Long id() {
        return id;
    }

    public UserModel setId(Long id) {this.id = id;
        return this;
    }

    public String name() {
        return name;
    }

    public UserModel setName(String name) {this.name = name;
        return this;
    }

    public String lestName() {
        return lestName;
    }

    public UserModel setLestName(String lestName) {this.lestName = lestName;
        return this;
    }

    public String UserName() {
        return UserName;
    }

    public UserModel setUserName(String userName) {UserName = userName;
        return this;
    }

    public String email() {
        return email;
    }

    public UserModel setEmail(String email) {this.email = email;
        return this;
    }

    public String password() {
        return password;
    }

    public UserModel setPassword(String password) {this.password = password;
        return this;
    }

    public int phoneNumber() {
        return phoneNumber;
    }

    public UserModel setPhoneNumber(int phoneNumber) {this.phoneNumber = phoneNumber;
        return this;
    }

    public List<String> permission() {
        return permission;
    }

    public UserModel setPermission(List<String> permission) {
        this.permission = permission;
        return this;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lestName='" + lestName + '\'' +
                ", UserName='" + UserName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", permission=" + permission +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserModel)) return false;
        UserModel userModel = (UserModel) o;
        return phoneNumber == userModel.phoneNumber && id.equals(userModel.id) && Objects.equals(name, userModel.name) && Objects.equals(lestName, userModel.lestName) && Objects.equals(UserName, userModel.UserName) && email.equals(userModel.email) && password.equals(userModel.password) && Objects.equals(permission, userModel.permission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lestName, UserName, email, password, phoneNumber, permission);
    }
}
