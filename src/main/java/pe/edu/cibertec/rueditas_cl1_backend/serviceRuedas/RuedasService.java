package pe.edu.cibertec.rueditas_cl1_backend.serviceRuedas;


import pe.edu.cibertec.rueditas_cl1_backend.DTORuedas.RuedasRequestDTO;

import java.io.IOException;

public interface RuedasService {
    String[] buscarRueditas(RuedasRequestDTO rueditasRequestDTO)throws IOException;
}

