package com.example.pruebamvp.login;

import com.example.pruebamvp.beans.User;

public interface ContractUser {

    interface Presenter{
        void login(User user);
    }

    interface View{
        void successLogin(User user);
        void failureLogin(String err);
    }

    interface Model{

        interface loginListener{
            void onFinished(User user);
            void onFailure(String err);
        }

        void API(User user, loginListener listener);

    }

}
