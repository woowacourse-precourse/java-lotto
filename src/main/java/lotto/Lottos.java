package lotto;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Lottos {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final int COUNT = 6;
    private int lottoCount;
    private List<Lotto> lottos;

    public Lottos(int lottoCount) {
        this.lottoCount = lottoCount;
        createLottos(lottoCount);
    }

    private void createLottos(int lottoCount){
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, COUNT));
        lottos = new ArrayList<Lotto>();
        for(int i = 0; i < lottoCount; i++) {
            lottos.add(lotto);
        }
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
