package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LottoResult {
    private final Map<Rank, Integer> lottoResult;

    public LottoResult(LottoTicket lottoTicket, LottoWinningNumber lottoWinningNumber) {
        this.lottoResult = drawLotto(lottoTicket, lottoWinningNumber);
        lottoResult.remove(Rank.LOSE);
    }

    public Map<Rank, Integer> getLottoResult() {
        return this.lottoResult;
    }

    public double getTotalPrize() {
        double totalPrize = 0;

        for (Entry<Rank, Integer> rank : lottoResult.entrySet()) {
            String stripedPrize = rank.getKey().prize().replaceAll(",","");
            int prize = Integer.parseInt(stripedPrize);
            totalPrize += prize * rank.getValue();
        }
        return totalPrize;
    }

    private static Map<Rank, Integer> drawLotto(LottoTicket lottoTicket, LottoWinningNumber lottoWinningNumber) {
        Map<Rank, Integer> lottoResult = initLotto();
        int winningNumberAmount;
        boolean hasBonusNumber;
        for (Lotto lotto : lottoTicket.getLottoTicket()) {
            winningNumberAmount = getWinningNumberAmount(lotto, lottoWinningNumber);
            hasBonusNumber = hasBonus(lotto, lottoWinningNumber.getBonusNumber());
            lottoResult.put(Rank.getRank(winningNumberAmount, hasBonusNumber),
                    lottoResult.get(Rank.getRank(winningNumberAmount, hasBonusNumber))+ 1);
        }
        return lottoResult;
    }

    private static Map<Rank, Integer> initLotto() {
        Map<Rank, Integer> lottoResult = new EnumMap<>(Rank.class);
        for(Rank rank: Rank.values()) {
            lottoResult.put(rank, 0);
        }
        return lottoResult;
    }

    private static boolean hasBonus(Lotto lotto, int bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return lottoNumbers.contains(bonusNumber);
    }

    private static int getWinningNumberAmount(Lotto lotto, LottoWinningNumber lottoWinningNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> lottoWinningNumbers = lottoWinningNumber.getWinningNumbers();
        int winningNumberAmount = 0;
        for (int lottoNumber : lottoNumbers) {
            if (lottoWinningNumbers.contains(lottoNumber)) {
                winningNumberAmount++;
            }
        }
        return winningNumberAmount;
    }
}
