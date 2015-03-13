package sectionGenerator.generatorInterface;

import tool.XMLBean;

public abstract class Sentence implements CharacterAndSymbol {

	protected abstract void appendContent(StringBuilder content,XMLBean xb);
}
