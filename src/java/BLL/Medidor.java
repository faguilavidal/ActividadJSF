/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

/**
 *
 * @author Matias
 */
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.MeterGaugeChartModel;

@ManagedBean
public class Medidor implements Serializable{
    
    private MeterGaugeChartModel medidor1;
    
    @PostConstruct
    public void init(){
        crearMedidor();
    }

    public MeterGaugeChartModel getMedidor1() {
        return medidor1;
    }
    
    private MeterGaugeChartModel IniciarMedidor()
    {
        List<Number> intervalos = new ArrayList<Number>()
        {
            {
                add(20);
                add(50);
                add(120);
                add(220);
            }
        };
        
        return new MeterGaugeChartModel(140,intervalos);
    }
    
    public void crearMedidor()
    {
        medidor1=IniciarMedidor();
        medidor1.setTitle("Grafico");
        medidor1.setGaugeLabel("Miles de Pesos");
    }
}
