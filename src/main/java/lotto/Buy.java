package lotto;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Buy{
    private int startInclusive;
    private int endInclusive;
    private int range;

    public Buy(int startInclusive, int endInclusive, int range) {
        this.startInclusive=startInclusive;
        this.endInclusive=endInclusive;
        this.range=range;
    }

    public List<List<Integer>> quickPicks(int count){
        List<List<Integer>> lottoBundle=new ArrayList<>();
        for(int i=0;i<count;i++){
            lottoBundle.add(Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, range));
        }
        return lottoBundle;
    }
}
