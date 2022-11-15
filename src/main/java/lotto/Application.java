package lotto;

public class Application {
    public static void main(String[] args) {
        Notice notice = new Notice();
        User user = new User();
        Error error = new Error();

        purchase(user, notice);
        Lottery lottery = new Lottery(user.getPurchaseNumber());
        notice.lottery(lottery);
        winningNumber(user, notice);
        bonusNumber(user, notice);
        winningResult(user, notice, lottery);
        error.check();
    }

    public static void purchase(User user, Notice notice) {
        notice.purchasePrice();
        user.setPurchasePrice();
        notice.purchaseNumber(user.getPurchaseNumber());
    }

    public static void winningNumber(User user, Notice notice) {
        notice.winningNumber();
        user.setWinningNumbers();
    }

    public static void bonusNumber(User user, Notice notice) {
        notice.bonusNumber();
        user.setBonusNumber();
    }

    public static void winningResult(User user, Notice notice, Lottery lottery) {
        lottery.calcGrade(user);
        notice.winningAnalysis(lottery.getGradeCount());
        notice.profitRatio(user.getProfitRatio(lottery.getWinningPrice()));
    }
}
