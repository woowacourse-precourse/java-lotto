package lotto.inputview;

import lotto.inputtool.ArrayConverter;
import lotto.lotto.Lotto;
import lotto.inputtool.TextConverter;
import lotto.lotto.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputWinningLottoTest {

    @Test
    void array변환() {
        String[] stringArray = TextConverter.splitComma("1,2,3,4,5,6");
        int[] intArray = Arrays.stream(stringArray)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    @Test
    @DisplayName("당첨번호 입력 - 리스트 반환 - 예외 체크")
    void 당첨번호입력() {
        String[] numberArray = TextConverter.splitComma("1,2,3,4,5,6");
        List<Integer> lottoNumberList = ArrayConverter.toIntegerList(numberArray);
        Assertions.assertThat(lottoNumberList.size()).isEqualTo(6);
        Lotto lotto = new Lotto(lottoNumberList);
    }

    @Test
    @DisplayName("당첨번호 입력 - 리스트 반환 - 예외 체크")
    void 당첨번호입력2() {
        String[] numberArray = TextConverter.splitComma("1,2,3,4,5,6,7");
        String[] numberArray2 = TextConverter.splitComma("1,2,3,4,6,6");
        String[] numberArray3 = TextConverter.splitComma("a,2,3,4,6,7");
        List<Integer> lottoNumberList = ArrayConverter.toIntegerList(numberArray);
        List<Integer> lottoNumberList2 = ArrayConverter.toIntegerList(numberArray2);
        assertThrows(IllegalArgumentException.class, () -> new Lotto(lottoNumberList));
        assertThrows(IllegalArgumentException.class, () -> new Lotto(lottoNumberList2));
        assertThrows(IllegalArgumentException.class, () -> ArrayConverter.toIntegerList(numberArray3));
    }

    @Test
    @DisplayName("당첨번호 입력 - 보너스 번호 입력")
    void 당청번호_보너스번호입력() {
        String[] numberArray = TextConverter.splitComma("1,2,3,4,5,6");
        List<Integer> lottoNumberList = ArrayConverter.toIntegerList(numberArray);
        Lotto lotto = new Lotto(lottoNumberList);
        WinningLotto winningLotto = new WinningLotto(lotto, 7);
    }
}