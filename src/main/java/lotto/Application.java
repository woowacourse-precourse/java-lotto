package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    static int amount, bonusNumber;
    static List<Lotto> lottos;
    static List<Integer> answerNumbers;
    static final int _LOTTO_LAST_NUM = 45;
    static final int _LOTTO_START_NUM = 1;
    static final int _LOTTO_COUNT_NUM = 6;
    static int[] result;

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        init();
        checkingLotto();
        getLottoNumbers();
        calc();
        resultOut();
    }

    private static void resultOut() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for(LottoPrice cur : LottoPrice.values()){
            System.out.println(cur.getLabel() + " " + "(" + cur.getPrice() + "원)" + " - " + result[cur.getNum()] + "개");
        }
        // 수익률 계산
        long sum = 0;
        for(LottoPrice lp : LottoPrice.values()){
            sum += Long.parseLong(lp.getPrice().replace(",", "")) * result[lp.getNum()];
        }
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", (double) sum * 100 / amount));
    }

    private static void calc() {
        // 해당 lottos 의 당첨 여부를 판단하는 함수
        for (Lotto lotto : lottos){
            lotto.matchResult(answerNumbers, bonusNumber, result);
        }
    }

    private static void getLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        // 당첨 번호는 쉼표(,) 를 기준으로 구분한다.
        // 토큰의 갯수는 총 6개 && 1~45 사이의 수 이어야 한다.
        StringTokenizer st = new StringTokenizer(Console.readLine(), ",");

        // Exception 처리

        while (st.hasMoreTokens()) {
            answerNumbers.add(Integer.parseInt(st.nextToken()));
        }
        System.out.println("보너스 번호를 입력해 주세요");
        bonusNumber = Integer.parseInt(Console.readLine());
    }

    private static void checkingLotto() {
        for (Lotto lotto : lottos) {
            List<Integer> list = new ArrayList<>();
            for(int w : lotto.getNumbers()) list.add(w);
            Collections.sort(list);
            System.out.println(list);
        }
    }

    static void init() {
        // amount 가 음수가 나올 경우 예외처리
        System.out.println("구입금액을 입력해 주세요.");
        amount = Integer.parseInt(Console.readLine());
        answerNumbers = new ArrayList<>();
        lottos = new ArrayList<>();
        result = new int[7];
        Arrays.fill(result, 0);
        // making lottos
        // Exception handling
        // 1. 1000 으로 나눠떨이지지 않을 경우
        System.out.println(String.format("%d개를 구매했습니다.", amount/1000));
        for (int i = 0; i < amount / 1000; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(_LOTTO_START_NUM, _LOTTO_LAST_NUM, _LOTTO_COUNT_NUM)));
        }
    }
}
