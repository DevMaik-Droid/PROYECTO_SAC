package com.dev_team.controllers;

import com.dev_team.views.V_Login;
import com.formdev.flatlaf.FlatLightLaf;
// fff

public class Main {

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                } else {  // O puedes usar "Nimbus" si prefieres
                    
                    FlatLightLaf.install();
                    
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ignored) {

        }
        System.out.println("");

        V_Login login = new V_Login();
        login.setVisible(true);

    }

}
