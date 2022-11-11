package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator
{
    private volatile static LottoGenerator lottoGenerator;
    private final static Integer LOTTO_PRICE = 1000;

    private LottoGenerator(){}

    public List<Lotto> generateLotties(int price)
    {
        if(price % LOTTO_PRICE != 0) throw new IllegalArgumentException();

        List<Lotto> lotties = new ArrayList<>();

        int lottoCount = price / LOTTO_PRICE;
        for(int nowCreatedLottoCount = 0 ; nowCreatedLottoCount < lottoCount; nowCreatedLottoCount++)
        {
            List<Integer> lottoNumbers = generateLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            lotties.add(lotto);
        }

        return lotties;
    }

    private List<Integer> generateLottoNumbers()
    {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(Lotto.START_LOTTO_NUMBER,Lotto.END_LOTTO_NUMBER,Lotto.LOTTO_SIZE);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public static LottoGenerator getInstance()
    {
        if(lottoGenerator == null)
        {
            synchronized (LottoGenerator.class)
            {
                if(lottoGenerator == null)
                {
                    lottoGenerator = new LottoGenerator();
                }
            }
        }

        return lottoGenerator;
    }


}
