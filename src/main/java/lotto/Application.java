package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
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
        Set<Integer> winnerNumber = setWinnerNumber();
        System.out.println("winnerNumber = " + winnerNumber);
        int bonusNumber = setBonusNumber();
        System.out.println("bonusNumber = " + bonusNumber);


    }

    private static int setBonusNumber() {
        String input = Console.readLine();
        if(validBonusNumber(input)){
            return Integer.parseInt(input);
        }
        throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_VALUE.message());
    }

    private static boolean validBonusNumber(String input) {
        if(Pattern.matches("\\d", input)){
            return true;
        }
        throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_VALUE.message());
    }


    private static Set<Integer> setWinnerNumber() {
        String input = Console.readLine();
        Set<Integer> winnerNumber = new HashSet<>();
        // 입력 받은 당첨 번호 검증
        if(validWinnerNumber(input)){
            winnerNumber = Stream.of(input.split(",")).map(Integer::parseInt).collect(Collectors.toSet());
        }
        if(winnerNumber.size() == 6){
            return winnerNumber;
        }
        throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_VALUE.message());
    }

    private static boolean validWinnerNumber(String input) {
        if(Pattern.matches("(\\d,){5}\\d" , input)){
            return true;
        }
        throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_VALUE.message());
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
