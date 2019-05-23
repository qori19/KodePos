package com.example.cobaprojek1.model.postlogin;

/**
 * Created by Qori Fatkhul Kurniyadi on 15/05/2019
 * Nim : 124170036
 * github : github.com/qori19
 */

public class PostLoginResponse{
	private boolean auth;
	private String token;

	public void setAuth(boolean auth){
		this.auth = auth;
	}

	public boolean isAuth(){
		return auth;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	@Override
 	public String toString(){
		return 
			"PostLoginResponse{" + 
			"auth = '" + auth + '\'' + 
			",token = '" + token + '\'' + 
			"}";
		}
}
