package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Application {

    public static int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 구입 금액을 입력해주세요
        IOUtils.requestSetAccount();
        // 구입 금액 입력 받기
//        Account account = new Account(IOUtils.input());
        int account = setAccount();
        System.out.println(account);

        // 구입 금액 출력
        IOUtils.responseSetAccount(account);

        // 로또 생성
        List<List<Integer>> lottos = Lotto.buyLotto(account, LOTTO_PRICE);

        // 로또 출력
        IOUtils.responseBoughtLottos(lottos.size());
        IOUtils.responseBoughtLottosList(lottos);

        // 당첨 번호 입력 받기
        IOUtils.requestWinnerNumbers();
        Set<Integer> winnerNumber = Lotto.setWinnerNumber(IOUtils.input());

        // 보너스 번호 입력 받기
        IOUtils.requestBonusNumber();
        int bonusNumber = Lotto.setBonusNumber(winnerNumber, IOUtils.input());

        // 로또 당첨 여부 확인
        List<List<Integer>> result = Lotto.checkLotto(lottos, winnerNumber, bonusNumber);

        // 로또 당첨 내역 통계
        int[] sumResult = Lotto.calResult(result);

        // 로또 당첨 내역 출력
        IOUtils.responseResult(sumResult);

        // 수익율 계산
        float yield = Lotto.calYield(sumResult, account);
        IOUtils.responseTotalYield(yield);

    }


    private static int setAccount() throws IllegalArgumentException{
        String input = Console.readLine();
        // 입력 받은 금액 검증
        if(validAccount(input)){
            return 0;
        }
        int account = Integer.parseInt(input);
        return account;
    }

    private static boolean validAccount(String input) {
        // 부정형..
        if(! Pattern.matches("[0-9]+" , input)){
            System.out.println("[ERROR] 잘못된 입력 값입니다.");
            return true;
        }
        int account = Integer.parseInt(input);
        if (account % 1000 == 0) {
            return false;
        }
        System.out.println("[ERROR] 잘못된 입력 값입니다.");
        return true;
    }


}
