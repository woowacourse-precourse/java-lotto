package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;
import lotto.domain.LottoRankingType;
import lotto.validation.LottoStoreValidation;
import lotto.view.UserInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoStore {
    private static final int LIST_SIZE = 1024;
    private static final int WINNING_NUMBER_COUNT = 6;
    private static final int ZERO = 0;
    private static final int LOTTO_PRICE = 1000;
    private static final int RATE = 100;
    private static final double DOUBLE_ZERO = 0.0;
    private static final UserInterface userInterface = new UserInterface();
    private static final LottoCalculator lottoCalculator = new LottoCalculator();
    private static final LottoStoreValidation lottoStoreValidation = new LottoStoreValidation();
    private final List<Lotto> lotteryTickets;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoStore() {
        this.lotteryTickets = new ArrayList<>(LIST_SIZE);
        this.winningNumbers = new ArrayList<>(WINNING_NUMBER_COUNT);
    }

    public void buyLotto() {
        int lottoCount = userInterface.getBuyLottoCount();

        for (int i = 0; i < lottoCount; ++i) {
            this.lotteryTickets.add(new Lotto(lottoCalculator.createLotto()));
        }

        lottoStoreValidation.lottoCountCheck(lottoCount);

        ArrayList<ArrayList<Integer>> displayLottoNumbers
                = lottoCalculator.getDisplayLottoNumbers(this.lotteryTickets);
        userInterface.printLotto(lottoCount, displayLottoNumbers);
    }

    public void inputWinningNumbers() {
        this.winningNumbers = userInterface.getWinningNumbers();
        lottoStoreValidation.lottoNumberDuplicateCheck(this.winningNumbers);
    }

    public void inputBonusNumber() {
        this.bonusNumber = userInterface.getBonusNumber();
        lottoStoreValidation.bonusNumberInWinningNumberCheck(this.winningNumbers, this.bonusNumber);
    }

    public void outputResult() {
        Map<LottoRankingType, Integer> lottoRankingTypes
                = lottoCalculator.getRankings(this.winningNumbers, this.bonusNumber, this.lotteryTickets);
        userInterface.printResult(lottoRankingTypes, getRateOfReturn(lottoRankingTypes));
    }

    private int getTotalWinningAmount(Map<LottoRankingType, Integer> lottoRankingTypes) {
        int totalAmount = 0;
        totalAmount += getWinningAmount(lottoRankingTypes, LottoRankingType.FIRST_PLACE);
        totalAmount += getWinningAmount(lottoRankingTypes, LottoRankingType.SECOND_PLACE);
        totalAmount += getWinningAmount(lottoRankingTypes, LottoRankingType.THIRD_PLACE);
        totalAmount += getWinningAmount(lottoRankingTypes, LottoRankingType.FOURTH_PLACE);
        totalAmount += getWinningAmount(lottoRankingTypes, LottoRankingType.FIFTH_PLACE);
        return totalAmount;
    }

    private int getWinningAmount(Map<LottoRankingType, Integer> lottoRankingTypes, LottoRankingType lottoRankingType) {
        if (lottoRankingTypes.containsKey(lottoRankingType)) {
            return lottoRankingType.getWinningAmount() * lottoRankingTypes.get(lottoRankingType);
        }
        return ZERO;
    }

    private double getRateOfReturn(Map<LottoRankingType, Integer> lottoRankingTypes) {
        int totalAmount = getTotalWinningAmount(lottoRankingTypes);
        double rateOfReturn = DOUBLE_ZERO;
        if (totalAmount != ZERO && this.lotteryTickets.size() != ZERO) {
            rateOfReturn = (double) totalAmount / (double) (this.lotteryTickets.size() * LOTTO_PRICE) * RATE;
        }
        return rateOfReturn;
    }
}
