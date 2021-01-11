package gal.udc.fic.vvs.email.archivador.integracion;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeThat;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.TestSetupGeneral;
import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;

@RunWith(JUnitQuickcheck.class)
public class ITArchivadorSimpleTestPBT extends TestSetupGeneral {

	private static final String NOMBRE_ARCHIVADOR_DEFECTO = "Archivador Nombre Test";
	private static final String NOMBRE_MENSAJE_DEFECTO = "Mensaje Nombre Test";

	/**
	 * Test de integración basado en propiedades, del método almacenarCorreoTest, de
	 * la clase ArchivadorSimple.
	 * 
	 * <p>
	 * 
	 * Añade un mail correctamente a un ArchivadorSimple cualquiera vacio
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
	 * @param randomEspacio   espacio del Archivador
	 * @param randomContenido contenido del Mensaje
	 */
	@Property
	public void almacenarCorreoTest(int randomEspacio, String randomContenido) {

		assumeThat(randomContenido.length(), lessThan(randomEspacio));

		ArchivadorSimple as = new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio);
		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE_DEFECTO, randomContenido));

		assertTrue(as.almacenarCorreo(c));
	}

	/**
	 * Test de integración basado en propiedades, del método almacenarCorreoTest, de
	 * la clase ArchivadorSimple.
	 * 
	 * <p>
	 * 
	 * Añade un mail a un ArchivadorSimple cualquiera sin el suficiente espacio
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
	 * @param randomEspacio   espacio del Archivador
	 * @param randomContenido contenido del Mensaje
	 */
	@Property
	public void almacenarCorreoSinEspacioTest(int randomEspacio, String randomContenido) {

		assumeThat(randomContenido.length(), greaterThan(randomEspacio));

		ArchivadorSimple as = new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio);
		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE_DEFECTO, randomContenido));

		assertFalse(as.almacenarCorreo(c));
	}

	/**
	 * Test de integración basado en propiedades, del método obtenerEspacioTotal, de
	 * la clase ArchivadorSimple.
	 * 
	 * <p>
	 * 
	 * Obtiene el espacio total de un ArchivadorSimple cualquiera despues de añadir
	 * un correo
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
	 * @param randomEspacio   espacio del Archivador
	 * @param randomContenido contenido del Mensaje
	 */
	@Property
	public void obtenerEspacioTotalDespuesDeAlmacenarTest(int randomEspacio, String randomContenido) {

		assumeThat(randomContenido.length(), lessThan(randomEspacio));

		ArchivadorSimple as = new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio);
		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE_DEFECTO, randomContenido));

		as.almacenarCorreo(c);

		assertEquals(randomEspacio, as.obtenerEspacioTotal());
	}

	/**
	 * Test de integración basado en propiedades, del método
	 * obtenerEspacioDisponible, de la clase ArchivadorSimple.
	 * 
	 * <p>
	 * 
	 * Obtiene el espacio disponible de un ArchivadorSimple cualquiera despues de
	 * añadir un correo correctamente
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
	 * @param randomEspacio   espacio del Archivador
	 * @param randomContenido contenido del Mensaje
	 */
	@Property
	public void obtenerEspacioDisponibleDespuesDeAlmacenarTest(int randomEspacio, String randomContenido) {

		assumeThat(randomContenido.length(), lessThan(randomEspacio));

		ArchivadorSimple as = new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio);
		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE_DEFECTO, randomContenido));

		as.almacenarCorreo(c);

		assertEquals(randomEspacio - c.obtenerTamaño(), as.obtenerEspacioDisponible());
	}

	/**
	 * Test de integración basado en propiedades, del método
	 * obtenerEspacioDisponible, de la clase ArchivadorSimple.
	 * 
	 * <p>
	 * 
	 * Obtiene el espacio disponible del ArchivadorSimple despues de añadir un
	 * correo sin tener el espacio necesario
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
	 * @param randomEspacio   espacio del Archivador
	 * @param randomContenido contenido del Mensaje
	 */
	@Property
	public void obtenerEspacioDisponibleSinEspacioTest(int randomEspacio, String randomContenido) {

		assumeThat(randomContenido.length(), greaterThan(randomEspacio));

		ArchivadorSimple as = new ArchivadorSimple(NOMBRE_ARCHIVADOR_DEFECTO, randomEspacio);
		Correo c = new Mensaje(new Texto(NOMBRE_MENSAJE_DEFECTO, randomContenido));

		as.almacenarCorreo(c);

		assertEquals(randomEspacio, as.obtenerEspacioDisponible());
	}

}
