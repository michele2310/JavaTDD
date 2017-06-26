package javabanco.entidade;
 
 import java.util.ArrayList;
import java.util.Date;
 
 public class ContaCorrente {
	 
  //	Criando atributos 
	private int _numero;
	private String _titular;
 	private float _saldo = 0;
 	private ArrayList<Operacao> _operacoes = new ArrayList<Operacao>();

 	
 	public float saldo(){
 		return _saldo;
 	}
 	
 	public float credito(float valor) {
 		if (valor <= 0) throw new IllegalArgumentException("O valor da operacao deve ser maior que zero");
 		_saldo += valor;
 		Operacao op = new Operacao(valor, "CREDITO", new Date());
		_operacoes.add(op);	
 		return _saldo;
 	}
 	
 	public float debito(float valor) {
 		if (valor <= 0) throw new IllegalArgumentException("O valor da operacao deve ser maior que zero");
 		_saldo -= valor;
 		Operacao op = new Operacao(valor, "DEBITO", new Date());
		_operacoes.add(op);	
 		return _saldo;
 	}
 	
 	public ArrayList<Operacao> extrato() {
 		return _operacoes;
 	}
 	
   
	public ContaCorrente(int numero, String titular){
	 	_numero = numero;
	 	_titular = titular;
	 }
 		
 	public String getTitular() {
 		return _titular;
 	}
 	
 	
 	public int getNumero() {
 		return _numero;
 	}
 		
 
 	public float transferencia( float valor , ContaCorrente ccDestino) {	
 		this.debito(valor);
 		ccDestino.credito(valor);
 		return _saldo;
 	}
 }