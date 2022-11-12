package lotto;

import java.util.*;

public class LottoMain
{
    camp.nextstep.edu.missionutils.Console console;
    //lottery issuance
    public List<Integer> issueLotto()
    {
        List<Integer> lottoList =
                camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(1, 45, 6);
        lottoList.sort(Comparator.naturalOrder());
        System.out.println(lottoList);

        return lottoList;
    }

    //draw lotto and check Exception
    public List<Integer> getLottoAnswer()
    {
        List<Integer> lottoAnswer = drawLotto();
        checkRange(lottoAnswer);
        checkDuplicated(lottoAnswer);

        return lottoAnswer;
    }

    //lottery draw
    private List<Integer> drawLotto()
    {
        System.out.println("당첨 번호를 입력해 주세요.");
        String lotto = console.readLine();
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String lottoBonus = console.readLine();

        List<Integer> lottoAnswer = new ArrayList<>();
        for(String number : lotto.split(","))
            lottoAnswer.add(Integer.parseInt(number));
        lottoAnswer.add(Integer.parseInt(lottoBonus));

        return lottoAnswer;
    }

    //check the lottoNumber range
    private void checkRange(List<Integer> lottoAnswer)
    {
        for(int number : lottoAnswer)
        {
            if(number < 1 || number > 45)
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    //check the lottoNumber duplicated
    private void checkDuplicated(List<Integer> lottoAnswer)
    {
        Set<Integer> numSet = new HashSet<>(lottoAnswer);

        if(numSet.size()!= lottoAnswer.size())
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복 되면 안됩니다.");
    }
}
