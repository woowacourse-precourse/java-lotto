package lotto.controller;

import lotto.domain.LottoQuantity;
import lotto.domain.LottoRanking;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    public List<Integer> userLottoNumbers;
    public int userLottoQuantity;
    public int userLottoMoney;
    public Lottos lottos = new Lottos(userLottoQuantity);
    public LottoQuantity lottoQuantity = new LottoQuantity();
    public Map<LottoRanking, Integer> lottoRanking;
    private static int MONEY_UNIT=1000;
    private static int PERCENT_CALCULATION=100;
    public void startLotto() {
        getUserMoney();
        printLottoQuantity();
        printLottos();
        getUserLottoNumbers();
        getUserBonusNumber();
        compareLottos();
        getLottoResult();
        getLottoResultRate();
    }

    public void getUserMoney() {
        userLottoMoney = InputView.requestPurchaseMoney();
    }


    public void printLottoQuantity() {
        lottoQuantity.setLottoQuantityNumber(userLottoMoney / MONEY_UNIT);
        userLottoQuantity = lottoQuantity.getLottoQuantityNumber();
        OutputView.printPurchaseLottoSet(userLottoQuantity);
    }

    public void printLottos() {
        lottos.initLottos(userLottoQuantity);
        OutputView.printPurchaseLottoNumbers(lottos.getLottos());
    }

    public void getUserLottoNumbers() {
        userLottoNumbers = InputView.requestLottoNumbers();
    }

    public void getUserBonusNumber() {
        userLottoNumbers.add(InputView.requestBonusNumber());
    }

    public void compareLottos() {
        lottoRanking = lottos.calculateLottos(userLottoNumbers);
    }

    public void getLottoResult() {
        OutputView.printLottoResult(lottoRanking);
    }

    public void getLottoResultRate() {
        int totalLottoMoney = 0;
        for (LottoRanking ranking : lottoRanking.keySet()) {
            totalLottoMoney += ranking.getLottoWinningMoney() * lottoRanking.get(ranking);
        }
        float percent = (float) totalLottoMoney / (userLottoMoney) * PERCENT_CALCULATION;
        OutputView.printLottoProfitRate(percent);
    }
}
