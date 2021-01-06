package gal.udc.fic.vvs.archunit;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.fields;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

import org.junit.runner.RunWith;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = { "gal.udc.fic.vvs.email.archivador", "gal.udc.fic.vvs.email.archivo",
		"gal.udc.fic.vvs.email.correo" })
public class ArquitecturaGeneralTest {

	/**
	 * Test unitario, ArchRule
	 * 
	 * <p>
	 * 
	 * Comprueba que todos los atributos no static y final de las clases en los
	 * paquetes que se analizan son privados. Excluyendo clases de tests.
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario (ArchRule).
	 * <li>Categoria de la prueba: Test dinámico estructural de caja blanca.
	 * <li>Mecanismo de selección de datos: No hay ningun tipo de selección de datos
	 * </ul>
	 * </ul>
	 */
	@ArchTest
	public static final ArchRule todosLosAtributosNoStaticYFinalSonPrivados = fields()
			.that().areNotStatic().and().areNotFinal()
			.and().areDeclaredInClassesThat().haveNameNotMatching(".*Test.*")
			.should().bePrivate();

	/**
	 * Test unitario, ArchRule
	 * 
	 * <p>
	 * 
	 * Comprueba que todos los atributos publicos son static y final. Excluyendo
	 * clases de tests.
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario (ArchRule).
	 * <li>Categoria de la prueba: Test dinámico estructural de caja blanca.
	 * <li>Mecanismo de selección de datos: No hay ningun tipo de selección de datos
	 * </ul>
	 * </ul>
	 */
	@ArchTest
	public static final ArchRule atributosPublicosSonStaticYFinal = fields()
			.that().arePublic().and().areDeclaredInClassesThat().haveNameNotMatching(".*Test.*")
			.should().beStatic().andShould().beFinal();

	/**
	 * Test unitario, ArchRule
	 * 
	 * <p>
	 * 
	 * Comprueba que todos los atributos privados comienzan por el caracter '_'.
	 * Excluyendo clases de tests.
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario (ArchRule).
	 * <li>Categoria de la prueba: Test dinámico estructural de caja blanca.
	 * <li>Mecanismo de selección de datos: No hay ningun tipo de selección de datos
	 * </ul>
	 * </ul>
	 */
	@ArchTest
	public static final ArchRule atributosPrivadosSiguenCodeConventions = fields()
			.that().arePrivate().and().doNotHaveName("etmMonitor")
			.and().areDeclaredInClassesThat().haveNameNotMatching(".*Test.*")
			.should().haveNameStartingWith("_");

	/**
	 * Test unitario, ArchRule
	 * 
	 * <p>
	 * 
	 * Comprueba que todos los metodos relacionados con obtener la visualizacion
	 * devuelven un valor de tipo string. Excluyendo clases de tests.
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario (ArchRule).
	 * <li>Categoria de la prueba: Test dinámico estructural de caja blanca.
	 * <li>Mecanismo de selección de datos: No hay ningun tipo de selección de datos
	 * </ul>
	 * </ul>
	 */
	@ArchTest
	public static final ArchRule obtenerVisualizacionAndPreVisualizacionTipoRetornoCorrecto = methods()
			.that().haveName("obtenerPreVisualizacion").and().haveName("obtenerVisualizacion")
			.and().areDeclaredInClassesThat().haveNameNotMatching(".*Test.*")
			.should().haveRawReturnType(String.class);

	/**
	 * Test unitario, ArchRule
	 * 
	 * <p>
	 * 
	 * Comprueba que todos los metodos relacionados con obtener el tamaño devuelven
	 * un valor de tipo int. Excluyendo clases de tests.
	 * 
	 * <p>
	 * 
	 * <ul>
	 * <li>Nivel de la prueba: Test Unitario (ArchRule).
	 * <li>Categoria de la prueba: Test dinámico estructural de caja blanca.
	 * <li>Mecanismo de selección de datos: No hay ningun tipo de selección de datos
	 * </ul>
	 * </ul>
	 */
	@ArchTest
	public static final ArchRule obtenerTamañoTipoRetornoCorrecto = methods()
			.that().haveName("obtenerTamaño").and().areDeclaredInClassesThat().haveNameNotMatching(".*Test.*")
			.should().haveRawReturnType(int.class);

}
