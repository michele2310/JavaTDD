package javabanco.entidade;
 
 import static org.junit.Assert.assertEquals;
 
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
 		cc.debito(100);
 		ArrayList<Float> op = cc.extrato();
 		assertEquals(2, op.size());
		assertEquals(100, op.get(0), 0);
		assertEquals(-100, op.get(1), 0);
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
 
 	 // criando teste
 	@Test
	 public void testGetTitular() {
 		ContaCorrente cc = new ContaCorrente(2310, "michele da silva");
	 			
	 }
 	
 	@Test
	 public void testGetNumero() {
 		ContaCorrente cc = new ContaCorrente(2310, "michele da silva");
		 
	 }
 	
   @Test
	 public void testTransferencia() {
	   ContaCorrente cc = new ContaCorrente(2310, "michele da silva");
	   ContaCorrente ccDestino = new ContaCorrente (0707, "joao pedro");
		 			
		 }
}
