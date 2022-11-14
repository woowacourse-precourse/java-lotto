package lotto.modelTest;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
public class LottoTest {
    private static final String WRONG_QUANTITY_ERROR_MESSAGE="[ERROR] 로또 번호의 수가 6개가 아닙니다. 프로그램을 종료합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE="[ERROR] 숫자가 중복되었습니다. 프로그램을 종료합니다.";

    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    public void createLottoByOverSize(){
        List<Integer> lotto = List.of(1,2,3,4,5,6,7);
        assertThatThrownBy(()->new Lotto(lotto)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(WRONG_QUANTITY_ERROR_MESSAGE);
    }
    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    public void createLottoByDuplicatedNumber(){
        List<Integer> lotto = List.of(1,2,3,4,6,6);
        assertThatThrownBy(()->new Lotto(lotto)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(DUPLICATE_ERROR_MESSAGE);
    }
    @Test
    @DisplayName("로또에 특정 숫자가 포함되어 있다면 true를 반환한다.")
    public void LottoHaveTheNumber(){
        List<Integer> lottoNumbers = List.of(1,2,3,4,5,6);
        int theNumber=1;
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto.has(theNumber)).isTrue();
    }
    @Test
    @DisplayName("로또에 특정 숫자가 포함되어 있지 않다면 false를 반환한다.")
    public void LottoHaveNotTheNumber(){
        List<Integer> lottoNumbers = List.of(1,2,3,4,5,6);
        int theNumber=7;
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto.has(theNumber)).isFalse();
    }
}
