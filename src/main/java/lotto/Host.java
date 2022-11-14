package lotto;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Host {

    private Lotto winningLotto;
    private List<Integer> winningLottoNumbers;
    private int winningBonusNumber;

    public Host(Lotto winningLotto, int winningBonusNumber) {
        this.winningLotto = winningLotto;
        this.winningLottoNumbers = winningLotto.getNumbers();
        this.winningBonusNumber = winningBonusNumber;
    }

    public List<Winning> drawLotto(User user) {
        List<Winning> result = new ArrayList<>();

        for (Lotto userLotto : user.getLottos()) {
            int correctCount = compareNumbers(userLotto);
            boolean isBonusNumber = compareBonusNumber(userLotto);
            result.add(Winning.valueOf(correctCount, isBonusNumber));
        }
        return result;
    }

    private boolean compareBonusNumber(Lotto userLotto) {
        return userLotto.getNumbers().contains(winningBonusNumber);
    }

    private int compareNumbers(Lotto userLotto) {
        List<Integer> userLottoNumbers = userLotto.getNumbers();
        int correctCount = 0;

        for (int i = 0; i < Constants.LOTTO_LEN; i++) {
            if (userLottoNumbers.get(i) == winningLottoNumbers.get(i)) {
                correctCount += 1;
            }
        }
        return correctCount;
    }
}
