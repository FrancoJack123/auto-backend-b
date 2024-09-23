package pe.edu.cibertec.autobackendb.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.core.io.Resource;
import pe.edu.cibertec.autobackendb.dto.AutoRequest;
import pe.edu.cibertec.autobackendb.service.interfaces.AutoService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class AutoServiceImpl implements AutoService {

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public String[] buscarAuto(AutoRequest request) throws IOException {
        String[] datosAutos = null;
        Resource resource = resourceLoader.getResource("classpath:vehiculos.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (request.placa().equals(datos[1])) {
                    datosAutos = new String[5];
                    datosAutos[0] = datos[2];
                    datosAutos[1] = datos[3];
                    datosAutos[2] = datos[4];
                    datosAutos[3] = datos[5];
                    datosAutos[4] = datos[6];
                    break;
                }
            }
        } catch (IOException e) {
            datosAutos = null;
            throw new IOException(e);
        }
        return datosAutos;
    }
}
