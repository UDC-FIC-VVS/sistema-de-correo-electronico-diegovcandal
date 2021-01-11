package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.TestSetupGeneral;

@RunWith(JUnitQuickcheck.class)
public class ArchivadorSimpleTestPBT extends TestSetupGeneral {

	private static final String NOMBRE_ARCHIVADOR_DEFECTO = "Archivador Nombre Test";

	/**
	 * Test unitario basado en propiedades, del método obtenerNombre, de la clase
	 * ArchivadorSimple.
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
	 * clase ArchivadorSimple.
	 * 
	 * <p>
	 * 
	 * Obtiene el espacio total de un ArchivadorSimple cualquiera
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
	 * @param randomEspacio espacio del Archivador
	 */
	@Property
	public void obtenerEspacioTotalTest(int randomEspacio) {

		ArchivadorSimple as = new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio);

		assertEquals(randomEspacio, as.obtenerEspacioTotal());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerEspacioDisponible, de
	 * la clase ArchivadorSimple.
	 * 
	 * <p>
	 * 
	 * Obtiene el espacio disponible de un ArchivadorSimple cualquiera
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
	public void obtenerEspacioDisponibleDespuesDeAlmacenarTest(int randomEspacio) {

		ArchivadorSimple as = new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio);

		assertEquals(randomEspacio, as.obtenerEspacioDisponible());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerDelegado, de la clase
	 * ArchivadorSimple.
	 * 
	 * <p>
	 * 
	 * Obtiene el Archivador delegado asignado al ArchivadorSimple, que para
	 * cualquier archivador sera un null para esta implementacion de Archivador
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
	public void obtenerDelegadoTest(String randomNombre, int randomEspacio) {

		ArchivadorSimple as = new ArchivadorSimple(randomNombre, randomEspacio);

		assertEquals(null, as.obtenerDelegado());
	}

}
