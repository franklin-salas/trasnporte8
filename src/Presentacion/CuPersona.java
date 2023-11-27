/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.DPersona;
import Negocio.NPersona;
import java.awt.List;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author FRANKLIN SALAS
 */
public class CuPersona extends javax.swing.JFrame {
     int codigo;
     int ci;
     String nombre;
     String sexo;
     String dir;
     int telf;
     String habilitado;

     int nroInt;
     String categoria;
     String cargo;
     String disponible;
     String tSocio;
     String tChofer;
     String tEmpleado;
     NPersona personas;
    /**
     * Creates new form CuSocio
     */
    public CuPersona() throws ClassNotFoundException {
        initComponents();
         this.setLocationRelativeTo(this);
         desHabilitar();
         personas=new NPersona();
         TableColumnModel columnModel = TPERSONAS.getColumnModel();
         columnModel.getColumn(0).setPreferredWidth(15);
         columnModel.getColumn(1).setPreferredWidth(15);
         columnModel.getColumn(2).setPreferredWidth(100);
         columnModel.getColumn(3).setPreferredWidth(10);
         columnModel.getColumn(4).setPreferredWidth(50);
         columnModel.getColumn(5).setPreferredWidth(15);
         columnModel.getColumn(6).setPreferredWidth(15);
         columnModel.getColumn(7).setPreferredWidth(15);
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        BTNSALIR = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TXTCARGO = new javax.swing.JTextField();
        TXTDIREC = new javax.swing.JTextField();
        TXTNOMBRE = new javax.swing.JTextField();
        TXTCOD = new javax.swing.JTextField();
        CBSEXO = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        S = new javax.swing.JRadioButton();
        C = new javax.swing.JRadioButton();
        TXTTEL = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        CBESTADO = new javax.swing.JComboBox();
        P = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        TXTCI = new javax.swing.JTextField();
        TXTINTERNO = new javax.swing.JTextField();
        CBLICENCIA = new javax.swing.JComboBox();
        BTNREGISTRAR = new javax.swing.JButton();
        BTNBUSCAR = new javax.swing.JButton();
        BTNEDITAR = new javax.swing.JButton();
        TXTDISPONIBLE = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        BTNNUEVO = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        BTNMOSTRAR1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TPERSONAS = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BTNSALIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/close.png"))); // NOI18N
        BTNSALIR.setText("SALIR");
        BTNSALIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSALIRActionPerformed(evt);
            }
        });
        jPanel1.add(BTNSALIR, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 320, 110, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario_2.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 240, 270));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("REGISTRO DE SOCIOS/CHOFER/PERSONAL");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));
        jPanel1.add(TXTCARGO, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 100, -1));
        jPanel1.add(TXTDIREC, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 270, -1));
        jPanel1.add(TXTNOMBRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 270, -1));
        jPanel1.add(TXTCOD, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 270, -1));

        CBSEXO.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELEGIR SEXO", "M", "F" }));
        jPanel1.add(CBSEXO, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, 160, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("NUMERO INTERNO");
        jLabel3.setToolTipText("");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("DIRECCION");
        jLabel4.setToolTipText("");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("CARNET IDENTIDAD");
        jLabel5.setToolTipText("");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 120, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("CODIGO");
        jLabel6.setToolTipText("");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, -1));

        S.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        S.setText("SOCIO");
        S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SActionPerformed(evt);
            }
        });
        jPanel1.add(S, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 90, 30));

        C.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        C.setText("CHOFER");
        C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CActionPerformed(evt);
            }
        });
        jPanel1.add(C, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 100, 30));
        jPanel1.add(TXTTEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 80, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("TELEFONO/CELULAR");
        jLabel7.setToolTipText("");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("CARGO");
        jLabel8.setToolTipText("");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, -1, -1));

        CBESTADO.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELEGIR ESTADO", "HABILITADO", "DESHABILITADO" }));
        jPanel1.add(CBESTADO, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, 160, -1));

        P.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        P.setText("PERSONAL");
        P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PActionPerformed(evt);
            }
        });
        jPanel1.add(P, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 130, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("NOMBRE COMPLETO");
        jLabel9.setToolTipText("");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, -1, -1));

        TXTCI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXTCIKeyTyped(evt);
            }
        });
        jPanel1.add(TXTCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 270, -1));
        jPanel1.add(TXTINTERNO, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 80, -1));

        CBLICENCIA.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CATEGORIA LICENCIA", "A", "B", "C" }));
        jPanel1.add(CBLICENCIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 180, -1));

        BTNREGISTRAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/onebit_20.png"))); // NOI18N
        BTNREGISTRAR.setText("REGISTRAR");
        BTNREGISTRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNREGISTRARActionPerformed(evt);
            }
        });
        jPanel1.add(BTNREGISTRAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 150, 40));

        BTNBUSCAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/search2.png"))); // NOI18N
        BTNBUSCAR.setText("BUSCAR");
        BTNBUSCAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNBUSCARActionPerformed(evt);
            }
        });
        jPanel1.add(BTNBUSCAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, 120, 40));

        BTNEDITAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        BTNEDITAR.setText("EDITAR");
        BTNEDITAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNEDITARActionPerformed(evt);
            }
        });
        jPanel1.add(BTNEDITAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 320, 110, 40));
        jPanel1.add(TXTDISPONIBLE, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, 80, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("DISPONIBLE");
        jLabel10.setToolTipText("");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, -1, -1));

        BTNNUEVO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonCrearNuevo.gif"))); // NOI18N
        BTNNUEVO.setText("  NUEVO");
        BTNNUEVO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNNUEVOActionPerformed(evt);
            }
        });
        jPanel1.add(BTNNUEVO, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 110, 40));

        jTabbedPane1.addTab("REGISTRO DE PERSONAS", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BTNMOSTRAR1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/stock1.png"))); // NOI18N
        BTNMOSTRAR1.setText("MOSTRAR");
        BTNMOSTRAR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNMOSTRAR1ActionPerformed(evt);
            }
        });
        jPanel2.add(BTNMOSTRAR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 40));

        TPERSONAS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "CARNET", "NOMBRE", "NRO", "DISPONIBLE", "TELEFONO", "TIPO", "HABILITADO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TPERSONAS.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        TPERSONAS.setMinimumSize(new java.awt.Dimension(0, 0));
        TPERSONAS.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(TPERSONAS);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 55, 790, 310));

        jTabbedPane1.addTab("LISTA DE DATOS", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
                
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    public void habilitar(){
        S.setEnabled(true);
        C.setEnabled(true);
        P.setEnabled(true);
    }
    
    public void desHabilitar(){
        CBLICENCIA.setEnabled(false);
        TXTINTERNO.setEnabled(false);
        TXTCARGO.setEnabled(false);
    }
    
    public void habiliatarSocio(){       
        TXTINTERNO.setEnabled(true);
        TXTCARGO.setEnabled(true);
        P.setEnabled(false);
    }
    
    public void habiliatarChofer(){
        CBLICENCIA.setEnabled(true);
        TXTINTERNO.setEnabled(true);
        P.setEnabled(false);
        if (!S.isSelected()) {
            S.setEnabled(false);
        }
    }
    
    public void habiliatarSecretaria(){
        TXTCARGO.setEnabled(true);
        S.setEnabled(false);
        C.setEnabled(false);
    }
    
    public void limpiar(){
        TXTCOD.setText("");
        TXTNOMBRE.setText("");
        TXTDIREC.setText("");
        TXTTEL.setText("");
        TXTCARGO.setText("");
        TXTINTERNO.setText("");
        TXTDISPONIBLE.setText("");
        TXTCI.setText("");
        CBESTADO.setSelectedIndex(0);
        CBSEXO.setSelectedIndex(0);
        CBLICENCIA.setSelectedIndex(0);
        S.setSelected(false);
        C.setSelected(false);
        P.setSelected(false);
        desHabilitar();
        habilitar();
    }
    
    private void BTNSALIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSALIRActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_BTNSALIRActionPerformed

    private void SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SActionPerformed
        // TODO add your handling code here:
        if (S.isSelected()) {
            habiliatarSocio();
        }else{
            TXTCARGO.setEnabled(false);
            TXTCARGO.setText("");
            if (!C.isSelected()) {
                P.setEnabled(true);
                TXTINTERNO.setEnabled(false);
                TXTINTERNO.setText("");
            }else{
                S.setEnabled(false);
            }          
        }
    }//GEN-LAST:event_SActionPerformed

    private void CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CActionPerformed
        // TODO add your handling code here:
        if (C.isSelected()) {
            habiliatarChofer();
            if (!S.isSelected()) {
                TXTINTERNO.setText("");
            }
        }else{
            CBLICENCIA.setEnabled(false);
            CBLICENCIA.setSelectedIndex(0);
            S.setEnabled(true);
            if (!S.isSelected()) {
                TXTINTERNO.setEnabled(false);
                TXTINTERNO.setText("");
                P.setEnabled(true);
            }
        }
    }//GEN-LAST:event_CActionPerformed

    private void PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PActionPerformed
        // TODO add your handling code here:
        if (P.isSelected()) {
            habiliatarSecretaria();
            TXTINTERNO.setText("");
            CBLICENCIA.setSelectedIndex(0);
        }else{
            TXTCARGO.setEnabled(false);
            TXTCARGO.setText("");
            C.setEnabled(true);
            S.setEnabled(true);
        }
    }//GEN-LAST:event_PActionPerformed
