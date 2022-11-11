package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.Domain.ErrorMessage;

public class Application {
    private boolean systemError = false;
    private int money=0;
    public static void main(String[] args) {
        Application application = new Application();
        application.inputMoney();
        if(application.systemError)
            return;
    }
    public void inputMoney()
    {
        try{
            System.out.println("구입금액을 입력해 주세요.");
            money = Integer.parseInt(Console.readLine());
            if(money%1000!=0)
                throw new IllegalArgumentException();
        }
        catch(Exception e)
        {
            errorCatcher(ErrorMessage.NOTTHOUSANDSNUMBER.getErrorMessage());
        }
    }

    public boolean errorCatcher(String errorMessage)
    {
        try
        {
            throw new IllegalArgumentException();
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("[ERROR]"+errorMessage);
            return systemError=true;
        }
    }

}
