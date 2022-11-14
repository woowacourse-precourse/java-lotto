package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Enum.ErrorCode;

import java.util.ArrayList;
import java.util.List;

public class Player {

    int money ;
    List<Lotto> lottos;

    public Player(){
        this.lottos = new ArrayList<>();
    }

    public Player(int money){
        this.lottos = new ArrayList<>(buyLottos(howManyLotto(money)));
        this.money = money;
    }

    public int howManyLotto(int money){
        if(money%1000!=0){
            throw new IllegalArgumentException(ErrorCode.NOT_DIVIDE_1000.getMessage());
        }
        return money/1000;
    }

    public List<Lotto> buyLottos(int moneyCount){

        List<Lotto> sampleLottos = new ArrayList<>();
        for (int i = 0; i < moneyCount; i++) {
            List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Lotto lotto = new Lotto(randomNumbers);
            sampleLottos.add(lotto);
        }
        return sampleLottos;
    }

    public void printLottos(){
        for(Lotto lotto : lottos){
            lotto.printLotto();
        }
    }

    public int[] winningLottoMatching(List<Integer> winningNumbers,int bonusNumber){

        int[] matchNumber = new int[8];
        for (Lotto lotto : lottos){
            int index = lotto.countMatchNumber(winningNumbers);
            matchNumber[index]++;
            if(index==5&&lotto.hasBonusNumber(bonusNumber)){
                matchNumber[7]++;
                matchNumber[5]--;
            }
        }
        return matchNumber;
    }

}
