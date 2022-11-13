package lotto;
import lotto.Domain.ErrorMessage;
import lotto.Domain.SayMessage;

public class Application {
    private boolean systemError = false;
    private int money = 0;
    private Lotto answerValue = null;
    private static LottoClerk lottoClerk;
    private static LottoMachine lottoMachine;

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    private int bonus=0;

    public Application() {
        lottoClerk = new LottoClerk();
        lottoMachine = new LottoMachine();
        this.inputMoney();
    }

    public static void main(String[] args) {
        Application application = new Application();
        if (application.systemError)
            return;
        lottoClerk.sayBuyLotto(lottoMachine.makeLottoCount(application.getMoney()));
        application.giveLotto();
        application.answerLotto();
        if (application.systemError)
            return;
        application.bonusLotto();
        if(application.systemError)
            return;
    }

    public void giveLotto() {
        lottoMachine.makeLottoReceipt();
        lottoClerk.sayLottoReceipt(lottoMachine.getLottoReceipt());
    }

    public int getMoney() {
        return money;
    }

    public boolean getSystemError() {
        return systemError;
    }

    public void inputMoney() {
        try {
            money = Integer.parseInt(lottoClerk.sayPleaseInput(SayMessage.BUY));
            if (money % 1000 != 0)
                throw new IllegalArgumentException();
        } catch (Exception e) {
            errorCatcher(ErrorMessage.NOTTHOUSANDSNUMBER.getErrorMessage());
        }
    }


    public boolean errorCatcher(String errorMessage) {
        try {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + errorMessage);
            return systemError = true;
        }
    }

    public void answerLotto() {
        try {
            String[] answer = lottoClerk.sayPleaseInput(SayMessage.ANSWER).split(",");
            Lotto lotto = new Lotto(answer);
            answerValue = lotto;
        } catch (Exception e) {
            errorCatcher(ErrorMessage.NOTONETOFOURTHYFIVE.getErrorMessage());
        }
    }

    public void bonusLotto() {
        try {
            bonus = Integer.parseInt(lottoClerk.sayPleaseInput(SayMessage.BONUS));
            if(bonus<1||bonus>45)
            {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            errorCatcher(ErrorMessage.NOTONETOFOURTHYFIVE.getErrorMessage());
        }
    }
}
