package lotto.generate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BuyerGenerateTest {
    @Test
    public void buyPriceInputIsDigit() throws Exception{
        String input = "e00";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(()-> new BuyerGenerate())
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    public void buyerGenerateCreate() throws Exception{
        String input = "1500";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(()-> new BuyerGenerate().generate())
                .isInstanceOf(IllegalArgumentException.class);
    }
}