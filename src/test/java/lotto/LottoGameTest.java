package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoGameTest {
    @DisplayName("로또 금액으로 로또가 몇개인지 반환한다.")
    @Test
    void getLottoCount() {
        int lottoPrice = 13000;
        int lottoCount = 13;

        assertThat(LottoGame.getLottoCount(lottoPrice)).isEqualTo(lottoCount);
    }

    @DisplayName("로또 번호 string 타입에서 list로 변환한다.")
    @Test
    void splitLottoNumber() {
        String lottoNumber = "1,2,3,4,5,6";
        List<Integer> lottoNumbers = LottoGame.spiltLottoNumber(lottoNumber);

        assertThat(lottoNumbers).contains(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("당첨 로또를 생성한다.")
    @Test
    void createWinningLotto() {
        String winningLottoNumbers = "1,2,3,4,5,6";
        String bonus = "7";

        WinningLotto winningLotto = LottoGame.createWinningLotto(winningLottoNumbers, bonus);

        List<Integer> winningLottoNumber = winningLotto.getWinningLottoNumbers().getLottoNumbers();

        assertThat(winningLottoNumber).contains(1, 2, 3, 4, 5, 6);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(7);
    }
}
