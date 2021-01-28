package de.ukoeln.idh.teaching.tri.ex10;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.dkpro.core.api.io.JCasFileWriter_ImplBase;

import de.tudarmstadt.ukp.dkpro.core.api.ner.type.NamedEntity;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;

public class Exercise10Writer extends JCasFileWriter_ImplBase {

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		OutputStream os;
		try {
			os = getOutputStream(jcas, ".txt");
			OutputStreamWriter osw = new OutputStreamWriter(os);

			for (NamedEntity ne : jcas.select(NamedEntity.class)) {

				List<Token> leftTokens = jcas.select(Token.class).preceding(ne).asList();
				int numberOfLeftTokens = leftTokens.size();
				if (numberOfLeftTokens >= 2) {
					osw.write(leftTokens.get(numberOfLeftTokens - 2).getCoveredText());
					osw.write(' ');
				}
				if (numberOfLeftTokens >= 1) {
					osw.write(leftTokens.get(numberOfLeftTokens - 1).getCoveredText());
					osw.write(' ');
				}
				osw.write(ne.getCoveredText());
				osw.write(' ');

				List<Token> rightTokens = jcas.select(Token.class).following(ne).asList();
				int numberOfRightTokens = rightTokens.size();
				if (numberOfRightTokens >= 1) {
					osw.write(rightTokens.get(0).getCoveredText());
					osw.write(' ');
				}
				if (numberOfRightTokens >= 2) {
					osw.write(rightTokens.get(1).getCoveredText());
					osw.write(' ');
				}
				osw.write("\n");
			}

			osw.flush();
			osw.close();
		} catch (

		IOException e) {
			throw new AnalysisEngineProcessException(e);
		}
	}

}
