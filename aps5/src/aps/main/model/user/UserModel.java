package aps.main.model.user;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class UserModel {
    private Long id;
    private String name;
    private String lestName;
    private String UserName;
    private String email;
    private String password;

    private String org;

    private Date createAt;

    private Date deletedAt;
    private List<String> permission;

    private List<String> contacts;

    public List<String> contacts() {
        return contacts;
    }

    public UserModel setContacts(List<String> contacts) {
        this.contacts = contacts;
        return this;
    }

    public String org() {
        return org;
    }

    public UserModel setOrg(String org) {
        this.org = org;
        return this;
    }

    public Date createAt() {
        return createAt;
    }

    public UserModel setCreateAt(Date createAt) {
        this.createAt = createAt;
        return this;
    }

    public Date deletedAt() {
        return deletedAt;
    }

    public UserModel setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
        return this;
    }

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
                ", UserName='" + UserName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", permission=" + permission +
                ", contacts=" + contacts +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserModel)) return false;
        UserModel userModel = (UserModel) o;
        return id.equals(userModel.id) && email.equals(userModel.email) && password.equals(userModel.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password);
    }

    public boolean validate(){
        return this.id != null
                && (this.email != null)
                && this.password != null;
    }
}
