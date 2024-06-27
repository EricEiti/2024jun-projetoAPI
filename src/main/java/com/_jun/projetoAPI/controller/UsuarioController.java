package com._jun.projetoAPI.controller;

import com._jun.projetoAPI.dto.UsuarioDTO;
import com._jun.projetoAPI.entity.UsuarioEntity;
import com._jun.projetoAPI.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Listar", description = "Metodo que retorna todos os dados", tags = "Usuario")
    @GetMapping(path = "/listar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UsuarioDTO>> listar() {
        List<UsuarioDTO> usuarios = usuarioService.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @Operation(summary = "Find By Id", description = "Metodo que retorna um registro", tags = "Usuario")
    @GetMapping(path = "listar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UsuarioDTO> findById(@PathVariable("id")Long id){
        UsuarioDTO usuarioDTO = usuarioService.findById(id);
        return ResponseEntity.ok(usuarioDTO);
    }

    @Operation(summary = "Salvar", description = "Metodo que salva um registro", tags = "Usuario")
    @PostMapping(path = "/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UsuarioDTO> salvar(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioSalvo = usuarioService.save(usuarioDTO);
        return ResponseEntity.ok(usuarioSalvo);
    }

    @Operation(summary = "Alterar", description = "Metodo que altera um registro", tags = "Usuario")
    @PutMapping(path = "/alterar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UsuarioDTO> alterar(@RequestBody UsuarioDTO usuarioDTO){
        return ResponseEntity.ok(usuarioService.alterar(usuarioDTO));
    }

    @Operation(summary = "Deletar", description = "Metodo que deleta um registro", tags = "Usuario")
    @DeleteMapping(path = "/deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable("id") Long id) {
        usuarioService.deletar(id);
    }

    @Operation(summary = "Busca por nome e email", description = "Metodo que retorna um registro", tags = "Usuario")
    @GetMapping(path = "/buscarPorNomeEEmail/{name}/{email}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UsuarioDTO> buscarPorNomeEEmail(@PathVariable String name, @PathVariable String email) {
        UsuarioDTO usuarioDTO = usuarioService.findByNameAndEmail(name, email);
        if (usuarioDTO != null) {
            return ResponseEntity.ok(usuarioDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