//this.tSocio=S.getText().substring(0, 1);
    private void BTNREGISTRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNREGISTRARActionPerformed
        // TODO add your handling code here:
        String resultado=""; 
        try {
         if (CBSEXO.getSelectedItem().toString().substring(0, 1).compareTo("E")==0) {
             JOptionPane.showMessageDialog(null, "ELIJA UN SEXO");
             return;
         }
         if (CBESTADO.getSelectedItem().toString().substring(0, 1).compareTo("E")==0) {
             JOptionPane.showMessageDialog(null, "ELIJA UN ESTADO");
             return;
         }
         if (C.isSelected() && CBLICENCIA.getSelectedItem().toString().length()>1) {
             JOptionPane.showMessageDialog(null, "ELIJA UNA CATEGORIA");
             return;
         }
         this.codigo=Integer.valueOf(TXTCOD.getText());
         this.ci=Integer.valueOf(TXTCI.getText());
         this.nombre=TXTNOMBRE.getText();

         this.sexo=CBSEXO.getSelectedItem().toString();
         this.dir=TXTDIREC.getText();
         this.telf=Integer.valueOf(TXTTEL.getText());
         
         this.habilitado="SI";
         this.nroInt=Integer.valueOf(TXTINTERNO.getText());
                  
         if (S.isSelected()) {
             this.tSocio=S.getText().substring(0, 1); 
             this.categoria="null";
             this.cargo=TXTCARGO.getText();}
         else{tSocio="null";}
         
         if (C.isSelected()) {
             this.tChofer=C.getText().substring(0, 1);
             this.categoria=CBLICENCIA.getSelectedItem().toString();
             this.cargo="null";
         }else{tChofer="null"; this.categoria="null";this.cargo=TXTCARGO.getText();}
         
         if (P.isSelected()) {
             this.tEmpleado="E";
             this.tChofer="null";
             this.tSocio="null";
             this.nroInt=-1;
             this.categoria="null";
             this.cargo=TXTCARGO.getText();
         }else{
             tEmpleado="null";
         }
         this.disponible=TXTDISPONIBLE.getText();
         
         resultado= personas.insertar(codigo, ci, nombre, sexo, dir, telf, habilitado, nroInt,
                 categoria, cargo, tSocio, tChofer, tEmpleado, disponible);
         JOptionPane.showMessageDialog(null, resultado);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR DE DATOS "+e.getMessage());
        }

    }//GEN-LAST:event_BTNREGISTRARActionPerformed
    
    private void BTNBUSCARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNBUSCARActionPerformed
        try {
         ci=Integer.valueOf(TXTCI.getText());
         String[] resultado=personas.Consultabuscar(TXTCI.getText());
         limpiar();
         TXTCOD.setText(resultado[0]);
         TXTCI.setText(resultado[1]);
         TXTNOMBRE.setText(resultado[2]);

         CBSEXO.setSelectedItem(resultado[3]);
        
         TXTDIREC.setText(resultado[4]);
         TXTTEL.setText(resultado[5]);
         
         if (resultado[6].compareTo("SI")==0) {
             CBESTADO.setSelectedIndex(1);            
         }else{
             CBESTADO.setSelectedIndex(2);
         }
         TXTINTERNO.setText(resultado[8]);
         CBLICENCIA.setSelectedItem(resultado[9]);
         if (resultado[7]!=null) {
             TXTCARGO.setText(resultado[7]);
         }else{
             TXTCARGO.setText("NULL");
         }
         
         if (resultado[11].compareTo("S")==0) {
             S.setSelected(true);
             habiliatarSocio();
             if (resultado[12].compareTo("C")==0) {
                 C.setSelected(true);
                 habiliatarChofer();
             }
         }else{
             if (resultado[12].compareTo("C")==0) {
                 C.setSelected(true);
                 habiliatarChofer();
             }
         }
         if (resultado[13].compareTo("E")==0) {
                P.setSelected(true);
                habiliatarSecretaria();
         }
            if (resultado[10]==null) {
                TXTDISPONIBLE.setText("NO");
            }else{
                TXTDISPONIBLE.setText(resultado[10]);
            }    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"PERSONA NO ENCONTRADO"+ e.getMessage());
        }
        
    }//GEN-LAST:event_BTNBUSCARActionPerformed

    private void BTNEDITARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNEDITARActionPerformed
        // TODO add your handling code here
        try {
            this.codigo=Integer.valueOf(TXTCOD.getText());
         this.ci=Integer.valueOf(TXTCI.getText());
         this.nombre=TXTNOMBRE.getText();

         this.sexo=CBSEXO.getSelectedItem().toString();
         this.dir=TXTDIREC.getText();
         this.telf=Integer.valueOf(TXTTEL.getText());
         
         this.habilitado=CBESTADO.getSelectedItem().toString();
            if (this.habilitado.compareTo("HABILITADO")==0) {
                this.habilitado="SI";
            }else{
                this.habilitado="NO";
            }
         this.nroInt=Integer.valueOf(TXTINTERNO.getText());
         
         this.categoria=CBLICENCIA.getSelectedItem().toString();
            if (this.categoria.length()>1) {
                categoria="null";
            }
         
         this.cargo=TXTCARGO.getText();
         if (S.isSelected()) {this.tSocio="S";}
         else{tSocio="null";}
         
         if (C.isSelected()) {this.tChofer="C"; this.cargo="NULL";}
         else{tChofer="null";this.cargo="NULL";}
         
         if (P.isSelected()) {this.tEmpleado="E";}
         else{tEmpleado="null";}
         
         this.disponible=TXTDISPONIBLE.getText();
         if (this.disponible.compareTo("")==0) {
            this.disponible="null";
         }
        
            String resultado=personas.acutalizar(codigo, ci, nombre, sexo, dir, telf, habilitado,
                    nroInt, categoria, cargo, tSocio, tChofer, tEmpleado, disponible);
            JOptionPane.showMessageDialog(null,resultado );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "DATOS NO VALIDOS "+ e.getMessage());
        }
         
        
    }//GEN-LAST:event_BTNEDITARActionPerformed

    private void BTNMOSTRAR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNMOSTRAR1ActionPerformed
        // TODO add your handling code here:
        try {
            String tipo=JOptionPane.showInputDialog(null,"INTRODUZCA TIPO DE PERSONAS 'C' CHOFERES Y 'T' TODAS");
            String[][] table=personas.listaDePersonas(tipo);
            DefaultTableModel modelo= (DefaultTableModel) TPERSONAS.getModel();
            int Tfila=modelo.getRowCount();
            if (Tfila>0) {
                for (int i = 0; i <Tfila ; i++) {
                    modelo.removeRow(0);
                }
            }
            int tuplas=table.length;
            for (int i = 0; i < tuplas; i++) {
                String [][] resultado=new String[1][1];
                if (table[i][11].compareTo("S")==0) {
                    resultado[0][0]=table[i][11];
                    if (table[i][12].compareTo("C")==0) {
                        resultado[0][0]=resultado[0][0]+" "+table[i][12];
                    }
                }else{
                    if (table[i][12].compareTo("C")==0) {
                        resultado[0][0]=table[i][12];
                    }else{
                        if (table[i][13].compareTo("E")==0) {
                            resultado[0][0]=table[i][13];
                        }
                    }
                }
                modelo.addRow(new Object[]{table[i][0],table[i][1],table[i][2],table[i][8],table[i][10],table[i][5],resultado[0][0],table[i][6]});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR DEL SISTEMA "+e.getMessage());
        }
    }//GEN-LAST:event_BTNMOSTRAR1ActionPerformed

    private void TXTCIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXTCIKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTCIKeyTyped

    private void BTNNUEVOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNNUEVOActionPerformed
        // TODO add your handling code here:
        limpiar();
        TXTCOD.setText(personas.ObetenerCodigoNuevo());
        TXTINTERNO.setText(personas.ObetenerNroIntNuevo());
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
            java.util.logging.Logger.getLogger(CuPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CuPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CuPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CuPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CuPersona().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CuPersona.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNBUSCAR;
    private javax.swing.JButton BTNEDITAR;
    private javax.swing.JButton BTNMOSTRAR1;
    private javax.swing.JButton BTNNUEVO;
    private javax.swing.JButton BTNREGISTRAR;
    private javax.swing.JButton BTNSALIR;
    private javax.swing.JRadioButton C;
    private javax.swing.JComboBox CBESTADO;
    private javax.swing.JComboBox CBLICENCIA;
    private javax.swing.JComboBox CBSEXO;
    private javax.swing.JRadioButton P;
    private javax.swing.JRadioButton S;
    private javax.swing.JTable TPERSONAS;
    private javax.swing.JTextField TXTCARGO;
    private javax.swing.JTextField TXTCI;
    private javax.swing.JTextField TXTCOD;
    private javax.swing.JTextField TXTDIREC;
    private javax.swing.JTextField TXTDISPONIBLE;
    private javax.swing.JTextField TXTINTERNO;
    private javax.swing.JTextField TXTNOMBRE;
    private javax.swing.JTextField TXTTEL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
