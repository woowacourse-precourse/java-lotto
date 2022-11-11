package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public List<Lotto> generateLottoAuto(int number) {

        List<Lotto> generatedLottos = new ArrayList<>();

        while (generatedLottos.size() < number) {
            List<Integer> numbers =
                    Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.NUMBER_COUNT);
            generatedLottos.add(new Lotto(numbers));
        }

        return generatedLottos;
    }

}
