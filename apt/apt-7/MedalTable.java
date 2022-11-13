import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MedalTable {
    public String[] generate(String[] results) {
        Map<String,MedalCountry> map = new HashMap<String, MedalCountry>();
        for(String s : results) {
            String[] data = s.split(" ");
            int place = 1;
            for(String c : data) {
                if (!map.containsKey(c)) {
                    map.put(c, new MedalCountry(c));
                }
                if(place == 1) {
                    map.get(c).addGold();
                }
                if(place == 2) {
                    map.get(c).addSilver();
                }
                if(place == 3) {
                    map.get(c).addBronze();
                }
                place ++;
            }
        }
        
        ArrayList<MedalCountry> list = new ArrayList<>(map.values());
        Comparator<MedalCountry> gold = Comparator.comparing(MedalCountry::getGold).reversed();
        Comparator<MedalCountry> silver = Comparator.comparing(MedalCountry::getSilver).reversed();
        Comparator<MedalCountry> bronze = Comparator.comparing(MedalCountry::getBronze).reversed();
        Comparator<MedalCountry> country = Comparator.comparing(MedalCountry::getName);
        Comparator<MedalCountry> comp = gold.thenComparing(silver).thenComparing(bronze).thenComparing(country);
        Collections.sort(list,comp);
        
        ArrayList<String> returnList = new ArrayList<String>();

        for(MedalCountry entry : list) {
            returnList.add(entry.toString());
        }
        return returnList.toArray(new String[0]);
    }
  }

class MedalCountry{
    String myName;
    int myGold;
    int mySilver;
    int myBronze;
    MedalCountry(String name) {
        myName = name;
        myGold = 0;
        mySilver = 0;
        myBronze = 0;
    }
    
    public String getName() {
        return myName;
    }

    public int getGold(){
        return myGold;
    }
    public int getSilver() {
        return mySilver;
    }
    public int getBronze() {
        return myBronze;
    }

    @Override
    public String toString(){
        return String.format("%s %d %d %d",
                myName,myGold,mySilver,myBronze);
    }

    public void addGold() {
        myGold ++;
    }

    public void addSilver() {
        mySilver ++;
    }

    public void addBronze() {
        myBronze ++;
    }


    
}