package lotto;


public class Application {
    static int amountToLottoCount(int userInput){
        Amount amount = new Amount(userInput);
        if(!amount.isValidateAmount()) {
            ResultView.exit("1000원 단위로 입력해주세요.");
        }
        return amount.getLottoCount();
    }

    public static void main(String[] args) {
        int lottoCount = amountToLottoCount(InputView.receiveAmount());
        Lottos lottos = new Lottos(lottoCount);
    }
}
