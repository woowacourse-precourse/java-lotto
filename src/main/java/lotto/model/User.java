package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Integer budget = 0;
    private List<Lotto> lottos = new ArrayList<>();

    public User(){

    }

    public void setBudget(Integer budget){
        validateBudget(budget);
        this.budget = budget;
    }

    public Integer getBudget() {
        return budget;
    }

    public void buyLotto(){
        lottos.add(new Lotto(generateLottoNumbers()));
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
}
