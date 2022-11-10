package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new User();
        NumberGenerator numberGenerator = new NumberGenerator();
        user.readMoney();
        user.setNumOfLotto();

        System.out.println(user.getNumOfLotto() + " 개를 구매했습니다.");
        for(int i=0; i<user.getNumOfLotto(); i++){
            user.addLotto(numberGenerator.makeNumber());
        }
        user.showLottos();

        numberGenerator.readLotto();
        numberGenerator.readBonus();

        System.out.println("당첨 통계\n---");
    }
}
