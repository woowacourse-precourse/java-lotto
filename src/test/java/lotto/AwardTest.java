package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AwardTest {

    @DisplayName("출력 양식이 포함되어 출력되는지")
    @Test
    void printTest() {
        ByteArrayOutputStream stdOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdOut));

        String money = "12000";
        String numbers = "1,8,4,2,5,3";
        String bonus = "42";
        String input = money + System.getProperty("line.separator")
                + numbers + System.getProperty("line.separator")
                + bonus;

        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Application.main(new String[]{});

        for(Winning winning : Winning.values()) {
            assertThat(stdOut.toString()).contains(winning.getMessage());
        }
    }

    @DisplayName("비교가 되어 일치 결과가 제대로 도출되는지")
    @Test
    void awardTest() {
        ByteArrayOutputStream stdOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdOut));

        Award award = Award.getInstance();

        List<Lotto> myLotteries = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 7, 8)),
                new Lotto(List.of(1, 2, 3, 7, 8, 9)),
                new Lotto(List.of(1, 2, 3, 4, 5, 10))
        );

        String money = "0";
        String numbers = "1,2,3,4,5,6";
        String bonus = "7";
        String input = money + System.getProperty("line.separator")
                + numbers + System.getProperty("line.separator")
                + bonus;

        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Application.main(new String[]{});

        award.compileStatistics(myLotteries);

        for(Winning winning : Winning.getValues()) {
            assertThat(stdOut.toString()).contains(winning.getMessage() + "1개");
        }
    }
}