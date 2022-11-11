package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    static String NUMBER_REG = "/^[0-9]+$/";
    static String LOTTO_NUMBER_REG = "^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$";
    public static void main(String[] args) {
        // TODO: Java Enum 만들기
        /*- 1. 로또 구입 금액을 입력 받는다.
            - 1000원 단위로 입력, 1000원으로 나누어 떨어지지 않을 시 예외 발생
            - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료한다.
          - 2. 로또 구입 금액에 해당하는 만큼 로또 발행
            - 숫자 범위는 1~45
            - 중복되지 않는 숫자 6개
          - 3. 발행한 로또 수량 및 번호를 출력한다.
            - 로또 번호는 오름차순으로 정렬하여 보여준다.
          - 4. 당첨 번호를 입력 받는다.
            - 중복되지 않는 숫자 6개 (번호는 (,) 기준으로 구분한다.)
            - 사용자가 잘못된 당첨 번호를 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료한다.
            - 보너스 숫자 1개
            - 사용자가 잘못된 보너스 숫자를 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료한다.
          - 5. 당첨 내역을 출력한다.
            - n개 일치 (당첨 금액) - 해당 금액 총 당첨 개수
            - 총 수익률 (소수점 둘째 자리에서 반올림)*/

        // 1.
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = Console.readLine();
        int money = validateInputMoney(inputMoney);

        // 2.
        List<Lotto> lottos = createLottos(money);

        // 3.
        printLottos(money, lottos);

        // 4.
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinningNums = Console.readLine();
        validateInputWinningNums(inputWinningNums);

        System.out.println("당첨 번호를 입력해 주세요.");
        String inputBonusNum = Console.readLine();
        validateInputBonusNum(inputBonusNum);

        List<Integer> winningNums = parseInputWinningNumsIntoInteger(inputWinningNums);
        int bonusNum = Integer.parseInt(inputBonusNum);


    }

    private static int validateInputMoney(String inputMoney) {
        if (!inputMoney.matches(NUMBER_REG)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        } else if (Integer.parseInt(inputMoney) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위만 입력할 수 있습니다.");
        }
        return Integer.parseInt(inputMoney);
    }

    private static void validateInputWinningNums(String inputWinningNums) {
        if (inputWinningNums.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 구분자 \",\"를 포함해야 합니다.");
        }
        String[] inputWinningNumsArr = inputWinningNums.split(",");
        if (inputWinningNumsArr.length < 6) {
            throw new IllegalArgumentException("[ERROR] 숫자 6개를 입력해야 합니다.");
        }
        for (String s : inputWinningNumsArr) {
            if (!s.matches(LOTTO_NUMBER_REG)) {
                throw new IllegalArgumentException("[ERROR] 숫자는 1~45까지만 입력할 수 있습니다.");
            }
        }
    }

    private static void validateInputBonusNum(String inputBonusNum) {
        if (!inputBonusNum.matches(NUMBER_REG)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private static List<Lotto> createLottos(int money) {
        int lottoCnt = money / 1000;

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static void printLottos(int money, List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", money / 1000);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static List<Integer> parseInputWinningNumsIntoInteger(String inputWinningNums) {
        List<String> inputWinningNumsList = Arrays.asList(inputWinningNums.split(","));
        return inputWinningNumsList.stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
