package com.example.rakutentv.adapter;

import android.view.View;

import com.example.rakutentv.beans.User;

import java.util.ArrayList;

public class AdapterUser {

    private ArrayList<User> lstUsers;
    private View.OnClickListener listener;

    public AdapterUser(ArrayList<User> lstUsers) {
        this.lstUsers = lstUsers;
    }
}
