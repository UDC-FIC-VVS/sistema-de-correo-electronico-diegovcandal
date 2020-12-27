package gal.udc.fic.vvs.generator;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import gal.udc.fic.vvs.email.archivo.Archivo;
import gal.udc.fic.vvs.email.archivo.Imagen;

public final class ArchivoGenerator extends Generator<Archivo> {

	private final StringGenerator stringGenerator = new StringGenerator();

	public ArchivoGenerator() {
		super(Archivo.class);
	}

	@Override
	public Archivo generate(SourceOfRandomness random, GenerationStatus status) {
		return new Imagen(stringGenerator.generate(random, status), stringGenerator.generate(random, status));
	}

}
