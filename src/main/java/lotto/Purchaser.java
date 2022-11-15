package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Purchaser {

    private static final Long LOTTO_PRICE = 1_000L;

    public static long cost;
    public static List<Lotto> numbers = new ArrayList<>();
    public static long totalEarns;

    protected static void setCost(){
        System.out.println("구매 금액을 입력해 주세요");
        String inputMoney = Console.readLine();

        // 금액을 정확히 입력했는지 확인
        Validations.checkCostValid(inputMoney);

        cost = Long.parseLong(inputMoney);
        System.out.println();
    }

    protected static void receiveLottoNumbers(){
        for(int i = 0; i < cost / LOTTO_PRICE ; ++i){
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numbers.add(new Lotto(lottoNumber));
        }
    }

    public void printLottoNums(){
        System.out.println((cost/LOTTO_PRICE) + "개를 구매했습니다.");
        for(int i=0; i<numbers.size(); ++i){
            System.out.println(numbers.get(i).getNumbers());
        }
    }
}
