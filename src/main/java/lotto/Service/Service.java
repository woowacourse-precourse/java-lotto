package lotto.Service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Domain.Lotto;
import lotto.Domain.User;
import lotto.Domain.Winnings;
import lotto.Domain.WonLotto;
import lotto.Enum.Message;
import lotto.Enum.Ranking;

public class Service {
    public void startService()
    {
        System.out.println(Message.BUY_MONEY.getMessage());
        String stringMoney = Console.readLine();
        int myMoney = Integer.parseInt(stringMoney);
        User myLottoNumbers = new User(myLottos(myMoney),myMoney);
        myLottoNumbers.printLottosList();
        Lotto lottoAnswer = new Lotto(answer());
        int lottoBonus = bonus();
        List<WonLotto> wonLottos =myLottoNumbers.countLotto(lottoAnswer,lottoBonus);
        Winnings winnings = new Winnings();
        int myPay = winnings.pay(wonLottos);
        int sameCount[] = winnings.sameCount(wonLottos);
        System.out.println(sameCount);
        win(sameCount);
        System.out.println(Message.FINAL_FIRST.getMessage()+""+Math.round((myPay-myMoney)/myMoney*100)+Message.FINAL_LAST.getMessage());
    }
    public List<Lotto> myLottos(int money){
        List<Lotto> myLottoNumbers = new ArrayList<>();
        for(;money!=0;money-=1000)
        {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1,45,6);
            Lotto myLotto = new Lotto(lotto);
            myLottoNumbers.add(myLotto);
        }
        System.out.println(myLottoNumbers.size()+""+ Message.BUY_COUNT.getMessage());
        return myLottoNumbers;
    }
    public List<Integer> answer()
    {
        System.out.println(Message.LOTTO_NUMBERS.getMessage());
        String str = Console.readLine();
        List<Integer> lottoAnswer = Arrays.stream(str.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        return lottoAnswer;
    }
    public int bonus()
    {
        System.out.println(Message.BONUS_NUMBER.getMessage());
        String str = Console.readLine();
        int lottoBonus = Integer.parseInt(str);
        return lottoBonus;
    }
    public void win(int sameCount[])
    {
        System.out.println(Ranking.RANKING.getMessage());
        System.out.println(Ranking.NUMBER_FIVE.getMessage(sameCount[4]));
        System.out.println(Ranking.NUMBER_FOUR.getMessage(sameCount[3]));
        System.out.println(Ranking.NUMBER_THREE.getMessage(sameCount[2]));
        System.out.println(Ranking.NUMBER_TWO.getMessage(sameCount[1]));
        System.out.println(Ranking.NUMBER_ONE.getMessage(sameCount[0]));
    }
}
