package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PersonalDataService {

    public CalculatedPersonalDataDto getCalculatedPersonalData(String filepath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            return readAndCalculateLines(reader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private CalculatedPersonalDataDto readAndCalculateLines(BufferedReader reader) throws IOException {
        CalculatedPersonalDataDto dto = new CalculatedPersonalDataDto();
        String line = reader.readLine();
        while (line != null) {
            dto.calculateLine(line);
            line = reader.readLine();
        }
        return dto;
    }
}
