package de.ukoeln.idh.teaching.tri.ex10;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.SelectFSs;
import org.apache.uima.jcas.JCas;
import org.dkpro.core.api.io.JCasFileWriter_ImplBase;

import de.tudarmstadt.ukp.dkpro.core.api.ner.type.NamedEntity;

public class Exercise10Writer extends JCasFileWriter_ImplBase {

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		
//		von Aufgabe 9 
//		SelectFSs<NamedEntity> selector = jcas.select(NamedEntity.class);
//
//		for (NamedEntity PER : selector) {}
	}

}
