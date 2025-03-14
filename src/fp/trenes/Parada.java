package fp.trenes;

import java.time.LocalTime;

import fp.utiles.Checkers;

public record Parada(
		String estacion,
		LocalTime horaLlegada,
		LocalTime horaSalida) {
	public Parada{
		Checkers.check("La hora de salida de la primera estación "
				+ "debe ser anterior a la hora de llegada de la última estación.",
				horaSalida==null && horaLlegada!=null ||
				horaLlegada==null && horaSalida!=null ||
				horaSalida!=null && horaLlegada!=null &&
				horaSalida.isBefore(horaLlegada));
	}
	

}
