package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoBuyerTest {

    @Test
    void getCost() {
        ByteArrayInputStream in = new ByteArrayInputStream("12000".getBytes());
        System.setIn(in);

        LottoBuyer lottoBuyer = new LottoBuyer();
        int cost = lottoBuyer.getCost();

        assertThat(cost).isEqualTo(12000);
    }

    @Test
    void buyRandomLotto() {
        LottoBuyer lottoBuyer = new LottoBuyer(12000);

        Lotto lotto = lottoBuyer.buyRandomLotto();

        System.out.println(lotto.getNumbers());

        assertThat(lotto.getNumbers().size()).isEqualTo(6);

    }

    @Test
    void buyLotto() {
        LottoBuyer lottoBuyer = new LottoBuyer(2000, List.of(
                List.of(1, 3, 5, 7, 11, 9),
                List.of(2, 4, 6, 8, 12, 10)
        ));

        Lotto lotto = lottoBuyer.buyLotto(List.of(1, 3, 5, 7, 11, 9));

        assertThat(lotto.getNumbers().size()).isEqualTo(6);
        assertThat(lotto.getNumbers()).containsExactly(1, 3, 5, 7, 9, 11);

    }

    @Test
    void getLotteries() {
        LottoBuyer lottoBuyer = new LottoBuyer(5000);

        List<Lotto> lotteries = lottoBuyer.getLotteries();

        for (Lotto lotto : lotteries) {
            System.out.println(lotto.getNumbers());
        }

        assertThat(lotteries.size()).isEqualTo(5);
        assertThat(lotteries.get(0)).isInstanceOf(Lotto.class);
    }
}