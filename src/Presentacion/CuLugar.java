/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.ConexionDriverSqlServer;
import Negocio.NLugar;
import java.net.URLDecoder;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author FRANKLIN SALAS
 */
public class CuLugar extends javax.swing.JFrame {
    NLugar lugares;
    int cod;
    String nombre;
    /**
     * Creates new form CuLugar
     */
    public CuLugar() throws ClassNotFoundException {
        initComponents();
        lugares=new NLugar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LBLPLACA = new javax.swing.JLabel();
        TXTCOD = new javax.swing.JTextField();
        LBLCAPACIDAD = new javax.swing.JLabel();
        TXTNOMBRE = new javax.swing.JTextField();
        BTNREGISTRAR = new javax.swing.JButton();
        BTNBUSCAR = new javax.swing.JButton();
        BTNEDITAR = new javax.swing.JButton();
        BTNMOSTRAR = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TLUGAR = new javax.swing.JTable();
        BTNSALIR = new javax.swing.JButton();
        BTNNUEVO = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "REGISTRO DE LUGARES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LBLPLACA.setText("CODIGO");
        jPanel1.add(LBLPLACA, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 33, -1, -1));

        TXTCOD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXTCODKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXTCODKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXTCODKeyTyped(evt);
            }
        });
        jPanel1.add(TXTCOD, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 30, 82, -1));

        LBLCAPACIDAD.setText("NOMBRE");
        jPanel1.add(LBLCAPACIDAD, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 73, -1, -1));
        jPanel1.add(TXTNOMBRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 70, 160, -1));

        BTNREGISTRAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/onebit_20.png"))); // NOI18N
        BTNREGISTRAR.setText("REGISTRAR");
        BTNREGISTRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNREGISTRARActionPerformed(evt);
            }
        });
        jPanel1.add(BTNREGISTRAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 150, 40));

        BTNBUSCAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/search2.png"))); // NOI18N
        BTNBUSCAR.setText("BUSCAR");
        BTNBUSCAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNBUSCARActionPerformed(evt);
            }
        });
        jPanel1.add(BTNBUSCAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 150, -1));

        BTNEDITAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        BTNEDITAR.setText("EDITAR");
        BTNEDITAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNEDITARActionPerformed(evt);
            }
        });
        jPanel1.add(BTNEDITAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 150, 40));

        BTNMOSTRAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/stock1.png"))); // NOI18N
        BTNMOSTRAR.setText("MOSTRAR");
        BTNMOSTRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNMOSTRARActionPerformed(evt);
            }
        });
        jPanel1.add(BTNMOSTRAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 130, 40));

        TLUGAR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOMBRE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TLUGAR);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 370, 130));

        BTNSALIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/close.png"))); // NOI18N
        BTNSALIR.setText("SALLIR");
        BTNSALIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSALIRActionPerformed(evt);
            }
        });
        jPanel1.add(BTNSALIR, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 150, 40));

        BTNNUEVO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonCrearNuevo.gif"))); // NOI18N
        BTNNUEVO.setText("  NUEVO");
        BTNNUEVO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNNUEVOActionPerformed(evt);
            }
        });
        jPanel1.add(BTNNUEVO, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 150, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TXTCODKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXTCODKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_TXTCODKeyPressed

    private void TXTCODKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXTCODKeyReleased
        // TODO add your handling code here:
//        try {
//            String buscar =TXTCOD.getText();
//            String[] resul=lugares.ConsultaBuscar(buscar);
//            //TXTCOD
//            TXTCOD.setText(resul[0]);
//            TXTNOMBRE.setText(resul[1]);
//        } catch (Exception e) {
//            TXTNOMBRE.setText("");
//        }
    }//GEN-LAST:event_TXTCODKeyReleased

    private void TXTCODKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXTCODKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_TXTCODKeyTyped

    private void BTNREGISTRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNREGISTRARActionPerformed
        // TODO add your handling code here:
        try {
            cod=Integer.valueOf(TXTCOD.getText());
            nombre= TXTNOMBRE.getText();
            if (nombre.length()==0) {
                JOptionPane.showMessageDialog(null, "INGRESE NOMBRE DEL LUGAR");
                return;
            }
            String resutado=lugares.insertar(cod, nombre);
            JOptionPane.showMessageDialog(null, resutado);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "DATOS INVALIDOS "+e.getMessage());
        }
        
        
    }//GEN-LAST:event_BTNREGISTRARActionPerformed

    private void BTNBUSCARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNBUSCARActionPerformed
        try {
        String cod=(TXTNOMBRE.getText());
        String[] resultado=lugares.Consultabuscar(cod);
        TXTCOD.setText(resultado[0]);
        TXTNOMBRE.setText(resultado[1]);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "EL NOMBRE DEL LUGAR NO EXISTE "+e.getMessage());
        }
    }//GEN-LAST:event_BTNBUSCARActionPerformed

    private void BTNEDITARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNEDITARActionPerformed
        // TODO add your handling code here:
        try {
            cod=Integer.valueOf(TXTCOD.getText());
            nombre=TXTNOMBRE.getText();
            String resultado=lugares.acutalizar(cod, nombre);
            JOptionPane.showMessageDialog(null, resultado);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR DE DATOS INTRODUCIDOS "+ e.getMessage());
        }
    }//GEN-LAST:event_BTNEDITARActionPerformed

    private void BTNMOSTRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNMOSTRARActionPerformed
        // TODO add your handling code here:
        try {
            DefaultTableModel modelo= (DefaultTableModel) TLUGAR.getModel();
            String[][] table=lugares.ListaDeLugares();
            int tuplas=modelo.getRowCount();
            if (tuplas>0) {
                for (int i = 0; i < tuplas; i++) {
                    modelo.removeRow(0);
                }
            }
            for (int i = 0; i <table.length ; i++) {
                modelo.addRow(new Object[]{table[i][0],table[i][1]});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"DATOS NO ENCONTRADOS "+ e.getMessage());
        }
