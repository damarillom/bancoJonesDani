/**
 * 
 */
package beans;

/**
 * @author iaw26509397
 *
 */
public class Account {
	private String cliente;
	private double saldo;
	private String iban;
	public Account(String cliente, double saldo, String iban) {
		super();
		this.cliente = cliente;
		this.saldo = saldo;
		this.iban = iban;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
}
