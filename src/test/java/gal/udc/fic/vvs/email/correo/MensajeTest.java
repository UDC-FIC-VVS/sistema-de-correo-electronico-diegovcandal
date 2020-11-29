package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Vector;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class MensajeTest {

	private static final String NOMBRE_MENSAJE = "Mensaje Nombre Test";
	private static final String CONTENIDO_MENSAJE = "Contenido de Mensaje Test";
	private static final String BUSCAR_MENSAJE_DISTINTO = "Otro Contenido de Mensaje Test";
	private static final String NOMBRE_CARPETA = "Carpeta Nombre Test";

	private final static int TAMAÑO_PREVISUALIZACION = 32;
	public static final Integer ICONO_MENSAJE = 2;
	public static final Integer ICONO_NUEVO_MENSAJE = 3;
	public static final Integer NUM_MENSAJES = 10;

	private static final String CONTENIDO_MENSAJE_PRE_VISUALIZACION = CONTENIDO_MENSAJE.substring(0,
			Math.min(CONTENIDO_MENSAJE.length(), TAMAÑO_PREVISUALIZACION)) + "...";

	/**
	 * Test del método establecerLeido, de la clase Mensaje.
	 * 
	 * Establece el mensaje como leido
	 */
	@Test()
	public void establecerObtenerLeidosTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		m.establecerLeido(true);

		assertEquals(0, m.obtenerNoLeidos());
	}

	/**
	 * Test del método establecerLeido, de la clase Mensaje.
	 * 
	 * Establece el mensaje como no leido
	 */
	@Test()
	public void establecerObtenerNoLeidosTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		m.establecerLeido(false);

		assertEquals(1, m.obtenerNoLeidos());
	}

	/**
	 * Test del método obtenerNoLeidos, de la clase Mensaje.
	 * 
	 * Obtiene el estado inicial del mensaje
	 */
	@Test()
	public void obtenerNoLeidosEstadoIncialTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		assertEquals(1, m.obtenerNoLeidos());
	}

	/**
	 * Test del método obtenerTamaño, de la clase Mensaje.
	 * 
	 * Obtiene el tamaño del contenido del mensaje
	 */
	@Test()
	public void obtenerTamañoTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		assertEquals(CONTENIDO_MENSAJE.length(), m.obtenerTamaño());
	}

	/**
	 * Test del método obtenerIcono, de la clase Mensaje.
	 * 
	 * Obtiene el icono si el mensaje esta marcado como leido
	 */
	@Test()
	public void obtenerIconoLeidoTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		m.establecerLeido(true);

		assertEquals(ICONO_MENSAJE, m.obtenerIcono());
	}

	/**
	 * Test del método obtenerIcono, de la clase Mensaje.
	 * 
	 * Obtiene el icono si el mensaje esta marcado como no leido
	 */
	@Test()
	public void obtenerIconoNoLeidoTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		assertEquals(ICONO_NUEVO_MENSAJE, m.obtenerIcono());
	}

	/**
	 * Test del método obtenerVisualizacion, de la clase Mensaje.
	 * 
	 * Obtiene la visualizacion general del mensaje
	 */
	@Test()
	public void obtenerVisualizacionTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		assertEquals(CONTENIDO_MENSAJE, m.obtenerVisualizacion());
	}

	/**
	 * Test del método obtenerVisualizacion, de la clase Mensaje.
	 * 
	 * Obtiene la visualizacion del mensaje cortandola si supera el tamaño limite
	 */
	@Test()
	public void obtenerPreVisualizacionTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		assertEquals(CONTENIDO_MENSAJE_PRE_VISUALIZACION, m.obtenerPreVisualizacion());
	}

	/**
	 * Test del método buscar, de la clase Mensaje.
	 * 
	 * Devuelve el mensaje si este hace match con el mismo
	 */
	@Test()
	public void buscarTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		Collection<Mensaje> collection = new Vector<Mensaje>();
		collection.add(m);

		assertEquals(collection, m.buscar(CONTENIDO_MENSAJE));
	}

	/**
	 * Test del método buscar, de la clase Mensaje.
	 * 
	 * Devuelve el mensaje si este hace match con una cadena vacia
	 */
	@Test()
	public void buscarCadenaVaciaTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		Collection<Mensaje> collection = new Vector<Mensaje>();
		collection.add(m);

		assertEquals(collection, m.buscar(""));
	}

	/**
	 * Test del método buscar, de la clase Mensaje.
	 * 
	 * Comprueba que no se devuelve el mensaje si se introduce una cadena que no
	 * pertence al mensaje
	 */
	@Test()
	public void buscarCadenaDistintaTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		assertEquals(new Vector<Mensaje>(), m.buscar(BUSCAR_MENSAJE_DISTINTO));
	}

	/**
	 * Test del método establecerPadre, de la clase Mensaje.
	 * 
	 * Establece el padre del Mensaje
	 */
	@Test()
	public void establecerObtenerPadreTest() throws OperacionInvalida {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		Carpeta c = new Carpeta(NOMBRE_CARPETA);
		m.establecerPadre(c);

		assertEquals(c, m.obtenerPadre());
	}

	/**
	 * Test del método obtenerPadre, de la clase Mensaje.
	 * 
	 * Obtiene el padre si no ha sido establecido anteriormente
	 */
	@Test()
	public void obtenerPadreNullTest() throws OperacionInvalida {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		assertEquals(null, m.obtenerPadre());
	}

	/**
	 * Test del método obtenerRuta, de la clase Mensaje.
	 * 
	 * Obtiene la ruta del Mensaje sin un padre asignado
	 */
	@Test()
	public void obtenerRutaTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		assertEquals(CONTENIDO_MENSAJE_PRE_VISUALIZACION, m.obtenerRuta());
	}

	/**
	 * Test del método obtenerRuta, de la clase Mensaje.
	 * 
	 * Obtiene la ruta del Mensaje con un padre asignado
	 */
	@Test()
	public void obtenerRutaConPadreTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		Carpeta c = new Carpeta(NOMBRE_CARPETA);
		m.establecerPadre(c);

		assertEquals(NOMBRE_CARPETA + " > " + CONTENIDO_MENSAJE_PRE_VISUALIZACION, m.obtenerRuta());
	}

	/**
	 * Test del método explorar, de la clase Mensaje.
	 * 
	 * Se devuelve una excepcion
	 */
	@Test(expected = OperacionInvalida.class)
	public void explorarTest() throws OperacionInvalida {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		m.explorar();
	}

	/**
	 * Test del método añadir, de la clase Mensaje.
	 * 
	 * Se devuelve una excepcion
	 */
	@Test(expected = OperacionInvalida.class)
	public void añadirTest() throws OperacionInvalida {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		m.añadir(new Mensaje(new Texto(CONTENIDO_MENSAJE, CONTENIDO_MENSAJE)));
	}

	/**
	 * Test del método eliminar, de la clase Mensaje.
	 * 
	 * Se devuelve una excepcion
	 */
	@Test(expected = OperacionInvalida.class)
	public void eliminarTest() throws OperacionInvalida {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		m.eliminar(new Mensaje(new Texto(CONTENIDO_MENSAJE, CONTENIDO_MENSAJE)));
	}

	/**
	 * Test del método obtenerHijo, de la clase Mensaje.
	 * 
	 * Se devuelve una excepcion
	 */
	@Test(expected = OperacionInvalida.class)
	public void obtenerHijoTest() throws OperacionInvalida {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		m.obtenerHijo(0);
	}

}
