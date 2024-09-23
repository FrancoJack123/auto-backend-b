package pe.edu.cibertec.autobackendb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.autobackendb.dto.AutoRequest;
import pe.edu.cibertec.autobackendb.dto.AutoResponse;
import pe.edu.cibertec.autobackendb.service.interfaces.AutoService;

@RestController
@RequestMapping("/api/vehiculos")
public class AutoController {
    @Autowired
    private AutoService autoService;

    @PostMapping
    public AutoResponse buscarAuto(@RequestBody AutoRequest request) {
        System.out.println("request = " + request);
        try {
            String[] datosAutos = autoService.buscarAuto(request);
            if (datosAutos == null) {
                return new AutoResponse(
                        "01",
                        "Error: Auto no encontrado",
                        "",
                        "",
                        "",
                        "",
                        "");
            }
            return new AutoResponse(
                    "01",
                    "",
                    datosAutos[0],
                    datosAutos[1],
                    datosAutos[2],
                    datosAutos[3],
                    datosAutos[4]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new AutoResponse(
                    "99",
                    "Error: Ocurrió un problema",
                    "",
                    "",
                    "",
                    "",
                    "");

        }
    }
}
