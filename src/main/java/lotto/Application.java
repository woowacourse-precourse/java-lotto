package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Money money = new Money();
        int count = 8;
        List<Lotto> lottos = generateLottos(count);
    }

    public static List<Lotto> generateLottos(int count) {
        NumberGenerator generator = new NumberGenerator();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = generator.createRandomUniqueNumbers();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }
}
