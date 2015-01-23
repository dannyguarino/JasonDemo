package javajsondemo;

import java.io.FileReader;
import java.util.Iterator;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javajsondemo.DetailClient.DetailRecl;

/**
 *
 * @author danieleguarino
 */
public class JavaJSONdemo {


    public static void main(String[] args) {
        
        if (args.length != 2) {
            System.out.println("Erreur de parametres");
            System.exit(0);
        }
        
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("inputfile.json"));
            JSONObject jsonObj = (JSONObject) obj;
            
            String client = (String) jsonObj.get("client");
            String typeContrat = (String) jsonObj.get("contrat");
            String mois = (String) jsonObj.get("mois");
            
            JSONArray reclamations = (JSONArray) jsonObj.get("reclamations");
            
            System.out.println("Client :" + client);
            System.out.println("Type de contract: " + typeContrat);
            System.out.println("Mois: " + mois);
            
            System.out.println(reclamations.toString());
            System.out.println("--------");
            
            System.out.println(reclamations.get(0).toString());
            System.out.println(reclamations.get(1).toString());
            System.out.println(reclamations.get(2).toString());
            
            DetailClient objClient = new DetailClient(client, mois, typeContrat);
            
            System.out.println("-------------------");
            System.out.println("Client :" + objClient.getClientID());
            System.out.println("Type de contract: " + objClient.getContrat());
            System.out.println("Mois: " + objClient.getDate());
            System.out.println("+++++++++++++++++++");
            
            Iterator i = reclamations.iterator();
            
            while (i.hasNext()) {
                JSONObject recDetail = (JSONObject) i.next();
                System.out.println("Soin: " + recDetail.get("soin"));
                System.out.println("Date: " + recDetail.get("date"));
                System.out.println("Montant" + recDetail.get("montant"));
                System.out.println("-----------");
                long soin = (long) recDetail.get("soin");
                String date = (String) recDetail.get("date");
                String montant = (String) recDetail.get("montant");
                System.out.println("" + soin + "," + date +"," + montant);
                objClient.ajoutReclamations(soin, date, montant);
                
            }
            System.out.println("-------------------");
            System.out.println("Client :" + objClient.getClientID());
            System.out.println("Type de contract: " + objClient.getContrat());
            System.out.println("Mois: " + objClient.getDate());
            
            System.out.println(objClient.toString());
            List<DetailRecl> tableau = objClient.getReclamations();
            
            System.out.println(tableau.toString());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
