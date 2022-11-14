package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.lottoclient.LottoConsole;
import org.junit.jupiter.api.Test;

class LottoCheckerTest {

    class MockLottoConsole implements LottoConsole {

        @Override
        public Integer inputAnswerBonusNumber() {
            return 7;
        }

        @Override
        public List<Integer> inputAnswerNumber() {
            return List.of(1, 2, 3, 4, 5, 6);
        }
    }

    @Test
    void 결과_로또_번호_지정_성공() throws Exception {
        MockLottoConsole lottoConsole = new MockLottoConsole();
        LottoChecker lottoChecker = new LottoChecker(lottoConsole);
        lottoChecker.decideAnswerLotto();
        AnswerLotto expect = new AnswerLotto(lottoConsole.inputAnswerNumber(),
            lottoConsole.inputAnswerBonusNumber());
        assertThat(lottoChecker.getAnswerLotto()).usingRecursiveComparison().isEqualTo(expect);
    }

    @Test
    void 로또번호_맞춰보기_성공() throws Exception {
        MockLottoConsole lottoConsole = new MockLottoConsole();
        LottoChecker lottoChecker = new LottoChecker(lottoConsole);
        lottoChecker.decideAnswerLotto();
        User user = new User("1000");
        user.setPaidLottoList(List.of(new PaidLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)))));
        lottoChecker.checkUserLottoList(user);

        assertThat(user.getPaidLottoList().get(0).getLottoReward()).isEqualTo(LottoReward.FIRST);
    }
}