package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoBot;
import lotto.validator.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerService {
    private final LottoBot lottoBot;

    public PlayerService(LottoBot lottoBot) {
        this.lottoBot = lottoBot;
    }

    public int getLottoCountPurchased() {
        int money = getMoneyPurchased();
        lottoBot.saveInitialMoney(money);
        return money / Lotto.LOTTO_PRICE;
    }

    private int getMoneyPurchased() {
        String money = Console.readLine();
        money = eraseAllBlank(money);
        Validator.checkPurchaseInput(money);
        return Integer.parseInt(money);
    }

    public void selectWinningNumbers() {
        String numbers = Console.readLine();
        numbers = eraseAllBlank(numbers);
        Validator.checkWinningNumberInput(numbers);

        List<String> winningNumbers = new ArrayList<>(Arrays.asList(numbers.split(",")));
        lottoBot.saveWinningNumbers(winningNumbers);
    }

    public void selectBonusNumber() {
        String number = Console.readLine();
        number = eraseAllBlank(number);
        Validator.checkBonusNumberInput(number);

        if (!lottoBot.isValidBonusNumber(number)) {
            selectBonusNumber();
            return;
        }

        lottoBot.saveBonusNumber(number);
    }

    private String eraseAllBlank(String str) {
        return str.replace(" ", "");
    }
}

