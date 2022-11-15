package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private long amount;
    private long purchaseCount;
    private List<Lotto> lottos = new ArrayList<>();

    public User(long amount) {
        validate(amount);
        this.amount = amount;
        calculatePurchaseCount();
    }

    private void validate(long amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000 단위로 입력해야 합니다.");
        }
    }

    private void calculatePurchaseCount() {
        this.purchaseCount = amount / 1000;
    }

    public void buyLotto() {
        for (int purchaseIndex = 0; purchaseIndex < purchaseCount; purchaseIndex++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumbers.sort(Integer::compareTo);
            lottos.add(new Lotto(lottoNumbers));
        }
    }

    public void printLottos() {
        System.out.println(purchaseCount + "개를 구매했습니다.");
        System.out.println(lottosToString());
    }

    private String lottosToString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Lotto lotto:lottos) {
            stringBuilder.append(lotto.toString())
                    .append("\n");
        }

        return stringBuilder.toString();
    }
}
