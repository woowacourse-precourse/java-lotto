package lotto.app;

import lotto.domain.lotto.BuyLotto;

import static lotto.util.InputImport.*;
//예기치 못한 오류 테스트 커밋
public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        BuyLotto.prepare_money(ReadLine());
    }
}
