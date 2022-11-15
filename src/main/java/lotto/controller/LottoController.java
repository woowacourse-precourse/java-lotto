package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {
    private static final int PERCENTAGE_CONVERTER = 100;
    private static final int LOTTO_ONE_GAME_PRICE = 1000;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private static int DEFAULT_EARNING_MONEY = 0;

    private Map<LottoRank, Integer> lottoResult = new HashMap<>();

    public static double calculateLottoEarningRate(int earningMoney, int purchaseMoney) {
        return (double) earningMoney / purchaseMoney * PERCENTAGE_CONVERTER;
    }

    private int generateTickets(int inputMoney) {
        return inputMoney / LOTTO_ONE_GAME_PRICE;
    }

    public void run() {
        int inputLottoMoney = InputView.inputLottoPurchaseMoney();
        int lottoTickets = generateTickets(inputLottoMoney);
        List<Integer> winningNumber = InputView.inputWinningNumber();
        int bonusNumber = InputView.inputBonusNumber();

        WinningNumbers winningNumbers = new WinningNumbers(winningNumber, bonusNumber);
        OutputView.printLottoPurchaseCompleteMessage(lottoTickets);
        calculateLotto(lottoTickets, winningNumbers);
        int lottoEarningMoney = calculateLottoEarningMoney();
        double lottoEarningRate = calculateLottoEarningRate(lottoEarningMoney, inputLottoMoney);
        OutputView.printLottoEarningRate(lottoEarningRate);
    }


    private void initializeLottoResultMap() {
        for (LottoRank lottoRank : LottoRank.values()) {
            lottoResult.put(lottoRank, 0);
        }
    }

    private void calculateLotto(int lottoTickets, WinningNumbers winningNumbers) {
        initializeLottoResultMap();
        for (int i = 0; i < lottoTickets; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
            Lotto lotto = new Lotto(numbers);
            calculateResult(winningNumbers, lotto);
        }
    }

    private void calculateResult(WinningNumbers winningNumbers, Lotto lotto) {
        LottoRank lottoRank = winningNumbers.calculateRank(lotto);
        lottoResult.put(lottoRank, lottoResult.getOrDefault(lottoRank, 0) + 1);
        OutputView.printLottoNumber(lotto);
    }

    private int calculateLottoEarningMoney() {
        int earningMoney = DEFAULT_EARNING_MONEY;
        for (LottoRank lottoRank : lottoResult.keySet()) {
            if (lottoResult.get(lottoRank) >= 1) {
                earningMoney += lottoResult.get(lottoRank) * lottoRank.getRewardMoney();
            }
        }
        OutputView.printLottoResult(lottoResult);
        return earningMoney;
    }

}
