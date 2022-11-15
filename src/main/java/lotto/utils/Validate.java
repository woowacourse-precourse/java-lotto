package lotto.utils;

import java.util.List;
import java.util.Set;

public class Validate {

    public void validateLottoNum(List<String> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또의 번호가 6개여야 합니다");
        }
        if (Set.copyOf(numbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 없어야 합니다");
        }
        checkNumberRange(numbers);
    }

    public void validateBonusNum(String num, List<Integer> winningNumber) {
        checkNumberRange(List.of(num));
        int number = Integer.parseInt(num);

        if (winningNumber.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호와 보너스 번호는 중복이 없어야 합니다");
        }
    }

    public void validateInputMoney(String input, int LOTTO_PRICE){
        if(!input.matches("[0-9]+")){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요");
        }

        int money = Integer.parseInt(input);
        if(money == 0  || money % LOTTO_PRICE != 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요");
        }
    }


    private void checkNumberRange(List<String> numbers) {
        for (String num : numbers) {
            if (num.matches("[^0-9]+")) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다");
            }
            int number = Integer.parseInt(num);
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 1 ~ 45 숫자만 입력 가능합니다");
            }
        }
    }


}

