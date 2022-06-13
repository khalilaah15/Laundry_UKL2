/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukl.s2;

import java.util.Scanner;

/**
 *
 * @author Khalilullah Nuraini
 */
public class Main {
    static Client client = new Client();
    static Petugas petugas = new Petugas();
    static Transaksi transaksi = new Transaksi();
    static JenisLaundry jenislaundry = new JenisLaundry();
    static Scanner input = new Scanner(System.in);
    static boolean tetap = true;
    static String key;
    
    public static void main (String[] args){
        System.out.println("Apakah anda sudah memiliki akun? klik Sudah/Belum");
        String jawab = input.next();
        if(jawab.equalsIgnoreCase("Sudah")){
            System.out.println("Masukkan ID Anda : ");
            int id = input.nextInt();
            System.out.println("Selamat Datang Kak "+client.getNama(transaksi.getClient(id))+"di Laundry Bersih");
            menu(id);
        }
        else if(jawab.equalsIgnoreCase("Belum")){
            System.out.println("Masukkan nama anda untuk membuat akun : ");
            String nama = input.next();
            client.setNama(nama);
            System.out.println("Masukkan ID baru untuk membuat akun anda :");
            int Id = input.nextInt();
            transaksi.setIDClient(Id);
            System.out.println("Masukkan Alamat rumah anda :");
            String alamat = input.next();
            client.setAlamat(alamat);
            System.out.println("Masukkan Nomor Telepon anda yang dapat dihubungi :");
            String telepon = input.next();
            client.setTelepon(telepon);
            System.out.println("Masukkan saldo yang ingin anda tambahkan :");
            int saldo = input.nextInt();
            client.addSaldo(saldo);
            System.out.println("Terimakasih telah mendaftar Kak "+nama);
            int id = transaksi.getIDClient(client.getId(nama));
            System.out.println("\t");
            System.out.println("Berikut data akun anda dan pastikan kembali bahwa data anda sudah valid");
            System.out.println("\t"+"Nama anda            : "+nama);
            System.out.println("\t"+"ID anda              : "+id);
            System.out.println("\t"+"Alamat anda          : "+alamat);
            System.out.println("\t"+"Telepon anda         : "+telepon);
            System.out.println("\t"+"Total Saldo saat ini : "+saldo);
            System.out.println("Apakah data anda sudah valid?");
            System.out.println("Ketik Benar jika sudah valid, Ketik Tidak jika belum valid :");
            String valid=input.next();
            if(valid.equalsIgnoreCase("benar")){
                 menu(id);
                 System.out.println("Ketik apapun dan enter untuk menuju menu : ");
                     key = input.next();
            }
            else if (valid.equalsIgnoreCase("tidak")){
                System.out.println("Masukkan nama anda untuk membuat akun : ");
            String jeneng = input.next();
            client.setNama(nama);
            System.out.println("Masukkan ID baru untuk membuat akun anda :");
            int ID = input.nextInt();
            transaksi.setIDClient(Id);
            System.out.println("Masukkan Alamat rumah anda :");
            String Alamat = input.next();
            client.setAlamat(alamat);
            System.out.println("Masukkan Nomor Telepon anda yang dapat dihubungi :");
            String Telepon = input.next();
            client.setTelepon(telepon);
            System.out.println("Masukkan saldo yang ingin anda tambahkan :");
            int Saldo = input.nextInt();
            client.addSaldo(saldo);
            System.out.println("Terimakasih telah mendaftar Kak "+nama);
             id = transaksi.getIDClient(client.getId(nama));
            menu(id);
        }
        }
    }
    
    public static void tampilLaundry(){
        int n = jenislaundry.size();
        for(int i=0;i<n;i++){
            System.out.println("------------------------");
            System.out.println("  "+jenislaundry.getLaundry(i));
            System.out.println("Harga        = "+jenislaundry.getHarga(i));
            System.out.println("Durasi       = "+jenislaundry.getDurasi(i));
            System.out.println("ID Pemesanan = "+transaksi.getIDJenisLaundry(i));
        }
    }
    
    public static void menu(int id){
        while(tetap){
            System.out.println("---- Laundry ----");
            System.out.println("Menu 1 : List Laundry");
            System.out.println("Menu 2 : List Petugas");
            System.out.println("Menu 3 : List Client");
            System.out.println("Menu 4 : Laundry");
            System.out.println("Menu 5 : Exit");
            System.out.print("Pilih menu : ");
            int menu = input.nextInt();
            if(menu==1){
                tampilLaundry();
                System.out.println("Ketik apapun dan enter untuk kembali");
                key = input.next();
            }
            else if(menu==2){
                petugas.tampilPetugas();
                System.out.println("Ketik apapun dan enter untuk kembali");
                key = input.next();
            }
            else if(menu==3){
                client.tampilClient();
                System.out.println("Ketik apapun dan enter untuk kembali");
                key = input.next();
            }
            else if(menu==4){
                tampilLaundry();
                System.out.println("Masukkan ID Paket laundry yang akan dipesan");
                int laundry = input.nextInt();
                System.out.println("Masukkan berapa banyak laundry anda");
                int banyak = input.nextInt();
                transaksi.setBanyak(banyak);
                int harga = jenislaundry.getHarga(transaksi.getIDJenisLaundry(laundry))*banyak;
                int total = client.getSaldo(transaksi.getClient(id))-harga;
                if(client.getSaldo(transaksi.getClient(id))>=harga){
                    System.out.println("------------> TOTAL PEMESANAN <------------");
                    System.out.println("Nama Pemesan               =  "+client.getNama(transaksi.getClient(id)));
                    System.out.println("Jenis Paket Laundry        =  "+jenislaundry.getLaundry(laundry));
                    System.out.println("Total Harga                =  Rp."+harga);
                    System.out.println("Durasi pengerjaan          =  "+jenislaundry.getDurasi(laundry)+ " menit ");
                    System.out.println("Sisa Saldo                 =  Rp."+total);
                    System.out.println("Karyawan yang Bertugas     =  "+petugas.getNama(transaksi.getIDJenisLaundry(laundry)));
                    System.out.println("Terimakasih telah menggunkaan jasa kami Kak");
                    System.out.println("Ketik apapun dan enter untuk kembali");
                    key = input.next();
                }
                else{
                    System.out.println("Saldo anda tidak cukup");
                    System.out.println("Ketik apapun dan enter untuk kembali");
                    key = input.next();
                }
            }
            else if(menu==5){
                System.out.println("Sampai Jumpa Lagi di Laundry Bersih");
                tetap = false;
            }
            else{
                System.out.println("Input yang anda masukkan tidak sesuai dengan menu");
                System.out.println("Ketik apapun dan enter untuk kembali");
                key = input.next();
            }
        }
    }
}

//set = mengganti
//get = mendapatkan data
//add = menambahkan data
