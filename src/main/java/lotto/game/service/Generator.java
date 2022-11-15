package lotto.game.service;

import lotto.user.Lotto;
import lotto.user.Purchase;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    public int generateQuantity(String purchaseAmount) {
        return Purchase
                .generate(purchaseAmount)
                .calculateQuantity();
    }

    public List<Lotto> generateLottos(int quantity) {
        List<Lotto> lottoNumbers = new ArrayList<>();

        while (lottoNumbers.size() < quantity) {
            lottoNumbers.add(Lotto.generate());
        }
        return lottoNumbers;
    }

    public Lotto generateDraw(String numbers) {
        return Lotto.generate(numbers);
    }

    public int generateBonus(String number) {
        return Integer.parseInt(number);
    }
}
