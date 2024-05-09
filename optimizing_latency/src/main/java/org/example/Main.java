package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    private static PathManager pathManager = new PathManager();
    private static PersonalDataService personalDataService = new PersonalDataService();

    public static void main(String[] args) {
        List<String> fileNames = Arrays.asList("data1.txt", "data2.txt", "data3.txt", "data4.txt", "data5.txt",
                "data6.txt", "data7.txt", "data8.txt", "data9.txt", "data10.txt", "data11.txt", "data12.txt");

        long start = System.currentTimeMillis();
        CalculatedPersonalDataDto dto = multiThread(fileNames);
        long end = System.currentTimeMillis();
        long latency = end - start;
        System.out.println("latency: " + latency);
        System.out.println(dto);
    }

    // 1400-1500
    public static CalculatedPersonalDataDto multiThread(List<String> fileNames) {
        CalculatedPersonalDataDto dto = new CalculatedPersonalDataDto();
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<CalculatedPersonalDataDto> result1 = service.submit(() -> singleThread(fileNames.subList(0, 6)));
        Future<CalculatedPersonalDataDto> result2 = service.submit(() -> singleThread(fileNames.subList(7, 12)));
        try {
            dto.add(result1.get());
            dto.add(result2.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        return dto;
    }

    // 2500-2600
    public static CalculatedPersonalDataDto singleThread(List<String> fileNames) {
        CalculatedPersonalDataDto dto = new CalculatedPersonalDataDto();
        for (String fileName : fileNames) {
            dto.add(personalDataService.getCalculatedPersonalData(pathManager.createAbsoluteResourceFilePath(fileName)));
        }
        return dto;
    }
}