package lotto;

public class Validation {

    boolean validatePurchase(String input){
        boolean isMoney = false;
        boolean isRightUnit = false;
        boolean isNotZero = false;

        try{
            isMoney = validateIsMoney(input);
            isRightUnit = validateUnit(input);
            isNotZero = validateIsZero(input);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return (isMoney || isRightUnit || isNotZero);
    }

    boolean validateIsMoney(String input) throws IllegalArgumentException{
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(ErrorMessage.MONEY_NUMBER_ERROR.getMessage());
            }
        }
        return true;
    }

    boolean validateUnit(String input) throws IllegalArgumentException {
        try{
            int unit = Integer.parseInt(input) % 1000;
            if (unit !=0){
                throw new IllegalArgumentException((ErrorMessage.MONEY_UNIT_ERROR.getMessage()));
            }
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.MONEY_UNIT_ERROR.getMessage());
        }
        return true;
    }

    boolean validateIsZero(String input) throws IllegalArgumentException{
        try{
            int money = Integer.parseInt(input);
            if(money == 0){
                throw new IllegalArgumentException(ErrorMessage.MONEY_ZERO_ERROR.getMessage());
            }
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.MONEY_ZERO_ERROR.getMessage());
        }
        return true;
    }

    void validateIsNumber(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_ERROR.getMessage());
            }
        }
    }
}
