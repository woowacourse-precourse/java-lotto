package lotto.view;

import lotto.strings.Strings;
import lotto.Lotto;

import java.util.List;

public class OutputView {
    public void lottoNumber(int count, List<Lotto> numbers) {
        System.out.println(count + Strings.purchaseCheckMessage);
        numbers.stream().forEach
                (lotto -> System.out.println(lotto.getNumbers()));
    }
}
