package lotto.domain;

import static lotto.constant.OutputMessage.PRINT_PURCHASE_AMOUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateLotto {
    public List<Lotto> buyLotto(int purchaseAmount) {
        int count = purchaseAmount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        System.out.println(count + PRINT_PURCHASE_AMOUNT);

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

            List<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());

            Lotto lotto = new Lotto(sortedNumbers);
            lottos.add(lotto);
            lotto.printNumbers();
        }
        return lottos;
    }
}
