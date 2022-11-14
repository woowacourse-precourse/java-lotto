package lotto;

import domain.Rank;
import utils.LottoGenerator;
import view.InputServiceImpl;
import view.PrintServiceImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGameServiceImpl implements LottoGameService {
    InputServiceImpl inputService = new InputServiceImpl();
    UserService userService = new UserServiceImpl();
    ResultServiceImpl resultService = new ResultServiceImpl();
    PrintServiceImpl printService = new PrintServiceImpl();
    LottoGenerator lottoGenerator = new LottoGenerator();
    public static int userPayment = 0;
    public static int cntOfLotto = 0;
    public static int bonus = 0;
    public static List<Integer> listOfUserNum = new ArrayList<>();
    public static Map<Rank, Integer> gameResult = new HashMap<>();
    public List<List<Integer>> lottoList = new ArrayList<>();

    @Override
    public void play() {
        getAllInputs();
        makeLottoList();
        makeResult();
        printAllResults();
    }

    @Override
    public void getAllInputs() {
        userPayment = inputService.getUserPayMessage();
        cntOfLotto = userService.getCntOfLotto(userPayment);
        listOfUserNum = userService.getUserNums(inputService.getUserNumsMessage());
        bonus = userService.getUserBonus(inputService.getUserBonusNumMessage());
    }

    @Override
    public List<List<Integer>> makeLottoList() {
        for (int cnt = 0; cnt < cntOfLotto; cnt++) {
            lottoList.add(lottoGenerator.makeLotto());
        }
        return lottoList;
    }

    @Override
    public Map<Rank, Integer> makeResult() {
        gameResult = resultService.getResult(listOfUserNum, lottoList, bonus);
        return gameResult;
    }

    @Override
    public void printAllResults() {
        printService.printLotto(lottoList);
        printService.printWinningResult(gameResult, resultService.getYield(gameResult, userPayment));
    }
}
