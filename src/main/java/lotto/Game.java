package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public void HowMuch(){
        System.out.println("구입 금액을 입력해 주세요.");
        String price = Console.readLine();
        int LottoPrice = Integer.parseInt(price);
        for (int i=0; i<LottoPrice/1000; i++){
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            System.out.println(lottoNumbers);
        }
    }

    public void Bonus(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String Bonus = Console.readLine();
        int BonusNumber = Integer.parseInt(Bonus);
        System.out.println(BonusNumber);
    }

    public void Jackpot(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String str1 = Console.readLine();
        String[] words = str1.split(",");

        List<Integer> numbers = new ArrayList<>();

        for (String wo : words ){
            numbers.add(Integer.parseInt(wo));
        }
        Lotto lotto = new Lotto(numbers);
        System.out.println(lotto.getNumbers());
    }
}
