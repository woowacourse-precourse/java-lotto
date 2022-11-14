package lotto.domain;

import java.util.Map;

public class LottoCount {
    private int first;
    private int second;
    private int third;
    private int fourth;
    private int fifth;
    private final Map<Lotto, Integer> rank;
    private static final String LINE_FEED = "\n";

    public LottoCount(Map<Lotto, Integer> rank, int bonusNumber) {
        this.rank = rank;
        rank.entrySet().forEach(lottoTicket -> countLottoCondition(bonusNumber, lottoTicket));
    }

    private void countLottoCondition(int bonusNumber, Map.Entry<Lotto, Integer> lottoTicket) {
        if (isRightLottoNumberCount(lottoTicket, 6)) {
            first++;
        }
        if (isRightLottoNumberCount(lottoTicket, 5) && isBonusNumberContain(lottoTicket, bonusNumber)) {
            second++;
        }
        if (isRightLottoNumberCount(lottoTicket, 5) && !isBonusNumberContain(lottoTicket, bonusNumber)) {
            third++;
        }
        if (isRightLottoNumberCount(lottoTicket, 4)) {
            fourth++;
        }
        if (isRightLottoNumberCount(lottoTicket, 3)) {
            fifth++;
        }
    }

    private static boolean isRightLottoNumberCount(Map.Entry<Lotto, Integer> lottoTicket, int rightNumber) {
        return lottoTicket.getValue() == rightNumber;
    }

    private static boolean isBonusNumberContain(Map.Entry<Lotto, Integer> lottoTicket, int bonusNumber) {
        return lottoTicket.getKey().getNumbers().contains(bonusNumber);
    }

    public String getYield() {
        return String.format("%.1f", ((double) this.first * 2000000000 +
                this.second * 30000000 +
                this.third * 1500000 +
                this.fourth * 50000 +
                this.fifth * 5000) / (this.rank.size() * 1000) * 100);
    }

    @Override
    public String toString() {
        return "3개 일치 (5,000원) - " + fifth + "개" + LINE_FEED +
                "4개 일치 (50,000원) - " + fourth + "개" + LINE_FEED +
                "5개 일치 (1,500,000원) - " + third + "개" + LINE_FEED +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + second + "개" + LINE_FEED +
                "6개 일치 (2,000,000,000원) - " + first + "개";
    }
}