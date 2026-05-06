package at.ac.htlstp.et.sj25k4a.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebControllerB {

    @GetMapping("/web/testb")
    public String webTestb(
            Model model,
            @RequestParam(required = false) String r1,
            @RequestParam(required = false) String r2
    ) {
        model.addAttribute("msg","Hallo Welt!");
        model.addAttribute("hasresult",false);
        model.addAttribute("r1",r1);
        model.addAttribute("r2",r2);
        try {
            double R1 = Double.parseDouble(r1.replaceAll(",", "."));
            double R2 = Double.parseDouble(r2.replaceAll(",", "."));
            double rser = R1+R2;
            double rpar = R1*R2/(R1+R2);
            model.addAttribute("rser",String.format("%5.2f",rser).replaceAll(",", "."));
            model.addAttribute("rpar",String.format("%5.2f",rpar).replaceAll(",", "."));
            model.addAttribute("hasresult",true);
        } catch (Exception e) {
            if (r1!=null || r2!=null)
                model.addAttribute("msg", "Eingabefehler!!");
            model.addAttribute("r1","");
            model.addAttribute("r2","");
        }
        return "webTestb";
    }
}
