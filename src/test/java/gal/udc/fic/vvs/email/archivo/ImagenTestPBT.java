package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

@RunWith(JUnitQuickcheck.class)
public class ImagenTestPBT {

	/**
	 * Test unitario basado en propiedades, del método obtenerMimeType, de la clase
	 * Imagen.
	 * 
	 * <p>
	 * 
	 * Obtiene el nombre de la Imagen
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos: Test basado en propiedades que genera
	 * dos parametros de tipo String aleatorios y no nulos.
	 * </ul>
	 * 
	 * @param randomNombre    nombre de la Imagen
	 * @param randomContenido contenido de la Imagen
	 */
	@Property
	public void obtenerNombreTest(String randomNombre, String randomContenido) {

		Archivo a = new Imagen(randomNombre, randomContenido);

		assertEquals(randomNombre, a.obtenerNombre());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerMimeType, de la clase
	 * Imagen.
	 * 
	 * <p>
	 * 
	 * Obtiene el contenido de la Imagen
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos: Test basado en propiedades que genera
	 * dos parametros de tipo String aleatorios y no nulos.
	 * </ul>
	 * 
	 * @param randomNombre    nombre de la Imagen
	 * @param randomContenido contenido de la Imagen
	 */
	@Property
	public void obtenerContenidoTest(String randomNombre, String randomContenido) {

		Archivo a = new Imagen(randomNombre, randomContenido);

		assertEquals(randomContenido, a.obtenerContenido());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerMimeType, de la clase
	 * Imagen.
	 * 
	 * <p>
	 * 
	 * Obtiene el tamaño del contenido de la Imagen
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos: Test basado en propiedades que genera
	 * dos parametros de tipo String aleatorios y no nulos.
	 * </ul>
	 * 
	 * @param randomNombre    nombre de la Imagen
	 * @param randomContenido contenido de la Imagen
	 */
	@Property
	public void obtenerTamañoTest(String randomNombre, String randomContenido) {

		Archivo a = new Imagen(randomNombre, randomContenido);

		assertEquals(randomContenido.length(), a.obtenerTamaño());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerMimeType, de la clase
	 * Imagen.
	 * 
	 * <p>
	 * 
	 * Obtiene un string con la información general de la Imagen en un formato
	 * determinado.
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos: Test basado en propiedades que genera
	 * dos parametros de tipo String aleatorios y no nulos.
	 * </ul>
	 * 
	 * @param randomNombre    nombre de la Imagen
	 * @param randomContenido contenido de la Imagen
	 */
	@Property
	public void obtenerPreVisualizacionTest(String randomNombre, String randomContenido) {

		Archivo a = new Imagen(randomNombre, randomContenido);

		assertEquals(obtenerPreVisualizacion(a), a.obtenerPreVisualizacion());
	}

	/**
	 * Método auxiliar para obtener la previsualización
	 */
	private String obtenerPreVisualizacion(Archivo archivo) {
		return archivo.obtenerNombre() + "(" + archivo.obtenerTamaño() + " bytes, " + archivo.obtenerMimeType() + ")";
	}
}
