package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private Integer budget = 0;
    private List<Lotto> lottos = new ArrayList<>();
    private Integer totalProfit = 0;
    private Map<Rank, Integer> winningCount= new HashMap<>();


    public User(){

    }

    public void setBudget(Integer budget){
        validateBudget(budget);
        this.budget = budget;
    }

    public Integer getBudget() {
        return budget;
    }

    public void buyLotto(Integer maximum){
        while (lottos.size() < maximum){
            lottos.add(new Lotto(generateLottoNumbers()));
        }
    }

    public List<Lotto> getLottos(){
        return lottos;
    }

    private void validateBudget(Integer budget){
        if (budget % Game.price != 0) throw new IllegalArgumentException();
    }

    private List<Integer> generateLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, Game.maximumLottoNumber, Game.numberToDraw);
    }

    public Map<Rank, Integer> getWinningCount(){
        return winningCount;
    }

    public Double getProfitRate(){
        return (1.0) * totalProfit / budget;
    }

    public void confirmWinning(List<Integer> winningNumbers, Integer bonus){
        for (Lotto lotto : lottos){
            Rank rank = lotto.getRank(winningNumbers, bonus);
            winningCount.put(rank, winningCount.getOrDefault(rank, 0) + 1);
            totalProfit += rank.getAmount();
        }
    }





}
