package lotto.view;

import lotto.domain.RandomLotto;

import java.util.List;

public class ResultView {

    StringBuilder sb;

    public void showNumberOfLottoPurchase(RandomLotto randomLotto) {
        sb = new StringBuilder();
        sb.append(randomLotto.getNumberOfLottoGame())
                .append("개를 구매했습니다.");
        System.out.println(sb);
    }

    public void showAllRandomLottoNumbers(RandomLotto randomLotto) {
        for (List<Integer> list : randomLotto.getRandomLottoNumbersList()) {
            System.out.println(list);
        }
    }
}
