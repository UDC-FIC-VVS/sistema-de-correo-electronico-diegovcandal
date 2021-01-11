package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.TestSetupGeneral;

@RunWith(JUnitQuickcheck.class)
public class LogTestPBT extends TestSetupGeneral {

	private static final String NOMBRE_ARCHIVADOR_DEFECTO = "Archivador Nombre Test";

	private final PrintStream standardOutput = System.out;
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	@Before
	public void setUpBeforeEach() {
		System.setOut(new PrintStream(outputStream));
	}

	@After
	public void tearDownAfterEach() {
		System.setOut(standardOutput);
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerDelegado, de la clase
	 * Log.
	 * 
	 * <p>
	 * 
	 * Se asigna un delegado al decorado, de la clase Delegado
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
	 * @param randomContenido       contenido del mensaje
	 * @param randomEspacio         espacio del Archivador
	 * @param randomEspacioDelegado espacio del Archivador Delegado
	 */
	@Property
	public void establecerObtenerDelegadoTest(int randomEspacio, int randomEspacioDelegado) {

		DecoradorArchivador da = new Log(new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio)));

		ArchivadorSimple as = new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacioDelegado);
		da.establecerDelegado(as);

		assertEquals(as, da.obtenerDelegado());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerDelegado, de la clase
	 * Log.
	 * 
	 * <p>
	 * 
	 * Se asigna un delegado al decorado, de la clase ArchivadorSimple
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos influyan en la prueba.
	 * <li>Categoria, numeros naturales, generados de forma aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomEspacio         espacio del Archivador
	 * @param randomEspacioDelegado espacio del Archivador Delegado
	 */
	@Property
	public void establecerObtenerDelegadoArchivadorSimpleTest(int randomEspacio, int randomEspacioDelegado) {

		DecoradorArchivador da = new Log(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio));
		ArchivadorSimple as = new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacioDelegado);

		da.establecerDelegado(as);

		assertEquals(null, da.obtenerDelegado());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerNombre, de la clase
	 * Log.
	 * 
	 * <p>
	 * 
	 * Comprueba que el nombre obtenido es el esperado.
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

		DecoradorArchivador da = new Log(new ArchivadorSimple(randomNombre, randomEspacio));
		assertEquals(randomNombre, da.obtenerNombre());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerEspacioTotal, de la
	 * clase Log.
	 * 
	 * <p>
	 * 
	 * Obtiene el espacio total del Archivador decorado asignado a Log
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos influyan en la prueba.
	 * <li>Categoria, numeros naturales, generados de forma aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomEspacio espacio del Archivador
	 */
	@Property
	public void obtenerEspacioTotalDecoradoTest(int randomEspacio) {

		DecoradorArchivador da = new Log(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio));

		assertEquals(randomEspacio, da.obtenerEspacioTotal());

	}

	/**
	 * Test unitario basado en propiedades, del método obtenerEspacioDisponible, de
	 * la clase Log.
	 * 
	 * <p>
	 * 
	 * Obtiene el espacio disponible del Archivador asignado a Log
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos influyan en la prueba.
	 * <li>Categoria, numeros naturales, generados de forma aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomEspacio espacio del Archivador
	 */
	@Property
	public void obtenerEspacioDisponibleTest(int randomEspacio) {

		DecoradorArchivador da = new Log(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio));

		assertEquals(randomEspacio, da.obtenerEspacioDisponible());

	}

}
