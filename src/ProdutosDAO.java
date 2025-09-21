import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        
         String sql = "INSERT INTO produtos (nome, valor) VALUES (?, ?)";
    
    try (Connection conn = new conectaDAO().connectDB();
         PreparedStatement pstm = conn.prepareStatement(sql)) {
        
        pstm.setString(1, produto.getNome());
        pstm.setDouble(2, produto.getValor());
        pstm.execute();
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e.getMessage());
    }
        //conn = new conectaDAO().connectDB();
        
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        ArrayList<ProdutosDTO> listagem = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        
        try (Connection conn = new conectaDAO().connectDB();
             PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {
            
            while (rs.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(rs.getInt("id"));       // coluna id
                produto.setNome(rs.getString("nome"));// coluna nome
                produto.setValor(rs.getInt("valor")); // coluna preco
                produto.setStatus(rs.getString("status"));// coluna status
                listagem.add(produto);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + e.getMessage());
        }
        
        
        return listagem;
    }
    
    
    
        
}

