package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

@RunWith(JUnitQuickcheck.class)
public class AudioTestPBT {

	/**
	 * Test unitario basado en propiedades, del método obtenerNombre, de la clase
	 * Audio.
	 * 
	 * <p>
	 * 
	 * Obtiene el nombre del Audio
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
	 * @param randomNombre    nombre del Audio
	 * @param randomContenido contenido del Audio
	 */
	@Property
	public void obtenerNombreTest(String randomNombre, String randomContenido) {

		Archivo a = new Audio(randomNombre, randomContenido);

		assertEquals(randomNombre, a.obtenerNombre());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerContenido, de la clase
	 * Audio.
	 * 
	 * <p>
	 * 
	 * Obtiene el contenido del Audio
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
	 * @param randomNombre    nombre del Audio
	 * @param randomContenido contenido del Audio
	 */
	@Property
	public void obtenerContenidoTest(String randomNombre, String randomContenido) {

		Archivo a = new Audio(randomNombre, randomContenido);

		assertEquals(randomContenido, a.obtenerContenido());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerTamaño, de la clase
	 * Audio.
	 * 
	 * <p>
	 * 
	 * Obtiene el tamaño del contenido del Audio
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
	 * @param randomNombre    nombre del Audio
	 * @param randomContenido contenido del Audio
	 */
	@Property
	public void obtenerTamañoTest(String randomNombre, String randomContenido) {

		Archivo a = new Audio(randomNombre, randomContenido);

		assertEquals(randomContenido.length(), a.obtenerTamaño());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerPreVisualizacion, de
	 * la clase Audio.
	 * 
	 * <p>
	 * 
	 * Obtiene un string con la información general del audio en un formato
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
	 * @param randomNombre    nombre del Audio
	 * @param randomContenido contenido del Audio
	 */
	@Property
	public void obtenerPreVisualizacionTest(String randomNombre, String randomContenido) {

		Archivo a = new Audio(randomNombre, randomContenido);

		assertEquals(obtenerPreVisualizacion(a), a.obtenerPreVisualizacion());
	}

	/**
	 * Método auxiliar para obtener la previsualización
	 */
	private String obtenerPreVisualizacion(Archivo archivo) {
		return archivo.obtenerNombre() + "(" + archivo.obtenerTamaño() + " bytes, " + archivo.obtenerMimeType() + ")";
	}

}
