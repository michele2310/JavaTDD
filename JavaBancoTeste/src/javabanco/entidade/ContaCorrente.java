package javabanco.entidade;
 
 import java.util.ArrayList;
 
 public class ContaCorrente {
	 
  //	Criando atributos 
	private int _numero;
	private String _titular;
	//
 	private float _saldo = 0;
 	private ArrayList<Float> _operacoes = new ArrayList<Float>();
	private Object ;
 	
 	
 	public float saldo(){
 		return _saldo;
 	}
 	
 	public float credito(float valor) {
 		if (valor <= 0) throw new IllegalArgumentException("O valor da operacao deve ser maior que zero");
 		_saldo += valor;
 		_operacoes.add(valor);
 		return _saldo;
 	}
 	
 	public float debito(float valor) {
 		if (valor <= 0) throw new IllegalArgumentException("O valor da operacao deve ser maior que zero");
 		_saldo -= valor;
 		_operacoes.add(-valor);
 		return _saldo;
 	}
 	
 	public ArrayList<Float> extrato() {
 		return _operacoes;
 	}
 	
   // Criando metodos para utilizar os atributos
 	
 		// criando metodo conta corrente e adicionando valor aos atributos	
	 	public ContaCorrente(int numero, String titular){
	 			_numero = numero;
	 			_titular = titular;
	 	}
 		// 	
	 	
	 //	 criando construtores
 	public String getTitular() {
 		return _titular;
 	}
 	
 	
 	public int getNumero() {
 		return _numero;
 	}
 		
 	
 	// 	
 	public float transferencia( float valor , ContaCorrente ccDestino) {
 	
 		// 	referenciando valor de debito 	
 		this.debito(valor);
 		ccDestino.credito(valor);
 		return _saldo;
 	}
 }