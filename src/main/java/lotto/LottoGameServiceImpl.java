package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Map;

public class LottoGameServiceImpl implements LottoGameService{
    InputServiceImpl inputService;
    UserService userService;
    ResultServiceImpl resultService;
    Lotto lotto;
    public static int cntOfLotto = 0;
    public static int bonus = 0;
    public static List<Integer> listOfUserNum;

    @Override
    public void play() {
        getAllInputs();

    }

    @Override
    public void getAllInputs() {
        cntOfLotto = userService.getCntOfLotto(inputService.getUserPayMessage()); // 구매한 로또 개수
        listOfUserNum = userService.getUserNums(inputService.getUserNumsMessage()); // 사용자가 입력한 당첨 번호 리스트
        bonus = userService.getUserBonus(inputService.getUserBonusNumMessage()); // 사용자가 입력한 보너스 번호
    }

    @Override
    public Map<Rank, Integer> makeResult() {
        for (int cnt = 0; cnt < cntOfLotto; cnt++) {
            resultService.getCntOfMatchedNum(listOfUserNum, lotto.makeLotto());
        }

        return null;
    }

    @Override
    public void printAllResults() {

    }
}
