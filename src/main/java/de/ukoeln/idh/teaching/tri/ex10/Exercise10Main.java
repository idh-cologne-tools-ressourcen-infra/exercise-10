package de.ukoeln.idh.teaching.tri.ex10;

import java.io.IOException;

import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;
import org.apache.uima.resource.ResourceInitializationException;
import org.dkpro.core.io.conll.Conll2002Writer;
import org.dkpro.core.io.text.TextReader;
import org.dkpro.core.stanfordnlp.StanfordNamedEntityRecognizer;
import org.dkpro.core.tokit.BreakIteratorSegmenter;

public class Exercise10Main {

	public static void main(String[] args)
			throws ResourceInitializationException, AnalysisEngineProcessException, CollectionException, IOException {

		// initialize collection reader
		CollectionReaderDescription readerDescription = CollectionReaderFactory.createReaderDescription(
				TextReader.class, TextReader.PARAM_SOURCE_LOCATION, "src/main/resources/imdb/reviewaa*.txt",
				TextReader.PARAM_LANGUAGE, "en");

		// initialize tokenizer
		AnalysisEngineDescription tokenizer = AnalysisEngineFactory
				.createEngineDescription(BreakIteratorSegmenter.class);

		// named entity recognizer
		AnalysisEngineDescription neTagger = AnalysisEngineFactory
				.createEngineDescription(StanfordNamedEntityRecognizer.class);

		// initialize output writer
		AnalysisEngineDescription writer = AnalysisEngineFactory.createEngineDescription(Conll2002Writer.class,
				Conll2002Writer.PARAM_TARGET_LOCATION, "target", Conll2002Writer.PARAM_OVERWRITE, true);

		// initialize exercise10writer
		AnalysisEngineDescription NEWriter = AnalysisEngineFactory.createEngineDescription(Exercise10Writer.class, Exercise10Writer.PARAM_TARGET_LOCATION, "target", Exercise10Writer.PARAM_OVERWRITE, true);
		// run the pipeline
		SimplePipeline.runPipeline(readerDescription, tokenizer, neTagger, writer, NEWriter);
		System.out.println("finished");
	}

}
