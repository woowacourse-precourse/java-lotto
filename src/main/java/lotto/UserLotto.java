package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class UserLotto {

    private int money;
    private int lottoCount;
    private List<Lotto> lottos;

    public UserLotto() {
        validateMoneyInput();
        setLottoCount();

        buyLotto();
        printLottoResult();
        printProfit();
    }

    public void validateMoneyInput() {
        try {
            money = Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new NoSuchElementException("[ERROR] 숫자만 입력 가능합니다.");
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 1000원 이상 입력해주세요.");
        }
    }


    public void setLottoCount() {
        this.lottoCount = money / 1000;
    }

    public void buyLotto() {
        WinningNumber winningNumber = new WinningNumber();
        this.lottos = new ArrayList<>();
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lotto.setWinningNumber(winningNumber);
            System.out.println(lotto.getNumbers());
            lottos.add(lotto);
        }
    }


    public Map<Rank, Long> getLottoRankCount() {
        return lottos.stream()
                .map(Lotto::lottoRank)
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
    }

    public void printLottoResult() {
        Map<Rank, Long> rankCount = getLottoRankCount();

        for (Rank rank : Rank.values()) {
            if (!rankCount.containsKey(rank)) {
                rankCount.put(rank, 0L);
            }
            System.out.println(rank.getMatchCountMessage() + " - " + rankCount.get(rank) + "개");
        }
    }

    public void printProfit() {
        Map<Rank, Long> rankCount = getLottoRankCount();
        int totalPrize = 0;

        for (Rank rank : rankCount.keySet()) {
            totalPrize += rank.getPrize() * rankCount.get(rank);
        }

        double profit = (double) totalPrize / money;
        System.out.println("총 수익률은 " + String.format("%.1f", profit * 100) + "%" + "입니다.");
    }


}
