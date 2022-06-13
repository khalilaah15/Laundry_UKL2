/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukl.s2;

import java.util.ArrayList;

/**
 *
 * @author Khalilullah Nuraini
 */

//polimorfisme

public class Petugas implements User{
    private ArrayList<String> namaPetugas = new ArrayList<String>(); //enkapsulation = yang di private
    private ArrayList<String> alamat = new ArrayList<String>();
    private ArrayList<String> telepon = new ArrayList<String>();
    private ArrayList<Integer> jabatan = new ArrayList<Integer>();
    
    public Petugas(){
        this.namaPetugas.add("Teh Yung");
        this.alamat.add("Rajajowas");
        this.telepon.add("71384548");
        this.jabatan.add(1);
        
        this.namaPetugas.add("Jim In");
        this.alamat.add("Gadang");
        this.telepon.add("08748264929");
        this.jabatan.add(2);
        
        this.namaPetugas.add("Atsumu pacar ice");
        this.alamat.add("menikah");
        this.telepon.add("08748264929");
        this.jabatan.add(3);
    }

    @Override
    public void setNama(String nama) {
        this.namaPetugas.add(nama);
    }

    @Override
    public void setAlamat(String alamat) {
        this.alamat.add(alamat);
    }

    @Override
    public void setTelepon(String telepon) {
        this.telepon.add(telepon);
    }

    @Override
    public String getNama(int id) {
        return this.namaPetugas.get(id);
    }

    @Override
    public String getAlamat(int id) {
        return this.alamat.get(id);
    }

    @Override
    public String getTelepon(int id) {
        return this.telepon.get(id);
    }
    
    public Integer getJabatan(int id) {
        return this.jabatan.get(id);
    }
    
    public void tampilPetugas(){
        int n = this.namaPetugas.size();
        for(int i=0;i<n;i++){
            System.out.println("------------------------");
            System.out.println("Nama    = "+getNama(i));
            System.out.println("Alamat  = "+getAlamat(i));
            System.out.println("Telepon = "+getTelepon(i));
            System.out.println("Jabatan = Laundry ke "+getJabatan(i));
        }
    }

    @Override
    public void setJabatan(int jabatan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}