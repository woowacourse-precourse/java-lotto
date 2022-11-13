package lotto.Model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.Utils.Validator.BonusValidator;
import lotto.Utils.Validator.BuyerValidator;
import lotto.Utils.Validator.LottoValidator;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    void BuyerValidator_입력받은_구매금액이_예외인지_판별() {
        String input1 = "$2,000";
        assertThatThrownBy(() -> new BuyerValidator(input1))
                .isInstanceOf(IllegalArgumentException.class);

        String input2 = "20210";
        assertThatThrownBy(() -> new BuyerValidator(input2))
                .isInstanceOf(IllegalArgumentException.class);

        String input3 = "-2000";
        assertThatThrownBy(() -> new BuyerValidator(input3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void LottoValidator_입력한_당첨로또번호가_예외인지_판별() {
        String input1 = "a,b,2,3,4,5";
        assertThatThrownBy(() -> new LottoValidator(input1))
                .isInstanceOf(IllegalArgumentException.class);

        String input2 = "1,2,3,4,5,6,7";
        assertThatThrownBy(() -> new LottoValidator(input2))
                .isInstanceOf(IllegalArgumentException.class);

        String input3 = "-2,0,3,4,5,87";
        assertThatThrownBy(() -> new LottoValidator(input3))
                .isInstanceOf(IllegalArgumentException.class);

        String input4 = "1,2,3,3,5,41";
        assertThatThrownBy(() -> new LottoValidator(input4))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void BonusValidator_입력받은_보너스번호가_예외인지_판별() {
        List<Integer> lotto = List.of(1,2,3,4,5,6);

        String input1 = "a";
        assertThatThrownBy(() -> new BonusValidator(lotto, input1))
                .isInstanceOf(IllegalArgumentException.class);

        String input2 = "-1";
        assertThatThrownBy(() -> new BonusValidator(lotto, input2))
                .isInstanceOf(IllegalArgumentException.class);

        String input3 = "6";
        assertThatThrownBy(() -> new BonusValidator(lotto, input3))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
