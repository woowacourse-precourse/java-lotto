package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

/*
 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
 */
public class Application {
    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        inputManager.inputMoney(); // 금액 입력
        inputManager.inputAnswerNumbers(); // 정답 숫자 생성
        List<Integer> answerNumbers = inputManager.getAnswerNumbers(); // 생성한 숫자 리스트에 저장
        Lotto lotto = new Lotto(answerNumbers); // 저장한 리스트를 이용해 로또 정답이 고정된 로또 인스턴스 생성
        lotto.buyLotto(); // 자동 선택 로또를 금액만큼 구매, 확인


    }
}
