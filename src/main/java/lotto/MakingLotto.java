package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class MakingLotto {

    public int getLottoCount(int money){
        int lottoCount=money/1000;
        return lottoCount;
    }

    public Lotto makeLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        Lotto lotto=new Lotto(numbers);
        return lotto;
    }

    public List<Lotto> getAllLotto(int LottoCount){
        List<Lotto> allLotto=new ArrayList<>();
        for(int index=0;index<LottoCount;index++){
            allLotto.add(makeLotto());
        }
        return allLotto;
    }

    public Lotto getWinningLotto(String winningLotto){
        String[] lottoNum=winningLotto.split(",");
        List<Integer> winnigLottoNumber=new ArrayList<>();
        for(int index=0;index<lottoNum.length;index++){
            int number=Integer.parseInt(lottoNum[index]);
            winnigLottoNumber.add(number);
        }
        Lotto lotto=new Lotto(winnigLottoNumber);
        return lotto;
    }

}
