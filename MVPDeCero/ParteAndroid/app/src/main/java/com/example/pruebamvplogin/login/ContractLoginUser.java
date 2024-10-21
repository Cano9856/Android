package com.example.pruebamvplogin.login;

import com.example.pruebamvplogin.beans.User;

public interface ContractLoginUser {

    interface Model{
        void API(User user, listener listener);
        interface listener{
            void onFinished(User user);
            void onFailure(String err);

        }
    }
    interface Presenter{
        void login(User user);

    }
    interface View{
        void onSuccessLoginView(User user);
        void onFailureLoginView(String err);

    }



}
