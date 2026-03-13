/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        
        //conn = new conectaDAO().connectDB();
        String sql = "INSERT INTO produtos (id, nome, valor, status) VALUES(?,?,?,?)";
        
        try{
            prep = conn.prepareStatement(sql);
            
            prep.setInt(1, produto.getId());
            prep.setString(2, produto.getNome());
            prep.setInt(3, produto.getValor());
            prep.setString(4, produto.getStatus());
            
            prep.executeUpdate();
            
            prep.close();
            conn.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        List<ProdutosDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos";

        try {
            prep = conn.prepareStatement(sql);
            resultset = prep.executeQuery();

            while (resultset.next()) {

                ProdutosDTO produto = new ProdutosDTO();

                produto.setId(resultset.getInt("id"));
                produto.setNome(resultset.getString("nome"));
                produto.setValor(resultset.getInt("valor"));
                produto.setStatus(resultset.getString("status"));

                lista.add(produto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listagem;
    }
    
    
    
        
}

