package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoVandingMachine
{
    private int issuedLottoCount = 0;

    //돈 입력
    public void inputMoney()
    {
        String money = Console.readLine();

        if(!money.matches("[0-9]+"))
            throw new IllegalArgumentException("[ERROR] 돈은 숫자로만 입력해야 합니다.");
        issuedLottoCount = Integer.parseInt(money) / 1000;

        if(Integer.parseInt(money) % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 돈은 1000원 단위로 입력해야 합니다.");
    }

    //로또 발행
    public List<Integer> issueLotto()
    {
        List<Integer> numList =
                Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> lottoList = new ArrayList<>();
        for(int num : numList)
            lottoList.add(num);
        Collections.sort(lottoList);
        System.out.println(lottoList);

        return lottoList;
    }

    //발행한 로또들 반환
    public List<Lotto> getIssuedLottoList()
    {
        inputMoney();

        System.out.println(issuedLottoCount + "개를 구매했습니다.");

        List<Lotto> lottoList = new ArrayList<>();
        int i = issuedLottoCount;
        while(i > 0)
        {
            lottoList.add(new Lotto(issueLotto()));
            i--;
        }
        return lottoList;
    }

    //로또 추첨
    public List<Integer> drawLotto()
    {
        System.out.println("당첨 번호를 입력해 주세요.");
        String lotto = Console.readLine();
        System.out.println(lotto);
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String lottoBonus = Console.readLine();
        System.out.println(lottoBonus);

        List<Integer> lottoAnswer = new ArrayList<>();
        for(String number : lotto.split(","))
            lottoAnswer.add(Integer.parseInt(number));
        lottoAnswer.add(Integer.parseInt(lottoBonus));

        return lottoAnswer;
    }

    public int getIssuedLottoCount() {
        return issuedLottoCount;
    }
}
