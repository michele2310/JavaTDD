package javabanco.entidade;
 
 import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
 
 import org.junit.Test;
 
 public class ContaCorrenteTest {
 
	@Test
 	public void testSaldo() {
 		ContaCorrente cc = new ContaCorrente(2310, "michele da silva");
 		assertEquals(0, cc.saldo(), 0);
 	}
 
 	@Test
 	public void testCredito() {
 		ContaCorrente cc = new ContaCorrente(2310, "michele da silva");
 		cc.credito(100);
 		assertEquals(100, cc.saldo(), 0);
 	}
 
 	@Test
 	public void testDebito() {
 		ContaCorrente cc = new ContaCorrente(2310, "michele da silva");
 		cc.debito(100);
 		assertEquals(-100, cc.saldo(), 0);
 	}
 
 	@Test
 	public void testExtrato() {
 		ContaCorrente cc = new ContaCorrente(2310, "michele da silva");
 		cc.credito(100);
 		cc.debito(80);
 		ArrayList<Operacao> listaOperacoes = cc.extrato();
 		assertEquals(2, listaOperacoes.size());
 		// maneira de pegar uma referencia ao primeiro intem da lista
 		Operacao op1 = listaOperacoes.get(0);
		assertEquals(100, op1.getValor(), 0);
		assertEquals("CREDITO", op1.getTipoOperacao());
		// maneira de pegar uma referencia ao primeiro intem da lista
		assertEquals(80, listaOperacoes.get(1).getValor(), 0);
		assertEquals("DEBITO", listaOperacoes.get(1).getTipoOperacao());
 	}
 	
 	@Test
 	public void testSaldoPequenosFloats() {
 		ContaCorrente cc = new ContaCorrente(2310, "michele da silva");
 		cc.credito(0.1f);
 		cc.credito(0.2f);
 		assertEquals(0.3f, cc.saldo(), 0.0f);
 	}
 	
 	@Test(expected = IllegalArgumentException.class)
 	 public void testCreditoValorNegativo() {
 	 	ContaCorrente cc = new ContaCorrente(2310, "michele da silva");	
 	 	cc.credito(-10);		
 	 }
 	 	
 	 @Test(expected = IllegalArgumentException.class)
 	 public void testDebitoValorNegativo() {
 	 	ContaCorrente cc = new ContaCorrente(2310, "michele da silva");		
 	 	cc.debito(-10);		
 	 }
 
 	@Test
	 public void testGetTitular() {
 		// prepara
 		ContaCorrente cc = new ContaCorrente(2310, "michele da silva");
 		// Testa
 		assertEquals ("michele da silva", cc.getTitular());
	 			
	 }
 	
 	@Test
	 public void testGetNumero() {
 		ContaCorrente cc = new ContaCorrente(2310, "michele da silva");
 		assertEquals(2310, cc.getNumero()); 
		 
	 }
 	
 	@Test
     public void testCriacaoContaCorrente(){
 		ContaCorrente cc = new ContaCorrente(2310, "michele da silva");
 		assertNotNull(cc);
 		
 	}
 	
   @Test
	 public void testTransferencia() {
	   ContaCorrente ccOrigem = new ContaCorrente(2310, "michele da silva");
	   ContaCorrente ccDestino = new ContaCorrente (0707, "joao pedro");
	   ccOrigem.transferencia(100, ccDestino);
	   assertEquals(-100, ccOrigem.saldo(),0);
	   assertEquals(100,  ccDestino.saldo(),0);	 			
	}

 }

