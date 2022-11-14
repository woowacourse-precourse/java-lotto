package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gambler {
    public int CurrentMoney;
    int amountOfLotto;
    public List<Lotto> gamblerLotto;

    public Gambler(int moneyInput){
        this.CurrentMoney = moneyInput;
        this.amountOfLotto = this.CurrentMoney / 1_000;
        this.gamblerLotto = new ArrayList<>(this.amountOfLotto);
    }

    public void buyingLotto(){
        this.CurrentMoney = 0;
        for (int cnt=0;cnt<this.amountOfLotto;cnt++){
            List<Integer> currentLottoNumbers = generateLottoNumbers();
            this.gamblerLotto.add(new Lotto(currentLottoNumbers));
        }
    }

    public List<Integer> generateLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }

    public void printAllLotto(){
        for (Lotto l:this.gamblerLotto) {
            l.printLotto();
        }
    }

    public List<Integer> checkAllLotto(List<Integer> winningNumbers){
        List<Integer> allLottoResult = new ArrayList<>(Arrays.asList(0,0,0,0,0));
        for (Lotto currentLotto : this.gamblerLotto){
            int place = currentLotto.compareWithWinningNumbers(winningNumbers);
            System.out.println(place);
            allLottoResult.set(place, allLottoResult.get(place) + 1);
        }
        return allLottoResult;
    }

}
