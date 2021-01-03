package gal.udc.fic.vvs.email;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import etm.core.configuration.BasicEtmConfigurator;
import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.renderer.SimpleTextRenderer;

/**
 * Clase auxiliar para realizar los tests de JETM, no funcionales dinamicos de
 * caja negra.
 *
 */
public abstract class TestSetupGeneral {

	public static EtmMonitor monitor = null;

	@BeforeClass
	public static void setUpBeforeAll() {
		BasicEtmConfigurator.configure();
		monitor = EtmManager.getEtmMonitor();
		monitor.start();
	}

	@AfterClass
	public static void tearDownAfterAll() {
		monitor.render(new SimpleTextRenderer());
		monitor.stop();
	}

}
