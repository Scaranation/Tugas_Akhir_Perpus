package view;

import controller.PerpustakaanController;
import entity.BukuEntity;

import java.util.Scanner;

public class PengunjungView {
    Scanner input = new Scanner(System.in);
    PerpustakaanController objPerpustakaan = new PerpustakaanController();
    public void menuPengunjung(){
        String pilih;
        do {
            System.out.println("""
                    ====================================
                              Panel Pengunjung
                    ====================================
                    1. Cari Buku
                    2. Exit
                    ====================================
                    """);
            System.out.print("Pilih Menu : "); pilih = input.nextLine();
            switch (pilih){
                case "1" -> menuCari();
                case "2" -> System.out.println("Terima kasih");
                default -> System.out.println("Menu Tidak Ada");
            }
        }while (!pilih.equals("2"));
    }
    public void menuCari(){
        try{
            String pilih;
            do{
                System.out.println("""
                        ====================================
                                   Menu Cari Buku          
                        ====================================
                        1. Cari Buku Berdasarkan Judul
                        2. Cari Buku Berdasarkan Pengarang
                        3. Cari Buku Berdasarkan Penerbit
                        4. Exit
                        ====================================
                        """);
                System.out.print("Pilih Menu : "); pilih = input.nextLine();
                switch (pilih){
                    case "1" -> {
                        System.out.print("Masukkan Judul Buku : ");
                        String judul = input.nextLine();
                        CariBukubyJudul(judul);
                    }
                    case "2" -> {
                        System.out.print("Masukkan Pengarang : ");
                        String pengarang = input.nextLine();
                        CariBukubyPengarang(pengarang);
                    }
                    case "3" -> {
                        System.out.print("Masukkan Penerbit : ");
                        String penerbit = input.nextLine();
                        CariBukubyPenerbit(penerbit);
                    }
                    case "4" -> System.out.println("Terima kasih");
                    default -> System.out.println("Menu Tidak Ada");
                }
            }while (!pilih.equals("4"));
        }catch (Exception e){
            input.nextLine();
        }
    }
    public void CariBukubyJudul (String judul){
        BukuEntity buku = objPerpustakaan.cariBukubyJudul(judul);
            if (buku != null){
                System.out.println("============================");
                System.out.println("          Detail Buku       ");
                System.out.println("============================");
                System.out.println("Rak :"+buku.getRak());
                System.out.println("Judul     :"+buku.getJudul());
                System.out.println("Pengarang :"+buku.getPengarang());
                System.out.println("Penerbit  :"+buku.getPenerbit());
                System.out.println("\n============================");
            }else{
                System.out.println("Buku Tidak DItemukan");
            }

    }
    public void CariBukubyPengarang (String pengarang){
        BukuEntity buku = objPerpustakaan.cariBukubyPengarang(pengarang);
            if (buku != null){
                System.out.println("============================");
                System.out.println("          Detail Buku       ");
                System.out.println("============================");
                System.out.println("Rak :"+buku.getRak());
                System.out.println("Judul     :"+buku.getJudul());
                System.out.println("Pengarang :"+buku.getPengarang());
                System.out.println("Penerbit  :"+buku.getPenerbit());
                System.out.println("\n============================");
            }else{
                System.out.println("Buku Tidak DItemukan");
            }

    }
    public void CariBukubyPenerbit (String penerbit){
        BukuEntity buku = objPerpustakaan.cariBukubyPenerbit(penerbit);
            if (buku != null){
                System.out.println("============================");
                System.out.println("          Detail Buku       ");
                System.out.println("============================");
                System.out.println("Rak :"+buku.getRak());
                System.out.println("Judul     :"+buku.getJudul());
                System.out.println("Pengarang :"+buku.getPengarang());
                System.out.println("Penerbit  :"+buku.getPenerbit());
                System.out.println("\n============================");
            }else{
                System.out.println("Buku Tidak DItemukan");
            }
        }
}

