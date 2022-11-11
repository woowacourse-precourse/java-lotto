package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.PrizeList;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class LottoView {
    public final String PURCHASE = "구입금액을 입력해 주세요.";
    public final String INPUT_ANSWER = "당첨 번호를 입력해 주세요.";
    public final String INPUT_BONUS = "보너스 번호를 입력해 주세요.";

    public String afterPurchase(int purchaseAmount) {
        return purchaseAmount / 1000 + "개를 구매했습니다.";
    }

    public String lottos(List<Lotto> lottos) {
        return lottos.stream()
                .map(Lotto::sorted)
                .map(Collection::toString)
                .collect(Collectors.joining("\n"));
    }

    public String result(PrizeList prizeList) {
        return Prize.FIFTH.toString() + prizeList.getFifth() + "개\n" +
                Prize.FOURTH + prizeList.getFourth() + "개\n" +
                Prize.THIRD + prizeList.getThird() + "개\n" +
                Prize.SECOND + prizeList.getSecond() + "개\n" +
                Prize.FIRST + prizeList.getFirst() + "개";
    }

    public String yield(String yield) {
        return "총 수익률은 " + yield + "%입니다.";
    }
}
