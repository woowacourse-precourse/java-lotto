package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final String ERROR_MESSAGE = "[ERROR]";

    public static String[] PLACE = {"3개 일치 (5,000원) - ",
                                    "4개 일치 (50,000원) - ",
                                    "5개 일치 (1,500,000원) - ",
                                    "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
                                    "6개 일치 (2,000,000,000원) - "};

    public static int[] SAME_STAT = new int[5];
    public static int QUANTITY = 0;

    public static final int[] PAY = {5000, 50000, 1500000, 30000000, 2000000000};
    public static int inputMoney;

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("구입금액을 입력해 주세요");

        try {
            input(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.err.println(ERROR_MESSAGE);
        }

        QUANTITY = inputMoney / 1000;

        System.out.println(QUANTITY + "개를 구매했습니다.");
        List<List<Integer>> numbers = new ArrayList<>();
        for(int i = 0; i < QUANTITY; i++) {
            // n개의 로또 번호 생성
            CreateLottoNumbers lottoNumbers = new CreateLottoNumbers();
            numbers.add(lottoNumbers.numbers);
            System.out.println(numbers.get(i));
        }

        // 사용자의 당첨 번호 & 보너스 번호 입력
        List winNumber = inputWinNumber();

        // 당첨 번호 / 로또 번호 비교
        for(int i = 0; i < numbers.size(); i++) {
            Compare compare = new Compare();
            int sameNumber = compare.compareNumbers(winNumber, numbers.get(i));
            countStat(sameNumber);
        }

        calculateStat(inputMoney);

    }

    // 사용자의 구매 금액 입력 (에러 판별)
    public static void input(String inputMoneyStr) throws IllegalArgumentException {

        try {
            for(int i = 0; i < inputMoneyStr.length(); i++) {
                if(!(inputMoneyStr.charAt(i) >= '0' && inputMoneyStr.charAt(i) <= '9')) {
                    throw new IllegalArgumentException(ERROR_MESSAGE);
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE);
        }

        inputMoney = Integer.parseInt(inputMoneyStr);

        if(inputMoney % 1000 != 0) {
            System.out.println(ERROR_MESSAGE);
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

    }

    // 사용자의 당첨 번호 & 보너스 번호 입력
    public static List inputWinNumber() {
        List<Integer> winNumber = new ArrayList<>();

        System.out.println("당첨 번호를 입력해 주세요.");
        String[] inputNumber = Console.readLine().split(",");
        for(int i = 0; i < inputNumber.length; i++) {
            if(winNumber.contains(Integer.parseInt(inputNumber[i]))) {
                throw new IllegalArgumentException(ERROR_MESSAGE + "잘못된 당첨 번호입니다.");
            }
            winNumber.add(Integer.parseInt(inputNumber[i]));
        }

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        if(winNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "잘못된 보너스 번호입니다.");
        }
        winNumber.add(bonusNumber);

        return winNumber;
    }

    // 당첨 개수 카운트
    public static void countStat (int sameNumber) {

        if(sameNumber == 3) {
            SAME_STAT[0]++;
        } else if (sameNumber == 4) {
            SAME_STAT[1]++;
        } else if (sameNumber == 5) {
            SAME_STAT[2]++;
        } else if (sameNumber == -1) {
            SAME_STAT[3]++;
        } else if (sameNumber == 6) {
            SAME_STAT[4]++;
        }

    }

    // 당첨 통계 출력
    public static void calculateStat(int inputMoney) {
        int sum = 0;
        double calculateStat;

        for(int i = 0; i < PLACE.length; i++) {
            System.out.print(PLACE[i]);
            System.out.println(SAME_STAT[i] + "개");
            sum += SAME_STAT[i] * PAY[i];
        }
        calculateStat = ((double)sum / inputMoney) * 100;

        System.out.print("총 수익률은 ");
        System.out.print(String.format("%.1f", calculateStat));
        System.out.println("%입니다.");

    }

}
