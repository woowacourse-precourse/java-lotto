package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Application {

    private static List<Lotto> lottos = new ArrayList<>();
    private static List<Integer> userNums = new ArrayList<>();
    private static int buyLot;

    // 구입 금액
    public static void buy() {
        System.out.println("구입 금액: ");
        String input_pay = Console.readLine();

        try {
            buyLot = Integer.parseInt(input_pay);
        } catch (IllegalArgumentException e) {
            System.out.println("[Error] 숫자만 입력!");
        }
    }
    public static int buyLotto() {
        int buyLot = 0;
        int pay = buyLot / 1000;
        System.out.println(pay + "개 구매");
        for (int i = 0; i < pay; i++) {
            Lotto lotto = new Lotto(pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }
        try {
            if (buyLot % 1000 != 0)
                throw new IllegalArgumentException("[Error] 구입 금액은 1,000원 단위여야 함.");
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
        return pay;
    }
    //     로또 번호 입력
    public static String[] userNum() {
        System.out.println("당첨 번호 입력: ");
        String myNum = Console.readLine();
        String myNums[] = myNum.split(",");

        userNums.add(Integer.valueOf(String.valueOf(myNums)));
        return myNums;
    }
    // 보너스 번호 입력
    public static int bounsNumber() {
        System.out.println("보너스 번호 입력: ");
        int bonusNum = Integer.parseInt(Console.readLine());
        return bonusNum;
    }




    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }
    }



