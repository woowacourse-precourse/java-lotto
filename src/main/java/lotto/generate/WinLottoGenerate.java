package lotto.generate;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.WinLotto;
import lotto.output.Output;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinLottoGenerate {
    private final int LOTTO_SIZE = 6;
    private final String[] winNumber;
    private final String bonus;

    public WinLottoGenerate() {
        Output.askWinNumber();
        winNumber = Console.readLine().split(",");
        winNumberValidate();
        Output.askBonusNumber();
        bonus = Console.readLine();
        bonusValidate();
    }

    private void bonusValidate() {
        if (!bonus.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
    }

    private void winNumberValidate() {
        lottoSizeValidate(winNumber);
        isDigit(winNumber);
    }

    private void isDigit(String[] winNumber) {
        for (String number : winNumber) {
            if (!number.chars().allMatch(Character::isDigit)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void lottoSizeValidate(String[] winNumber) {
        if (winNumber.length != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }
    public WinLotto generate(){
        List<Integer> numbers = Arrays.stream(winNumber).map(Integer::parseInt).collect(Collectors.toList());
        Integer bonusInteger = Integer.parseInt(bonus);
        return new WinLotto(new Lotto(numbers), bonusInteger);
    }

}
