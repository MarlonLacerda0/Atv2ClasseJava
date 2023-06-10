package a1c2;
import java.util.Scanner;
/*
 *  Autor: Marlon Lacerda de Oliveira
 * 	Data:  19/05/2023
 * 	Avalicao1, C2 LPII 
 *	
 * */
public class UsaConta {
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		Conta [] vetor = new Conta[5];
		int menu = 0;
		preencher(vetor);
		
		do{
			System.out.println("            MENU");
			System.out.println("Escolha uma das opcoes:");
			System.out.println("1-Mostrar saldo\n2-Depositar\n3-Sacar\n4-Sair");
			menu = input.nextInt();
			switch(menu){
			case 1:
				mostraSaldo(vetor);
				break;
			case 2:
				depositar(vetor);	
				break;
			case 3:
				sacar(vetor);
				break;
			case 4:
				System.out.println("VOCE SAIU\nFIM DO PROGRAMA");
				break;
			default:
				System.out.println("OPCAO INVALIDA");
			}
		}while(menu!=4);	

	}	
	//preenche o vetor
	public static void preencher(Conta[] vetor) {
		int numero;
		String titular;
		double saldo;
		for(int i=0; i<vetor.length; i++){
			System.out.println("Entre com numero da conta: ");
			numero = input.nextInt();
			System.out.println("Entre com nome do titular da conta: ");
			titular = input.next();
			System.out.println("Entre com saldo da conta: ");
			saldo = input.nextDouble();
			vetor[i] = new Conta(numero,titular,saldo);			
		}		
	}	
	//mostra o saldo
	public static void mostraSaldo(Conta[] vetor) {
		int numero;
		System.out.println("Qual numero da conta?");
		numero = input.nextInt();
		for(int i=0; i<vetor.length; i++){
			if(vetor[i].getNumero()==numero){
				System.out.println(vetor[i].toString()+"\n");
				return;
			}			
		}
		System.out.println("CONTA INEXISTENTE\n");
	}	
	//deposita na conta
	public static void depositar(Conta[] vetor) {
		int numero;
		double depositado;
		System.out.println("Qual numero da conta?");
		numero = input.nextInt();
		for(int i=0; i<vetor.length; i++){
			if(vetor[i].getNumero()==numero){
				System.out.println("Entre com valor do deposito:");
				depositado = input.nextDouble();
				vetor[i].deposito(depositado);
				System.out.println("Novo Saldo: "+vetor[i].getSaldo()+"\n");
				return;
			}			
		}		
		System.out.println("CONTA INEXISTENTE\n");
	}	
	//Sacar da conta
	public static void sacar(Conta[] vetor) {
		int numero;
		double saque;
		System.out.println("Qual numero da conta?");
		numero = input.nextInt();		
		for(int i=0; i<vetor.length; i++){
			if(vetor[i].getNumero()==numero){
				System.out.println("Valor de saque:");
				saque = input.nextDouble();
				if(vetor[i].sacar(saque) == true) {					
					System.out.println("Novo Saldo:"+vetor[i].getSaldo());
					return;
				}
				else {
					System.out.println("SALDO INSUFICIENTE");
					return;
				}
			}			
		}
		System.out.println("CONTA INEXISTENTE\n");
	}	
}
