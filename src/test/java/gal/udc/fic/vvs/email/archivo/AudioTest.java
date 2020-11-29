package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AudioTest {

	private static final String NOMBRE_AUDIO = "Audio Nombre Test";
	private static final String CONTENIDO_AUDIO = "Contenido del Audio Test";
	private static final String MIME_TYPE = "audio/ogg";

	/**
	 * Test del método obtenerMimeType, de la clase Audio.
	 * 
	 * Obtiene el MimeType asociado a la clase
	 */
	@Test()
	public void obtenerMimeTypeTest() {

		Archivo a = new Audio(NOMBRE_AUDIO, CONTENIDO_AUDIO);

		assertEquals(MIME_TYPE, a.obtenerMimeType());
	}

	/**
	 * Test del método obtenerNombre, de la clase Audio.
	 * 
	 * Obtiene el nombre del Audio
	 */
	@Test()
	public void obtenerNombreTest() {

		Archivo a = new Audio(NOMBRE_AUDIO, CONTENIDO_AUDIO);

		assertEquals(NOMBRE_AUDIO, a.obtenerNombre());
	}

	/**
	 * Test del método obtenerContenido, de la clase Audio.
	 * 
	 * Obtiene el contenido del Audio
	 */
	@Test()
	public void obtenerContenidoTest() {

		Archivo a = new Audio(NOMBRE_AUDIO, CONTENIDO_AUDIO);

		assertEquals(CONTENIDO_AUDIO, a.obtenerContenido());
	}

	/**
	 * Test del método obtenerTamaño, de la clase Audio.
	 * 
	 * Obtiene el tamaño del contenido del Audio
	 */
	@Test()
	public void obtenerTamañoTest() {

		Archivo a = new Audio(NOMBRE_AUDIO, CONTENIDO_AUDIO);

		assertEquals(CONTENIDO_AUDIO.length(), a.obtenerTamaño());
	}

	/**
	 * Test del método obtenerPreVisualizacion, de la clase Audio.
	 * 
	 * Obtiene un string con la información general del audio
	 */
	@Test()
	public void obtenerPreVisualizacionTest() {

		Archivo a = new Audio(NOMBRE_AUDIO, CONTENIDO_AUDIO);

		assertEquals(obtenerPreVisualizacion(a), a.obtenerPreVisualizacion());
	}

	/**
	 * Método auxiliar para obtener la previsualización
	 */
	private String obtenerPreVisualizacion(Archivo archivo) {
		return archivo.obtenerNombre() + "(" + archivo.obtenerTamaño() + " bytes, " + archivo.obtenerMimeType() + ")";
	}

}
