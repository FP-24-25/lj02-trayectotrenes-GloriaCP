package fp.trenes;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrayectoTrenImpl implements TrayectoTren,Comparable<TrayectoTren> {
	
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
		this.codigoTren=codigoTren;
		this.nombre=nombre;
		this.tipo=tipo;
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
		return estaciones;
	}

	
	public List<LocalTime> getHorasSalida() {
		return horasSalida;
	}

	
	public List<LocalTime> getHorasLlegada() {
		return horasLlegada;
	}

	//Getters de las derivadas
	public LocalTime getHoraSalida() {
		return horasSalida.get(0);
	}

	
	public LocalTime getHoraLlegada() {
		return horasLlegada.get(horasLlegada.size()-1);
	}

	public Duration getDuracionTrayecto() {
		Duration res= Duration.between(getHoraSalida(), getHoraLlegada());
		return res;
	}
	
	//toString
	//TODO preguntar to String
//	public String toString() {
//		return getNombre()+"-"+getTipo()+"("+getCodigoTren()+")"+System.lineSeparator()+
//				getEstaciones().get(0)+"	"+getHoraSalida()
//	}

	
	
	//Otras operaciones
		//TODO Otras operaciones TRENES
	public LocalTime getHoraSalida(String estacion) {
		return null;
	}

	
	public LocalTime getHoraLlegada(String estacion) {
		return null;
	}

	
	public void anadirEstacionIntermedia(int posicion, String estacion, LocalTime horaLlegada, LocalTime horaSalida) {
		

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
