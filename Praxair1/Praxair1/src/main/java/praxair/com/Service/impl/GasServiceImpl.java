package praxair.com.Service.impl;

import praxair.com.dao.GasDao;
import praxair.com.domain.Gas;
import praxair.com.Service.GasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GasServiceImpl implements GasService {

    @Autowired
    private GasDao gasDao;

    @Override
    @Transactional(readOnly = true)
    public List<Gas> getGases() {
        return gasDao.findAll();  // Retorna toda la lista sin filtrar
    }

    @Override
    @Transactional(readOnly = true)
    public Gas getGas(Gas gas) {
        return gasDao.findById(gas.getIdGas()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Gas gas) {
        gasDao.save(gas);
    }

    @Override
    @Transactional
    public void delete(Gas gas) {
        gasDao.delete(gas);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Gas> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup) {
        return gasDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Gas> metodoJPQL(double precioInf, double precioSup) {
        return gasDao.metodoJPQL(precioInf, precioSup);
    }
}
