package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Application {
    public static void main(String[] args) {
        final int GAME_MONEY = 1000;
        final int THREE = 0;
        final int FOUR = 0;
        final int FIVE = 0;
        final int FIVE_BONUS = 0;
        final int SIX = 0;

        ArrayList<Lotto> lottos = new ArrayList<>();

        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        int buyMoney = Integer.parseInt(Console.readLine());
        System.out.println();
        if (buyMoney % GAME_MONEY != 0) {
            throw new IllegalArgumentException("1000 단위가 아닐때 예외처리");
        }

        for (int i = 0; i < buyMoney / GAME_MONEY; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(i, lotto);
        }

        System.out.println(buyMoney / GAME_MONEY + "개를 구매했습니다.");
        for (int i = 0; i < lottos.toArray().length; i++) {
            System.out.println(lottos.get(i).getNumbers());
        }
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String pickNumber = Console.readLine();
        String[] b = pickNumber.split(",");

        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        int BonusNumber = Integer.parseInt(Console.readLine());

        for (int i = 0; i < lottos.size(); i++) {
            lotteryWinning(lottos.get(i).getNumbers(), b, BonusNumber);
        }

// TODO : 중복, 1~45 이외 숫자 나올시 예외처리


// TODO: 1~45 이외 숫자 나올시 예외처리

        System.out.println("당첨 통계");
        System.out.println("---");

    }

    private static void lotteryWinning(List<Integer> numbers, String[] b, int bonusNumber) {
        int count = 0;
        numbers.add(bonusNumber); // [1,2,3,4,5,6,7]
        Arrays.sort(b);
        List<String> list = Arrays.asList(b);
        List<Integer> newList = list.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        newList.add(bonusNumber);
        //TODO : 결과값 도출하기
        if(numbers.get(6)==newList.get(6)){
            System.out.println("1");
        }
        System.out.println(newList);

    }
}
