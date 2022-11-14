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
        for (int i = 0; i < numbers.size(); i++) {
            String num = numbers.get(i);
            if(num.matches("[^0-9]+")){
                throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다");
            }
            int bonusNum = Integer.parseInt(num);
            if (bonusNum < 1 || bonusNum > 45) {
                throw new IllegalArgumentException("[ERROR] 1 ~ 45 숫자만 입력 가능합니다");
            }
        }

    }

    public void validateBonusNum(String num, List<Integer> winningNumber) {

        if(num.matches("[^0-9]")){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다");
        }

        int bonusNum = Integer.parseInt(num);
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException("[ERROR] 1 ~ 45 숫자만 입력 가능합니다");
        }

        if (winningNumber.contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호와 보너스 번호는 중복이 없어야 합니다");
        }


    }

}

