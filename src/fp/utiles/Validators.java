package fp.utiles;

public class Validators {

	public static Boolean sonDigitos(String cadena) {
		//para todo
		Boolean res=true;
		//for clásico
		//inicializacion;condicion;incremento
		for(int i=0;i<cadena.length();i++) {
			//cojo el caracter que esta en la posicion i
			Character c=cadena.charAt(i);
			if(!Character.isDigit(c)) {
				res=false;
				break;
			}
			
			
		}
		
		return res;
	}

	public static boolean sonLetras(String substring) {
		Boolean res=true;
		for(int i=0;i<substring.length();i++) {
			Character c=substring.charAt(i);
			if(!Character.isLetter(c)) {
				res=false;
				break;
				
			}
			
		}
		return res;
	}
	

}
