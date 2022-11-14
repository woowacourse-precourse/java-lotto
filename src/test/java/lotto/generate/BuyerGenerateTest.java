package lotto.generate;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BuyerGenerateTest {
    @Test
    public void buyPriceInputIsDigit() throws Exception{
        assertThatThrownBy(() ->new BuyerGenerate().digitValidate("1500a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}