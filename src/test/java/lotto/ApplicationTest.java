package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void 구입금액입력_테스트() {
        // 19000원을 가지고 로또 19장을 살 수 있음
        String input = "19000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int count = Application.buyLotto();
        assertSimpleTest(() -> {
            assertThat(count).isEqualTo(19);
        });
    }

    @Test
    void 구입금액입력_예외테스트_1000단위아님() {
        // 8400 -> 1000 단위로 나누어지지 않음
        String input = "8400";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> {
            int count = Application.buyLotto();
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입 금액은 1000원 단위로 입력해야 합니다.");
    }

    @Test
    void 구입금액입력_예외테스트_문자입력() {
        // 8400 -> 1000 단위로 나누어지지 않음
        String input = "abc";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> {
            int count = Application.buyLotto();
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자 이외의 값을 입력할 수 없습니다.");
    }

    @Test
    void 로또번호선택_기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    List<Lotto> lottos = Application.pickLottoNumber(3);
                    assertThat(output()).contains(
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44)
        );
    }

    @Test
    void 로또번호선택_중복_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    List<Lotto> lottos = Application.pickLottoNumber(3);
                    assertThat(output()).contains(
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(8, 21, 23, 41, 42, 43),
                List.of(8, 21, 23, 41, 42, 43),
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44)
        );
    }

    @Test
    void 당첨번호입력_기능테스트() {
        String input = "1,2,3,4,5,6";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertSimpleTest(() -> {
            Lotto lotto = Application.pickLuckyNumber();
            assertThat(lotto.getLottoNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        });
    }

    @Test
    void 당첨번호입력_예외테스트_문자입력() {
        String input = "1,2,3,4,5,ㅁ";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> {
            Lotto lotto = Application.pickLuckyNumber();
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자 이외의 값을 입력할 수 없습니다.");
    }

    @Test
    void 당첨번호입력_예외테스트_범위외입력() {
        String input = "1,2,3,4,5,99";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> {
            Lotto lotto = Application.pickLuckyNumber();
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1~45 범위를 벗어나는 값을 입력할 수 없습니다.");
    }

    @Test
    void 당첨번호입력_예외테스트_중복입력() {
        String input = "1,2,3,4,5,5";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> {
            Lotto lotto = Application.pickLuckyNumber();
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복된 숫자를 입력할 수 없습니다.");
    }

    @Test
    void 당첨번호입력_예외테스트_6개미만입력() {
        String input = "1,2,3,4,5";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> {
            Lotto lotto = Application.pickLuckyNumber();
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호를 제외한 로또 번호는 6개를 입력해야 합니다.");
    }

    @Test
    void 보너스번호입력_기능테스트() {
        String input = "7";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertSimpleTest(() -> {
            int bonusNumber = Application.pickBonusNumber(new Lotto(List.of(1,2,3,4,5,6)));
            assertThat(bonusNumber).isEqualTo(Integer.parseInt(input));
        });
    }

    @Test
    void 보너스번호입력_예외테스트_범위외입력() {
        String input = "46";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> {
            int bonusNumber = Application.pickBonusNumber(new Lotto(List.of(1,2,3,4,5,6)));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1~45 범위를 벗어나는 값을 입력할 수 없습니다.");
    }

    @Test
    void 보너스번호입력_예외테스트_문자입력() {
        String input = "a";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> {
            int bonusNumber = Application.pickBonusNumber(new Lotto(List.of(1,2,3,4,5,6)));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자 이외의 값을 입력할 수 없습니다.");
    }

    @Test
    void 보너스번호입력_예외테스트_중복입력() {
        String input = "6";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> {
            int bonusNumber = Application.pickBonusNumber(new Lotto(List.of(1,2,3,4,5,6)));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 기존 당첨 번호와 중복된 숫자를 입력할 수 없습니다.");
    }

    @Test
    void 당첨결과출력_기능테스트() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1,2,3,4,5,6)),
                new Lotto(List.of(1,2,3,4,5,7)),
                new Lotto(List.of(1,2,3,4,5,8)),
                new Lotto(List.of(1,2,3,4,6,7))
        );
        Lotto luckyLotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 7;
        HashMap<Application.Prize, Integer> answer = new HashMap<>();
        answer.put(Application.Prize.FIRST, 1);
        answer.put(Application.Prize.SECOND, 2);
        answer.put(Application.Prize.THIRD, 1);
        assertSimpleTest(() -> {
            HashMap<Application.Prize, Integer> prizes = Application.getLottoResult(lottos, luckyLotto, bonusNumber);
            assertThat(prizes).isEqualTo(answer);
        });
    }

    @Test
    void 수익률출력_기능테스트1() {
        int purchase = 8000;
        int profit = 2061500000;
        assertSimpleTest(() -> {
            String profitRate = Application.getProfitRate(purchase, profit).toString();
            assertThat(profitRate).isEqualTo("25768750");
        });
    }

    @Test
    void 수익률출력_기능테스트2() {
        int purchase = 8000;
        int profit = 5000;
        assertSimpleTest(() -> {
            String profitRate = Application.getProfitRate(purchase, profit).toString();
            assertThat(profitRate).isEqualTo("62.5");
        });
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
