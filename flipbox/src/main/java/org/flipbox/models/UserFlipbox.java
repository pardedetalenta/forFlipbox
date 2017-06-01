package org.flipbox.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="User")
public class UserFlipbox{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "id")
	private Integer id; 
	@Column (name = "nama_user")
	private String  nama_user;
	@Column (name = "jk_user")
	private String  jk_user;
	@Column (name = "mobile_ph")
	private String  mobile_ph;
	@Column (name = "email")
	private String  email;
	@Column (name = "username")
	private String  username;
	@Column (name = "password")
	private String  password;
	@Column (name = "alamat")
	private String  alamat;
	
	public UserFlipbox(){
	}
	
	
	public UserFlipbox(Integer id, String nama_user, String jk_user, String mobile_ph, String email, String username,
			String password, String alamat) {
		super();
		this.id = id;
		this.nama_user = nama_user;
		this.jk_user = jk_user;
		this.mobile_ph = mobile_ph;
		this.email = email;
		this.username = username;
		this.password = password;
		this.alamat = alamat;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNama_user() {
		return nama_user;
	}
	public void setNama_user(String nama_user) {
		this.nama_user = nama_user;
	}
	public String getJk_user() {
		return jk_user;
	}
	public void setJk_user(String jk_user) {
		this.jk_user = jk_user;
	}
	public String getMobile_ph() {
		return mobile_ph;
	}
	public void setMobile_ph(String mobile_ph) {
		this.mobile_ph = mobile_ph;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	
	
	
}
