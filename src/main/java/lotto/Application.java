package lotto;

import java.util.List;

public class Application {
    public static <Ineger> void main(String[] args) {
        // TODO: 프로그램 구현


        Lotto.inputBuyPirce1(); //메세지

        int input = User.inputBuyPrice(); //입력칸

        int input2 = Lotto.buyScuessCount(input); //8개를 구입하셨습니다

        User user = new User();
        Lotto.buySucess(input2);
        List<List<Integer>> lottoRandomNumber = User.lottoRandomNumber(input2);


        Lotto.sayLottoNumber();     //32번
        String lottoListSix = user.lottoListSix();
        List<Integer> InputList = Validator.InputList(lottoListSix);

        Lotto.bonusSay();
        int bonusNumber = User.bonusNumber();
        Validator.ValidatorBonusRepeatNumber(InputList, bonusNumber);


        Lotto.CountNumberMessage();
        List<Integer> toResult = Lotto.toResult(InputList, lottoRandomNumber); //43

        System.out.println(toResult);

        List<Boolean> BonuseChooseList = Lotto.BonusChooseList(lottoRandomNumber , bonusNumber);

        int[] ScoreNumber = Lotto.ScoreNumber(toResult,BonuseChooseList );


        Lotto.CountNumberMessage(ScoreNumber);

        int TotalNumber = Lotto.TotalNumber(toResult, BonuseChooseList);

        Lotto.decimalPointCirculator(TotalNumber, input);





    }
}
