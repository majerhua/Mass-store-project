package com.app.proyectomas.local.Usuario;

import android.content.Context;
import android.content.SharedPreferences;

import com.app.proyectomas.entity.Usuario;

public class SessionManagement {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String SHARED_PREF_NAME = "session";
    String SESSION_KEY = "session_user";
    String NAME_USER = "name";
    String ROL_USER = "rol";


    public SessionManagement(Context contex){
        sharedPreferences = contex.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveSession(Usuario user){
        int id = user.getId();
        String name = user.getUsername();
        int rol = user.getRol();
        editor.putInt(SESSION_KEY,id).commit();
        editor.putString(NAME_USER,name).commit();
        editor.putInt(ROL_USER,rol).commit();
    }

    public int getSession(){
        return sharedPreferences.getInt(SESSION_KEY,-1);
    }

    public int getRol(){
        return sharedPreferences.getInt(ROL_USER,-1);
    }

    public String getNameUseSession(){
        return sharedPreferences.getString(NAME_USER,"usuario");
    }

    public int getIdUserSession(){
        return sharedPreferences.getInt(SESSION_KEY,0);
    }

    public void removeSession(){
        editor.putInt(SESSION_KEY,-1).commit();
    }

}
