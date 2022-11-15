package lotto;

import static lotto.core.LottoRank._1st;
import static lotto.core.LottoRank._2nd;
import static lotto.core.LottoRank._3rd;
import static lotto.core.LottoRank._4th;
import static lotto.core.LottoRank._5th;
import static lotto.core.LottoRank.DRAW;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.core.Lotto;
import lotto.core.LottoRank;
import lotto.core.LottoWinningDiscriminator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class LottoWinningDiscriminatorTest {
    private static final List<Integer> WINNING_NUMBER = List.of(1, 2, 3, 4, 5, 6);
    private static final Integer BONUS_NUMBER = 7;

    private final LottoWinningDiscriminator discriminator =
            new LottoWinningDiscriminator(WINNING_NUMBER, BONUS_NUMBER);

    @DisplayName("구입한 로또를 입력하면 1등이 나온다.")
    @Test
    void _1stDiscriminateTest() {
        List<Lotto> purchasedLotto = new ArrayList<>();
        purchasedLotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        List<LottoRank> discriminate = discriminator.discriminate(purchasedLotto);

        assertThat(discriminate).containsExactly(_1st);
    }

    @DisplayName("구입한 로또를 입력하면 2등이 나온다.")
    @Test
    void _2ndDiscriminateTest() {
        List<Lotto> purchasedLotto = new ArrayList<>();
        purchasedLotto.add(new Lotto(List.of(2, 3, 4, 5, 6, 7)));

        List<LottoRank> discriminate = discriminator.discriminate(purchasedLotto);

        assertThat(discriminate).containsExactly(_2nd);
    }

    @DisplayName("구입한 로또를 입력하면 3등이 나온다.")
    @Test
    void _3rdDiscriminateTest() {
        List<Lotto> purchasedLotto = new ArrayList<>();
        purchasedLotto.add(new Lotto(List.of(2, 3, 4, 5, 6, 8)));

        List<LottoRank> discriminate = discriminator.discriminate(purchasedLotto);

        assertThat(discriminate).containsExactly(_3rd);
    }

    @DisplayName("구입한 로또를 입력하면 4등이 나온다.")
    @Test
    void _4thDiscriminateTest() {
        List<Lotto> purchasedLotto = new ArrayList<>();
        purchasedLotto.add(new Lotto(List.of(3, 4, 5, 6, 7, 8)));

        List<LottoRank> discriminate = discriminator.discriminate(purchasedLotto);

        assertThat(discriminate).containsExactly(_4th);
    }

    @DisplayName("구입한 로또를 입력하면 5등이 나온다.")
    @Test
    void _5thDiscriminateTest() {
        List<Lotto> purchasedLotto = new ArrayList<>();
        purchasedLotto.add(new Lotto(List.of(4, 5, 6, 7, 8, 9)));

        List<LottoRank> discriminate = discriminator.discriminate(purchasedLotto);

        assertThat(discriminate).containsExactly(_5th);
    }

    @DisplayName("구입한 로또를 입력하면 꽝이 나온다.")
    @Test
    void drawDiscriminateTest() {
        List<Lotto> purchasedLotto = new ArrayList<>();
        purchasedLotto.add(new Lotto(List.of(10, 11, 12, 13, 14, 15)));

        List<LottoRank> discriminate = discriminator.discriminate(purchasedLotto);

        assertThat(discriminate).containsExactly(DRAW);
    }
}