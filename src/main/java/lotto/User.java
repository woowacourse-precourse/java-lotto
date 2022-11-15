package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class User {
    private long amount;
    private long purchaseCount;
    private List<Lotto> lottos = new ArrayList<>();
    private Map<Rank, Integer> resultMap = new HashMap<>();

    private static final String WIN_COUNT_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String WIN_SECOND_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %d%%입니다.";

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
            lottoNumbers = lottoNumbers.stream().sorted().collect(Collectors.toList());
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

    public void printLottoResult(WinLotto winLotto) {
        calculateLottoResult(winLotto);
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(getRankResultMessage());
        System.out.println(getRateOfReturnMessage());
    }

    private void calculateLottoResult(WinLotto winLotto) {
        initResultMap();
        for (Lotto lotto:lottos) {
            Rank rank = winLotto.getLottoResult(lotto);
            resultMap.put(rank, resultMap.get(rank) + 1);
        }
    }

    private void initResultMap() {
        for (Rank rank:Rank.values()) {
            resultMap.put(rank, resultMap.getOrDefault(rank, 0));
        }
    }

    private String getRankResultMessage() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format(WIN_COUNT_MESSAGE, Rank.FIFTH.winLottoCount(),
                                           decimalFormat.format(Reward.FIFTH.reward()), resultMap.get(Rank.FIFTH)));
        stringBuilder.append("\n");
        stringBuilder.append(String.format(WIN_COUNT_MESSAGE, Rank.FOURTH.winLottoCount(),
                decimalFormat.format(Reward.FOURTH.reward()), resultMap.get(Rank.FOURTH)));
        stringBuilder.append("\n");
        stringBuilder.append(String.format(WIN_COUNT_MESSAGE, Rank.THIRD.winLottoCount(),
                decimalFormat.format(Reward.THIRD.reward()), resultMap.get(Rank.THIRD)));
        stringBuilder.append("\n");
        stringBuilder.append(String.format(WIN_SECOND_MESSAGE, Rank.SECOND.winLottoCount(),
                decimalFormat.format(Reward.SECOND.reward()), resultMap.get(Rank.SECOND)));
        stringBuilder.append("\n");
        stringBuilder.append(String.format(WIN_COUNT_MESSAGE, Rank.FIRST.winLottoCount(),
                decimalFormat.format(Reward.FIRST.reward()), resultMap.get(Rank.FIRST)));

        return stringBuilder.toString();
    }

    private String getRateOfReturnMessage() {
        long totalReward = 0;

        Iterator<Rank> keys =  resultMap.keySet().iterator();
        while (keys.hasNext()) {
            Rank rank = keys.next();
            totalReward += resultMap.get(rank) * Reward.valueOfRank(rank).reward();
        }


        return String.format(RATE_OF_RETURN_MESSAGE, totalReward / amount);
    }
}
