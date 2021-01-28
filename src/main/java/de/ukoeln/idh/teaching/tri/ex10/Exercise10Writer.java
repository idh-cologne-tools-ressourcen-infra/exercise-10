package de.ukoeln.idh.teaching.tri.ex10;

import de.tudarmstadt.ukp.dkpro.core.api.ner.type.NamedEntity;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.dkpro.core.api.io.JCasFileWriter_ImplBase;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Exercise10Writer extends JCasFileWriter_ImplBase {

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		try {
			OutputStream os = getOutputStream(jcas, ".txt");
			OutputStreamWriter osWriter = new OutputStreamWriter(os);

			for(NamedEntity ne : jcas.select(NamedEntity.class)){

				List<Token> leftTokenList = jcas.select(Token.class).preceding(ne).asList();
				int leftTokensSize = leftTokenList.size();
				List<Token> rightTokenList = jcas.select(Token.class).following(ne).asList();
				int rightTokensSize = rightTokenList.size();

				// write 2 tokens before NE
				if(leftTokensSize >= 2){
					String item = leftTokenList.get(leftTokensSize-2).getCoveredText();
					if(!punctuationMatcher(item)){
						osWriter.write(item + " ");
					}

				}
				if(leftTokensSize >= 1){
					String item = leftTokenList.get(leftTokensSize-1).getCoveredText();
					if(!punctuationMatcher(item)){
						osWriter.write(item + " ");
					}

				}
				// write NE
				osWriter.write(ne.getCoveredText() + " ");

				// write 2 tokens after NE
				if(rightTokensSize >= 1){
					String item = rightTokenList.get(0).getCoveredText();
					if(!punctuationMatcher(item)){
						osWriter.write(item + " ");
					}

				}
				if(rightTokensSize >= 2){
					String item = rightTokenList.get(1).getCoveredText();
					if(!punctuationMatcher(item)){
						osWriter.write(item + "\n");
					}

				}


			}

			osWriter.flush();
			osWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	/**
	 * Matches punctuation tokens
	 * @param item
	 * @return a boolean if punctuation mark was found
	 */
	private boolean punctuationMatcher(String item){
		Pattern p = Pattern.compile("[<>\":.,!?()/\\-]");
		Matcher m = p.matcher(item);
		return m.find();
	}

}
