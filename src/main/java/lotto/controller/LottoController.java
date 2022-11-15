package lotto.controller;

import lotto.app.InputService;
import lotto.app.OutputService;
import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private InputService inputService = new InputService();
    private OutputService outputService = new OutputService();
    private Money money;
    private Lotto winningLotto;
    private int bonusNumber;
    private boolean hasBonusNumber;
    private LottoAmount lottoAmount;
    private LottoGenerator lottoGenerator = new LottoGenerator();
    private List<Lotto> lottos = new ArrayList<>();
    private LottoResult lottoResult = new LottoResult();
    private LottoReward lottoReward = new LottoReward();

    public void startLotto(){
        money = new Money(inputService.setMoney());
        lottoAmount = new LottoAmount(money);
        for(int i = 0; i < lottoAmount.getAmount(); i++) {
            Lotto lotto = new Lotto(lottoGenerator.createLotto());
            outputService.printNumbers(lotto.getNumbers());
            lottos.add(lotto);
        }

        winningLotto = new Lotto(inputService.setWinningNumbers());
        bonusNumber = inputService.setBonusNumber();
        for(int i = 0; i < lottoAmount.getAmount(); i++){
            hasBonusNumber = lottoResult.hasBonusNumber(lottos.get(i), bonusNumber);
            lottoResult.setRanksItem(winningLotto, lottos.get(i), hasBonusNumber);
        }

        outputService.printResult(lottoResult);
        lottoReward.setReward(lottoResult);
        lottoReward.setRewardRate(money);
        outputService.printRewardRate(money, lottoResult, lottoReward);
    }
}
