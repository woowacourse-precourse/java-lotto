package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;

public class LottoMachineTest {

    @DisplayName("로또 머신에 희망 금액을 입력하면 구매 가능 개수를 리턴해준다.")
    @Test
    public void canBuyAmount() {
        //given
        User user = new User();
        String input = "55000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int wantBuyAmountInput = user.wantBuyAmountInput();

        LottoMachine lottoMachine = new LottoMachine();

        //then
        int canBuyAmount = lottoMachine.canBuyAmount(wantBuyAmountInput);

        //then
        Assertions.assertThat(canBuyAmount).isEqualTo(55);
    }

    @DisplayName("로또 머신에 정수타입의 리스트를 넣으면 로또 객체를 생선해준다.")
    @Test
    public void makeLotto() {
        //given
        LottoMachine lottoMachine = new LottoMachine();
        List<Integer> pickUniqueNumbersInRange = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        //when
        Lotto lotto = lottoMachine.makeLotto(pickUniqueNumbersInRange);

        //then
        Assertions.assertThat(lotto.getNumbers()).isEqualTo(pickUniqueNumbersInRange);
    }

    @DisplayName("로또 머신에 구매 가능 수량을 넣으면 그 수만큼 로또를 발행한다.")
    @Test
    public void lottoList() {
        //given
        LottoMachine lottoMachine = new LottoMachine();

        User user = new User();
        String input = "5000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int wantBuyAmountInput = user.wantBuyAmountInput();

        int canBuyAmount = lottoMachine.canBuyAmount(wantBuyAmountInput);

        //when
        List<Lotto> lottoList = lottoMachine.lottoList(canBuyAmount);

        //then
        Assertions.assertThat(lottoList.size()).isEqualTo(canBuyAmount);
        Assertions.assertThat(lottoList.get(0).getNumbers().size()).isEqualTo(6);
    }

    @DisplayName("로또 머신에 로또와 당첨번호를 입력하면 맞은 갯수를 알려준다.")
    @Test
    public void countCorrect() {
        //given
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.lottoList(1);
        List<Integer> winningNumbers = new ArrayList<>(lottos.get(0).getNumbers());

        //when
        List<Integer> countCorrect = lottoMachine.countCorrect(lottos, winningNumbers);

        //then
        Assertions.assertThat(countCorrect.get(0)).isEqualTo(6);
    }

    @DisplayName("로또 머신에 로또와 보너스 번호를 입력하면 보너스 번호가 포함되었는지 알려준다.")
    @Test
    public void isContainBonusNumber() {
        //given
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.lottoList(1);

        //when
        boolean containBonusNumber1 = lottoMachine.isContainBonusNumber(lottos, lottos.get(0).getNumbers().get(0));
        boolean containBonusNumber2 = lottoMachine.isContainBonusNumber(lottos, 46);

        //then
        Assertions.assertThat(containBonusNumber1).isEqualTo(true);
        Assertions.assertThat(containBonusNumber2).isEqualTo(false);
    }

    @DisplayName("로또 머신에 로또 리스트와 보너스 넘버를 입력하면 보너스 번호가 포함되었는지에 대한 리스트를 리턴한다.")
    @Test
    public void isContainBonusNumberList() {
        //given
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.lottoList(10);

        //when
        List<Boolean> containBonusNumberList1 = lottoMachine.isContainBonusNumberList(lottos, 10);
        List<Boolean> containBonusNumberList2 = lottoMachine.isContainBonusNumberList(lottos, 50);

        //then
        Assertions.assertThat(containBonusNumberList1.size()).isEqualTo(10);
        Assertions.assertThat(containBonusNumberList2.size()).isEqualTo(10);

        for (int i = 0; i < 10; i++) {
            Assertions.assertThat(containBonusNumberList2.get(i)).isEqualTo(false);
        }
    }

    @DisplayName("로또 머신에 맞은갯수 리스트와 보너스 번호 일치여부 리스트를 입력하면 각 등수의 갯수를 리턴한다.")
    @Test
    public void makeScoreBoard() {
        //given
        LottoMachine lottoMachine = new LottoMachine();
        List<Integer> correctList = List.of(1, 3, 3, 4, 4, 6);
        List<Boolean> bonusList = List.of(true, true, false, true, false, false);

        //when
        int[] scoreBoard = lottoMachine.makeScoreBoard(correctList, bonusList);

        //then
        Assertions.assertThat(scoreBoard[0]).isEqualTo(2);
        Assertions.assertThat(scoreBoard[1]).isEqualTo(2);
        Assertions.assertThat(scoreBoard[2]).isEqualTo(0);
        Assertions.assertThat(scoreBoard[3]).isEqualTo(0);
        Assertions.assertThat(scoreBoard[4]).isEqualTo(1);
    }

    @DisplayName("로또 머신에 맞은갯수 리스트와 보너스 번호 일치 여부 리스트를 입력하면 총 수익을 리턴한다.")
    @Test
    public void totalIncome() {
        //given
        LottoMachine lottoMachine = new LottoMachine();
        List<Integer> correctList = List.of(1, 3, 3, 4, 4, 6);
        List<Boolean> bonusList = List.of(true, true, false, true, false, false);

        //when
        int totalIncome = lottoMachine.totalIncome(correctList, bonusList);

        //then
        Assertions.assertThat(totalIncome).isEqualTo(2000110000);
    }
}
