package br.com.empresa.clientes.controller;

import java.util.HashMap;
// import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.empresa.clientes.entity.Cliente;
import br.com.empresa.clientes.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    

    @Autowired
    private ClienteService service;

    @GetMapping
    public ModelAndView index(){


         var listaClientes = service.getAll();

        return new ModelAndView("cliente/index", "listaClientes", listaClientes);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var cliente = new Cliente();


        return new ModelAndView("cliente/form", "listaCliente",cliente);
    }

    @PostMapping(params = "form")
    public ModelAndView save(Cliente cliente, BindingResult bindResult){


        if(bindResult.hasErrors()){
            
            HashMap<String,Object> dados = new HashMap<>();
            dados.put("cliente", cliente);
            
    


            return new ModelAndView("cliente/form",dados);
        }

        service.save(cliente);
        

        return new ModelAndView("redirect:/clientes");
    }

}
