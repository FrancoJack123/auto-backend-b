package pe.edu.cibertec.autobackendb.service.interfaces;

import pe.edu.cibertec.autobackendb.dto.AutoRequest;

import java.io.IOException;

public interface AutoService {
    String[] buscarAuto(AutoRequest request) throws IOException;
}
