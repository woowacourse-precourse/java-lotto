package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.Lotto;
import lotto.util.Type;
import lotto.util.InputUtility;

public class LottoShop {

    public List<Lotto> buy() {
        return createLotto(getAmountInput());
    }

    private int getAmountInput() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(InputUtility.readLine(Type.AMOUNT.getValue()));
    }

    private List<Lotto> createLotto(int amount) {
        return IntStream.range(0, (int) (amount / 1000))
            .mapToObj(i -> pickLottoNumber())
            .map(Lotto::new)
            .collect(Collectors.toList());
    }

    private List<Integer> pickLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
            .stream().sorted()
            .collect(Collectors.toList());
    }

}
