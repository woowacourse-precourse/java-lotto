package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            Buyer buyer = new Buyer(UserInterface.readUserInput(InformMessage.PURCHASE_AMOUNT));
            Lotto correct;
            int bonus;

            UserInterface.writeLotteryTickets(buyer.getBoughtTicketDTO());
            correct = new Lotto(UserInterface.readUserInput(InformMessage.WINNING_NUMBER));
            bonus = correct.parseBonusNumber(UserInterface.readUserInput(InformMessage.BONUS_NUMBER));
            buyer.checkBoughtTickets(correct, bonus);
            UserInterface.writeResult(buyer.getWinningCountDTO());
            UserInterface.writeEarningRate(buyer.calculateEarningRate());
        } catch (IllegalArgumentException ex) {
            UserInterface.writeExceptionMessage(ex);
        }
    }
}
