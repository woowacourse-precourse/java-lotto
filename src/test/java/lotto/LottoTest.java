package lotto;

import lotto.exception.Exception;
import lotto.rank.Rank;
import lotto.service.Service;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    // 아래에 추가 테스트 작성 가능

    @DisplayName("구입 금액에 숫자가 아닌 문자가 섞여있을 때 예외 발생")
    @Test
    void verifyMoneyNumberFormat() {
        assertThatThrownBy(() -> Exception.verifyMoney("1000q"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 0이나 1000으로 나누어 떨어지지 않을 때")
    @Test
    void verifyMoney() {
        assertThatThrownBy(() -> Exception.verifyMoney("0"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Exception.verifyMoney("10001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 개수와 로또 구매 개수가 같아야 합니다.")
    @Test
    void verifyLottoListLength() {
        int volume = 5;
        List<Lotto> lottoList = Service.getLotto(volume);
        assertThatThrownBy(() -> Exception.verifyLottoListVolume(lottoList, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호를 배열로 바꿨을 때의 길이가 6이고, 구성된 배열의 값이 당첨번호와 일치해야 합니다.")
    @Test
    void verifyJackpotToArr() {
        String jackpot = "1,2,3,4,5,6";
        String[] jackpotArr = Service.getJackpotNumberToArr(jackpot);
        assertThat(jackpotArr).isEqualTo(new String[]{"1","2","3","4","5","6"});
        assertThat(jackpotArr).hasSize(6);
    }

    @DisplayName("구매한 로또 번호에 보너스 번호가 포함되어 있는지 확인")
    @Test
    void checkLottoNumber() {
        List<Integer> lotto = List.of(1,2,3,4,5,7);
        String[] jackpotArr = new String[]{"1","2","3","4","5","6"};
        int bonusNum = 7;
        Service.checkLotto(lotto, jackpotArr, bonusNum);
        assertThat(Rank.getBonus()).isTrue();
    }

    @DisplayName("당첨번호와 맞는 숫자가 5개, 보너스번호를 맞췄을 때 2등 횟수 1카운트")
    @Test
    void checkRank() {
        List<Integer> lotto = List.of(1,2,3,4,5,7);
        String[] jackpotArr = new String[]{"1","2","3","4","5","6"};
        int bonusNum = 7;
        Service.checkLotto(lotto, jackpotArr, bonusNum);
        Service.checkRank();
        assertThat(Rank.getSecond()).isEqualTo(1);
    }
}
