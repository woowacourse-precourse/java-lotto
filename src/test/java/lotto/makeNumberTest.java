package lotto;

import lotto.domain.Money;
import lotto.domain.makeNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @DisplayName("당첨번호 입력받는 기능 테스트")
    @Test
    void getWinningNumberTest(){
        InputStream in=generateUserInput("1,2,3,4,5,6");
        System.setIn(in);
        String money = makeNumber.getAmountInput();
        assertThat(money.equals("8000"));
    }
    @DisplayName("당첨번호 구분해서 Set에 담는 기능 테스트")
    @Test
    void makeWinningNumberTest(){
        Set<Integer> winner=new HashSet<>();
        makeNumber.addNumber("1,2,3,4,5,6","8",winner);
        assertThat(winner.size() == 7);

    }
    @DisplayName("로또 구입금액 로또로 바꾸는 기능 테스트")
    @Test
    void buyLottoTest(){
        Money money=new Money("8000");
        int lotto= makeNumber.buyLotto(money);
        assertThat(lotto==8);
    }
    @DisplayName("로또번호 랜덤 생성 테스트")
    @Test
    void randomLottoTest(){
        List<Integer> number = new ArrayList<>();
        number= makeNumber.randomLotto();
        assertThat(number.size()==6);
        assertThat(number).doesNotHaveDuplicates();
    }

}
