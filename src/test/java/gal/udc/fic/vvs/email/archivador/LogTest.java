package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gal.udc.fic.vvs.email.TestSetupGeneral;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class LogTest extends TestSetupGeneral {

	private static final String NOMBRE_ARCHIVADOR = "Archivador Nombre Test";
	private static final String NOMBRE_MENSAJE = "Mensaje Nombre Test";
	private static final String CONTENIDO_MENSAJE = "Contenido de Mensaje Test";

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
	 * Test unitario, del método almacenarCorreo, de la clase Log.
	 * 
	 * <p>
	 * 
	 * Añade un mail correctamente al Archivador decorado vacio asignado al Log, e
	 * imprimiendo un mensaje de log y con el espacio justo para aceptarlo
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores frontera, el tamaño del mensaje es el maximo para poder ser
	 * almacenado
	 * </ul>
	 * </ul>
	 */
	@Test
	public void almacenarCorreoEspacioExactoTest() {

		DecoradorArchivador da = new Log(new ArchivadorSimple(NOMBRE_ARCHIVADOR, CONTENIDO_MENSAJE.length() + 1));
		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		assertTrue(da.almacenarCorreo(c));
	}

	/**
	 * Test unitario, del método almacenarCorreo, de la clase Log.
	 * 
	 * <p>
	 * 
	 * Añade un mail al Archivador decorado sin el espacio suficiente asignado al
	 * Log
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y negativo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores frontera, el tamaño del mensaje es el minimo para no poder
	 * almacenarse
	 * </ul>
	 * </ul>
	 */
	@Test(expected = NullPointerException.class)
	public void almacenarCorreoSinEspacioTest() {

		DecoradorArchivador da = new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR, CONTENIDO_MENSAJE.length()));
		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		da.almacenarCorreo(c);
	}

}
