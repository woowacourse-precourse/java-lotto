package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ResultTest {

    Result result = new Result();
    Printer printer = new Printer();
    int bonus;

    private Lotto makeTestLotto(int one, int two, int three, int four, int five, int six){
        return new Lotto(List.of(one, two, three, four, five, six));
    }

    @Test
    void checkWinFirst() {
        Lotto winLotto = makeTestLotto(1, 2, 3,4,5,6);
        Lotto testLotto = makeTestLotto(1, 2, 3,4,5,6);
        bonus = 7;
        result.compareEachLotto(winLotto, 7, testLotto);
        assertEquals(result.count, 6);
        assertEquals(result.bonus_index, 0);
    }

    @Test
    void checkWinSecond() {
        Lotto winLotto = makeTestLotto(1, 2, 3,4,5,6);
        Lotto testLotto = makeTestLotto(1, 2, 3,4,5,7);
        bonus = 7;
        result.compareEachLotto(winLotto, 7, testLotto);
        assertEquals(result.count, 5);
        assertEquals(result.bonus_index, 1);
    }

    @Test
    void checkWinThird() {
        Lotto winLotto = makeTestLotto(1, 2, 3,4,5,6);
        Lotto testLotto = makeTestLotto(8, 2, 3,4,5,6);
        bonus = 7;
        result.compareEachLotto(winLotto, 7, testLotto);
        assertEquals(result.count, 5);
        assertEquals(result.bonus_index, 0);
    }

    @Test
    void checkWinFourth() {
        Lotto winLotto = makeTestLotto(1, 2, 3,4,5,6);
        Lotto testLotto = makeTestLotto(8, 9, 3,4,5,6);
        bonus = 7;
        result.compareEachLotto(winLotto, 7, testLotto);
        assertEquals(result.count, 4);
        assertEquals(result.bonus_index, 0);
    }

    @Test
    void checkWinFifth() {
        Lotto winLotto = makeTestLotto(1, 2, 3,4,5,6);
        Lotto testLotto = makeTestLotto(8, 9, 10,4,5,6);
        bonus = 7;
        result.compareEachLotto(winLotto, 7, testLotto);
        assertEquals(result.count, 3);
        assertEquals(result.bonus_index, 0);
    }
}
