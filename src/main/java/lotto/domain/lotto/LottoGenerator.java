package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {

    public static Lotto createLottoWithRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> sortedNumbers = randomNumbers.stream().sorted().collect(Collectors.toList());
        return new Lotto(sortedNumbers);
    }

    public static Lotto createWinningLottoWithEnterNumbers() {
        String enterNumbers = Console.readLine();
        List<Integer> numbers = Arrays.stream(enterNumbers.split(","))
            .mapToInt(Integer::parseInt)
            .boxed()
            .sorted()
            .collect(Collectors.toList());
    }
}
