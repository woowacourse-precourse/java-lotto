package lotto;

public class Convert {
    public static Integer costConvert(String cost){
        InputValidation.numberFormatExceptionValidation(cost);
        return Integer.parseInt(cost);
    }
}
