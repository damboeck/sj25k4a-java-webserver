package at.ac.htlstp.et.sj25k4a.controller;

import at.ac.htlstp.et.sj25k4a.model.AjaxModelWiderstand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class APIController {

    @PostMapping("/api/calcwid")
    public ResponseEntity<Map<String, Object>> calcwid(@RequestBody AjaxModelWiderstand m){
        double rSerie = m.getR1()+m.getR2();
        double rParallel = m.getR1()* m.getR2()/rSerie;
        Map<String,Object> map = new HashMap<>();
        map.put("rSerie",rSerie);
        map.put("rParallel",rParallel);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
