package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class LogTest {

	private static final String NOMBRE_ARCHIVADOR = "Archivador Nombre Test";
	private static final String NOMBRE_ARCHIVADOR_DELEGADO = "Archivador Delegado Nombre Test";
	private static final int ESPACIO_ARCHIVADOR = 100;
	private static final int ESPACIO_ARCHIVADOR_INSUFICIENTE = -1;
	private static final String NOMBRE_MENSAJE = "Mensaje Nombre Test";
	private static final String CONTENIDO_MENSAJE = "Contenido de Mensaje Test";
	private static final String LOG_MESSAGE = "Mensaxe de log";

	private final PrintStream standardOutput = System.out;
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	/**
	 * Test del metodo obtenerDelegado, de la clase Log.
	 * 
	 * Se asigna un delegado al decorado, de la clase Delegado
	 */
	@Test()
	public void establecerObtenerDelegadoTest() {

		DecoradorArchivador da = new Log(
				new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DELEGADO, ESPACIO_ARCHIVADOR_INSUFICIENTE)));

		ArchivadorSimple as = new ArchivadorSimple(NOMBRE_ARCHIVADOR_DELEGADO, ESPACIO_ARCHIVADOR);
		da.establecerDelegado(as);

		assertEquals(as, da.obtenerDelegado());
	}

	/**
	 * Test del metodo obtenerDelegado, de la clase Log.
	 * 
	 * Se asigna un delegado al decorado, de la clase ArchivadorSimple
	 */
	@Test()
	public void establecerObtenerDelegadoArchivadorSimpleTest() {

		DecoradorArchivador da = new Log(new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR_INSUFICIENTE));
		ArchivadorSimple as = new ArchivadorSimple(NOMBRE_ARCHIVADOR_DELEGADO, ESPACIO_ARCHIVADOR);

		da.establecerDelegado(as);

		assertEquals(null, da.obtenerDelegado());
	}

	/**
	 * Test del metodo almacenarCorreo, de la clase Log.
	 * 
	 * Añade un mail correctamente al Archivador decorado vacio asignado al Log, e
	 * imprimiendo un mensaje de log.
	 */
	@Test
	public void almacenarCorreoTest() {

		DecoradorArchivador da = new Log(new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR));
		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		assertTrue(da.almacenarCorreo(c));

	}

	/**
	 * Test del metodo almacenarCorreo, de la clase Log.
	 * 
	 * Comprueba que el mensaje de log impreso es el esperado
	 */
	@Test
	public void almacenarCorreoTestMensajeLogCorrecto() {

		System.setOut(new PrintStream(outputStream));

		DecoradorArchivador da = new Log(new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR));
		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		da.almacenarCorreo(c);

		assertEquals(LOG_MESSAGE, outputStream.toString().trim());

		System.setOut(standardOutput);
	}

	/**
	 * Test del metodo almacenarCorreo, de la clase Log.
	 * 
	 * Añade un mail correctamente al Archivador decorado vacio asignado al Log, e
	 * imprimiendo un mensaje de log.
	 */
	@Test
	public void almacenarCorreoSinEspacioTest() {

		DecoradorArchivador da = new Log(new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR_INSUFICIENTE));
		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		assertFalse(da.almacenarCorreo(c));

	}

	/**
	 * Test del metodo obtenerNombre, de la clase Log.
	 * 
	 * Comprueba que el nombre obtenido es el esperado.
	 */
	@Test
	public void obtenerNombreTest() {

		DecoradorArchivador da = new Log(new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR));
		assertEquals(NOMBRE_ARCHIVADOR, da.obtenerNombre());
	}

	/**
	 * Test del metodo obtenerEspacioTotal method, de la clase Log.
	 * 
	 * Obtiene el espacio total del Archivador decorado asignado a Log
	 */
	@Test
	public void obtenerEspacioTotalDecoradoTest() {

		DecoradorArchivador da = new Log(new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR));

		assertEquals(ESPACIO_ARCHIVADOR, da.obtenerEspacioTotal());
	}

	/**
	 * Test del metodo obtenerEspacioTotal, de la clase Log.
	 * 
	 * Obtiene el espacio total del Archivador asignado a Log
	 */
	@Test
	public void obtenerEspacioTotalDespuesDeAlmacenarTest() {

		DecoradorArchivador da = new Log(new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR));
		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		da.almacenarCorreo(c);

		assertEquals(ESPACIO_ARCHIVADOR, da.obtenerEspacioTotal());
	}

	/**
	 * Test del metodo obtenerEspacioDisponible, de la clase Log.
	 * 
	 * Obtiene el espacio disponible del Archivador asignado a Log
	 */
	@Test
	public void obtenerEspacioDisponibleTest() {

		DecoradorArchivador da = new Log(new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR));

		assertEquals(ESPACIO_ARCHIVADOR, da.obtenerEspacioDisponible());
	}

	/**
	 * Test del metodo obtenerEspacioDisponible, de la clase Log.
	 * 
	 * Obtiene el espacio disponible del Archivador asignado a Log despues de añadir
	 * un correo correctamente
	 */
	@Test
	public void obtenerEspacioDisponibleDespuesDeAlmacenarTest() {

		DecoradorArchivador da = new Log(new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR));
		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		da.almacenarCorreo(c);

		assertEquals(ESPACIO_ARCHIVADOR - c.obtenerTamaño(), da.obtenerEspacioDisponible());
	}

	/**
	 * Test del metodo obtenerEspacioDisponible, de la clase Log.
	 * 
	 * Obtiene el espacio disponible del Archivador asignado a Log despues de añadir
	 * un correo sin tener el espacio necesario
	 */
	@Test
	public void obtenerEspacioDisponibleDecoradoSinEspacioTest() {

		DecoradorArchivador da = new Log(new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR_INSUFICIENTE));
		da.establecerDelegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DELEGADO, ESPACIO_ARCHIVADOR));

		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		da.almacenarCorreo(c);

		assertEquals(ESPACIO_ARCHIVADOR_INSUFICIENTE, da.obtenerEspacioDisponible());
	}
}
