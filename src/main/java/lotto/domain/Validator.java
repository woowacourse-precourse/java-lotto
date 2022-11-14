package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static lotto.utils.Messages.ERROR_MESSAGE;

public class Validator {
    static final int LOTTO_LOWER_BOUND = 1;
    static final int LOTTO_UPPER_BOUND = 45;
    static final int LOTTO_SIZE = 6;

    public boolean validateInputAmount(String input){
        try{
            validateNumeric(input);
            validateGraterThousand(input);
            validateMultipleOfThousands(input);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean validateBonusNumber(String input){
        try{
            validateNumeric(input);
            validateLottoNumberBound(input);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public void validateNumeric(String input){
        String numericPattern = "^[0-9]*$";
        if(!Pattern.matches(numericPattern, input)){
            throw new IllegalArgumentException(ERROR_MESSAGE + "숫자 형태가 아닙니다");
        }
    }
    public void validateGraterThousand(String input){
        int amount = Integer.parseInt(input);
        if(amount < 1000){
            throw new IllegalArgumentException(ERROR_MESSAGE + "1,000원 미만입니다.");
        }
    }

    public void validateMultipleOfThousands(String input){
        int amount = Integer.parseInt(input);
        if(amount % 1000 != 0){
            throw new IllegalArgumentException(ERROR_MESSAGE + "1,000의 단위가 아닙니다.");
        }
    }

    public void validateLottoNumberBound(String input){
        int bonusNumber = Integer.parseInt(input);
        if(bonusNumber < LOTTO_LOWER_BOUND || bonusNumber > LOTTO_UPPER_BOUND){
            throw new IllegalArgumentException(ERROR_MESSAGE + "1-45 사이의 범위가 아닙니다");
        }
    }

    public void validatePermissionPatter(String input){
        String permissionPattern = "\\d";
        String output = input.replaceAll(permissionPattern, "");
        if(output.length() != LOTTO_SIZE - 1){
            throw new IllegalArgumentException(ERROR_MESSAGE + "올바르지 않은 입력 형식입니다.");
        }
    }

}
