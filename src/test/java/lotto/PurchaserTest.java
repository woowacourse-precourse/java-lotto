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
