package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.Vector;

import org.junit.Test;

import gal.udc.fic.vvs.email.TestSetupGeneral;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class ArchivadorSimpleTest extends TestSetupGeneral {

	private static final String NOMBRE_ARCHIVADOR = "Archivador Nombre Test";
	private static final String NOMBRE_MENSAJE = "Mensaje Nombre Test";
	private static final String CONTENIDO_MENSAJE = "Contenido de Mensaje Test";

	/**
	 * Test unitario, del método almacenarCorreo, de la clase ArchivadorSimple.
	 * 
	 * <p>
	 * 
	 * Añade un mail correctamente a un ArchivadorSimple vacio y con el espacio
	 * justo para aceptarlo
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores frontera, el tamaño del mensaje es el maximo para poder ser
	 * almacenado
	 * </ul>
	 * </ul>
	 */
	@Test
	public void almacenarCorreoEspacioExactoTest() {

		ArchivadorSimple as = new ArchivadorSimple(NOMBRE_ARCHIVADOR, CONTENIDO_MENSAJE.length() + 1);
		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		assertTrue(as.almacenarCorreo(c));
	}

	/**
	 * Test unitario, del método almacenarCorreo, de la clase ArchivadorSimple.
	 * 
	 * <p>
	 * 
	 * Añade un mail a un ArchivadorSimple sin el suficiente espacio.
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores frontera, el tamaño del mensaje es el minimo para no poder
	 * almacenarse
	 * </ul>
	 * </ul>
	 */
	@Test
	public void almacenarCorreoSinEspacioTest() {

		ArchivadorSimple as = new ArchivadorSimple(NOMBRE_ARCHIVADOR, CONTENIDO_MENSAJE.length());
		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		assertFalse(as.almacenarCorreo(c));
	}

	/**
	 * Test unitario, del método almacenarCorreo, de la clase ArchivadorSimple.
	 * 
	 * <p>
	 * 
	 * Añade un mail correctamente a un ArchivadorSimple vacio y comprueba que el
	 * Vector _correos se modifica correctamente
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores frontera, el tamaño del mensaje es el maximo para poder ser
	 * almacenado
	 * </ul>
	 * </ul>
	 * 
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@Test
	public void almacenarCorreoTamañoVectorExactoTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

		ArchivadorSimple as = new ArchivadorSimple(NOMBRE_ARCHIVADOR, CONTENIDO_MENSAJE.length() + 1);
		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		as.almacenarCorreo(c);

		Field privateCorreosField = ArchivadorSimple.class.getDeclaredField("_correos");

		privateCorreosField.setAccessible(true);

		Vector _correos = (Vector) privateCorreosField.get(as);

		assertEquals(1, _correos.size());
	}

}
