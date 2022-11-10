package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Application {

    public static int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("구입 금액을 입력 해주세요.");
        // 구입 금액 입력 받기
        int account = setAccount();
        System.out.println("account = " + account);

        // 로또 생성
        List<List<Integer>> lottos = buyLotto(account);

        // 로또 출력
        lottos.stream().forEach(System.out::println);
        System.out.println(lottos.size() + "개를 구매했습니다.");

        // 당첨 번호 , 보너스 번호 입력 받기
        List<Integer> winnerNumber = setWinnerNumber();


    }


    private static List<Integer> setWinnerNumber() {
        String input = Console.readLine();

        return null;
    }



    private static List<List<Integer>> buyLotto(int account) {
        List<List<Integer>> lottos = new ArrayList<>();
        while (account > 0) {
            List<Integer> list = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(list);
            account -= LOTTO_PRICE;
        }
        return lottos;
    }

    private static int setAccount() {
        int account = Integer.parseInt(Console.readLine());
        // 입력 받은 금액 검증
        if(validAccount(account)){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_VALUE.message());
        }
        return account;
    }

    private static boolean validAccount(int account) {
        if (account % 1000 == 0) {
            return false;
        }
        return true;
    }


}
