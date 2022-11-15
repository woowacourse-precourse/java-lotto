package lotto.view;

import lotto.domain.Lotto;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class LottoView {
    public void purchase() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void afterPurchase(int purchaseAmount) {
        System.out.println("\n" + purchaseAmount / 1000 + "개를 구매했습니다.");
    }

    public void lottos(List<Lotto> lottos) {
        lottos.stream()
                .map(Lotto::sorted)
                .map(Collection::toString)
                .forEach(System.out::println);
    }

    public void inputAnswer() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public void inputBonus() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }
}
