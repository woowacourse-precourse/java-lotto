package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoBuyerTest {

    @Test
    void getCost() {
        ByteArrayInputStream in = new ByteArrayInputStream("12000".getBytes());
        System.setIn(in);

        UI.setCost();
        LottoBuyer lottoBuyer = new LottoBuyer(UI.getCost());
        int cost = lottoBuyer.getCost();

        assertThat(cost).isEqualTo(12000);
    }

}