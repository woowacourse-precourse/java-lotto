package lotto.Model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.Generate;

public class User {

    private final List<Lotto> user;



    public User(final Price pay) {
        this.user = IntStream.rangeClosed(1, pay.calculateQuantity())
                .mapToObj(count -> new Lotto(Generate.MakeLotto())).collect(Collectors.toList());
    }

    public List<String> getUser() {
        return user.stream()
                .map(Lotto::toString)
                .collect(Collectors.toList());
    }

    public List<Rank> compareLottoNbr(final Winning winningLotto) {
        List<Rank> rankCollection = user.stream()
                .map(lotto -> lotto.CompareNbr(winningLotto))
                .filter(lottoRank -> lottoRank != Rank.Not_winning)
                .collect(Collectors.toList());
        validateRankSize(rankCollection);
        return rankCollection;
    }

    private void validateRankSize(final List<Rank> rankCollection) {
        if (this.user.size() < rankCollection.size()) {
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
        User userLotto1 = (User) o;
        return Objects.equals(user, userLotto1.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }
}