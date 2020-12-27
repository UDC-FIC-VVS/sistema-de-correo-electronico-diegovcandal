package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.generator.MensajeGenerator;

@RunWith(JUnitQuickcheck.class)
public class CabeceraTestPBT {

	private static final String NOMBRE_CARPETA_DEFECTO = "Carpeta Nombre Test";

	/**
	 * Test unitario basado en propiedades, del método obtenerTamaño, de la clase
	 * Cabecera.
	 * 
	 * <p>
	 * 
	 * Obtiene la suma del tamaño del mensaje y la cabecera
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Por categoria: mensajes con cualquier contenido generados de forma
	 * aleatoria.
	 * <li>Por categoria: strings de cualquier longitud no nulos, generados de forma
	 * aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomMensaje           mensaje base
	 * @param randomNombreCabecera    nombre de la cabecera
	 * @param randomContenidoCabecera contenido de la cabecera
	 * 
	 */
	@Property
	public void obtenerTamañoTest(@From(MensajeGenerator.class) Mensaje randomMensaje, String randomNombreCabecera,
			String randomContenidoCabecera) {

		Cabecera c = new Cabecera(randomMensaje, randomNombreCabecera, randomContenidoCabecera);

		assertEquals(randomMensaje.obtenerTamaño() + randomNombreCabecera.length() + randomContenidoCabecera.length(),
				c.obtenerTamaño());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerTamaño, de la clase
	 * Cabecera.
	 * 
	 * <p>
	 * 
	 * Para mas de una cabecera obtiene la suma del tamaño del mensaje y las
	 * cabeceras
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Por categoria: mensajes con cualquier contenido generados de forma
	 * aleatoria.
	 * <li>Por categoria: strings de cualquier longitud no nulos, generados de forma
	 * aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomMensaje           mensaje base
	 * @param randomNombreCabecera    nombre de la cabecera
	 * @param randomContenidoCabecera contenido de la cabecera
	 * 
	 */
	@Property
	public void obtenerTamañoCabeceraMultipleTest(@From(MensajeGenerator.class) Mensaje randomMensaje,
			String randomNombreCabecera, String randomContenidoCabecera) {

		Cabecera c = new Cabecera(randomMensaje, randomNombreCabecera, randomContenidoCabecera);
		Cabecera c2 = new Cabecera(c, randomNombreCabecera, randomContenidoCabecera);

		assertEquals(c.obtenerTamaño() + randomNombreCabecera.length() + randomContenidoCabecera.length(),
				c2.obtenerTamaño());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerVisualizacion, de la
	 * clase Cabecera.
	 * 
	 * <p>
	 * 
	 * Obtiene la visualizacion del mensaje y el archivo la cabecera
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Por categoria: mensajes con cualquier contenido generados de forma
	 * aleatoria.
	 * <li>Por categoria: strings de cualquier longitud no nulos, generados de forma
	 * aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomMensaje           mensaje base
	 * @param randomNombreCabecera    nombre de la cabecera
	 * @param randomContenidoCabecera contenido de la cabecera
	 * 
	 */
	@Property
	public void obtenerVisualizacionTest(@From(MensajeGenerator.class) Mensaje randomMensaje,
			String randomNombreCabecera, String randomContenidoCabecera) {

		Cabecera c = new Cabecera(randomMensaje, randomNombreCabecera, randomContenidoCabecera);

		assertEquals(
				randomNombreCabecera + ": " + randomContenidoCabecera + "\n" + randomMensaje.obtenerVisualizacion(),
				c.obtenerVisualizacion());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerVisualizacion, de la
	 * clase Cabecera.
	 * 
	 * <p>
	 * 
	 * Para mas de una cabecera obtiene la visualizacion del mensaje y el archivo
	 * las cabeceras
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Por categoria: mensajes con cualquier contenido generados de forma
	 * aleatoria.
	 * <li>Por categoria: strings de cualquier longitud no nulos, generados de forma
	 * aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomMensaje           mensaje base
	 * @param randomNombreCabecera    nombre de la cabecera
	 * @param randomContenidoCabecera contenido de la cabecera
	 * 
	 */
	@Property
	public void obtenerVisualizacionCabeceraMultipleTest(@From(MensajeGenerator.class) Mensaje randomMensaje,
			String randomNombreCabecera, String randomContenidoCabecera) {

		Cabecera c = new Cabecera(randomMensaje, randomNombreCabecera, randomContenidoCabecera);
		Cabecera c2 = new Cabecera(c, randomNombreCabecera, randomContenidoCabecera);

		assertEquals(randomNombreCabecera + ": " + randomContenidoCabecera + "\n" + c.obtenerVisualizacion(),
				c2.obtenerVisualizacion());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerPreVisualizacion, de
	 * la clase Cabecera.
	 * 
	 * <p>
	 * 
	 * Obtiene la previsualizacion del mensaje
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Por categoria: mensajes con cualquier contenido generados de forma
	 * aleatoria.
	 * <li>Por categoria: strings de cualquier longitud no nulos, generados de forma
	 * aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomMensaje           mensaje base
	 * @param randomNombreCabecera    nombre de la cabecera
	 * @param randomContenidoCabecera contenido de la cabecera
	 * 
	 */
	@Property
	public void obtenerPreVisualizacionTest(@From(MensajeGenerator.class) Mensaje randomMensaje,
			String randomNombreCabecera, String randomContenidoCabecera) {

		Cabecera c = new Cabecera(randomMensaje, randomNombreCabecera, randomContenidoCabecera);

		assertEquals(randomMensaje.obtenerPreVisualizacion(), c.obtenerPreVisualizacion());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerRuta, de la clase
	 * Cabecera.
	 * 
	 * <p>
	 * 
	 * Obtiene la ruta del mensaje
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Por categoria: mensajes con cualquier contenido generados de forma
	 * aleatoria.
	 * <li>Por categoria: strings de cualquier longitud no nulos, generados de forma
	 * aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomMensaje           mensaje base
	 * @param randomNombreCabecera    nombre de la cabecera
	 * @param randomContenidoCabecera contenido de la cabecera
	 * 
	 */
	@Property
	public void obtenerRutaTest(@From(MensajeGenerator.class) Mensaje randomMensaje, String randomNombreCabecera,
			String randomContenidoCabecera) {

		Cabecera c = new Cabecera(randomMensaje, randomNombreCabecera, randomContenidoCabecera);

		assertEquals(randomMensaje.obtenerRuta(), c.obtenerRuta());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerRuta, de la clase
	 * Cabecera.
	 * 
	 * <p>
	 * 
	 * Obtiene la ruta del mensaje con un padre asignado
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Por categoria: mensajes con cualquier contenido generados de forma
	 * aleatoria.
	 * <li>Por categoria: strings de cualquier longitud no nulos, generados de forma
	 * aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomMensaje           mensaje base
	 * @param randomNombreCabecera    nombre de la cabecera
	 * @param randomContenidoCabecera contenido de la cabecera
	 * 
	 */
	@Property
	public void obtenerRutaConPadreTest(@From(MensajeGenerator.class) Mensaje randomMensaje,
			String randomNombreCabecera, String randomContenidoCabecera) {

		Cabecera cab = new Cabecera(randomMensaje, randomNombreCabecera, randomContenidoCabecera);

		Carpeta c = new Carpeta(NOMBRE_CARPETA_DEFECTO);
		cab.establecerPadre(c);

		assertEquals(NOMBRE_CARPETA_DEFECTO + " > " + randomMensaje.obtenerPreVisualizacion(), cab.obtenerRuta());
	}
}
