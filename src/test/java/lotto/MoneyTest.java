package lotto;

import lotto.model.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

//    @BeforeEach
//    public void 객체_셍성() {
//        Money money = new Money();
//    }


    @DisplayName("같은 값이 들어간 경우 두 값이 같은지 확인")
    @Test
    public void 같은_값이_들어간_경우() {
        Money money1 = new Money("1000");
        Money money2 = new Money("1000");

        Assertions.assertThat(money1.getMoney()).isEqualTo(money2.getMoney());
    }

    @DisplayName("앞, 뒤에 공백이 있는 경우 정상 작동 되는지 확인")
    @Test
    public void 앞_뒤로_공백이_있는_경우() {
        Money money1 = new Money("     1000     ");
        Money money2 = new Money("1000");

        Assertions.assertThat(money1.getMoney()).isEqualTo(money2.getMoney());
    }

    @DisplayName("공백만 들어간 경우 런타임 오류 발생을 확인")
    @Test
    public void 공백이_들어간_경우() {

        Assertions.assertThatThrownBy(() -> new Money("   ")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 값이 들어간 경우 런타임 오류 발생을 확인")
    @Test
    public void 정수가_아닌_값이_들어간_경우() {

        Assertions.assertThatThrownBy(() -> new Money("Abc")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음수가 들어간 경우 런타임 오류 발생을 확인")
    @Test
    public void 음수_값이_들어간_경우() {

        Assertions.assertThatThrownBy(() -> new Money("-1")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1,000원 단위로 값이 들어오지 않은 경우 런타임 오류 발생을 확인")
    @Test
    public void 잘못된_단위의_값이_들어간_경우() {

        Assertions.assertThatThrownBy(() -> new Money("950")).isInstanceOf(IllegalArgumentException.class);
    }



}
