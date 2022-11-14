package lotto;

import lotto.global.LogicException;
import lotto.model.Check;
import lotto.model.Rank;
import lotto.model.Lotto;
import lotto.domain.Service;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

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
        assertThatThrownBy(() -> LogicException.verifyMoney("1000q"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 0이나 1000으로 나누어 떨어지지 않을 때")
    @Test
    void verifyMoney() {
        assertThatThrownBy(() -> LogicException.verifyMoney("0"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LogicException.verifyMoney("10001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 개수와 로또 구매 개수가 같아야 합니다.")
    @Test
    void verifyLottoListLength() {
        int volume = 5;
        List<Lotto> lottoList = Service.getLotto(volume);
        assertThatThrownBy(() -> LogicException.verifyLottoListVolume(lottoList, 3))
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
        List<Check> checkList = Service.checkLotto(lotto, jackpotArr, bonusNum);
        assertThat(checkList.get(0).getBonus()).isTrue();
    }

    @DisplayName("당첨번호와 맞는 숫자가 5개, 보너스번호를 맞췄을 때 2등 횟수 1카운트")
    @Test
    void checkRank() {
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 7);
        String[] jackpotArr = new String[]{"1", "2", "3", "4", "5", "6"};
        int bonusNum = 7;
        Rank rank = new Rank(0, 0, 0, 0, 0);
        List<Check> checkList = Service.checkLotto(lotto, jackpotArr, bonusNum);
        Service.checkRank(checkList, rank);
        assertThat(rank.getSecond()).isEqualTo(1);
    }


    @DisplayName("당첨금액의 총액이 일치하는지 테스트")
    @Test
    void checkWinningPrice() {
        List<Integer> lotto = List.of(1,2,3,4,5,7);
        String[] jackpotArr = new String[]{"1","2","3","4","5","6"};
        int bonusNum = 7;
        Rank rank = new Rank(0,0,0,0,0);
        List<Check> checkList = Service.checkLotto(lotto, jackpotArr, bonusNum);
        Service.checkRank(checkList, rank);
        int winning = Service.getWinningPrice(rank);
        assertThat(winning).isEqualTo(30000000);
    }

    @DisplayName("수익률은 소수점 둘째자리에서 반올림한다")
    @Test
    void checkEarningRate() {
        int winningPrice = 25790000;
        int money = 100000000;
        assertThat(Service.getEarningsRate(winningPrice, money)).isEqualTo("25.8");
    }

    @DisplayName("보너스 번호는 1부터 45까지여야 한다")
    @Test
    void checkBonusNum() {
        int bonusNum = 0;
        assertThatThrownBy(() -> LogicException.verifyBonusNum(bonusNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호는 당첨번호에 포함되지 않아야 한다")
    @Test
    void checkBonusNumAndJackpotNum() {
        String jackpotNum = "1,2,3,4,5,6";
        String[] jackpotNumArr = Service.getJackpotNumberToArr(jackpotNum);
        int bonusNum = 6;
        assertThatThrownBy(() -> LogicException.verifyBonusNumAndJackpot(jackpotNumArr, bonusNum))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
