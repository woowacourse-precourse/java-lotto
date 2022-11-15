package lotto.controller;

import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;
import lotto.domain.WinningNumbers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class LottoController {

    private final int LOTTO_ONE_GAME_PRICE = 1000;
    private static final int PERCENTAGE_CONVERTER = 100;
    private final int DEFAULT_EARNING_MONEY = 0;
    private Map<LottoRank, Integer> lottoResult = new HashMap<>();

    public void run() {
        int inputLottoMoney = inputLottoPurchaseMoney();
        int lottoTickets = generateLottoTickets(inputLottoMoney);
        List<Integer> winningNumber = inputWinningNumber();
        int bonusNumber = inputBonusNumber();

        WinningNumbers winningNumbers = new WinningNumbers(winningNumber, bonusNumber);
        printLottoPurchaseCompleteMessage(lottoTickets);
        calculrateLotto(lottoTickets,winningNumbers);
        int lottoEarningMoney = calculrateLottoEarningMoney();
        double lottoEarningRate = calculrateLottoEarningRate(lottoEarningMoney, lottoPurchaseMoney);
        printLottoEarningRate(lottoEarningRate);
    }

    private int generateLottoTickets(int inputMoney) {
        return inputMoney / LOTTO_ONE_GAME_PRICE;
    }

    private void calculrateLotto(int lottoTickets, WinningNumbers winningNumbers) {
        initializeLottoResultMap();
        for (int i = 0; i < lottoTickets; i++) {
            List<Integer> lotto = LottoTicket.createLottoOneGameNumber();
            LottoRank lottoRank = winningNumbers.calculrateRank(lotto);
            calculrateResult(lottoRank, winningNumbers, lotto);
        }
    }

    private void initializeLottoResultMap() {
        for (LottoRank lottoRank : LottoRank.values()) {
            lottoResult.put(lottoRank, 0);
        }
    }

    private void calculrateResult(LottoRank lottoRank, WinningNumbers winningNumbers, List<Integer> lotto) {
        lottoRank = winningNumbers.calculrateRank(lotto);
        lottoResult.put(lottoRank, lottoResult.getOrDefault(lottoRank, 0) + 1);
        printLottoNumber(lotto);
    }

    private int calculrateLottoEarningMoney() {
        int earningMoney = DEFAULT_EARNING_MONEY;
        for (LottoRank lottoRank : lottoResult.keySet()) {
            if (lottoResult.get(lottoRank) >= 1) {
                earningMoney += lottoResult.get(lottoRank) * lottoRank.getRewardMoney();
            }
        }
        printLottoResult(lottoResult);
        return earningMoney;
    }

    public static double calculrateLottoEarningRate(int earningMoney, int purchaseMoney) {
        return (double) earningMoney / purchaseMoney * PERCENTAGE_CONVERTER;
    }

}
