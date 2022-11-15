package lotto.model;

import java.util.List;

public class BankTeller {
    public List<LottoRank> checkLottos(Customer customer, LottoCompany lottoCompany) {
        return LottoReader.rank(customer.getLottos(), lottoCompany.getWinningNumbers(),
                lottoCompany.getBonusNumber());
    }

    public int calculatePrize(List<LottoRank> lottoRanks) {
        return lottoRanks.stream()
                .map(lottoRank -> lottoRank.getPrize())
                .mapToInt(Integer::intValue).sum();
    }

    public double calculateROI(int prize, int fee) {
        return (double) prize / (double) fee;
    }
}
