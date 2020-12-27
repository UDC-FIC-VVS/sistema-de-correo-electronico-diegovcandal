package gal.udc.fic.vvs.generator;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;

public final class MensajeGenerator extends Generator<Mensaje> {

	private final StringGenerator stringGenerator = new StringGenerator();

	public MensajeGenerator() {
		super(Mensaje.class);
	}

	@Override
	public Mensaje generate(SourceOfRandomness random, GenerationStatus status) {
		return new Mensaje(
				new Texto(stringGenerator.generate(random, status), stringGenerator.generate(random, status)));
	}

}
