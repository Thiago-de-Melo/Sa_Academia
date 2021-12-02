
package br.com.senai.dao;

import br.com.senai.entidade.Cargos;
import java.util.List;


public interface CargosDao extends BaseDao{
    
    Cargos pesquisarPorId(int idCargo) throws Exception;
    
    List<Cargos> pesquisarPorNome(String nomeCargo) throws Exception;
    
}
