package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 구입 금액 입력
        System.out.println(OutputMessage.PRICE.get());
        Price p = new Price();
        System.out.println(p.get());
        // 당첨 번호, 보너스 번호 입력
        // 로또 수량 구하기
        // 로또 수량 만큼 로또 생성
        // 당첨 내역 구하기
    }
}
