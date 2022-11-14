package lotto.domain;

import lotto.domain.enums.Number;
import lotto.service.ManagerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ManagerTest {

    User user;
    Manager manager;
    ManagerService managerService;

    @BeforeEach
    void beforeEach() {
        user = new User();
        manager = new Manager();
        managerService = new ManagerService();
    }

    @Test
    void 구입금액에_따른_로또_반환_테스트() {
        user.setMoney(8000.0);
        int expect = 8;
        managerService.changeLottos(user);

        assertThat(user.getLottoCount()).isEqualTo(expect);
    }

    @Test
    void 구입금액에_따른_로또_반환_테스트_0() {
        user.setMoney(0.0);
        int expect = 0;
        managerService.changeLottos(user);

        assertThat(user.getLottoCount()).isEqualTo(expect);
    }

    @Test
    void getCorrectCountTest() {
        Lotto userLotto = new Lotto(new ArrayList<>(List.of(6,5,4,3,2,1)));
        manager.setWinningNumbers("1,2,3,4,5,7");

        int expect = 5;
        int result = manager.countCorrect(userLotto);

        assertThat(result).isEqualTo(expect);
    }

    @Test
    void judgeRankTest() {
        assertAll(
            () -> assertThat(managerService.judgeRank(0, true)).isEqualTo(Number.ZERO),
            () -> assertThat(managerService.judgeRank(1, true)).isEqualTo(Number.ZERO),
            () -> assertThat(managerService.judgeRank(2, true)).isEqualTo(Number.ZERO),
            () -> assertThat(managerService.judgeRank(3, true)).isEqualTo(Number.FIVE),
            () -> assertThat(managerService.judgeRank(4, true)).isEqualTo(Number.FOUR),
            () -> assertThat(managerService.judgeRank(5, false)).isEqualTo(Number.THREE),
            () -> assertThat(managerService.judgeRank(5, true)).isEqualTo(Number.TWO),
            () -> assertThat(managerService.judgeRank(6, true)).isEqualTo(Number.ONE)
        );
    }
}