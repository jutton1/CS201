import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashListAutocomplete implements Autocompletor {

    private static final int MAX_PREFIX = 10;
    private Map<String, List<Term>> myMap = new HashMap<String, List<Term>>();
    private int mySize;


    public HashListAutocomplete(String[] terms, double[] weights) {
        if (terms == null || weights == null) {
			throw new NullPointerException("One or more arguments null");
		}
		if (terms.length != weights.length) {
			throw new IllegalArgumentException("The terms and weights are not equal in length");
		}
		initialize(terms,weights);
    }

    @Override
    public List<Term> topMatches(String prefix, int k) {
        if (prefix.length() > MAX_PREFIX) {
            prefix = prefix.substring(0, MAX_PREFIX);
        }
        List<Term> returnList = new ArrayList<Term>();
        if (myMap.containsKey(prefix)) {
            returnList = myMap.get(prefix).subList(0, Math.min(k, myMap.get(prefix).size()));
        }
        return returnList;
    }

    @Override
    public void initialize(String[] terms, double[] weights) {
        myMap.clear();
        mySize = 0;
        ArrayList<Term> subTerm = new ArrayList<Term>();
        for (int y = 0; y < terms.length; y++) {
            String term = terms[y];
            Term myTerm = new Term(term, weights[y]);
            mySize += myTerm.getWord().length() * BYTES_PER_CHAR;
            mySize += BYTES_PER_DOUBLE;
            subTerm.add(myTerm);
            if (weights[y] < 0) {
				throw new IllegalArgumentException("Illegal weight ");
			}
            

            for (int i = 0; i < Math.min(MAX_PREFIX, term.length()); i++) {
                
                List<Term> termList = new ArrayList<Term>();
                String termPrefix = term.substring(0,i + 1);
                
                if (!myMap.containsKey(termPrefix)) {
                    mySize += termPrefix.length() * BYTES_PER_CHAR;
                    termList.add(myTerm);
                    myMap.put(termPrefix, termList);
                    
                }
                else {
                    myMap.get(termPrefix).add(myTerm);
            
                }
                
                
            }

        }

        myMap.put("", subTerm);

        for(String key : myMap.keySet()) {
            List<Term> tempList = myMap.get(key);
            Collections.sort(tempList, Comparator.comparing(Term::getWeight).reversed());
            myMap.put(key,tempList);
        }
        
    }

    @Override
    public int sizeInBytes() {

        return mySize;
        
    }
    
}

