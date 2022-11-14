package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto.Lotto;
import lotto.Lotto.LottoInfo;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator
{
    private volatile static LottoGenerator lottoGenerator;

    private LottoGenerator(){}

    public List<Lotto> generateLotties(int price)
    {
        if(price % LottoInfo.LOTTO_PRICE != 0) throw new IllegalArgumentException();

        List<Lotto> lotties = new ArrayList<>();
        int lottoCount = price / LottoInfo.LOTTO_PRICE;
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
        List<Integer> lottoNumbers =
                Randoms.pickUniqueNumbersInRange(LottoInfo.START_LOTTO_NUMBER,LottoInfo.END_LOTTO_NUMBER,LottoInfo.LOTTO_SIZE);
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
