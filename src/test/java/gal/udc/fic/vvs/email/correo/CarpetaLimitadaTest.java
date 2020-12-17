package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class CarpetaLimitadaTest {

	private static final String NOMBRE_CARPETA = "Carpeta Nombre Test";
	private static final String NOMBRE_MENSAJE = "Mensaje Nombre Test";
	private static final String NOMBRE_CARPETA_PADRE = NOMBRE_CARPETA + " Padre";
	private static final String CONTENIDO_MENSAJE = "Contenido de Mensaje Test";

	public static final Integer ICONO_CARPETA = 1;

	public static final int NUM_MENSAJES = 10;
	public static final int TAM_CARPETA = NUM_MENSAJES;

	/**
	 * Test del método obtenerIcono, de la clase CarpetaLimitada.
	 * 
	 * Obtiene el icono asociado a la clase
	 */
	@Test()
	public void obtenerIcono() {

		CarpetaLimitada c = crearCarpetaLimitada();

		assertEquals(ICONO_CARPETA, c.obtenerIcono());
	}

	/**
	 * Test del método establecerLeido, de la clase CarpetaLimitada.
	 * 
	 * Establece todos los correos de la carpeta como leidos
	 */
	@Test()
	public void establecerLeidoTest() {

		CarpetaLimitada c = crearCarpetaLimitada();

		c.establecerLeido(true);

		assertEquals(0, c.obtenerNoLeidos());
	}

	/**
	 * Test del método establecerLeido, de la clase CarpetaLimitada.
	 * 
	 * Establece todos los correos de la carpeta como no leidos
	 */
	@Test()
	public void establecerNoLeidoTest() {

		CarpetaLimitada c = crearCarpetaLimitada();

		c.establecerLeido(false);

		assertEquals(NUM_MENSAJES, c.obtenerNoLeidos());
	}

	/**
	 * Test del método establecerLeido, de la clase CarpetaLimitada.
	 * 
	 * Establece todos los correos de la carpeta como leidos con un hijo que es otra
	 * carpeta
	 */
	@Test()
	public void establecerLeidoCarpetaAnidadaTest() throws OperacionInvalida {

		CarpetaLimitada c = crearCarpetaLimitada();
		c.añadir(crearCarpeta());

		c.establecerLeido(true);

		assertEquals(0, c.obtenerNoLeidos());
	}

	/**
	 * Test del método establecerLeido, de la clase CarpetaLimitada.
	 * 
	 * Establece todos los correos de la carpeta como no leidos con un hijo que es
	 * otra carpeta
	 */
	@Test()
	public void establecerNoLeidoCarpetaAnidadaTest() throws OperacionInvalida {

		CarpetaLimitada c = crearCarpetaLimitada();
		c.añadir(crearCarpeta());

		c.establecerLeido(false);

		assertEquals(NUM_MENSAJES * 2, c.obtenerNoLeidos());
	}

	/**
	 * Test del método obtenerNoLeidos, de la clase CarpetaLimitada.
	 * 
	 * Obtiene la cantidad de correos no leidos dentro de la carpeta
	 */
	@Test()
	public void obtenerNoLeidosTest() {

		CarpetaLimitada c = crearCarpetaLimitada();

		assertEquals(NUM_MENSAJES, c.obtenerNoLeidos());
	}

	/**
	 * Test del método obtenerNoLeidos, de la clase CarpetaLimitada.
	 * 
	 * Establece todos los correos de la carpeta como leidos con un hijo que es otra
	 * carpeta
	 */
	@Test()
	public void obtenerNoLeidosCarpetaAnidadaTest() throws OperacionInvalida {

		CarpetaLimitada c = crearCarpetaLimitada();
		c.añadir(crearCarpeta());

		assertEquals(NUM_MENSAJES * 2, c.obtenerNoLeidos());
	}

	/**
	 * Test del método obtenerRuta, de la clase CarpetaLimitada.
	 * 
	 * Obtiene la ruta de la carpeta sin un padre asignado
	 */
	@Test()
	public void obtenerRutaTest() {

		CarpetaLimitada c = crearCarpetaLimitada();

		assertEquals(NOMBRE_CARPETA + " (" + NUM_MENSAJES + ")", c.obtenerRuta());
	}

	/**
	 * Test del método obtenerRuta, de la clase CarpetaLimitada.
	 * 
	 * Obtiene la ruta la carpeta con un padre asignado
	 */
	@Test()
	public void obtenerRutaConPadreTest() throws OperacionInvalida {

		CarpetaLimitada c1 = crearCarpetaLimitada();
		Carpeta c2 = new Carpeta(NOMBRE_CARPETA_PADRE);

		c2.añadir(c1);

		assertEquals(
				NOMBRE_CARPETA_PADRE + " (" + NUM_MENSAJES + ")" + " > " + NOMBRE_CARPETA + " (" + NUM_MENSAJES + ")",
				c1.obtenerRuta());
	}

	/**
	 * Test del método obtenerTamaño, de la clase CarpetaLimitada.
	 * 
	 * Obtiene el tamaño total de la carpeta y sus hijos
	 */
	@Test()
	public void obtenerTamañoTest() {

		CarpetaLimitada c = crearCarpetaLimitada();

		assertEquals(CONTENIDO_MENSAJE.length() * NUM_MENSAJES, c.obtenerTamaño());
	}

	/**
	 * Test del método obtenerTamaño, de la clase CarpetaLimitada.
	 * 
	 * Obtiene el tamaño total de una carpeta sin hijos
	 */
	@Test()
	public void obtenerTamañoCarpetaVaciaTest() {

		CarpetaLimitada c = new CarpetaLimitada(new Carpeta(NOMBRE_CARPETA), TAM_CARPETA);

		assertEquals(0, c.obtenerTamaño());
	}

	/**
	 * Test del método obtenerTamaño, de la clase CarpetaLimitada.
	 * 
	 * Obtiene el tamaño total de una carpeta con un hijo que es otra carpeta
	 */
	@Test()
	public void obtenerTamañoCarpetaAnidadaTest() throws OperacionInvalida {

		CarpetaLimitada c = crearCarpetaLimitada();
		c.añadir(crearCarpeta());

		assertEquals(CONTENIDO_MENSAJE.length() * NUM_MENSAJES * 2, c.obtenerTamaño());
	}

	/**
	 * Test del método obtenerVisualizacion, de la clase CarpetaLimitada.
	 * 
	 * Obtiene la visualizacion de la carpeta
	 */
	@Test()
	public void obtenerVisualizacionTest() {

		CarpetaLimitada c = crearCarpetaLimitada();

		assertEquals(c.obtenerPreVisualizacion(), c.obtenerVisualizacion());
	}

	/**
	 * Test del método obtenerPreVisualizacion, de la clase CarpetaLimitada.
	 * 
	 * Obtiene la previsualizacion (la visualizacion normal) de la carpeta
	 */
	@Test()
	public void obtenerPreVisualizacionTest() {

		CarpetaLimitada c = crearCarpetaLimitada();

		assertEquals(NOMBRE_CARPETA + " (" + NUM_MENSAJES + ")", c.obtenerPreVisualizacion());
	}

	/**
	 * Test del método obtenerPreVisualizacion, de la clase CarpetaLimitada.
	 * 
	 * Obtiene la previsualizacion (la visualizacion normal) de la carpeta con todos
	 * sus mensajes marcados como leidos
	 */
	@Test()
	public void obtenerPreVisualizacionMensajesLeidosTest() {

		CarpetaLimitada c = crearCarpetaLimitada();
		c.establecerLeido(true);

		assertEquals(NOMBRE_CARPETA, c.obtenerPreVisualizacion());
	}

	/**
	 * Test del método obtenerPreVisualizacion, de la clase CarpetaLimitada.
	 * 
	 * Obtiene la previsualizacion (la visualizacion normal) de la carpeta con un
	 * hijo que es otra carpeta
	 */
	@Test()
	public void obtenerPreVisualizacionCarpetaAnidadaTest() throws OperacionInvalida {

		CarpetaLimitada c = crearCarpetaLimitada();
		c.añadir(crearCarpeta());

		assertEquals(NOMBRE_CARPETA + " (" + NUM_MENSAJES * 2 + ")", c.obtenerPreVisualizacion());
	}

	/**
	 * Test del método obtenerPreVisualizacion, de la clase CarpetaLimitada.
	 * 
	 * Obtiene la previsualizacion (la visualizacion normal) de la carpeta sin
	 * ningun mensaje hijo
	 */
	@Test()
	public void obtenerPreVisualizacionCarpetaVaciaTest() {

		CarpetaLimitada c = new CarpetaLimitada(new Carpeta(NOMBRE_CARPETA), TAM_CARPETA);

		assertEquals(NOMBRE_CARPETA, c.obtenerPreVisualizacion());
	}

	/**
	 * Test del método explorar, de la clase CarpetaLimitada.
	 * 
	 * Devuelve todos los hijos
	 */
	@Test()
	public void explorarTest() throws OperacionInvalida {

		CarpetaLimitada c = crearCarpetaLimitada();

		assertEquals(NUM_MENSAJES, c.explorar().size());
	}

	/**
	 * Test del método explorar, de la clase CarpetaLimitada.
	 * 
	 * Devuelve todos los hijos de una carpeta vacia
	 */
	@Test()
	public void explorarCarpetaVaciaTest() throws OperacionInvalida {

		CarpetaLimitada c = new CarpetaLimitada(new Carpeta(NOMBRE_CARPETA), TAM_CARPETA);

		assertEquals(0, c.explorar().size());
	}

	/**
	 * Test del método añadir, de la clase CarpetaLimitada.
	 * 
	 * Añade un hijo a la carpeta
	 */
	@Test()
	public void añadirTest() throws OperacionInvalida {

		CarpetaLimitada c = new CarpetaLimitada(new Carpeta(NOMBRE_CARPETA), TAM_CARPETA);

		c.añadir(new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE)));

		assertEquals(1, c.explorar().size());
	}

	/**
	 * Test del método añadir, de la clase CarpetaLimitada.
	 * 
	 * Añade un hijo de una carpeta a otra
	 */
	@Test()
	public void añadirMensajeDeOtraCarpetaTest() throws OperacionInvalida {

		CarpetaLimitada c2 = new CarpetaLimitada(new Carpeta(NOMBRE_CARPETA + " 2"), TAM_CARPETA);
		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		c2.añadir(m);

		CarpetaLimitada c1 = new CarpetaLimitada(new Carpeta(NOMBRE_CARPETA), TAM_CARPETA);
		c1.añadir(m);

		assertEquals(0, c2.explorar().size());
	}

	/**
	 * Test del método añadir, de la clase CarpetaLimitada.
	 * 
	 * Añade una carpeta como hija de otra
	 */
	@Test()
	public void añadirCarpetaTest() throws OperacionInvalida {

		CarpetaLimitada c1 = new CarpetaLimitada(new Carpeta(NOMBRE_CARPETA), TAM_CARPETA);
		CarpetaLimitada c2 = crearCarpetaLimitada();

		c1.añadir(c2);

		assertEquals(NUM_MENSAJES, c2.explorar().size());
	}

	/**
	 * Test del método eliminar, de la clase CarpetaLimitada.
	 * 
	 * Elimina un hijo de la carpeta
	 */
	@Test()
	public void eliminarTest() throws OperacionInvalida {

		CarpetaLimitada c = new CarpetaLimitada(new Carpeta(NOMBRE_CARPETA), TAM_CARPETA);
		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		c.añadir(m);

		c.eliminar(m);

		assertEquals(0, c.explorar().size());
	}

	/**
	 * Test del método eliminar, de la clase CarpetaLimitada.
	 * 
	 * Elimina una carpeta hija de otra
	 */
	@Test()
	public void eliminarCarpetaTest() throws OperacionInvalida {

		CarpetaLimitada c1 = new CarpetaLimitada(new Carpeta(NOMBRE_CARPETA), TAM_CARPETA);
		CarpetaLimitada c2 = crearCarpetaLimitada();
		c1.añadir(c2);

		c1.eliminar(c2);

		assertEquals(0, c1.explorar().size());
	}

	/**
	 * Test del método eliminar, de la clase CarpetaLimitada.
	 * 
	 * Elimina un hijo que no existe de la carpeta
	 */
	@Test()
	public void eliminarMensajeNoExistenteTest() throws OperacionInvalida {

		CarpetaLimitada c = new CarpetaLimitada(new Carpeta(NOMBRE_CARPETA), TAM_CARPETA);
		Mensaje m1 = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		c.añadir(m1);

		Mensaje m2 = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		c.eliminar(m2);

		assertEquals(1, c.explorar().size());
	}

	/**
	 * Test del método obtenerHijo, de la clase CarpetaLimitada.
	 * 
	 * Obtiene el hijo en cierta posicion
	 */
	@Test()
	public void obtenerHijoTest() throws OperacionInvalida {

		CarpetaLimitada c = new CarpetaLimitada(new Carpeta(NOMBRE_CARPETA), TAM_CARPETA);
		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		c.añadir(m);

		assertEquals(m, c.obtenerHijo(0));
	}

	/**
	 * Test del método obtenerHijo, de la clase CarpetaLimitada.
	 * 
	 * Obtiene el hijo inexistente en cierta posicion
	 */
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void obtenerHijoNoExisteTest() throws OperacionInvalida {

		CarpetaLimitada c = new CarpetaLimitada(new Carpeta(NOMBRE_CARPETA), TAM_CARPETA);

		c.obtenerHijo(0);
	}

	/**
	 * Test del método buscar, de la clase CarpetaLimitada.
	 * 
	 * Devuelve los hijos que hacen match con la cadena de busqueda
	 */
	@Test()
	public void buscarTest() throws OperacionInvalida {

		CarpetaLimitada c = crearCarpetaLimitada();

		assertEquals(TAM_CARPETA, c.buscar(CONTENIDO_MENSAJE).size());
	}

	/**
	 * Test del método buscar, de la clase CarpetaLimitada.
	 * 
	 * Devuelve los hijos que hacen match con la cadena de busqueda sobrepasando el
	 * limite de elementos encontrados
	 */
	@Test()
	public void buscarLimiteElementosTest() throws OperacionInvalida {

		CarpetaLimitada c = new CarpetaLimitada(new Carpeta(NOMBRE_CARPETA), TAM_CARPETA);

		for (int i = 0; i < TAM_CARPETA * 2; i++) {
			c.añadir(new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE)));
		}

		assertEquals(TAM_CARPETA + 1, c.buscar(CONTENIDO_MENSAJE).size());
	}

	/**
	 * Test del método buscar, de la clase CarpetaLimitada.
	 * 
	 * Devuelve los hijos que hacen match con la cadena de busqueda para una carpeta
	 * vacia
	 */
	@Test()
	public void buscarCarpetaVaciaTest() throws OperacionInvalida {

		CarpetaLimitada c = new CarpetaLimitada(new Carpeta(NOMBRE_CARPETA), TAM_CARPETA);

		assertEquals(0, c.buscar(CONTENIDO_MENSAJE).size());
	}

	/**
	 * Test del método buscar, de la clase CarpetaLimitada.
	 * 
	 * Devuelve los hijos que hacen match con la cadena de busqueda
	 */
	@Test()
	public void buscarSinResultadosTest() throws OperacionInvalida {

		CarpetaLimitada c = crearCarpetaLimitada();

		assertEquals(0, c.buscar(NOMBRE_MENSAJE).size());
	}

	/**
	 * Test del método buscar, de la clase CarpetaLimitada.
	 * 
	 * Devuelve los hijos que hacen match con la cadena de busqueda con un hijo que
	 * es otra carpeta
	 */
	@Test()
	public void buscarCarpetaAnidadaTest() throws OperacionInvalida {

		CarpetaLimitada c = crearCarpetaLimitada();
		c.añadir(new CarpetaLimitada(new Carpeta(NOMBRE_CARPETA), TAM_CARPETA));

		assertEquals(TAM_CARPETA, c.buscar(CONTENIDO_MENSAJE).size());
	}

	private CarpetaLimitada crearCarpetaLimitada() {

		CarpetaLimitada c = new CarpetaLimitada(crearCarpeta(), TAM_CARPETA);

		return c;
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
