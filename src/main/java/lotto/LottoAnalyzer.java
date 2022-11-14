package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.price.PrizeMoney;
import lotto.util.Util;

public class LottoAnalyzer {

    private final List<Lotto> lottoTickets;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final int[] rankCount = new int[5];
    private int wholePrizeMoney = 0;

    public LottoAnalyzer(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        this.lottoTickets = lottoTickets;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        compareLottoTickets();
        addPrizeMoney();
    }


    public void compareLottoTickets() {
        for (Lotto lottoTicket : lottoTickets) {
            List<Integer> joinedNumbers = Util.joinIntegerList(lottoTicket.getNumbers(),
                winningNumbers);
            Set<Integer> lottoChecker = new HashSet<>(joinedNumbers);
            checkNumbers(lottoChecker);
        }
    }

    private void checkNumbers(Set<Integer> lottoChecker) {
        if (lottoChecker.size() == 6) {
            rankCount[4]++;
        }
        if (lottoChecker.size() == 7) {
            if (lottoChecker.contains(bonusNumber)) {
                rankCount[3]++;
            }
            if (!lottoChecker.contains(bonusNumber)) {
                rankCount[2]++;
            }
        }
        if (lottoChecker.size() == 8) {
            rankCount[1]++;
        }
        if (lottoChecker.size() == 9) {
            rankCount[0]++;
        }
    }

    public int[] getRankCount() {
        return rankCount;
    }

    public int getWholePrizeMoney() {
        return wholePrizeMoney;
    }

    private void addPrizeMoney() {
        PrizeMoney prizeMoney[] = PrizeMoney.values();
        for (int i = 0; i < 5; i++) {
            wholePrizeMoney += prizeMoney[i].getValue() * rankCount[i];
        }
    }
}
