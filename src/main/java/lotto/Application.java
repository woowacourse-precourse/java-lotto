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



    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }
    }



