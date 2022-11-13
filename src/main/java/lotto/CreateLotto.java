package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class CreateLotto {
    final List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    public List<Integer> createRandomBall() {
        return numbers;
    }

    public void winningNumber() {

    }

    public void textWinningNumber() {
        System.out.println("당첨 번호를 입력해주세요");
    }

    public void textBounsNumber() {
        System.out.println("보너스 번호를 입력해주세요");
    }

}
