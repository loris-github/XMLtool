package sectionGenerator.generatorInterface;

import java.io.Serializable;

public abstract class Bean<B extends Bean<B>> implements Comparable<B>,Cloneable, Serializable {
	
	private static final long serialVersionUID = 1L;

	@Override
	public abstract B clone();
	
	@Override
	public int compareTo(B b)
	{
		throw new UnsupportedOperationException();
	}
}
