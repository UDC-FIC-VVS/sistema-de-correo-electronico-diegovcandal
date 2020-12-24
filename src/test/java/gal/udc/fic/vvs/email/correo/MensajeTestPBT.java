package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Texto;

@RunWith(JUnitQuickcheck.class)
public class MensajeTestPBT {

	private static final String NOMBRE_MENSAJE_DEFECTO = "Mensaje Nombre Test";
	private final static int TAMAÑO_PREVISUALIZACION = 32;

	/**
	 * Test unitario basado en propiedades, del método obtenerTamaño, de la clase
	 * Mensaje.
	 * 
	 * <p>
	 * 
	 * Obtiene el tamaño del contenido de un mensaje con un contenido cualquiera.
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos no influyan en la prueba.
	 * <li>Por categoria: string de cualquier longitud no nulo, generado de forma
	 * aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomContenido contenido del mensaje
	 */
	@Property
	public void establecerObtenerLeidosTest(String randomContenido) {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE_DEFECTO, randomContenido));

		assertEquals(randomContenido.length(), m.obtenerTamaño());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerVisualizacion, de la
	 * clase Mensaje.
	 * 
	 * <p>
	 * 
	 * Obtiene la visualizacion general de un mensaje con un contenido cualquiera.
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos no influyan en la prueba.
	 * <li>Por categoria: string de cualquier longitud no nulo, generado de forma
	 * aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomContenido contenido del mensaje
	 */
	@Property
	public void obtenerVisualizacionTest(String randomContenido) {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE_DEFECTO, randomContenido));

		assertEquals(randomContenido, m.obtenerVisualizacion());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerPreVisualizacion, de
	 * la clase Mensaje.
	 * 
	 * <p>
	 * 
	 * Obtiene la visualizacion general de un mensaje, con un contenido cualquiera,
	 * cortandola si supera el tamaño limite
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos no influyan en la prueba.
	 * <li>Por categoria: string de cualquier longitud no nulo, generado de forma
	 * aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomContenido contenido del mensaje
	 */
	@Property
	public void obtenerPreVisualizacionTest(String randomContenido) {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE_DEFECTO, randomContenido));

		assertEquals(obtenerPreVisualizacion(randomContenido), m.obtenerPreVisualizacion());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerRuta, de la clase
	 * Mensaje.
	 * 
	 * <p>
	 * 
	 * Obtiene la ruta de un Mensaje sin un padre asignado
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos no influyan en la prueba.
	 * <li>Por categoria: string de cualquier longitud no nulo, generado de forma
	 * aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomContenido contenido del mensaje
	 */
	@Property
	public void obtenerRutaTest(String randomContenido) {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE_DEFECTO, randomContenido));

		assertEquals(obtenerPreVisualizacion(randomContenido), m.obtenerRuta());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerRuta, de la clase
	 * Mensaje.
	 * 
	 * <p>
	 * 
	 * Obtiene la ruta del Mensaje con un padre asignado
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos no influyan en la prueba.
	 * <li>Por categoria: strings de cualquier longitud no nulos, generados de forma
	 * aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomContenido     contenido del mensaje
	 * @param randomCarpetaNombre nombre de la carpeta padre
	 */
	@Property
	public void obtenerRutaConPadreTest(String randomContenido, String randomCarpetaNombre) {

		Mensaje m = new Mensaje(new Texto(NOMBRE_MENSAJE_DEFECTO, randomContenido));
		Carpeta c = new Carpeta(randomCarpetaNombre);
		m.establecerPadre(c);

		assertEquals(randomCarpetaNombre + " > " + obtenerPreVisualizacion(randomContenido), m.obtenerRuta());
	}

	/**
	 * Método auxiliar para obtener la previsualización
	 */
	private String obtenerPreVisualizacion(String contenido) {
		return contenido.substring(0, Math.min(contenido.length(), TAMAÑO_PREVISUALIZACION)) + "...";
	}

}
