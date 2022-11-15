package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Machine {

    public static BigInteger countNumberOfLottos(BigInteger money) {
        return money.divide(BigInteger.valueOf(1_000));
    }

    public static List<Lotto> generateLottos(BigInteger numberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (BigInteger bi = BigInteger.valueOf(0);
             bi.compareTo(numberOfLottos) < 0;
             bi = bi.add(BigInteger.ONE)) {

            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> sortedLottoNumbers = lottoNumbers.stream().sorted().collect(Collectors.toList());
            lottos.add(new Lotto(sortedLottoNumbers));
        }
        return lottos;
    }

}
