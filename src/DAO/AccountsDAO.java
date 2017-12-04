/**
 * 
 */
package DAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import bbdd.ConnectionManager;
import beans.Account;


/**
 * @author iaw26509397
 *
 */
public class AccountsDAO {
	static Connection con = null;

	public static List<Account> getAccounts(String dni) throws IOException {
		List<Account> accounts = new ArrayList<>();
		//Account a = new Account("", 0, "");
		con = ConnectionManager.getConnection();
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			Properties prop = new Properties();
			InputStream input = ClienteDAO.class.getClassLoader().getResourceAsStream("sql.properties");			
			if (input == null) {
				System.out.println("No se encontró el archivo");
			}			
			prop.load(input);
			stmt = con.prepareStatement(prop.getProperty("account.getAccounts"));
			stmt.setString(1, dni);
			rs = (ResultSet) stmt.executeQuery();
			while (rs.next()) {
				Account a = new Account(rs.getString("cliente"), rs.getDouble("saldo"), rs.getString("iban"));
				//a.setCliente(rs.getString("cliente"));
				//a.setIban(rs.getString("iban"));
				//a.setSaldo(rs.getDouble("saldo"));
				accounts.add(a);
			} 
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {	
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return accounts;
	}
	
	public static boolean insertAccount(Account account) {
		boolean result = false;
		con = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		
		try {
			Properties prop = new Properties();
			InputStream input = AccountsDAO.class.getClassLoader().getResourceAsStream("sql.properties");			
			if (input == null) {
				System.out.println("No se encontró el archivo");
			}			
			prop.load(input);
			stmt = con.prepareStatement(prop.getProperty("account.insertAccount"));
			stmt.setString(1, account.getIban());
			stmt.setDouble(2, account.getSaldo());
			stmt.setString(3, account.getCliente());
			stmt.execute();
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
					result = true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}
	
	public static boolean deleteAccount(Account account) {
		boolean result = false;
		con = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		
		try {
			Properties prop = new Properties();
			InputStream input = AccountsDAO.class.getClassLoader().getResourceAsStream("sql.properties");			
			if (input == null) {
				System.out.println("No se encontró el archivo");
			}			
			prop.load(input);
			stmt = con.prepareStatement(prop.getProperty("account.deleteAccount"));
			stmt.setString(1, account.getIban());
			stmt.setString(2, account.getCliente());
			stmt.execute();
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
					result = true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}
}
