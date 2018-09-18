import java.util.Scanner;

public class Jogatina {
	
	static Scanner sc;

	public static void main(String[] args) {
		

		int num1;
		int num2;
		sc = new Scanner(System.in);
			
		System.out.println("-------------TABULEIRO DA SORTE----------------");
		
		do {
		System.out.println("Escolha o primeiro numero: ");
		num1 = Integer.parseInt(sc.nextLine());
		if(num1 < 0 || num1 > 100) System.out.println("Numero invalido, digite um numero de 0 até 100!Boa sorte.");
		}while(num1 < 0 || num1 > 100);
		
		do {
		System.out.println("Escolha o Segundo numero: ");
		num2 = Integer.parseInt(sc.nextLine());
		if(num2 < 0 || num2 > 100) System.out.println("Numero invalido, digite um numero de 0 até 100!Boa sorte.");
		}while(num2 < 0 || num2 > 100);
		Tabuleiro tabu = new Tabuleiro(num1, num2);
		
		tabu.toString();
		
	}

}
