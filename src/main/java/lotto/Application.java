package lotto;

import static lotto.Cli.getPurchaseAmount;
import static lotto.Cli.print;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        int amount = getPurchaseAmount();
        int purchaseCount = amount / 1000;
        List<Lotto> lottoList = createLotto(purchaseCount);
        print(lottoList);
    }

    /**
     * Function to create lotto.
     * @param count The integer value of lotto count.
     * @return The list of lotto.
     */
    private static List<Lotto> createLotto(Integer count) {

        List<Lotto> lottoList = new ArrayList<>();
        for (int i=0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> sortedNumber = numbers.stream()
                .sorted().collect(Collectors.toList());
            Lotto lotto = new Lotto(sortedNumber);
            lottoList.add(lotto);
        }

        return lottoList;
    }
}
