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
        String userInput=readLine();
        if (!checkErrorInput(userInput))return;
        UserMoney userMoney = userInputMoney(userInput);

        List<Lotto> lottos = makeLotto(userMoney.getLottoNumber());
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> numbers = userInputNumbers();
        System.out.println("당첨 통계");
        System.out.println("---");
        int ranking[] = compareUserInputLottos(lottos, numbers);
        calculateEarnings(ranking, userMoney.getUserInputMoney());
    }
    //사용자 돈 에러 체크 함수
    private static boolean checkErrorInput(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.charAt(i) < 48 || userInput.charAt(i) > 57) {
                System.out.println("[ERROR]");
                return false;
            }
        }
        if (Integer.parseInt(userInput) % 1000 != 0) {
            System.out.println("[ERROR]");
            return false;
        }
        return true;
    }
    // 수익률 계산 함수
    private static void calculateEarnings(int[] ranking, int userInputMoney) {
        int total = ranking[3] * RankingMoney.FIFTH.getMoney()
                + ranking[4] * RankingMoney.FOURTH.getMoney()
                + ranking[5] * RankingMoney.THIRD.getMoney()
                + ranking[7] * RankingMoney.SECOND.getMoney()
                + ranking[6] * RankingMoney.FIRST.getMoney();
        double earnings = total / (double) userInputMoney * 100;
        double roundedEarnings = (double) Math.round(earnings * 10) / 10;
        System.out.println("총 수익률은 " + roundedEarnings + "%입니다.");
    }
    // 사용자 입력 번호와 로또들 비교 함수
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
    // 사용자 입력 번호화 로또드 비교 출력 함수
    private static void printRanking(int[] ranking) {
        System.out.println("3개 일치 (5,000원) - " + ranking[3] + "개");
        System.out.println("4개 일치 (50,000원) - " + ranking[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + ranking[5] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + ranking[7] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + ranking[6] + "개");
    }
    // 5개 맞을 시 보너스 번호 체크 함수
    private static int checkBonussNumber(Lotto lotto, Integer integer) {
        if (lotto.getNumbers().contains(integer)) {
            return 2;
        }
        return 0;
    }
    // 로또 한개와 사용자 입력 숫자 한개 비교 함수
    private static int compareNumbers(Lotto lotto, int numbers) {
        if (lotto.getNumbers().contains(numbers)) {
            return 1;
        }
        return 0;
    }
    // 사용자 로또 번호 입력 함수
    private static List<Integer> userInputNumbers() {
        userNumbers userNumbers = new userNumbers(readLine());
        userNumbers.addBonusNumber(Integer.parseInt(readLine()));
        return userNumbers.getNumbers();
    }
    // 로또 만들기 함수
    private static List<Lotto> makeLotto(int lottoNum) {
        ArrayList<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoNum; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < numbers.size(); j++) {
                list.add(numbers.get(j));
            }
            Collections.sort(list);
            Lotto lotto = new Lotto(list);
            printLotto(list);
            lottos.add(lotto);
        }
        return lottos;
    }
    // 로또 출력 함수
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
    private static UserMoney userInputMoney(String userinput) {
        UserMoney userMoney = new UserMoney(userinput);
        System.out.println(userMoney.getLottoNumber() + "개를 구매했습니다.");
        return userMoney;
    }
}
