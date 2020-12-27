package gal.udc.fic.vvs.email.correo;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeThat;

import java.util.List;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.generator.MensajeGenerator;

@RunWith(JUnitQuickcheck.class)
public class CarpetaLimitadaTestPBT {

	private static final String NOMBRE_CARPETA_DEFECTO = "Carpeta Nombre Test";
	private static final String NOMBRE_CARPETA_PADRE_DEFECTO = NOMBRE_CARPETA_DEFECTO + " Padre";

	/**
	 * Test unitario basado en propiedades, del método obtenerRuta, de la clase
	 * CarpetaLimitada.
	 * 
	 * <p>
	 * 
	 * Obtiene la ruta de la carpeta sin un padre asignado
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos no influyan en la prueba.
	 * <li>Por categoria: mensajes con cualquier contenido generados de forma
	 * aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomMensajes lista de mensajes
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void obtenerRutaTest(List<@From(MensajeGenerator.class) Mensaje> randomMensajes) throws OperacionInvalida {

		assumeThat(randomMensajes.size(), greaterThan(0));

		CarpetaLimitada c = new CarpetaLimitada(new Carpeta(NOMBRE_CARPETA_DEFECTO), randomMensajes.size());

		for (Mensaje mensaje : randomMensajes) {
			c.añadir(mensaje);
		}

		assertEquals(NOMBRE_CARPETA_DEFECTO + " (" + randomMensajes.size() + ")", c.obtenerRuta());

	}

	/**
	 * Test unitario basado en propiedades, del método obtenerRuta, de la clase
	 * CarpetaLimitada.
	 * 
	 * <p>
	 * 
	 * Obtiene la ruta la carpeta con un padre asignado
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos no influyan en la prueba.
	 * <li>Por categoria: mensajes con cualquier contenido generados de forma
	 * aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomMensajes      lista de mensajes
	 * @param randomMensajesPadre lista de mensajes de la carpeta padre
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void obtenerRutaConPadreTest(List<@From(MensajeGenerator.class) Mensaje> randomMensajes,
			List<@From(MensajeGenerator.class) Mensaje> randomMensajesPadre) throws OperacionInvalida {

		assumeThat(randomMensajes.size(), greaterThan(0));

		CarpetaLimitada c1 = new CarpetaLimitada(new Carpeta(NOMBRE_CARPETA_DEFECTO), randomMensajes.size());

		CarpetaLimitada c2 = new CarpetaLimitada(new Carpeta(NOMBRE_CARPETA_PADRE_DEFECTO), randomMensajesPadre.size());

		c2.añadir(c1);

		for (Mensaje mensaje : randomMensajes) {
			c1.añadir(mensaje);
		}

		for (Mensaje mensaje : randomMensajesPadre) {
			c2.añadir(mensaje);
		}

		assertEquals(NOMBRE_CARPETA_PADRE_DEFECTO + " (" + (randomMensajesPadre.size() + randomMensajes.size()) + ")"
				+ " > " + NOMBRE_CARPETA_DEFECTO + " (" + randomMensajes.size() + ")", c1.obtenerRuta());

	}

	/**
	 * Test unitario basado en propiedades, del método obtenerTamaño, de la clase
	 * CarpetaLimitada.
	 * 
	 * <p>
	 * 
	 * Obtiene el tamaño total de la carpeta y sus hijos
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos no influyan en la prueba.
	 * <li>Por categoria: mensajes con cualquier contenido generados de forma
	 * aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomMensajes lista de mensajes
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void obtenerTamañoTest(List<@From(MensajeGenerator.class) Mensaje> randomMensajes) throws OperacionInvalida {

		int tam = 0;
		CarpetaLimitada c = new CarpetaLimitada(new Carpeta(NOMBRE_CARPETA_DEFECTO), randomMensajes.size());

		for (Mensaje mensaje : randomMensajes) {
			c.añadir(mensaje);
			tam += mensaje.obtenerTamaño();
		}

		assertEquals(tam, c.obtenerTamaño());

	}

	/**
	 * Test unitario basado en propiedades, del método obtenerTamaño, de la clase
	 * CarpetaLimitada.
	 * 
	 * <p>
	 * 
	 * Obtiene el tamaño total de una carpeta con un hijo que es otra carpeta
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos no influyan en la prueba.
	 * <li>Por categoria: mensajes con cualquier contenido generados de forma
	 * aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomMensajes      lista de mensajes
	 * @param randomMensajesPadre lista de mensajes de la carpeta padre
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void obtenerTamañoCarpetaAnidadaTest(List<@From(MensajeGenerator.class) Mensaje> randomMensajes,
			List<@From(MensajeGenerator.class) Mensaje> randomMensajesPadre) throws OperacionInvalida {

		assumeThat(randomMensajes.size(), greaterThan(0));

		int tam1 = 0;
		CarpetaLimitada c1 = new CarpetaLimitada(new Carpeta(NOMBRE_CARPETA_DEFECTO), randomMensajes.size());

		int tam2 = 0;
		CarpetaLimitada c2 = new CarpetaLimitada(new Carpeta(NOMBRE_CARPETA_PADRE_DEFECTO), randomMensajesPadre.size());

		c2.añadir(c1);

		for (Mensaje mensaje : randomMensajes) {
			c1.añadir(mensaje);
			tam1 += mensaje.obtenerTamaño();
		}

		for (Mensaje mensaje : randomMensajesPadre) {
			c2.añadir(mensaje);
			tam2 += mensaje.obtenerTamaño();
		}

		assertEquals(tam1 + tam2, c2.obtenerTamaño());

	}

	/**
	 * Test unitario basado en propiedades, del método explorar, de la clase
	 * CarpetaLimitada.
	 * 
	 * <p>
	 * 
	 * Devuelve todos los hijos
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos no influyan en la prueba.
	 * <li>Por categoria: mensajes con cualquier contenido generados de forma
	 * aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomMensajes lista de mensajes
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void explorarTest(List<@From(MensajeGenerator.class) Mensaje> randomMensajes) throws OperacionInvalida {

		CarpetaLimitada c = new CarpetaLimitada(new Carpeta(NOMBRE_CARPETA_DEFECTO), randomMensajes.size());

		for (Mensaje mensaje : randomMensajes) {
			c.añadir(mensaje);
		}

		assertEquals(randomMensajes.size(), c.explorar().size());

	}

}
