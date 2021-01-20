# Exercise 10

This exercise is about using DKpro pipeline components and writing a new, parameterized output component.

## Step 1

Please clone this repository onto your local computer. On the command line, you would enter: `git clone https://github.com/idh-cologne-tools-ressourcen-infra/exercise-10`, and create a new branch using your UzK username as a name.

## Step 2

Inspect the code in `de.ukoeln.idh.teaching.tri.ex10.Exercise10Main`: It's a simple main function that establishes and runs a pipeline consisting of a collection reader, a tokenizer, a named entity tagger and the conll writer that we know from the last exercise. The repository also contains the same data set as last week.

Verify that the code runs as it is. It should produce output in `target`. The first sentence in file `reviewaaaa.txt.conll` should look like this:

```
I O
always O
wrote O
this O
series O
off O
as O
being O
a O
complete O
stink-fest O
because O
Jim B-PERSON
Belushi I-PERSON
was O
involved O
in O
it O
, O
and O
heavily O
. O
```

Please note the B-PERSON and I-PERSON marking in the second column. This indicates that the token "Jim" is the beginning of a named entity for a person, and "Belushi" is a token inside of a named entity for a person. Other tokens  are tagged as "O", indicating that they are outside of an annotation (this is called the [BIO scheme](https://en.wikipedia.org/wiki/Inside–outside–beginning_(tagging))).

## Step 3

You also find a class `Exercise10Writer` in the package. It inherits from `org.dkpro.core.api.io.JCasFileWriter_ImplBase`, but so far only contains an empty `process()` method. Add this component to the pipeline (even though it doesn't do anything right now).

## Step 4

You should now implement the `process()` method such that it generates a new plain text file for each document. This file should contain each named entity on a single line, together with a context of two tokens to the left and right. For instance, for the file `reviewaaaa.txt`, we want a document `reviewaaaa.nes.txt`, which contains 

```
stink-fest because Jim Belushi was involved
After a White Sox game ended
Belushi has all
...
```

If there are no two tokens to the left (or right) because of sentence boundaries, just omit them (see third line in the example above, in which the sentence starts with "Belushi").

## Step 5
Commit your program to the repository and push it to the repository.


## Useful links

- [Apache Maven](http://maven.apache.org)

- [Apache UIMA](https://uima.apache.org)
     - [Overview & Setup](https://uima.apache.org/d/uimaj-current/overview_and_setup.html)
     - [Tutorial & Developers Guide](https://uima.apache.org/d/uimaj-current/tutorials_and_users_guides.html)
     - [Tools Guide and Reference](https://uima.apache.org/d/uimaj-current/tools.html)
     - [References](https://uima.apache.org/d/uimaj-current/references.html)
- [UIMA Javadoc](https://javadoc.io/doc/org.apache.uima/uimaj-core/latest/index.html)
- [UIMAfit Javadoc](https://javadoc.io/doc/org.apache.uima/uimafit-core/latest/index.html)

- [DKPro core](https://dkpro.github.io/dkpro-core/)
- 