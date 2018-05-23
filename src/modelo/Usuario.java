package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Usuario {
	private int id;
	private String nombre;
	private String apellido;
	private int edad;
	private String dni;
	private Date fechaNacimineto;
	private String password;

	public static final String USUARIO = "usuario";

	public Usuario() {

	}

	public static String getUsuario() {
		return USUARIO;
	}

	Usuario(int id, String nombre, String apellido, int edad, String dni, Date fechaNacimiento, String password) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.dni = dni;
		this.fechaNacimineto = fechaNacimiento;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechaNacimineto() {
		return fechaNacimineto;
	}

	public void setFechaNacimineto(Date fechaNacimineto) {
		this.fechaNacimineto = fechaNacimineto;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", dni=" + dni
				+ ", fechaNacimineto=" + fechaNacimineto + ", password=" + password + "]";
	}

}