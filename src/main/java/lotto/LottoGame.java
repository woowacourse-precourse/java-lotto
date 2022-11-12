package lotto;

public class LottoGame {

    public void startGame(){

        User user = new User();

        System.out.println("로또를 구매할 금액을 입력해주세요.(1,000의 배수만 가능합니다.)");
        user.lottoPurchaseAmount(new UserInputGeneratorImpl());

        System.out.println("번호 여섯 자리를 입력해 주세요.(쉼표로 구분합니다.)");
        user.userLottoNumbers(new UserInputGeneratorImpl());
    }
}
