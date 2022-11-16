package lotto.view;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoView {

    public void printAllLotto(List<Lotto> wallet) {
        for (Lotto lotto : wallet) {
            List<Integer> numbers = lotto.getNumbers();

            List<Integer> tmp = new ArrayList<>(numbers);

            Collections.sort(tmp);

            System.out.println(tmp);
        }
    }
}
