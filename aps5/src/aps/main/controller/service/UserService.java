package aps.main.controller.service;

import aps.main.model.user.UserModel;
import aps.main.controller.repository.UserRepository;

import java.sql.SQLException;

public class UserService {
UserRepository userRepository = new UserRepository();
    public void create(UserModel user) throws SQLException {
       if(user.validate()) {
           userRepository.create(user);
       }else{
           System.out.println("erro => userService => create => user.validation => user.model => {a validação do usuario é nula}");
       }
    }

    public void delete(final Long id) throws SQLException {
        if(id != null) {
            userRepository.deleteById(id);
        }else{
            System.out.println("userService => delete => id => não pode ser nulo");
        }
    }

    public void findById(final Long id) throws SQLException {
        if(id != null){
            userRepository.getByID(id);
        }else{
            System.out.println("userService => findById => id => não pode ser nulo");
        }

    }

    public UserModel findByEmail(String email) throws SQLException {
        return userRepository.getByEmail(email);
    }

    public void getAllFriends(){}


}
