package fp.trenes;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fp.utiles.Checkers;
import fp.utiles.Validators;

public class TrayectoTrenImpl implements TrayectoTren {
	
	//Atributos
	private String codigoTren;
	private String nombre;
	private TipoTren tipo;
	private List <String> estaciones;
	private List <LocalTime> horasSalida;
	private List <LocalTime> horasLlegada;
	
	//Constructor(es)
	public TrayectoTrenImpl(
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
		Checkers.checkNoNull(horaSalida, horaLlegada);
		Checkers.check("La hora de salida de la primera"
				+ "estacion debe ser anterior a la hora de llegada de la"
				+ "última estación.", horaSalida.isBefore(horaLlegada));
		this.estaciones=new ArrayList<>();
		Collections.addAll(this.estaciones, estacionOrigen,estacionFinal);
		this.horasSalida= new ArrayList<>();
		Collections.addAll(this.horasSalida,horaSalida,null);
		this.horasLlegada= new ArrayList<>();
		Collections.addAll(this.horasLlegada,null,horaLlegada);
		
	}
	
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
		return new ArrayList<String> (estaciones);
	}

	
	public List<LocalTime> getHorasSalida() {
		return new ArrayList<LocalTime>(horasSalida);
	}

	
	public List<LocalTime> getHorasLlegada() {
		return new ArrayList<LocalTime>(horasLlegada);
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
			res= res+estaciones.get(i)+"\t"
					+formateaHora(horasLlegada.get(i))+"\t"
					+formateaHora(horasSalida.get(i))+"\n";
		}
		return res;
		
	}

	
	
	//Otras operaciones

	public void anadirEstacionIntermedia(int posicion, String estacion, LocalTime horaLlegada, LocalTime horaSalida) {
		Checkers.check("La posicion intermedia no esta entre 1 y n", posicion>0 && posicion<estaciones.size());
		Checkers.check("La hora de salida no es posterior a la de llegada", horaSalida.isAfter(horaLlegada));
		Checkers.check("Hora llegada tiene que ser posterior a hora salida de la estacion anterior", horaLlegada.isAfter(horasSalida.get(posicion-1)) );
		Checkers.check("Hora Salida es anterior a la hora de llegada de la siguiente estación", horaSalida.isBefore(horasLlegada.get(posicion)));
		estaciones.add(posicion,estacion);
		horasLlegada.add(posicion,horaLlegada);
		horasSalida.add(posicion,horaSalida);

	}

	
	public void eliminarEstacionIntermedia(String estacion) {
		Checkers.check("No puede ser la primera estacion", !(estacion.equals(estaciones.getFirst())));
		Checkers.check("No puede ser la última estación", !(estacion.equals(estaciones.getLast())));
		Checkers.check("La estacion no está", estaciones.contains(estacion));
		estaciones.remove(estacion);
		

	}


	//Criterio de ordenación.
	public int compareTo(TrayectoTren tt) {
		int res= getNombre().compareTo(tt.getNombre());
		if (res==0) {
			res=getHoraSalida().compareTo(tt.getHoraSalida());
			if(res==0) {
				res=getCodigoTren().compareTo(tt.getCodigoTren());
			}
		}
		return res;
	}
	
	//Criterio de igualdad y hashCode().
	public boolean equals(Object obj) {
		boolean res=false;
		if(obj instanceof TrayectoTrenImpl) {
			TrayectoTrenImpl t1= (TrayectoTrenImpl) obj;
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
