package at.ac.htlstp.et.sj25k4a.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    @GetMapping("/web/test")
    public String webTest(Model model, @RequestParam(required = false) String r1, @RequestParam(required = false) String r2) {
        model.addAttribute("msg","Hallo Welt!");
        model.addAttribute("r1",r1);
        model.addAttribute("r2",r2);
        model.addAttribute("result",false);
        try {
            double dR1 = Double.parseDouble(r1.replaceAll(",", "."));
            double dR2 = Double.parseDouble(r2.replaceAll(",", "."));
            double serie = dR1 + dR2;
            double par = dR1 * dR2 / (dR1 + dR2);
            model.addAttribute("serie", serie);
            model.addAttribute("par", par);
            if (serie>0)
                model.addAttribute("result",true);
        } catch (Exception e) {}
        return "web_test";
    }

}
