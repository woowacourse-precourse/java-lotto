package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int lottoNum=userInputMoney();

        List<Lotto> lottos=makeLotto(lottoNum);
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> numbers=userInputNumbers();
    }

    private static List<Integer> userInputNumbers() {
        userNumbers userNumbers = new userNumbers(readLine());
        userNumbers.addBonusNumber(Integer.parseInt(readLine()));
        return userNumbers.getNumbers();
    }

    private static List<Lotto> makeLotto(int lottoNum) {
        ArrayList<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoNum; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            printLotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }
    private static void printLotto(List<Integer> lottonumbers){
        System.out.print("[");
        for (int i = 0; i < lottonumbers.size(); i++) {
            if(i==lottonumbers.size()-1){
                System.out.print(lottonumbers.get(i)+"]");
            }
            System.out.print(lottonumbers.get(i)+", ");
        }
    }
    //사용자 금액 입력
    private static int userInputMoney() {
        UserMoney userMoney = new UserMoney(Integer.parseInt(readLine()));
        System.out.println(userMoney.getLottoNumber()+"개를 구매했습니다.");
        return userMoney.getLottoNumber();
    }


}
