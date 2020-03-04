package cours.jee.devoir.controller;

import cours.jee.devoir.dao.ILogiciel;
import cours.jee.devoir.dao.IOrdinateur;
import cours.jee.devoir.dao.IOs;
import cours.jee.devoir.model.Logiciel;
import cours.jee.devoir.model.Ordinateur;
import cours.jee.devoir.model.Os;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DevoirController {
    @Autowired
    private IOs iOs;

    @Autowired
    private IOrdinateur iOrdi;

    @Autowired
    private ILogiciel iLogiciel;

    @ModelAttribute("ordi")
    public Ordinateur lordi(){
        Ordinateur o = new Ordinateur();
        o.setOs(new Os());
        o.setLogiciels(new ArrayList<>());
        return  o;
    }

    @GetMapping("/")
    public String load(Model model){

        model.addAttribute("lesos", iOs.findAll());
        List<Logiciel> logi = iLogiciel.findAll();
        model.addAttribute("leslogiciels", logi);

        return "ordinateur";

    }

    @PostMapping("/save")
    public String load(@ModelAttribute("ordi") Ordinateur o, @RequestParam("logi") long[] logis, Model model){
        if(logis.length == 0){
            model.addAttribute("error", "selectionner au moins un logiciel");
        }
        else{
            for (int i = 0; i < logis.length; i++) {
                o.getLogiciels().add(iLogiciel.findById((logis[i])).get());
            }
            iOrdi.save(o);
        }
        model.addAttribute("lesos", iOs.findAll());
        List<Logiciel> logi = iLogiciel.findAll();
        model.addAttribute("leslogiciels", logi);

        return "ordinateur";
    }
}
