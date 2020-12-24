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

	public static final Integer ICONO_MENSAJE = 2;
	public static final Integer ICONO_NUEVO_MENSAJE = 3;
	public static final Integer NUM_MENSAJES = 10;

	/**
	 * Test del método establecerLeido, de la clase Mensaje.
	 * 
	 * <p>
	 * 
	 * Establece el mensaje como leido
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos no influyan en la prueba.
	 * </ul>
	 * </ul>
	 * 
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
	 * <p>
	 * 
	 * Establece el mensaje como no leido
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos no influyan en la prueba.
	 * </ul>
	 * </ul>
	 * 
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
	 * <p>
	 * 
	 * Obtiene el estado inicial del mensaje
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos no influyan en la prueba.
	 * </ul>
	 * </ul>
	 * 
	 */
	@Test()
	public void obtenerNoLeidosEstadoIncialTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		assertEquals(1, m.obtenerNoLeidos());
	}

	/**
	 * Test unitario del método obtenerIcono de la clase Mensaje.
	 * 
	 * <p>
	 * 
	 * Obtiene el icono si el mensaje esta marcado como leido
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos no influyan en la prueba.
	 * </ul>
	 * </ul>
	 * 
	 */
	@Test()
	public void obtenerIconoLeidoTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		m.establecerLeido(true);

		assertEquals(ICONO_MENSAJE, m.obtenerIcono());
	}

	/**
	 * Test unitario del método obtenerIcono de la clase Mensaje.
	 * 
	 * <p>
	 * 
	 * Obtiene el icono si el mensaje esta marcado como no leido
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos no influyan en la prueba.
	 * </ul>
	 * </ul>
	 * 
	 */
	@Test()
	public void obtenerIconoNoLeidoTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		assertEquals(ICONO_NUEVO_MENSAJE, m.obtenerIcono());
	}

	/**
	 * Test unitario del método buscar de la clase Mensaje.
	 * 
	 * <p>
	 * 
	 * Devuelve el mensaje si este hace match con el mismo
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos no influyan en la prueba.
	 * </ul>
	 * </ul>
	 * 
	 */
	@Test()
	public void buscarTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		Collection<Mensaje> collection = new Vector<Mensaje>();
		collection.add(m);

		assertEquals(collection, m.buscar(CONTENIDO_MENSAJE));
	}

	/**
	 * Test unitario del método buscar de la clase Mensaje.
	 * 
	 * <p>
	 * 
	 * Devuelve el mensaje si este hace match con una cadena vacia
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos no influyan en la prueba.
	 * </ul>
	 * </ul>
	 * 
	 */
	@Test()
	public void buscarCadenaVaciaTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		Collection<Mensaje> collection = new Vector<Mensaje>();
		collection.add(m);

		assertEquals(collection, m.buscar(""));
	}

	/**
	 * Test unitario del método buscar de la clase Mensaje.
	 * 
	 * <p>
	 * 
	 * Comprueba que no se devuelve el mensaje si se introduce una cadena que no
	 * pertence al mensaje
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos no influyan en la prueba.
	 * </ul>
	 * </ul>
	 * 
	 */
	@Test()
	public void buscarCadenaDistintaTest() {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		assertEquals(new Vector<Mensaje>(), m.buscar(BUSCAR_MENSAJE_DISTINTO));
	}

	/**
	 * Test unitario del método establecerPadre de la clase Mensaje.
	 * 
	 * <p>
	 * 
	 * Establece el padre del Mensaje
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos no influyan en la prueba.
	 * </ul>
	 * </ul>
	 * 
	 */
	@Test()
	public void establecerObtenerPadreTest() throws OperacionInvalida {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));
		Carpeta c = new Carpeta(NOMBRE_CARPETA);
		m.establecerPadre(c);

		assertEquals(c, m.obtenerPadre());
	}

	/**
	 * Test unitario del método obtenerPadre de la clase Mensaje.
	 * 
	 * <p>
	 * 
	 * Obtiene el padre si no ha sido establecido anteriormente
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos no influyan en la prueba.
	 * </ul>
	 * </ul>
	 * 
	 */
	@Test()
	public void obtenerPadreNullTest() throws OperacionInvalida {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		assertEquals(null, m.obtenerPadre());
	}

	/**
	 * Test unitario del método explorar de la clase Mensaje.
	 * 
	 * <p>
	 * 
	 * Se devuelve una excepcion
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y negativo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos no influyan en la prueba.
	 * </ul>
	 * </ul>
	 * 
	 */
	@Test(expected = OperacionInvalida.class)
	public void explorarTest() throws OperacionInvalida {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		m.explorar();
	}

	/**
	 * Test unitario del método añadir de la clase Mensaje.
	 * 
	 * <p>
	 * 
	 * Se devuelve una excepcion
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y negativo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos no influyan en la prueba.
	 * </ul>
	 * </ul>
	 * 
	 */
	@Test(expected = OperacionInvalida.class)
	public void añadirTest() throws OperacionInvalida {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		m.añadir(new Mensaje(new Texto(CONTENIDO_MENSAJE, CONTENIDO_MENSAJE)));
	}

	/**
	 * Test unitario del método eliminar de la clase Mensaje.
	 * 
	 * <p>
	 * 
	 * Se devuelve una excepcion
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y negativo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos no influyan en la prueba.
	 * </ul>
	 * </ul>
	 * 
	 */
	@Test(expected = OperacionInvalida.class)
	public void eliminarTest() throws OperacionInvalida {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		m.eliminar(new Mensaje(new Texto(CONTENIDO_MENSAJE, CONTENIDO_MENSAJE)));
	}

	/**
	 * Test unitario del método obtenerHijo de la clase Mensaje.
	 * 
	 * <p>
	 * 
	 * Se devuelve una excepcion
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y negativo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos no influyan en la prueba.
	 * </ul>
	 * </ul>
	 * 
	 */
	@Test(expected = OperacionInvalida.class)
	public void obtenerHijoTest() throws OperacionInvalida {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		m.obtenerHijo(0);
	}

}
