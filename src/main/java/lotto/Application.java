package lotto;

public class Application {


    public static void main(String[] args) {
        Notice notice = new Notice();
        User user = new User();

        notice.purchasePrice();
        user.setPurchasePrice();

        notice.purchaseNumber(user.getPurchaseNumber());
        Lottery lottery = new Lottery(user.getPurchaseNumber());

        notice.lottery(lottery);

        notice.winningNumber();
        user.setWinningNumbers();

        notice.bonusNumber();
        user.setBonusNumber();

        lottery.calcGrade(user);
        notice.winningAnalysis(lottery.getGradeCount());
    }

}
