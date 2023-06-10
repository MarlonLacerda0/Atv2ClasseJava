package a1c2;
/*
 *  Autor: Marlon Lacerda de Oliveira
 * 	Data:  19/05/2023
 * 	Avalicao1, C2 LPII 
 *	
 * */
public class Conta {
	private int numero;
	private String titular;
	private double saldo;
	public Conta(int numero, String titular, double saldo) {
		super();
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public double getSaldo() {
		return saldo;
	}
	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", titular=" + titular + ", saldo="
				+ saldo + "]";
	}
	
	public void deposito(double deposito){
		double valor = 0;
		this.saldo += deposito;
	}
	
	public boolean sacar(double saque){
		boolean podeSacar;		
		if (saque <= this.saldo){
			this.saldo -= saque;
			podeSacar = true;
		}
		else{
			podeSacar = false;
		}			
		return podeSacar;
	}

}
