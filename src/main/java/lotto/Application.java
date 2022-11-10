package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    static String NUMBER_REG = "/^[0-9]+$/";
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
            - 보너스 숫자 1개
          - 5. 당첨 내역을 출력한다.
            - n개 일치 (당첨 금액) - 해당 금액 총 당첨 개수
            - 총 수익률 (소수점 둘째 자리에서 반올림)*/

        // 1.
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = Console.readLine();
        int lottoCnt = validateUserInput(userInput);

    }

    private static int validateUserInput(String userInput) {
        if (!userInput.matches(NUMBER_REG)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        } else if (Integer.parseInt(userInput) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위만 입력할 수 있습니다.");
        }
        return Integer.parseInt(userInput);
    }
}
