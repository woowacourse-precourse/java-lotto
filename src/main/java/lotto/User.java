package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class User {

    private static final String INFORMATION_MESSAGE = "구입금액을 입력해주세요.";
    private static final String INFORMATION_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String INFORMATION_USER_INPUT_MESSAGE = "당첨 번호를 입력해주세요.";
    private static final String INFORMATION_USER_INPUT_BONUS_MESSAGE = "보너스 번호를 입력해주세요.";

    private int price;
    private int lottoCount;
    private UserLotto userLotto;
    private final Exception exception;
    private ArrayList<Lotto> randomLottoNumbers;

    public User(){
        exception = new Exception();
        randomLottoNumbers = new ArrayList<Lotto>();
        userLotto = new UserLotto();
    }

    public void setPrice(){
        System.out.println(INFORMATION_MESSAGE);
        String strPrice = Console.readLine();
        exception.validateInteger(strPrice);
        this.price = Integer.parseInt(strPrice);
    }

    public int getPrice(){
        return this.price;
    }

    public void setLottoCount(){
        exception.validatePrice(this.price);
        this.lottoCount = price / 1000;
        System.out.println(lottoCount + INFORMATION_LOTTO_COUNT_MESSAGE);
    }

    public int getLottoCount(){
        return this.lottoCount;
    }

    public void setRandomLottoNumbers(){
        for(int i=0;i<lottoCount;i++){
            Lotto lotto = new Lotto(initNewLotto());
            exception.validateDuplicateLotto(lotto);
            randomLottoNumbers.add(lotto);
        }
    }

    public UserLotto getUserLotto(){
        return this.userLotto;
    }

    private List<Integer> initNewLotto(){
        List<Integer> lottos = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        ArrayList<Integer> lotto = new ArrayList<>();
        lotto.addAll(lottos);
        checkValidLotto(lotto);
        return lotto;
    }

    private void checkValidLotto(List<Integer> lottos) {
        exception.validateDuplicate(lottos);
        exception.validateLottoCount(lottos);
    }

    public List<Lotto> getRandomLottoNumbers(){
        return randomLottoNumbers;
    }

    public void setUserLotto(){
        setUserInputLottoNumbers();
        setUserInputLottoBonusNumber();
    }

    private void setUserInputLottoNumbers(){
        System.out.println(INFORMATION_USER_INPUT_MESSAGE);
        Set<Integer> winningNumber = getUserInputNumbers();
        userLotto.setNumbers(winningNumber);
    }

    private Set<Integer> getUserInputNumbers() {
        String inputWinningNumber = Console.readLine();
        String[] numberSplit = inputWinningNumber.split(",");
        Set<Integer> winningNumber = new HashSet<>();
        List<Integer> stringNumber = new ArrayList<Integer>();
        for(int i=0;i<numberSplit.length;i++){
            exception.validateInteger(numberSplit[i]);
            exception.validateDuplicateInputNumber(winningNumber, Integer.parseInt(numberSplit[i]));

            stringNumber.add(Integer.parseInt(numberSplit[i]));
        }

        return winningNumber;
    }

    private void setUserInputLottoBonusNumber(){
        System.out.println(INFORMATION_USER_INPUT_BONUS_MESSAGE);
        String inputBonus = Console.readLine();
        // +예외
        userLotto.setBonusNumber(Integer.parseInt(inputBonus));
    }
}
