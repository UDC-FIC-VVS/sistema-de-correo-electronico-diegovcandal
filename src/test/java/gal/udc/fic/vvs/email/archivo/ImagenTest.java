package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ImagenTest {

	private static final String NOMBRE_IMAGEN = "Imagen Nombre Test";
	private static final String CONTENIDO_IMAGEN = "Contenido de la Imagen Test";
	private static final String MIME_TYPE = "image/png";

	/**
	 * Test unitario del método obtenerMimeType, de la clase Imagen.
	 * 
	 * <p>
	 * 
	 * Obtiene el MimeType asociado a la clase
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos: Valores por defecto para casos donde
	 * estos no influyan en la prueba.
	 * </ul>
	 * 
	 */
	@Test()
	public void obtenerMimeTypeTest() {

		Archivo a = new Imagen(NOMBRE_IMAGEN, CONTENIDO_IMAGEN);

		assertEquals(MIME_TYPE, a.obtenerMimeType());
	}

}
