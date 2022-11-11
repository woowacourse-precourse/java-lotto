package lotto.generate;

import camp.nextstep.edu.missionutils.Console;
import lotto.output.Output;

import java.util.Arrays;

public class WinLottoGenerate {
    private final int LOTTO_SIZE = 6;

    public WinLottoGenerate() {
        Output.askWinNumber();
        String[] winNumber = Console.readLine().split(",");
        winNumberValidate(winNumber);
        Output.askBonusNumber();
        String bonus = Console.readLine();
        bonusValidate(bonus);
    }

    private void bonusValidate(String bonus) {
        if(!bonus.chars().allMatch(Character::isDigit)){
            throw new IllegalArgumentException();
        }
    }

    private void winNumberValidate(String[] winNumber) {
        lottoSizeValidate(winNumber);
        isDigit(winNumber);
    }

    private void isDigit(String[] winNumber) {
        for(String number : winNumber){
            if(!number.chars().allMatch(Character::isDigit)){
                throw new IllegalArgumentException();
            }
        }
    }

    private void lottoSizeValidate(String[] winNumber) {
        if (winNumber.length != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
