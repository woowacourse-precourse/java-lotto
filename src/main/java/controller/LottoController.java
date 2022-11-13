package controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.LottoBonus;
import lotto.Money;
import view.UserOutput;
import view.UserInput;
import lotto.WinningLotto;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final UserInput userInput = new UserInput();
    private final UserOutput userOutput = new UserOutput();
    private Lotto lotto;
    private LottoBonus lottoBonus;
    private WinningLotto winningLotto;

    //로또 시작하기
    public void lottoStart(){
        userOutput.printRandomLottoList(makeRandomLottoNumber(buyLotto()));
        makeLottoWinningNumber();

    }

    //로또 구매 금액 입력 시, 검증 후에 몇개의 로또를 살 수 있는지 출력하는 메서드
    public int buyLotto(){
        Money money = new Money(userInput.inputMoney());
        userOutput.printLottoCount(money.getTicketCount());
        return money.getTicketCount();
    }

    //당첨번호 입력 시 로또 검증해야 함
    public void makeLottoWinningNumber(){
        winningLotto = new WinningLotto(userInput.inputWinningNumber());
        lotto = new Lotto
                (winningLotto.getWinningNumbers());
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



}
