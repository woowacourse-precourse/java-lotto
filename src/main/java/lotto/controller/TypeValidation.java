package lotto.controller;

public class TypeValidation {
    private static final String NUMERIC_REGULAR_EXPRESSION = "^[0-9]+$";

    public void checkNumericValue(String value){
        if(!value.matches(NUMERIC_REGULAR_EXPRESSION)){
            throw new IllegalArgumentException();
        }
    }
}
