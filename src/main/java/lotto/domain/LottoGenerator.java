package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoGenerator {
    public List<Lotto> generateLottos(int numberOfLotto) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> randomNumbers = generateRandomNumbers();
            Lotto lotto = new Lotto(randomNumbers);
        }
        return lottos;
    }

    public List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
}
