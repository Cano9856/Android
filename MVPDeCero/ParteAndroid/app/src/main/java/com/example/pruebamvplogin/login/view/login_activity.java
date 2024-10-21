package com.example.pruebamvplogin.login.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pruebamvplogin.R;
import com.example.pruebamvplogin.beans.User;
import com.example.pruebamvplogin.login.ContractLoginUser;
import com.example.pruebamvplogin.login.presenter.LoginPresenter;

public class login_activity extends AppCompatActivity implements ContractLoginUser.View {
    private EditText edtEmail, edtPass;
    private Button btnLogin;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter = new LoginPresenter(this);
        initComponents();
    }



    private void initComponents(){
        edtEmail= findViewById(R.id.edtEmail);
        edtPass= findViewById(R.id.edtPass);
        btnLogin = findViewById(R.id.button);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user= new User(edtEmail.getText().toString(), edtPass.getText().toString());
                presenter.login(user);
                System.out.println(user.getEmail()+"\n"+user.getPassword());
            }
        });
    }

    @Override
    public void onSuccessLoginView(User user) {
        Toast.makeText(this, "Login exitoso: "+ user.getEmail(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailureLoginView(String err) {
        Toast.makeText(this, "Login fallido "+ err, Toast.LENGTH_SHORT).show();
    }
}