/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lat.uas.ws.lat.uas.ws;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author lenovo
 */

@Controller
@ResponseBody
public class myCOntroller {
    
    Barang data = new Barang();
    BarangJpaController ctrl = new BarangJpaController();
    
    //view data 
    @RequestMapping ("/get/{id}")
    public String getName (@PathVariable("id") int id){
        try{
            data = ctrl.findBarang(id);
            return "Id " + data.getId()+" berisi:"+"<br>"+"Nama Barang: " + data.getNamaBrg() + "<br>" + "Jumlah Barang: " 
                    + data.getJumlah();
        }catch(Exception e) {
            return "Data tidak ada";}
    }

    //view all data
    @RequestMapping ("/getall")
    public List<Barang> getAllBarang() {
        List<Barang> Barang = new ArrayList<Barang>();
        return ctrl.findBarangEntities();
    }
    
    //delete
    @RequestMapping("/del/{id}")
    public String deleteData (@PathVariable("id")int id){
        try{
            ctrl.destroy(id);
            return "Data terhapus";
        }catch (Exception e) {
            return "Data tidak ditemukan";
        }
    }
   
}
