package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 구매금액입력
    }

    /**
     * 6. buyLotto (로또 구입) 완료 <br/>
     * 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다. <br/>
     * 1장에 1,000원. 소숫점 예외처리 발생 <br/>
     * inputMoney % 1000 != 0 예외발생!<br/>
     * buyLotto return 값으로 1. lottoRandomNum n회차 돌리기
     * 
     * @return
     */
    public static int buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        int inputMoney = 0;
        try {
            inputMoney = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력 타입 오류.");
        }
        if (inputMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액 입력 오류.");
        }

        int buyLotto = inputMoney / 1000;

        return buyLotto;
    }

    // 랜덤 로또번호 뽑기

}
