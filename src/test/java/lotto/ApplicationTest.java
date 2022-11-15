package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.Application.*;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

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
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    public void 로또_구매_하기(){
        String test = "2000";
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        InputStream inputStream = new ByteArrayInputStream(test.getBytes());
        System.setIn(inputStream);

        int value = lottoPurchase();

        assertEquals(2, value);
    }

    @Test
    public void 로또_번호_입력기(){
        String test = "1,2,3,4,5,6";
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        InputStream inputStream = new ByteArrayInputStream(test.getBytes());
        System.setIn(inputStream);
        List<Integer> lottoList = enterScore();
        List<Integer> targer = Arrays.asList(1,2,3,4,5,6);
        assertEquals(lottoList, targer);
    }

    @Test
    public void 보너스_번호_입력(){
        String bousNumber = "7";
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        InputStream inputStream = new ByteArrayInputStream(bousNumber.getBytes());
        System.setIn(inputStream);

        List<Integer> numberList = Arrays.asList(1,2,3,4,5,6);
        int result = bonusNumber(numberList);

        assertEquals(7, result);
    }

    @Test
    public void 로또_번호_비교(){
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        List<Integer> lottoNumbers = Arrays.asList(1,2,3,4,5,6);
        int bonusNumber = 7;
        List<Integer> value = checkValue(lotto.getNumbers(),lottoNumbers, bonusNumber);
        assertEquals(6, value.size());
    }

    @Test
    public void 금액_반환(){
        List<Integer> sameNumber = Arrays.asList(1,2,3);
        int bonusNumber = 4;
        int test = price(sameNumber, bonusNumber);

        assertEquals(test, 5000);
    }

    @Test
    public void 당첨금_확인(){
        List<Integer> point = Arrays.asList(5000);
        List<String> test = endScore(point);
        assertEquals(test.get(0), "3개 일치 (5,000원) - 1개");
    }

    @Test
    public void 수익률_확인(){
        List<Integer> pointList = Arrays.asList(5000);
        int lotto = 5;
        String result = revenue(pointList, lotto);
        assertEquals(result, "총 수익률은 100.0%입니다.");
    }
}
