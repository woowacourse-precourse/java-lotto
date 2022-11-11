package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.entity.Lotto;

public class LottoService {

    public static final int COUNT = 6;
    public static final int RANGE_START = 1;
    public static final int RANGE_END = 45;
    public static final int PRICE = 1000;

    private static final String ERROR_MESSAGE = "금액은 " + PRICE + "원 단위로 입력해야 합니다. 입력 : ";

    public List<Lotto> generateLottos(int price) {
        if (price % PRICE != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + price);
        }
        return IntStream.range(0, price / PRICE)
            .mapToObj(
                i -> new Lotto(Randoms.pickUniqueNumbersInRange(RANGE_START, RANGE_END, COUNT)))
            .collect(Collectors.toList());
    }

}
