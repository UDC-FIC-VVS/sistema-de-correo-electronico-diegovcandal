package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Archivo;
import gal.udc.fic.vvs.generator.ArchivoGenerator;
import gal.udc.fic.vvs.generator.MensajeGenerator;

@RunWith(JUnitQuickcheck.class)
public class AdjuntoTestPBT {

	private static final String NOMBRE_CARPETA_DEFECTO = "Carpeta Nombre Test";

	/**
	 * Test unitario basado en propiedades, del método obtenerTamaño, de la clase
	 * Adjunto.
	 * 
	 * <p>
	 * 
	 * Obtiene la suma del tamaño del mensaje y el archivo adjunto
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
	 * <li>Por categoria: archivos con cualquier contenido generados de forma
	 * aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomMensaje mensaje base
	 * @param randomArchivo archivo adjunto
	 * 
	 */
	@Property
	public void obtenerTamañoTest(@From(MensajeGenerator.class) Mensaje randomMensaje,
			@From(ArchivoGenerator.class) Archivo randomArchivo) {

		Adjunto r = new Adjunto(randomMensaje, randomArchivo);

		assertEquals(randomMensaje.obtenerTamaño() + randomArchivo.obtenerTamaño(), r.obtenerTamaño());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerTamaño, de la clase
	 * Adjunto.
	 * 
	 * <p>
	 * 
	 * Para mas de un adjunto, obtiene la suma del tamaño del mensaje y los archivos
	 * adjuntados
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
	 * <li>Por categoria: archivos con cualquier contenido generados de forma
	 * aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomMensaje mensaje base
	 * @param randomArchivo archivo adjunto
	 * 
	 */
	@Property
	public void obtenerTamañoAdjuntoMultipleTest(@From(MensajeGenerator.class) Mensaje randomMensaje,
			@From(ArchivoGenerator.class) Archivo randomArchivo) {

		Adjunto r = new Adjunto(randomMensaje, randomArchivo);
		Adjunto r2 = new Adjunto(r, randomArchivo);

		assertEquals(r.obtenerTamaño() + randomArchivo.obtenerTamaño(), r2.obtenerTamaño());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerVisualizacion, de la
	 * clase Adjunto.
	 * 
	 * <p>
	 * 
	 * Obtiene la visualizacion del mensaje y el archivo adjunto
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
	 * <li>Por categoria: archivos con cualquier contenido generados de forma
	 * aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomMensaje mensaje base
	 * @param randomArchivo archivo adjunto
	 * 
	 */
	@Property
	public void obtenerVisualizacionTest(@From(MensajeGenerator.class) Mensaje randomMensaje,
			@From(ArchivoGenerator.class) Archivo randomArchivo) {

		Adjunto r = new Adjunto(randomMensaje, randomArchivo);

		assertEquals(randomMensaje.obtenerVisualizacion() + "\n\nAdxunto: " + randomArchivo.obtenerPreVisualizacion(),
				r.obtenerVisualizacion());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerVisualizacion, de la
	 * clase Adjunto.
	 * 
	 * <p>
	 * 
	 * Para mas de un adjunto, obtiene la visualizacion del mensaje y los archivos
	 * adjuntados
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
	 * <li>Por categoria: archivos con cualquier contenido generados de forma
	 * aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomMensaje mensaje base
	 * @param randomArchivo archivo adjunto
	 * 
	 */
	@Property
	public void obtenerVisualizacionAdjuntoMultipleTest(@From(MensajeGenerator.class) Mensaje randomMensaje,
			@From(ArchivoGenerator.class) Archivo randomArchivo) {

		Adjunto r = new Adjunto(randomMensaje, randomArchivo);
		Adjunto r2 = new Adjunto(r, randomArchivo);

		assertEquals(r.obtenerVisualizacion() + "\n\nAdxunto: " + randomArchivo.obtenerPreVisualizacion(),
				r2.obtenerVisualizacion());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerPreVisualizacion, de
	 * la clase Adjunto.
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
	 * <li>Por categoria: archivos con cualquier contenido generados de forma
	 * aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomMensaje mensaje base
	 * @param randomArchivo archivo adjunto
	 * 
	 */
	@Property
	public void obtenerPreVisualizacionTest(@From(MensajeGenerator.class) Mensaje randomMensaje,
			@From(ArchivoGenerator.class) Archivo randomArchivo) {

		Adjunto r = new Adjunto(randomMensaje, randomArchivo);

		assertEquals(randomMensaje.obtenerPreVisualizacion(), r.obtenerPreVisualizacion());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerRuta, de la clase
	 * Adjunto.
	 * 
	 * <p>
	 * 
	 * Obtiene la ruta del mensaje
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
	 * <li>Por categoria: archivos con cualquier contenido generados de forma
	 * aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomMensaje mensaje base
	 * @param randomArchivo archivo adjunto
	 * 
	 */
	@Property
	public void obtenerRutaTest(@From(MensajeGenerator.class) Mensaje randomMensaje,
			@From(ArchivoGenerator.class) Archivo randomArchivo) {

		Adjunto r = new Adjunto(randomMensaje, randomArchivo);

		assertEquals(randomMensaje.obtenerRuta(), r.obtenerRuta());
	}

	/**
	 * Test unitario basado en propiedades, del método obtenerRuta, de la clase
	 * Adjunto.
	 * 
	 * <p>
	 * 
	 * Obtiene la ruta del mensaje con un padre asignado
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
	 * <li>Por categoria: archivos con cualquier contenido generados de forma
	 * aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomMensaje mensaje base
	 * @param randomArchivo archivo adjunto
	 * 
	 */
	@Property
	public void obtenerRutaConPadreTest(@From(MensajeGenerator.class) Mensaje randomMensaje,
			@From(ArchivoGenerator.class) Archivo randomArchivo) {

		Adjunto r = new Adjunto(randomMensaje, randomArchivo);
		Carpeta c = new Carpeta(NOMBRE_CARPETA_DEFECTO);
		r.establecerPadre(c);

		assertEquals(NOMBRE_CARPETA_DEFECTO + " > " + randomMensaje.obtenerPreVisualizacion(), r.obtenerRuta());
	}

}
