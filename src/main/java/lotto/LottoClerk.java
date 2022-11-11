package lotto;

import java.util.ArrayList;

public class LottoClerk {
    public void sayBuyLotto(int lottoCount)
    {
        System.out.println(lottoCount+"개를 구매했습니다.");
    }
    public void sayLottoReceipt(ArrayList<Lotto> lottoReceipt)
    {
        for(Lotto l:lottoReceipt)
        {
            System.out.println(l.getLottoText());
        }
    }
}
