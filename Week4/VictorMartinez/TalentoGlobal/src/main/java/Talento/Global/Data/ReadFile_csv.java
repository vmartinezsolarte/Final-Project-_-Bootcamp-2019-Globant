package Talento.Global.Data;

import Talento.Global.Model.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ReadFile_csv {


    private static List<TestCase> TestCasesList;

    public ReadFile_csv(){ TestCasesList = new ArrayList<TestCase>(); }

    public static List<TestCase> getTestCasesList() { return TestCasesList; }

    public static void setTestCasesList(List<TestCase> testCasesList) { TestCasesList = testCasesList; }


    public static List<TestCase> getTestCases(String Uri) {


        List<TestCase> testCasesList = new ArrayList<>();

        Path pathToTestCases = Paths.get(Uri);

        // create an instance of BufferedReader
        try (BufferedReader br = Files.newBufferedReader(pathToTestCases,
                StandardCharsets.US_ASCII)) {

            // read the first line from the text file - get number of test Cases
            String numberTestCases = br.readLine();

            // loop through the cases until all test cases are built
            numberTestCases = br.readLine();

            while (numberTestCases != null) {


                // use string.split to load a string array with the values from
                // each line of
                // the file, using a space as the delimiter
                String[] attributes = numberTestCases.split(" ");

                // detect which is a case and which the parameters of a test case
                if((attributes[0].substring(0,1)).matches("[^\\d]*[\\d]")){

                    int numberOfPlayers = Integer.parseInt(attributes[0]);
                    int numberOfScores = Integer.parseInt(attributes[1]);


                //Create new TestCase with numberPlayers, Number scores
                    TestCase newTestCase = new TestCase(numberOfPlayers, numberOfScores);

                //Loop Through the Key-Values params
                    String [] nameScoreValues = null;

                for(int numberKeyValues = 0; numberKeyValues<numberOfPlayers;numberKeyValues++){

                //Read the P-numberPlayers keyValues Items and add them to the List
                        numberTestCases = br.readLine();
                        nameScoreValues = numberTestCases.split(" ");
                        newTestCase.addScore(nameScoreValues[0],Integer.parseInt(nameScoreValues[1]));



                }
                    //System.out.println(newTestCase.getScores().size());
                // Add the new TestCase to the Test Case List
                    testCasesList.add(newTestCase);

                }

                // Read next line until null condition is completed
                numberTestCases = br.readLine();
            }


        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        TestCasesList = testCasesList;
        return testCasesList;
    }

}
