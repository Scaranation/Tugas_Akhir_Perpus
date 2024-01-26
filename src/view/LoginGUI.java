package view;

import controller.AdminController;
import controller.LoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI {
    private JFrame frame;
    private JPanel panel;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginGUI() {
        frame = new JFrame("Perpustakaan");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        frame.add(panel);
        placeComponents();

        frame.setVisible(true);
    }

    private void placeComponents() {
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Selamat Datang di Perpustakaan");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        titleLabel.setBounds(50, 20, 300, 25);
        panel.add(titleLabel);

        JButton loginAdminButton = new JButton("Login Admin");
        loginAdminButton.setBounds(50, 70, 150, 25);
        loginAdminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAdminLogin();
            }
        });
        panel.add(loginAdminButton);

        JButton pengunjungButton = new JButton("Menu Pengunjung");
        pengunjungButton.setBounds(50, 110, 150, 25);
        pengunjungButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPengunjungMenu();
            }
        });
        panel.add(pengunjungButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(50, 150, 80, 25);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Terima kasih");
                System.exit(0);
            }
        });
        panel.add(exitButton);
    }

    private void showAdminLogin() {
        panel.removeAll();
        frame.repaint();

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 50, 80, 25);
        panel.add(userLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(150, 50, 165, 25);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 80, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(150, 80, 165, 25);
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(50, 120, 80, 25);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());
                LoginController loginController = new LoginController();

                if (loginController.loginAdmin(username, password)) {
                    AdminView objAdmin = new AdminView();
                    objAdmin.menuAdmin();
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Username atau password salah");
                }
            }
        });
        panel.add(loginButton);

        JButton backButton = new JButton("Back to Menu");
        backButton.setBounds(50, 150, 150, 25);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                placeComponents();
                frame.repaint();
            }
        });
        panel.add(backButton);

        frame.repaint();
    }

    private void showPengunjungMenu() {
        PengunjungView objPengunjung = new PengunjungView();
        objPengunjung.menuPengunjung();
        System.out.println("Menu Pengunjung");
    }

    public static void main(String[] args) {
        new LoginGUI();
    }
}
