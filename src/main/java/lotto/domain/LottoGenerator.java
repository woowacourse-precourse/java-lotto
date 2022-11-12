package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static int LOTTO_MIN_NUMBER = 1;
    private static int LOTTO_MAX_NUMBER = 45;
    private static int LOTTO_SIZE = 6;

    private LottoGenerator() {}

    public static List<Lotto> buyMultipleRandomLotto(Money userMoney){
        List<Lotto> userLottos = new ArrayList<>();
        int countOfLotto = userMoney.getCountOfLotto();
        for(int count = 0; count < countOfLotto; count++){
            userLottos.add(getRandomLotto());
        }
        return userLottos;
    }

    private static Lotto getRandomLotto(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
        return new Lotto(lottoNumbers);
    }
}