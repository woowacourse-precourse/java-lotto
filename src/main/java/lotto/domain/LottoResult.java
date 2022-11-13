package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private int THREE_MATCHES = 0;
    private int FOUR_MATCHES = 0;
    private int FIVE_MATCHES = 0;
    private int FIVE_AND_BONUS_MATCHES = 0;
    private int SIX_MATCHES = 0;

    public LottoResult(List<Lotto> purchaseLotto, Lotto lottoNumbers, int bonusNumber) {
        checkMatchCount(purchaseLotto, lottoNumbers, bonusNumber);
    }

    public List<Integer> getResult() {
        List<Integer> list = new ArrayList<>();
        list.add(THREE_MATCHES);
        list.add(FOUR_MATCHES);
        list.add(FIVE_MATCHES);
        list.add(FIVE_AND_BONUS_MATCHES);
        list.add(SIX_MATCHES);
        return list;
    }

    public void checkMatchCount(List<Lotto> purchaseLotto, Lotto lottoNumbers, int bonusNumber) {
        CompareLotto compareLotto = new CompareLotto();
        for (Lotto lotto : purchaseLotto) {
            int count = compareLotto.getMatchingLottoNumberCount(lotto, lottoNumbers);
            boolean bonusMatch = compareLotto.checkMatchingBonusNumber(lotto, bonusNumber);
            if (count == 3) {
                THREE_MATCHES++;
            }
            if (count == 4) {
                FOUR_MATCHES++;
            }
            if (count == 5 && !bonusMatch) {
                FIVE_MATCHES++;
            }
            if (count == 5 && bonusMatch) {
                FIVE_AND_BONUS_MATCHES++;
            }
            if (count == 6) {
                SIX_MATCHES++;
            }
        }
    }

}
