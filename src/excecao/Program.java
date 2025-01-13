package excecao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		method1();
		System.out.println("Fim do programa");
	}

	
	public static void method1() {
		System.out.println("Inicio metodo 1");
		method2();
		System.out.println("Fim metodo 1");
	}
	
	
	public static void method2() {

		Scanner sc = new Scanner(System.in);
		

		try {
			String[] vect = sc.nextLine().split(" ");
			int position = sc.nextInt();
			System.out.println(vect[position]);
		} catch (ArrayIndexOutOfBoundsException e) {
			// e.printStackTrace();
			System.out.println("Invalid position");
		} catch (InputMismatchException e) {
			System.out.println("Input error");
			e.printStackTrace();
		}

		System.out.println("fim do método 2");
		

		sc.close();
	}

}
