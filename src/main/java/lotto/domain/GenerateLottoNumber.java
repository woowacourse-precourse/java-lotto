package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class GenerateLottoNumber {
    private final List<Lotto> LOTTONUMBER;

    public GenerateLottoNumber(int count){
        LOTTONUMBER = generateLottoNumber(count);
        lottoErrorTest();
    }

    private List<Lotto> generateLottoNumber (int count) {
        List<Lotto> line = new ArrayList<>();
        for(int i=0; i<count; i++){
            line.add(new Lotto(buyLottoNumbers()));
        }
        return line;
    }

    private List<Integer> buyLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private void lottoErrorTest (){
        for(Lotto e: LOTTONUMBER){
        }
    }

    public List<Lotto> getLottoNumber(){
        return LOTTONUMBER;
    }

}
