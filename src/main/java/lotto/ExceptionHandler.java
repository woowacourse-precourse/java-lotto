package lotto;

import java.util.List;

public class ExceptionHandler {
    public void validNumberRange(int num){
        if(num < 1 || num > 45){
            throw new IllegalArgumentException("1에서 45 사이의 수만 입력 가능합니다.");
        }
    }

    public void validNumberDupplication(int newNumber, List<Integer> numbers){
        if(numbers.contains(newNumber)){
            throw new IllegalArgumentException("중복된 값은 입력할 수 없습니다.");
        }
    }

    public void validWinningForm(String readline){
        String[] numbers = readline.split(",");
        if(numbers.length != 6){
            throw new IllegalArgumentException("쉼표로 구분된 6개의 수만 입력 가능합니다.");
        }
    }

    public void validPurchaseForm(int amount){
        if(amount%1000 != 0){
            throw new IllegalArgumentException("1000원 단위로만 구입이 가능합니다.");
        }
    }
}
