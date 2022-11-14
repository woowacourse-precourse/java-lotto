package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    static int amount, bonusNumber;
    static List<Lotto> lottos;
    static List<Integer> answerNumbers;
    static int[] result;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            init();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 잘못된 입력입니다.");
            return;
        }
        checkingLotto();
        getLottoNumbers();
        calc();
        resultOut();
    }

    private static void resultOut() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoPrice cur : LottoPrice.values()) {
            System.out.println(cur.getLabel() + " " + "(" + cur.getPrice() + "원)" + " - " + result[cur.getNum()] + "개");
        }
        // 수익률 계산
        long sum = 0;
        for (LottoPrice lp : LottoPrice.values()) {
            sum += Long.parseLong(lp.getPrice().replace(",", "")) * result[lp.getNum()];
        }
        System.out.printf("총 수익률은 %.1f%%입니다.%n", (double) sum * 100 / amount);
    }

    private static void calc() {
        // 해당 lottos 의 당첨 여부를 판단하는 함수
        for (Lotto lotto : lottos) {
            lotto.matchResult(answerNumbers, bonusNumber, result);
        }
    }

    private static void getLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        // 당첨 번호는 쉼표(,) 를 기준으로 구분한다.
        // 토큰의 갯수는 총 6개 && 1~45 사이의 수 이어야 한다.
        StringTokenizer st = new StringTokenizer(Console.readLine(), ",");

        // Exception 처리
        // 1. 해당 하는 토큰이 6개가 아닌 경우
        // 2. 해당 하는 토큰이 unique 하지 않은 경우
        validateTokens(st);

        while (st.hasMoreTokens()) {
            int value = Integer.parseInt(st.nextToken());
            // Exception 처리
            validateNumbers(value);
            answerNumbers.add(value);
        }
        System.out.println("보너스 번호를 입력해 주세요");
        bonusNumber = Integer.parseInt(Console.readLine());
    }

    private static void validateTokens(StringTokenizer st) {
        if (st.countTokens() != 6)
            throw new IllegalArgumentException(String.format("%s : %s\n", Exceptions.ERROR_MESSAGE.msg, Exceptions.NOT_6_ELEMENT.msg));
    }

    private static void validateNumbers(int num) {
        if (num < LottoSystemInfo.START.num || num > LottoSystemInfo.LAST.num)
            throw new IllegalArgumentException(String.format("%s : %s\n", Exceptions.ERROR_MESSAGE.msg, Exceptions.NOT_IN_SCALE.msg));
    }

    private static void checkingLotto() {
        for (Lotto lotto : lottos) {
            List<Integer> list = new ArrayList<>();
            for (int w : lotto.getNumbers()) list.add(w);
            Collections.sort(list);
            System.out.println(list);
        }
    }

    static void init() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        try {
            checkingAmount(input);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        amount = Integer.parseInt(input);

        answerNumbers = new ArrayList<>();
        lottos = new ArrayList<>();
        result = new int[7];
        Arrays.fill(result, 0);
        // making lottos
        System.out.printf("%d개를 구매했습니다.%n", amount / 1000);
        for (int i = 0; i < amount / 1000; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(LottoSystemInfo.START.num, LottoSystemInfo.LAST.num, LottoSystemInfo.COUNT.num)));
        }
    }

    private static void checkingAmount(String input) {
        // Exception 처리
        int amount = 0;
        try {
            amount = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.format("%s : %s\n", Exceptions.ERROR_MESSAGE.msg, Exceptions.ILLEGAL_INPUT.msg));
        }


        // amount가 1000으로 나눠떨이지지 않는 경우
        if (amount % 1000 != 0)
            throw new IllegalArgumentException(String.format("%s : %s\n", Exceptions.ERROR_MESSAGE.msg, Exceptions.NOT_DIVIDED.msg));

        // amount가 음수 일 경우
        if (amount < 0)
            throw new IllegalArgumentException(String.format("%s : %s\n", Exceptions.ERROR_MESSAGE.msg, Exceptions.NEGATIVE_AMOUNT.msg));
    }
}
