package lotto;

import static lotto.Rank.valueOfRank;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

public class Simulator {
    private int quantity;
    private List<Lotto> lottos;
    private Lotto winning;
    private int bonus;

    public Simulator(int price) {
        validatePrice(price);
        this.quantity = toQuantity(price);
        this.lottos = generate(this.quantity);
    }

    public int getQuantity() {
        return this.quantity;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public Simulator setWinning(Lotto winning, int bonus) {
        this.winning = winning;
        Lotto.validateRange(bonus);
        this.bonus = bonus;
        return this;
    }

    public List<Integer> getStatistic() {
        List<Integer> wins = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        for (Lotto lotto : this.lottos) {
            int rank = lotto.compare(this.winning, this.bonus);
            if (rank < 6) {
                wins.set(rank - 1, wins.get(rank - 1) + 1);
            }
        }
        return wins;
    }

    private void validatePrice(int price) {
        if ((price % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야합니다.");
        }
    }

    private int toQuantity(int price) {
        return price / 1000;
    }

    public static List<Lotto> generate(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(generate());
        }
        return lottos;
    }

    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public static BigDecimal calculateRateOfReturn(List<Integer> wins, int purchasePrice) {
        BigDecimal totalWinningPrice = new BigDecimal(calculateTotalWinningPrice(wins));
        BigDecimal totalPurchasePrice = new BigDecimal(purchasePrice);
        return totalWinningPrice.divide(totalPurchasePrice, new MathContext(3));
    }

    public static BigInteger calculateTotalWinningPrice(List<Integer> wins) {
        BigInteger totalWinningPrice = new BigInteger("0");
        for (int rank = 1; rank < 6; rank++) {
            for (int n = 0; n < wins.get(rank - 1); n++) {
                totalWinningPrice = totalWinningPrice.add(
                        BigInteger.valueOf(
                                valueOfRank(rank).getWinningPrice()
                        )
                );
            }
        }
        return totalWinningPrice;
    }
}
