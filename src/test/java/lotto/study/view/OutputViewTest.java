package lotto.study.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest extends NsTest {

    @DisplayName("로또 출력")
    @Test
    void 로또_출력() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "[8, 21, 23, 41, 42, 43]"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43)
        );
    }

    @DisplayName("통계 출력")
    @Test
    void 통계_출력1() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "당첨 통계",
                            "---",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 40,631,100%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 10),
                List.of(1, 2, 3, 4, 10, 11),
                List.of(1, 2, 3, 10, 11, 12)
                );
    }

    @DisplayName("통계 출력 열개 이상 당첨")
    @Test
    void 통계_출력() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("11000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "당첨 통계",
                            "---",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 11개",
                            "총 수익률은 200,000,000%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @DisplayName("수익률 0%")
    @Test
    void 수익률_출력1() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "총 수익률은 0%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 11, 14, 22, 45)
        );
    }

    @DisplayName("수익률 반올림")
    @Test
    void 수익률_출력2() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("7000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "총 수익률은 714.3%입니다."
                    );
                },
                List.of(7, 8, 9, 10, 11, 12),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(1, 2, 3, 4, 9, 10),
                List.of(1, 3, 10, 14, 22, 45)
        );
    }

    @DisplayName("수익률 천단위 콤마")
    @Test
    void 수익률_출력3() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("7000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "총 수익률은 28,571,428.6%입니다."
                    );
                },
                List.of(7, 8, 9, 10, 11, 12),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 3, 10, 14, 22, 45)
        );
    }

    @DisplayName("에러 출력")
    @Test
    void 에러_로그(){
        //given
        Exception e = new IllegalArgumentException("테스트 익셉션");

        //when
        OutputView.showError(e.getMessage());

        //then
        assertThat(output()).contains("[ERROR]");

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}