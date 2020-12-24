package gal.udc.fic.vvs.email.archivador;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;

@RunWith(JUnitQuickcheck.class)
public class LogTestPBT {

	private static final String NOMBRE_ARCHIVADOR_DEFECTO = "Archivador Nombre Test";
	private static final String NOMBRE_MENSAJE_DEFECTO = "Mensaje Nombre Test";

	private static final String LOG_MESSAGE = "Mensaxe de log";

	private final PrintStream standardOutput = System.out;
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	/**
	 * Test unitario basado en propiedades, del método obtenerDelegado, de la clase
	 * Log.
	 * 
	 * <p>
	 * 
	 * Se asigna un delegado al decorado, de la clase Delegado
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos no influyan en la prueba.
	 * <li>Categoria, numeros naturales, generados de forma aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomContenido       contenido del mensaje
	 * @param randomEspacio         espacio del Archivador
	 * @param randomEspacioDelegado espacio del Archivador Delegado
	 */
	@Property
	public void establecerObtenerDelegadoTest(int randomEspacio, int randomEspacioDelegado) {

		DecoradorArchivador da = new Log(new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio)));

		ArchivadorSimple as = new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacioDelegado);
		da.establecerDelegado(as);

		assertEquals(as, da.obtenerDelegado());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerDelegado, de la clase
	 * Log.
	 * 
	 * <p>
	 * 
	 * Se asigna un delegado al decorado, de la clase ArchivadorSimple
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos influyan en la prueba.
	 * <li>Categoria, numeros naturales, generados de forma aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomEspacio         espacio del Archivador
	 * @param randomEspacioDelegado espacio del Archivador Delegado
	 */
	@Property
	public void establecerObtenerDelegadoArchivadorSimpleTest(int randomEspacio, int randomEspacioDelegado) {

		DecoradorArchivador da = new Log(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio));
		ArchivadorSimple as = new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacioDelegado);

		da.establecerDelegado(as);

		assertEquals(null, da.obtenerDelegado());
	}

	/**
	 * Test unitario basado en propiedades, del método almacenarCorreoTest, de la
	 * clase Log.
	 * 
	 * <p>
	 * 
	 * Añade un mail correctamente al Archivador decorado vacio asignado al Log, e
	 * imprimiendo un mensaje de log.
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos influyan en la prueba.
	 * <li>Categoria, strings de cualquier longitud no nulos, generados de forma
	 * aleatoria.
	 * <li>Categoria, numeros naturales, generados de forma aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomEspacio   espacio del Archivador
	 * @param randomContenido contenido del Mensaje
	 */
	@Property
	public void almacenarCorreoTest(int randomEspacio, String randomContenido) {

		assumeThat(randomContenido.length(), lessThan(randomEspacio));

		DecoradorArchivador da = new Log(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio));
		Correo c = new Mensaje(new Texto(NOMBRE_ARCHIVADOR_DEFECTO, randomContenido));

		assertTrue(da.almacenarCorreo(c));

	}

	/**
	 * Test unitario basado en propiedades, del método almacenarCorreoTest, de la
	 * clase Log.
	 * 
	 * <p>
	 * 
	 * Comprueba que el mensaje de log impreso es el esperado
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos influyan en la prueba.
	 * <li>Categoria, strings de cualquier longitud no nulos, generados de forma
	 * aleatoria.
	 * <li>Categoria, numeros naturales, generados de forma aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomEspacio   espacio del Archivador
	 * @param randomContenido contenido del Mensaje
	 */
	@Property
	public void almacenarCorreoTestMensajeLogCorrecto(int randomEspacio, String randomContenido) {

		System.setOut(new PrintStream(outputStream));

		DecoradorArchivador da = new Log(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio));
		Correo c = new Mensaje(new Texto(NOMBRE_ARCHIVADOR_DEFECTO, randomContenido));
		da.almacenarCorreo(c);

		assertEquals(LOG_MESSAGE, outputStream.toString().trim());

		System.setOut(standardOutput);

	}

	/**
	 * Test unitario basado en propiedades, del método almacenarCorreoTest, de la
	 * clase Log.
	 * 
	 * <p>
	 * 
	 * Añade un mail correctamente al Archivador decorado vacio asignado al Log, e
	 * imprimiendo un mensaje de log.
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos influyan en la prueba.
	 * <li>Categoria, strings de cualquier longitud no nulos, generados de forma
	 * aleatoria.
	 * <li>Categoria, numeros naturales, generados de forma aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomEspacio   espacio del Archivador
	 * @param randomContenido contenido del Mensaje
	 */
	@Property
	public void almacenarCorreoSinEspacioTest(int randomEspacio, String randomContenido) {

		assumeThat(randomContenido.length(), greaterThan(randomEspacio));

		DecoradorArchivador da = new Log(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio));
		Correo c = new Mensaje(new Texto(NOMBRE_ARCHIVADOR_DEFECTO, randomContenido));

		assertFalse(da.almacenarCorreo(c));

	}

	/**
	 * Test unitario basado en propiedades, del método obtenerNombre, de la clase
	 * Log.
	 * 
	 * <p>
	 * 
	 * Comprueba que el nombre obtenido es el esperado.
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Categoria, strings de cualquier longitud no nulos, generados de forma
	 * aleatoria.
	 * <li>Categoria, numeros naturales, generados de forma aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomNombre  nombre del Archivador
	 * @param randomEspacio espacio del Archivador
	 */
	@Property
	public void obtenerNombreTest(String randomNombre, int randomEspacio) {

		DecoradorArchivador da = new Log(new ArchivadorSimple(randomNombre, randomEspacio));
		assertEquals(randomNombre, da.obtenerNombre());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerEspacioTotal, de la
	 * clase Log.
	 * 
	 * <p>
	 * 
	 * Obtiene el espacio total del Archivador decorado asignado a Log
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos influyan en la prueba.
	 * <li>Categoria, numeros naturales, generados de forma aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomEspacio espacio del Archivador
	 */
	@Property
	public void obtenerEspacioTotalDecoradoTest(int randomEspacio) {

		DecoradorArchivador da = new Log(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio));

		assertEquals(randomEspacio, da.obtenerEspacioTotal());

	}

	/**
	 * Test unitario basado en propiedades, del método obtenerEspacioTotal, de la
	 * clase Log.
	 * 
	 * <p>
	 * 
	 * Obtiene el espacio total del Archivador asignado a Log
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos influyan en la prueba.
	 * <li>Categoria, strings de cualquier longitud no nulos, generados de forma
	 * aleatoria.
	 * <li>Categoria, numeros naturales, generados de forma aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomEspacio   espacio del Archivador
	 * @param randomContenido contenido del Mensaje
	 */
	@Property
	public void obtenerEspacioTotalDespuesDeAlmacenarTest(int randomEspacio, String randomContenido) {

		DecoradorArchivador da = new Log(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio));
		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE_DEFECTO, randomContenido));

		da.almacenarCorreo(c);

		assertEquals(randomEspacio, da.obtenerEspacioTotal());

	}

	/**
	 * Test unitario basado en propiedades, del método obtenerEspacioDisponible, de
	 * la clase Log.
	 * 
	 * <p>
	 * 
	 * Obtiene el espacio disponible del Archivador asignado a Log
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos influyan en la prueba.
	 * <li>Categoria, numeros naturales, generados de forma aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomEspacio espacio del Archivador
	 */
	@Property
	public void obtenerEspacioDisponibleTest(int randomEspacio) {

		DecoradorArchivador da = new Log(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio));

		assertEquals(randomEspacio, da.obtenerEspacioDisponible());

	}

	/**
	 * Test unitario basado en propiedades, del método obtenerEspacioDisponible, de
	 * la clase Log.
	 * 
	 * <p>
	 * 
	 * Obtiene el espacio disponible del Archivador asignado a Log despues de añadir
	 * un correo correctamente
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos influyan en la prueba.
	 * <li>Categoria, strings de cualquier longitud no nulos, generados de forma
	 * aleatoria.
	 * <li>Categoria, numeros naturales, generados de forma aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomEspacio   espacio del Archivador
	 * @param randomContenido contenido del Mensaje
	 */
	@Property
	public void obtenerEspacioDisponibleDespuesDeAlmacenarTest(int randomEspacio, String randomContenido) {

		assumeThat(randomContenido.length(), lessThan(randomEspacio));

		DecoradorArchivador da = new Log(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio));
		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE_DEFECTO, randomContenido));

		da.almacenarCorreo(c);

		assertEquals(randomEspacio - c.obtenerTamaño(), da.obtenerEspacioDisponible());

	}

	/**
	 * Test unitario basado en propiedades, del método obtenerEspacioDisponible, de
	 * la clase Log.
	 * 
	 * <p>
	 * 
	 * Obtiene el espacio disponible del Archivador asignado a Log despues de añadir
	 * un correo sin tener el espacio necesario
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos no influyan en la prueba.
	 * <li>Categoria, strings de cualquier longitud no nulos, generados de forma
	 * aleatoria.
	 * <li>Categoria, numeros naturales, generados de forma aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomEspacio         espacio del Archivador
	 * @param randomContenido       contenido del Mensaje
	 * @param randomEspacioDelegado espacio del Archivador Delegado
	 */
	@Property
	public void obtenerEspacioDisponibleDecoradoSinEspacioTest(int randomEspacio, String randomContenido,
			int randomEspacioDelegado) {

		assumeThat(randomContenido.length(), greaterThan(randomEspacio));

		DecoradorArchivador da = new Log(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio));
		da.establecerDelegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacioDelegado));

		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE_DEFECTO, randomContenido));

		da.almacenarCorreo(c);

		assertEquals(randomEspacio, da.obtenerEspacioDisponible());

	}

}
