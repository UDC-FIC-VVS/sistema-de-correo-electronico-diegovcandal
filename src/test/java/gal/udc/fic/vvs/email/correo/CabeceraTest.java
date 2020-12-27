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
	 * Test del método establecerLeido, de la clase Cabecera.
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
	 * <li>Valores por defecto, creando cabeceras y mensajes con contenido
	 * predefinido para tests generales
	 * </ul>
	 * </ul>
	 * 
	 */
	@Test()
	public void obtenerNoLeidosTest() {

		Cabecera c = crearCabecera();

		assertEquals(1, c.obtenerNoLeidos());
	}

	/**
	 * Test del método establecerLeido, de la clase Cabecera.
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
	 * <li>Valores por defecto, creando cabeceras y mensajes con contenido
	 * predefinido para tests generales
	 * </ul>
	 * </ul>
	 * 
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
	 * <li>Valores por defecto, creando cabeceras y mensajes con contenido
	 * predefinido para tests generales
	 * </ul>
	 * </ul>
	 * 
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
	 * <li>Valores por defecto, creando cabeceras y mensajes con contenido
	 * predefinido para tests generales
	 * </ul>
	 * </ul>
	 * 
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
	 * <li>Valores por defecto, creando cabeceras y mensajes con contenido
	 * predefinido para tests generales
	 * </ul>
	 * </ul>
	 * 
	 */
	@Test()
	public void obtenerIconoNoLeidoTest() {

		Cabecera c = crearCabecera();

		assertEquals(ICONO_NUEVO_MENSAJE, c.obtenerIcono());
	}

	/**
	 * Test del método explorar, de la clase Cabecera.
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
	 * <li>Valores por defecto, creando cabeceras y mensajes con contenido
	 * predefinido para tests generales
	 * </ul>
	 * </ul>
	 * 
	 */
	@Test(expected = OperacionInvalida.class)
	public void explorarTest() throws OperacionInvalida {

		Cabecera c = crearCabecera();

		c.explorar();
	}

	/**
	 * Test del método añadir, de la clase Cabecera.
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
	 * <li>Valores por defecto, creando cabeceras y mensajes con contenido
	 * predefinido para tests generales
	 * </ul>
	 * </ul>
	 * 
	 */
	@Test(expected = OperacionInvalida.class)
	public void añadirTest() throws OperacionInvalida {

		Cabecera c = crearCabecera();

		c.añadir(new Mensaje(new Texto(CONTENIDO_MENSAJE, CONTENIDO_MENSAJE)));
	}

	/**
	 * Test del método eliminar, de la clase Cabecera.
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
	 * <li>Valores por defecto, creando cabeceras y mensajes con contenido
	 * predefinido para tests generales
	 * </ul>
	 * </ul>
	 * 
	 */
	@Test(expected = OperacionInvalida.class)
	public void eliminarTest() throws OperacionInvalida {

		Cabecera c = crearCabecera();

		c.eliminar(new Mensaje(new Texto(CONTENIDO_MENSAJE, CONTENIDO_MENSAJE)));
	}

	/**
	 * Test del método obtenerHijo, de la clase Cabecera.
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
	 * <li>Valores por defecto, creando cabeceras y mensajes con contenido
	 * predefinido para tests generales
	 * </ul>
	 * </ul>
	 * 
	 */
	@Test(expected = OperacionInvalida.class)
	public void obtenerHijoTest() throws OperacionInvalida {

		Cabecera c = crearCabecera();

		c.obtenerHijo(0);
	}

	/**
	 * Test del método buscar, de la clase Cabecera.
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
	 * <li>Valores por defecto, creando cabeceras y mensajes con contenido
	 * predefinido para tests generales
	 * </ul>
	 * </ul>
	 * 
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
	 * <p>
	 * 
	 * Devuelve el mensaje si este hace match con una cadena.
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto, creando cabeceras y mensajes con contenido
	 * predefinido para tests generales
	 * </ul>
	 * </ul>
	 * 
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
	 * <li>Valores por defecto, creando cabeceras y mensajes con contenido
	 * predefinido para tests generales
	 * </ul>
	 * </ul>
	 * 
	 */
	@Test()
	public void buscarCadenaDistintaTest() {

		Cabecera c = crearCabecera();

		assertEquals(new Vector<Cabecera>(), c.buscar(BUSCAR_MENSAJE_DISTINTO));
	}

	/**
	 * Test del método establecerPadre, de la clase Cabecera.
	 * 
	 * <p>
	 * 
	 * Establece el padre del mensaje
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto, creando cabeceras y mensajes con contenido
	 * predefinido para tests generales
	 * </ul>
	 * </ul>
	 * 
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
	 * <li>Valores por defecto, creando cabeceras y mensajes con contenido
	 * predefinido para tests generales
	 * </ul>
	 * </ul>
	 * 
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
