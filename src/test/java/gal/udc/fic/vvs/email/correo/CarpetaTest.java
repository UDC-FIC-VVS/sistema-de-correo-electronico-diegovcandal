package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class CarpetaTest {

	private static final String NOMBRE_CARPETA = "Carpeta Nombre Test";
	private static final String NOMBRE_MENSAJE = "Mensaje Nombre Test";
	private static final String CONTENIDO_MENSAJE = "Contenido de Mensaje Test";
	private static final String NOMBRE_CARPETA_PADRE = NOMBRE_CARPETA + " Padre";
	public static final Integer ICONO_CARPETA = 1;
	public static final int NUM_MENSAJES = 10;

	/**
	 * Test del método obtenerIcono, de la clase Carpeta.
	 * 
	 * Obtiene el icono asociado a la clase
	 */
	@Test()
	public void obtenerIcono() {

		Correo c = crearCarpeta();

		assertEquals(ICONO_CARPETA, c.obtenerIcono());
	}

	/**
	 * Test del método establecerLeido, de la clase Carpeta.
	 * 
	 * Establece todos los correos de la carpeta como leidos
	 */
	@Test()
	public void establecerLeidoTest() {

		Carpeta c = crearCarpeta();

		c.establecerLeido(true);

		assertEquals(0, c.obtenerNoLeidos());
	}

	/**
	 * Test del método establecerLeido, de la clase Carpeta.
	 * 
	 * Establece todos los correos de la carpeta como no leidos
	 */
	@Test()
	public void establecerNoLeidoTest() {

		Carpeta c = crearCarpeta();

		c.establecerLeido(false);

		assertEquals(NUM_MENSAJES, c.obtenerNoLeidos());
	}

	/**
	 * Test del método establecerLeido, de la clase Carpeta.
	 * 
	 * Establece todos los correos de la carpeta como leidos con un hijo que es otra
	 * carpeta
	 */
	@Test()
	public void establecerLeidoCarpetaAnidadaTest() throws OperacionInvalida {

		Carpeta c = crearCarpeta();
		c.añadir(crearCarpeta());

		c.establecerLeido(true);

		assertEquals(0, c.obtenerNoLeidos());
	}

	/**
	 * Test del método establecerLeido, de la clase Carpeta.
	 * 
	 * Establece todos los correos de la carpeta como no leidos con un hijo que es
	 * otra carpeta
	 */
	@Test()
	public void establecerNoLeidoCarpetaAnidadaTest() throws OperacionInvalida {

		Carpeta c = crearCarpeta();
		c.añadir(crearCarpeta());

		c.establecerLeido(false);

		assertEquals(NUM_MENSAJES * 2, c.obtenerNoLeidos());
	}

	/**
	 * Test del método obtenerNoLeidos, de la clase Carpeta.
	 * 
	 * Obtiene la cantidad de correos no leidos dentro de la carpeta
	 */
	@Test()
	public void obtenerNoLeidosTest() {

		Carpeta c = crearCarpeta();

		assertEquals(NUM_MENSAJES, c.obtenerNoLeidos());
	}

	/**
	 * Test del método obtenerNoLeidos, de la clase Carpeta.
	 * 
	 * Establece todos los correos de la carpeta como leidos con un hijo que es otra
	 * carpeta
	 */
	@Test()
	public void obtenerNoLeidosCarpetaAnidadaTest() throws OperacionInvalida {

		Carpeta c = crearCarpeta();
		c.añadir(crearCarpeta());

		assertEquals(NUM_MENSAJES * 2, c.obtenerNoLeidos());
	}

	/**
	 * Test del método obtenerRuta, de la clase Carpeta.
	 * 
	 * Obtiene la ruta de la carpeta sin un padre asignado
	 */
	@Test()
	public void obtenerRutaTest() {

		Carpeta c = crearCarpeta();

		assertEquals(NOMBRE_CARPETA + " (" + NUM_MENSAJES + ")", c.obtenerRuta());
	}

	/**
	 * Test del método obtenerRuta, de la clase Carpeta.
	 * 
	 * Obtiene la ruta la carpeta con un padre asignado
	 */
	@Test()
	public void obtenerRutaConPadreTest() throws OperacionInvalida {

		Carpeta c1 = crearCarpeta();
		Carpeta c2 = new Carpeta(NOMBRE_CARPETA_PADRE);

		c2.añadir(c1);

		assertEquals(
				NOMBRE_CARPETA_PADRE + " (" + NUM_MENSAJES + ")" + " > " + NOMBRE_CARPETA + " (" + NUM_MENSAJES + ")",
				c1.obtenerRuta());
	}

	/**
	 * Test del método obtenerTamaño, de la clase Carpeta.
	 * 
	 * Obtiene el tamaño total de la carpeta y sus hijos
	 */
	@Test()
	public void obtenerTamañoTest() {

		Carpeta c = crearCarpeta();

		assertEquals(CONTENIDO_MENSAJE.length() * NUM_MENSAJES, c.obtenerTamaño());
	}

	/**
	 * Test del método obtenerTamaño, de la clase Carpeta.
	 * 
	 * Obtiene el tamaño total de una carpeta sin hijos
	 */
	@Test()
	public void obtenerTamañoCarpetaVaciaTest() {

		Carpeta c = new Carpeta(NOMBRE_CARPETA);

		assertEquals(0, c.obtenerTamaño());
	}

	/**
	 * Test del método obtenerTamaño, de la clase Carpeta.
	 * 
	 * Obtiene el tamaño total de una carpeta con un hijo que es otra carpeta
	 */
	@Test()
	public void obtenerTamañoCarpetaAnidadaTest() throws OperacionInvalida {

		Carpeta c = crearCarpeta();
		c.añadir(crearCarpeta());

		assertEquals(CONTENIDO_MENSAJE.length() * NUM_MENSAJES * 2, c.obtenerTamaño());
	}

	/**
	 * Test del método obtenerPreVisualizacion, de la clase Carpeta.
	 * 
	 * Obtiene la previsualizacion (la visualizacion normal) de la carpeta
	 */
	@Test()
	public void obtenerPreVisualizacionTest() {

		Carpeta c = crearCarpeta();

		assertEquals(NOMBRE_CARPETA + " (" + NUM_MENSAJES + ")", c.obtenerPreVisualizacion());
	}

	/**
	 * Test del método obtenerPreVisualizacion, de la clase Carpeta.
	 * 
	 * Obtiene la previsualizacion (la visualizacion normal) de la carpeta con todos
	 * sus mensajes marcados como leidos
	 */
	@Test()
	public void obtenerPreVisualizacionMensajesLeidosTest() {

		Carpeta c = crearCarpeta();
		c.establecerLeido(true);

		assertEquals(NOMBRE_CARPETA, c.obtenerPreVisualizacion());
	}

	/**
	 * Test del método obtenerPreVisualizacion, de la clase Carpeta.
	 * 
	 * Obtiene la previsualizacion (la visualizacion normal) de la carpeta con un
	 * hijo que es otra carpeta
	 */
	@Test()
	public void obtenerPreVisualizacionCarpetaAnidadaTest() throws OperacionInvalida {

		Carpeta c = crearCarpeta();
		c.añadir(crearCarpeta());

		assertEquals(NOMBRE_CARPETA + " (" + NUM_MENSAJES * 2 + ")", c.obtenerPreVisualizacion());
	}

	/**
	 * Test del método obtenerPreVisualizacion, de la clase Carpeta.
	 * 
	 * Obtiene la previsualizacion (la visualizacion normal) de la carpeta sin
	 * ningun mensaje hijo
	 */
	@Test()
	public void obtenerPreVisualizacionCarpetaVaciaTest() {

		Carpeta c = new Carpeta(NOMBRE_CARPETA);

		assertEquals(NOMBRE_CARPETA, c.obtenerPreVisualizacion());
	}

	/**
	 * Test del método explorar, de la clase Carpeta.
	 * 
	 * Devuelve todos los hijos
	 */
	@Test()
	public void explorarTest() throws OperacionInvalida {

		Carpeta c = crearCarpeta();

		assertEquals(NUM_MENSAJES, c.explorar().size());
	}

	/**
	 * Test del método explorar, de la clase Carpeta.
	 * 
	 * Devuelve todos los hijos de una carpeta vacia
	 */
	@Test()
	public void explorarCarpetaVaciaTest() throws OperacionInvalida {

		Carpeta c = new Carpeta(NOMBRE_CARPETA);

		assertEquals(0, c.explorar().size());
	}

	/**
	 * Test del método buscar, de la clase Carpeta.
	 * 
	 * Devuelve los hijos que hacen match con la cadena de busqueda
	 */
	@Test()
	public void buscarTest() throws OperacionInvalida {

		Carpeta c = crearCarpeta();

		assertEquals(NUM_MENSAJES, c.buscar(CONTENIDO_MENSAJE).size());
	}

	/**
	 * Test del método buscar, de la clase Carpeta.
	 * 
	 * Devuelve los hijos que hacen match con la cadena de busqueda para una carpeta
	 * vacia
	 */
	@Test()
	public void buscarCarpetaVaciaTest() throws OperacionInvalida {

		Carpeta c = new Carpeta(NOMBRE_CARPETA);

		assertEquals(0, c.buscar(CONTENIDO_MENSAJE).size());
	}

	/**
	 * Test del método buscar, de la clase Carpeta.
	 * 
	 * Devuelve los hijos que hacen match con la cadena de busqueda
	 */
	@Test()
	public void buscarSinResultadosTest() throws OperacionInvalida {

		Carpeta c = crearCarpeta();

		assertEquals(0, c.buscar(NOMBRE_MENSAJE).size());
	}

	/**
	 * Test del método buscar, de la clase Carpeta.
	 * 
	 * Devuelve los hijos que hacen match con la cadena de busqueda con un hijo que
	 * es otra carpeta
	 */
	@Test()
	public void buscarCarpetaAnidadaTest() throws OperacionInvalida {

		Carpeta c = crearCarpeta();
		c.añadir(crearCarpeta());

		assertEquals(NUM_MENSAJES + NUM_MENSAJES, c.buscar(CONTENIDO_MENSAJE).size());
	}

	/**
	 * Test del método añadir, de la clase Carpeta.
	 * 
	 * Añade un hijo a la carpeta
	 */
	@Test()
	public void añadirTest() throws OperacionInvalida {

		Carpeta c = new Carpeta(NOMBRE_CARPETA);

		c.añadir(new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE)));

		assertEquals(1, c.explorar().size());
	}

	/**
	 * Test del método añadir, de la clase Carpeta.
	 * 
	 * Añade un hijo de una carpeta a otra
	 */
	@Test()
	public void añadirMensajeDeOtraCarpetaTest() throws OperacionInvalida {

		Carpeta c2 = new Carpeta(NOMBRE_CARPETA + " 2");
		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		c2.añadir(m);

		Carpeta c1 = new Carpeta(NOMBRE_CARPETA);
		c1.añadir(m);

		assertEquals(1, c1.explorar().size());
		assertEquals(0, c2.explorar().size());
	}

	/**
	 * Test del método añadir, de la clase Carpeta.
	 * 
	 * Añade una carpeta como hija de otra
	 */
	@Test()
	public void añadirCarpetaTest() throws OperacionInvalida {

		Carpeta c1 = new Carpeta(NOMBRE_CARPETA);
		Carpeta c2 = crearCarpeta();

		c1.añadir(c2);

		assertEquals(1, c1.explorar().size());
		assertEquals(NUM_MENSAJES, c2.explorar().size());
	}

	/**
	 * Test del método eliminar, de la clase Carpeta.
	 * 
	 * Elimina un hijo de la carpeta
	 */
	@Test()
	public void eliminarTest() throws OperacionInvalida {

		Carpeta c = new Carpeta(NOMBRE_CARPETA);
		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		c.añadir(m);

		c.eliminar(m);

		assertEquals(0, c.explorar().size());
	}

	/**
	 * Test del método eliminar, de la clase Carpeta.
	 * 
	 * Elimina una carpeta hija de otra
	 */
	@Test()
	public void eliminarCarpetaTest() throws OperacionInvalida {

		Carpeta c1 = new Carpeta(NOMBRE_CARPETA);
		Carpeta c2 = crearCarpeta();
		c1.añadir(c2);

		c1.eliminar(c2);

		assertEquals(0, c1.explorar().size());
		assertEquals(NUM_MENSAJES, c2.explorar().size());
	}

	/**
	 * Test del método eliminar, de la clase Carpeta.
	 * 
	 * Elimina un hijo que no existe de la carpeta
	 */
	@Test()
	public void eliminarMensajeNoExistenteTest() throws OperacionInvalida {

		Carpeta c = new Carpeta(NOMBRE_CARPETA);
		Mensaje m1 = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		c.añadir(m1);

		Mensaje m2 = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		c.eliminar(m2);

		assertEquals(1, c.explorar().size());
	}

	/**
	 * Test del método obtenerHijo, de la clase Carpeta.
	 * 
	 * Obtiene el hijo en cierta posicion
	 */
	@Test()
	public void obtenerHijoTest() throws OperacionInvalida {

		Carpeta c1 = new Carpeta(NOMBRE_CARPETA);
		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		c1.añadir(m);

		assertEquals(m, c1.obtenerHijo(0));
	}

	/**
	 * Test del método obtenerHijo, de la clase Carpeta.
	 * 
	 * Obtiene el hijo inexistente en cierta posicion
	 */
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void obtenerHijoNoExisteTest() throws OperacionInvalida {

		Carpeta c1 = new Carpeta(NOMBRE_CARPETA);

		c1.obtenerHijo(0);
	}

	private Carpeta crearCarpeta() {

		Carpeta c = new Carpeta(NOMBRE_CARPETA);

		try {
			for (int i = 0; i < NUM_MENSAJES; i++) {
				c.añadir(new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE)));
			}
		} catch (OperacionInvalida e) {
			e.printStackTrace();
		}

		return c;
	}
}
