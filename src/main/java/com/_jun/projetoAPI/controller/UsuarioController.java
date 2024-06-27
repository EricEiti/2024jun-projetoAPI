package com._jun.projetoAPI.controller;

import com._jun.projetoAPI.dto.UsuarioDTO;
import com._jun.projetoAPI.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(path = "/listar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UsuarioDTO>> listar() {
        List<UsuarioDTO> usuarios = usuarioService.listar();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping(path = "listar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UsuarioDTO> findById(@PathVariable("id")Long id){
        UsuarioDTO usuarioDTO = usuarioService.findById(id);
        return ResponseEntity.ok(usuarioDTO);
    }

    @PostMapping(path = "/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UsuarioDTO> salvar(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioSalvo = usuarioService.save(usuarioDTO);
        return ResponseEntity.ok(usuarioSalvo);
    }

}
