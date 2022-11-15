package lotto;

import lotto.model.Lotto;
import lotto.model.Lottos;

import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    LottoService lottoService = new LottoService();

    @Test
    void 구입_금액으로_1000원_입력시_1개_구입_가능() {
        assertThat(lottoService.calBuyingCount(1000))
                .isEqualTo(1);
    }

    @Test
    void 구입_금액으로_2000원_입력시_2개_구입_가능() {
        assertThat(lottoService.calBuyingCount(2000))
                .isEqualTo(2);
    }

    @Test
    void 로또_생성시_정렬된_랜덤_넘버6개를_갖는_로또_객체_반환() {
        Lotto newLotto = lottoService.getNewLotto();
        assertThat(newLotto).isInstanceOf(Lotto.class);
        List<Integer> numbers = newLotto.getNumbers();
        assertThat(numbers).isSorted()
                .hasSize(6);
    }

    @Test
    void 원하는_개수만큼_로또_생성() {
        Lottos lottos = lottoService.getLottos(5);
        List<Lotto> lottoList = lottos.getLottos();
        assertThat(lottos).isInstanceOf(Lottos.class);
        assertThat(lottoList).hasSize(5);
    }

    @Test
    void 매칭되는_넘버의_개수_찾기_테스트() {
        Lotto lottoA = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lottoB = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lottoService.getCountOfNumbersMatchWinningLotto(lottoA, lottoB))
                .isEqualTo(6);

        Lotto lottoC = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lottoD = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        assertThat(lottoService.getCountOfNumbersMatchWinningLotto(lottoC, lottoD))
                .isEqualTo(0);

        Lotto lottoE = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lottoF = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        assertThat(lottoService.getCountOfNumbersMatchWinningLotto(lottoE, lottoF))
                .isEqualTo(3);
    }

    @Test
    void 로또_당첨_결과_테스트() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6");
        winningLotto.setBonusNumber("7");
        List<Lotto> list = new ArrayList<>();
        list.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        list.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        list.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        list.add(new Lotto(List.of(1, 2, 3, 4, 7, 8)));
        list.add(new Lotto(List.of(1, 2, 3, 7, 8, 9)));
        list.add(new Lotto(List.of(1, 2, 7, 8, 9, 10)));

        Lottos lottos = new Lottos(list);

        assertThat(lottoService.getWinningResult(winningLotto, lottos))
                .containsExactly(1, 1, 1, 1, 1);

    }

    @Test
    void 수익률_퍼센트_계산_테스트1() {
        assertThat(lottoService.calRatePercent(1000, 5000))
                .isEqualTo(500);
    }

    @Test
    void 수익률_퍼센트_계산_테스트2() {
        assertThat(lottoService.calRatePercent(100000, 5000))
                .isEqualTo(5);
    }

    @DisplayName("로또 상금 테스트 1등0명_2등0명_3등0명_4등0명_5등0명 -> 0원")
    @Test
    void 로또_상금_계산_테스트0() {
        assertThat(lottoService.calPrizeMoney(List.of(0, 0, 0, 0, 0)))
                .isEqualTo(0);
    }

    @DisplayName("로또 상금 테스트 1등0명_2등0명_3등0명_4등0명_5등1명 -> 5000원")
    @Test
    void 로또_상금_계산_테스트1() {
        assertThat(lottoService.calPrizeMoney(List.of(1, 0, 0, 0, 0)))
                .isEqualTo(5000);
    }

    @DisplayName("로또 상금 테스트 1등0명_2등0명_3등0명_4등1명_5등0명 -> 50000원")
    @Test
    void 로또_상금_계산_테스트2() {
        assertThat(lottoService.calPrizeMoney(List.of(0, 1, 0, 0, 0)))
                .isEqualTo(50000);
    }

    @DisplayName("로또 상금 테스트 1등0명_2등0명_3등1명_4등0명_5등0명 -> 1500000원")
    @Test
    void 로또_상금_계산_테스트3() {
        assertThat(lottoService.calPrizeMoney(List.of(0, 0, 1, 0, 0)))
                .isEqualTo(1500000);
    }

    @DisplayName("로또 상금 테스트 1등0명_2등1명_3등0명_4등0명_5등0명 -> 30000000원")
    @Test
    void 로또_상금_계산_테스트4() {
        assertThat(lottoService.calPrizeMoney(List.of(0, 0, 0, 1, 0)))
                .isEqualTo(30000000);
    }

    @DisplayName("로또 상금 테스트 1등1명_2등0명_3등0명_4등0명_5등0명 -> 2000000000원")
    @Test
    void 로또_상금_계산_테스트5() {
        assertThat(lottoService.calPrizeMoney(List.of(0, 0, 0, 0, 1)))
                .isEqualTo(2000000000);
    }

    @DisplayName("로또 상금 테스트 1등1명_2등0명_3등0명_4등0명_5등0명 -> 2000000000 + 30000000 + 1500000 + 50000 + 5000원")
    @Test
    void 로또_상금_계산_테스트6() {
        assertThat(lottoService.calPrizeMoney(List.of(1, 1, 1, 1, 1)))
                .isEqualTo(2000000000 + 30000000 + 1500000 + 50000 + 5000);
    }
}

