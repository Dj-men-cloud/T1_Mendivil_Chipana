package org.cibertec.app;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import org.cibertec.controlador.InventarioJpaController;
import org.cibertec.model.Inventario;

public class ListadoMendivil extends JFrame {

    private JPanel contentPane;
    private JTable tblInventarios;
    private DefaultTableModel modelo;
    
    
    private InventarioJpaController jpaInventario = new InventarioJpaController();

    public static void main(String[] args) {
        
        try {
            ListadoMendivil frame = new ListadoMendivil();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ListadoMendivil() {
        setTitle("Listado de Inventarios Realizados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        
        String[] columnas = {
            "NRO. INVENTARIO", 
            "FECHA", 
            "PRODUCTO", 
            "NRO. CATEGORÍA", 
            "COSTO INGRESO"
        };
        
        modelo = new DefaultTableModel(columnas, 0);
        tblInventarios = new JTable(modelo);
        
        
        JScrollPane scrollPane = new JScrollPane(tblInventarios);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        
        listar();
    }

    void listar() {
        
        modelo.setRowCount(0);
        
        try {
           
            List<Inventario> lista = jpaInventario.findAllInventario();
            
            for (Inventario inv : lista) {
                
                Object[] fila = {
                    inv.getNroInventario(),
                    inv.getFecha(),
                    inv.getIdProducto().getNomProd(), 
                    inv.getIdProducto().getCategoria().getIdCategoria(), 
                    inv.getCostoIngreso() 
                };
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar: " + e.getMessage());
        }
    }
}