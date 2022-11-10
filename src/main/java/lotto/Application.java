package lotto;

import camp.nextstep.edu.missionutils.Randoms;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    private static Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
