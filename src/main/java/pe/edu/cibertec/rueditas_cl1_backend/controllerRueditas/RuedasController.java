package pe.edu.cibertec.rueditas_cl1_backend.controllerRueditas;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.rueditas_cl1_backend.DTORuedas.RuedasRequestDTO;
import pe.edu.cibertec.rueditas_cl1_backend.DTORuedas.RuedasResponseDTO;
import pe.edu.cibertec.rueditas_cl1_backend.serviceRuedas.RuedasService;

@RestController
@RequestMapping("/rueda")
public class RuedasController {

    @Autowired
    RuedasService rueditasService;

    @PostMapping("/busqueda")
    public RuedasResponseDTO busqueda(@RequestBody RuedasRequestDTO ruedasRequestDTO) {
        try {
            String[] dates = rueditasService.buscarRueditas(ruedasRequestDTO);
            if (dates == null) {
                return new RuedasResponseDTO("01","Error: Vehículo no encontrado","","","","","");
            }
            return new RuedasResponseDTO("00","",dates[0],dates[1],dates[2],dates[3],dates[4]);

        } catch (Exception e) {
            return new RuedasResponseDTO("99","Error: Ha ocurrido un problema","","","","","");
        }

    }
}
