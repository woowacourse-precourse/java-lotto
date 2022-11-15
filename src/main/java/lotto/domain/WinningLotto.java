package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;

    Lotto winningNumber = null;
    int bonusNumber;

    public WinningLotto() {
    }

    public WinningLotto(Lotto winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public void receiveWinningNumber() {
        String input = Console.readLine();
        String[] numbers = splitByComma(input);

        winningNumber = new Lotto(stringArrayToIntegerList(numbers));
    }

    public String[] splitByComma(String sentence) {
        String[] numbers = sentence.split(",");

        return numbers;
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

    public List<Integer> stringArrayToIntegerList(String[] words) {
        List<Integer> result = new ArrayList<>();

        for (String w:words) {
            judgeIsDigitOfString(w);
            checkRangeOfNumber(w);
            result.add(Integer.parseInt(w));
        }

        return result;
    }


    public void judgeIsDigitOfString(String sentence) {
        for (int i = 0; i < sentence.length(); i++) {
            char l = sentence.charAt(i);
            judgeIsDigitOfChar(l);
        }
    }

    public void judgeIsDigitOfChar(char word) {
        if (!Character.isDigit(word)) {
            throw new IllegalArgumentException("[ERROR] 입력은 자연수만 가능합니다.");
        }
    }

    public void checkRangeOfNumber(String word) {
        int number = Integer.parseInt(word);

        if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 입력은 1~45사이의 자연수만 가능합니다.");
        }
    }

    public void checkBonusInWinning() {
        if(winningNumber.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 다른 번호를 입력해야 합니다.");
        }
    }

}
