package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber {
    private int lottoAmount;
    private List<Lotto> lottoNumber = new ArrayList<>();

    public void LottoBuyPriceInput(){
        System.out.println("구입금액을 입력해 주세요.");
        String buyPrice = Console.readLine();
        System.out.println();
        int lottoNum = Integer.parseInt(buyPrice) / 1000;
        lottoAmount = lottoNum;
        System.out.println(lottoNum + "개를 구매했습니다.");
    }

    public void InputLottoNumber(){
        for(int i = 0; i < lottoAmount; i++){
            lottoNumber.add(autoGenerate());
        }
        for(Lotto lotto : lottoNumber){
            System.out.println(lotto.getNumbers());
        }
    }

    private Lotto autoGenerate(){
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1,45,6));
        return new Lotto(numbers);
    }
}
