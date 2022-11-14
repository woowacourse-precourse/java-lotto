package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.money.Money;
import lotto.domain.publish.NumberPublication;
import lotto.service.Service;
import lotto.view.View;

import java.util.List;
import java.util.Map;

public class Controller {
    private final Service service;
    private final NumberPublication numberPublication;
    private final Money money;
    private final View view;

    public Controller() {
        service = new Service();
        numberPublication = new NumberPublication();
        money = new Money();
        view = new View();
    }

    public void play() {
        int inputMoney = inputMoney();
        int count = lottoCount(inputMoney);
        System.out.println(count); //
        List<List<Integer>> lottoNumbers = showLottoNumbers(count);

        Lotto lotto = inputPlayerNumber();

        BonusNumber bonus = playerBonusNumber(lotto);

        Map<String, Integer> rewards = service.matchLotteryNumber(lottoNumbers,lotto.getNumbers(),bonus.getBonus());

        view.winningDetails(rewards);
        showProfitRate(inputMoney);
    }

    private int inputMoney() {
        view.inputMoneyMessage();
        return view.inputMoney();
    }

    private int lottoCount(int inputMoney) {
        return money.lottoCount(inputMoney);
    }
    private List<List<Integer>> showLottoNumbers(int count) {
        view.lotteryCountMessage(count);
        List<List<Integer>> lottoNumbers = numberPublication.publishNumbers(count);
        view.lotteryNumbers(lottoNumbers);

        return lottoNumbers;
    }
    private Lotto inputPlayerNumber() {
        view.inputLotteryNumbers();
        List<Integer> lotteryNumber = view.inputLottoNumber();
        return new Lotto(lotteryNumber);
    }

    private BonusNumber playerBonusNumber(Lotto lotto) {
        view.inputBonusNumber();
        int bonusNumber = view.bonusNumber();
        return new BonusNumber(bonusNumber, lotto.getNumbers());
    }

    private void showProfitRate(int lottoCount) {
        String profitRate = service.profitRate(lottoCount);
        view.showProfitRate(profitRate);
    }
}
