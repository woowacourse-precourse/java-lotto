package lotto.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.PlayerLottoAmount;
import lotto.domain.Ranking;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public LottoController() {
    }

    private static PlayerLottoAmount playerLottoAmount;
    private static List<Integer> lotto = new ArrayList<>();
    private static List<Lotto> lottoList;
    private static WinningResult winningResult;


    public void start(){
        int ticketCount = inputPlayerAmount();
        OutputView.printTicketCount(ticketCount);

        lottoList = makeLottoList(ticketCount);
        winningResult = validateBonus();

    }

    public int inputPlayerAmount(){
        playerLottoAmount = new PlayerLottoAmount(InputView.inputPlayerAmount());
        return playerLottoAmount.calculateLottoCount();
    }

    public WinningResult validateBonus(){
        Lotto lotto = new Lotto(InputView.inputLottoWinningNum());
        List<Integer> winningNumber = lotto.getLottoNumbers();

        int ball =InputView.inputBonusNumber();
        lotto.validateBonusNumber(winningNumber,ball);
        winningResult = new WinningResult(new Lotto(winningNumber),ball);

        return winningResult;
    }


    private static List<Lotto> makeLottoList(int ticketCount){
        lottoList = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottoList.add(makeLotto());
        }
        return lottoList;
    }


    private static Lotto makeLotto() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lotto = new ArrayList<>();

        lotto = lottoNumbers.setRandomNumbers();
        System.out.println(lotto);
        return new Lotto(lotto);
    }


}


