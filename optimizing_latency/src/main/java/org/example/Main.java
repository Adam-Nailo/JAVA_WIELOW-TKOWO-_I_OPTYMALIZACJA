package org.example;

public class Main {
    private static PathManager pathManager = new PathManager();
    private static PersonalDataService personalDataService = new PersonalDataService();

    public static void main(String[] args) {

       CalculatedPersonalDataDto calculatedPersonalData =  personalDataService.getCalculatedPersonalData(pathManager.createAbsoluteResourceFilePath("data1.txt"));

        System.out.println(calculatedPersonalData);
    }
}