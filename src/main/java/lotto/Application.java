package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Money money = new Money(askMoney());
        Integer count = money.getLottoCount();
        List<Lotto> lottos = generateLottos(count);
    }

    @SuppressWarnings("unchecked")
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

    private static Integer askMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
