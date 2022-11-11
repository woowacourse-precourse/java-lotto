package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    public static final int LOTTO_PRICE = 1000;
    public static final String ERROR_NOT_VALID_PRICE = "[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다.";
    public static final int CRITERION_ZERO = 0;
    public static final String ERROR_PRICE_COUNT_NOT_EQUAL_LOTTO_SIZE = "[ERROR] 주어진 금액과 주어진 로또 번호의 개수가 일치하지 않습니다.";

    private final List<Lotto> lottos;

    public Player() {
        lottos = new ArrayList<>();
    }

    public List<Lotto> buyLottos(int purchasePrice, List<List<Integer>> lottoNumbers) {
        int purchaseLottoCount = calculateLottoCount(purchasePrice);
        validateSize(purchaseLottoCount, lottoNumbers.size());

        List<Lotto> createLottos = lottoNumbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());

        this.lottos.addAll(createLottos);
        return lottos;
    }

    public int calculateLottoCount(int purchasePrice) {
        validateCanPurchase(purchasePrice);
        return purchasePrice / LOTTO_PRICE;
    }

    private void validateCanPurchase(int purchasePrice) {
        if (!isDivided(purchasePrice)) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_PRICE);
        }
    }

    private boolean isDivided(int purchasePrice) {
        return ((purchasePrice % LOTTO_PRICE) == CRITERION_ZERO);
    }

    private void validateSize(int buyLottoCount, int lottoNumbersSize) {
        if (!isSame(buyLottoCount, lottoNumbersSize)) {
            throw new IllegalArgumentException(ERROR_PRICE_COUNT_NOT_EQUAL_LOTTO_SIZE);
        }
    }

    private boolean isSame(int count, int lottoNumbersSize) {
        return count == lottoNumbersSize;
    }
}
