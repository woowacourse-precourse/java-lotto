package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;


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
