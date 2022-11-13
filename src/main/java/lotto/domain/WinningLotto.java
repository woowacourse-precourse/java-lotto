package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    Lotto winningNumber = null;

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public void receiveWinningNumber() {
        String input = Console.readLine();
        String[] numbers = input.split(",");
        winningNumber = new Lotto(stringArrayToIntegerList(numbers));
    }

    private List<Integer> stringArrayToIntegerList(String[] words) {
        List<Integer> result = new ArrayList<>();

        for (String w:words) {
            judgeIsDigitOfString(w);
            checkRangeOfNumber(w);
            result.add(Integer.parseInt(w));
        }

        return result;
    }

    private void judgeIsDigitOfString(String sentence) {
        for (int i = 0; i < sentence.length(); i++) {
            char l = sentence.charAt(i);
            judgeIsDigitOfChar(l);
        }
    }

    private void judgeIsDigitOfChar(char word) {
        if (!Character.isDigit(word)) {
            throw new IllegalArgumentException("[ERROR] 입력은 자연수만 가능합니다.");
        }
    }

    private void checkRangeOfNumber(String word) {
        int number = Integer.parseInt(word);

        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 입력은 1~45사이의 자연수만 가능합니다.");
        }
    }

}
