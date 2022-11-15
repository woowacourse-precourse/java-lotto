package lotto;

public class InputController {
    private static final int END = 0;
    private int checkTicketAmount(){
        int amount;
        String countInput = InputView.getTicketCount();
        try {
            Validator.isNumber(countInput);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return END;
        }
        amount = Integer.parseInt(countInput);
        return amount;
    }
    public int checkTicketCount(){
        int count;
        int amount = checkTicketAmount();
        try {
            Validator.checkAmount(amount);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return END;
        }
        count = amount / Constant.PURCHASE_UNIT;
        return count;
    }
}
