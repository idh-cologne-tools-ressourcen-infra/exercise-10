package de.ukoeln.idh.teaching.tri.ex10;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.dkpro.core.api.io.JCasFileWriter_ImplBase;

import de.tudarmstadt.ukp.dkpro.core.api.ner.type.NamedEntity;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Sentence;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.tudarmstadt.ukp.dkpro.core.api.syntax.type.constituent.NP;
import edu.stanford.nlp.dcoref.Document;

public class Exercise10Writer extends JCasFileWriter_ImplBase {

	@Override //throws, wenn Problem während des processing auftritt
	public void process(JCas jcas) throws AnalysisEngineProcessException {

	for (Sentence sentence : JCasUtil.select(jcas, Sentence.class)) {
		//für jeden Token in dem Satz
		for (Token token : JCasUtil.selectCovered(jcas, Token.class, sentence)) {
			
		} // ToDo :  das mit den Tokens rausfinden
		for (NamedEntity ne : JCasUtil.selectCovered(jcas, NamedEntity.class, sentence)){
			System.out.println(token.getCoveredText(), ne.getCoveredText());
			
		}
	} 
	}
}
	


	//normale process Methode
//    /* all sentences */
//    for (Sentence sentence : JCasUtil.select(jcas, Sentence.class)) {
// 
//      /* all Noun Phrases within that sentence */
//      for (NP nounphrase : JCasUtil.selectCovered(jcas, NP.class, sentence)) {
// 
//        /* all Named Entities within that noun phrase */
//        for (NamedEntity ne : JCasUtil.selectCovered(jcas, NamedEntity.class, nounphrase)) {
//
//            System.out.printf("NP: '%s'\tNE: '%s'\n", nounphrase.getCoveredText(), ne.getCoveredText());
//
//        }
//      } 
//    } 
//  } 