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

    private int firstCount;
    private int secondCount;
    private int thirdCount;
    private int fourthCount;
    private int fifthCount;

    public LottoAnalyzer(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        this.lottoTickets = lottoTickets;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.firstCount = 0;
        this.secondCount = 0;
        this.thirdCount = 0;
        this.fourthCount = 0;
        this.fifthCount = 0;
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
