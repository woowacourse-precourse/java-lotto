package lotto;

import java.util.*;

public class Result {
    Map<String, Integer> prizeRecord = new LinkedHashMap<>() {
        {
            put("FIFTH", 0);
            put("FOURTH", 0);
            put("THIRD", 0);
            put("SECOND", 0);
            put("FIRST", 0);
        }
    };
    List<Lotto> lottoTickets;
    WinningTicket winningTicket;
    int prizeMoney = 0;

    void getResult(List<Lotto> lottoTickets, WinningTicket winningTicket) {
        this.lottoTickets = lottoTickets;
        this.winningTicket = winningTicket;

        matchAllLotto();
        printPrizeRecord();
        setPrizeMoney();
    }

    private void matchAllLotto() {
        for (Lotto lotto : lottoTickets) {
            matchLotto(lotto);
        }
    }

    private void matchLotto(Lotto lotto) {
        int rightNumberCount = matchNumbers(lotto);
        boolean hasBonus = matchBonus(lotto);
        setPrizeRecord(rightNumberCount, hasBonus);
    }

    private int matchNumbers(Lotto lotto) {
        int rightNumberCount = 0;

        for (Integer winNumber : winningTicket.numbers) {
            if (lotto.matchNumber(winNumber)) {
                rightNumberCount++;
            }
        }
        return rightNumberCount;
    }

    Boolean matchBonus(Lotto lotto) {
        return lotto.matchNumber(winningTicket.bonusNumber);
    }

    void setPrizeRecord(int rightNumberCount, Boolean hasBonus) {
        if (rightNumberCount == 6) {
            prizeRecord.put("FIRST", prizeRecord.get("FIRST") + 1);
        } else if (rightNumberCount == 5 && hasBonus) {
            prizeRecord.put("SECOND", prizeRecord.get("SECOND") + 1);
        } else if (rightNumberCount == 5) {
            prizeRecord.put("THIRD", prizeRecord.get("THIRD") + 1);
        } else if (rightNumberCount == 4) {
            prizeRecord.put("FOURTH", prizeRecord.get("FOURTH") + 1);
        } else if (rightNumberCount == 3) {
            prizeRecord.put("FIFTH", prizeRecord.get("FIFTH") + 1);
        }
    }

    void printPrizeRecord() {
        System.out.println("\n당첨 통계\n---"
                + "\n3개 일치 (5,000원) - " + prizeRecord.get("FIFTH") + "개"
                + "\n4개 일치 (50,000원) - " + prizeRecord.get("FOURTH") + "개"
                + "\n5개 일치 (1,500,000원) - " + prizeRecord.get("THIRD") + "개"
                + "\n5개 일치, 보너스 볼 일치 (30,000,000원) - " + prizeRecord.get("SECOND") + "개"
                + "\n6개 일치 (2,000,000,000원) - " + prizeRecord.get("FIRST") + "개");
    }

    void setPrizeMoney() {
        prizeMoney += 2000000000 * prizeRecord.get("FIRST");
        prizeMoney += 30000000 * prizeRecord.get("SECOND");
        prizeMoney += 1500000 * prizeRecord.get("THIRD");
        prizeMoney += 50000 * prizeRecord.get("FOURTH");
        prizeMoney += 5000 * prizeRecord.get("FIFTH");
    }
}
