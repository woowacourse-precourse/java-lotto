package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoCalculator;
import lotto.model.LottoRankingType;
import lotto.view.UserInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LotteryStore {
    private static final int ARRAY_LIST_SIZE = 1024;
    private static final int WINNING_NUMBER_COUNT = 6;
    private static final int ZERO = 0;
    private static final int LOTTO_PRICE = 1000;
    private static final int RATE = 100;
    private static final String ERROR_WINNING_NUMBER_DUPLICATED = "[ERROR] 당첨 번호는 서로 다른 숫자를 입력 해 주셔야 합니다.";
    private static final String ERROR_BONUS_NUMBER_DUPLICATED = "[ERROR] 당첨 번호 중 보너스 번호와 동일한 번호가 있습니다.";
    private static final String ERROR_LOTTO_COUNT = "[ERROR] 로또를 최소 1개 이상 구매 해야 합니다. 로또 금액 : 1000원";
    private UserInterface userInterface;
    private LottoCalculator lottoCalculator;
    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private int lottoCount;

    public LotteryStore() {
        this.userInterface = new UserInterface();
        this.lottoCalculator = new LottoCalculator();
        this.lottos = new ArrayList<>(ARRAY_LIST_SIZE);
        this.winningNumbers = new ArrayList<>(WINNING_NUMBER_COUNT);
    }

    public void buyLotto() {
        this.lottoCount = this.userInterface.getLottoCount();
        for (int i = 0; i < lottoCount; ++i) {
            this.lottos.add(new Lotto(lottoCalculator.createLotto()));
        }

        if (lottoCount < 1) {
            throw new IllegalArgumentException(ERROR_LOTTO_COUNT);
        }

        this.userInterface.printLotto(this.lottoCount, this.lottos);
    }

    public void inputWinningNumbers() {
        this.winningNumbers = this.userInterface.getWinningNumbers();

        if (this.winningNumbers.size() != this.winningNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBER_DUPLICATED);
        }
    }

    public void inputBonusNumber() {
        this.bonusNumber = this.userInterface.getBonusNumber();

        if (this.winningNumbers.contains(this.bonusNumber)) {
            throw new IllegalArgumentException(ERROR_BONUS_NUMBER_DUPLICATED);
        }
    }

    public void outputResult() {
        // 로또 당첨 계산하고
        Map<LottoRankingType, Integer> lottoRankingTypes = this.lottoCalculator.getLottoRanking(this.winningNumbers, this.bonusNumber, this.lottos);

        int totalAmount = getTotalWinningAmount(lottoRankingTypes);
        double rateOfReturn = 0.0;
        if (totalAmount != ZERO || this.lottos.size() != ZERO) {
           rateOfReturn = (double) totalAmount / (double) (this.lottos.size() * LOTTO_PRICE) * RATE;
        }
        // 결과를 userinterface에 넘겨주자
        this.userInterface.printResult(lottoRankingTypes, rateOfReturn);
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
            return lottoRankingType.getWinningAmount() * lottoRankingTypes.get(lottoRankingType).intValue();
        }

        return ZERO;
    }
}
