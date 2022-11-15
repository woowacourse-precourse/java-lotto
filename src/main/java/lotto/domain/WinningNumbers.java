package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final String ERROR_ALREADY_EXIST = "[ERROR]이미 존재하는 수 입니다.";

    private final Lotto lotto;
    private final LottoTickets lottoTickets;
    private final int bonusNumber;

    public static List<List<Integer>> resultlotto;
    public static List<Integer> userLottoNumbers;

    public WinningNumbers(Lotto lotto, LottoTickets lottoTickets, int bonusNumber) {
        try {
            validate(lotto,bonusNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        this.bonusNumber = bonusNumber;
        this.lotto = lotto;
        this.lottoTickets = lottoTickets;

    }

    public RankingResult createRanking() {
        resultlotto = lottoTickets.getLottoTicket();
        userLottoNumbers = lotto.getLottoNumbers();
        RankingResult rankingResult = new RankingResult();
        boolean bonus;
        for (int i = 0; i < resultlotto.size(); i++) {
            int count = 0;
            bonus = containBonusNumber(resultlotto.get(i), bonusNumber);
            for (int j = 0; j < userLottoNumbers.size(); j++) {
                if (resultlotto.get(i).contains(userLottoNumbers.get(j))) {
                    count++;
                }
            }
            rankingResult.update(Ranking.getRanking(bonus, count));
        }
        return rankingResult;
    }

    public void validate(Lotto lotto,int bonusNumber) {
        if (lotto.getLottoNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_ALREADY_EXIST);
        }
    }

    public boolean containBonusNumber(List<Integer> resultlotto, int bonusNumber) {
        if (!resultlotto.contains(bonusNumber)) {
            return false;
        }
        return true;
    }
}
