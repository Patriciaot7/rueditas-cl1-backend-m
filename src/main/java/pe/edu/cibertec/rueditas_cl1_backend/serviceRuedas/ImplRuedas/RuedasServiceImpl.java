package pe.edu.cibertec.rueditas_cl1_backend.serviceRuedas.ImplRuedas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.rueditas_cl1_backend.DTORuedas.RuedasRequestDTO;
import pe.edu.cibertec.rueditas_cl1_backend.serviceRuedas.RuedasService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class RuedasServiceImpl implements RuedasService {
    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] buscarRueditas(RuedasRequestDTO ruedasRequestDTO) throws IOException {

        String[] rueditas = null;
        Resource resource = resourceLoader.getResource("classpath:vehiculoscl1.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] dates = line.split(";");
                if (ruedasRequestDTO.placa().equals(dates[1])){
                    rueditas = new String[5];
                    rueditas[0] = dates[2];
                    rueditas[1] = dates[3];
                    rueditas[2] = dates[4];
                    rueditas[3] = dates[5];
                    rueditas[4] = dates[6];
                    break;
                }
            }

        } catch (Exception e) {
            rueditas = null;
            throw new IOException(e);
        }

        return rueditas;
    }
}

