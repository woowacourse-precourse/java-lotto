package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {
    private LottoGenerator lottoGenerator = new LottoGenerator();

    public List<Lotto> inputLottoNumber(int lottoAmount){
        List<Lotto> lottoNumber = new ArrayList<>();

        for(int i = 0; i < lottoAmount; i++){
            lottoNumber.add(lottoGenerator.autoGenerate());
        }

        for(Lotto lotto : lottoNumber){
            System.out.println(lotto.getNumbers());
        }
        return lottoNumber;
    }
}
