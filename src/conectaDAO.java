
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class conectaDAO {
    
    public Connection connectDB(){
        Connection conn = null;
        
        try {
        
            // Ajuste a porta se seu MySQL não for 3306
            String url = "jdbc:mysql://localhost:3306/uc11?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            String user = "root";
            String password = "V!deogam3555"; // coloque a senha do seu MySQL aqui
            
            conn = DriverManager.getConnection(url, user, password);
            
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO: " + erro.getMessage());
        }
        return conn;
    }
    
}
