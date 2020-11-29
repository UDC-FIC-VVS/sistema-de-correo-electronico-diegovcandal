package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ImagenTest {

	private static final String NOMBRE_IMAGEN = "Imagen Nombre Test";
	private static final String CONTENIDO_IMAGEN = "Contenido de la Imagen Test";
	private static final String MIME_TYPE = "image/png";

	/**
	 * Test del método obtenerMimeType, de la clase Imagen.
	 * 
	 * Obtiene el MimeType asociado a la clase
	 */
	@Test()
	public void obtenerMimeTypeTest() {

		Archivo a = new Imagen(NOMBRE_IMAGEN, CONTENIDO_IMAGEN);

		assertEquals(MIME_TYPE, a.obtenerMimeType());
	}

	/**
	 * Test del método obtenerNombre, de la clase Imagen.
	 * 
	 * Obtiene el nombre de la Imagen
	 */
	@Test()
	public void obtenerNombreTest() {

		Archivo a = new Imagen(NOMBRE_IMAGEN, CONTENIDO_IMAGEN);

		assertEquals(NOMBRE_IMAGEN, a.obtenerNombre());
	}

	/**
	 * Test del método obtenerContenido, de la clase Imagen.
	 * 
	 * Obtiene el contenido de la Imagen
	 */
	@Test()
	public void obtenerContenidoTest() {

		Archivo a = new Imagen(NOMBRE_IMAGEN, CONTENIDO_IMAGEN);

		assertEquals(CONTENIDO_IMAGEN, a.obtenerContenido());
	}

	/**
	 * Test del método obtenerTamaño, de la clase Imagen.
	 * 
	 * Obtiene el tamaño del contenido de la Imagen
	 */
	@Test()
	public void obtenerTamañoTest() {

		Archivo a = new Imagen(NOMBRE_IMAGEN, CONTENIDO_IMAGEN);

		assertEquals(CONTENIDO_IMAGEN.length(), a.obtenerTamaño());
	}

	/**
	 * Test del método obtenerPreVisualizacion, de la clase Imagen.
	 * 
	 * Obtiene un string con la información general de la Imagen
	 */
	@Test()
	public void obtenerPreVisualizacionTest() {

		Archivo a = new Imagen(NOMBRE_IMAGEN, CONTENIDO_IMAGEN);

		assertEquals(obtenerPreVisualizacion(a), a.obtenerPreVisualizacion());
	}

	/**
	 * Método auxiliar para obtener la previsualización
	 */
	private String obtenerPreVisualizacion(Archivo archivo) {
		return archivo.obtenerNombre() + "(" + archivo.obtenerTamaño() + " bytes, " + archivo.obtenerMimeType() + ")";
	}
}
