package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Controller.LottoController;
import lotto.Model.Buyer;
import lotto.Model.Lotto;
import lotto.Model.LuckyLotto;
import org.junit.jupiter.api.Test;

import java.io.*;
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
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 구입금액입력_테스트() {
        // 19000원을 가지고 로또 19장을 살 수 있음
        String input = "19000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        LottoController lc = new LottoController();
        assertSimpleTest(() -> {
            lc.getLotto();
            assertThat(output()).contains("구입금액을 입력해 주세요.", "19개를 구매했습니다.");
        });
    }

    @Test
    void 구입금액입력_예외테스트_1000단위아님() {
        // 8400 -> 1000 단위로 나누어지지 않음
        String input = "8400";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        LottoController lc = new LottoController();
        assertThatThrownBy(() -> {
            lc.getLotto();
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입 금액은 1000원 단위로 입력해야 합니다.");
    }

    @Test
    void 구입금액입력_예외테스트_문자입력() {
        // 8400 -> 1000 단위로 나누어지지 않음
        String input = "abc";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        LottoController lc = new LottoController();
        assertThatThrownBy(() -> {
            lc.getLotto();
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자 이외의 값을 입력할 수 없습니다.");
    }

    @Test
    void 로또번호선택_기능_테스트() {
        String input = "3000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        LottoController lc = new LottoController();
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    lc.getLotto();
                    lc.pickLottoNumbers();
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
        String input = "3000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        LottoController lc = new LottoController();
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    lc.getLotto();
                    lc.pickLottoNumbers();
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
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        LottoController lc = new LottoController();
        assertSimpleTest(() -> {
            Lotto lotto = lc.pickLuckyNumber();
            assertThat(lotto.getLottoNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        });
    }

    @Test
    void 당첨번호입력_예외테스트_문자입력() {
        String input = "1,2,3,4,5,ㅁ";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        LottoController lc = new LottoController();
        assertThatThrownBy(() -> {
            Lotto lotto = lc.pickLuckyNumber();
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자 이외의 값을 입력할 수 없습니다.");
    }

    @Test
    void 당첨번호입력_예외테스트_범위외입력() {
        String input = "1,2,3,4,5,99";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        LottoController lc = new LottoController();
        assertThatThrownBy(() -> {
            Lotto lotto = lc.pickLuckyNumber();
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1~45 범위를 벗어나는 값을 입력할 수 없습니다.");
    }

    @Test
    void 당첨번호입력_예외테스트_중복입력() {
        String input = "1,2,3,4,5,5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        LottoController lc = new LottoController();
        assertThatThrownBy(() -> {
            Lotto lotto = lc.pickLuckyNumber();
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복된 숫자를 입력할 수 없습니다.");
    }

    @Test
    void 당첨번호입력_예외테스트_6개미만입력() {
        String input = "1,2,3,4,5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        LottoController lc = new LottoController();
        assertThatThrownBy(() -> {
            Lotto lotto = lc.pickLuckyNumber();
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호를 제외한 로또 번호는 6개를 입력해야 합니다.");
    }

    @Test
    void 보너스번호입력_기능테스트() {
        String input = "7";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        LottoController lc = new LottoController();
        assertSimpleTest(() -> {
            int bonusNumber = lc.pickBonusNumber();
            assertThat(bonusNumber).isEqualTo(Integer.parseInt(input));
        });
    }

    @Test
    void 보너스번호입력_예외테스트_범위외입력() {
        String input = "1,2,3,4,5,6\n46";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        LottoController lc = new LottoController();
        assertThatThrownBy(() -> {
            lc.createLuckyLotto();
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1~45 범위를 벗어나는 값을 입력할 수 없습니다.");
    }

    @Test
    void 보너스번호입력_예외테스트_문자입력() {
        String input = "1,2,3,4,5,6\na";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        LottoController lc = new LottoController();
        assertThatThrownBy(() -> {
            lc.createLuckyLotto();
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자 이외의 값을 입력할 수 없습니다.");
    }

    @Test
    void 보너스번호입력_예외테스트_중복입력() {
        String input = "1,2,3,4,5,6\n6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        LottoController lc = new LottoController();
        assertThatThrownBy(() -> {
            lc.createLuckyLotto();
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 기존 당첨 번호와 중복된 숫자를 입력할 수 없습니다.");
    }

    @Test
    void 당첨결과출력_기능테스트() {
        String input = "3000\n8,21,23,41,1,2\n5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        LottoController lc = new LottoController();
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    lc.getLotto();
                    lc.pickLottoNumbers();
                    lc.createLuckyLotto();
                    lc.getLottoResult();
                    assertThat(output()).contains(
                            "당첨 통계",
                            "---",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(8, 1, 2, 44, 42, 43),
                List.of(33, 34, 35, 36, 37, 38)
        );
    }

    @Test
    void 당첨결과출력_기능테스트_2등() {
        String input = "3000\n8,21,23,41,42,2\n43";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        LottoController lc = new LottoController();
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    lc.getLotto();
                    lc.pickLottoNumbers();
                    lc.createLuckyLotto();
                    lc.getLottoResult();
                    assertThat(output()).contains(
                            "당첨 통계",
                            "---",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(8, 1, 2, 44, 42, 43),
                List.of(33, 34, 35, 36, 37, 38)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
