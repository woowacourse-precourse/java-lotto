package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Controller {
    private View view;
    private List<Lotto> lottoNumbers;
    private List<Integer> winningNumbers;

    private Rank rank;

    public void makeLottoNumbers(int number) {
        for (int i = 0; i < number; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumbers.add(new Lotto(numbers));
        }
    }

    public void makeWinningNumbers() {
        winningNumbers = view.inputLottoNumber();
        winningNumbers.add(view.inputBonusNumber());
    }

    public void checkLottoNumbers() {
        for (Lotto L : lottoNumbers) {
            compareTwoNumbers(L.getNumbers());
        }
    }

    public void compareTwoNumbers(List<Integer> lottoNumbers) {
        int count = 0;
        for (int i = 0; i < winningNumbers.size(); i++) {
            if (i == winningNumbers.size() - 1 && count == 5) {
                Rank.valueOf("FIFTH_BONUS").increaseCount();
            } else if (lottoNumbers.contains(winningNumbers.get(i))) {
                count++;
            }
        }
        Rank[] values = Rank.values();
        for(int i = 0; i< values.length; i++){
            values[i].increaseCount();
        }
    }
}
