package lotto;

import lotto.model.Amount;
import lotto.model.Lotto;
import lotto.model.UserLotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.model.Lotto.createLotto;

public class LottoService {
    private static final String BONUS_DUPLICATE = "보너스번호가 당첨번호와 중복됩니다.";

    public List<Lotto> create(Amount amount) {
        int count = amount.getLottoCount();
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lotto.add(createLotto());
        }
        return lotto;
    }

    public void validate(UserLotto userLotto) {
        if (userLotto.isDuplicate()) {
            throw new IllegalArgumentException(BONUS_DUPLICATE);
        }
    }
}

