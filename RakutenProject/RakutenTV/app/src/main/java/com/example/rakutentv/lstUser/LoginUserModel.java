package com.example.rakutentv.lstUser;

import android.os.AsyncTask;
import android.util.Log;

import com.example.rakutentv.beans.User;
import com.example.rakutentv.utils.Post;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;

public class LoginUserModel implements LoginUserContract.Model {

private ArrayList<User> lstUsers;
private OnLoginUserListener onLoginUserListener;

    @Override
    public void getUserService(final OnLoginUserListener onLoginUserListener,
                               User usuario) {
        this.onLoginUserListener = onLoginUserListener;
        HashMap<String,String> param = new HashMap<>();
        param.put("ACTION", "USUARIO.LOGIN");
        param.put("EMAIL", usuario.getEmail());
        param.put("PASSWORD", usuario.getPassword());
        TareaSegundoPlano miTarea = new TareaSegundoPlano(param);
        //Cambiar URL según IP
        miTarea.execute("http://192.168.104.74:8080/RakutenTVAndroid/Controller"); //Cambiar URL Según IP
    }

    /*Clase ASYNKTASK*/
// HILO ASYNCTASK
class TareaSegundoPlano extends AsyncTask<String, Integer, Boolean> {
    private HashMap<String, String> parametros = null;

    public TareaSegundoPlano( HashMap<String, String> parametros) {
        super();
        this.parametros = parametros;
    }

    @Override
    protected Boolean  doInBackground(String... params) {
        String url_select = params[0];
        try {
            Post post = new Post();
            JSONArray result = post.getServerDataPost(parametros,url_select);
            if (result != null) {
                Log.d("log_tag", "Response: " + result.toString());
                lstUsers = User.getArrayListFromJSon(result);
            } else {
                Log.e("log_tag", "Result is null");
            }
        } catch (Exception e) {
            Log.e("log_tag", "Error in http connection " + e.toString());
        }
        return true;
    }

    @Override
    protected void onPostExecute(Boolean resp) {
        try {
            if(resp){
                onLoginUserListener.onFinished(lstUsers.get(0));
            }
        }catch (Exception e) {
            onLoginUserListener.onFailure("Fallo:Listar Usuario");
        }
    }
}

}
