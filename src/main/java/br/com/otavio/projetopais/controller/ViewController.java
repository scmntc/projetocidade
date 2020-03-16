package br.com.otavio.projetopais.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    // Classe feita para usar o redirecionamento html5Mode (https://spring.io/blog/2015/05/13/modularizing-the-client-angular-js-and-spring-security-part-vii)
    // Mapeada toda rota do AngularJS para não ter problema durante a atualização da pagina;
    @RequestMapping({
            "/{[path:[^\\.]*}",
            "/web/cadastro",
            "/web/editar/{id}",
            "/web"
    })
    public String redirect() {
        return "forward:/";
    }

}