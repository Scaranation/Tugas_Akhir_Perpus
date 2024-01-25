package view;

import controller.PeminjamanController;
import controller.PerpustakaanController;
import entity.BukuEntity;
import entity.PeminjamanEntity;
import entity.PengunjungEntity;
import model.PerpustakaanModel;

import java.util.Scanner;

public class PeminjamanView {
    Scanner input = new Scanner(System.in);
    PerpustakaanController objPerpustakaan = new PerpustakaanController();
    PerpustakaanModel objPerpustakaanModel = new PerpustakaanModel();
    PeminjamanController objPeminjam = new PeminjamanController();
    PengunjungView objPengunjung = new PengunjungView();


    public void pinjamBukuView() {
        String pilih;
        do {
            System.out.println("""
                    ====================================
                             Panel Peminjaman
                    ====================================
                    1. Peminjaman Buku
                    2. Data Peminjam
                    3. Exit
                    ====================================
                    """);
            System.out.println();
            System.out.println("Pilih Menu : ");
            pilih = input.nextLine();
            switch (pilih) {
                case "1" -> peminjamanBuku();
                case "2" -> viewDataPeminjam();
                case "3" -> System.out.println("Terima kasih");
                default -> System.out.println("Pilihan Tidak Tersedia");
            }
        } while (!pilih.equals("3"));
    }

    public void peminjamanBuku() {
        try {

            for (BukuEntity buku : objPerpustakaanModel.allArrayBuku()) {
                if (buku != null) {
                    System.out.println("============================");
                    System.out.println("Judul : " + buku.getJudul());
                    System.out.println("Stok  : " + buku.getStok());
                    System.out.println("Harga : " + buku.getHarga() + "/Hari");
                    System.out.println("\n============================");
                }
            }
            System.out.println("Masukkan Nama Peminjam : ");
            String nama = input.nextLine();
            System.out.println("Masukkan Alamat Peminjam : ");
            String tpt = input.nextLine();
            System.out.println("Masukkan Judul Buku Peminjaman: ");
            String judul = input.nextLine();
            System.out.println("Masukkan Lama Peminjaman : ");
            int lama = input.nextInt();
            int total = objPeminjam.totalHarga(judul, lama);
            if (objPerpustakaan.cariBukubyJudul(judul) != null) {
                if (objPerpustakaan.cariBukubyJudul(judul).getStok() > 0) {
                    objPengunjung.CariBukubyJudul(judul);
                    objPeminjam.allArrayPeminjaman();
                    objPerpustakaan.updateStokBuku(judul, objPerpustakaan.cariBukubyJudul(judul).getStok() - 1);
                    System.out.println("============================");
                    System.out.println("      Detail Peminjaman     ");
                    System.out.println("============================");
                    System.out.println("Peminjam : " + nama);
                    System.out.println("Alamat : " + tpt);
                    System.out.println("Judul : " + objPerpustakaan.cariBukubyJudul(judul).getJudul());
                    System.out.println("Pengarang : " + objPerpustakaan.cariBukubyJudul(judul).getPengarang());
                    System.out.println("Penerbit : " + objPerpustakaan.cariBukubyJudul(judul).getPenerbit());
                    System.out.println("Jumlah Halaman : " + objPerpustakaan.cariBukubyJudul(judul).getJumlahHalaman());
                    System.out.println("Harga : " + total);
                    PengunjungEntity orang = new PengunjungEntity(nama, tpt);
                    PeminjamanEntity peminjaman = new PeminjamanEntity(orang, objPerpustakaan.cariBukubyJudul(judul), lama, total);
                    objPeminjam.tambahPeminjaman(peminjaman);
                    System.out.println("Peminjaman Berhasil");
                    input.nextLine();
                    System.out.println("\n============================");
                } else {
                    System.out.println("Stok buku habis");
                }
            } else {
                System.out.println("Buku Tidak Ditemukan");
            }
        } catch (Exception e) {
            input.nextLine();
        }
    }

    public void viewDataPeminjam() {
            if (objPeminjam.allArrayPeminjaman().size() == 0) {
                System.out.println("Data Peminjaman tidak ditemukan");
            } else {
                for (PeminjamanEntity peminjaman : objPeminjam.allArrayPeminjaman()){
                System.out.println("============================");
                System.out.println("Peminjam : " + peminjaman.getPengunjungEntity().getUsername());
                System.out.println("Alamat : " + peminjaman.getPengunjungEntity().getPassword());
                System.out.println("Judul : " + peminjaman.getBukuEntity().getJudul());
                System.out.println("Pengarang : " + peminjaman.getBukuEntity().getPengarang());
                System.out.println("Penerbit : " + peminjaman.getBukuEntity().getPenerbit());
                System.out.println("Jumlah Halaman : " + peminjaman.getBukuEntity().getJumlahHalaman());
                System.out.println("Total Harga : " + peminjaman.getTotalHarga());
                System.out.println("Lama Peminjaman : " + peminjaman.getLamaPeminjaman());
                System.out.println("Tgl Peminjaman : " + peminjaman.getTglPinjam());
                System.out.println("\n============================");
            }
        }
    }
}