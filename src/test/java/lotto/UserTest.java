package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void 단위가_1000원이_아닌경우(){
        int money = 1100;
        User user = new User();
        Assertions.assertThatIllegalArgumentException().isThrownBy(()
                -> user.isMoneyDividedWith1000(money));
    }

}