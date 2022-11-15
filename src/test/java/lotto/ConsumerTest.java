package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ConsumerTest {
    @Test
    void testBuyLotto() {
        Consumer consumer = new Consumer();
        String input = "8000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        consumer.buyLotto();
        System.out.println(out.toString());
        assertThat(out.toString()).contains("8개를 구매했습니다.");
    }

    @Test
    void putWinLotto() {
        Consumer consumer = new Consumer();
        String input = "11,12,13,14,15,16";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(consumer.putWinLotto().getNumbers()).isEqualTo(List.of(11,12,13,14,15,16));
    }

    @Test
    void putBonusNumber() {
        Consumer consumer = new Consumer();
        String input = "11";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(consumer.putBonusNumber()).isEqualTo(11);
    }

    @Test
    void calcStat() {
        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Consumer tester = new Consumer(winLotto);
        assertThat(tester.calcStat(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7))
                .isEqualTo(List.of(0, 0, 0, 1, 0, 0));
    }

    @Test
    void calcProfit() {
        Consumer consumer = new Consumer(new Lotto(List.of(1,2,3,4,5,6)));
        List<Integer> stat = new ArrayList<>(List.of(1,0,0,0,0,0));
        assertThat(consumer.calcProfit(stat))
                .isEqualTo(List.of(1, 0, 0, 0, 0, 5000));
    }
}