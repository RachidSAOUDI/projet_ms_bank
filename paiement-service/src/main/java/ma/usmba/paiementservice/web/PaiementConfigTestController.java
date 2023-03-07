package ma.usmba.paiementservice.web;

import ma.usmba.paiementservice.config.PaiementConfigParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaiementConfigTestController {
    @Autowired
    private PaiementConfigParams paiementConfigParams;
    @GetMapping("/configTestParams")
    public PaiementConfigParams configParams(){
        return paiementConfigParams;
    }
}
