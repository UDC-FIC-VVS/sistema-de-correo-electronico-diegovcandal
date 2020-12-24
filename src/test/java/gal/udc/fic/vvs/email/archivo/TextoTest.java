package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TextoTest {

	private static final String NOMBRE_TEXTO = "Texto Nombre Test";
	private static final String CONTENIDO_TEXTO = "Contenido del Texto Test";
	private static final String MIME_TYPE = "text/plain";

	/**
	 * Test unitario del método obtenerMimeType, de la clase Texto.
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

		Archivo a = new Texto(NOMBRE_TEXTO, CONTENIDO_TEXTO);

		assertEquals(MIME_TYPE, a.obtenerMimeType());
	}

}
