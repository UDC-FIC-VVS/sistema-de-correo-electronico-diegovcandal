package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Vector;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class ReenvioTest {

	private static final String NOMBRE_MENSAJE = "Mensaje Nombre Test";
	private static final String CONTENIDO_MENSAJE = "Contenido de Mensaje Test";
	private static final String NOMBRE_CARPETA = "Carpeta Nombre Test";
	private static final String NOMBRE_MENSAJE_REENVIADO = "Mensaje Reenviado Nombre Test";
	private static final String CONTENIDO_MENSAJE_REENVIADO = "Contenido de Mensaje Reenviado Test";

	private static final String BUSCAR_MENSAJE_DISTINTO = "Otro Contenido de Mensaje Test";

	public static final Integer ICONO_MENSAJE = 2;
	public static final Integer ICONO_NUEVO_MENSAJE = 3;

	/**
	 * Test del método obtenerTamaño, de la clase Reenvio.
	 * 
	 * Obtiene la suma del tamaño del mensaje y el correo reenviado
	 */
	@Test()
	public void obtenerTamañoTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		Mensaje m_reenviado = new Mensaje(new Texto(NOMBRE_MENSAJE_REENVIADO, CONTENIDO_MENSAJE_REENVIADO));

		Correo r = new Reenvio(m, m_reenviado);

		assertEquals(m.obtenerTamaño() + m_reenviado.obtenerTamaño(), r.obtenerTamaño());
	}

	/**
	 * Test del método obtenerTamaño, de la clase Reenvio.
	 * 
	 * Para mas de un reenvio, obtiene la suma del tamaño del mensaje y los correos
	 * reenviados
	 */
	@Test()
	public void obtenerTamañoReenvioMultipleTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		Mensaje m_reenviado = new Mensaje(new Texto(NOMBRE_MENSAJE_REENVIADO, CONTENIDO_MENSAJE_REENVIADO));

		Correo r = new Reenvio(m, m_reenviado);
		Correo r2 = new Reenvio(m, r);

		assertEquals(m.obtenerTamaño() + r.obtenerTamaño(), r2.obtenerTamaño());
	}

	/**
	 * Test del método obtenerVisualizacion, de la clase Reenvio.
	 * 
	 * Obtiene la visualizacion del mensaje y el correo reenviado
	 */
	@Test()
	public void obtenerVisualizacionTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		Mensaje m_reenviado = new Mensaje(new Texto(NOMBRE_MENSAJE_REENVIADO, CONTENIDO_MENSAJE_REENVIADO));

		Correo r = new Reenvio(m, m_reenviado);

		assertEquals(m.obtenerVisualizacion() + "\n\n---- Correo reenviado ----\n\n"
				+ m_reenviado.obtenerVisualizacion() + "\n---- Fin correo reenviado ----", r.obtenerVisualizacion());
	}

	/**
	 * Test del método obtenerTamaño, de la clase Reenvio.
	 * 
	 * Para mas de un reenvio, obtiene la visualizacion del mensaje y los correos
	 * reenviados
	 */
	@Test()
	public void obtenerVisualizacionReenvioMultipleTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		Mensaje m_reenviado = new Mensaje(new Texto(NOMBRE_MENSAJE_REENVIADO, CONTENIDO_MENSAJE_REENVIADO));

		Correo r = new Reenvio(m, m_reenviado);
		Correo r2 = new Reenvio(m, r);

		assertEquals(m.obtenerVisualizacion() + "\n\n---- Correo reenviado ----\n\n" + r.obtenerVisualizacion()
				+ "\n---- Fin correo reenviado ----", r2.obtenerVisualizacion());
	}

	/**
	 * Test del método establecerLeido, de la clase Reenvio.
	 * 
	 * Obtiene los mensajes no leidos
	 */
	@Test()
	public void obtenerNoLeidosTest() {

		Reenvio r = crearReenvio();

		assertEquals(1, r.obtenerNoLeidos());
	}

	/**
	 * Test del método establecerLeido, de la clase Reenvio.
	 * 
	 * Establece el mensaje como leido
	 */
	@Test()
	public void establecerLeidoTrueTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		Mensaje m_reenviado = new Mensaje(new Texto(NOMBRE_MENSAJE_REENVIADO, CONTENIDO_MENSAJE_REENVIADO));

		Correo r = new Reenvio(m, m_reenviado);

		r.establecerLeido(true);

		assertEquals(0, m.obtenerNoLeidos());
	}

	/**
	 * Test del método establecerLeido, de la clase Reenvio.
	 * 
	 * Establece el mensaje como no leido
	 */
	@Test()
	public void establecerNoLeidoTrueTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		Mensaje m_reenviado = new Mensaje(new Texto(NOMBRE_MENSAJE_REENVIADO, CONTENIDO_MENSAJE_REENVIADO));

		Correo r = new Reenvio(m, m_reenviado);

		r.establecerLeido(false);

		assertEquals(1, m.obtenerNoLeidos());
	}

	/**
	 * Test del método obtenerIcono, de la clase Reenvio.
	 * 
	 * Obtiene el icono si el mensaje esta marcado como leido
	 */
	@Test()
	public void obtenerIconoLeidoTest() {

		Reenvio r = crearReenvio();

		r.establecerLeido(true);

		assertEquals(ICONO_MENSAJE, r.obtenerIcono());
	}

	/**
	 * Test del método obtenerIcono, de la clase Reenvio.
	 * 
	 * Obtiene el icono si el mensaje esta marcado como no leido
	 */
	@Test()
	public void obtenerIconoNoLeidoTest() {

		Reenvio r = crearReenvio();

		assertEquals(ICONO_NUEVO_MENSAJE, r.obtenerIcono());
	}

	/**
	 * Test del método obtenerPreVisualizacion, de la clase Reenvio.
	 * 
	 * Obtiene la previsualizacion del mensaje
	 */
	@Test()
	public void obtenerPreVisualizacionTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		Mensaje m_reenviado = new Mensaje(new Texto(NOMBRE_MENSAJE_REENVIADO, CONTENIDO_MENSAJE_REENVIADO));

		Correo r = new Reenvio(m, m_reenviado);

		assertEquals(m.obtenerPreVisualizacion(), r.obtenerPreVisualizacion());
	}

	/**
	 * Test del método obtenerRuta, de la clase Reenvio.
	 * 
	 * Obtiene la ruta del reenvio
	 */
	@Test()
	public void obtenerRutaTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		Mensaje m_reenviado = new Mensaje(new Texto(NOMBRE_MENSAJE_REENVIADO, CONTENIDO_MENSAJE_REENVIADO));

		Correo r = new Reenvio(m, m_reenviado);

		assertEquals(m.obtenerRuta(), r.obtenerRuta());
	}

	/**
	 * Test del método obtenerRuta, de la clase Reenvio.
	 * 
	 * Obtiene la ruta del reenvio con un padre asignado
	 */
	@Test()
	public void obtenerRutaConPadreTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		Mensaje m_reenviado = new Mensaje(new Texto(NOMBRE_MENSAJE_REENVIADO, CONTENIDO_MENSAJE_REENVIADO));

		Reenvio r = new Reenvio(m, m_reenviado);

		Carpeta c = new Carpeta(NOMBRE_CARPETA);
		r.establecerPadre(c);

		assertEquals(NOMBRE_CARPETA + " > " + m.obtenerPreVisualizacion(), r.obtenerRuta());
	}

	/**
	 * Test del método explorar, de la clase Reenvio.
	 * 
	 * Se devuelve una excepcion
	 */
	@Test(expected = OperacionInvalida.class)
	public void explorarTest() throws OperacionInvalida {

		Reenvio r = crearReenvio();

		r.explorar();
	}

	/**
	 * Test del método añadir, de la clase Reenvio.
	 * 
	 * Se devuelve una excepcion
	 */
	@Test(expected = OperacionInvalida.class)
	public void añadirTest() throws OperacionInvalida {

		Reenvio r = crearReenvio();

		r.añadir(new Mensaje(new Texto(CONTENIDO_MENSAJE, CONTENIDO_MENSAJE)));
	}

	/**
	 * Test del método eliminar, de la clase Reenvio.
	 * 
	 * Se devuelve una excepcion
	 */
	@Test(expected = OperacionInvalida.class)
	public void eliminarTest() throws OperacionInvalida {

		Reenvio r = crearReenvio();

		r.eliminar(new Mensaje(new Texto(CONTENIDO_MENSAJE, CONTENIDO_MENSAJE)));
	}

	/**
	 * Test del método obtenerHijo, de la clase Reenvio.
	 * 
	 * Se devuelve una excepcion
	 */
	@Test(expected = OperacionInvalida.class)
	public void obtenerHijoTest() throws OperacionInvalida {

		Reenvio r = crearReenvio();

		r.obtenerHijo(0);
	}

	/**
	 * Test del método buscar, de la clase Reenvio.
	 * 
	 * Devuelve el reenvio si este hace match con el mismo
	 */
	@Test()
	public void buscarTest() {

		Reenvio r = crearReenvio();

		Collection<Reenvio> collection = new Vector<Reenvio>();
		collection.add(r);

		assertEquals(collection, r.buscar(CONTENIDO_MENSAJE));
	}

	/**
	 * Test del método buscar, de la clase Reenvio.
	 * 
	 * Devuelve el reenvio si este hace match con una cadena vacia
	 */
	@Test()
	public void buscarCadenaVaciaTest() {

		Reenvio r = crearReenvio();

		Collection<Reenvio> collection = new Vector<Reenvio>();
		collection.add(r);

		assertEquals(collection, r.buscar(""));
	}

	/**
	 * Test del método buscar, de la clase Reenvio.
	 * 
	 * Comprueba que no se devuelve el reenvio si se introduce una cadena que no
	 * pertence al mensaje
	 */
	@Test()
	public void buscarCadenaDistintaTest() {

		Reenvio r = crearReenvio();

		assertEquals(new Vector<Reenvio>(), r.buscar(BUSCAR_MENSAJE_DISTINTO));
	}

	/**
	 * Test del método establecerPadre, de la clase Reenvio.
	 * 
	 * Establece el padre del reenvio
	 */
	@Test()
	public void establecerObtenerPadreTest() throws OperacionInvalida {

		Reenvio r = crearReenvio();
		Carpeta c = new Carpeta(NOMBRE_CARPETA);
		r.establecerPadre(c);

		assertEquals(c, r.obtenerPadre());
	}

	/**
	 * Test del método obtenerPadre, de la clase Reenvio.
	 * 
	 * Obtiene el padre si no ha sido establecido anteriormente
	 */
	@Test()
	public void obtenerPadreNullTest() throws OperacionInvalida {

		Reenvio r = crearReenvio();

		assertEquals(null, r.obtenerPadre());
	}

	private Reenvio crearReenvio() {
		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		Mensaje m_reenviado = new Mensaje(new Texto(NOMBRE_MENSAJE_REENVIADO, CONTENIDO_MENSAJE_REENVIADO));

		return new Reenvio(m, m_reenviado);
	}

}
