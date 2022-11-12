package lotto;

import java.util.ArrayList;
import java.util.List;

public class LuckyAndBonus {
    public List<Integer> luckySix;
    public int bonusNumber;

    public LuckyAndBonus(List<Integer> luckySix, int bonusNumber) {
        List<Integer> tempNumbers = new ArrayList<>(luckySix);
        tempNumbers.add(bonusNumber);
        if (tempNumbers.size() != tempNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException(LottoMessage.LUCKY_DUPLICATE_ERROR_MESSAGE.getMessage());
        }
        this.luckySix = luckySix;
        this.bonusNumber = bonusNumber;
    }
}
