
package br.com.senai.dao;

import br.com.senai.entidade.AparelhosAcademia;
import br.com.senai.entidade.CadastroCliente;
import br.com.senai.entidade.Plano;
import br.com.senai.entidade.Treino;
import br.com.senai.entidade.TreinoAparelhos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CadastroClienteDaoImpl implements CadastroClienteDao{
    
    private Connection conexao;
    private PreparedStatement preparaInstrucao;
    private ResultSet resultado;
    

    @Override
    public void salvar(Object object) throws Exception {
        CadastroCliente cadastroCliente = (CadastroCliente) object;
        String instrucao = "insert into Cadastro_Cliente ("
                + "CPF, Nome, Rua, Bairro, Telefone, Data_Nascimento, Senha, Sobrenome, Id_Plano, Whatsapp, Id_Treino) "
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement(instrucao, Statement.RETURN_GENERATED_KEYS);
            preparaInstrucao.setLong(1, cadastroCliente.getCpf());
            preparaInstrucao.setString(2, cadastroCliente.getNome());
            preparaInstrucao.setString(3, cadastroCliente.getRua());
            preparaInstrucao.setString(4, cadastroCliente.getBairro());
            preparaInstrucao.setInt(5, cadastroCliente.getTelefone());
            preparaInstrucao.setString(6, cadastroCliente.getDataNascimento());
            preparaInstrucao.setString(7, cadastroCliente.getSenha());
            preparaInstrucao.setString(8, cadastroCliente.getSobrenome());
            preparaInstrucao.setInt(9, cadastroCliente.getPlano().getIdPlano());
            preparaInstrucao.setInt(10, cadastroCliente.getTreino().getIdTreino());
            /** linha que manda os valores para o insert */
            preparaInstrucao.executeUpdate();
            resultado = preparaInstrucao.getGeneratedKeys();
            resultado.next();
            long CPF = resultado.getLong(1);
            cadastroCliente.setCpf(CPF);
        } catch (Exception e) {
            /** linha para executar mensagens de erro de conexção com o banco */
            System.out.println("Erro ao salvar cadastro cliente! " + e.getMessage());
        } finally {
            /** codigo para que quando de erro feche a conexção com o banco */
            conexao.close();
            preparaInstrucao.close();
        }                
    }

    @Override
    public void alterar(Object object) throws Exception {
        CadastroCliente cadastroCliente = (CadastroCliente) object;
        String sql = "UPDATE Cadastro_Cliente SET "
                + "nome = ?, rua = ?, bairro = ?, telefone = ?, data_nascimento = ?, "
                + "sobrenome = ?, id_Plano = ?, whatsapp = ?, id_Treino = ? WHERE CPF = ?";
        try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement(sql);
            preparaInstrucao.setString(1, cadastroCliente.getNome());
            preparaInstrucao.setString(2, cadastroCliente.getRua());
            preparaInstrucao.setString(3, cadastroCliente.getBairro());
            preparaInstrucao.setInt(4, cadastroCliente.getTelefone());
            preparaInstrucao.setString(5, cadastroCliente.getDataNascimento());
            preparaInstrucao.setString(6, cadastroCliente.getSobrenome());
            preparaInstrucao.setInt(7, cadastroCliente.getPlano().getIdPlano());
            preparaInstrucao.setInt(8, cadastroCliente.getWhatsapp());
            preparaInstrucao.setInt(9, cadastroCliente.getTreino().getIdTreino());
            preparaInstrucao.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao alterar cadastro cliente! " + e.getMessage());
        } finally {
            conexao.close();
            preparaInstrucao.close();
        } 
    }

    @Override
    public void excluir(long cpf) throws Exception {
            String sql = "DELETE FROM Cadastro_Cliente WHERE cpf = ?";
        try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement(sql);
            preparaInstrucao.setLong(1, cpf);
            preparaInstrucao.executeUpdate();
        } catch (Exception e) {
            System.out.println("erro ao excluir Cdastro do cliente " + e.getMessage());
        } finally {
            conexao.close();
            preparaInstrucao.close();
        }
    }
    
    @Override
    public CadastroCliente pesquisarPorId(Long cpf) throws Exception {
        CadastroCliente cadastroCliente = null;
        String consulta = "select * from Vw_Plano where cpf = ?;";
        try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement(consulta);
            preparaInstrucao.setLong(1, cpf);
            resultado = preparaInstrucao.executeQuery();
            if (resultado.next()) {
                cadastroCliente = new CadastroCliente();
                Plano plano = new Plano();
                cadastroCliente.setCpf(resultado.getLong("cc.cpf"));
                plano.setIdPlano(resultado.getInt("pl.id_plano"));
                plano.setValorPlano(resultado.getInt("pl.valor_plano"));
                cadastroCliente.setNome(resultado.getString("cc.nome"));
                cadastroCliente.setSobrenome(resultado.getString("cc.sobrenome"));
                cadastroCliente.setDataNascimento(resultado.getString("cc.data_nascimento"));
                cadastroCliente.setPlano(plano);
            }
        } catch (Exception e) {
            System.out.println("erro ao pesquisar por CPF cliente " + e.getMessage());
        } finally {
            conexao.close();
            preparaInstrucao.close();
            resultado.close();
        }
        return cadastroCliente;
    }
    
    @Override
    public List<CadastroCliente> pesquisarPorNome(String nome) throws Exception {
        List<CadastroCliente> cadastroClientes = new ArrayList<>();
        String consulta = "SELECT * from Cadastro_Cliente where nome like ?";
        try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement(consulta);
            preparaInstrucao.setString(1, "%" + nome + "%");
            resultado = preparaInstrucao.executeQuery();
            CadastroCliente cadastroCliente;
            while (resultado.next()) {
                cadastroCliente = new CadastroCliente();
                cadastroCliente.setCpf(resultado.getLong("cpf"));
                cadastroCliente.setNome(resultado.getString("nome"));
                cadastroCliente.setSobrenome(resultado.getString("sobrenome"));
                cadastroCliente.setBairro(resultado.getString("bairro"));
                cadastroCliente.setRua(resultado.getString("rua"));
                cadastroCliente.setTelefone(resultado.getInt("telefone"));
                cadastroCliente.setWhatsapp(resultado.getInt("whatsapp"));
                cadastroClientes.add(cadastroCliente);
            }
        } catch (Exception e) {
            System.out.println("erro pesquisar Clientes por nome!" + e.getMessage());
        } finally {
            conexao.close();
            preparaInstrucao.close();
            resultado.close();
        }
        return cadastroClientes;
    }

    @Override
    public CadastroCliente logar(Long cpf, String senha) throws Exception {
                String consulta = "SELECT * FROM cadastro_cliente WHERE cpf = ? and senha = ?";
        CadastroCliente cadastroCliente = null;
        try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement(consulta);
            preparaInstrucao.setLong(1, cpf);
            preparaInstrucao.setString(2, senha);
            resultado = preparaInstrucao.executeQuery();
            if (resultado.next()) {
                cadastroCliente = new CadastroCliente();
                cadastroCliente.setCpf(resultado.getLong("cpf"));
                cadastroCliente.setSenha(resultado.getString("senha"));
                cadastroCliente.setCpf(cpf);
                cadastroCliente.setSenha(senha);
            }
        } catch (Exception e) {
            System.out.println("erro ao logar cadastro do cliente!" + e.getMessage());
        } finally {
            conexao.close();
            preparaInstrucao.close();
            resultado.close();
        }
        return cadastroCliente;
    }

    @Override
    public void excluir(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
