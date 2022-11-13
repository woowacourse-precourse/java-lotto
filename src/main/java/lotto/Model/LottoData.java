package lotto.Model;

import java.util.HashMap;
import java.util.List;

public class LottoData{
    public enum LottoPrize{
        FIRSTPRIZE(2000000000),
        SECONDPRIZE(30000000),
        THRIDPRIZE(1500000),
        FOURTHPRIZE(50000),
        FIFTHPRIZE(5000);
        private final int value;
        LottoPrize(int value) {
            this.value = value;
        }
        public int getValue(){return value;}
    }
    private HashMap<Integer, Integer> numberOfWins = new HashMap<Integer, Integer>();
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
    public Lotto getWinnerNumber(){return winnerNumber;}

    public void setBonusNumber(int bonusNumber){
        this.bonusNumber = bonusNumber;
    }
    public int getBonusNumber(){return bonusNumber;}
    public List<Lotto> getLottos(){
        return lottos;
    }
}
