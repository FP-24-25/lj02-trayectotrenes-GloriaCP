package fp.trenes;

import java.util.List;

import fp.utiles.Checkers;
import fp.utiles.Validators;

public class TrayectoTrenImpl3 {
	
	//Atributos
	private String codigoTren;
	private String nombre;
	private TipoTren tipo;
	List<Parada> paradas;
	
	//Constructor
	public TrayectoTrenImpl3(
			String codigoTren,
			String nombre,
			TipoTren tipo,
			List<Parada> paradas) {
		Checkers.check("Codigo no válido", 
				codigoTren.length()==5 && Validators.sonDigitos(codigoTren));
		this.codigoTren=codigoTren;
		this.nombre=nombre;
		this.tipo=tipo;
		this.paradas=paradas;
		
	}
}
