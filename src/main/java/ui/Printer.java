package ui;

public class Printer {

    private System system;

    Printer(System system){
        this.system = system;
    }

    public void printEnterPurchaseAmount() {
        system.out.println(UiText.ENTER_PURCHASE_AMOUNT.getTxt());
    }

    public void printBoughtNum(Integer boughtNum) {
        system.out.println(boughtNum + UiText.BOUGHT_NUMBER.getTxt());
    }

    public void printEnterWinningNumber() {
        system.out.println(UiText.ENTER_WINNING_NUMBER.getTxt());
    }

    public void printEnterBonusNumber() {
        system.out.println(UiText.ENTER_BONUS_NUMBER.getTxt());
    }

    public void printWinningStatistics() {
        system.out.println(UiText.WINNING_STATISTICS.getTxt());
        system.out.println(UiText.THREE_MATCHES.getTxt());
        system.out.println(UiText.FOUR_MATCHES.getTxt());
        system.out.println(UiText.FIVE_MATCHES.getTxt());
        system.out.println(UiText.FIVE_AND_BONUS_MATCHES.getTxt());
        system.out.println(UiText.SIX_MATCHES.getTxt());
        system.out.println(UiText.GROSS_RETURN.getTxt());
    }
}
