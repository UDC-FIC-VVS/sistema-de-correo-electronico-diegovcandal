package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Vector;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Archivo;
import gal.udc.fic.vvs.email.archivo.Imagen;
import gal.udc.fic.vvs.email.archivo.Texto;

public class AdjuntoTest {

	private static final String NOMBRE_MENSAJE = "Mensaje Nombre Test";
	private static final String CONTENIDO_MENSAJE = "Contenido de Mensaje Test";
	private static final String NOMBRE_CARPETA = "Carpeta Nombre Test";
	private static final String NOMBRE_ADJUNTO = "Adjunto Nombre Test";
	private static final String CONTENIDO_ADJUNTO = "Contenido del Adjunto Test";

	private static final String BUSCAR_MENSAJE_DISTINTO = "Otro Contenido de Mensaje Test";

	public static final Integer ICONO_MENSAJE = 2;
	public static final Integer ICONO_NUEVO_MENSAJE = 3;

	/**
	 * Test del método obtenerTamaño, de la clase Adjunto.
	 * 
	 * Obtiene la suma del tamaño del mensaje y el archivo adjunto
	 */
	@Test()
	public void obtenerTamañoTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		Archivo ar = new Imagen(NOMBRE_ADJUNTO, CONTENIDO_ADJUNTO);

		Adjunto r = new Adjunto(m, ar);

