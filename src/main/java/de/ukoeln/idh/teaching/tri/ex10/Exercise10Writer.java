package de.ukoeln.idh.teaching.tri.ex10;

import de.tudarmstadt.ukp.dkpro.core.api.ner.type.NamedEntity;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Sentence;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.dkpro.core.api.io.JCasFileWriter_ImplBase;

import java.util.LinkedList;
import java.util.List;


public class Exercise10Writer extends JCasFileWriter_ImplBase {
	List<Annotation> items = new LinkedList<Annotation>();

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		for(Sentence sentence : jcas.select(Sentence.class)){
			for (Annotation a : jcas.select(Annotation.class).coveredBy(sentence)){
				items.add(a);
			}
		}
		

	}

}
