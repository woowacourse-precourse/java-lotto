package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    Lotto winningNumber = null;
    int bonusNumber;

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public void receiveWinningNumber() {
        String input = Console.readLine();
        String[] numbers = input.split(",");
        winningNumber = new Lotto(stringArrayToIntegerList(numbers));
    }

    public void receiveBonusNumber() {
        String input = Console.readLine();
        judgeIsDigitOfString(input);
        checkRangeOfNumber(input);

        bonusNumber = Integer.parseInt(input);
        checkBonusInWinning();
    }

    public int compareLotto(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningNumber.getNumbers();
        int correctCount = 0;

        for (int lottoNumber:lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                correctCount++;
            }
        }

        return correctCount;
    }

    public boolean isBonusInLotto(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        if (lottoNumbers.contains(bonusNumber)) {
            return true;
        };

        return false;
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

    private void checkBonusInWinning() {
        if(winningNumber.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 다른 번호를 입력해야 합니다.");
        }
    }

}
