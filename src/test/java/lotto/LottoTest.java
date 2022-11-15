package lotto;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Rank를 반환한다.")
    @Test
    void getLottoRank() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        String input = "1,2,3,4,5,6\n7\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        WinningNumber winningNumbers = new WinningNumber();
        lotto.setWinningNumber(winningNumbers);

        //when
        Rank rank = lotto.lottoRank();

        //then
        Assertions.assertThat(rank).isEqualTo(Rank.FIRST);


    }

    @Test
    void matchWinningNumbers() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        String input = "1,2,3,4,5,6\n7\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        WinningNumber winningNumbers = new WinningNumber();
        lotto.setWinningNumber(winningNumbers);

        //when
        int matchWinningNumberCount = lotto.matchWinningNumbers();

        //then
        Assertions.assertThat(matchWinningNumberCount).isEqualTo(6);
    }

    @Test
    void matchBonusNumber() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        String input = "1,2,3,4,5,6\n7\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        WinningNumber winningNumbers = new WinningNumber();
        lotto.setWinningNumber(winningNumbers);

        //when
        int matchBonusNumberCount = lotto.matchBonusNumber();

        //then
        Assertions.assertThat(matchBonusNumberCount).isEqualTo(0);
    }
}
