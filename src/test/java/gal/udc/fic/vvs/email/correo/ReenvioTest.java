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
	 * Test del método establecerLeido, de la clase Reenvio.
	 * 
	 * <p>
	 * 
	 * Obtiene los mensajes no leidos
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto, creando mensajes con contenido predefinido para
	 * tests generales
	 * </ul>
	 * </ul>
	 * 
	 */
	@Test()
	public void obtenerNoLeidosTest() {

		Reenvio r = crearReenvio();

		assertEquals(1, r.obtenerNoLeidos());
	}

	/**
	 * Test del método establecerLeido, de la clase Reenvio.
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
	 * <li>Valores por defecto, creando mensajes con contenido predefinido para
	 * tests generales
	 * </ul>
	 * </ul>
	 * 
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
	 * <li>Valores por defecto, creando mensajes con contenido predefinido para
	 * tests generales
	 * </ul>
	 * </ul>
	 * 
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
	 * <li>Valores por defecto, creando mensajes con contenido predefinido para
	 * tests generales
	 * </ul>
	 * </ul>
	 * 
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
	 * <li>Valores por defecto, creando mensajes con contenido predefinido para
	 * tests generales
	 * </ul>
	 * </ul>
	 * 
	 */
	@Test()
	public void obtenerIconoNoLeidoTest() {

		Reenvio r = crearReenvio();

		assertEquals(ICONO_NUEVO_MENSAJE, r.obtenerIcono());
	}

	/**
	 * Test del método explorar, de la clase Reenvio.
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
	 * <li>Valores por defecto, creando mensajes con contenido predefinido para
	 * tests generales
	 * </ul>
	 * </ul>
	 * 
	 */
	@Test(expected = OperacionInvalida.class)
	public void explorarTest() throws OperacionInvalida {

		Reenvio r = crearReenvio();

		r.explorar();
	}

	/**
	 * Test del método añadir, de la clase Reenvio.
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
	 * <li>Valores por defecto, creando mensajes con contenido predefinido para
	 * tests generales
	 * </ul>
	 * </ul>
	 * 
	 */
	@Test(expected = OperacionInvalida.class)
	public void añadirTest() throws OperacionInvalida {

		Reenvio r = crearReenvio();

		r.añadir(new Mensaje(new Texto(CONTENIDO_MENSAJE, CONTENIDO_MENSAJE)));
	}

	/**
	 * Test del método eliminar, de la clase Reenvio.
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
	 * <li>Valores por defecto, creando mensajes con contenido predefinido para
	 * tests generales
	 * </ul>
	 * </ul>
	 * 
	 */
	@Test(expected = OperacionInvalida.class)
	public void eliminarTest() throws OperacionInvalida {

		Reenvio r = crearReenvio();

		r.eliminar(new Mensaje(new Texto(CONTENIDO_MENSAJE, CONTENIDO_MENSAJE)));
	}

	/**
	 * Test del método obtenerHijo, de la clase Reenvio.
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
	 * <li>Valores por defecto, creando mensajes con contenido predefinido para
	 * tests generales
	 * </ul>
	 * </ul>
	 * 
	 */
	@Test(expected = OperacionInvalida.class)
	public void obtenerHijoTest() throws OperacionInvalida {

		Reenvio r = crearReenvio();

		r.obtenerHijo(0);
	}

	/**
	 * Test del método buscar, de la clase Reenvio.
	 * 
	 * <p>
	 * 
	 * Devuelve el reenvio si este hace match con el mismo
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto, creando mensajes con contenido predefinido para
	 * tests generales
	 * </ul>
	 * </ul>
	 * 
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
	 * <p>
	 * 
	 * Devuelve el reenvio si este hace match con una cadena vacia
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto, creando mensajes con contenido predefinido para
	 * tests generales
	 * </ul>
	 * </ul>
	 * 
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
	 * <p>
	 * 
	 * Comprueba que no se devuelve el reenvio si se introduce una cadena que no
	 * pertence al mensaje
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto, creando mensajes con contenido predefinido para
	 * tests generales
	 * </ul>
	 * </ul>
	 * 
	 */
	@Test()
	public void buscarCadenaDistintaTest() {

		Reenvio r = crearReenvio();

		assertEquals(new Vector<Reenvio>(), r.buscar(BUSCAR_MENSAJE_DISTINTO));
	}

	/**
	 * Test del método establecerPadre, de la clase Reenvio.
	 * 
	 * <p>
	 * 
	 * Establece el padre del reenvio
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto, creando mensajes con contenido predefinido para
	 * tests generales
	 * </ul>
	 * </ul>
	 * 
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
	 * <li>Valores por defecto, creando mensajes con contenido predefinido para
	 * tests generales
	 * </ul>
	 * </ul>
	 * 
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
