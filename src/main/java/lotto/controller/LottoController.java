package lotto.controller;

import lotto.domain.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.LinkedHashMap;
import java.util.List;

public class LottoController {
    static String price;
    static int quantity;
    static List<Lotto> allLotto;
    static Lotto winningNumber;
    static BonusNumber bonusNumber;

    public void lottoRun() {
        getPrice();
        getNumbers();
        getAllLotto();
        getResult();
    }

    public static void getPrice() {
        Input input = new Input();
        price = input.getPrice();
        System.out.println(input.printNext(price));
    }

    public static void getNumbers() {
        winningNumber = new Lotto(Input.getWinningNumber());
        System.out.println(winningNumber);
        bonusNumber = new BonusNumber(Input.getBonusNumber(), winningNumber);
        System.out.println(bonusNumber.get().get(0));
    }

    public static void getAllLotto() {
        quantity = BuyLotto.getQuantity(price);
        allLotto = LottoGenerator.getAllLotto(quantity);
        Output.printLottoNumbers(allLotto, quantity);
    }

    public static void getResult() {
        final List<Integer> matchResult
                = LottoMatch.putMatchNumbers(allLotto, winningNumber);
        final List<Boolean> hasBonus = LottoMatch.putBonus(allLotto, bonusNumber);
        final double earningRate = LottoEarnings.calculateEarningRate(matchResult, hasBonus, Integer.parseInt(price));
        final LinkedHashMap<Rank, Integer> winningResult = Result.getWinningResult(matchResult, hasBonus);

        Output.printStatics(winningResult);
        Output.printEarningRate(earningRate);
    }
}