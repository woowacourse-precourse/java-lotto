package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class NumbersMakerTest {

    @Test
    void makeWinningNumbers() {
        NumbersMaker numbersMaker = new NumbersMaker();
        String numberWithComma = "1,2,3,4,5,6";
        List<Integer> winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        assertThat(numbersMaker.makeWinningNumbers(numberWithComma)).isEqualTo(winningNumbers);
    }

    @Test
    void makeBonusNumber() {

    }

    @Test
    void makePurchaserNumbers() {
    }
}