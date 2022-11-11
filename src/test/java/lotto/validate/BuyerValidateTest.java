package lotto.validate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BuyerValidateTest {
    private static BuyerValidate buyerValidate;
    @BeforeEach
    public void beforeEach(){
        buyerValidate = new BuyerValidate();
    }

    @Test
    public void buyerValidateTest() throws Exception{
        assertThatThrownBy(() -> buyerValidate.validate(10000,4000))// 구입금액, 로또 한장의 금액
                .isInstanceOf(IllegalArgumentException.class);

    }
}