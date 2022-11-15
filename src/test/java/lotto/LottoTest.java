package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Dto.Lotto;
import lotto.Dto.Money;
import lotto.Services.CalculatedService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest extends NsTest {
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

    // 아래에 추가 테스트 작성 가능
    @DisplayName("돈이 숫자가 아니면 예외가 발생한다")
    @Test
    void createLottoBuyMoney() {
        assertThatThrownBy(() -> new Money("하이"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("돈이 1000원 단위로 들어오는지 확인한다.")
    @Test
    void createLottoSize() {
        assertThatThrownBy(() -> new CalculatedService().lottoSize(new Money("4050")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("형식에 맞게 입력이 들어오는지 확인한다.")
    @Test
    void creatWinningNumbers() {
        assertThatThrownBy(() -> new Lotto("1, 2, 3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨된 로또의 갯수가 반환하는 함수를 테스트")
    @Test
    void checkWinningNumberResult() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[1, 3, 5, 14, 22, 45]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[1, 2, 3, 4, 5, 7]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 2, 3, 4, 5, 7]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개",
                            "6개 일치 (2,000,000,000원) - 0개"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(1, 3, 5, 14, 22, 45),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 2, 3, 4, 5, 7)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
