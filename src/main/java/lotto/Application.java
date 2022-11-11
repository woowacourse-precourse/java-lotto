package lotto;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static List<List<Integer>> randomNumbers = new ArrayList<>();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 로또 구입 금액 입력
        Input.inputCoin();
        // 구매 개수만큼 로또용지 출력
        for(int i=0; i<Input.buyCount; i++){
            randomNumbers.add(NumberGenerator.createRandomNumber());
        }
        // 당첨 번호를 입력
        Input.inputWinningNumber();
        // 보너스 번호 입력
        Input.inputBonusNumber();

        System.out.println("당첨 통계");
        System.out.println("---");

        // 일치하는 숫자 확인 기능 실행
        for(int i=0; i<Input.buyCount; i++){
            NumberCompare.compare(Input.lottoNumber, randomNumbers.get(i), Input.lottoBonusNumber);
        }
        // 등수당 일치 개수 출력

    }
}
