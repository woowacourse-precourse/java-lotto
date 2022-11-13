package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.Util;

public class LottoAnalyzer {

    private final List<Lotto> lottoTickets;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    private int firstCount = 0;
    private int secondCount = 0;
    private int thirdCount = 0;
    private int fourthCount = 0;
    private int fifthCount = 0;

    public LottoAnalyzer(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        this.lottoTickets = lottoTickets;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        compareLottoTickets();
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
            firstCount++;
        }
        if (lottoChecker.size() == 7) {
            if (lottoChecker.contains(bonusNumber)) {
                secondCount++;
            }
            if (!lottoChecker.contains(bonusNumber)) {
                thirdCount++;
            }
        }
        if (lottoChecker.size() == 8) {
            fourthCount++;
        }
        if (lottoChecker.size() == 9) {
            fifthCount++;
        }
    }

    public int getFirstCount() {
        return firstCount;
    }

    public int getSecondCount() {
        return secondCount;
    }

    public int getThirdCount() {
        return thirdCount;
    }

    public int getFourthCount() {
        return fourthCount;
    }

    public int getFifthCount() {
        return fifthCount;
    }
}
