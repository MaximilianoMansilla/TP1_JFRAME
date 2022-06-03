package negocio;


import bancoUTN.CajaAhorro;
import bancoUTN.CtaCte;
import bancoUTN.Usuario;


public class Negocio {
	public Usuario[] arrUsu = new Usuario[10];


	
	public void transferencia(Usuario usu, Double saldo, int op) {
		if(op==0) {
			usu.getCtaCte().setSaldo((saldo + usu.getCtaCte().getSaldo()));
			usu.getCajaAhorro().setSaldo((usu.getCajaAhorro().getSaldo()- saldo));
		}else {	
			usu.getCajaAhorro().setSaldo((saldo + usu.getCajaAhorro().getSaldo()));
			usu.getCtaCte().setSaldo((usu.getCtaCte().getSaldo()- saldo));
		}

	}


	public Boolean registrarUsuarios(String name, String pwd, int i) {						
			Usuario usu = new Usuario();
			CtaCte cc = new CtaCte();
			CajaAhorro ca = new CajaAhorro();
			usu.setCajaAhorro(ca);
			usu.setCtaCte(cc);
			if(validaNombre(name)) {
				return false;
			}else {
				usu.setNombre(name);
				usu.setPassword(pwd);
				arrUsu[i] = usu;
				return true;
			}
			
			
			
	}
	
	public Usuario buscaUsuario(String name ) {
		Usuario usu = new Usuario();
		usu=null;
		for(int i=0;i<10;i++) {
			if(arrUsu[i]!=null) {
				if(arrUsu[i].getNombre().equals(name)) {
					usu = arrUsu[i];	
					break;
				}
			}
		}
		return usu;
		
	}
	
	
	public void limpiarArray() {
		for(int i=0; i<10;i++) {
			arrUsu[i]=null;
		}
	}
	
	
	public Boolean validaNombre(String name) {
		Boolean rta=false;
		
		for(int i=0;i<10;i++) {
			if(arrUsu[i]!=null) {
				if(arrUsu[i].getNombre().equals(name)) {
					rta=true;
					break;
				}
			}
		}
		
		return rta;
	}


	public Boolean validaPwd(String pwd, Usuario usu) {
		
		if(usu.getPassword().equals(pwd))return true;
		else return false;
	}
	
}//CLASE
