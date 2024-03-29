/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package water.pollution.forms;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.sun.prism.paint.Color;
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import water.pollution.model.ConexaoDB;
import water.pollution.libs.*;
import water.pollution.model.Entity.Rio;

/**
 *
 * @author willi
 */
public class AnaliseRioPoluicao extends javax.swing.JFrame {

    /**
     * Creates new form AnaliseRioPoluicao
     */
    public AnaliseRioPoluicao() {
        initComponents();
        
        // Para fechar apenas a propria tela no X
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        //Ícone do título
        URL url = this.getClass().getResource("iconeTitulo.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
        
        FlowLayout flow = new FlowLayout();
        flow.setAlignment(FlowLayout.LEFT);
        pnCharts.setLayout(flow);
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        cboRio = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        cboPoluicao = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cmdAtualizar = new javax.swing.JButton();
        pnCharts = new java.awt.Panel();
        pnChartPoluicao = new java.awt.Panel();
        pnChartRio = new java.awt.Panel();
        cboAno = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cboOrdenacao = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analise de Rio");
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1100, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 500));
        setType(java.awt.Window.Type.POPUP);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cboRio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panel1.add(cboRio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 38, 251, 34));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Rio");
        panel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 40, 15));

        cboPoluicao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboPoluicao.setMaximumRowCount(30);
        panel1.add(cboPoluicao, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 210, 34));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Poluição");
        panel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, 15));

        cmdAtualizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmdAtualizar.setText("Atualizar");
        cmdAtualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdAtualizarMouseClicked(evt);
            }
        });
        panel1.add(cmdAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 40, 140, 34));

        pnCharts.setPreferredSize(new java.awt.Dimension(1040, 540));
        pnCharts.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                pnChartsComponentAdded(evt);
            }
        });
        pnCharts.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                pnChartsComponentResized(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                pnChartsComponentShown(evt);
            }
        });

        pnChartPoluicao.setBackground(new java.awt.Color(255, 204, 0));
        pnChartPoluicao.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                pnChartPoluicaoComponentAdded(evt);
            }
        });
        pnChartPoluicao.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                pnChartPoluicaoComponentShown(evt);
            }
        });

        javax.swing.GroupLayout pnChartPoluicaoLayout = new javax.swing.GroupLayout(pnChartPoluicao);
        pnChartPoluicao.setLayout(pnChartPoluicaoLayout);
        pnChartPoluicaoLayout.setHorizontalGroup(
            pnChartPoluicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 681, Short.MAX_VALUE)
        );
        pnChartPoluicaoLayout.setVerticalGroup(
            pnChartPoluicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnChartRio.setBackground(new java.awt.Color(204, 204, 204));
        pnChartRio.setName(""); // NOI18N
        pnChartRio.setPreferredSize(new java.awt.Dimension(410, 380));

        javax.swing.GroupLayout pnChartRioLayout = new javax.swing.GroupLayout(pnChartRio);
        pnChartRio.setLayout(pnChartRioLayout);
        pnChartRioLayout.setHorizontalGroup(
            pnChartRioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        pnChartRioLayout.setVerticalGroup(
            pnChartRioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnChartsLayout = new javax.swing.GroupLayout(pnCharts);
        pnCharts.setLayout(pnChartsLayout);
        pnChartsLayout.setHorizontalGroup(
            pnChartsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChartsLayout.createSequentialGroup()
                .addComponent(pnChartRio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnChartPoluicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnChartsLayout.setVerticalGroup(
            pnChartsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnChartRio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnChartPoluicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        panel1.add(pnCharts, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1090, 480));

        cboAno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panel1.add(cboAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 78, 34));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Ano");
        panel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, -1, 15));

        cboOrdenacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboOrdenacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Crescente", "Decrescente" }));
        panel1.add(cboOrdenacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, 120, 34));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Ordenação");
        panel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 90, 15));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1099, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        /** Populando os combos da tela */
        this.PopularCombos();

        /** Monta o grafico */
        this.MakerChartPollution();
        this.MakerChartWater();
        pack();        
    }//GEN-LAST:event_formWindowOpened

    /**
     * Popula os combos de opções da tela (Rio, Poluição)
     */
    private void PopularCombos(){
        /** Carregando os Rios */
        ResultSet rios;
        try{
            // Consultando os rios
            rios = ConexaoDB.ExecuteSelect("SELECT * FROM RIO");
            
            // Removendo so rios ja existentes no combo e adicionandos os retornados na pesquisa
            cboRio.removeAllItems();
            cboRio.addItem("Todos");
            while(rios.next()){
                cboRio.addItem(rios.getString("_ID") + " - " + rios.getString("Nome"));
            }
            
            // Caso não tenha nenhum rio, sai da tela
            if(cboRio.getItemCount() <= 0){
                JOptionPane.showMessageDialog(null, "Nenhum rio cadastrado.");
                this.CloseFrame();
            }
            
            rios.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao consultar os rios. Motivo: " + e.getMessage());
            return;
        }
        
        /** Carregando as poluicoes */
        ResultSet poluicoes;
        try{
            // Consultando os rios
            poluicoes = ConexaoDB.ExecuteSelect("SELECT * FROM TipoPoluicao");
            
            if(poluicoes == null){
                return;
            }
            
            // Removendo as poluicoes ja existentes no combo e adicionandos as retornados na pesquisa
            cboPoluicao.removeAllItems();
            cboPoluicao.addItem("Todos");
            while(poluicoes.next()){
                cboPoluicao.addItem(poluicoes.getString("_ID") + " - " + poluicoes.getString("Nome"));
            }
            
            // Caso não tenha nenhum poluicao, sai da tela
            if(cboPoluicao.getItemCount() <= 0){
                JOptionPane.showMessageDialog(null, "Nenhum tipo de poluição foi cadastrado.");
                this.CloseFrame();
            }
            
            rios.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao consultar os tipos de poluições. Motivo: " + e.getMessage());
            return;
        }
        
        /** Popukando os anos */
        cboAno.removeAllItems();
        for(int i = 0; i < 35; i++){
            cboAno.addItem(2019 - i);
        }
        
    }
    
    /**
     * Função para fechar a tela
     */
    private void CloseFrame(){
        this.setVisible(false);
        dispose();
    }
    
    /**
     * Função para montar o gráfico das poluições
     */
    private void MakerChartPollution(){
        ArrayList<Rio> dataChartPollution = new ArrayList<Rio>();
        
        // Os rios e suas poluições pela View
        try{
            String sql = "SELECT * FROM VW_POLUICAO";
            String filter = "";
            
            ArrayList<Object> params = new ArrayList<Object>();
            
            // Adicionando filtro de RIo
            if(cboRio.getSelectedIndex() > 0){
                filter += " AND _ID = ?";
                        
                // Pega o ID do rio selecionado
                String display = cboRio.getSelectedItem().toString();
                int hifen = display.indexOf(" - ");
                int idRio = Integer.parseInt(display.substring(0, hifen).trim());
                params.add(idRio);
            }
            
            
            // Pega o ID da poluição selecionada
            if(cboPoluicao != null && cboPoluicao.getSelectedIndex() > 0){
                String displayPol = cboPoluicao.getSelectedItem().toString();
                int sep = displayPol.indexOf(" - ");
                int idPol = Integer.parseInt(displayPol.substring(0, sep).trim());
                filter += " AND IdPoluicao = ?";
                params.add(idPol);
            }
            
            // Filtra o ano
            filter += " AND Ano = ?";
            params.add(Integer.parseInt(cboAno.getSelectedItem().toString()));
            
            // Adiciona a WHERE na select
            if(filter.length() > 0){
                sql += " WHERE " + filter.substring(5);
            } 

            // Prepara a query
            PreparedStatement query = ConexaoDB.getNewPreparedStatement(sql);
            
            // Adicionando parametros
            for (int i = 0; i < params.size(); i++) {
                query.setObject(i + 1, params.get(i));
            }
            
            //ResultSet analiseBD = ConexaoDB.ExecuteSelect("SELECT * FROM VW_POLUICAO ORDER BY ANO ASC");
            ResultSet analiseBD = query.executeQuery();
            
            while(analiseBD.next()){
                Rio newRio = new Rio();
                newRio.id = analiseBD.getInt("_ID");
                newRio.Nome = analiseBD.getString("Nome");
                newRio.TipoPoluicao = analiseBD.getString("TipoPoluicao");
                newRio.Ano = analiseBD.getInt("Ano");
                newRio.Quantidade = analiseBD.getFloat("Quantidade");

                dataChartPollution.add(newRio);
            }
            
            analiseBD.close();
            query.close();            
        }catch(Exception e){
            if(e.getMessage() != null){
                JOptionPane.showMessageDialog(null, "Erro ao montar grafico de poluição: " + e.getMessage());                
            }
            
            return;
        }
        
        ChartMaker newChart = new ChartMaker();
        
        this.pnChartPoluicao.removeAll();
        this.pnChartPoluicao.setLayout(new FlowLayout());
        this.pnChartPoluicao.setPreferredSize(new Dimension(730, pnCharts.getHeight()));
        this.pnChartPoluicao.setBackground(java.awt.Color.white);
                
        ChartPanel chartFinal = newChart.CreateChart(OrdenarRios(dataChartPollution), "P");
        chartFinal.setPreferredSize(new Dimension(this.pnChartPoluicao.getWidth(), this.pnChartPoluicao.getHeight()-20));
        chartFinal.setLocation(0,0);

        this.pnChartPoluicao.add(chartFinal);
    }
    
    /**
     * Função para montar o gráfico das rios
     */
    private void MakerChartWater(){
        ArrayList<Rio> dataChart = new ArrayList<Rio>();
        
        // Os rios e suas poluições pela View
        try{            
            String sql = "SELECT * FROM VW_RIO";
            String filter = "";
            ArrayList<Object> params = new ArrayList<Object>();
                        
            // Adicionando filtro de RIo
            if(cboRio.getSelectedIndex() > 0){
                filter += " AND _ID = ?";
                        
                // Pega o ID do rio selecionado
                String display = cboRio.getSelectedItem().toString();
                int hifen = display.indexOf(" - ");
                int idRio = Integer.parseInt(display.substring(0, hifen).trim());
                params.add(idRio);
            }
            
            // Adiciona a WHERE na select
            if(filter.length() > 0){
                sql += " WHERE " + filter.substring(5);
            }             
            
            PreparedStatement query = ConexaoDB.getNewPreparedStatement(sql);
            
            // Adicionando parametros
            for (int i = 0; i < params.size(); i++) {
                query.setObject(i + 1, params.get(i));
            }
            
            ResultSet analiseBD = query.executeQuery();
            
            while(analiseBD.next()){
                Rio newRio = new Rio();
                newRio.id = analiseBD.getInt("_ID");
                newRio.Nome = analiseBD.getString("Nome");
                newRio.Ano = analiseBD.getInt("Ano");
                newRio.Quantidade = analiseBD.getFloat("Total");

                dataChart.add(newRio);
            }
            
            analiseBD.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao montar grafico de Rios: " + e.getMessage());
        }
        
        ChartMaker newChart = new ChartMaker();
        
        this.pnChartRio.removeAll();
        this.pnChartRio.setLayout(new FlowLayout());
        this.pnChartRio.setPreferredSize(new Dimension(350, pnCharts.getHeight()));
        this.pnChartRio.setBackground(java.awt.Color.white);
        
        ChartPanel chartFinal = newChart.CreateChart(OrdenarRios(dataChart), "R");
        chartFinal.setPreferredSize(new Dimension(pnChartRio.getWidth(), pnChartRio.getHeight()-20));
        chartFinal.setLocation(0,0);
        this.pnChartRio.add(chartFinal);
    }
    
    /**
     * Realiza a ordenação de um Array de Rios, conforme selecionado no ComboBox de ordenação
     * @param rios
     * @return 
     */
    private ArrayList<Rio> OrdenarRios(ArrayList<Rio> rios){
        if(cboOrdenacao.getSelectedIndex() == 0){
            return OrdenarRioAsc(rios);            
        }else{
            return OrdenarRioDesc(rios);
        }        
    }
    
    /**
     * Realiza a ordenação de um Array de Rios de forma Decrescente 
     * 
     * @param rios
     * @return 
     */
    private ArrayList<Rio> OrdenarRioDesc(ArrayList<Rio> rios){
        ArrayList<Rio> arrayOrdenado = new ArrayList<Rio>();

        while(rios.size() > 0){
            for (int i = 0; i < rios.size(); i++) {
                Rio rio = rios.get(i);

                if(!TemMaior(rio.Quantidade, i, rios)){
                    arrayOrdenado.add(rio);
                    rios.remove(i);
                }
            }
        }
        
        return arrayOrdenado;
    }
    
    private Boolean TemMaior(float value, int indexAtual, ArrayList<Rio> lista){
        Boolean ret = false;
        for (int i = 0; i < lista.size(); i++) {
            Rio rio = lista.get(i);
            
            // caso exista um cara maior que ele, deve retornar true
            if(i != indexAtual && rio.Quantidade > value){
                ret = true;
            }
        }
        return ret;
    }
    
    /**
     * Realiza a ordenação de um Array de Rios de forma Crescente
     * 
     * @param rios
     * @return 
     */
    private ArrayList<Rio> OrdenarRioAsc(ArrayList<Rio> rios){
        ArrayList<Rio> arrayOrdenado = new ArrayList<Rio>();
        
        while(rios.size() > 0){
            for (int i = 0; i < rios.size(); i++) {
                Rio rio = rios.get(i);

                if(!TemMenor(rios, i)){
                    arrayOrdenado.add(rio);
                    rios.remove(i);
                }
            }
        }
        
        return arrayOrdenado;
    }
    
    private Boolean TemMenor(ArrayList<Rio> lista, int indexAtual){
        for (int i = 0; i < lista.size(); i++) {
            Rio get = lista.get(i);
            
            if(get.Quantidade < lista.get(indexAtual).Quantidade){
                return true;
            }   
        }
        
        return false;
    }
    
    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized

    }//GEN-LAST:event_formComponentResized

    private void cmdAtualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdAtualizarMouseClicked
        /** Monta o grafico */
        this.MakerChartPollution();
        this.MakerChartWater();
        pack();
    }//GEN-LAST:event_cmdAtualizarMouseClicked

    private void pnChartsComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pnChartsComponentResized

    }//GEN-LAST:event_pnChartsComponentResized

    private void pnChartsComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pnChartsComponentShown

    }//GEN-LAST:event_pnChartsComponentShown

    private void pnChartsComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_pnChartsComponentAdded

    }//GEN-LAST:event_pnChartsComponentAdded

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown

    }//GEN-LAST:event_formComponentShown

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void pnChartPoluicaoComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pnChartPoluicaoComponentShown
        /** Monta o grafico */
        this.MakerChartPollution();
        this.MakerChartWater();
        pack();
    }//GEN-LAST:event_pnChartPoluicaoComponentShown

    private void pnChartPoluicaoComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_pnChartPoluicaoComponentAdded

    }//GEN-LAST:event_pnChartPoluicaoComponentAdded

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
            java.util.logging.Logger.getLogger(AnaliseRioPoluicao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnaliseRioPoluicao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnaliseRioPoluicao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnaliseRioPoluicao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnaliseRioPoluicao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboAno;
    private javax.swing.JComboBox cboOrdenacao;
    private javax.swing.JComboBox cboPoluicao;
    private javax.swing.JComboBox cboRio;
    private javax.swing.JButton cmdAtualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private java.awt.Panel panel1;
    private java.awt.Panel pnChartPoluicao;
    private java.awt.Panel pnChartRio;
    private java.awt.Panel pnCharts;
    // End of variables declaration//GEN-END:variables
}