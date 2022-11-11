package lotto;

public class Bonus {

    private static int BONUSNUMBER = 0;

    Bonus(int input) {
        validity(input);
        this.BONUSNUMBER = input;
    }

    private void validity(int input) {
        //input이 숫자가 맞는지, 로또 정답이랑 맞는지 비교한다.
        checkBonusNum(input);
        checkBonusNotInWinning(input);
    }

    private void checkBonusNum(int input) {
        // 입력된 보너스 번호가 숫자가 맞는가?
    }

    private void checkBonusNotInWinning(int input) {
        // 당첨 번호에서 사용된 숫자는 아닌가?
    }

    public int checkBonusIncluded(/*인자 필요해*/) {
        //인자로 로또번호 6자리를 가져와서 보너스가 들어있는지 판단, 그 결과에 따라 0또는 1 리턴 (나중에 상수화)
        return 1;
    }
}
