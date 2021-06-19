package br.unibh.sdm.repository;
import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import br.unibh.sdm.entidades.Usuario;



/**
 * 
 * @author jvcgu
 *
 */
@EnableScan()
public interface UsuarioRepository extends CrudRepository<Usuario, String>  {

	List<Usuario> findByIdUsuario(String idUsuario);
	
}
