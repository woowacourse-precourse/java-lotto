package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Lottos {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final int COUNT = 6;

    // Results
    private List<LottoStatus> lottosStatus;
    private LottoResults lottoResults;
    private float totalWinningAmount;

    // com Lottos
    private int lottoCount;
    private List<Lotto> lottosNumbers;

    // user Lottos
    private Lotto winningLotto;
    private int bonusNum;

    public Lottos(int lottoCount, Lotto winningLotto, int bonusNum) {
        this.lottoCount = lottoCount;
        createLottos(lottoCount);
        createWinningNumbers(winningLotto, bonusNum);
        createLottosStatus();
        createLottoResults();
        calcTotalAmount();
    }

    private void createLottos(int lottoCount){
        this.lottosNumbers = new ArrayList<Lotto>();
        for(int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, COUNT));
            lottosNumbers.add(lotto);
        }
    }

    private void createWinningNumbers(Lotto lotto, int bonusNum){
        this.winningLotto = lotto;
        this.bonusNum = bonusNum;
    }

    private void createLottosStatus() {
        this.lottosStatus = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++) {
            this.lottosStatus.add(createLottoStatus(lottosNumbers.get(i)));
        }
    }

    private LottoStatus createLottoStatus(Lotto lotto) {
        return new LottoStatus(lotto, winningLotto, bonusNum);
    }

    public float getTotalWinningAmount() {
        return this.totalWinningAmount;
    }

    private void calcTotalAmount() {
        for(int i = 0; i < lottosStatus.size(); i++) {
            this.totalWinningAmount += lottosStatus.get(i).calcAmount();
        }
    }

    private void createLottoResults() {
        this.lottoResults = new LottoResults(this.lottosStatus);
    }

    public LottoResults getLottoResults() {
        return lottoResults;
    }

    public int getLottoCount() {
        return this.lottoCount;
    }

    public List<Lotto> getLottos() {
        return this.lottosNumbers;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
