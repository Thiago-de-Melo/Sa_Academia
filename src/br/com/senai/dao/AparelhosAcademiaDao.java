
package br.com.senai.dao;

import br.com.senai.entidade.AparelhosAcademia;
import java.util.List;


public interface AparelhosAcademiaDao extends BaseDao{
    
    AparelhosAcademia pesquisaPorId(int idAparelhos) throws Exception;
    
    List<AparelhosAcademia> pesquisarPorNome(String nomeAparelhos) throws Exception;
    
}
