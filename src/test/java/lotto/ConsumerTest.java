package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ConsumerTest {

    @Test
    void buyLotto() {
    }

    @Test
    void calcStat() {
        Lotto winLotto = new Lotto(List.of(1,2,3,4,5,6));
        Consumer tester = new Consumer(winLotto);
        assertThat(tester.calcStat(new Lotto(List.of(1,2,3,4,5,6)),7))
                .isEqualTo(List.of(0,0,0,1,0,0));
    }
}