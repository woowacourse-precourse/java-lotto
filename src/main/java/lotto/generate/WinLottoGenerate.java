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

    }

    private void winNumberValidate(String[] winNumber) {
        lottoSizeValidate(winNumber);
    }

    private void lottoSizeValidate(String[] winNumber) {
        if (winNumber.length != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
