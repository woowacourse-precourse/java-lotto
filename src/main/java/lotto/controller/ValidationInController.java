package lotto.controller;

import java.util.List;

public class ValidationInController {
    private static final String NUMERIC_REGULAR_EXPRESSION = "^[0-9]+$";

    public void checkNumericValue(String value){
        if(!value.matches(NUMERIC_REGULAR_EXPRESSION)){
            throw new IllegalArgumentException();
        }
    }

    public void checkNumericValueList(List<String> values){
        for(int i = 0; i < values.size(); i++){
            checkNumericValue(values.get(i));
        }
    }
}
