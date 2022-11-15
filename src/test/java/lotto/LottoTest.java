package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest extends NsTest{
    Lotto lotto;
    @BeforeEach
    void beforeEach() {
        lotto=new Lotto(List.of(1,2,3,4,5,6,7));
    }
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("200");
            assertThat(output()).contains("ERROR");
        });
    }
    // 아래에 추가 테스트 작성 가능
    @DisplayName("한장 샀을경우")
    @Test
    void buyOne() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,6,9", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 8]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 5000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 8, 5)
        );
    }
    @DisplayName("두장 샀을경우")
    @Test
    void buyTwo() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("2000", "1,2,3,4,5,8", "7");
                    assertThat(output()).contains(
                            "2개를 구매했습니다.",
                            "[1, 2, 3, 4, 7, 8]",
                            "[3, 5, 7, 8, 9, 11]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 1500250.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 8, 7),
                List.of(3, 5, 7, 8, 9, 11)
        );
    }
    @DisplayName("Lotto 기능 테스트 isUnique")
    @Test
    void isUniqueTest(){
        assertThatThrownBy(() -> lotto.isUnique(List.of(1,2,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
