package lotto.domain;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

public class BankTeller {
    private final DecimalFormat MONETARY_FORMAT = new DecimalFormat("###,###");
    private final String STATIC_FORMAT = "%s (%s원) - %d개";

    private PrizeCalculator prizeCalculator;
    private LottoReader lottoReader;

    public BankTeller(PrizeCalculator prizeCalculator, LottoReader lottoReader) {
        this.prizeCalculator = prizeCalculator;
        this.lottoReader = lottoReader;
    }

    public void givePrizeTo(Customer customer, LottoCompany lottoCompany) {
        List<LottoRank> lottoRanks = lottoReader.rank(customer.getLottos(), lottoCompany.getWinningNumbers(),
                lottoCompany.getBonusNumber());
        int prize = prizeCalculator.getPrize(lottoRanks);
        int fee = customer.getLottos().size()*Constants.LOTTO_PRICE;
        double returnOfInvest = prizeCalculator.getROI(prize, fee);
        guideWinningBreakdown(lottoRanks, returnOfInvest);
        customer.earn(prize);
    }

    private void guideWinningBreakdown(List<LottoRank> lottoRanks, double roi) {
        System.out.println("당첨 통계\n---");
        for (LottoRank rank : LottoRank.values()) {
            int count = Collections.frequency(lottoRanks, rank);
            System.out.println(String.format(STATIC_FORMAT,
                    rank.getCondition(), MONETARY_FORMAT.format(rank.getPrize()), count));
        }
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", roi * 100));
    }
}
