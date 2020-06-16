package Data;

import Domain.Client;
import java.sql.*;
import java.util.*;

public class ClientDAO {
    public static final String SQL_SELECT_ALL = "select client_id, name, lastname, email, phone_number, residue from clients";
    public static final String SQL_SELECT_BY_ID = "select client_id, name, lastname, email, phone_number, residue from clients where client_id = ?";
    public static final String SQL_INSERT = "insert into clients (name, lastname, email, phone_number, residue) values (?, ?, ?, ?, ?)";
    public static final String SQL_UPDATE = "update clients set name = ?, lastname = ?, email = ?, phone_number = ?, residue = ? where client_id = ?";
    public static final String SQL_DELETE = "delete from clients where client_id = ?";
    
    public List<Client> getClients() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Client client = null;
        
        List<Client> clients = new ArrayList<>();
        try {
            conn = ConnectionManager.getConnection();
            pstm = conn.prepareStatement(SQL_SELECT_ALL);
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                int clientId = rs.getInt("client_id");
                String name = rs.getString("name");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phone_number");
                double residue = rs.getDouble("residue");
                
                client = new Client(clientId, name, lastname, email, phoneNumber, residue);
                clients.add(client);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionManager.close(rs);
            ConnectionManager.close(pstm);
            ConnectionManager.close(conn);
        }
        return clients;
    } 
    
    public Client getClientById(Client client) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            conn = ConnectionManager.getConnection();
            pstm = conn.prepareStatement(SQL_SELECT_BY_ID);
            pstm.setInt(1, client.getClientId());
            rs = pstm.executeQuery();
            
            if (rs.next()) { 
                String name = rs.getString("name");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phone_number");
                double residue = rs.getDouble("residue");

                client.setName(name);
                client.setLastname(lastname);
                client.setEmail(email);
                client.setPhoneNumber(phoneNumber);
                client.setResidue(residue);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionManager.close(rs);
            ConnectionManager.close(pstm);
            ConnectionManager.close(conn);
        }
        return client;
    }
    
    public int insertClient(Client client) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int affectedRows = 0;
        
        try {
            conn = ConnectionManager.getConnection();
            pstm = conn.prepareStatement(SQL_INSERT);
            
            pstm.setString(1, client.getName());
            pstm.setString(2, client.getLastname());
            pstm.setString(3, client.getEmail());
            pstm.setString(4, client.getPhoneNumber());
            pstm.setDouble(5, client.getResidue());
            
            affectedRows = pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionManager.close(pstm);
            ConnectionManager.close(conn);
        }
        return affectedRows;
    }
    
    public int updateClient(Client client) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int affectedRows = 0;
        
        try {
            conn = ConnectionManager.getConnection();
            pstm = conn.prepareStatement(SQL_UPDATE);
            
            pstm.setString(1, client.getName());
            pstm.setString(2, client.getLastname());
            pstm.setString(3, client.getEmail());
            pstm.setString(4, client.getPhoneNumber());
            pstm.setDouble(5, client.getResidue());
            pstm.setInt(6, client.getClientId());
            
            affectedRows = pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionManager.close(pstm);
            ConnectionManager.close(conn);
        }
        return affectedRows;
    }
    
    public int deleteClient(Client client) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int affectedRows = 0;
        
        try {
            conn = ConnectionManager.getConnection();
            pstm = conn.prepareStatement(SQL_DELETE);
            
            pstm.setInt(1, client.getClientId());
            
            affectedRows = pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionManager.close(pstm);
            ConnectionManager.close(conn);
        }
        return affectedRows;
    }
}
