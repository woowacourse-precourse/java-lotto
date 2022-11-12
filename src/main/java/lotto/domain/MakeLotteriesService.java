package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class MakeLotteriesService {
    private List<List<Integer>> lotteries;

    public void makeLotteries(int lotteriesNumber){
        for (int lottoCount = 0; lottoCount < lotteriesNumber; lotteriesNumber++){
            lotteries.add(makeLotto());
        }
    }

    public List<List<Integer>> getLotteries() {
        return lotteries;
    }

    private List<Integer> makeLotto(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
