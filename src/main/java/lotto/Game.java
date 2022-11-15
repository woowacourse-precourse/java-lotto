package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Lotto answerLotto;
    private final List<Lotto> myLotto = new ArrayList<>();
    private int bonusNumber;

    private final LottoManager lottoManager = new LottoManager();

    public void start(){
        System.out.println("구입금액을 입력해 주세요.");
        int inputCost = Integer.parseInt(Console.readLine());

        if (inputCost%1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력하세요");
        }

        int lottoCount = getCountOfLottoByCost(inputCost);
        System.out.println(lottoCount + "개를 구매했습니다.");

        for (int i = 0; i < lottoCount; i++) {
            myLotto.add(new Lotto(lottoManager.makeRandomLottoNumbers()));
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        answerLotto = new Lotto(getAnswerNumberList());

        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.parseInt(Console.readLine());
    }

    private List<Integer> getAnswerNumberList(){
        String numberLine = Console.readLine();

        List<Integer> numberList = new ArrayList<>();
        String[] numberSplit = numberLine.split(",");
        for(String number : numberSplit){
            numberList.add(Integer.parseInt(number));
        }

        return numberList;
    }

    private int getCountOfLottoByCost(int cost){
        return cost / 1000;
    }

    private void printMyLotto(){
        for(Lotto lotto : myLotto){
            System.out.println(lotto);
        }
    }

}
