package lotto.domain;

import static lotto.constant.LottoRule.PRICE_OF_ONE_LOTTO;
import static lotto.constant.LottoRule.COUNT_OF_NUMBERS;
import static lotto.constant.LottoRule.END_NUMBER;
import static lotto.constant.LottoRule.START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.ErrorMessage;
import lotto.ui.UserInterface;

public class LottoMachine {
    public static List<Lotto> publish(String inputMoneyRaw) {
        int inputMoney = convertStringToInt(inputMoneyRaw);
        validate(inputMoney);
        int countOfLottos = getCountOfLottos(inputMoney);
        UserInterface.announceCountOfLottosPublished(countOfLottos);
        List<Lotto> lottos = publishLottosByCount(countOfLottos);
        return lottos;
    }

    private static int convertStringToInt(String numberRaw) {
        return Integer.parseInt(numberRaw);
    }

    private static void validate(int inputMoney) {
        boolean isMultipleOfPriceOfLotto = (inputMoney % PRICE_OF_ONE_LOTTO) == 0;
        if (isMultipleOfPriceOfLotto) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.LOTTO_MACHINE_NOT_MULTIPLE_OF_PRICE_OF_LOTTO);
    }

    private static int getCountOfLottos(int inputMoney) {
        return inputMoney / PRICE_OF_ONE_LOTTO;
    }

    private static List<Lotto> publishLottosByCount(int countOfLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < countOfLottos; count++) {
            List<Integer> randomNumbers = getSortedRandomNumbers();
            Lotto lotto = new Lotto(randomNumbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    private static List<Integer> getSortedRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT_OF_NUMBERS)
                .stream()
                .sorted()
                .collect(Collectors.toList());
        return numbers;
    }
}
