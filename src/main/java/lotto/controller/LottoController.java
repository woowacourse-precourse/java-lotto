package lotto.controller;

import lotto.domain.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.LinkedHashMap;
import java.util.List;

public class LottoController {
    static final int LOTTO_PRICE_DEFAULT_UNIT = 1000;
    static int price;
    static int lottoQuantity;
    static List<Lotto> lottoContainer;
    static Lotto winningLotto;
    static Bonus bonusNumber;

    //로또 프로그램 실행 메서드
    public static void execute() {
        LottoController.getPrice();
        getLottoQuantity(price);
        Output.printQuantity(lottoQuantity);
        getSavedLotto(lottoQuantity);
        getWinningLotto();
        getBonusNumber();
        getResult();
    }

    public static void getPrice() {
        price = Input.inputPrice();
    }

    public static void getLottoQuantity(int price) {
        lottoQuantity = price / LOTTO_PRICE_DEFAULT_UNIT;
    }

    public static void getSavedLotto(int lottoQuantity) {
        lottoContainer = LottoCreator.saveLotto(lottoQuantity);
        Output.printAllLottoNumber(lottoContainer);
    }

    public static void getWinningLotto() {
        winningLotto = new Lotto(Input.inputWinningNumber());
    }

    public static void getBonusNumber() {
        bonusNumber = new Bonus(Input.inputBonusNumber(), winningLotto);
    }

    public static void getResult() {

        List<Integer> countMatchNumber = LottoProcess.putMatchNumber(winningLotto, lottoContainer);
        List<Boolean> bonusInLotto = LottoProcess.putAvailableBonus(bonusNumber, lottoContainer);
        double rateOfProfit = LottoProcess.calculateRateOfProfit(countMatchNumber,bonusInLotto, price);
        LinkedHashMap<MapMatchPrize, Integer> winningResult = LottoResult.getWinningResult(countMatchNumber, bonusInLotto);

        Output.printWinningStatics(winningResult);
        Output.printRateOfProfit(rateOfProfit);
    }
}
