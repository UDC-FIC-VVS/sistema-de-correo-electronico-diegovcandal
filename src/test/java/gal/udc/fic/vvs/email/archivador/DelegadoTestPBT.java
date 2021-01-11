package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.TestSetupGeneral;

@RunWith(JUnitQuickcheck.class)
public class DelegadoTestPBT extends TestSetupGeneral {

	private static final String NOMBRE_ARCHIVADOR_DEFECTO = "Archivador Nombre Test";
	private static final int ESPACIO_ARCHIVADOR_DEFECTO = 100;

	/**
	 * Test unitario basado en propiedades, del método obtenerDelegado, de la clase
	 * Delegado.
	 * 
	 * <p>
	 * 
	 * Obtiene el delegado asignado previamente
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos no influyan en la prueba.
	 * <li>Categoria, strings de cualquier longitud no nulos, generados de forma
	 * aleatoria.
	 * <li>Categoria, numeros naturales, generados de forma aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomNombre          nombre del Archivador
	 * @param randomEspacioDelegado espacio del Archivador Delegado
	 */
	@Property
	public void establecerObtenerDelegadoTest(String randomNombre, int randomEspacioDelegado) {

		DecoradorArchivador da = new Delegado(
				new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, ESPACIO_ARCHIVADOR_DEFECTO));
		ArchivadorSimple as = new ArchivadorSimple(randomNombre, randomEspacioDelegado);
		da.establecerDelegado(as);

		assertEquals(as, da.obtenerDelegado());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerNombre, de la clase
	 * Delegado.
	 * 
	 * <p>
	 * 
	 * Comprueba que el nombre obtenido es el esperado para cualquier tipo de
	 * archivador.
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Categoria, strings de cualquier longitud no nulos, generados de forma
	 * aleatoria.
	 * <li>Categoria, numeros naturales, generados de forma aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomNombre  nombre del Archivador
	 * @param randomEspacio espacio del Archivador
	 */
	@Property
	public void obtenerNombreTest(String randomNombre, int randomEspacio) {

		ArchivadorSimple as = new ArchivadorSimple(randomNombre, randomEspacio);
		assertEquals(randomNombre, as.obtenerNombre());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerEspacioTotal, de la
	 * clase Delegado.
	 * 
	 * <p>
	 * 
	 * Obtiene el espacio total del Archivador delegado asignado a Delegado
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos no influyan en la prueba.
	 * <li>Categoria, strings de cualquier longitud no nulos, generados de forma
	 * aleatoria.
	 * <li>Categoria, numeros naturales, generados de forma aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomEspacio         espacio del Archivador
	 * @param randomEspacioDelegado espacio del Archivador Delegado
	 */
	@Property
	public void obtenerEspacioTotalDelegadoTest(int randomEspacio, int randomEspacioDelegado) {

		DecoradorArchivador da = new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio));
		da.establecerDelegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacioDelegado));

		assertEquals(randomEspacioDelegado, da.obtenerDelegado().obtenerEspacioTotal());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerEspacioDisponible, de
	 * la clase Delegado.
	 * 
	 * <p>
	 * 
	 * Obtiene el espacio disponible del Archivador decorado asignado a Delegado
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos no influyan en la prueba.
	 * <li>Categoria, numeros naturales, generados de forma aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomEspacio espacio del Archivador
	 */
	@Property
	public void obtenerEspacioDisponibleDecoradoTest(int randomEspacio) {

		DecoradorArchivador da = new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio));

		assertEquals(randomEspacio, da.obtenerEspacioDisponible());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerEspacioDisponible, de
	 * la clase Delegado.
	 * 
	 * <p>
	 * 
	 * Obtiene el espacio disponible del Archivador delegado asignado a Delegado
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos no influyan en la prueba.
	 * <li>Categoria, numeros naturales, generados de forma aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomEspacio         espacio del Archivador
	 * @param randomEspacioDelegado espacio del Archivador Delegado
	 */
	@Property
	public void obtenerEspacioDisponibleDelegadoTest(int randomEspacio, int randomEspacioDelegado) {

		DecoradorArchivador da = new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio));
		da.establecerDelegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacioDelegado));

		assertEquals(randomEspacioDelegado, da.obtenerDelegado().obtenerEspacioDisponible());
	}

}
