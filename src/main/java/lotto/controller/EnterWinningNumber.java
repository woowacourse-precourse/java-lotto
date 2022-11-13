package lotto.controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class EnterWinningNumber {
    public static final int LOTTO_SIZE = 6;
    
    private String getWinningNumberInput() {
        return Console.readLine();
    }

    private void isEachNumberBetween1AND45(int number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void lottoSizeValidation(List<Integer> lotto) {
        if (lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리만 입력 가능합니다.");
        }
    }
}