		assertEquals(m.obtenerTamaño() + ar.obtenerTamaño(), r.obtenerTamaño());
	}

	/**
	 * Test del método obtenerTamaño, de la clase Adjunto.
	 * 
	 * Para mas de un adjunto, obtiene la suma del tamaño del mensaje y los archivos
	 * adjuntados
	 */
	@Test()
	public void obtenerTamañoAdjuntoMultipleTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		Archivo ar = new Imagen(NOMBRE_ADJUNTO, CONTENIDO_ADJUNTO);

		Adjunto r = new Adjunto(m, ar);
		Adjunto r2 = new Adjunto(r, ar);

		assertEquals(r.obtenerTamaño() + ar.obtenerTamaño(), r2.obtenerTamaño());
	}

	/**
	 * Test del método obtenerVisualizacion, de la clase Adjunto.
	 * 
	 * Obtiene la visualizacion del mensaje y el archivo adjunto
	 */
	@Test()
	public void obtenerVisualizacionTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		Archivo ar = new Imagen(NOMBRE_ADJUNTO, CONTENIDO_ADJUNTO);

		Adjunto r = new Adjunto(m, ar);

		assertEquals(m.obtenerVisualizacion() + "\n\nAdxunto: " + ar.obtenerPreVisualizacion(),
				r.obtenerVisualizacion());
	}

	/**
	 * Test del método obtenerTamaño, de la clase Adjunto.
	 * 
	 * Para mas de un adjunto, obtiene la visualizacion del mensaje y los archivos
	 * adjuntados
	 */
	@Test()
	public void obtenerVisualizacionAdjuntoMultipleTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		Archivo ar = new Imagen(NOMBRE_ADJUNTO, CONTENIDO_ADJUNTO);

		Adjunto r = new Adjunto(m, ar);
		Adjunto r2 = new Adjunto(r, ar);

		assertEquals(r.obtenerVisualizacion() + "\n\nAdxunto: " + ar.obtenerPreVisualizacion(),
				r2.obtenerVisualizacion());
	}

	/**
	 * Test del método establecerLeido, de la clase Adjunto.
	 * 
	 * Obtiene los mensajes no leidos
	 */
	@Test()
	public void obtenerNoLeidosTest() {

		Adjunto r = crearAdjunto();

		assertEquals(1, r.obtenerNoLeidos());
	}

	/**
	 * Test del método establecerLeido, de la clase Adjunto.
	 * 
	 * Establece el mensaje como leido
	 */
	@Test()
	public void establecerLeidoTrueTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		Archivo ar = new Imagen(NOMBRE_ADJUNTO, CONTENIDO_ADJUNTO);

		Adjunto r = new Adjunto(m, ar);

		r.establecerLeido(true);

		assertEquals(0, m.obtenerNoLeidos());
	}

	/**
	 * Test del método establecerLeido, de la clase Adjunto.
	 * 
	 * Establece el mensaje como no leido
	 */
	@Test()
	public void establecerNoLeidoTrueTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		Archivo ar = new Imagen(NOMBRE_ADJUNTO, CONTENIDO_ADJUNTO);

		Adjunto r = new Adjunto(m, ar);

		r.establecerLeido(false);

		assertEquals(1, m.obtenerNoLeidos());
	}

	/**
	 * Test del método obtenerIcono, de la clase Adjunto.
	 * 
	 * Obtiene el icono si el mensaje esta marcado como leido
	 */
	@Test()
	public void obtenerIconoLeidoTest() {

		Adjunto r = crearAdjunto();

		r.establecerLeido(true);

		assertEquals(ICONO_MENSAJE, r.obtenerIcono());
	}

	/**
	 * Test del método obtenerIcono, de la clase Adjunto.
	 * 
	 * Obtiene el icono si el mensaje esta marcado como no leido
	 */
	@Test()
	public void obtenerIconoNoLeidoTest() {

		Adjunto r = crearAdjunto();

		assertEquals(ICONO_NUEVO_MENSAJE, r.obtenerIcono());
	}

	/**
	 * Test del método obtenerPreVisualizacion, de la clase Adjunto.
	 * 
	 * Obtiene la previsualizacion del mensaje
	 */
	@Test()
	public void obtenerPreVisualizacionTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		Archivo ar = new Imagen(NOMBRE_ADJUNTO, CONTENIDO_ADJUNTO);

		Adjunto r = new Adjunto(m, ar);

		assertEquals(m.obtenerPreVisualizacion(), r.obtenerPreVisualizacion());
	}

	/**
	 * Test del método obtenerRuta, de la clase Adjunto.
	 * 
	 * Obtiene la ruta del mensaje
	 */
	@Test()
	public void obtenerRutaTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		Archivo ar = new Imagen(NOMBRE_ADJUNTO, CONTENIDO_ADJUNTO);

		Adjunto r = new Adjunto(m, ar);

		assertEquals(m.obtenerRuta(), r.obtenerRuta());
	}

	/**
	 * Test del método obtenerRuta, de la clase Adjunto.
	 * 
	 * Obtiene la ruta del mensaje con un padre asignado
	 */
	@Test()
	public void obtenerRutaConPadreTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		Archivo ar = new Imagen(NOMBRE_ADJUNTO, CONTENIDO_ADJUNTO);

		Adjunto r = new Adjunto(m, ar);

		Carpeta c = new Carpeta(NOMBRE_CARPETA);
		r.establecerPadre(c);

		assertEquals(NOMBRE_CARPETA + " > " + m.obtenerPreVisualizacion(), r.obtenerRuta());
	}

	/**
	 * Test del método explorar, de la clase Adjunto.
	 * 
	 * Se devuelve una excepcion
	 */
	@Test(expected = OperacionInvalida.class)
	public void explorarTest() throws OperacionInvalida {

		Adjunto r = crearAdjunto();

		r.explorar();
	}

	/**
	 * Test del método añadir, de la clase Adjunto.
	 * 
	 * Se devuelve una excepcion
	 */
	@Test(expected = OperacionInvalida.class)
	public void añadirTest() throws OperacionInvalida {

		Adjunto r = crearAdjunto();

		r.añadir(new Mensaje(new Texto(CONTENIDO_MENSAJE, CONTENIDO_MENSAJE)));
	}

	/**
	 * Test del método eliminar, de la clase Adjunto.
	 * 
	 * Se devuelve una excepcion
	 */
	@Test(expected = OperacionInvalida.class)
	public void eliminarTest() throws OperacionInvalida {

		Adjunto r = crearAdjunto();

		r.eliminar(new Mensaje(new Texto(CONTENIDO_MENSAJE, CONTENIDO_MENSAJE)));
	}

	/**
	 * Test del método obtenerHijo, de la clase Adjunto.
	 * 
	 * Se devuelve una excepcion
	 */
	@Test(expected = OperacionInvalida.class)
	public void obtenerHijoTest() throws OperacionInvalida {

		Adjunto r = crearAdjunto();

		r.obtenerHijo(0);
	}

	/**
	 * Test del método buscar, de la clase Adjunto.
	 * 
	 * Devuelve el mensaje si este hace match con el mismo
	 */
	@Test()
	public void buscarTest() {

		Adjunto r = crearAdjunto();

		Collection<Adjunto> collection = new Vector<Adjunto>();
		collection.add(r);

		assertEquals(collection, r.buscar(CONTENIDO_MENSAJE));
	}

	/**
	 * Test del método buscar, de la clase Adjunto.
	 * 
	 * Devuelve el mensaje si este hace match con una cadena Adjunto
	 */
	@Test()
	public void buscarCadenaVaciaTest() {

		Adjunto r = crearAdjunto();

		Collection<Adjunto> collection = new Vector<Adjunto>();
		collection.add(r);

		assertEquals(collection, r.buscar(""));
	}

	/**
	 * Test del método buscar, de la clase Adjunto.
	 * 
	 * Comprueba que no se devuelve el mensaje si se introduce una cadena que no
	 * pertence al mensaje
	 */
	@Test()
	public void buscarCadenaDistintaTest() {

		Adjunto r = crearAdjunto();

		assertEquals(new Vector<Adjunto>(), r.buscar(BUSCAR_MENSAJE_DISTINTO));
	}

	/**
	 * Test del método establecerPadre, de la clase Adjunto.
	 * 
	 * Establece el padre del mensaje
	 */
	@Test()
	public void establecerObtenerPadreTest() throws OperacionInvalida {

		Adjunto r = crearAdjunto();

		Carpeta c = new Carpeta(NOMBRE_CARPETA);
		r.establecerPadre(c);

		assertEquals(c, r.obtenerPadre());
	}

	/**
	 * Test del método obtenerPadre, de la clase Adjunto.
	 * 
	 * Obtiene el padre si no ha sido establecido anteriormente
	 */
	@Test()
	public void obtenerPadreNullTest() throws OperacionInvalida {

		Adjunto r = crearAdjunto();

		assertEquals(null, r.obtenerPadre());
	}

	private Adjunto crearAdjunto() {
		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		Archivo ar = new Imagen(NOMBRE_ADJUNTO, CONTENIDO_ADJUNTO);

		return new Adjunto(m, ar);
	}

}
