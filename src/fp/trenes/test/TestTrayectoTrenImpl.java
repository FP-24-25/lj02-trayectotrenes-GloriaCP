package fp.trenes.test;

import java.time.LocalTime;

import fp.trenes.TipoTren;
import fp.trenes.TrayectoTrenImpl;

public class TestTrayectoTrenImpl {

	public static void main(String[] args) {
		try {
		TrayectoTrenImpl tt = new TrayectoTrenImpl(
				"02471", "Sevilla-Madrid", 
				TipoTren.AV_CITY,
				"SEVILLA-SANTA JUSTA", "MADRID-PUERTA DE ATOCHA",
				LocalTime.of(7, 0), LocalTime.of(10, 2));
		//System.out.println(tt);
		
		tt.anadirEstacionIntermedia(1, "PUERTOLLANO", LocalTime.of(8, 40), LocalTime.of(8, 41));
		tt.anadirEstacionIntermedia(1, "CORDOBA", LocalTime.of(7, 45), LocalTime.of(7, 50));
		System.out.println(tt);
		
		}catch(IllegalArgumentException e) {
			System.out.println("Capturada Excepcion:: "+e.getMessage());
		}
	}
		
		

}
