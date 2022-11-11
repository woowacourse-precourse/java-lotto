package lotto.view;

import static lotto.util.InputUtil.toIntStringNumberParser;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int inputBuyingPriceView() {
        String buyingPrice = Console.readLine();
        return toIntStringNumberParser(buyingPrice);
    }

    public String inputLottoNumbersView() {
        String lottoNumbers = Console.readLine();
        return lottoNumbers;
    }

    public String inputBonusNumberView() {
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
