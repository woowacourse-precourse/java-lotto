package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.Error;
import lotto.ui.LottoShopView;
import lotto.ui.LottoWin;

public class LottoShop {

    private final int LOTTO_PRICE = 1000;

    public List<Lotto> buy(int money) {
        validate(money);

        int purchaseQuantity = getPurchaseQuantity(money);
        List<Lotto> lottos = createLottos(purchaseQuantity);

        printLotto(lottos);

        return lottos;
    }

    public LinkedHashMap<LottoWin, Integer> compare(
        List<Lotto> lottos,
        List<Integer> winningNumbers,
        Integer bonusNumber
    ) {
        LinkedHashMap<LottoWin, Integer> result = new LinkedHashMap<>();

        Arrays.stream(LottoWin.values())
            .forEach(lottoWin -> result.put(lottoWin, 0));

        lottos.forEach(
            lotto -> {
                List<Integer> lottoNumbers = lotto.getNumbers();

                long count = lottoNumbers.stream()
                    .filter(winningNumbers::contains)
                    .count();

                boolean hasBonusNumber = lottoNumbers.contains(bonusNumber);

                if (count >= 3) {
                    result.merge(LottoWin.getWinPlace(count, hasBonusNumber), 1, Integer::sum);
                }
            }
        );

        return result;
    }

    private void validate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(Error.IS_NOT_THOUSAND_UNIT.getMessage());
        }
    }

    private int getPurchaseQuantity(int money) {
        return money / LOTTO_PRICE;
    }

    private List<Lotto> createLottos(int purchaseQuantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseQuantity; i++) {
            List<Integer> lottoNumbers = NumberGenerator.createUniqueRandomNumbers();
            lottos.add(new Lotto(lottoNumbers));
        }
        return lottos;
    }

    private void printLotto(List<Lotto> lottos) {
        LottoShopView.printLottoQuantity(lottos);
        LottoShopView.printLottos(lottos);
    }
}
