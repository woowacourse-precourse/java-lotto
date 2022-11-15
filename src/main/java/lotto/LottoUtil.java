package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoUtil {

    public static int numberOfLottoAvailableCount(int userMoney) {
        return userMoney/1000;
    }

    public static List<Lotto> getLottos(int userLottoCnt) {

        List<Lotto> userLottos = new ArrayList<>();

        for(int i = 0 ; i < userLottoCnt ; i++){
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);

            Collections.sort(lottoNumbers);

            userLottos.add(new Lotto(lottoNumbers));
        }

        return userLottos;
    }
}
