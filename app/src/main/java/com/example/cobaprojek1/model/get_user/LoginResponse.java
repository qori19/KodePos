package com.example.cobaprojek1.model.get_user;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Qori Fatkhul Kurniyadi on 15/05/2019
 * Nim : 124170036
 * github : github.com/qori19
 */

public class LoginResponse{
	@SerializedName("name")
	String nama;
	@SerializedName("email")
	String email;

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
