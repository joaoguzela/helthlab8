package br.unibh.sdm.negocio;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.unibh.sdm.entidades.Usuario;
import br.unibh.sdm.repository.UsuarioRepository;

@Service
public class UsuarioService {


    private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    
    private final  UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
    
    public List<Usuario> getUsuario(){
        if(logger.isInfoEnabled()){
            logger.info("Buscando todos os objetos");
        }
        Iterable<Usuario> lista = this.usuarioRepository.findAll();
        if (lista == null) {
        	return new ArrayList<Usuario>();
        }
        return IteratorUtils.toList(lista.iterator());
    }    

    public Usuario getUsuarioById(String idUsuario){
        if(logger.isInfoEnabled()){
            logger.info("Buscando Usuario com o codigo {}",idUsuario);
        }
        Optional<Usuario> retorno = this.usuarioRepository.findById(idUsuario);
        if(!retorno.isPresent()){
            throw new RuntimeException("Usuario com o id "+idUsuario+" nao encontrado");
        }
        return retorno.get();
    }
    
    
    public Usuario saveUsuario(Usuario usuario){
        if(logger.isInfoEnabled()){
            logger.info("Salvando Usuario com os detalhes {}",usuario.toString());
        }
        return this.usuarioRepository.save(usuario);
    }
    
    public void deleteUsuario(String idUsuario){
        if(logger.isInfoEnabled()){
            logger.info("Excluindo Cotacao com id {}",idUsuario);
        }
        this.usuarioRepository.deleteById(idUsuario);
    }

    public boolean isUsuarioExists(Usuario usuario){
    	Optional<Usuario> retorno = this.usuarioRepository.findById(usuario.getIdUsuario());
        return retorno.isPresent() ? true:  false;
    }

}
