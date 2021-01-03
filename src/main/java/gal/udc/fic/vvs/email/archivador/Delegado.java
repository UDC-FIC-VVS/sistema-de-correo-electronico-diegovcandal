package gal.udc.fic.vvs.email.archivador;

import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;
import gal.udc.fic.vvs.email.correo.Correo;

public class Delegado extends DecoradorArchivador {

	public Delegado(Archivador decorado) {
		super(decorado);
	}

	public boolean almacenarCorreo(Correo correo) {

		EtmPoint point = etmMonitor.createPoint(getClass().getName() + "#almacenarCorreo");

		if (!super.almacenarCorreo(correo)) {

			point.collect();

			return _delegado.almacenarCorreo(correo);
		}

		point.collect();

		return true;
	}

	public Archivador obtenerDelegado() {
		return _delegado;
	}

	public void establecerDelegado(Archivador archivador) {
		_delegado = archivador;
	}

	private Archivador _delegado;

	private static final EtmMonitor etmMonitor = EtmManager.getEtmMonitor();

}
