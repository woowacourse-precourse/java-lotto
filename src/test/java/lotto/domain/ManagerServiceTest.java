package lotto.domain;

import lotto.domain.enums.Number;
import lotto.service.ManagerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ManagerServiceTest {

    User user;
    Manager manager;
    ManagerService managerService;

    @BeforeEach
    void beforeEach() {
        user = new User();
        manager = new Manager();
        managerService = new ManagerService();
    }

    @DisplayName("8000.0 입력시 user.lottos.size() == 8")
    @Test
    void changeLottosTest() {
        user.setMoney(8000.0);
        int expect = 8;
        managerService.changeLottos(user);

        assertThat(user.getLottoCount()).isEqualTo(expect);
    }

    @DisplayName("0 입력 시 user.lottos.size() == 0")
    @Test
    void changeLottosTest_2() {
        user.setMoney(0.0);
        int expect = 0;
        managerService.changeLottos(user);

        assertThat(user.getLottoCount()).isEqualTo(expect);
    }

    @DisplayName("user의 Lotto와 정답 Lotto 비교하여 맞은 개수 반환 테스트")
    @Test
    void getCorrectCountTest() {
        Lotto userLotto = new Lotto(new ArrayList<>(List.of(6,5,4,3,2,1)));
        manager.setWinningNumbers("1,2,3,4,5,7");

        int expect = 5;
        int result = manager.countCorrect(userLotto);

        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("맞은 개수와 보너스 번호 맞았는지 여부에 따른 등수 반환 테스트")
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