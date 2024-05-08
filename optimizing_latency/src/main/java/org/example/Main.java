package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static PathManager pathManager = new PathManager();
    private static PersonalDataService personalDataService = new PersonalDataService();

    public static void main(String[] args) {
        List<String> fileNames = Arrays.asList("data1.txt", "data2.txt", "data3.txt", "data4.txt", "data5.txt",
                "data6.txt", "data7.txt", "data8.txt", "data9.txt", "data10.txt", "data111.txt", "data12.txt");

        long start = System.currentTimeMillis();
        CalculatedPersonalDataDto dto = singleThread(fileNames);
        long end = System.currentTimeMillis();
        long latency = end - start;
        System.out.println("latency: " + latency);
        System.out.println(dto);
    }

    public static CalculatedPersonalDataDto singleThread(List<String> fileNames) {
        CalculatedPersonalDataDto dto = new CalculatedPersonalDataDto();
        for (String fileName : fileNames) {
            dto.add(personalDataService.getCalculatedPersonalData(pathManager.createAbsoluteResourceFilePath(fileName)));
        }
        return dto;
    }
}