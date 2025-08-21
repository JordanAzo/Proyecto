package praxair.com.Service;

import praxair.com.domain.Gas;
import java.util.List;

public interface GasService {
    List<Gas> getGases();  // Se elimina el parámetro boolean
    Gas getGas(Gas gas);
    void save(Gas gas);
    void delete(Gas gas);
    List<Gas> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
    List<Gas> metodoJPQL(double precioInf, double precioSup);
}

