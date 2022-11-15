package lotto.domain.lottoPublication;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.Lotto;
import lotto.utils.Constants;

public class LottoPublication {
    public static Lottos publicationLottos(int count){
        Lottos lottos = new Lottos();

        for(int i = 0; i<count; i++){
            lottos.addLotto(new Lotto(generateLottoNumber()));
        }
        return lottos;
    }

    private static List<Integer> generateLottoNumber(){
        return Randoms.pickUniqueNumbersInRange(Constants.LOTTO_MIN_NUMBER,Constants.LOTTO_MAX_NUMBER,Constants.LOTTO_NUMBER_COUNT);
    }
}
