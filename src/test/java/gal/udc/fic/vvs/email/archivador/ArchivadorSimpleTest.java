package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class ArchivadorSimpleTest {

	private static final String NOMBRE_ARCHIVADOR = "Archivador Nombre Test";
	private static final int ESPACIO_ARCHIVADOR = 100;
	private static final int ESPACIO_ARCHIVADOR_INSUFICIENTE = -1;
	private static final String NOMBRE_MENSAJE = "Mensaje Nombre Test";
	private static final String CONTENIDO_MENSAJE = "Contenido de Mensaje Test";

	/**
	 * Test del metodo obtenerNombre, de la clase ArchivadorSimple.
	 * 
	 * Comprueba que el nombre obtenido es el esperado.
	 */
	@Test
	public void obtenerNombreTest() {

		ArchivadorSimple as = new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR);
		assertEquals(NOMBRE_ARCHIVADOR, as.obtenerNombre());
	}

	/**
	 * Test del metodo almacenarCorreo, de la clase ArchivadorSimple.
	 * 
	 * Añade un mail correctamente a un ArchivadorSimple vacio
	 */
	@Test
	public void almacenarCorreoTest() {

		ArchivadorSimple as = new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR);
		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		assertTrue(as.almacenarCorreo(c));
	}

	/**
	 * Test del metodo almacenarCorreo, de la clase ArchivadorSimple.
	 * 
	 * Añade un mail a un ArchivadorSimple sin el suficiente espacio
	 */
	@Test
	public void almacenarCorreoSinEspacioTest() {

		ArchivadorSimple as = new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR_INSUFICIENTE);
		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		assertFalse(as.almacenarCorreo(c));
	}

	/**
	 * Test del metodo obtenerEspacioTotal, de la clase ArchivadorSimple.
	 * 
	 * Obtiene el espacio total del ArchivadorSimple
	 */
	@Test
	public void obtenerEspacioTotalTest() {

		ArchivadorSimple as = new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR);

		assertEquals(ESPACIO_ARCHIVADOR, as.obtenerEspacioTotal());
	}

	/**
	 * Test del metodo obtenerEspacioTotal, de la clase ArchivadorSimple.
	 * 
	 * Obtiene el espacio total del ArchivadorSimple despues de añadir un correo
	 */
	@Test
	public void obtenerEspacioTotalDespuesDeAlmacenarTest() {

		ArchivadorSimple as = new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR);
		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		as.almacenarCorreo(c);

		assertEquals(ESPACIO_ARCHIVADOR, as.obtenerEspacioTotal());
	}

	/**
	 * Test del metodo obtenerEspacioDisponible, de la clase ArchivadorSimple.
	 * 
	 * Obtiene el espacio disponible del ArchivadorSimple
	 */
	@Test
	public void obtenerEspacioDisponibleTest() {

		ArchivadorSimple as = new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR);

		assertEquals(ESPACIO_ARCHIVADOR, as.obtenerEspacioDisponible());
	}

	/**
	 * Test del metodo obtenerEspacioDisponible, de la clase ArchivadorSimple.
	 * 
	 * Obtiene el espacio disponible del ArchivadorSimple despues de añadir un
	 * correo correctamente
	 */
	@Test
	public void obtenerEspacioDisponibleDespuesDeAlmacenarTest() {

		ArchivadorSimple as = new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR);
		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		as.almacenarCorreo(c);

		assertEquals(ESPACIO_ARCHIVADOR - c.obtenerTamaño(), as.obtenerEspacioDisponible());
	}

	/**
	 * Test del metodo obtenerEspacioDisponible, de la clase ArchivadorSimple.
	 * 
	 * Obtiene el espacio disponible del ArchivadorSimple despues de añadir un
	 * correo sin tener el espacio necesario
	 */
	@Test
	public void obtenerEspacioDisponibleSinEspacioTest() {

		ArchivadorSimple as = new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR_INSUFICIENTE);
		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		as.almacenarCorreo(c);

		assertEquals(ESPACIO_ARCHIVADOR_INSUFICIENTE, as.obtenerEspacioDisponible());
	}

	/**
	 * Test del metodo obtenerDelegado, de la clase ArchivadorSimple.
	 * 
	 * Obtiene el Archivador delegado asignado al ArchivadorSimple, que sera un null
	 * para esta implementacion de Archivador
	 */
	@Test
	public void obtenerDelegadoTest() {

		ArchivadorSimple as = new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR_INSUFICIENTE);

		assertEquals(null, as.obtenerDelegado());
	}

}
