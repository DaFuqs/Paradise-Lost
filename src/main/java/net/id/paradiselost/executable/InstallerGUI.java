package net.id.paradiselost.executable;

import javax.swing.*;

public class InstallerGUI {
    public static void main(String[] args) {
        String text = "Paradise Lost is not meant to be run as an executable! Place it in your \\.minecraft\\mods folder instead.";
        JOptionPane.showMessageDialog(null, text, "Paradise Lost", JOptionPane.WARNING_MESSAGE);
    }
}
