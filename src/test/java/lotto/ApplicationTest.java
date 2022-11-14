package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.lotto.domain.Lotto;
import lotto.domain.lotto.presentation.LottoController;
import lotto.global.util.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            assertThat(output().contains(ERROR_MESSAGE));
        });
    }

    @DisplayName("게임 시작 문구 출력")
    @Test
    void printGameStart() {
        assertThat(output().contains("구입금액을 입력해 주세요."));
    }

    @DisplayName("1000원을 투자하고 숫자 4개 일치시 수익률은 50000.00%이다.")
    @Test
    void isBenefit5000Percent() {
        // given
        LottoController lottoController = new LottoController();
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        Lotto prizeLotto = new Lotto(List.of(1, 2, 3, 4, 21, 22));
        int bonusNumber = 44;

        // when
        Double benefit = lottoController.compareNumbers(lottos, prizeLotto, bonusNumber);

        // then
        assertEquals(benefit, 50000.00);
    }

    @DisplayName("로또 숫자 입력시 오름차순 정렬이 되야한다.")
    @Test
    void test() {
        // given
        List<Integer> numbers = new ArrayList<>(List.of(6, 5, 4, 3, 2, 1));

        // when
        List<Integer> orderByAscNumbers = Util.orderByDescForList(numbers);

        // then
        assertEquals(orderByAscNumbers, List.of(1, 2, 3, 4, 5, 6));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}