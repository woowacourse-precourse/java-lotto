package controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.LottoBonus;
import lotto.Money;
import view.UserOutput;
import view.UserInput;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoController {
    private UserInput userInput = new UserInput();
    private UserOutput userOutput = new UserOutput();
    private Lotto lotto;
    private LottoBonus lottoBonus;
    private List<String> winningNumbers;

    //로또 시작하기
    public void lottoStart(){
        userOutput.printRandomLottoList(makeRandomLottoNumber(buyLotto()));
        makeLottoWinningNumber();
        makeLottoBonusNumber();

    }

    //로또 구매 금액 입력 시, 검증 후에 몇개의 로또를 살 수 있는지 출력하는 메서드
    public int buyLotto(){
        Money money = new Money(userInput.inputMoney());
        userOutput.printLottoCount(money.getTicketCount());
        return money.getTicketCount();
    }

    //당첨번호를 리스트로 넣기
    public List<Integer> setWinningNumberBasedOnComma(String input){
        winningNumbers = Stream.of(input.split("\\s*,\\s*"))
                .collect(Collectors.toList());

        List<Integer> winningNumbersConvert = winningNumbers.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        return winningNumbersConvert;
    }

    //당첨번호 입력 시 로또 검증해야 함
    public void makeLottoWinningNumber(){
        lotto = new Lotto
                (setWinningNumberBasedOnComma(userInput.inputWinningNumber()));
    }

    //구매한 장수만큼 로또 랜덤 생성하기
    public List<List<Integer>> makeRandomLottoNumber(int count){
        List<List<Integer>> randomLottoNumber = new ArrayList<>();

        for(int i = 0; i < count ; ++i) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lotto = new Lotto(numbers);
            randomLottoNumber.add(numbers);
        }
        return randomLottoNumber;
    }

    //보너스 번호 입력 로직 실행
    public int makeLottoBonusNumber(){
        lottoBonus = new LottoBonus(userInput.inputBonusNumber());
        return lottoBonus.getBonusNumber();
    }

}
