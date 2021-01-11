package gal.udc.fic.vvs.email.archivador.integracion;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeThat;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.TestSetupGeneral;
import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivador.DecoradorArchivador;
import gal.udc.fic.vvs.email.archivador.Delegado;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;

@RunWith(JUnitQuickcheck.class)
public class ITDelegadoTestPBT extends TestSetupGeneral {

	private static final String NOMBRE_ARCHIVADOR_DEFECTO = "Archivador Nombre Test";
	private static final String NOMBRE_MENSAJE_DEFECTO = "Mensaje Nombre Test";
	private static final int ESPACIO_ARCHIVADOR_DEFECTO = 100;

	/**
	 * Test de integración basado en propiedades, del método almacenarCorreo, de la
	 * clase Delegado.
	 * 
	 * <p>
	 * 
	 * Añade un mail correctamente a un Archivador decorado cualquiera vacio
	 * asignado a un Delegado
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test de Integración.
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
	 * @param randomContenido contenido del mensaje
	 * @param randomEspacio   espacio del Archivador
	 */
	@Property
	public void almacenarCorreoTest(String randomContenido, int randomEspacio) {

		assumeThat(randomContenido.length(), lessThan(randomEspacio));

		DecoradorArchivador da = new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio));
		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE_DEFECTO, randomContenido));

		assertTrue(da.almacenarCorreo(c));
	}

	/**
	 * Test de integración basado en propiedades, del método almacenarCorreo, de la
	 * clase Delegado.
	 * 
	 * <p>
	 * 
	 * Añade un mail a un Archivador decorado cualquiera sin el espacio suficiente
	 * asignado al Delegado, sin un Archivador asignado como delegado
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test de Integración.
	 * <li>Categoria de la prueba: Test funcional dinamico de caja negra y negativo.
	 * <li>Mecanismo de selección de datos:
	 * <ul>
	 * <li>Valores por defecto para casos donde estos no influyan en la prueba.
	 * <li>Categoria, strings de cualquier longitud no nulos, generados de forma
	 * aleatoria.
	 * <li>Categoria, numeros naturales, generados de forma aleatoria.
	 * </ul>
	 * </ul>
	 * 
	 * @param randomContenido contenido del mensaje
	 * @param randomEspacio   espacio del Archivador
	 */
	@Property
	public void almacenarCorreoSinEspacioTest(String randomContenido, int randomEspacio) {

		boolean exception_thrown = false;

		assumeThat(randomContenido.length(), greaterThan(randomEspacio));

		DecoradorArchivador da = new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio));
		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE_DEFECTO, randomContenido));

		try {
			da.almacenarCorreo(c);

		} catch (NullPointerException e) {
			exception_thrown = true;
		}

		assertTrue(exception_thrown);
		;
	}

	/**
	 * Test de integración basado en propiedades, del método almacenarCorreo, de la
	 * clase Delegado.
	 * 
	 * <p>
	 * 
	 * Añade un mail al Archivador decorado cualquiera sin el espacio suficiente
	 * asignado al Delegado, con un delegado asignado
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test de Integración.
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
	 * @param randomContenido       contenido del mensaje
	 * @param randomEspacio         espacio del Archivador
	 * @param randomEspacioDelegado espacio del Archivador Delegado
	 */
	@Property
	public void almacenarCorreoSinEspacioConDelegadoTest(String randomContenido, int randomEspacio,
			int randomEspacioDelegado) {

		assumeThat(randomContenido.length(), greaterThan(randomEspacio));
		assumeThat(randomContenido.length(), lessThan(randomEspacioDelegado));

		DecoradorArchivador da = new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio));
		da.establecerDelegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacioDelegado));
		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE_DEFECTO, randomContenido));

		assertTrue(da.almacenarCorreo(c));
	}

	/**
	 * Test de integración basado en propiedades, del método obtenerEspacioTotal, de
	 * la clase Delegado.
	 * 
	 * <p>
	 * 
	 * Obtiene el espacio total del Archivador delegado asignado a Delegado
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test de Integración.
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
	public void obtenerEspacioTotalDelegadoDespuesDeAlmacenarTest(int randomEspacio, String randomContenido,
			int randomEspacioDelegado) {

		DecoradorArchivador da = new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio));
		da.establecerDelegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacioDelegado));

		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE_DEFECTO, randomContenido));

		da.almacenarCorreo(c);

		assertEquals(randomEspacioDelegado, da.obtenerDelegado().obtenerEspacioTotal());
	}

	/**
	 * Test de integración basado en propiedades, del método
	 * obtenerEspacioDisponible, de la clase Delegado.
	 * 
	 * <p>
	 * 
	 * Obtiene el espacio disponible del Archivador decorado asignado a Delegado
	 * despues de añadir un correo correctamente
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test de Integración.
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
	public void obtenerEspacioDisponibleDecoradoDespuesDeAlmacenarTest(int randomEspacio, String randomContenido,
			int randomEspacioDelegado) {

		assumeThat(randomContenido.length(), lessThan(randomEspacio));

		DecoradorArchivador da = new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio));

		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE_DEFECTO, randomContenido));

		da.almacenarCorreo(c);

		assertEquals(randomEspacio - c.obtenerTamaño(), da.obtenerEspacioDisponible());
	}

	/**
	 * Test de integración basado en propiedades, del método
	 * obtenerEspacioDisponible, de la clase Delegado.
	 * 
	 * <p>
	 * 
	 * Obtiene el espacio disponible del Archivador decorado asignado a Delegado
	 * despues de añadir un correo sin tener el espacio necesario
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test de Integración.
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
		assumeThat(randomContenido.length(), lessThan(randomEspacioDelegado));

		DecoradorArchivador da = new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio));
		da.establecerDelegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacioDelegado));

		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE_DEFECTO, randomContenido));

		da.almacenarCorreo(c);

		assertEquals(randomEspacio, da.obtenerEspacioDisponible());
	}

	/**
	 * Test de integración basado en propiedades, del método
	 * obtenerEspacioDisponible, de la clase Delegado.
	 * 
	 * <p>
	 * 
	 * Obtiene el espacio disponible del Archivador delegado asignado a Delegado
	 * despues de añadir un correo correctamente al archivador decorado
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test de Integración.
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
	public void obtenerEspacioDisponibleDelegadoDespuesDeAlmacenarTest(int randomEspacio, String randomContenido,
			int randomEspacioDelegado) {

		assumeThat(randomContenido.length(), lessThan(randomEspacio));

		DecoradorArchivador da = new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio));
		da.establecerDelegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacioDelegado));

		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE_DEFECTO, randomContenido));

		da.almacenarCorreo(c);

		assertEquals(randomEspacioDelegado, da.obtenerDelegado().obtenerEspacioDisponible());
	}

	/**
	 * Test de integración basado en propiedades, del método
	 * obtenerEspacioDisponible, de la clase Delegado.
	 * 
	 * <p>
	 * 
	 * Obtiene el espacio disponible del Archivador delegado asignado a Delegado
	 * despues de añadir un correo al archivador decorado sin tener el espacio
	 * necesario
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test de Integración.
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
	public void obtenerEspacioDisponibleDelegadoSinEspacioTest(int randomEspacio, String randomContenido,
			int randomEspacioDelegado) {

		assumeThat(randomContenido.length(), greaterThan(randomEspacio));
		assumeThat(randomContenido.length(), lessThan(randomEspacioDelegado));

		DecoradorArchivador da = new Delegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio));
		da.establecerDelegado(new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacioDelegado));

		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE_DEFECTO, randomContenido));

		da.almacenarCorreo(c);

		assertEquals(randomEspacioDelegado - c.obtenerTamaño(), da.obtenerDelegado().obtenerEspacioDisponible());
	}

}
