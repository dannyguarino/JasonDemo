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
            System.out.println("Erreur arguments invalide");
            System.exit(0);
        }
        String inputfile = args[0];
        String outputfile= args [1];
        
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(inputfile));
            JSONObject jsonObj = (JSONObject) obj;
            
            String client = (String) jsonObj.get("client");
            String typeContrat = (String) jsonObj.get("contrat");
            String mois = (String) jsonObj.get("mois");
            DetailClient objClient = new DetailClient(client, mois, typeContrat);
            
            JSONArray reclamations = (JSONArray) jsonObj.get("reclamations");
            
            Iterator i = reclamations.iterator();
            
            while (i.hasNext()) {
                JSONObject recDetail = (JSONObject) i.next();
                long soin = (long) recDetail.get("soin");
                String date = (String) recDetail.get("date");
                String montant = (String) recDetail.get("montant");
                objClient.ajoutReclamations(soin, date, montant);
                
            }
            
            List<DetailRecl> tableau = objClient.getReclamations();
            
            System.out.println(tableau.toString());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
