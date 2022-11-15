package lotto;

public class Controller {
    public Controller(){
        Domain domain = new Domain();
        try{
            domain.buyTicket();
            domain.receiveWinningNumber();
            domain.printPrize();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
