package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        UserMoney userMoney = userInputMoney();

        List<Lotto> lottos = makeLotto(userMoney.getLottoNumber());
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> numbers = userInputNumbers();
        System.out.println("당첨 통계");
        System.out.println("---");
        int ranking[] = compareUserInputLottos(lottos, numbers);
        calculateEarnings(ranking, userMoney.getUserInputMoney());
    }

    private static void calculateEarnings(int[] ranking, int userInputMoney) {
        int total=ranking[3]*5000
                +ranking[4]*50000
                +ranking[5]*150000
                +ranking[7]*30000000
                +ranking[6]*2000000000;
        double earnings=total/(double)userInputMoney*100;
        double roundedEarnings=(double)Math.round(earnings*10)/10;
        System.out.println("총 수익률은 "+roundedEarnings+"%입니다.");
    }

    private static int[] compareUserInputLottos(List<Lotto> lottos, List<Integer> numbers) {
        int[] ranking = new int[8];
        for (int i = 0; i < lottos.size(); i++) {
            int cnt = 0;
            for (int j = 0; j < numbers.size() - 1; j++) {
                cnt += compareNumbers(lottos.get(i), numbers.get(j));
            }
            if (cnt == 5) {
                cnt += checkBonussNumber(lottos.get(i), numbers.get(numbers.size() - 1));
            }
            ranking[cnt]++;
        }
        printRanking(ranking);
        return ranking;
    }

    private static void printRanking(int[] ranking) {
        System.out.println("3개 일치 (5,000원) - "+ranking[3]+"개");
        System.out.println("4개 일치 (50,000원) - "+ranking[4]+"개");
        System.out.println("5개 일치 (1,500,000원) - " + ranking[5] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+ranking[7]+"개");
        System.out.println("6개 일치 (2,000,000,000원) - " + ranking[6] + "개");
    }

    private static int checkBonussNumber(Lotto lotto, Integer integer) {
        if (lotto.getNumbers().contains(integer)) {
            return 2;
        }
        return 0;
    }

    private static int compareNumbers(Lotto lotto, int numbers) {
        if (lotto.getNumbers().contains(numbers)) {
            return 1;
        }
        return 0;
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
            ArrayList<Integer> a=new ArrayList<>();
            for (int j = 0; j < numbers.size(); j++) {
                a.add(numbers.get(j));
            }
            Collections.sort(a);
            Lotto lotto = new Lotto(a);
            printLotto(a);
            lottos.add(lotto);
        }
        return lottos;
    }

    private static void printLotto(List<Integer> lottonumbers) {
        System.out.print("[");
        for (int i = 0; i < lottonumbers.size(); i++) {
            if (i == lottonumbers.size() - 1) {
                System.out.print(lottonumbers.get(i) + "]");
                break;
            }
            System.out.print(lottonumbers.get(i) + ", ");
        }
        System.out.println();
    }

    //사용자 금액 입력
    private static UserMoney userInputMoney() {
        UserMoney userMoney = new UserMoney(readLine());
        System.out.println(userMoney.getLottoNumber() + "개를 구매했습니다.");
        return userMoney;
    }


}
