package com._jun.projetoAPI.service;

import com._jun.projetoAPI.dto.UsuarioDTO;
import com._jun.projetoAPI.entity.UsuarioEntity;
import com._jun.projetoAPI.mapper.UsuarioMapper;
import com._jun.projetoAPI.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> findAll() {
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        return UsuarioMapper.toListDTO(usuarios);
    }

    public UsuarioDTO findById(Long id) {
        Optional<UsuarioEntity> usuarioEntity = usuarioRepository.findById(id);
        return usuarioEntity.map(UsuarioMapper::toDTO).orElse(null); // Retorna null se não encontrar
    }

    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuario = UsuarioMapper.toEntity(usuarioDTO);
        UsuarioEntity usuarioSalvo = usuarioRepository.save(usuario);
        return UsuarioMapper.toDTO(usuarioSalvo);
    }

    public UsuarioDTO alterar(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuario = UsuarioMapper.toEntity(usuarioDTO);
        UsuarioEntity usuarioSalvo = usuarioRepository.save(usuario);
        return UsuarioMapper.toDTO(usuarioSalvo);
    }

    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }

    public UsuarioDTO findByNameAndEmail(String name, String email) {
        UsuarioEntity usuarioEntity = usuarioRepository.findByNameAndEmail(name, email);
        UsuarioDTO usuario = UsuarioMapper.toDTO(usuarioEntity);
        return usuario;
    }
}
