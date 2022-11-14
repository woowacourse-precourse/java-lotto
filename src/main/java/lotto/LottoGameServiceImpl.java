package lotto;
import ui.InputServiceImpl;
import ui.PrintServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGameServiceImpl implements LottoGameService{
    InputServiceImpl inputService = new InputServiceImpl();
    UserService userService = new UserServiceImpl();
    ResultServiceImpl resultService = new ResultServiceImpl();
    PrintServiceImpl printService = new PrintServiceImpl();
    public static int userPayment = 0;
    public static int cntOfLotto = 0;
    public static int bonus = 0;
    public static List<Integer> listOfUserNum = new ArrayList<>();
    public static Map<Rank, Integer> gameResult = new HashMap<>();
    public static List<List<Integer>> lottoList = new ArrayList<>();

    @Override
    public void play() {
        getAllInputs();
        makeLottoList();
        makeResult();
        printAllResults();
    }

    @Override
    public void getAllInputs() {
        userPayment = inputService.getUserPayMessage(); // 구매 금액
        cntOfLotto = userService.getCntOfLotto(userPayment); // 구매한 로또 개수
        listOfUserNum = userService.getUserNums(inputService.getUserNumsMessage()); // 사용자가 입력한 당첨 번호 리스트
        bonus = userService.getUserBonus(inputService.getUserBonusNumMessage()); // 사용자가 입력한 보너스 번호
    }

    @Override
    public Map<Rank, Integer> makeResult() {
        gameResult = resultService.getResult(listOfUserNum, lottoList, bonus);
        return gameResult;
    }

    @Override
    public List<List<Integer>> makeLottoList() {
        for (int cnt = 0; cnt < cntOfLotto; cnt++) {
            lottoList.add(Lotto.makeLotto());
        }
        return lottoList;
    }

    @Override
    public void printAllResults() {
        printService.printLotto(lottoList);
        printService.printWinningResult(gameResult, resultService.getYield(gameResult, userPayment));
    }
}
