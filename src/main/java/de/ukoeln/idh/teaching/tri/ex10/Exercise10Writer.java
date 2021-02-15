package de.ukoeln.idh.teaching.tri.ex10;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.dkpro.core.api.io.JCasFileWriter_ImplBase;

import de.tudarmstadt.ukp.dkpro.core.api.ner.type.NamedEntity;

public class Exercise10Writer extends JCasFileWriter_ImplBase {

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		OutputStream os;
		try {
			os = getOutputStream(jcas, ".txt");
			OutputStreamWriter osw = new OutputStreamWriter(os);

			for (NamedEntity ne : jcas.select(NamedEntity.class)) {
				osw.write(ne.getCoveredText());
				osw.write("\n");
			}
			
			osw.flush();
			osw.close();
		} catch (
		
		IOException e) {
			
		}
	}

}
