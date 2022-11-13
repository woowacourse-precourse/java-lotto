package domain;

public class Ticket {

    public UserMoneyValidate userMoney = new UserMoneyValidate();
    final int THOUSAND = 1000;

    public int getTicketNum(int input){
        return input / THOUSAND;
    }
}
