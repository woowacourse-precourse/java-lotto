package lotto.Services;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Dto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LogicService {
    public List<Lotto> makeLotto(int lottoSize) {
        List<Lotto> lottos = new ArrayList<>(lottoSize);
        for(int i = 0; i < lottoSize; i++){
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }
}
