package lotto;

import java.util.List;

public class WinningNumbers {
    private final List<LottoItem> lottoItems;
    private final LottoItem bonusNumber;

    public WinningNumbers(List<LottoItem> lottoItems, LottoItem lottoItem) {
        this.lottoItems = lottoItems;
        this.bonusNumber = lottoItem;
    }

    private void validate(List<LottoItem> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private void validateBonusNumberDuplicate(
            List<LottoItem> lottoItems,
            LottoItem bonusNumber
    ) {
        if (lottoItems.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
