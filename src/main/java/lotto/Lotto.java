package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.ui.Constants;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력하셔야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for(Integer lottoNum : numbers) {
            validateNum(lottoNum);
        }
    }

    public static void validateNum(int num) {
        if(num < 1 || num > 45)
            throw new IllegalArgumentException("[ERROR] 1이상 45 이하의 숫자를 입력해주셔야 합니다");
    }

    private void validateUnique(int money) {
        if (money % Constants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력하셔야 합니다.");
        }
    }


}
