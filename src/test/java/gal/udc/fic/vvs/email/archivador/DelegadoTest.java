package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class DelegadoTest {

	private static final String NOMBRE_ARCHIVADOR = "Archivador Nombre Test";
	private static final String NOMBRE_ARCHIVADOR_DELEGADO = "Archivador Delegado Nombre Test";
	private static final int ESPACIO_ARCHIVADOR = 100;
	private static final int ESPACIO_ARCHIVADOR_DELEGADO = 500;
	private static final int ESPACIO_ARCHIVADOR_INSUFICIENTE = -1;
	private static final String NOMBRE_MENSAJE = "Mensaje Nombre Test";
	private static final String CONTENIDO_MENSAJE = "Contenido de Mensaje Test";

	/**
	 * Test del metodo almacenarCorreo, de la clase Delegado.
	 * 
	 * Añade un mail correctamente al Archivador decorado vacio asignado al Delegado
	 */
	@Test
	public void almacenarCorreoTest() {

		DecoradorArchivador da = new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR));
		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		assertTrue(da.almacenarCorreo(c));
	}

	/**
	 * Test del metodo almacenarCorreo, de la clase Delegado.
	 * 
	 * Añade un mail al Archivador decorado sin el espacio suficiente asignado al
	 * Delegado, sin un Archivador asignado como delegado
	 */
	@Test(expected = NullPointerException.class)
	public void almacenarCorreoSinEspacioTest() {

		DecoradorArchivador da = new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR_INSUFICIENTE));
		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		da.almacenarCorreo(c);
	}

	/**
	 * Test del metodo almacenarCorreo, de la clase Delegado.
	 * 
	 * Añade un mail al Archivador decorado sin el espacio suficiente asignado al
	 * Delegado, con un delegado asignado
	 */
	@Test()
	public void almacenarCorreoSinEspacioConDelegadoTest() {

		DecoradorArchivador da = new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR_INSUFICIENTE));
		da.establecerDelegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DELEGADO, ESPACIO_ARCHIVADOR));

		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		assertTrue(da.almacenarCorreo(c));
	}

	/**
	 * Test del metodo obtenerDelegado, de la clase Delegado.
	 * 
	 * Obtiene el delegado asignado previamente
	 */
	@Test()
	public void establecerObtenerDelegadoTest() {

		DecoradorArchivador da = new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR_INSUFICIENTE));
		ArchivadorSimple as = new ArchivadorSimple(NOMBRE_ARCHIVADOR_DELEGADO, ESPACIO_ARCHIVADOR);

		da.establecerDelegado(as);

		assertEquals(as, da.obtenerDelegado());
	}

	/**
	 * Test del metodo obtenerNombre, de la clase Delegado.
	 * 
	 * Comprueba que el nombre obtenido es el esperado.
	 */
	@Test
	public void obtenerNombreTest() {

		DecoradorArchivador da = new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR));
		assertEquals(NOMBRE_ARCHIVADOR, da.obtenerNombre());
	}

	/**
	 * Test del metodo obtenerEspacioTotal method, de la clase Delegado.
	 * 
	 * Obtiene el espacio total del Archivador decorado asignado a Delegado
	 */
	@Test
	public void obtenerEspacioTotalDecoradoTest() {

		DecoradorArchivador da = new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR));

		assertEquals(ESPACIO_ARCHIVADOR, da.obtenerEspacioTotal());
	}

	/**
	 * Test del metodo obtenerEspacioTotal, de la clase Delegado.
	 * 
	 * Obtiene el espacio total del Archivador decorado asignado a Delegado
	 */
	@Test
	public void obtenerEspacioTotalDecoradoDespuesDeAlmacenarTest() {

		DecoradorArchivador da = new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR));
		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		da.almacenarCorreo(c);

		assertEquals(ESPACIO_ARCHIVADOR, da.obtenerEspacioTotal());
	}

	/**
	 * Test del metodo obtenerEspacioTotal method, de la clase Delegado.
	 * 
	 * Obtiene el espacio total del Archivador delegado asignado a Delegado
	 */
	@Test
	public void obtenerEspacioTotalDelegadoTest() {

		DecoradorArchivador da = new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR));
		da.establecerDelegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DELEGADO, ESPACIO_ARCHIVADOR_DELEGADO));

		assertEquals(ESPACIO_ARCHIVADOR_DELEGADO, da.obtenerDelegado().obtenerEspacioTotal());
	}

	/**
	 * Test del metodo obtenerEspacioTotal, de la clase Delegado.
	 * 
	 * Obtiene el espacio total del Archivador delegado asignado a Delegado
	 */
	@Test
	public void obtenerEspacioTotalDelegadoDespuesDeAlmacenarTest() {

		DecoradorArchivador da = new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR));
		da.establecerDelegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DELEGADO, ESPACIO_ARCHIVADOR_DELEGADO));

		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		da.almacenarCorreo(c);

		assertEquals(ESPACIO_ARCHIVADOR_DELEGADO, da.obtenerDelegado().obtenerEspacioTotal());
	}

	/**
	 * Test del metodo obtenerEspacioDisponible, de la clase Delegado.
	 * 
	 * Obtiene el espacio disponible del Archivador decorado asignado a Delegado
	 */
	@Test
	public void obtenerEspacioDisponibleDecoradoTest() {

		DecoradorArchivador da = new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR));

		assertEquals(ESPACIO_ARCHIVADOR, da.obtenerEspacioDisponible());
	}

	/**
	 * Test del metodo obtenerEspacioDisponible, de la clase Delegado.
	 * 
	 * Obtiene el espacio disponible del Archivador decorado asignado a Delegado
	 * despues de añadir un correo correctamente
	 */
	@Test
	public void obtenerEspacioDisponibleDecoradoDespuesDeAlmacenarTest() {

		DecoradorArchivador da = new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR));
		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		da.almacenarCorreo(c);

		assertEquals(ESPACIO_ARCHIVADOR - c.obtenerTamaño(), da.obtenerEspacioDisponible());
	}

	/**
	 * Test del metodo obtenerEspacioDisponible, de la clase Delegado.
	 * 
	 * Obtiene el espacio disponible del Archivador decorado asignado a Delegado
	 * despues de añadir un correo sin tener el espacio necesario
	 */
	@Test
	public void obtenerEspacioDisponibleDecoradoSinEspacioTest() {

		DecoradorArchivador da = new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR_INSUFICIENTE));
		da.establecerDelegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DELEGADO, ESPACIO_ARCHIVADOR));

		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		da.almacenarCorreo(c);

		assertEquals(ESPACIO_ARCHIVADOR_INSUFICIENTE, da.obtenerEspacioDisponible());
	}

	/**
	 * Test del metodo obtenerEspacioDisponible, de la clase Delegado.
	 * 
	 * Obtiene el espacio disponible del Archivador delegado asignado a Delegado
	 */
	@Test
	public void obtenerEspacioDisponibleDelegadoTest() {

		DecoradorArchivador da = new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR));
		da.establecerDelegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DELEGADO, ESPACIO_ARCHIVADOR_DELEGADO));

		assertEquals(ESPACIO_ARCHIVADOR_DELEGADO, da.obtenerDelegado().obtenerEspacioDisponible());
	}

	/**
	 * Test del metodo obtenerEspacioDisponible, de la clase Delegado.
	 * 
	 * Obtiene el espacio disponible del Archivador delegado asignado a Delegado
	 * despues de añadir un correo correctamente al archivador decorado
	 */
	@Test
	public void obtenerEspacioDisponibleDelegadoDespuesDeAlmacenarTest() {

		DecoradorArchivador da = new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR));
		da.establecerDelegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DELEGADO, ESPACIO_ARCHIVADOR_DELEGADO));

		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		da.almacenarCorreo(c);

		assertEquals(ESPACIO_ARCHIVADOR_DELEGADO, da.obtenerDelegado().obtenerEspacioDisponible());
	}

	/**
	 * Test del metodo obtenerEspacioDisponible, de la clase Delegado.
	 * 
	 * Obtiene el espacio disponible del Archivador delegado asignado a Delegado
	 * despues de añadir un correo al archivador decorado sin tener el espacio
	 * necesario
	 */
	@Test
	public void obtenerEspacioDisponibleDelegadoSinEspacioTest() {

		DecoradorArchivador da = new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR_INSUFICIENTE));
		da.establecerDelegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DELEGADO, ESPACIO_ARCHIVADOR_DELEGADO));

		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		da.almacenarCorreo(c);

		assertEquals(ESPACIO_ARCHIVADOR_DELEGADO - c.obtenerTamaño(), da.obtenerDelegado().obtenerEspacioDisponible());
	}

}
