package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomLottoNumbersGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static List<Lotto> generateLottoMachine(int count, int size) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(generate(size)));
        }

        return lottos;
    }

    private static List<Integer> generate(int size) {
        Set<Integer> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() != size) {
            lottoNumbers.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
        }

        return new ArrayList<>(lottoNumbers);
    }
}
