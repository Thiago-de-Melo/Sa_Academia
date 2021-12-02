
package br.com.senai.dao;

import br.com.senai.entidade.Plano;
import java.util.List;


public interface PlanoDao extends BaseDao {
    
    Plano pesquisarPorId(int id_plano) throws Exception;
    
    List<Plano> pesquisarPorNome(String planos)throws Exception;
    
}
