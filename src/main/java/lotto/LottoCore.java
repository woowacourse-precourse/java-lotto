package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoCore {

    private List<Integer> winnigLotto;
    private int bonusNum;

    LottoCore() {
        winnigLotto = null;
        bonusNum = 0;
    }

    public List<Lotto> createManyLotto(int lottoCount) {

        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto;
        for (int index = 0; index < lottoCount; index++) {
            lotto = createLotto();
            lottos.add(lotto);
        }

        return lottos;
    }

    private Lotto createLotto() {
        Lotto lotto;
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        lotto = new Lotto(numbers);
        return lotto;
    }

    public void setWinnigLotto(List<Integer> winnigLotto) {
        this.winnigLotto = winnigLotto;
    }

    public void setBonus(int bonus) {
        this.bonusNum = bonus;
    }

    public Map<LottoPrize, Integer> compareLotto(List<Lotto> lottos) {

        Map<LottoPrize, Integer> winningList = new EnumMap<>(LottoPrize.class);

        initWinningMap(winningList);

        for (int index = 0; index < lottos.size(); index++) {
            LottoPrize lottoPrize = lottos.get(index).compare(winnigLotto, bonusNum);

            increasePrizeCount(winningList, lottoPrize);
        }
        return winningList;
    }

    private void initWinningMap(Map<LottoPrize, Integer> winningList) {
        LottoPrize[] valuse = LottoPrize.values();
        for (int i = 0; i < valuse.length; i++) {
            winningList.put(valuse[i], 0);
        }
    }

    private void increasePrizeCount(Map<LottoPrize, Integer> winningList, LottoPrize lottoPrize) {
        int prizeCount = winningList.get(lottoPrize);
        winningList.put(lottoPrize, prizeCount + 1);
    }

}
