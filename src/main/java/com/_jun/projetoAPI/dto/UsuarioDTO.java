package com._jun.projetoAPI.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
}
