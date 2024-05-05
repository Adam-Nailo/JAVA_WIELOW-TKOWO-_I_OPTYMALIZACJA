package org.example;

public class Main {
    private static PathManager pathManager = new PathManager();

    public static void main(String[] args) {
        String line = "Barnaby,Valance,bvalance0@intel.com,Male";

        CalculatedPersonalDataDto dto = new CalculatedPersonalDataDto();
        dto.calculateLine(line);

        System.out.println(dto);
    }
}