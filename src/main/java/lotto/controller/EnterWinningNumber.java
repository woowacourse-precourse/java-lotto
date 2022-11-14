package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoInfo;
import lotto.domain.WinningLotto;
import lotto.view.UserInputHelper;

import java.util.ArrayList;
import java.util.List;

public class EnterWinningNumber {
    private UserInputHelper userInputHelper;
    private List<Integer> winningLotto;
    private int bonusNumber;

    public EnterWinningNumber() {
        userInputHelper = new UserInputHelper();
    }

    public WinningLotto enterWinngLottoNumber() {
        winningLotto = getWinningNumberInput();
        bonusNumber = getBonusNumberInput();

        return new WinningLotto(winningLotto, bonusNumber);
    }

    private List<Integer> getWinningNumberInput() {
        userInputHelper.winningNumberHelper();
        return convert(Console.readLine());
    }

    private int getBonusNumberInput() {
        userInputHelper.bonusNumberHelper();
        int bonusNumber = inputIsNumber(Console.readLine());
        isEachNumberBetween1AND45(bonusNumber);
        return bonusNumber;
    }

    private List<Integer> convert(String winningNumber) {
        List<Integer> winninLotto = new ArrayList<>();
        String[] winningSplitNumber = winningNumber.split(",");

        for (String numberString : winningSplitNumber) {
            int number = inputIsNumber(numberString);
            isEachNumberBetween1AND45(number);
            winninLotto.add(number);
        }

        lottoSizeValidation(winninLotto);
        return winninLotto;
    }

    private int inputIsNumber(String userInput) {
        if (!userInput.matches("[0-9]{1,2}")) {
            throw new IllegalArgumentException("[ERROR] 값은 ,와 숫자만 입력 가능합니다.");
        }

        return Integer.valueOf(userInput);
    }

    private void isEachNumberBetween1AND45(int number) {
        if (number > LottoInfo.MAX_NUMBER.getValue() || number < LottoInfo.MIN_NUMBER.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void lottoSizeValidation(List<Integer> lotto) {
        if (lotto.size() != LottoInfo.LOTTO_LENGTH.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리만 입력 가능합니다.");
        }
    }
}
