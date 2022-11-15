package lotto.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class InputViewTest {

    @Test
    void 구매금액에_숫자_아닌_문자_입력() {
        String input = "700a";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        try {
            InputView.readAmountOfLottoPrice();
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("[ERROR] 로또 구매 금액에는 숫자 외의 문자가 포함될 수 없습니다.", e.getMessage());
        }
    }

    @Test
    void 구매금액에_1000원으로_나눠떨어지지_않는_금액_입력() {
        String input = "7500";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        try {
            InputView.readAmountOfLottoPrice();
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("[ERROR] 로또는 1,000원 단위로만 구매할 수 있습니다.", e.getMessage());
        }
    }

    @Test
    void 구매금액에_0원_이하의_금액_입력() {
        String input = "0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        try {
            InputView.readAmountOfLottoPrice();
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("[ERROR] 0원 이하의 금액은 입력할 수 없습니다.", e.getMessage());
        }
    }

    @Test
    void 당첨번호를_쉼표가_아닌_문자로_숫자로_구분해서_입력() {
        String input = "1 2 3 4 5 6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        try {
            InputView.readWinningNumbers();
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("[ERROR] 당첨 번호는 6개의 숫자를 쉼표로 구분하여 입력해야 합니다.", e.getMessage());
        }
    }
}