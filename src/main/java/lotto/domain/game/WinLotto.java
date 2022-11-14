package lotto.domain.game;

import lotto.domain.player.Player;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;
import static lotto.domain.game.Lotto.LOTTO_BONUS_COUNT;
import static lotto.domain.game.Lotto.LOTTO_COUNT;

public class WinLotto {
    private final List<Integer> winningNumber;
    private final int bonusNumber;
    private final List<List<Integer>> lottoTickets;
    private final long userMoney;
    private Map<Ranking, Integer> winningResult = new EnumMap<>(Ranking.class);

    public WinLotto(Lotto lotto, Player player){
        List<Integer> tempWinningBonusLotto = lotto.getLotto();
        int lottoBonusNumberIndex = tempWinningBonusLotto.size()-1;
        bonusNumber = tempWinningBonusLotto.get(lottoBonusNumberIndex);
        tempWinningBonusLotto.remove(lottoBonusNumberIndex);
        winningNumber = tempWinningBonusLotto;
        this.lottoTickets = player.getLottoTickets();
        this.userMoney = player.getMoney();
        winningResult = initWinningResult();
    }

    private Map<Ranking, Integer> initWinningResult() {
        return Arrays.stream(Ranking.values()).collect(toMap(ranking -> ranking, ranking -> 0));
    }

    public int countMatchWinningNumber(List<Integer> lottoTicket){
        return (int) lottoTicket.stream()
                .filter(winningNumber::contains)
                .count();
    }

    public boolean isBonusNumberMatch(List<Integer> lottoTicket){
        return lottoTicket.contains(bonusNumber);
    }

    public void checkLotto(){
        for(List<Integer> lottoTicket : lottoTickets){
            int count = countMatchWinningNumber(lottoTicket);
            boolean bonus = false;

            if (count == LOTTO_COUNT - LOTTO_BONUS_COUNT){
                bonus = isBonusNumberMatch(lottoTicket);
            }
            Ranking ranking = Ranking.findRanking(count, bonus);

            winningResult.put(ranking, winningResult.get(ranking) + 1);
        }
    }

    public long calculatePrizeSum(){
        return winningResult.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public double calculateReturnRate(){
        long sum = calculatePrizeSum();
        double returnRate = sum / (double)userMoney * 100;

        return Double.parseDouble(String.format("%.1f", returnRate));
    }

    public Map<Ranking, Integer> getWinningResult() {
        return winningResult;
    }
}
