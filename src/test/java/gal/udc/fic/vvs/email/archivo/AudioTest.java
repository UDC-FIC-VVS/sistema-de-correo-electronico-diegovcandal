package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AudioTest {

	private static final String NOMBRE_AUDIO = "Audio Nombre Test";
	private static final String CONTENIDO_AUDIO = "Contenido del Audio Test";
	private static final String MIME_TYPE = "audio/ogg";

	/**
	 * Test unitario del método obtenerMimeType, de la clase Audio.
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

		Archivo a = new Audio(NOMBRE_AUDIO, CONTENIDO_AUDIO);

		assertEquals(MIME_TYPE, a.obtenerMimeType());
	}

}