//        imprimir();
    }//GEN-LAST:event_BTNMOSTRARActionPerformed

    public void imprimir() throws ClassNotFoundException{
    ConexionDriverSqlServer cone = null;
        try {
            String urlreport="C:\\Users\\Pablo\\Downloads\\Proyecto_Transporte\\src\\Reportes\\lugares.jasper";
//            String path = getClass().getResource("/Reportes/lugares.jasper").getPath();
//            path=URLDecoder.decode(path,"UTF-8");
             cone=new ConexionDriverSqlServer();
            cone.conectar();
            Connection cn=cone.getConnection();
  //          Map parametro=new HashMap();
//            parametro.put("codigo", "1");
//            JasperReport reporte=(JasperReport)JRLoader.loadObject(CuLugar.class.getResource
            JasperReport reporte=JasperCompileManager.compileReport(urlreport);
//        ("/Reportes/lugares.jasper"));
            JasperPrint imprimir=JasperFillManager.fillReport(reporte, null,cn);
            JasperViewer.viewReport(imprimir);
            //JasperViewer ventana=new JasperViewer(imprimir,false);
            //ventana.setTitle("lugares");
            //ventana.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR DE REPORTE "+ e.getMessage());
        }
        cone.desconectar();
    }
    
    
    private void BTNSALIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSALIRActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_BTNSALIRActionPerformed

    private void BTNNUEVOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNNUEVOActionPerformed
        // TODO add your handling code here:
        TXTNOMBRE.setText("");
        TXTCOD.setText(lugares.ObetenerCodigo());
//        try {
//            imprimir();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(CuLugar.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_BTNNUEVOActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CuLugar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CuLugar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CuLugar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CuLugar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CuLugar().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CuLugar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNBUSCAR;
    private javax.swing.JButton BTNEDITAR;
    private javax.swing.JButton BTNMOSTRAR;
    private javax.swing.JButton BTNNUEVO;
    private javax.swing.JButton BTNREGISTRAR;
    private javax.swing.JButton BTNSALIR;
    private javax.swing.JLabel LBLCAPACIDAD;
    private javax.swing.JLabel LBLPLACA;
    private javax.swing.JTable TLUGAR;
    private javax.swing.JTextField TXTCOD;
    private javax.swing.JTextField TXTNOMBRE;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private String ConexionDriverSqlServer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}