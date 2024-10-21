package com.example.pruebamvplogin.login.presenter;

import com.example.pruebamvplogin.beans.User;
import com.example.pruebamvplogin.login.ContractLoginUser;
import com.example.pruebamvplogin.login.model.LoginModel;

public class LoginPresenter implements ContractLoginUser.Presenter, ContractLoginUser.Model.listener {
    private ContractLoginUser.View view;
    private ContractLoginUser.Model model;


    public LoginPresenter(ContractLoginUser.View view){
        this.view =view;
        model = new LoginModel();
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
            view.onFailureLoginView("Invalid email or password");
        }
    }
    @Override
    public void onFinished(User user) {
        view.onSuccessLoginView(user);
    }

    @Override
    public void onFailure(String err) {
        view.onFailureLoginView(err);
    }
}
