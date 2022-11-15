package lotto.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static lotto.model.Prize.NONE;
import static lotto.utils.Constant.LOTTO_PRICE;

public class Lottos {
    public static final String INPUT_RIGHT_MONEY = "[ERROR] 1000원으로 나누어 떨어지는 금액을 입력해주세요.";
    public static final long INITIALIZE_WINNING_RESULT_VALUE = 0L;
    public static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    public static final long RESULT_INITIAL_VALUE = 1L;

    private final List<Lotto> lottos = new ArrayList<>();

    private Lottos(int money) {
        validateMoney(money);
        purchaseLotto(money);
    }

    private static void validateMoney(int money) {
        if (isRestMoney(money)) {
            throw new IllegalArgumentException(INPUT_RIGHT_MONEY);
        }
    }

    private void purchaseLotto(int money) {
        int totalLotto = money / LOTTO_PRICE;
        for (int count = 0; count < totalLotto; count++) {
            lottos.add(Lotto.create());
        }
    }

    private static boolean isRestMoney(int money) {
        return money % LOTTO_PRICE != 0;
    }

    public static Lottos purchaseLottos(int money) {
        return new Lottos(money);
    }

    public void printAllLottos() {
        System.out.println(lottos.size() + PURCHASE_MESSAGE);
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
    }

    public Map<Prize, Long> compareResult(Result result) {
        Map<Prize, Long> winningResult = initializeWinningResult();
        compareLotto(result, winningResult);
        return winningResult;
    }

    private void compareLotto(Result result, Map<Prize, Long> winningResult) {
        lottos.stream()
                .map(result::compare)
                .filter(isDifferentWithNone())
                .forEach(addResult(winningResult));
    }

    private static Map<Prize, Long> initializeWinningResult() {
        Map<Prize, Long> winningResult = new LinkedHashMap<>();
        for (Prize prize : Prize.values()) {
            winningResult.put(prize, INITIALIZE_WINNING_RESULT_VALUE);
        }
        winningResult.remove(NONE);
        return winningResult;
    }

    private static Predicate<Prize> isDifferentWithNone() {
        return prize -> prize != NONE;
    }

    private static Consumer<Prize> addResult(Map<Prize, Long> winningResult) {
        return prize -> winningResult.merge(prize, RESULT_INITIAL_VALUE, Long::sum);
    }
}
