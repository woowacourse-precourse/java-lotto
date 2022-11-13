package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.validate.Validate;
import lotto.view.Input;
import lotto.view.Output;

public class LottoGenerator {
    private final List<Lotto> container;

    public LottoGenerator() {
        container = new ArrayList<>();
    }

    public void generate() {
        generate(Integer.parseInt(ShouldReturnInputPurchasingAmountWhenValidated()) / 1000);
    }

    public void generate(int numberOfLottos) {
        for (int number = 0; number < numberOfLottos; number++) {
            createLottoAndPutIntoContainer();
        }
        Output.printLottoHistory(container);
    }

    public void createLottoAndPutIntoContainer() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Stream<Integer> randomNumbersStream = randomNumbers.stream();
        randomNumbers = randomNumbersStream.sorted().collect(Collectors.toList());
        container.add(new Lotto(randomNumbers));
    }

    public String ShouldReturnInputPurchasingAmountWhenValidated() {
        return validate(Input.readPurchasingAmount());
    }

    private String validate(String purchasingAmount) {
        Validate.validatePurchasingAmount(purchasingAmount);
        return purchasingAmount;
    }

    public int size() {
        return container.size();
    }
}
