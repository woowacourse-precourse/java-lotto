package lotto;

import static lotto.Lotto.printLotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import com.sun.nio.sctp.IllegalReceiveException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;


public class Application {


    static Map<String, Integer> map = new HashMap<>();
    static Queue<String> queue = new ArrayDeque<>();
    static double income = 0;
    static String ERROR_MESSAGE = "[ERROR] 구입금액은 숫자만 입력 가능합니다.";

    public static int enterPurchaseAmount() {

        String str = "구입금액을 입력해 주세요.";
        System.out.println(str);
        String strAmount = Console.readLine();
        for (int i = 0; i < strAmount.length(); ++i) {
            if (!Character.isDigit(strAmount.charAt(i))) {
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
        }
        int amount = Integer.parseInt(strAmount);

        if (amount % 1000 != 0) {
            throw new NoSuchElementException("[ERROR] 1000의 배수만 입력 가능합니다.");
        }
        return amount;
    }


    public static int printNumberOfTickets(int amount) {

        int cnt = amount / 1000;
        System.out.println(cnt + "개를 구매했습니다.");
        return cnt;

    }


    public static int[] enterWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String strWinningNums = Console.readLine();
        String[] tmpArr = strWinningNums.split(",");
        int[] winningNums = new int[tmpArr.length];
        for (int i = 0; i < tmpArr.length; ++i) {
            for (char c : tmpArr[i].toCharArray()) {
                if (!Character.isDigit(c)) {
                    throw new IllegalReceiveException("[ERROR] 당첨 번호는 숫자만 입력 가능합니다.");
                }
            }
            winningNums[i] = Integer.parseInt(tmpArr[i]);
        }
        validateLotto(winningNums);
        return winningNums;
    }

    public static boolean validateLotto(int[] winningNums) {

        List<Integer> list = new ArrayList<>();
        for (int winningNum : winningNums) {
            list.add(winningNum);
        }
        Lotto lotto = new Lotto(list);
        return true;

    }


    public static int enterBonusNum(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String tmp = Console.readLine();
        for (char c : tmp.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력 가능합니다.");
            }
        }
        int bonusNum = Integer.parseInt(tmp);
        List<Integer> winningNumsList = new ArrayList<>();
        if (winningNumsList.contains(bonusNum) || bonusNum < 1 || 45 < bonusNum) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 부터 45 사이의 숫자이며 당첨 번호와 중복될 수 없습니다.");
        }
        return bonusNum;
    }

    public static int validateBonusNum(int[] winningNums) {

        List<Integer> winningNumsList = new ArrayList<>();

        for (int winningNum : winningNums) {
            winningNumsList.add(winningNum);
        }
        int bonusNum = enterBonusNum();

        return bonusNum;
    }


    public static Lotto generateLotto() {

        List<Integer> lottoList = new ArrayList<>();
        lottoList = Randoms.pickUniqueNumbersInRange(1, 45, 6);   // 1, 45 포함
        Lotto lotto = new Lotto(lottoList); // 생성한 로또에 대해 유효성 검사
        Lotto.sortLotto(lotto);
        return lotto;

    }


    public static List<Lotto> generateAllLotto(int numberOfTickets) {

        List<Lotto> allLottoList = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; ++i) {
            Lotto lotto = generateLotto();   // 로또 랜덤으로 생성
            allLottoList.add(lotto);
            printLotto(lotto);

        }

        return allLottoList;
    }


    public static void insertToMapAndQueue() {

        queue.addAll(List.of("3개 일치 (5,000원)", "4개 일치 (50,000원)", "5개 일치 (1,500,000원)",
            "5개 일치, 보너스 볼 일치 (30,000,000원)", "6개 일치 (2,000,000,000원)"
        ));

        map.put("3개 일치 (5,000원)", 0);
        map.put("4개 일치 (50,000원)", 0);
        map.put("5개 일치 (1,500,000원)", 0);
        map.put("5개 일치, 보너스 볼 일치 (30,000,000원)", 0);
        map.put("6개 일치 (2,000,000,000원)", 0);
    }


    public static double income(List<Lotto> allLotto, int[] winningNums, int bonusNum, int amount) {

        for (Lotto lotto : allLotto) {

            int cnt = 0;

            for (int winningNum : winningNums) {

                if (Lotto.contains(lotto, winningNum)) {
                    ++cnt;

                }
            }

            if (cnt == 6) {
                map.put("6개 일치 (2,000,000,000원)",
                    map.getOrDefault("6개 일치 (2,000,000,000원)", 0) + 1);
                income += 2000000000;


            } else if (cnt == 5) {

                if (Lotto.contains(lotto, bonusNum)) {
                    map.put("5개 일치, 보너스 볼 일치 (30,000,000원)",
                        map.getOrDefault("5개 일치, 보너스 볼 일치 (30,000,000원)", 0) + 1);
                    income += 30000000;
                    continue;

                }

                map.put("5개 일치 (1,500,000원)",
                    map.getOrDefault("5개 일치 (1,500,000원)", 0) + 1);
                income += 1500000;

            } else if (cnt == 4) {
                map.put("4개 일치 (50,000원)",
                    map.getOrDefault("4개 일치 (50,000원)", 0) + 1);
                income += 50000;

            } else if (cnt == 3) {
                map.put("3개 일치 (5,000원)",
                    map.getOrDefault("3개 일치 (5,000원)", 0) + 1);
                income += 5000;

            }

        }
        return income;
    }

    public static void printResult(double rateOfReturn) {

        System.out.println("당첨 통계");
        System.out.println("---");

        while (!queue.isEmpty()) {
            String key = queue.poll();
            int value = map.get(key);
            System.out.println(key + " - " + value + "개");
        }

        System.out.print("총 수익률은 ");
        System.out.printf("%.1f", rateOfReturn);
        System.out.println("%입니다.");

    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int amount = enterPurchaseAmount();      // 구매 금액 입력
        int numberOfTickets = printNumberOfTickets(amount);     // 로또 개수 출력
        List<Lotto> allLotto = generateAllLotto(numberOfTickets);       // 모든 로또를 개수 만큼 생성한다.
        int[] winningNums = enterWinningNumber();   // 당첨 번호 입력
        int bonusNum = validateBonusNum(winningNums);   // 보너스 번호 입력

        insertToMapAndQueue();

        // 이렇게 말고 각 로또에 대해 하나씩 income구하는 방식으로 쪼갤 수 있음
        double income = income(allLotto, winningNums, bonusNum, amount);
        printResult((double) (income / amount * 100));

    }
}
