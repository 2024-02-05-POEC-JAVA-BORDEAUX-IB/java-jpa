package com.bigcorp.java.correction;

import java.util.Scanner;

		// Classe principale
		public class ExerciceConditions {
			public static void main(String[] args) {
				// Récupération de deux variables a et b
				Scanner scannerClavier = new Scanner(System.in);
				System.out.println("Veuillez entrer un entier a");
				int a = scannerClavier.nextInt();
				scannerClavier.nextLine();
				System.out.println("Veuillez entrer un entier b");
				int b = scannerClavier.nextInt();
				scannerClavier.nextLine();
				System.out.println("Veuillez entrer un entier c");
				int c = scannerClavier.nextInt();
				scannerClavier.nextLine();

				// Chercher le maximum entre a et b (ne faîtes pas ça chez vous, il
				// y a beaucoup mieux en mode 'Programmation Orientée Objet')
				// et afficher le résultat

				// Chercher le maximum entre a,b et c
				// et afficher le résultat

				// Afficher si a est pair ou impair avec un switch

				// Afficher si a est pair ou impair avec une expression ternaire

				// Fermeture des ressources (il y a mieux pour ce faire, mais nous verrons cela
				// plus tard)
				scannerClavier.close();

	}

}
