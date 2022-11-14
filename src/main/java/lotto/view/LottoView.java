package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class LottoView {

    public void printAllLotto(List<Lotto> wallet) {
        for (Lotto lotto : wallet) {
            List<Integer> numbers = lotto.getNumbers();
            System.out.println(numbers);
        }
    }
}
