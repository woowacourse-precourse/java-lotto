package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.validate.ValidatePurchasingAmount;
import lotto.view.Input;
import lotto.view.Output;

public class LottoGenerator {
    private final List<Lotto> container;

    public LottoGenerator() {
        container = new ArrayList<>();
    }

    public List<Lotto> generate() throws IllegalArgumentException {
        String purchasingAmount = Input.readPurchasingAmount();
        ValidatePurchasingAmount.validate(purchasingAmount);
        return generate(getLottoNumbers(purchasingAmount));
    }

    private int getLottoNumbers(String purchasingAmount) {
        return Integer.parseInt(purchasingAmount) / 1000;
    }

    public List<Lotto> generate(int numberOfLottos) {
        for (int number = 0; number < numberOfLottos; number++) {
            createLottoAndPutIntoContainer();
        }
        Output.printLottoHistory(container);
        return container;
    }

    public void createLottoAndPutIntoContainer() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Stream<Integer> randomNumbersStream = randomNumbers.stream();
        randomNumbers = randomNumbersStream.sorted().collect(Collectors.toList());
        container.add(new Lotto(randomNumbers));
    }

    public int size() {
        return container.size();
    }
}
