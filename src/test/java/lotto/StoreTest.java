package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StoreTest {
    Store store;

    @BeforeEach
    void beforeEach() {
        store = new Store();
    }

    @Test
    void 정상발행_1000원() {
        List<Lotto> lottos = store.sellLotto(1000);
        boolean a = lottos != null;
        System.out.println(lottos.get(0));
        assertTrue(a);
    }

    @Test
    void 정상발행_3000원() {
        List<Lotto> lottos = store.sellLotto(3000);
        boolean a = lottos != null;
        System.out.println(lottos.get(0));
        System.out.println(lottos.get(1));
        System.out.println(lottos.get(2));
        assertTrue(a);
    }

    @Test
    void 예외발행_1001원() {
        try {
            List<Lotto> lottos = store.sellLotto(1001);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }
    }

    @Test
    void 당첨확인_1등_5등2개() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        store.setWinningLotto(winningLotto);
        store.setBonusNumber(bonusNumber);

        List<Lotto> lottos = new ArrayList<Lotto>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 11, 12, 13)));
        lottos.add(new Lotto(List.of(1, 2, 3, 11, 12, 13)));

        LottoResult lr = store.checkPrize(lottos);
        assertThat(lr.getTotalMoney()).isEqualTo(2000010000);
        mathcingResult(lr, 1, 0, 0, 0, 2);
    }

    @Test
    void 당첨확인_2등() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        store.setWinningLotto(winningLotto);
        store.setBonusNumber(bonusNumber);

        List<Lotto> lottos = new ArrayList<Lotto>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(List.of(14, 25, 23, 11, 12, 13)));

        LottoResult lr = store.checkPrize(lottos);
        assertThat(lr.getTotalMoney()).isEqualTo(30000000);
        mathcingResult(lr, 0, 1, 0, 0, 0);
    }

    @Test
    void 당첨확인_4등_2개ㅓ() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        store.setWinningLotto(winningLotto);
        store.setBonusNumber(bonusNumber);

        List<Lotto> lottos = new ArrayList<Lotto>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 27, 28)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 7, 28)));

        LottoResult lr = store.checkPrize(lottos);
        assertThat(lr.getTotalMoney()).isEqualTo(100000);
        mathcingResult(lr, 0, 0, 0, 2, 0);
    }

    void mathcingResult(LottoResult lr, int p1, int p2, int p3, int p4, int p5) {
        matching(lr.countPrize(Prize.PRIZE1), p1);
        matching(lr.countPrize(Prize.PRIZE2), p2);
        matching(lr.countPrize(Prize.PRIZE3), p3);
        matching(lr.countPrize(Prize.PRIZE4), p4);
        matching(lr.countPrize(Prize.PRIZE5), p5);
    }

    void matching(int a, int b) {
        assertThat(a).isEqualTo(b);
    }
}