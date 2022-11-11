package lotto.domain.model;

import static lotto.utils.Advice.PurchaseValidator.MINIMUM_ORDER;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.utils.LottoGenerator;

public class UserLotto {

    private final List<Lotto> userLotto;

    public UserLotto(List<Lotto> userLotto) {
        this.userLotto = userLotto;
    }

    public UserLotto(Pay pay) {
        this.userLotto = IntStream.rangeClosed(1, (int) (pay.getPay() /MINIMUM_ORDER))
                .mapToObj(count -> new Lotto(LottoGenerator.makeLotto())).collect(Collectors.toList());
    }

    public int getUserLottoSize() {
        return userLotto.size();
    }

    public List<String> getUserLotto() {
        return userLotto.stream()
                .map(Lotto::toString)
                .collect(Collectors.toList());
    }

    public List<LottoRank> compareLottoNumber(LottoNumber lottoNumber) {
        List<LottoRank> rankCollection = userLotto.stream()
                .map(lotto -> lotto.compareLottoNumber(lottoNumber))
                .filter(lottoRank -> lottoRank != LottoRank.NONE)
                .collect(Collectors.toList());
        validateLottoRankSize(rankCollection);
        return rankCollection;
    }
    private void validateLottoRankSize(List<LottoRank> rankCollection) {
        if (this.userLotto.size() < rankCollection.size()) {
            throw new IllegalArgumentException();
        }
    }
}
