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
public class JenisLaundry {
    private ArrayList<String> jenisLaundry = new ArrayList<String>(); //enkapsulation = yang di private
    private ArrayList<Integer> harga = new ArrayList<Integer>();
    private ArrayList<Integer> durasi = new ArrayList<Integer>();
    
    public int size(){
        return this.jenisLaundry.size();
    }
    
    public JenisLaundry(){
        this.jenisLaundry.add("Paket Cuci Kering");
        this.harga.add(3000);
        this.durasi.add(60);
        
        this.jenisLaundry.add("Paket Cuci Lipat");
        this.harga.add(4000);
        this.durasi.add(70);
        
        this.jenisLaundry.add("Paket Cuci Setrika");
        this.harga.add(6000);
        this.durasi.add(80);
        
        this.jenisLaundry.add("Paket Cuci Karpet");
        this.harga.add(10000);
        this.durasi.add(120);
    }
    
    public void setLaundry(String jenis){
        this.jenisLaundry.add(jenis);
    }
    public void setHarga(int harga){
        this.harga.add(harga);
    }
    public void setDurasi(int durasi){
        this.durasi.add(durasi);
    }
    public String getLaundry(int id){
        return this.jenisLaundry.get(id);
    }
    public int getHarga(int id){
        return this.harga.get(id);
    }
    public int getDurasi(int id){
        return this.durasi.get(id);
    }
}
