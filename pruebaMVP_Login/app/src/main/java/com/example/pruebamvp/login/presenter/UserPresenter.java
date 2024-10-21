package com.example.pruebamvp.login.presenter;

import com.example.pruebamvp.beans.User;
import com.example.pruebamvp.login.ContractUser;
import com.example.pruebamvp.login.model.UserModel;

public class UserPresenter implements ContractUser.Presenter, ContractUser.Model.loginListener {
    private ContractUser.View view;
    private ContractUser.Model model;


    public UserPresenter(ContractUser.View view){
        this.view =view;
        model = new UserModel();
    }

    private boolean isValidInput(User user){
        return user != null && user.getEmail()!= null && !user.getEmail().isEmpty()
                && user.getPassword() != null && !user.getPassword().isEmpty();
    }

    @Override
    public void login(User user) {
        if (isValidInput(user)){
            model.API(user, this);
        }else {
            view.failureLogin("Invalid email or password");
        }
    }
    @Override
    public void onFinished(User user) {
        view.successLogin(user);
    }

    @Override
    public void onFailure(String err) {
        view.failureLogin(err);
    }


}
