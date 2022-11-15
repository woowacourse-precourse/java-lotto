package lotto.domain;

import lotto.domain.info.Rank;

import java.util.List;
import java.util.Set;

public class Player {
    private int amount;
    private int bonus;
    private Set<Integer> playersLottoNumber;
    private List<Lotto> lottos;
    private List<Rank> results;

    public Player() {
    }

    public Player(List<Lotto> lottos, int amount, Set<Integer> playersLottoNumber, int bonus, List<Rank> results) {
        this.lottos = lottos;
        this.amount = amount;
        this.playersLottoNumber = playersLottoNumber;
        this.bonus = bonus;
        this.results = results;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Set<Integer> getPlayersLottoNumber() {
        return playersLottoNumber;
    }

    public void setPlayersLottoNumber(Set<Integer> playersLottoNumber) {
        this.playersLottoNumber = playersLottoNumber;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public List<Rank> getResults() {
        return results;
    }

    public void setResults(List<Rank> results) {
        this.results = results;
    }
}
