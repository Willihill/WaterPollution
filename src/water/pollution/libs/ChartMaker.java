/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package water.pollution.libs;

import java.awt.Dimension;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import water.pollution.model.Entity.*;

public class ChartMaker {
    
    public CategoryDataset CreateDataSet(ArrayList<Rio> data, String tipo){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        int i = 0;
        for(Rio rio : data){
            if(tipo.equals("P")){
                dataSet.addValue(rio.Quantidade, rio.Nome + " - " + rio.Ano, rio.TipoPoluicao + "(" + rio.Ano.toString().substring(2, 4) + ")");
            }else{
                dataSet.addValue(rio.Quantidade, rio.Nome, rio.Ano);
            }
            i++;
        }
        
        return dataSet;
    }
    
    public JFreeChart CreateBarChart(CategoryDataset dataSet, String tipo){
        JFreeChart chartBar = ChartFactory.createBarChart((tipo == "P" ? "Poluições" : "Rios"), "", "Nível de poluição (%)", dataSet, PlotOrientation.VERTICAL, true, true, false);
        return chartBar;
    }
    
    public ChartPanel CreateChart(ArrayList<Rio> data, String tipo){
        
        CategoryDataset dataSet  = this.CreateDataSet(data, tipo);
        
        JFreeChart chart = this.CreateBarChart(dataSet, tipo);
        ChartPanel chartGrafic = new ChartPanel(chart);
        chartGrafic.setPreferredSize(new Dimension(400, 400));
        
        return chartGrafic;        
    }
    
}