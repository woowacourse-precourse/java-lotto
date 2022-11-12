package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public static List<Lotto> generatLottos(Integer amount) {
        List<Lotto> lottos=new ArrayList<>();
        for(int i=0;i<getCount(amount);i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            sortNumbers(numbers);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static int getCount(Integer amount) {
        int count = amount / 1000;
        return count;
    }

    private static void sortNumbers(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
    }
}
