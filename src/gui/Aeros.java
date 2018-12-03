/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import connection.Buscas;
import connection.ConnectionDB;
import connection.Dados;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Maximiliano Meyer
 */
public class Aeros extends javax.swing.JFrame {
    
    public Aeros() {
        initComponents();
        setTitle("Busca de voos através dos aeroportos");

        DefaultTableModel modelo = (DefaultTableModel) tableAero.getModel();
        tableAero.setRowSorter(new TableRowSorter(modelo));
        tableAero.setDefaultRenderer(Object.class, new Aeros.CellRenderer2()); 
        modelo.setNumRows(0);
        setLocationRelativeTo(null);
        popularCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboAero = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        check1 = new javax.swing.JCheckBox();
        check2 = new javax.swing.JCheckBox();
        LimparDist = new javax.swing.JButton();
        FiltrarDist = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAero = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        sub1 = new javax.swing.JTextField();
        sub2 = new javax.swing.JTextField();
        sub3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboAn = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        comboAero.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        comboAero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAeroActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Buscar voos do aeroporto");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar como"));

        check1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        check1.setText("Origem");
        check1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check1ActionPerformed(evt);
            }
        });

        check2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        check2.setText("Destino");
        check2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(check1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check2))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(check1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(check2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LimparDist.setText("Limpar");
        LimparDist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimparDistActionPerformed(evt);
            }
        });

        FiltrarDist.setText("Filtrar");
        FiltrarDist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltrarDistActionPerformed(evt);
            }
        });

        tableAero.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tableAero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Voo", "Origem", "Destino"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableAero);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        sub1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        sub1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sub1ActionPerformed(evt);
            }
        });

        sub2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        sub3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Aeroporto");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Cidade");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Estado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sub2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                    .addComponent(sub1)
                    .addComponent(sub3))
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sub1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sub2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sub3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(5, 5, 5))
        );

        comboAn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        comboAn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "2006", "2007", "2008" }));
        comboAn.setToolTipText("");
        comboAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Ano");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboAn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(comboAero, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FiltrarDist, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LimparDist, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(FiltrarDist))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LimparDist)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboAero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAnActionPerformed

    }//GEN-LAST:event_comboAnActionPerformed

    private void FiltrarDistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltrarDistActionPerformed

        buscarAero((String) comboAero.getSelectedItem(), check1.isSelected(), check2.isSelected(), (String) comboAn.getSelectedItem());
    }//GEN-LAST:event_FiltrarDistActionPerformed

    private void LimparDistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimparDistActionPerformed
        check1.setSelected(false);
        check2.setSelected(false);
        comboAero.setSelectedIndex(0);
        comboAn.setSelectedIndex(0);
        sub1.setText("");
        sub2.setText("");
        sub3.setText("");
        DefaultTableModel modelo = (DefaultTableModel) tableAero.getModel();
        modelo.setNumRows(0);
    }//GEN-LAST:event_LimparDistActionPerformed

    private void check2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check2ActionPerformed

    private void check1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check1ActionPerformed

    private void comboAeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboAeroActionPerformed

    private void sub1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sub1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sub1ActionPerformed
 
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
            java.util.logging.Logger.getLogger(Aeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aeros().setVisible(true);
            }
        });
    }
    
    public class CellRenderer2 extends DefaultTableCellRenderer {           //Código para centralizar os dados dentro da JTable
	public CellRenderer2() {
		super();
	}
        public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		this.setHorizontalAlignment(CENTER);
		return super.getTableCellRendererComponent(table, value, isSelected,
				hasFocus, row, column);
	}
    }
    
    public void popularCombo() {
        Connection con = ConnectionDB.getConnection(); //faz a conexão ao DB
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
       try {
            stmt = con.prepareStatement("Select * from Aeros"); // Faz a busca de todo o conteúdo da tabela
            rs = stmt.executeQuery();   //Coloca em um resultado para poder exibir

            while (rs.next()) {     //Enquanto tiver valores ele vai executar           
                
               comboAero.addItem(rs.getString("Aeros"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Algo de errado não está certo");
        } finally {                 // Processo que será sempre executado. Com sucesso ou erro das partes anteriores
            ConnectionDB.closeConnection(con, stmt, rs);   //Após o uso o finally fechará as conexões abertas por motivos de segurança
        }
    }

    public void buscarAero(String aero, boolean check1, boolean check2, String ano){
        
        DefaultTableModel modelo = (DefaultTableModel) tableAero.getModel();
                
        if ( !"".equals(aero) && check1 == false && check2 == false){                                                    //Caso nenhum mês esteja selecionado no filtro ele não faz a busca por mês
        JOptionPane.showConfirmDialog(null, "Selecione ao menos uma das opções: \n\n Origem \nDestino");
        } else {
        
        modelo.setNumRows(0);                                                       //Para não replicar os dados após aplicar filtreos
        Buscas tabela = new Buscas();
        
        for (Dados x: tabela.buscarAero(aero, check1, check2, ano)){
            
            modelo.addRow(new Object[]{
                x.getFlightNum(),  
                x.getOrigin(),    
                x.getDest(),  
                
            });
        }
        dadosAero(aero);   
      }
    } 
    
    
    
    public void dadosAero(String aero){
        Connection con = ConnectionDB.getConnection(); //faz a conexão ao DB
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM `aeros` WHERE Aeros = '" + aero + "'"); // Faz a busca de todo o conteúdo da tabela
            rs = stmt.executeQuery();   //Coloca em um resultado para poder exibir

            while (rs.next()) {     //Enquanto tiver valores ele vai executar           
                
               String x = (rs.getString("Aeroporto"));
               sub1.setText(x);
               x = (rs.getString("Cidade"));
               sub2.setText(x);
               x = (rs.getString("Estado"));
               sub3.setText(x);
               
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        } finally {                 // Processo que será sempre executado. Com sucesso ou erro das partes anteriores
            ConnectionDB.closeConnection(con, stmt, rs);   //Após o uso o finally fechará as conexões abertas por motivos de segurança
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FiltrarDist;
    private javax.swing.JButton LimparDist;
    private javax.swing.JCheckBox check1;
    private javax.swing.JCheckBox check2;
    private javax.swing.JComboBox<String> comboAero;
    private javax.swing.JComboBox<String> comboAn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField sub1;
    private javax.swing.JTextField sub2;
    private javax.swing.JTextField sub3;
    private javax.swing.JTable tableAero;
    // End of variables declaration//GEN-END:variables
}