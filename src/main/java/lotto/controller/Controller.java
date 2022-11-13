package lotto.controller;

import lotto.converter.ConvertMoney;
import lotto.converter.ConvertPlayerNumbers;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.money.Money;
import lotto.domain.publish.NumberPublication;
import lotto.service.Service;
import lotto.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Controller {
    private final Service service;
    private final ConvertPlayerNumbers convertPlayerNumbers;
    private final ConvertMoney convertMoney;
    private final NumberPublication numberPublication;

    private final Money money;
    private final View view;

    public Controller() {
        service = new Service();
        convertPlayerNumbers = new ConvertPlayerNumbers();
        convertMoney = new ConvertMoney();
        numberPublication = new NumberPublication();
        money = new Money();
        view = new View();
    }

    public void play() {
        view.inputMoneyMessage();
        int inputMoney = convertMoney.toNumbers(view.input());

        int count = money.lottoCount(inputMoney);
        System.out.println(count);

        view.lotteryCountMessage(count);
        List<List<Integer>> lottoNumbers = numberPublication.publishNumbers(count);

        view.lotteryNumbers(lottoNumbers);

        view.inputLotteryNumbers();

        List<Integer> lotteryNumber = convertPlayerNumbers.toNumbers(view.input());
        Lotto lotto = new Lotto(lotteryNumber);

        view.inputBonusNumber();
        int bonusNumber = convertPlayerNumbers.toBonusNumber(view.input());


        BonusNumber bonus = new BonusNumber(bonusNumber, lotteryNumber);

        Map<String, Integer> rewards = service.matchLotteryNumber(lottoNumbers,lotto.getNumbers(),bonus.getBonus());

        view.winningDetails(rewards);
        String profitRate = service.profitRate(inputMoney);
        view.showProfitRate(profitRate);


    }
}
