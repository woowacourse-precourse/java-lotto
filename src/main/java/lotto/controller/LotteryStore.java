package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoCalculator;
import lotto.model.LottoRankingType;
import lotto.view.UserInterface;

import java.util.ArrayList;
import java.util.List;

public class LotteryStore {
    private static final int ARRAY_LIST_SIZE = 1024;
    private static final int WINNING_NUMBER_COUNT = 6;
    private static final String ERROR_WINNING_NUMBER_DUPLICATED = "[ERROR] 당첨 번호는 서로 다른 숫자를 입력 해 주셔야 합니다.";
    private static final String ERROR_BONUS_NUMBER_DUPLICATED = "[ERROR] 당첨 번호 중 보너스 번호와 동일한 번호가 있습니다.";
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
        List<LottoRankingType> lottoRankingTypes
                = this.lottoCalculator.getLottoRanking(this.winningNumbers, this.bonusNumber, this.lottos);

        // 결과를 userinterface에 넘겨주자
        this.userInterface.printResult();
    }
}
