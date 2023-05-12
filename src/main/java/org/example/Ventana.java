package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ventana extends JFrame{
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JButton btnBoton;
    private JComboBox combo;
    private NombreModeloCombo modelo;

    public Ventana(String title) throws HeadlessException {
        super(title);
        this.setSize(400, 400);
        setLayout(new FlowLayout());
        lblNombre = new JLabel("Ingresa un nombre: ");
        this.getContentPane().add(lblNombre);
        txtNombre = new JTextField(30);
        this.getContentPane().add(txtNombre);
        btnBoton = new JButton("Agregar ");
        this.getContentPane().add(btnBoton);
        //configuramos el modelo
        modelo = new NombreModeloCombo();
        modelo.agregar("Diana ");
        modelo.agregar("Diego");
        modelo.agregar("Susana ");
        combo = new JComboBox<>(modelo);
        this.getContentPane().add(combo);

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        btnBoton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String nuevo = txtNombre.getText();
                modelo.agregar(nuevo);
                txtNombre.setText(" ");
            }
        });
        combo.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(combo.getSelectedIndex());
                System.out.println(combo.getSelectedItem());
                JOptionPane.showMessageDialog(null, "Hola " + combo.getSelectedItem());
            }
        });
    }
}