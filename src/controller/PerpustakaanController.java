package controller;

import entity.AdminEntity;
import entity.BukuEntity;
import entity.PeminjamanEntity;
import model.PerpustakaanModel;

import java.util.ArrayList;

public class PerpustakaanController {

    PerpustakaanModel perpustakaanModel;

    public PerpustakaanController(){
        this.perpustakaanModel = new PerpustakaanModel();
    }
    public ArrayList<BukuEntity> allArrayBuku() {
        return perpustakaanModel.allArrayBuku();
    }
    public BukuEntity cariBukubyJudul(String judul) {
        return perpustakaanModel.cariBukubyJudul(judul);
    }
    public BukuEntity cariBukubyPengarang(String pengarang) {
        return perpustakaanModel.cariBukubyPengarang(pengarang);
    }
    public BukuEntity cariBukubyPenerbit(String penerbit) {
        return perpustakaanModel.cariBukubyPenerbit(penerbit);
    }
    public void tambahBuku(BukuEntity buku){
        perpustakaanModel.tambahBuku(buku);
    }
    public void updateStokBuku(String judul, int stok) {
        perpustakaanModel.updateStokBuku(judul, stok);
    }
    public void hapusBuku(String judul){
        perpustakaanModel.hapusBuku(judul);
    }
}
