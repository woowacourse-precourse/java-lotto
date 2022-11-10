package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {
    Lotto winningLotto;
    int bonusNum;

    @BeforeEach
    void lottoNumbersInit() {
        winningLotto =  new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        bonusNum = 7;
    }

    @Test
    @DisplayName("6개 번호 일치 -> 1등 당첨 테스트")
    void firstPlace() {
        LottoNumbers lottoNumbers = new LottoNumbers(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), winningLotto, bonusNum);
        assertThat(lottoNumbers.getResult()).isEqualTo(LottoResult.FIRST_PLACE);
    }

    @Test
    @DisplayName("5개 번호 일치 + 본스 번호 일치 -> 2등 당첨 테스트")
    void secondPlace() {
        LottoNumbers lottoNumbers = new LottoNumbers(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), winningLotto, bonusNum);
        assertThat(lottoNumbers.getResult()).isEqualTo(LottoResult.SECOND_PLACE);
    }

    @Test
    @DisplayName("5개 번호 일치 -> 3등 당첨 테스트")
    void thirdPlace() {
        LottoNumbers lottoNumbers = new LottoNumbers(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)), winningLotto, bonusNum);
        assertThat(lottoNumbers.getResult()).isEqualTo(LottoResult.THIRD_PLACE);
    }

    @Test
    @DisplayName("4개 번호 일치 -> 4등 당첨 테스트")
    void fourthPlace() {
        LottoNumbers lottoNumbers = new LottoNumbers(new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)), winningLotto, bonusNum);
        assertThat(lottoNumbers.getResult()).isEqualTo(LottoResult.FOURTH_PLACE);
    }

    @Test
    @DisplayName("3개 번호 일치 -> 5등 당첨 테스트")
    void fifthPlace() {
        LottoNumbers lottoNumbers = new LottoNumbers(new Lotto(Arrays.asList(1, 3, 5, 14, 22, 45)), winningLotto, bonusNum);
        assertThat(lottoNumbers.getResult()).isEqualTo(LottoResult.FIFTH_PLACE);
    }

    @Test
    @DisplayName("3개 미만의 번호만 일치했을 때")
    void lastPlace() {
        LottoNumbers lottoNumbers = new LottoNumbers(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)), winningLotto, bonusNum);
        assertThat(lottoNumbers.getResult()).isEqualTo(LottoResult.LAST_PLACE);
    }
}
