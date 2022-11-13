package lotto;// @ author ninaaano

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private static List<Lotto> lottoNumber;
    private static int lottoCount;

    public LottoGame() {
        lottoNumber = new ArrayList<>();
        this.lottoCount = lottoCount;
    }

    private List<Integer> createLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private List<Lotto> createLotto(){
        List<Integer> lottoNumbers = createLottoNumber();
        for(int i =0; i<lottoCount; i++){
            if(!lottoNumber.contains(lottoNumbers)){
                lottoNumber.add(new Lotto(lottoNumbers));
            }
        }
        return lottoNumber;
    }

    public static int getLottoCount() {
        return lottoCount;
    }
}
