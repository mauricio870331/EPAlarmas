/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Pojos.Alarmas;
import com.google.gson.Gson;
import java.util.List;
import java.util.TreeMap;

public class Arreglos {



    
    

    public static void main(String[] args) throws Exception {
//        Mihilo hilo=new Mihilo();
//        CargarTerminales();
//        Thread.sleep(10000);
//        System.out.println("---");
//        CargarTerminales();
//        Set set = map.entrySet();
//        Iterator iterator = set.iterator();
//        while (iterator.hasNext()) {
//            Map.Entry mentry = (Map.Entry) iterator.next();
//            System.out.print("key is: " + mentry.getKey() + " & Value is: ");
//            System.out.println(mentry.getValue());
//        }
//        System.out.println("Map : " + map.size());
        String json = (alarmasTerminales("1"));
        Gson gson = new Gson();
        System.out.println("-- : " + json.length());
        Alarmas[] footballPlayers = gson.fromJson(json,
                Alarmas[].class);
        System.out.println("tam : " + footballPlayers.length);
        for (Alarmas footballPlayer : footballPlayers) {
            System.out.println(footballPlayer);
        }

    }

    private static String alarmasTerminales(java.lang.String condicion) {
        WS.Expal_Service service = new WS.Expal_Service();
        WS.Expal port = service.getExpalPort();
        return port.alarmasTerminales(condicion);
    }

}
