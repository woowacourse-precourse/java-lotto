package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    CalculatorUtility calculatorUtility = new CalculatorUtility();

    private List<Lotto> lottoTickets = new ArrayList<>();

    public void generateLottoTickets(int purchasingAmount) {
        int tickets = calculatorUtility.convertMoneyToTickets(purchasingAmount);
        for(int count = 0; count < tickets; count++) {
            List<Integer> numbers = generateLottoNumbers();
            Lotto lotto = new Lotto(numbers);
            lottoTickets.add(lotto);
        }

    }

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

}
