package aps.test.service;

import aps.main.model.user.UserModel;
import aps.main.controller.repository.UserRepository;

public class UserServiceTest {
static UserRepository repository = new UserRepository();
   private UserModel help() {
        UserModel userModel = new UserModel();

        userModel.setOrg("unip");
        userModel.setName("oliver");
        userModel.setId(204L);
        userModel.setEmail("createUser4@test.com.br");
        userModel.setPassword("59323387");
        userModel.setOrg("develope");
        userModel.setName("oliver");

        return  userModel;
}

    private void createUserTest(){
       try{
           repository.create(this.help());
       }catch (Exception e){

       }

    }
    private void deletUserTest(){
        try{
                repository.deleteById(this.help().id());
        }catch (Exception e){

        }
    }
    private void selectUserByIdTest(){
        try{
            System.out.println( repository.getByID(this.help().id()));
        }catch (Exception e){

        }
    }

    public void test(){
       createUserTest();
       selectUserByIdTest();
       deletUserTest();
    }


}
