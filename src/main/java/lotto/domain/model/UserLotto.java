package lotto.domain.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.utils.LottoGenerator;

public class UserLotto {

    private final List<Lotto> userLotto;

    public UserLotto(final List<Lotto> userLotto) {
        this.userLotto = userLotto;
    }

    public UserLotto(final Pay pay) {
        this.userLotto = IntStream.rangeClosed(1, pay.calculateQuantity())
                .mapToObj(count -> new Lotto(LottoGenerator.makeLotto())).collect(Collectors.toList());
    }

    public List<String> getUserLotto() {
        return userLotto.stream()
                .map(Lotto::toString)
                .collect(Collectors.toList());
    }

    public List<LottoRank> compareLottoNumber(final WinningLotto winningLotto) {
        List<LottoRank> rankCollection = userLotto.stream()
                .map(lotto -> lotto.compareLottoNumber(winningLotto))
                .filter(lottoRank -> lottoRank != LottoRank.NO_MATCH)
                .collect(Collectors.toList());
        validateLottoRankSize(rankCollection);
        return rankCollection;
    }

    private void validateLottoRankSize(final List<LottoRank> rankCollection) {
        if (this.userLotto.size() < rankCollection.size()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserLotto userLotto1 = (UserLotto) o;
        return Objects.equals(userLotto, userLotto1.userLotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userLotto);
    }
}
