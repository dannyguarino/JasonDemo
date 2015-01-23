package javajsondemo;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author danieleguarino
 */
public class DetailClient {

    String pattern = "yyyy-MM";
    SimpleDateFormat format = new SimpleDateFormat(pattern);

    final private String clientID;
    final private String date;
    final private String contrat;
    private ArrayList<DetailRecl> reclamations = new ArrayList();

    public DetailClient(String id, String date, String contrat) {
        this.clientID = id;
        this.date = date;
        this.contrat = contrat;
    }

    public void ajoutReclamations(long soin, String date, String montant) {
        reclamations.add(new DetailRecl(soin, date, montant));
    }

    public String getClientID() {
        return clientID;
    }

    public String getDate() {
        return date;
    }

    public String getContrat() {
        return contrat;
    }

    public List<DetailRecl> getReclamations() {
        return reclamations;
    }

    @Override
    public String toString() {
        Iterator i = reclamations.iterator();
        
        while (i.hasNext()) {
            DetailRecl detail = (DetailRecl) i.next();
            System.out.println("Soin: " + detail.getSoin() + ", Date: "
                + detail.getDate() + ", Amount: " + detail.getMontant());
        }
        
        return null;
    }

    protected class DetailRecl {

        private long soin;
        private String date;
        private String montant;

        public DetailRecl(long soin, String date, String montant) {
            this.soin = soin;
            this.date = date;
            this.montant = montant;
        }

        public long getSoin() {
            return soin;
        }

        public String getDate() {
            return date;
        }

        public String getMontant() {
            return montant;
        }
        

    }

}
