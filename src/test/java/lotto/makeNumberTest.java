package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import  lotto.makeNumber.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class makeNumberTest {
    public static InputStream generateUserInput(String input){
        return new ByteArrayInputStream(input.getBytes());
    }

    @DisplayName("로또 구입금액 입력받는 기능 테스트")
    @Test
    void getAmountInputTest(){
        InputStream in=generateUserInput("8000");
        System.setIn(in);
        String money = makeNumber.getAmountInput();
        assertThat(money.equals("8000"));
    }

    @DisplayName("로또 구입금액 로또로 바꾸는 기능 테스트")
    @Test
    void buyLottoTest(){
        int lotto= makeNumber.buyLotto("8000");
        assertThat(lotto==8);
    }
    @DisplayName("로또번호 랜덤 생성 테스트")
    @Test
    void randomLottoTest(){
        List<Integer> number = new ArrayList<>();
        number= makeNumber.randomLotto(number);
        assertThat(number.size()==6);
        assertThat(number).doesNotHaveDuplicates();
    }

}
