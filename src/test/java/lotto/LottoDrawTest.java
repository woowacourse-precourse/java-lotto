package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoDrawTest {

    @Test
    void init() {
        ByteArrayInputStream in = new ByteArrayInputStream("1,3,5,7,9,13\n15".getBytes());
        System.setIn(in);

        LottoDraw lottoDraw = new LottoDraw();

        assertThat(lottoDraw.getTotalPrizeMoney()).isEqualTo(0);
        assertThat(lottoDraw.getNumberOfWins())
                .hasSize(5)
                .contains(entry("1등", 0), entry("2등", 0), entry("3등", 0), entry("4등", 0), entry("5등", 0));
    }

    @Test
    void enterWinningNumber() {
        ByteArrayInputStream in = new ByteArrayInputStream("1,3,5,7,9,13\n15".getBytes());
        System.setIn(in);


        LottoDraw lottoDraw = new LottoDraw();
        assertThat(lottoDraw.getWinningNumbers()).isEqualTo(List.of(1, 3, 5, 7, 9, 13));
    }

    @Test
    void numberCountValidation() {
        ByteArrayInputStream in = new ByteArrayInputStream("1,3,5,7,9,11,13".getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> new LottoDraw())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 당첨 번호는 6개입니다.");
    }

    @Test
    void numberDuplicateValidation() {
        ByteArrayInputStream in = new ByteArrayInputStream("1,3,5,3,9,11\n12".getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> new LottoDraw())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 당첨 번호는 중복될 수 없습니다.");
    }

    @Test
    void numberRangeValidation() {
        ByteArrayInputStream in = new ByteArrayInputStream("1,2,46,3,9,11\n12".getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> new LottoDraw())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 당첨 번호는 1 ~ 45 범위입니다.");
    }

    @Test
    void enterBonusNumber() {
        ByteArrayInputStream in = new ByteArrayInputStream("1,2,3,4,5,6\n7".getBytes());
        System.setIn(in);

        LottoDraw lottoDraw = new LottoDraw();

        assertThat(lottoDraw.getBonusNumber()).isEqualTo(7);
    }

    @Test
    void bonusNumberDuplicateValidation() {
        ByteArrayInputStream in = new ByteArrayInputStream("1,2,3,4,5,6\n3".getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> new LottoDraw())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 당첨 번호는 중복될 수 없습니다.");
    }

    @Test
    void bonusNumberRangeValidation() {
        ByteArrayInputStream in = new ByteArrayInputStream("1,2,3,4,5,6\n0".getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> new LottoDraw())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 당첨 번호는 1 ~ 45 범위입니다.");
    }
}