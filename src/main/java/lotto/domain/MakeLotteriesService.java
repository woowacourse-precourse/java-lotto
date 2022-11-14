package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedList;
import java.util.List;
import lotto.model.Lotto;

public class MakeLotteriesService {
    private List<Lotto> lotteries;

    public MakeLotteriesService(int lotteriesNumber){
        makeLotteries(lotteriesNumber);
    }

    private void makeLotteries(int lotteriesNumber){
        lotteries = new LinkedList<>();
        for (int lottoCount = 0; lottoCount < lotteriesNumber; lottoCount++){
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
