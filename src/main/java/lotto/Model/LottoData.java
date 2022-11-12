package lotto.Model;

import java.util.List;

public class LottoData{
    private int countOfLotto;
    private List<Lotto> lottos;

    private Lotto winnerNumber;

    private int bonusNumber;
    public void setCountOfLotto(int numberOfLotto){
        this.countOfLotto = numberOfLotto;
    }

    public int getCountOfLotto(){
        return countOfLotto;
    }
    public void setLottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public void setWinnerNumber(Lotto winnerNumber){
        this.winnerNumber = winnerNumber;
    }
    public List<Lotto> getLottos(){
        return lottos;
    }
}
