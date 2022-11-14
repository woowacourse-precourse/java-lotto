package lotto.validator;

import lotto.constant.ErrorMessage;

import java.util.List;

public class ValidationInView {
    private static final String NUMERIC_REGULAR_EXPRESSION = "^[-]?[0-9]+$";

    public void checkNumericValue(String value){
        if(!value.matches(NUMERIC_REGULAR_EXPRESSION)){
            throw new IllegalArgumentException(ErrorMessage.TYPE_IS_NOT_RIGHT);
        }
    }

    public void checkNumericValueList(List<String> values){
        for(int i = 0; i < values.size(); i++){
            checkNumericValue(values.get(i));
        }
    }
}
