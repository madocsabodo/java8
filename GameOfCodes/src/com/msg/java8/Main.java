package com.msg.java8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@FunctionalInterface
interface DragonTest {
	int test();
}

@FunctionalInterface
interface DragonTestInstance {
	String test();
}

@FunctionalInterface
interface SzamTeszt {
	boolean ellenorizSzam(int n);
}

@FunctionalInterface
interface TestZeroParams {
	void test();
}

@FunctionalInterface
interface SzamolInteger {
	int atalakit(int n);
}

@FunctionalInterface
interface SzamolDouble {
	double atalakit(double n);
}

@FunctionalInterface
interface Sign {
	String atalakit(int n);
}

@FunctionalInterface
interface SzovegKiegeszito {
	String feldolgoz(String sz1, String sz2);
}

public class Main {

	/*
	 * Peldak metodusrefernciakra
	 */
	public void metodusReferenciak() {
		// statikus metodusreferencia
		DragonTest staticMethodRef = Dragon::totalCount;
		System.out.println(staticMethodRef.test());

		// egyed metodusreferencia
		Dragon drogon = new Dragon("Drogon");
		DragonTestInstance instanceMethodReference = drogon::feed;
		System.out.println(instanceMethodReference.test());

		// egyed metodusreferencia osztalyon keresztul
		Dragon rhaegal = new Dragon("Rhaegal");
		Dragon viserion = new Dragon("Viserion");
		Stream.of(drogon, rhaegal, viserion).forEach(Dragon::dracarys);

		// konstruktor referencia hasznalata
		Stream.of("Drogon", "Rhaegal", "Viserion").map(Dragon::new).toArray(Dragon[]::new);
	}

	public void peldaTypeInference() {
		// Pelda type inference
		SzamolInteger negyzetInteger = (n) -> n * n;
		System.out.println(negyzetInteger.atalakit(5));

		SzamolDouble negyzetDouble = n -> n * n;
		System.out.println(negyzetDouble.atalakit(5.5));
	}

	boolean primTeszt(int n) {
		if (n % 2 == 0)
			return false;
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public void peldaLambdak() {

		TestZeroParams zeroParamLambda = () -> System.out.println("Zero parameters lambda");
		zeroParamLambda.test();

		SzamTeszt paros = (n) -> n % 2 == 0;

		SzamTeszt pozitiv = (n) -> n > 0;

		SzamTeszt prim = (n) -> {
			if (n % 2 == 0)
				return false;
			for (int i = 3; i * i <= n; i += 2) {
				if (n % i == 0)
					return false;
			}
			return true;
		};

		SzovegKiegeszito szovegK1 = (sz1, sz2) -> "You know nothing," + sz1 + sz2 + ".";
		System.out.println(szovegK1.feldolgoz("John", "Snow"));
	}

	public void peldakJavaUtilFunction() {

		Predicate<Integer> ellonorizPrimPredicate = n -> primTeszt(n);
		System.out.println(ellonorizPrimPredicate.test(13));

		UnaryOperator<Integer> negyzet = n -> n * n;
		System.out.println(negyzet.apply(13));

		BinaryOperator<Double> hatvany = (a, b) -> Math.pow(a, b);
		System.out.println(hatvany.apply(2.0, 5.0));
		
		Consumer<Integer> kiirat = n->System.out.println(n);
		kiirat.accept(5);
		
		//Supplier
		Supplier<Integer> veletlenParosErtek = () -> { 
					Random random = new Random();
					int n = random.nextInt(100);
					n = n%2==0? n : n+1;
					return n;
				    };
				    
		System.out.println(veletlenParosErtek.get());
	}
	
	public void streamMuveletek(){
		
		//filter
		
		int[] szamok = {-1,2,3,13,-15,20,29,34};

		Arrays.stream(szamok).filter((n) -> (n % 2) == 0);  // 2, 20, 34

		Arrays.stream(szamok).filter((n) -> (n > 0));           //  2, 3, 13, 20, 29, 34

		Arrays.stream(szamok).filter(n -> primTeszt(n));   //  2, 3, 13, 29 
		
		//map
		
		Arrays.stream(szamok).map( n -> n*n );				//  1,4,9,16,25

		Stream.of("1","2","3").map(Integer::valueOf); // 1, 2, 3

		String[] szoveg= {"a","b","c","d"};

		Arrays.stream(szoveg).map(n->n.toUpperCase());  	//  "A","B","C","D"

		Arrays.stream(szoveg).map(String::toUpperCase ); 	// "A","B","C","D"

		//sorted szoveg  { “is”, “winter”, “coming” }
		Stream<String> szovegStream = Stream.of( "is", "winter", "coming" );
		
		szovegStream.sorted(); // “coming”,“is”, “winter”
		
		szovegStream.sorted(Comparator.reverseOrder());// “winter”, “is”, “coming”
		
		szovegStream.sorted(Comparator.comparing(String::length)); 
	}
	
	public void streamLezaroMuveletek(){
		//collect
		int[] szamok = {-1,2,3,13,-15,20,29,34};

		IntStream szamLista = Arrays.stream(szamok);
		
		Stream.of(1,2,3,4,5).collect(Collectors.toList()) ;// egy Lista lesz az eredmeny
		
		Stream.of(1,2,3,4,5).collect(Collectors.toCollection(TreeSet::new)) ;// egy TreeSet lesz az eredmeny

		szamLista.reduce(0, (a, b) -> a + b);
		szamLista.sum();
		szamLista.average();
	}

	public static void main(String[] args) {

	}

}
