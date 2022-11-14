package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.LottoError;

import java.util.*;

public class User {
    private int purchaseAmount;
    private final Map<Prize, Integer> prizes = new HashMap<>();
    private final List<Lotto> lottos = new ArrayList<>();

    public User() {
        Arrays.stream(Prize.values())
                .forEach(o -> prizes.put(o, 0));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<Prize, Integer> getPrizes() {
        return prizes;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    /**
     * 도메인 로직
     */
    public void inputPurchaseAmount(String input) {
        validate(input);
        this.purchaseAmount = Integer.parseInt(input);
    }

    public List<Lotto> createLottos() {
        int count = purchaseAmount / 1000;

        while (count-- > 0) {
            List<Integer> randoms = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(randoms));
        }

        return lottos;
    }

    public void addPrize(Prize prize) {
        prizes.put(prize, prizes.get(prize) + 1);
    }

    public String getYield() {
        double yieldPercent = (double) sumPrizes() / purchaseAmount * 100;

        return String.format("%.1f", yieldPercent);
    }

    private long sumPrizes() {
        return prizes.entrySet().stream()
                .mapToLong(o -> (long) o.getKey().getPrize() * o.getValue())
                .sum();
    }

    private void validate(String input) throws RuntimeException {
        long numericLength = input.chars().filter(Character::isDigit).count();
        if (numericLength != input.length())
            throw new IllegalArgumentException(LottoError.NOT_NUMERIC.getErrorMessage());

        int money = Integer.parseInt(input);
        if (money % 1000 != 0)
            throw new IllegalArgumentException(LottoError.WRONG_UNIT_OF_WON.getErrorMessage());
    }
}
