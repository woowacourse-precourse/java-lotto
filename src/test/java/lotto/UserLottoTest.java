package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserLottoTest {

    @DisplayName("구입금액이 숫자가 아니면 오류를 뱉어 낸다.")
    @Test
    void testValidateMoneyTypeInput() {
        //given
        String input = "1000k";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        UserLotto userLotto = new UserLotto();
        //then
        assertThrows(IllegalArgumentException.class, () -> userLotto.startGame());
    }


    @DisplayName("구입금액이 1000원 단위가 아니면 오류를 뱉어 낸다.")
    @Test
    void testValidateMoneyBillInput() {
        //given
        String input = "1100";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        UserLotto userLotto = new UserLotto();

        //then
        assertThrows(IllegalArgumentException.class, () -> userLotto.startGame());
    }

    @DisplayName("구입금액대로 로또를 구매한다.")
    @Test
    void buyLotto() {
        //given
        String input = "10000\n1,2,3,4,5,6\n7";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        UserLotto userLotto = new UserLotto();

        //when
        userLotto.startGame();
        //then
        assertThat(out.toString()).contains("10개를 구매했습니다.");
    }

    @DisplayName("당첨번호아 로또를 비교하여 등수를 매긴다.")
    @Test
    void getLottoRankCount() {
        //given
        String input = "10000\n1,2,3,4,5,6\n7";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        UserLotto userLotto = new UserLotto();

        //when
        userLotto.startGame();

        //then
        assertThat(userLotto.getLottoRankCount()).isNotEmpty();

    }

    @DisplayName("로또 당첨 결과를 출력한다.")
    @Test
    void printLottoResult() {
        //given
        String input = "10000\n1,2,3,4,5,6\n7";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        UserLotto userLotto = new UserLotto();

        //when
        userLotto.startGame();

        //then
        assertThat(out.toString()).contains("개");
    }

    @DisplayName("수익률을 계산하고 출력한다.")
    @Test
    void printProfit() {
        //given
        String input = "10000\n1,2,3,4,5,6\n7";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        UserLotto userLotto = new UserLotto();

        //when
        userLotto.startGame();

        //then
        assertThat(out.toString()).contains("총 수익률은");
    }

}