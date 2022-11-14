package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import lotto.utils.Constants;

public class LottoPublication {

    public static Lottos publicationLottos(int count){
        Lottos lottos = new Lottos();

        for(int i = 0; i<count; i++){
            lottos.addLotto(new Lotto(generateLottoNumber()));
        }

        return lottos;
    }

    private static ArrayList<Integer> generateLottoNumber(){
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(Constants.LOTTO_MIN_NUMBER,Constants.LOTTO_MAX_NUMBER,Constants.LOTTO_NUMBER_COUNT));
    }
}
