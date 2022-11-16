package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.app.Application;
import lotto.domain.jackpot.Jackpot;
import lotto.domain.lotto.Lotto;
import lotto.validation.Validation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AllTaskTest extends NsTest {
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
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
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

    public static Jackpot jp;

    @BeforeAll
    static void import_initialize() {
        jp = new Jackpot();
    }

    @Test
    void 유저_입력_금액_예외_테스트_1() {
        assertSimpleTest(() -> {
            runException("가나다라마바사");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @Test
    void 유저_입력_금액_예외_테스트_2() {
        assertSimpleTest(() -> {
            runException("123456");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @ParameterizedTest
    //given
    @ValueSource(strings = {"1", "123456", "a,b,c,d,e,f", "가,나,다,라,마,바", "1,2,3,4,5"})
    void validation_user_input_jackpot_number_유저의_당첨번호_입력값이_유효하지_않을경우_예외발생(String source) {
        //when
        assertThatThrownBy(() -> jp.jackpot_number_output_and_validate(source))
                .isInstanceOf(IllegalArgumentException.class)
                //then
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 하며 6자리를 입력해야합니다.");
    }

    @ParameterizedTest
    //given
    @ValueSource(strings = {"111", "abc", "가나다"})
    void validation_user_input_bonus_number_유저의_보너스번호_입력값이_유효하지_않을경우_예외발생(String source) {
        //when
        assertThatThrownBy(() -> jp.bonus_number_output_and_validate(source))
                .isInstanceOf(IllegalArgumentException.class)
                //then
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45사이의 숫자여야하며 당첨번호와는 겹쳐선 안됩니다.");
    }

    @ParameterizedTest
    //given
    @ValueSource(strings = {"1","2","3","4","5","6"})
    void validation_user_input_bonus_number_유저의_보너스번호_입력값이_당첨번호와_중복할경우_예외발생(String source) {
        List<String> jackpot_number_list= Arrays.asList("1","2","3","4","5","6");
        Validation.setJackpot_number_list_compare(jackpot_number_list);

        //when
        assertThatThrownBy(() -> jp.bonus_number_output_and_validate(source))
                .isInstanceOf(IllegalArgumentException.class)
                //then
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45사이의 숫자여야하며 당첨번호와는 겹쳐선 안됩니다.");

    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
