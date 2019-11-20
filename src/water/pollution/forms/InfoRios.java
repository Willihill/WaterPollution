package water.pollution.forms;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import water.pollution.model.Entity.RioPoluicao;
import java.sql.ResultSet;
import java.sql.SQLException;
import water.pollution.model.*;

public class InfoRios extends javax.swing.JFrame {
    public RioPoluicao Data;
    
    public InfoRios () {
        initComponents();        
        // Para fechar apenas a propria tela no X
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        //Ícone do Form
        URL url = this.getClass().getResource("iconeTitulo.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
        
        // Centro da tela
        this.setLocationRelativeTo(null);
        
        PopularCombos();
    }
    
    private void PopularCombos(){
        
        // Populando combo de tipo de poluição
        try{
            ResultSet tipos = ConexaoDB.ExecuteSelect("SELECT * FROM TipoPoluicao");
            
            cboTipoPoluicao.removeAllItems();
            while(tipos.next()){
                cboTipoPoluicao.addItem(tipos.getString("_ID") + " - " + tipos.getString("Nome"));
            }
            
            tipos.close();
        }catch(Exception e){
        }
        
        /** Populando os anos */
        cboAno.removeAllItems();
        for(int i = 0; i < 35; i++){
            cboAno.addItem(String.valueOf(2019 - i));
        }
        
        /** Populando as quantidades */
        cboQuantidade.removeAllItems();
        for(int i = 0; i < 100; i = i+5){
            cboQuantidade.addItem(String.valueOf(100 - i));
        }
        
    }
    
    private void PopularCamposData(){
        if(Data == null){
            return;            
        }
        
        txtIDRIO.setText(Data.Fk_rio.toString());
        txtNOMERIO.setText(Data.NomeRio);
        cboAno.setSelectedItem(Data.Ano.toString());
        
        cboTipoPoluicao.setSelectedItem(Data.Fk_tipopoluicao.toString() + " - " + Data.NomeTipoPoluicao);
        
        String qtd = Data.Quantidade.toString().substring(0, Data.Quantidade.toString().indexOf("."));
        cboQuantidade.setSelectedItem(qtd);
    }
    
    private static final long serialVersionUID = 1L;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_codrio = new javax.swing.JLabel();
        txtIDRIO = new javax.swing.JTextField();
        txtNOMERIO = new javax.swing.JTextField();
        lb_nomerio = new javax.swing.JLabel();
        lb_tipopoluição = new javax.swing.JLabel();
        cboTipoPoluicao = new javax.swing.JComboBox<String>();
        lb_anorio = new javax.swing.JLabel();
        lb_nivelrio = new javax.swing.JLabel();
        bt_cadastrar = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();
        cboAno = new javax.swing.JComboBox<String>();
        cboQuantidade = new javax.swing.JComboBox<String>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de poluição");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lb_codrio.setText("Cod. Rio:");

        txtIDRIO.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIDRIOFocusLost(evt);
            }
        });

        txtNOMERIO.setEditable(false);
        txtNOMERIO.setToolTipText("");
        txtNOMERIO.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                txtNOMERIOComponentRemoved(evt);
            }
        });
        txtNOMERIO.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNOMERIOFocusLost(evt);
            }
        });
        txtNOMERIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNOMERIOActionPerformed(evt);
            }
        });

        lb_nomerio.setText("Nome do Rio:");

        lb_tipopoluição.setText("Tipo de Poluição:");

        cboTipoPoluicao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipo", "Plástico", "Hospitalar", "Esgoto" }));
        cboTipoPoluicao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboTipoPoluicaoMouseClicked(evt);
            }
        });
        cboTipoPoluicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoPoluicaoActionPerformed(evt);
            }
        });

        lb_anorio.setText("Ano:");

        lb_nivelrio.setText("Nível de Poluição (%)");

        bt_cadastrar.setText("Salvar");
        bt_cadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_cadastrarMouseClicked(evt);
            }
        });
        bt_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastrarActionPerformed(evt);
            }
        });

        bt_cancelar.setText("Cancelar");
        bt_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_cancelarMouseClicked(evt);
            }
        });
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });

        cboAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ano", "1990", "19911", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020" }));
        cboAno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboAnoMouseClicked(evt);
            }
        });
        cboAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAnoActionPerformed(evt);
            }
        });

        cboQuantidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nivel", "0%", "5%", "10%", "15%", "20%", "25%", "30%", "35%", "40%", "45%", "50%", "55%", "60%", "65%", "70%", "75%", "80%", "85%", "90%", "95%", "100%" }));
        cboQuantidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboQuantidadeMouseClicked(evt);
            }
        });
        cboQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboQuantidadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIDRIO, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_codrio))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_nomerio)
                            .addComponent(txtNOMERIO, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lb_tipopoluição)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lb_anorio)
                                .addGap(69, 69, 69))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cboTipoPoluicao, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(cboAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_nivelrio)
                            .addComponent(cboQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(bt_cadastrar)
                .addGap(56, 56, 56)
                .addComponent(bt_cancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_codrio)
                    .addComponent(lb_nomerio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIDRIO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNOMERIO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_tipopoluição, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_nivelrio)
                    .addComponent(lb_anorio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTipoPoluicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_cadastrar)
                    .addComponent(bt_cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboTipoPoluicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipoPoluicaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTipoPoluicaoActionPerformed

    private void bt_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_cadastrarActionPerformed

    private void cboAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboAnoActionPerformed

    private void txtNOMERIOFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNOMERIOFocusLost

    }//GEN-LAST:event_txtNOMERIOFocusLost

    private void txtIDRIOFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDRIOFocusLost
        try {
            Integer id = 0;
            try{
                id = Integer.parseInt(txtIDRIO.getText());
            }catch(Exception e){}
            
            if(id < 1){
                return;                
            }
            
            PreparedStatement query = ConexaoDB.getNewPreparedStatement("SELECT * FROM RIO WHERE _ID = ?");
            query.setInt(1, id);

            ResultSet result = query.executeQuery();

            result.next();
            if(result.getRow() == 0){
                JOptionPane.showMessageDialog(null, "Rio não encontrado.");
                txtNOMERIO.setText("");
                return;
            }

            txtNOMERIO.setText(result.getString("Nome"));
            
            result.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar rio: " + ex.getMessage());
        }
    }//GEN-LAST:event_txtIDRIOFocusLost

    private void txtNOMERIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNOMERIOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNOMERIOActionPerformed

    private void txtNOMERIOComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_txtNOMERIOComponentRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNOMERIOComponentRemoved

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
     
    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void cboQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboQuantidadeActionPerformed

    private void cboTipoPoluicaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboTipoPoluicaoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTipoPoluicaoMouseClicked

    private void cboAnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboAnoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cboAnoMouseClicked

    private void cboQuantidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboQuantidadeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cboQuantidadeMouseClicked

    private void bt_cadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_cadastrarMouseClicked
        if(!ValidarCampos()){
            return;
        }
        
        if(Data == null){
            Data = new RioPoluicao();
        }else{
            Data.Acao = "A";
        }
        
        Data.Fk_rio = Integer.parseInt(txtIDRIO.getText());
        Data.NomeRio = txtNOMERIO.getText();

        String displayPol = cboTipoPoluicao.getSelectedItem().toString();
        int sep = displayPol.indexOf(" - ");
        int idPol = Integer.parseInt(displayPol.substring(0, sep).trim());
        String nomePol = displayPol.substring(sep+3).trim();

        Data.Fk_tipopoluicao = idPol;
        Data.NomeTipoPoluicao = nomePol;
        Data.Ano = Integer.parseInt(cboAno.getSelectedItem().toString());
        Data.Quantidade = Float.parseFloat(cboQuantidade.getSelectedItem().toString());
        
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_bt_cadastrarMouseClicked

    private Boolean ValidarCampos(){
        
        /** Validando RIo */
        if(txtNOMERIO.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Rio inválido!");
            return false;
        }
           
        return true;
    }
    
    private void bt_cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_cancelarMouseClicked
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_bt_cancelarMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        PopularCamposData();
    }//GEN-LAST:event_formWindowOpened
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
            java.util.logging.Logger.getLogger(InfoRios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfoRios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfoRios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoRios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new InfoRios().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cadastrar;
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JComboBox<String> cboAno;
    private javax.swing.JComboBox<String> cboQuantidade;
    private javax.swing.JComboBox<String> cboTipoPoluicao;
    private javax.swing.JLabel lb_anorio;
    private javax.swing.JLabel lb_codrio;
    private javax.swing.JLabel lb_nivelrio;
    private javax.swing.JLabel lb_nomerio;
    private javax.swing.JLabel lb_tipopoluição;
    private javax.swing.JTextField txtIDRIO;
    private javax.swing.JTextField txtNOMERIO;
    // End of variables declaration//GEN-END:variables

    private static class jTableRios {

        public jTableRios() {
        }
    }
}
