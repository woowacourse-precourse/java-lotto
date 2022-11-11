package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    // 구입금액 입력
    private static int inputBuyMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());

        if(money%1000!=0){
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 1000원 단위로 입력해야 합니다.");
        }
        System.out.println();

        return money;
    }

    // 로또 번호 생성
    private static List<Lotto> generateLottoNumbers(int lottoCnt){
        List<Lotto> userLottoNum = new ArrayList<>();
        for(int i=0; i<lottoCnt; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            userLottoNum.add(lotto);
        }

        return userLottoNum;
    }

    // 로또 번호 출력
    private static void printLottoNumbers(List<Lotto> userLottoNum){
        System.out.println(userLottoNum.size()+"개를 구매했습니다.");
        for(Lotto lotto : userLottoNum){
            lotto.printLottoNumbers();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 구입금액 입력
        int lottoCnt = inputBuyMoney()/1000;

        // 로또 번호 생성
        List<Lotto> userLottoNum = generateLottoNumbers(lottoCnt);

        // 로또 번호 출력
        printLottoNumbers(userLottoNum);
    }
}
