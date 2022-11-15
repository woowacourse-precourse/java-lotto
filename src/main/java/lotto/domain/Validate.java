package lotto.domain;

import java.util.List;
import java.util.Set;

public class Validate {
    public void validateLottoNum(List<String> numbers) {
        if(numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개 입력해야 합니다.");
        }
        // Set으로 변환
        if(Set.copyOf(numbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 중복되지 않아야 합니다.");
        }
        for(int i = 0; i < numbers.size(); i++) {
            String num = numbers.get(i);
            if(num.matches("[^0-9]")) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다. ");
            }
            int bonusNum = Integer.parseInt(num);
            if(bonusNum < 1 || bonusNum > 45) {
                throw new IllegalArgumentException("[ERROR] 1 ~ 45 숫자만 입력 가능합니다.");
            }
        }
    }

    public void validateBonusNum(String num, List<Integer>winningNumber) {
        if(num.matches("[^0-9]]")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다. ");
        }
        int bonusNum = Integer.parseInt(num);
        if(bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException("[ERROR] [ERROR] 1 ~ 45 숫자만 입력 가능합니다.");
        }
        if(winningNumber.contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 중복되지 않아야 합니다.");
        }
    }
}
