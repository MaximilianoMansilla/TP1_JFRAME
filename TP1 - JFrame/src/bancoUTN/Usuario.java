package bancoUTN;

public class Usuario {
	public String nombre;
	public String password;	
	public CtaCte ctaCte;
	public CajaAhorro cajaAhorro;
	
	public CtaCte getCtaCte() {
		return ctaCte;
	}
	public void setCtaCte(CtaCte ctaCte) {
		this.ctaCte = ctaCte;
	}
	public CajaAhorro getCajaAhorro() {
		return cajaAhorro;
	}
	public void setCajaAhorro(CajaAhorro cajaAhorro) {
		this.cajaAhorro = cajaAhorro;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
}
