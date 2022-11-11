package lotto.domain.model;

import static lotto.utils.Advice.PurchaseValidator.MINIMUM_ORDER;
import static lotto.utils.Advice.PurchaseValidator.checkConsistNumber;
import static lotto.utils.Advice.PurchaseValidator.checkReminder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.utils.LottoGenerator;

public class UserLotto {

    private final List<Lotto> userLotto;

    public UserLotto(List<Lotto> userLotto) {
        this.userLotto = userLotto;
    }

    public UserLotto(String pay) {
        validate(pay);
        this.userLotto = IntStream.rangeClosed(1, Integer.parseInt(pay) / MINIMUM_ORDER)
                .mapToObj(count -> new Lotto(LottoGenerator.makeLotto())).collect(Collectors.toList());
    }
    public List<Lotto> getUserLotto() {
        return userLotto;
    }

    private static void validate(String pay) {
        checkConsistNumber(pay);
        checkReminder(pay);
    }

    public List<LottoRank> compareLottoNumber(LottoNumber lottoNumber) {
        List<LottoRank> lottoRanks = userLotto.stream().map(lotto -> lotto.compareLottoNumber(lottoNumber))
                .filter(lottoRank -> lottoRank != LottoRank.NONE).collect(Collectors.toList());
        validateLottoRankSize(lottoRanks);
        return lottoRanks;
    }

    private void validateLottoRankSize(List<LottoRank> lottoRanks) {
        if (this.userLotto.size() < lottoRanks.size()) {
            throw new IllegalArgumentException();
        }
    }
}
