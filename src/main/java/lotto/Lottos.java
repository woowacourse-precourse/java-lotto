package lotto;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class Lottos {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final int COUNT = 6;
    LottoResult lottoResult;
    int totalWinningAmount;
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

    public void countResult() {
    }

    public void calcAmount() {
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
