package fp.trenes;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public class TrayectoTrenImpl implements TrayectoTren {
	private String codigoTren;
	private String nombre;
	private TipoTren tipo;
	private List <String> estaciones;
	private List <LocalTime> horasSalida;
	private List <LocalTime> horasLlegada;

	@Override
	public String getCodigoTren() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoTren getTipo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getEstaciones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LocalTime> getHorasSalida() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LocalTime> getHorasLlegada() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalTime getHoraSalida() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalTime getHoraLlegada() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Duration getDuracionTrayecto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalTime getHoraSalida(String estacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalTime getHoraLlegada(String estacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void anadirEstacionIntermedia(int posicion, String estacion, LocalTime horaLlegada, LocalTime horaSalida) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarEstacionIntermedia(String estacion) {
		// TODO Auto-generated method stub

	}

}
