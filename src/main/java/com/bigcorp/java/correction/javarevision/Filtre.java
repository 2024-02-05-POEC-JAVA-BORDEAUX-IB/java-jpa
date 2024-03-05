package com.bigcorp.java.correction.javarevision;

import java.util.function.Predicate;

public class Filtre implements Predicate<String> {

	@Override
	public boolean test(String s) {
		if (s.length() > 5) {
			return true;
		} else {
			return false;
		}
	}

}
