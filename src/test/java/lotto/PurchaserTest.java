package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaserTest extends NsTest{
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static Purchaser purchaser;

    @Test
    void 단위테스트_구매_금액_예외_테스트() {
//        입력금액이_숫자가_아닌_예외_테스트
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
//        입력금액이_숫자가_아닌_예외_테스트
        assertSimpleTest(() -> {
            runException("Not Numeric");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
//        입력금액이_천단위가_아닌_예외_테스트
        assertSimpleTest(() -> {
            runException("1234");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 단위테스트_구입한_개수만큼의_로또번호_출력() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                run("8000");
                assertThat(output()).contains(
                    "8개를 구매했습니다.",
                    "[8, 21, 23, 41, 42, 43]",
                    "[3, 5, 11, 16, 32, 38]",
                    "[7, 11, 16, 35, 36, 44]",
                    "[1, 8, 11, 31, 41, 42]",
                    "[13, 14, 16, 38, 42, 45]",
                    "[7, 11, 30, 40, 42, 43]",
                    "[2, 13, 22, 32, 38, 45]",
                    "[1, 3, 5, 14, 22, 45]"
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

    @Override
    public void runMain() {
        try {
            Purchaser purchaser = new Purchaser();
            purchaser.setPurchaseAmount();
            purchaser.calculateLottoNum();
            System.out.println(purchaser.getLottoNum() + "개를 구매했습니다.");

            purchaser.pickRandomNumbers();
            for (List n : purchaser.numbers){
                System.out.println(n);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
