package pe.edu.upeu.clase02.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumno implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idalumno;
	private String codigo;
	private String nombre;
	private String apellido_pat;
	private String apellido_mat;
	
	
	public int getIdalumno() {
		return idalumno;
	}
	public void setIdalumno(int idalumno) {
		this.idalumno = idalumno;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido_pat() {
		return apellido_pat;
	}
	public void setApellido_pat(String apellido_pat) {
		this.apellido_pat = apellido_pat;
	}
	public String getApellido_mat() {
		return apellido_mat;
	}
	public void setApellido_mat(String apellido_mat) {
		this.apellido_mat = apellido_mat;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	
	
	
	
	
}
