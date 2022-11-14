package lotto.domain;

import java.util.*;

public class WinningResult {
    private final Map<Rank, Integer> winningResult = new EnumMap<Rank, Integer>(Rank.class);
    private final LottoTicket tickets;
    private final Lotto winningLottoNumbers;
    private final LottoBonus bonus;

    public WinningResult(LottoTicket tickets, Lotto winningLottoNumbers, LottoBonus bonus){
        this.tickets = tickets;
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonus = bonus;
        putInit();
        putValues();
    }

    public Map<Rank, Integer> getWinningResult() {
        return winningResult;
    }

    public long prizeSum(){
        return winningResult.entrySet().stream().
                mapToLong(entry -> entry.getKey().multiple(entry.getValue())).sum();
    }

    public float profit(int money){
        long prizeSum = prizeSum();
        return ((float) prizeSum / (float) money) * 100;
    }

    private void putInit(){
        Rank[] values = Rank.values();
        for (Rank value : values) {
            winningResult.put(value, 0);
        }
    }

    private void putValues(){
        List<Rank> ranks = calculateRank();
        for (Rank rank : ranks) {
            winningResult.put(rank, winningResult.getOrDefault(rank, 0) + 1);
        }
    }

    private List<Rank> calculateRank(){
        List<Integer> sameLottoNumbers = tickets.countSameLottoNumbers(winningLottoNumbers);
        List<Boolean> sameLottoBonus = tickets.checkSameLottoBonus(bonus.getBonus());
        List<Rank> ranks = new ArrayList<>();

        for (int i = 0; i < tickets.getTickets(); i++){
            ranks.add(Rank.getRanking(sameLottoNumbers.get(i), sameLottoBonus.get(i)));
        }

        return ranks;
    }
}
