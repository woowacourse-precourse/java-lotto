package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedList;
import java.util.List;
import lotto.model.Lotto;

public class MakeLotteriesService {
    private List<Lotto> lotteries;

    public void makeLotteries(int lotteriesNumber){
        lotteries = new LinkedList<>();
        for (int lottoCount = 0; lottoCount < lotteriesNumber; lotteriesNumber++){
            lotteries.add(makeLotto());
        }
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    private Lotto makeLotto(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
