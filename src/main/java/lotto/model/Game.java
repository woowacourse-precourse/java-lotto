package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static final Integer price = 1000;
    public static final Integer maximumLottoNumber = 45;
    public static final Integer numberToDraw = 6;

    private Integer budget = 0;
    private List<Lotto> lottos = new ArrayList<>();
    private Lotto winningLotto;
    private Integer bonus;
    public Game(){

    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget){
        validateBudget(budget);
        this.budget = budget;
    }

    public void buyLotto(){
        lottos.add(new Lotto(generateLottoNumbers()));
    }

    public List<Lotto> getLottos(){
        return lottos;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public void setWinningLotto(List<Integer> winningNumbers){
        winningLotto = new Lotto(winningNumbers);
    }

    public Integer getBonus(){
        return bonus;
    }

    public void setBonus(Integer bonus){
        this.bonus = bonus;
    }

    private void validateBudget(Integer budget){
        if (budget % price != 0) throw new IllegalArgumentException();
    }

    private List<Integer> generateLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, maximumLottoNumber, numberToDraw);
    }





}
