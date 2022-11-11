package lotto.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ConfirmationWinningServiceTest extends NsTest {
    ConfirmationWinningService confirmationWinningService;

    public ConfirmationWinningServiceTest() {
        this.confirmationWinningService = new ConfirmationWinningService();
    }

    @Test
    @DisplayName("당첨번호와 구입한 로또를 주면 당첨 내역을 출력해야 한다.")
    void giveLottosBePrint() {
        // given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(1,2,3,4,5,7)));
        lottos.add(new Lotto(List.of(1,2,3,4,5,8)));
        lottos.add(new Lotto(List.of(1,2,3,4,8,9)));
        lottos.add(new Lotto(List.of(1,2,3,8,9,10)));
        lottos.add(new Lotto(List.of(8,9,10,11,12,13)));
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");

        // when
        confirmationWinningService.confirm(lottos, winningLotto);

        // then
        assertThat(output()).contains(
                "당첨 통계",
                "---",
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 1개",
                "5개 일치 (1,500,000원) - 1개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                "6개 일치 (2,000,000,000원) - 1개",
                "총 수익률은 6771850.0%입니다."
        );
    }

    @Override
    protected void runMain() {

    }
}