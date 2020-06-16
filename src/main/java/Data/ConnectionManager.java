package Data;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionManager {
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/clients_control?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrival=true";
    public static final String DATABASE_USER = "root";
    public static final String DATABASE_PASSWORD = "root";
    
    public static BasicDataSource dataSource;
    
    public static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl(DATABASE_URL);
            dataSource.setUsername(DATABASE_USER);
            dataSource.setPassword(DATABASE_PASSWORD);
            dataSource.setInitialSize(50);
        }
        return dataSource;
    }
    
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
    
    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement pst) {
        try {
            pst.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
