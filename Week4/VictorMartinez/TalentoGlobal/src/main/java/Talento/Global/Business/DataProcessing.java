package Talento.Global.Business;


import Talento.Global.Exceptions.invalidInputValues;
import Talento.Global.Model.TestCase;
import Talento.Global.Utils.PARAMS;
import Talento.Global.Utils.Tools;
import Talento.Global.Utils.Tools.*;


import java.util.*;
import java.util.stream.Collectors;
import static Talento.Global.Utils.Tools.validateValues;

public class DataProcessing {

    public static void printTestCases(List<TestCase> testCases)throws invalidInputValues{

        for(int i =0; i<testCases.size();i++){
            System.out.println(i+1);
            printTestCase(testCases.get(i));
        }
    }

    public static void printTestCase(TestCase testCase) throws invalidInputValues {


        TreeMap<String, Integer> nameScores = testCase.getScores();

        if(!validateValues(nameScores).equals(PARAMS.VALID)){throw  new invalidInputValues("Wrong input parameters");}

        printMap(nameScores, testCase.getNumberScores());

    }

    public static void printMap(TreeMap<String, Integer> tmap, int numberScores){

        Set<String> keys = tmap.keySet();
        int insufficientValues = numberScores - keys.size();
        int cont = 1;
        int lastValue = Integer.MAX_VALUE;

        SortedSet<Map.Entry<String,Integer>> orderedMapByValues = Tools.entriesSortedByValues(tmap);

        if(insufficientValues>0){
            Iterator<Map.Entry<String,Integer>> items = orderedMapByValues.iterator();
            while(items.hasNext()){
                Map.Entry<String, Integer> tempValues = items.next();
                String correctKey = Tools.correctKey(tempValues.getKey());
                if(lastValue != tempValues.getValue()){cont++; lastValue=tempValues.getValue();}
                System.out.println(cont-1 + " " + correctKey + " " + tempValues.getValue());


            }
            for(int missingValues =0; missingValues<insufficientValues;missingValues++){
                System.out.println(cont + " " + "*** ***");
                cont++;
            }

       }
        else
        {
            Iterator<Map.Entry<String,Integer>> items = orderedMapByValues.iterator();
            while(items.hasNext()){
                Map.Entry<String, Integer> tempValues = items.next();
                if(cont<=numberScores) {
                    String correctKey = Tools.correctKey(tempValues.getKey());
                    if(lastValue != tempValues.getValue()){
                        cont++;
                        lastValue=tempValues.getValue();
                        System.out.println(cont - 1 + " " + correctKey + " " + tempValues.getValue());
                    }
                    else {
                        System.out.println(cont - 1 + " " + correctKey + " " + tempValues.getValue());
                        cont++;
                    }
                }
            }
        }
    }




}
