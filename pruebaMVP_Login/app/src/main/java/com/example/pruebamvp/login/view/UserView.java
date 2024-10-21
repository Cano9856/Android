package com.example.pruebamvp.login.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pruebamvp.R;
import com.example.pruebamvp.beans.User;
import com.example.pruebamvp.login.ContractUser;
import com.example.pruebamvp.login.presenter.UserPresenter;

public class UserView extends AppCompatActivity implements ContractUser.View {
    private EditText edtEmail, edtPassword;
    private Button btnLogin;
    private UserPresenter userPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        userPresenter = new UserPresenter(this);
        initComponents();
    }

    private void initComponents(){
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword= findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User(edtEmail.getText().toString(), edtPassword.getText().toString());
                userPresenter.login(user);
            }
        });
    }


    @Override
    public void successLogin(User user) {
        Toast.makeText(this, "Login exitoso: "+user.getEmail(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failureLogin(String err) {
        Toast.makeText(this, "Login fallido: "+ err, Toast.LENGTH_SHORT).show();
    }
}
