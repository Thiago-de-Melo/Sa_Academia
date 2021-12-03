
package br.com.senai.dao;

import br.com.senai.entidade.CadastroCliente;
import java.util.List;


public interface CadastroClienteDao extends BaseDao{

    CadastroCliente pesquisarPorId(Long cpf) throws Exception;

    List<CadastroCliente> pesquisarPorNome(String nome) throws Exception;
    
    CadastroCliente logar(Long cpf, String senha) throws Exception;

}
