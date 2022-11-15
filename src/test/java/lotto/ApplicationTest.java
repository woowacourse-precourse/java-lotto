package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static lotto.Application.*;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void get_lotto_answer_검사(){
        InputStream stdin = System.in;
        System.setIn(new StringBufferInputStream("1,2,3,4,5,6"));
        Lotto lotto = get_lotto_answer();
        assertThat(lotto.return_lotto().size()).isEqualTo(6);
    }

    @Test
    void get_lotto_numbers_검사(){
        List<Lotto> test_lottos =get_lotto_numbers(8000);
        assertThat(test_lottos.size()).isEqualTo(8);
    }

    @Test
    void verify_lotto_검사(){
        List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
        Lotto input_lotto = new Lotto(numbers);
        Lotto answer_lotto = new Lotto(numbers);
        assertThat(verify_lotto(input_lotto, answer_lotto, 7)).isEqualTo(2000000000);
    }

    @Test
    void win_lotto_number_검사(){
        int[] win_lotto = {0,0,0,0,0};
        win_lotto = win_lotto_number(win_lotto, 50000);
        assertThat(win_lotto[1]).isEqualTo(1);
    }

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
