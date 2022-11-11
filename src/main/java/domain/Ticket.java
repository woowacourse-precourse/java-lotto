package domain;

public class Ticket {

    public UserMoneyValidate userMoney = new UserMoneyValidate();
    final int THOUSAND = 1000;

    public int getTicketNum(String input){
        int totalMoney = userMoney.validateGetMoney(input);
        return totalMoney / THOUSAND;
    }
}
