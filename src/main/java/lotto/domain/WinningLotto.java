package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningLotto {
    Lotto winningLottoNumbers;
    int bonusNumber;

    private WinningLotto(Lotto winningLottoNumbers, int bonusNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto winningLottoNumbers, String bonusNumber) {
        int convertedBonusNumber = convertBonusNumber(bonusNumber);
        validateBonusNumberDuplicate(winningLottoNumbers, convertedBonusNumber);
        return new WinningLotto(winningLottoNumbers, convertedBonusNumber);
    }

    private static int convertBonusNumber(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 번호는 숫자만 입력할 수 있습니다.");
        }
        return Integer.parseInt(bonusNumber);
    }

    public static void validateBonusNumberDuplicate(Lotto winningLottoNumbers, int bonusNumber) {
        if (winningLottoNumbers.isContain(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public Map<Rank, Integer> getUserLottoScore(List<Lotto> userLottos) {
        Map<Rank, Integer> userLottoScore = new HashMap<>();
        for (Rank rank : Rank.values()) {
            userLottoScore.put(rank, 0);
        }
        userLottos.forEach(userLotto -> {
            Rank rank = Rank.of(winningLottoNumbers.getMatchedCount(userLotto), userLotto.isContain(bonusNumber));
            userLottoScore.put(rank, userLottoScore.get(rank) + 1);
        });
        userLottoScore.remove(Rank.NOTHING);
        return userLottoScore;
    }
}