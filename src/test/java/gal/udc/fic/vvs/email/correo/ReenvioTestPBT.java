package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.generator.MensajeGenerator;

@RunWith(JUnitQuickcheck.class)
public class ReenvioTestPBT {

	private static final String NOMBRE_CARPETA_DEFECTO = "Carpeta Nombre Test";

	/**
	 * Test unitario basado en propiedades, del método obtenerTamaño, de la clase
	 * Reenvio.
	 * 
	 * <p>
	 * 
	 * Obtiene la suma del tamaño del mensaje y el correo reenviado
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Por categoria: mensajes con cualquier contenido generados de forma
	 * aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomMensaje          mensaje base
	 * @param randomMensajeReenviado mensaje reenviado
	 * 
	 */
	@Property
	public void obtenerTamañoTest(@From(MensajeGenerator.class) Mensaje randomMensaje,
			@From(MensajeGenerator.class) Mensaje randomMensajeReenviado) {

		Correo r = new Reenvio(randomMensaje, randomMensajeReenviado);
		assertEquals(randomMensaje.obtenerTamaño() + randomMensajeReenviado.obtenerTamaño(), r.obtenerTamaño());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerTamaño, de la clase
	 * Reenvio.
	 * 
	 * <p>
	 * 
	 * Para mas de un reenvio, obtiene la suma del tamaño del mensaje y los correos
	 * reenviados
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Por categoria: mensajes con cualquier contenido generados de forma
	 * aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomMensaje          mensaje base
	 * @param randomMensajeReenviado mensaje reenviado
	 * 
	 */
	@Property
	public void obtenerTamañoReenvioMultipleTest(@From(MensajeGenerator.class) Mensaje randomMensaje,
			@From(MensajeGenerator.class) Mensaje randomMensajeReenviado) {

		Correo r = new Reenvio(randomMensaje, randomMensajeReenviado);
		Correo r2 = new Reenvio(randomMensaje, r);

		assertEquals(randomMensaje.obtenerTamaño() + r.obtenerTamaño(), r2.obtenerTamaño());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerVisualizacion, de la
	 * clase Reenvio.
	 * 
	 * <p>
	 * 
	 * Obtiene la visualizacion del mensaje y el correo reenviado
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Por categoria: mensajes con cualquier contenido generados de forma
	 * aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomMensaje          mensaje base
	 * @param randomMensajeReenviado mensaje reenviado
	 * 
	 */
	@Property
	public void obtenerVisualizacionTest(@From(MensajeGenerator.class) Mensaje randomMensaje,
			@From(MensajeGenerator.class) Mensaje randomMensajeReenviado) {

		Correo r = new Reenvio(randomMensaje, randomMensajeReenviado);

		assertEquals(
				randomMensaje.obtenerVisualizacion() + "\n\n---- Correo reenviado ----\n\n"
						+ randomMensajeReenviado.obtenerVisualizacion() + "\n---- Fin correo reenviado ----",
				r.obtenerVisualizacion());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerVisualizacion, de la
	 * clase Reenvio.
	 * 
	 * <p>
	 * 
	 * Para mas de un reenvio, obtiene la visualizacion del mensaje y los correos
	 * reenviados
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Por categoria: mensajes con cualquier contenido generados de forma
	 * aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomMensaje          mensaje base
	 * @param randomMensajeReenviado mensaje reenviado
	 * 
	 */
	@Property
	public void obtenerVisualizacionReenvioMultipleTest(@From(MensajeGenerator.class) Mensaje randomMensaje,
			@From(MensajeGenerator.class) Mensaje randomMensajeReenviado) {

		Correo r = new Reenvio(randomMensaje, randomMensajeReenviado);
		Correo r2 = new Reenvio(randomMensaje, r);

		assertEquals(randomMensaje.obtenerVisualizacion() + "\n\n---- Correo reenviado ----\n\n"
				+ r.obtenerVisualizacion() + "\n---- Fin correo reenviado ----", r2.obtenerVisualizacion());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerPreVisualizacion, de
	 * la clase Reenvio.
	 * 
	 * <p>
	 * 
	 * Obtiene la previsualizacion del mensaje
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Por categoria: mensajes con cualquier contenido generados de forma
	 * aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomMensaje          mensaje base
	 * @param randomMensajeReenviado mensaje reenviado
	 * 
	 */
	@Property
	public void obtenerPreVisualizacionTest(@From(MensajeGenerator.class) Mensaje randomMensaje,
			@From(MensajeGenerator.class) Mensaje randomMensajeReenviado) {

		Correo r = new Reenvio(randomMensaje, randomMensajeReenviado);

		assertEquals(randomMensaje.obtenerPreVisualizacion(), r.obtenerPreVisualizacion());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerRuta, de la clase
	 * Reenvio.
	 * 
	 * <p>
	 * 
	 * Obtiene la ruta del reenvio
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Por categoria: mensajes con cualquier contenido generados de forma
	 * aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomMensaje          mensaje base
	 * @param randomMensajeReenviado mensaje reenviado
	 * 
	 */
	@Property
	public void obtenerRutaTest(@From(MensajeGenerator.class) Mensaje randomMensaje,
			@From(MensajeGenerator.class) Mensaje randomMensajeReenviado) {

		Correo r = new Reenvio(randomMensaje, randomMensajeReenviado);

		assertEquals(randomMensaje.obtenerRuta(), r.obtenerRuta());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerRuta, de la clase
	 * Reenvio.
	 * 
	 * <p>
	 * 
	 * Obtiene la ruta del reenvio con un padre asignado
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y positivo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Por categoria: mensajes con cualquier contenido generados de forma
	 * aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomMensaje          mensaje base
	 * @param randomMensajeReenviado mensaje reenviado
	 * 
	 */
	@Property
	public void obtenerRutaConPadreTest(@From(MensajeGenerator.class) Mensaje randomMensaje,
			@From(MensajeGenerator.class) Mensaje randomMensajeReenviado) {

		Reenvio r = new Reenvio(randomMensaje, randomMensajeReenviado);

		Carpeta c = new Carpeta(NOMBRE_CARPETA_DEFECTO);
		r.establecerPadre(c);

		assertEquals(NOMBRE_CARPETA_DEFECTO + " > " + randomMensaje.obtenerPreVisualizacion(), r.obtenerRuta());
	}

}
