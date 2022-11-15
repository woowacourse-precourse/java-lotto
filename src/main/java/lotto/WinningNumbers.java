package lotto;

import java.util.ArrayList;

// 당첨 번호
public class WinningNumbers {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final Lotto lotto;
    private final int bonusNUM;

    private WinningNumbers (Lotto lotto, int bonusNUM) {
        validateContain(lotto, bonusNUM);
        validateNumberRange(bonusNUM);
        this.lotto = lotto;
        this.bonusNUM = bonusNUM;
    }
    public static WinningNumbers newWinningLottoWithInput(Lotto lotto, int bonusNUM) {
        return new WinningNumbers(lotto, bonusNUM);
    }

    private void validateContain(Lotto lotto, int bonusNo) {
        if (lotto.getLottoNumbers().contains(bonusNo)) {
            throw new IllegalArgumentException("[ERROR] 동일한 로또 번호가 존재합니다.");
        }
    }

    private void validateNumberRange(Integer number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public ArrayList<Integer> match(Lotto userLotto) {
        ArrayList<Integer> matchedLottos = new ArrayList<>();
        int i = (int) userLotto.getLottoNumbers().stream()
                .filter(number -> lotto.getLottoNumbers().contains(number)).count();

        int isBonous = 0;

        if (userLotto.getLottoNumbers().contains(bonusNUM)){
            isBonous = 1;
        }
        else {
            isBonous = 0;
        }
        matchedLottos.add(i);
        matchedLottos.add(isBonous);
        return matchedLottos;
    }
}
