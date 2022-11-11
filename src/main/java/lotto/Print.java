package lotto;

import java.util.Arrays;
import java.util.List;

public class Print {

    public static void PrintUserPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void PrintUserPurchaseLottoAmount(Integer lottoMoney){
        System.out.println(lottoMoney+"개를 구매했습니다.");
    }

    public static void PrintUserLottoNumbers(UserLotto userLottoes) {

        for (Lotto l : userLottoes.getUserLottoes()){
            List<Integer> numbers = l.getNumbers();
            System.out.println(Arrays.toString(numbers.toArray()));
        }
    }

    public static void PrintTypingWinLotto(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }
}
