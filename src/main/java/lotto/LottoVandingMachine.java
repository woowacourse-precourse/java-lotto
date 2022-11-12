package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoVandingMachine
{
    camp.nextstep.edu.missionutils.Console console;

    LottoMain lotto = new LottoMain();

    //돈 입력
    private int inputMoney()
    {
        int money = Integer.parseInt(console.readLine());
        int lottoCount = money / 1000;

        if(money % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 돈은 1000원 단위로 입력해야 합니다.");

        return lottoCount;
    }

    //로또 구매
    public List<List<Integer>> buyLotto()
    {
        int lottoCount = inputMoney();
        List<List<Integer>> issuedLottoList = new ArrayList<>();
        while(lottoCount > 0)
        {
            issuedLottoList.add(lotto.issueLotto());
            lottoCount--;
        }

        return issuedLottoList;
    }
}
