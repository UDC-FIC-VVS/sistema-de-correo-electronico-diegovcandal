package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TextoTest {

	private static final String NOMBRE_TEXTO = "Texto Nombre Test";
	private static final String CONTENIDO_TEXTO = "Contenido del Texto Test";
	private static final String MIME_TYPE = "text/plain";

	/**
	 * Test del método obtenerMimeType, de la clase Texto.
	 * 
	 * Obtiene el MimeType asociado a la clase
	 */
	@Test()
	public void obtenerMimeTypeTest() {

		Archivo a = new Texto(NOMBRE_TEXTO, CONTENIDO_TEXTO);

		assertEquals(MIME_TYPE, a.obtenerMimeType());
	}

	/**
	 * Test del método obtenerNombre, de la clase Texto.
	 * 
	 * Obtiene el nombre del Texto
	 */
	@Test()
	public void obtenerNombreTest() {

		Archivo a = new Texto(NOMBRE_TEXTO, CONTENIDO_TEXTO);

		assertEquals(NOMBRE_TEXTO, a.obtenerNombre());
	}

	/**
	 * Test del método obtenerContenido, de la clase Texto.
	 * 
	 * Obtiene el contenido del Texto
	 */
	@Test()
	public void obtenerContenidoTest() {

		Archivo a = new Texto(NOMBRE_TEXTO, CONTENIDO_TEXTO);

		assertEquals(CONTENIDO_TEXTO, a.obtenerContenido());
	}

	/**
	 * Test del método obtenerTamaño, de la clase Texto.
	 * 
	 * Obtiene el tamaño del contenido del Texto
	 */
	@Test()
	public void obtenerTamañoTest() {

		Archivo a = new Texto(NOMBRE_TEXTO, CONTENIDO_TEXTO);

		assertEquals(CONTENIDO_TEXTO.length(), a.obtenerTamaño());
	}

	/**
	 * Test del método obtenerPreVisualizacion, de la clase Texto.
	 * 
	 * Obtiene un string con la información general del Texto
	 */
	@Test()
	public void obtenerPreVisualizacionTest() {

		Archivo a = new Texto(NOMBRE_TEXTO, CONTENIDO_TEXTO);

		assertEquals(obtenerPreVisualizacion(a), a.obtenerPreVisualizacion());
	}

	/**
	 * Método auxiliar para obtener la previsualización
	 */
	private String obtenerPreVisualizacion(Archivo archivo) {
		return archivo.obtenerNombre() + "(" + archivo.obtenerTamaño() + " bytes, " + archivo.obtenerMimeType() + ")";
	}
}
