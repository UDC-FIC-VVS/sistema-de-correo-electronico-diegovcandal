package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class DelegadoTest {

	private static final String NOMBRE_ARCHIVADOR = "Archivador Nombre Test";
	private static final String NOMBRE_ARCHIVADOR_DELEGADO = "Archivador Delegado Nombre Test";
	private static final int ESPACIO_ARCHIVADOR = 100;
	private static final int ESPACIO_ARCHIVADOR_DELEGADO = 500;
	private static final int ESPACIO_ARCHIVADOR_INSUFICIENTE = -1;
	private static final String NOMBRE_MENSAJE = "Mensaje Nombre Test";
	private static final String CONTENIDO_MENSAJE = "Contenido de Mensaje Test";

	/**
	 * Test unitario, del método almacenarCorreo, de la clase Delegado.
	 * 
	 * <p>
	 * 
	 * Añade un mail correctamente al Archivador decorado vacio asignado al Delegado
	 * y con el espacio justo para aceptarlo
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

		DecoradorArchivador da = new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR));
		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		assertTrue(da.almacenarCorreo(c));
	}

	/**
	 * Test unitario, del método almacenarCorreo, de la clase Delegado.
	 * 
	 * <p>
	 * 
	 * Añade un mail al Archivador decorado sin el espacio suficiente asignado al
	 * Delegado, sin un Archivador asignado como delegado
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

		DecoradorArchivador da = new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR_INSUFICIENTE));
		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		assertThrows(NullPointerException.class, () -> da.almacenarCorreo(c));
	}

	/**
	 * Test unitario, del método almacenarCorreo, de la clase Delegado.
	 * 
	 * <p>
	 * 
	 * Añade un mail al Archivador decorado sin el espacio suficiente asignado al
	 * Delegado, con un delegado asignado con el espacio justo para aceptarlo
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores frontera, el tamaño del mensaje es el maximo para poder ser
	 * almacenado en el Delegado
	 * </ul>
	 * </ul>
	 */
	@Test
	public void almacenarCorreoSinEspacioConDelegadoTest() {

		DecoradorArchivador da = new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR_INSUFICIENTE));
		da.establecerDelegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DELEGADO, CONTENIDO_MENSAJE.length() + 1));

		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE, CONTENIDO_MENSAJE));

		assertTrue(da.almacenarCorreo(c));
	}

}
