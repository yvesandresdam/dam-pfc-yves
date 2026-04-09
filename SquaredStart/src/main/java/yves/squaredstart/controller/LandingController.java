package yves.squaredstart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/")
public class LandingController {
    @GetMapping("")
    public String landingPage(Model model) {
        List<String> imagenes = List.of("componenteColinas.png", "componenteDesierto.png", "componenteArtico.png","componenteJungla.png");

        Random random = new Random();
        String imagenRandom = imagenes.get(random.nextInt(imagenes.size()));

        model.addAttribute("image", imagenRandom);

        return "landingPage";
    }
}
