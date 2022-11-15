package lotto;

//import lotto.domain.NumberGenerator;
import lotto.domain.Result;
import lotto.domain.User;
import lotto.ui.UserInput;
import lotto.ui.UserOutput;

public class Application {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        UserOutput userOutput = new UserOutput();

        User user = new User();
        Result result = new Result();

        //사용자에게 돈 입력받기
        user.SetMoney(userInput.GetMoney());
        //사용자 돈으로 로또 구매
        user.BuyLotto();
        //로또 구매 결과 출력
        userOutput.PrintBoughtLotto(user.GetMyLotto());
        //사용자에게 로또 번호 입력받음
        user.SetAnswerNumber(userInput.GetLottoNumber());
        //사용자에게 보너스 번호 입력받음
        user.SetBonusNumber(userInput.GetBonusNumber());
        //로또 결과 도출
        result.CalculateResult(user);
        //로또 결과 출력
        userOutput.PrintResult(result.GetResult(), user.GetMoney());



    }
}
