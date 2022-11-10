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
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, COUNT));
        this.lottosNumbers = new ArrayList<Lotto>();
        for(int i = 0; i < lottoCount; i++) {
            lottosNumbers.add(lotto);
        }
    }

    private void createWinningNumbers(Lotto lotto, int bonusNum){
        this.winningLotto = lotto;
        this.bonusNum = bonusNum;
    }


    public int getLottoCount() {
        return this.lottoCount;
    }

    public List<Lotto> getLottos() {
        return this.lottosNumbers;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
