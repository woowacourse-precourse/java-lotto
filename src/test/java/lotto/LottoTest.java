package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.Count.WinTypeCounter;
import static lotto.Count.WinningCount;
import static lotto.Lotto.validateNumberRange;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByBigNumber(){
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5000)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void createBonusByDuplicatedLotto(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Bonus.BonusNumber = 1;
        assertThatThrownBy(() -> Bonus.BonusValidate(Bonus.BonusNumber,lotto.getLottoNumber()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("가격 input 값이 숫자가 아니면 예외처리")
    @Test
    void PriceCheckInt() {
        String input = "ABBD";
        new Buy();
        assertThatThrownBy(() -> Buy.validatePrice(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 단위로 입력되지 않으면 예외처리")
    @Test
    void PriceCheck1000() {
        int input = 7999;
        new Buy();
        assertThatThrownBy(() -> Buy.validate1000(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호를 로또의 범위 1~45에서 벗어나면 예외처리")
    @Test
    void inputBonusByRange() {
        Bonus.BonusNumber = 56;
        assertThatThrownBy(() -> validateNumberRange(Bonus.BonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호를 로또번호와 비교")
    @Test
    void compareLottoTest() {
        List<Integer> lotto = Arrays.asList(10,22,34,43,23,6);
        List<Integer> winningNumbers = Arrays.asList(10,22,34,1,5,4);
        Bonus.BonusNumber = 7;

        assertEquals(MatchNumber.THREE, Count.WinCount(lotto, winningNumbers));
    }

    @DisplayName("로또 번호와 당첨번호를 비교하여 같은 번호 갯수")
    @Test
    void winningLottoTest() {
        Lotto lotto = new Lotto(List.of(3, 4, 5, 6, 7, 8));
        List<List<Integer>> userNumber = new ArrayList<>();
        List<Integer> result;
        userNumber.add(List.of(1, 5, 6, 8, 23, 30));  //568 3개 같다
        userNumber.add(List.of(3, 4, 5, 6, 11, 30));  //3456 4개 같다
        userNumber.add(List.of(1, 3, 4, 5, 6, 7)); //34567 5개 같다
        userNumber.add(List.of(3, 4, 5, 6, 7, 8));  //345678 6개 같다
        result = Count.WinningCount(userNumber, lotto.getLottoNumber());
        assertEquals(List.of(3, 4, 5, 6), result);
    }

    @Test
    void priceCalculateTest() {
        Lotto lotto = new Lotto(List.of(3, 4, 5, 6, 7, 8));
        List<List<Integer>> userNumber = new ArrayList<>();
        int result;
        userNumber.add(List.of(1, 5, 6, 8, 23, 30));  //568 3개 같다
        userNumber.add(List.of(3, 4, 5, 6, 11, 30));  //3456 4개 같다
        userNumber.add(List.of(3, 5, 6, 21, 23, 45));  //356 3개 같다

        WinningCount(userNumber, lotto.getLottoNumber());
        result = PrintLotto.getPrizeMoney(WinTypeCounter);
        assertEquals(65000, result);
    }
}
