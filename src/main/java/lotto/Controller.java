package lotto;

public class Controller {
    public Controller(){
        Domain domain = new Domain();
        domain.buyTicket();
        domain.receiveWinningNumber();
    }
}
