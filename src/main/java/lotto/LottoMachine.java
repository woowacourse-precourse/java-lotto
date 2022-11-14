package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    final int firstBallNum = 1;
    final int LASTBALLNUM = 45;
    final int COUNT = 6;

    List<Object> totalLotto;

    Buyer buyer = new Buyer(Integer.parseInt(Console.readLine()));


    public List<Object> makeLotto (int lottoAmount){
        totalLotto = new ArrayList<>();
        for(int i =0 ; i<lottoAmount ; i++){
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(firstBallNum, LASTBALLNUM, COUNT));
        totalLotto.add(lotto);
        }
        return totalLotto;
    }
    public void outPutLottoNum (List<Object> totalLotto){
        for(Object lottoNum : totalLotto){
            System.out.println(lottoNum);
        }
    }

}