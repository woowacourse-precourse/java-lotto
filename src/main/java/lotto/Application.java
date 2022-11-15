package lotto;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        User user = UI.getUser();
        Lotto lottoNumbers = UI.getLottoNumbers();
        int bonusNumber = UI.getBonusNumber();
        Rank rank = new Rank(lottoNumbers, bonusNumber);
        rank.run(user);
        UI.printTotalResult(user.money);
    }
}
