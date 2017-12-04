package beans;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bbdd.ConnectionManager;

public class Cliente {
	static Logger logger = LogManager.getLogger(Cliente.class);
	private String nombre;
	private String dni;
	private String apellidos;
	private String contraseña;
	private String fechaNacimiento;
	private String sexo;
	private String direccion;
	private String telefono;
	private List<Account> accounts;
	public String getApellidos() {
		logger.info("Apellidos: " + this.apellidos);
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
		logger.info("Apellidos: " + apellidos);
	}
	public String getContraseña() {
		logger.info("Contraseña: " + this.contraseña);
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		logger.info("Contraseña: " + contraseña);
		this.contraseña = contraseña;
	}
	public String getFechaNacimiento() {
		logger.info("Fecha de nacimiento: " + this.fechaNacimiento);
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		logger.info("Fecha de nacimiento: " + fechaNacimiento);
	}
	public String getSexo() {
		logger.info("Sexo: " + this.sexo);
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
		logger.info("Sexo: " + sexo);
	}
	public String getDireccion() {
		logger.info("Direccion: " + this.direccion);
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
		logger.info("Direccion: " + direccion);
	}
	public String getTelefono() {
		logger.info("Telefono: " + this.telefono);
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
		logger.info("Telefono: " + telefono);
	}
	private boolean isValid;
	
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public String getNombre() {
		logger.info("Nombre: " + this.nombre);
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
		logger.info("Nombre: " + nombre);
	}
	public String getDni() {
		logger.info("DNI: " + this.dni);
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
		logger.info("DNI: " + dni);
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	} 
	
	
}
