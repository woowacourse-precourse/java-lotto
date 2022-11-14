package lotto;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Buy{
    public List<List<Integer>> quickPicks(int count){
        List<List<Integer>> lottoBundle=new ArrayList<>();
        for(int i=0;i<count;i++){
            lottoBundle.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return lottoBundle;
    }
}
