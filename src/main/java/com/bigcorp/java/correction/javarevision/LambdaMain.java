package com.bigcorp.java.correction.javarevision;

import java.util.ArrayList;
import java.util.List;

public class LambdaMain {

	public static void main(String[] args) {

		// Création d'une sonnette et utilisation de la sonnette directement
		Sonnette sonnette = new Sonnette();
		System.out.println(sonnette.pousse());

		// Utilisation de la sonnette en tant que Bouton
		Bouton boutonQuiEstEnFaitUneSonnette = new Sonnette();
		System.out.println(boutonQuiEstEnFaitUneSonnette.pousse());

		// Utilisation de la sonnette dans une méthode
		verifieLeBouton(sonnette);
		verifieLeBouton(new Gachette());

		// Utilisation d'une lambda directement dans la méthode
		// C'est comme si l'on avait créé une classe qui implémentait
		// l'interface Bouton, et que l'on avait défini sa méthode
		// avec ce qu'il y a dans la lambda

		// Ceci ne fonctionne que parce qu'il n'y a qu'une seule méthode
		// dans l'interface Bouton, qui est considérée comme "interface fonctionnelle"
		verifieLeBouton(() -> {
			return "Super bouton";
		});

		//Utilisation de lambdas avec Streams
		// Création d'une collection de Strings
		List<String> mesMots = new ArrayList<>();
		mesMots.add("Salut");
		mesMots.add("Coucou");
		mesMots.add("Adieu");

		// Affichage des mots avec plus de 5 caractères avec une boucle
		// et un if
		for (String monMot : mesMots) {
			if (monMot.length() > 5) {
				System.out.println("Ce mot est long : " + monMot);
			}
		}

		// Utilisation de lambda pour faire la meme chose
		// On utilise stream() qui propose des méthodes
		// qui sont grandes consommatrices d'interfaces fonctionnelles
		// comme Predicate, Consumer ...
		// on peut implémenter ces interfaces avec des lambdas
		mesMots.stream().filter((String s) -> {
			return s.length() > 5;
		}).forEach((String s) -> {
			System.out.println("1" + s);
		});

		// Il y a des possibilités de raccourcir les lambdas
		// dans certains cas
		mesMots.stream().filter(s -> s.length() > 5)
			.forEach(s -> System.out.println(s));

		//Voire d'utiliser des références de méthode 
		//pour raccourcir encore plus
		mesMots.stream().filter(s -> s.length() > 5)
			.forEach(System.out::println);

	}

	public static void verifieLeBouton(Bouton bouton) {
		System.out.println("Bonjour, je vais vérifier le bouton.");
		String resultat = bouton.pousse();
		if (resultat == null) {
			System.out.println("Attention, le bouton ne fait rien");
		} else {
			System.out.println("Le bouton a produit : " + resultat);
		}
		System.out.println("La vérification est faite");
	}

}
