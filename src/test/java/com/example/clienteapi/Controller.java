package com.example.apicliente;

import com.example.clienteapi.Cliente;
import com.example.clienteapi.Repository;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Executable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cliente/v1/")

public class Controller {

    @Autowired
    Repository repository;

    @PostMapping
    public Cliente cliente(@RequestBody @Valid Cliente cliente) {
        Cliente clienteSavad = repository.save(cliente);
        return clienteSavad;
    }

    @GetMapping("/id")
    @ResponseBody
    public Optional<Cliente> getClienteById(@PathVariable @Validated Long id) {
        Optional<Cliente> clienteReturned = repository.findById(id);
        return clienteReturned;
    }

    public String deleteClienteById(@PathVariable Long id) {
        try {
            Optional<Cliente> cliente = Optional.of(repository.getById(id));
            if (cliente != null) {
                repository.deleteById(id);
                return "Cliente de " + id + "deletado com sucesso!";
            } else {
                throw new Exception("Cliente inexistente!");
            }
        }catch (Exception e){
            System.out.println("Execussão ocorreu!");
            e.printStackTrace();
            return "O cliente de " + id + " não existe para ser deletado";
        }
    }
    @GetMapping
    public List<Cliente> listCLiente(){
        return repository.findAll();
    }

}