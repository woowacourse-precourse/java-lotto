package lotto.controller;

import camp.nextstep.edu.missionutils.Console;

public class EnterWinningNumber {
    private String getWinningNumberInput() {
        return Console.readLine();
    }

    private void isEachNumberBetween1AND45(int number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
