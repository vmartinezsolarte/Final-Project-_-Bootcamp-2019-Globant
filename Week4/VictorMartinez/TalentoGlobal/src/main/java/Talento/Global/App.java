package Talento.Global;

import Talento.Global.Business.DataProcessing;
import Talento.Global.Exceptions.invalidInputValues;
import Talento.Global.Model.TestCase;

import java.util.List;

import static Talento.Global.Data.ReadFile_csv.getTestCases;

public class App {

    public static void main(String [] args) throws invalidInputValues {

        List<TestCase> testCases = getTestCases("src/main/java/Talento/Global/Repository/TestCase.csv");
        DataProcessing.printTestCases(testCases);
        System.out.print("ended");
    }
}
