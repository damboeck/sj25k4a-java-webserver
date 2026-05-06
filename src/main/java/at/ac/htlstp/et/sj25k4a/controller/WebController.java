package at.ac.htlstp.et.sj25k4a.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/web/posttest")
    public String webPostTest(Model model) {
        model.addAttribute("msg","Hallo Welt!");
        return "web_post";
    }

    @PostMapping("/web/postresult")
    public String webPostResult(Model model, String r1, String r2) {
        try {
            double R1 = Double.parseDouble(r1.replaceAll(",", "."));
            double R2 = Double.parseDouble(r2.replaceAll(",", "."));
            double rser = R1+R2;
            double rpar = R1*R2/(R1+R2);
            model.addAttribute("rser",rser);
            model.addAttribute("rpar",rpar);
            model.addAttribute("r1",R1+"");
            model.addAttribute("r2",R2+"");
            if (R1==0 || R2==0) throw new RuntimeException("Ungültige Eingabe");
        } catch(Exception e) {
            model.addAttribute("msg", "Eingabefehler!");
            return "web_post";
        }
        return "web_post_result";
    }

    @RequestMapping("/web/pt")
    public String webPostTest2(Model model, String r1, String r2) {
        model.addAttribute("msg","Hallo Welt!");
        return "web_post_test2";
    }

}
