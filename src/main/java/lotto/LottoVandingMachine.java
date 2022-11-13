package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoVandingMachine
{
    camp.nextstep.edu.missionutils.Console console;
    LottoMain lotto = new LottoMain();
    int issuedLottoCount = 0;

    //돈 입력
    private void inputMoney()
    {
        int money = Integer.parseInt(console.readLine());
        issuedLottoCount = money / 1000;

        if(money % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 돈은 1000원 단위로 입력해야 합니다.");
    }

    //로또 구매
    public List<List<Integer>> buyLotto()
    {
        inputMoney();

        int i = issuedLottoCount;
        List<List<Integer>> issuedLottoList = new ArrayList<>();
        while(i > 0)
        {
            issuedLottoList.add(lotto.issueLotto());
            i--;
        }

        return issuedLottoList;
    }
}
