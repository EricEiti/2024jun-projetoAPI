package com._jun.projetoAPI.mapper;

import com._jun.projetoAPI.dto.UsuarioDTO;
import com._jun.projetoAPI.entity.UsuarioEntity;

public class UsuarioMapper {

    public static UsuarioDTO toDTO(UsuarioEntity usuarioEntity) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuarioEntity.getId());
        usuarioDTO.setName(usuarioEntity.getName());
        usuarioDTO.setEmail(usuarioEntity.getEmail());
        usuarioDTO.setPassword(usuarioEntity.getPassword());
        return usuarioDTO;
    }

    public static UsuarioEntity toEntity(UsuarioDTO dto) {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setId(dto.getId());
        usuario.setName(dto.getName());
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword());
        return usuario;
    }
}
