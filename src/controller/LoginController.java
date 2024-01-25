package controller;

import com.google.gson.reflect.TypeToken;
import entity.AdminEntity;
import model.AdminModel;
import modelgson.GsonModel;
import view.AdminView;

import java.util.ArrayList;

public class LoginController {
    private AdminModel adminModel;
    private  AdminView adminView;
    public LoginController() {
        adminModel = new AdminModel();
        adminView = new AdminView();
    }
    public boolean loginAdmin(String username, String password) {
        ArrayList<AdminEntity> listAdmin = new GsonModel<AdminEntity>("src/database/admin.json").readFromFile(new TypeToken<ArrayList<AdminEntity>>(){}.getType());
        if (listAdmin != null) {
            for (AdminEntity admin : listAdmin) {
                if (admin.getUsername().equalsIgnoreCase(username) && admin.getPassword().equalsIgnoreCase(password)) {
                    System.out.println("========== Welcome Scaranation ==========");
                    adminView.menuAdmin();
                    return true;
                }
            }
        }
        System.out.println("Login Gagal");
        return false;
    }
}
