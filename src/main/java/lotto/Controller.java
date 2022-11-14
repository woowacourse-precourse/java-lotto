package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Controller {
    private View view;
    private List<Lotto> lottoNumbers;
    private List<Integer> winningNumbers;

    public void makeLottoNumbers(int number) {
        for (int i = 0; i < number; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumbers.add(new Lotto(numbers));
        }
    }

    public void makeWinningNumbers(){
        winningNumbers = view.inputLottoNumber();
        winningNumbers.add(view.inputBonusNumber());
    }
}
