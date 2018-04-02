/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;

/**
 *
 * @author Toshiba
 */
public interface ControllerInterface {
    public boolean insert(Object obj);
    public boolean update(Object obj);
    public boolean delete(String id);
    public List<Object> search(String category, String cari);
    public List<Object> getAllData();
    public Object getByGradeLevel(String gl);
    
    
    
}
