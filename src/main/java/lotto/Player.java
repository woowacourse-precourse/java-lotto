package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Player {

    public static final int LOTTO_PRICE = 1000;
    public static final String ERROR_NOT_VALID_PRICE = "[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다.";
    public static final int CRITERION_ZERO = 0;

    public int canBuyLottoCount(int price) {
        validate(price);
        return price / LOTTO_PRICE;
    }

    private void validate(int price) {
        if (!isDivided(price)) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_PRICE);
        }
    }

    private boolean isDivided(int price) {
        return ((price % LOTTO_PRICE) == CRITERION_ZERO);
    }

    public List<Lotto> buyLottos(int price, List<List<Integer>> lottoNumbers) {
        canBuyLottoCount(price);
        return lottoNumbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

}
