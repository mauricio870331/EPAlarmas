/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Pojos.Alarmas;
import com.google.gson.Gson;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author admin
 */
@Named(value = "beanSemaforo")
@ViewScoped
public class BeanSemaforo implements Serializable {

//    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/192.168.20.2_6161/WSExpal/Expal.wsdl")
//    private Expal_Service service;

    List<Alarmas> listAlarmas = new ArrayList();

    @PostConstruct
    public void init() {
        try {
            System.out.println("ENtro al construcot");
            cargaDatos();
        } catch (Exception ex) {
            System.out.println("Error : " + ex.toString());
            Logger.getLogger(BeanSemaforo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargaDatos() {
        String json = alarmasTerminales("1");
        if (json.length() > 0) {
            Gson gson = new Gson();
            Alarmas[] alarma = gson.fromJson(json,
                    Alarmas[].class);
            System.out.println("Retotmo : " + alarma.length);
            for (Alarmas alarmaobj : alarma) {
                listAlarmas.add(alarmaobj);
            }
            for (Alarmas listAlarma : listAlarmas) {
                System.out.println(": " + listAlarma.toString());
            }
        }
    }

    public List<Alarmas> getListAlarmas() {
        return listAlarmas;
    }

    public void setListAlarmas(List<Alarmas> listAlarmas) {
        this.listAlarmas = listAlarmas;
    }

    private static String alarmasTerminales(java.lang.String condicion) {
        WS.Expal_Service service = new WS.Expal_Service();
        WS.Expal port = service.getExpalPort();
        return port.alarmasTerminales(condicion);
    }


}
