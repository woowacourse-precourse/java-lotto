package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Generator;
import lotto.model.Lotto;
import org.junit.jupiter.api.Test;

class GeneratorTest {

    @Test
    void creatNumber() {
        final int size = 6;
        final List<Integer> instance = Generator.creatNumber();
        assertEquals(instance.size(), size);
    }

    @Test
    void creatLottoBundle() {
        final int purchaseAmount = 5;
        final List<Lotto> instance = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            instance.add(new Lotto(Generator.creatNumber()));
        }
        assertEquals(instance.size(), purchaseAmount);
    }

    @Test
    void creatWinningNumber() {
        final String input = "1,2,3,4,5,6";
        final int size = 6;
        List<Integer> instance = Generator.creatWinningNumber(input);
        assertEquals(instance.size(), size);
    }

    @Test
    void addBonusNumber() {
        final String input = "1,2,3,4,5,6";
        final int size = 7;
        final int bonusNumber = 7;
        List<Integer> instance = Generator.creatWinningNumber(input);
        Generator.addBonusNumber(instance, bonusNumber);
        assertEquals(instance.size(), size);
    }
}