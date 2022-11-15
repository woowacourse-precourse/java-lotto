package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.enums.EtcNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    CalculatorUtility calculatorUtility = new CalculatorUtility();

    public LottoTickets generateLottoTickets(int purchasingAmount) {
        List<Lotto> lottos = new ArrayList<>();
        int tickets = calculatorUtility.convertMoneyToTickets(purchasingAmount);

        for (int count = EtcNumber.ZERO.getNumber(); count < tickets; count++) {
            List<Integer> numbers = generateLottoNumbers();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        LottoTickets lottoTickets = new LottoTickets(lottos);

        return lottoTickets;
    }

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(EtcNumber.NUMBER_MIN.getNumber(), EtcNumber.NUMBER_MAX.getNumber(), EtcNumber.LOTTO_SIZE.getNumber());
    }

    public WinningLotto generateWinningLotto(List<Integer> winningNumbers) {
        WinningLotto winningLotto = new WinningLotto(winningNumbers);
        return winningLotto;
    }

    public BonusBall generateBonusBall(int bonusNumber) {
        BonusBall bonusBall = new BonusBall(bonusNumber);
        return bonusBall;
    }

}
