package lotto.controller;

import lotto.domain.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.LinkedHashMap;
import java.util.List;

public class LottoController {
    static int price;
    static int quantity;
    static List<Lotto> allLotto;
    static Lotto winningNumber;
    static BonusNumber bonusNumber;

    public static void lottoRun() {
        getPrice();
        getAllLotto();
        getNumbers();
        getResult();
    }

    public static void getPrice() {
        price = Input.getPrice();
        System.out.println(price);
        quantity = BuyLotto.getQuantity(price);
    }

    public static void getAllLotto() {
        allLotto = LottoGenerator.getAllLotto(quantity);
        Output.printLottoNumbers(allLotto, quantity);
    }

    public static void getNumbers() {
        winningNumber = new Lotto(Input.getWinningNumber());
        System.out.println(winningNumber);
        bonusNumber = new BonusNumber(Input.getBonusNumber(), winningNumber);
        System.out.println(bonusNumber);
    }

    public static void getResult() {
        final List<Integer> matchResult
                = LottoMatch.putMatchNumbers(allLotto, winningNumber);
        final List<Boolean> hasBonus = LottoMatch.putBonus(allLotto, bonusNumber);
        final double earningRate = LottoEarnings.calculateEarningRate(matchResult, hasBonus, price);
        final LinkedHashMap<Rank, Integer> winningResult = Result.getWinningResult(matchResult, hasBonus);

        Output.printStatics(winningResult);
        Output.printEarningRate(earningRate);
    }
}
