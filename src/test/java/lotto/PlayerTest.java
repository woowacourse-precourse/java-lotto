package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class PlayerTest {

    @DisplayName("올바르지 않은 금액 입력 - 문자 포함")
    @Test
    void test1() {
        String input = "l35000";
        Throwable t = catchThrowable(() -> inputCostForLotto(input));

        assertThat(t)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_INPUT_ERROR_MESSAGE);
    }

    @DisplayName("올바르지 않은 금액 입력 - 1000으로 안나눠짐")
    @Test
    void test2() {
        String input = "3500";
        Throwable t = catchThrowable(() -> inputCostForLotto(input));

        assertThat(t)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_COST_ERROR_MESSAGE);
    }

    @DisplayName("올바른 금액 입력")
    @Test
    void test3() {
        String input = "35000";
        int result = inputCostForLotto(input);
        assertThat(result).isEqualTo(35);
    }

    @DisplayName("실행 결과 정상 출력 테스트 - 로또 구매, 생성, 출력")
    @Test
    void test4() {
        String input = "9000";
        int lottoCount = inputCostForLotto(input);
        List<Lotto> lottoSet = buyLotto(lottoCount);
        printLottoNumber(lottoSet);
    }

    private int inputCostForLotto(String input) {
        System.out.println(PURCHASE_MESSAGE);
        System.out.println(input);

        Validator.validateForIllegalInput(input);

        int cost = Integer.parseInt(input);
        Validator.validateForDividedBy1000(cost);

        return cost / LOTTO_PRICE;
    }

    private List<Lotto> buyLotto(int lottoCount) {
        List<Lotto> lottoSet = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoSet.add(new Lotto(Lotto.createLottoNumber()));
        }
        System.out.println();
        System.out.println(lottoCount + PURCHASE_CONFIRM_MESSAGE);
        return lottoSet;
    }

    private void printLottoNumber(List<Lotto> lottoSet) {
        for (int i = 0; i < lottoSet.size(); i++) {
            System.out.println(lottoSet.get(i));
        }
        System.out.println();
    }
}
