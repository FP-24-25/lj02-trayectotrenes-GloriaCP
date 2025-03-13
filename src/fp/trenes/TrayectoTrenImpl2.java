package fp.trenes;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fp.utiles.Checkers;
import fp.utiles.Validators;

public class TrayectoTrenImpl2 implements TrayectoTren {
	
	//Atributos
	private String codigoTren;
	private String nombre;
	private TipoTren tipo;
	private List<Parada> paradas;
	
	//Constructor(es)
	public TrayectoTrenImpl2(
			String codigoTren,
			String nombre,
			TipoTren tipo,
			String estacionOrigen,
			String estacionFinal,
			LocalTime horaSalida,
			LocalTime horaLlegada
			) {
		Checkers.check("Codigo no válido", 
				codigoTren.length()==5 && Validators.sonDigitos(codigoTren));
		this.codigoTren=codigoTren;
		this.nombre=nombre;
		this.tipo=tipo;
		Parada estacionInicial= new Parada(estacionOrigen, horaSalida, null);
		Parada estacionDestino= new Parada (estacionFinal,null,horaLlegada);
		
		
		paradas=new ArrayList<Parada> ();
		paradas.add(estacionInicial);
		paradas.add(estacionDestino);	
	}
	
	//TODO checkers

	
	//Getters
	public String getCodigoTren() {
		return codigoTren;
	}


	public String getNombre() {
		return nombre;
	}

	
	public TipoTren getTipo() {
		return tipo;
	}

	public List<String> getEstaciones() {
		List<String> estaciones= new ArrayList<>();
		for(Parada p: paradas) {
			estaciones.add(p.estacion());
		}
		return estaciones;
	
	}

	
	public List<LocalTime> getHorasSalida() {
		List<LocalTime> hS= new ArrayList<>();
		for(Parada p: paradas) {
			hS.add(p.horaSalida());
		}
		return hS;
	}

	
	public List<LocalTime> getHorasLlegada() {
		List<LocalTime> hL= new ArrayList<>();
		for(Parada p: paradas) {
			hL.add(p.horaSalida());
		}
		return hL;
		
		
	}

	//Getters de las derivadas
	public LocalTime getHoraSalida() {
		return horasSalida.get(0);
		//return horasSalida.getFirst();
	}

	
	public LocalTime getHoraLlegada() {
		return horasLlegada.get(horasLlegada.size()-1);
		//return horasLlegada.getLast();
	}

	public Duration getDuracionTrayecto() {
		Duration res= Duration.between(getHoraSalida(), getHoraLlegada());
		return res;
	}
	
	public LocalTime getHoraSalida(String estacion) {
		LocalTime res= null;
		int pos=estaciones.indexOf(estacion);
		if(pos>=0) {
			res=horasSalida.get(pos);
		}
		return res;
	}
	
	public LocalTime getHoraLlegada(String estacion) {
		LocalTime res=null;
		int pos=estaciones.indexOf(estacion);
		if(pos>=0) {
			res=horasLlegada.get(pos);
		}
		return res;
	}
	
	//toString
	private String formateaHora(LocalTime hora) {
	    if (hora != null) {
	        return hora.format(DateTimeFormatter.ofPattern("HH:mm"));
	    } else {
	        return "  ";
	    }
	}
	

	public String toString() {
		String res=getNombre()+"-"+getTipo()+"("+getCodigoTren()+")\n";
		for(int i=0; i<estaciones.size();i++) {
			res= "\t"+res+estaciones.get(i)+"\t"
					+formateaHora(horasLlegada.get(i))+"\t"
					+formateaHora(horasSalida.get(i))+"\n";
		}
		return res;
		
	}

	
	
	//Otras operaciones
		//TODO Otras operaciones TRENES

	public void anadirEstacionIntermedia(int posicion, String estacion, LocalTime horaLlegada, LocalTime horaSalida) {
		Checkers.check("La posicion intermedia no esta entre 1 y n", posicion>0 && posicion<estaciones.size());
		Checkers.check("La hora de salida no es posterior a la de llegada", horaSalida.isAfter(horaLlegada));
		Checkers.check("Hora llegada no es posterior a hora salida estacion anterior", null);

	}

	
	public void eliminarEstacionIntermedia(String estacion) {
		

	}


	//Criterio de ordenación.
	public int compareTo(TrayectoTren tt) {
		int res= getNombre().compareTo(tt.getNombre());
		if (res==0) {
			res=getHoraSalida().compareTo(tt.getHoraSalida());
		}
		return res;
	}
	
	//Criterio de igualdad y hashCode().
	public boolean equals(Object obj) {
		boolean res=false;
		if(obj instanceof TrayectoTrenImpl2) {
			TrayectoTrenImpl2 t1= (TrayectoTrenImpl2) obj;
			res= getNombre().equals(t1.getNombre()) && 
					getHoraSalida().equals(t1.getHoraSalida())
					&& getCodigoTren().equals(t1.getCodigoTren());
			
		}
		return res;
	}
	
	public int hashCode() {
		return getNombre().hashCode() + 31* getHoraSalida().hashCode()
				+31*31* getCodigoTren().hashCode();
	}

}
