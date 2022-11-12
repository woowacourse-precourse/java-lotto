package lotto.modelTest;

import lotto.model.Buyer;
import lotto.model.Lotto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    private static final String WRONG_QUANTITY_ERROR_MESSAGE="[ERROR] 로또 번호의 수가 6개가 아닙니다. 프로그램을 종료합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE="[ERROR] 숫자가 중복되었습니다. 프로그램을 종료합니다.";

    @Test
    public void 로또_번호가_5개인_경우_예외_확인하기(){
        List<Integer> lotto = List.of(1,2,3,4,5);
        assertThatThrownBy(()->new Lotto(lotto)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(WRONG_QUANTITY_ERROR_MESSAGE);
    }
    @Test
    public void 로또_번호가_7개인_경우_예외_확인하기(){
        List<Integer> lotto = List.of(1,2,3,4,5,6,7);
        assertThatThrownBy(()->new Lotto(lotto)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(WRONG_QUANTITY_ERROR_MESSAGE);
    }
    @Test
    public void 로또_번호가_중복된_경우_예외_확인하기(){
        List<Integer> lotto = List.of(1,2,3,4,6,6);
        assertThatThrownBy(()->new Lotto(lotto)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(DUPLICATE_ERROR_MESSAGE);
    }
}
