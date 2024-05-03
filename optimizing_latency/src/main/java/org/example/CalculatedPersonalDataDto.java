package org.example;

public class CalculatedPersonalDataDto {

    private long amountOfFemales;
    private long amountOfMales;
    private long amountOfShortNames;
    private long amountOfLongNames;

    public void add(CalculatedPersonalDataDto calculatedPersonalDataDto){
        this.setAmountOfFemales(this.getAmountOfFemales()+calculatedPersonalDataDto.getAmountOfFemales());
        this.setAmountOfMales(this.getAmountOfMales()+calculatedPersonalDataDto.getAmountOfMales());

    }

    public long getAmountOfFemales() {
        return amountOfFemales;
    }

    public void setAmountOfFemales(long amountOfFemales) {
        this.amountOfFemales = amountOfFemales;
    }

    public long getAmountOfMales() {
        return amountOfMales;
    }

    public void setAmountOfMales(long amountOfMales) {
        this.amountOfMales = amountOfMales;
    }

    public long getAmountOfShortNames() {
        return amountOfShortNames;
    }

    public void setAmountOfShortNames(long amountOfShortNames) {
        this.amountOfShortNames = amountOfShortNames;
    }

    public long getAmountOfLongNames() {
        return amountOfLongNames;
    }

    public void setAmountOfLongNames(long amountOfLongNames) {
        this.amountOfLongNames = amountOfLongNames;
    }
}
