/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package praxair.com.Service.impl;

import praxair.com.dao.AccesorioDao;
import praxair.com.domain.Accesorio;
import praxair.com.Service.AccesorioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccesorioServiceImpl implements AccesorioService {

    @Autowired
    private AccesorioDao accesorioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Accesorio> getAccesorios() {
        return accesorioDao.findAll();  // Retorna toda la lista sin filtrar
    }

    @Override
    @Transactional(readOnly = true)
    public Accesorio getAccesorio(Accesorio accesorio) {
        return accesorioDao.findById(accesorio.getIdAccesorio()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Accesorio accesorio) {
        accesorioDao.save(accesorio);
    }

    @Override
    @Transactional
    public void delete(Accesorio accesorio) {
        accesorioDao.delete(accesorio);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Accesorio> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup) {
        return accesorioDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Accesorio> metodoJPQL(double precioInf, double precioSup) {
        return accesorioDao.metodoJPQL(precioInf, precioSup);
    }
}
