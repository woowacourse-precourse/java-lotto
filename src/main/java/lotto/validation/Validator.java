package lotto.validation;

public class Validator {

    public static void validateStringIsNumeric(String input){
        if(!input.matches("[+-]?\\d*(\\.\\d+)?")){
            throw new IllegalArgumentException("[ERROR] input이 숫자가 아닙니다.");
        }
    }

    public static void validatePriceRange(Long price){
        if(price < 0) {
            throw new IllegalArgumentException("[ERROR] 음수값은 입력하실 수 없습니다.");
        }
    }

    public static void validateUnit(Long price){
        if(price % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1,000원 단위의 값을 입력해야합니다.");
        }
    }

}
