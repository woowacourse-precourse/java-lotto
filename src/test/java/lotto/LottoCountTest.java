package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import view.OutputView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LottoCountTest {
    @ParameterizedTest
    @DisplayName("구입 금액에 따른 로또의 갯수를 확인하는 테스트")
    @ValueSource(strings = {"1000","2000","14000","8000","42000"})
    void 로또_갯수_Count_테스트(String input){
        LottoMoney lottoMoney = new LottoMoney(input);
        Assertions.assertThat(lottoMoney.changeToLottoCount()).isEqualTo(Integer.parseInt(input)/LottoMoney.LOTTO_PRICE);
    }

    @ParameterizedTest
    @DisplayName(("로또 갯수를 출력이 올바른지 확인하는 테스트"))
    @ValueSource(ints = {1,14,58,52,4,8})
    void 로또_갯수_콘솔_출력_테스트(int count){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        OutputView.printLottoCount(new LottoCount(count));
        LottoCount lottoCount = new LottoCount(count);
        Assertions.assertThat(String.format("%d개를 구매했습니다",count)).isEqualTo(byteArrayOutputStream.toString());
    }
    @ParameterizedTest
    @DisplayName("로또 갯수가 마이너스이면 에러를 띄우는 테스트")
    @ValueSource(ints = {-1,-2,-3,-4,-5,-6,-7,-8})
    void 로또_갯수가_마이너스(int count){
        Assertions.assertThatThrownBy(()->new LottoCount(count)).isInstanceOf(IllegalArgumentException.class);
    }
}
