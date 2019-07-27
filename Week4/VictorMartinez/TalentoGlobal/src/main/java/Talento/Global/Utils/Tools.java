package Talento.Global.Utils;

import Talento.Global.Exceptions.invalidKeyException;
import Talento.Global.Exceptions.invalidValueException;
import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import jdk.internal.jline.console.KeyMap;

import java.util.*;
import java.util.stream.Collectors;

public class Tools {

    public static void printVal(){
        System.out.println("");
    }

    public static String validateValues(TreeMap<String, Integer> tmap){
        String response;
        Set keys = tmap.keySet();
        Collection<Integer> values = tmap.values();

        try {
            validateKeys(keys);
        }catch (invalidKeyException ex){
            response = ex.getMessage();
            return response;
        };

        try{
            validateValues(values);
        }catch (invalidValueException ex){
            response = ex.getMessage();
            return response;
        }

        return PARAMS.VALID;
    }

    public static boolean validateKeys(Set keys) throws invalidKeyException {
        Iterator<String> iterator = keys.iterator();
        boolean invalid = false;
        while(iterator.hasNext()){
            String testString = iterator.next();
            if(testString.matches("[^A-Za-z0-9]")){
                invalid = true;
                throw new invalidKeyException("Keys cannot carry numbers");
            }
        }
        return invalid;
    }

    public static boolean validateValues(Collection<Integer> values) throws invalidValueException {

        boolean invalid = false;
        Iterator<Integer> valuesIterator = values.iterator();
        while(valuesIterator.hasNext()){
            long testValue = valuesIterator.next();


            if(testValue<0 || testValue >PARAMS.LIMIT){
                invalid = true;
                throw new invalidValueException("Number Surpasses The Standar Range");
            }
        }
        return invalid;
    }

    public static <K,V extends Comparable<? super V>>
    SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
                new Comparator<Map.Entry<K,V>>() {
                    @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                        int res = e2.getValue().compareTo(e1.getValue());
                        return res != 0 ? res : 1;
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

    public static String correctKey(String key){
        return key.substring(0,3);
    }

}
