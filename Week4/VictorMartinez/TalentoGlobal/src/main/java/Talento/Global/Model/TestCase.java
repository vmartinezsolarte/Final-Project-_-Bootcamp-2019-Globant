package Talento.Global.Model;

import java.util.TreeMap;

import Talento.Global.Utils.PARAMS;
import Talento.Global.Utils.PARAMS.*;
//import org.apache.commons.collections4.MultiValuedMap;

public class TestCase {

    private TreeMap<String, Integer> scoresTable;
    private int numberPlayers;
    private int numberScores;

    public TestCase(){}

    public TestCase(int numberPlayers, int numberScores){
        this.numberPlayers = numberPlayers;
        this.numberScores  = numberScores;
        this.scoresTable   = new TreeMap<>();
    }

    public String addScore(String name, int scores){
        while(scoresTable.containsKey(name)){name = name+String.valueOf(Math.round(Math.random()*1000));}
        this.scoresTable.put(name, scores);
        return PARAMS.ADDED;
    }

    public TreeMap<String, Integer> getScores() {
        return scoresTable;
    }

    public void setScores(TreeMap<String, Integer> scores) {
        this.scoresTable = scores;
    }

    public int getNumberPlayers() {
        return numberPlayers;
    }

    public void setNumberPlayers(int numberPlayers) {
        this.numberPlayers = numberPlayers;
    }

    public int getNumberScores() {
        return numberScores;
    }

    public void setNumberScores(int numberScores) {
        this.numberScores = numberScores;
    }
}
