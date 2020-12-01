package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Vector;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class CabeceraTest {

	private static final String NOMBRE_MENSAJE = "Mensaje Nombre Test";
	private static final String CONTENIDO_MENSAJE = "Contenido de Mensaje Test";
	private static final String NOMBRE_CARPETA = "Carpeta Nombre Test";
	private static final String NOMBRE_CABECERA = "Cabecera Nombre Test";
	private static final String CONTENIDO_CABECERA = "Contenido de la Cabecera Test";

	private static final String BUSCAR_MENSAJE_DISTINTO = "Otro Contenido de Mensaje Test";

	public static final Integer ICONO_MENSAJE = 2;
	public static final Integer ICONO_NUEVO_MENSAJE = 3;

	/**
	 * Test del método obtenerTamaño, de la clase Cabecera.
	 * 
	 * Obtiene la suma del tamaño del mensaje y la cabecera
	 */
	@Test()
	public void obtenerTamañoTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		Cabecera c = new Cabecera(m, NOMBRE_CABECERA, CONTENIDO_CABECERA);

		assertEquals(m.obtenerTamaño() + NOMBRE_CABECERA.length() + CONTENIDO_CABECERA.length(), c.obtenerTamaño());
	}

	/**
	 * Test del método obtenerTamaño, de la clase Cabecera.
	 * 
	 * Para mas de una cabecera obtiene la suma del tamaño del mensaje y las
	 * cabeceras
	 */
	@Test()
	public void obtenerTamañoCabeceraMultipleTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		Cabecera c = new Cabecera(m, NOMBRE_CABECERA, CONTENIDO_CABECERA);
		Cabecera c2 = new Cabecera(c, NOMBRE_CABECERA, CONTENIDO_CABECERA);

		assertEquals(c.obtenerTamaño() + NOMBRE_CABECERA.length() + CONTENIDO_CABECERA.length(), c2.obtenerTamaño());
	}

	/**
	 * Test del método obtenerVisualizacion, de la clase Cabecera.
	 * 
	 * Obtiene la visualizacion del mensaje y el archivo la cabecera
	 */
	@Test()
	public void obtenerVisualizacionTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		Cabecera c = new Cabecera(m, NOMBRE_CABECERA, CONTENIDO_CABECERA);

		assertEquals(NOMBRE_CABECERA + ": " + CONTENIDO_CABECERA + "\n" + m.obtenerVisualizacion(),
				c.obtenerVisualizacion());
	}

	/**
	 * Test del método obtenerTamaño, de la clase Cabecera.
	 * 
	 * Para mas de una cabecera obtiene la visualizacion del mensaje y el archivo
	 * las cabeceras
	 */
	@Test()
	public void obtenerVisualizacionCabeceraMultipleTest() {

		Cabecera c = crearCabecera();
		Cabecera c2 = new Cabecera(c, NOMBRE_CABECERA, CONTENIDO_CABECERA);

		assertEquals(NOMBRE_CABECERA + ": " + CONTENIDO_CABECERA + "\n" + c.obtenerVisualizacion(),
				c2.obtenerVisualizacion());
	}

	/**
	 * Test del método establecerLeido, de la clase Cabecera.
	 * 
	 * Obtiene los mensajes no leidos
	 */
	@Test()
	public void obtenerNoLeidosTest() {

		Cabecera c = crearCabecera();

		assertEquals(1, c.obtenerNoLeidos());
	}

	/**
	 * Test del método establecerLeido, de la clase Cabecera.
	 * 
	 * Establece el mensaje como leido
	 */
	@Test()
	public void establecerLeidoTrueTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		Cabecera c = new Cabecera(m, NOMBRE_CABECERA, CONTENIDO_CABECERA);

		c.establecerLeido(true);

		assertEquals(0, m.obtenerNoLeidos());
	}

	/**
	 * Test del método establecerLeido, de la clase Cabecera.
	 * 
	 * Establece el mensaje como no leido
	 */
	@Test()
	public void establecerNoLeidoTrueTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		Cabecera c = new Cabecera(m, NOMBRE_CABECERA, CONTENIDO_CABECERA);

		c.establecerLeido(false);

		assertEquals(1, m.obtenerNoLeidos());
	}

	/**
	 * Test del método obtenerIcono, de la clase Cabecera.
	 * 
	 * Obtiene el icono si el mensaje esta marcado como leido
	 */
	@Test()
	public void obtenerIconoLeidoTest() {

		Cabecera c = crearCabecera();

		c.establecerLeido(true);

		assertEquals(ICONO_MENSAJE, c.obtenerIcono());
	}

	/**
	 * Test del método obtenerIcono, de la clase Cabecera.
	 * 
	 * Obtiene el icono si el mensaje esta marcado como no leido
	 */
	@Test()
	public void obtenerIconoNoLeidoTest() {

		Cabecera c = crearCabecera();

		assertEquals(ICONO_NUEVO_MENSAJE, c.obtenerIcono());
	}

	/**
	 * Test del método obtenerPreVisualizacion, de la clase Cabecera.
	 * 
	 * Obtiene la previsualizacion del mensaje
	 */
	@Test()
	public void obtenerPreVisualizacionTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		Cabecera c = new Cabecera(m, NOMBRE_CABECERA, CONTENIDO_CABECERA);

		assertEquals(m.obtenerPreVisualizacion(), c.obtenerPreVisualizacion());
	}

	/**
	 * Test del método obtenerRuta, de la clase Cabecera.
	 * 
	 * Obtiene la ruta del mensaje
	 */
	@Test()
	public void obtenerRutaTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		Cabecera c = new Cabecera(m, NOMBRE_CABECERA, CONTENIDO_CABECERA);

		assertEquals(m.obtenerRuta(), c.obtenerRuta());
	}

	/**
	 * Test del método obtenerRuta, de la clase Cabecera.
	 * 
	 * Obtiene la ruta del mensaje con un padre asignado
	 */
	@Test()
	public void obtenerRutaConPadreTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		Cabecera cab = new Cabecera(m, NOMBRE_CABECERA, CONTENIDO_CABECERA);

		Carpeta c = new Carpeta(NOMBRE_CARPETA);
		cab.establecerPadre(c);

		assertEquals(NOMBRE_CARPETA + " > " + m.obtenerPreVisualizacion(), cab.obtenerRuta());
	}

	/**
	 * Test del método explorar, de la clase Cabecera.
	 * 
	 * Se devuelve una excepcion
	 */
	@Test(expected = OperacionInvalida.class)
	public void explorarTest() throws OperacionInvalida {

		Cabecera c = crearCabecera();

		c.explorar();
	}

	/**
	 * Test del método añadir, de la clase Cabecera.
	 * 
	 * Se devuelve una excepcion
	 */
	@Test(expected = OperacionInvalida.class)
	public void añadirTest() throws OperacionInvalida {

		Cabecera c = crearCabecera();

		c.añadir(new Mensaje(new Texto(CONTENIDO_MENSAJE, CONTENIDO_MENSAJE)));
	}

	/**
	 * Test del método eliminar, de la clase Cabecera.
	 * 
	 * Se devuelve una excepcion
	 */
	@Test(expected = OperacionInvalida.class)
	public void eliminarTest() throws OperacionInvalida {

		Cabecera c = crearCabecera();

		c.eliminar(new Mensaje(new Texto(CONTENIDO_MENSAJE, CONTENIDO_MENSAJE)));
	}

	/**
	 * Test del método obtenerHijo, de la clase Cabecera.
	 * 
	 * Se devuelve una excepcion
	 */
	@Test(expected = OperacionInvalida.class)
	public void obtenerHijoTest() throws OperacionInvalida {

		Cabecera c = crearCabecera();

		c.obtenerHijo(0);
	}

	/**
	 * Test del método buscar, de la clase Cabecera.
	 * 
	 * Devuelve el mensaje si este hace match con el mismo
	 */
	@Test()
	public void buscarTest() {

		Cabecera c = crearCabecera();

		Collection<Cabecera> collection = new Vector<Cabecera>();
		collection.add(c);

		assertEquals(collection, c.buscar(CONTENIDO_MENSAJE));
	}

	/**
	 * Test del método buscar, de la clase Cabecera.
	 * 
	 * Devuelve el mensaje si este hace match con una cadena Adjunto
	 */
	@Test()
	public void buscarCadenaVaciaTest() {

		Cabecera c = crearCabecera();

		Collection<Cabecera> collection = new Vector<Cabecera>();
		collection.add(c);

		assertEquals(collection, c.buscar(""));
	}

	/**
	 * Test del método buscar, de la clase Cabecera.
	 * 
	 * Comprueba que no se devuelve el mensaje si se introduce una cadena que no
	 * pertence al mensaje
	 */
	@Test()
	public void buscarCadenaDistintaTest() {

		Cabecera c = crearCabecera();

		assertEquals(new Vector<Cabecera>(), c.buscar(BUSCAR_MENSAJE_DISTINTO));
	}

	/**
	 * Test del método establecerPadre, de la clase Cabecera.
	 * 
	 * Establece el padre del mensaje
	 */
	@Test()
	public void establecerObtenerPadreTest() throws OperacionInvalida {

		Cabecera cab = crearCabecera();

		Carpeta c = new Carpeta(NOMBRE_CARPETA);
		cab.establecerPadre(c);

		assertEquals(c, cab.obtenerPadre());
	}

	/**
	 * Test del método obtenerPadre, de la clase Cabecera.
	 * 
	 * Obtiene el padre si no ha sido establecido anteriormente
	 */
	@Test()
	public void obtenerPadreNullTest() throws OperacionInvalida {

		Cabecera c = crearCabecera();

		assertEquals(null, c.obtenerPadre());
	}

	private Cabecera crearCabecera() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		return new Cabecera(m, NOMBRE_CABECERA, CONTENIDO_CABECERA);
	}
}
