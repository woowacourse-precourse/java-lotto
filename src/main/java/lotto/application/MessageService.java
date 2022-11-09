package lotto.application;

public class MessageService {
    private static final MessageService instance=new MessageService();
    private MessageService(){}
    public static MessageService getInstance(){
        return instance;
    }
    public void inputPurchaseAmountInformationMessage(){
        System.out.println("구매금액을 입력해 주세요.");
    }
}
