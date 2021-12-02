
package br.com.senai.dao;

import br.com.senai.entidade.EspacoTempo;
import java.util.List;


public interface EspacoTempoDao extends BaseDao{
    
    EspacoTempo pesquisarPorId(int id) throws Exception;
    
    List<EspacoTempo> pesquisarPorNome(String nome) throws Exception;
    
}
