package lotto.controller;

import lotto.Prize;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningNumber;
import lotto.service.CompareNumber;
import lotto.service.GenerateLotto;
import lotto.service.ResultPrize;

import java.util.HashMap;
import java.util.List;

public class LottoController {

    private final UserController userController = new UserController();
    private final GenerateLotto generateLotto = new GenerateLotto();

    public void start() {
        HashMap<Integer, Integer> sameMap = new HashMap<>();
        HashMap<Integer, Boolean> bonusMap = new HashMap<>();

        int money = userController.requestMoney();
        int amount = amountLotto(money);
        List<Lotto> lottoList = generateLotto.generateLottoList(amount);
        List<Integer> winningNumber = userController.requestWinningNumber();
        int bonusNumber = userController.requestBonusNumber();
        ResultPrize resultPrize = new ResultPrize(lottoList, winningNumber, bonusNumber);
        HashMap<String, Integer> prize = resultPrize.CalResult();
        userController.printResult(prize, money);
    }

    public int amountLotto(int money) {
        return money/1000;
    }
}
