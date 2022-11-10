package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Application {
    static final int LOTTO_PRICE = 1000;
    static int BONUS_NUMBER;
    static int numberOfPurchasedLotto;
    static List<Lotto> purchasedLotto =  new ArrayList<>();
    static final String ENTER_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    static final String LOTTO_PURCHASE_MESSAGE = "개를 구매했습니다.";
    public static void main(String[] args) {
//        validateGivenNumbers();
//        initializeBonusNumber();
        printLottoNumbers();
    }

    public static void enterTheAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        if(amount%LOTTO_PRICE!=0) throw new IllegalArgumentException();
        numberOfPurchasedLotto = amount/LOTTO_PRICE;
    }

    public static Lotto generateSixNumbers(){
        System.out.println(ENTER_WINNING_NUMBER);
        String inputNumbers = Console.readLine();
        String[] winningNumbersAsString = inputNumbers.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number: winningNumbersAsString) winningNumbers.add(Integer.parseInt(number));
        return new Lotto(winningNumbers);
    }

    public static boolean printTheErrorMessageIfNotInTheRange(List<Integer> numbers){
        for(int number: numbers){
            if(number<1 || number>45){
                System.out.println(ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    public static Lotto validateGivenNumbers(){
        Lotto lotto;
        do{
           lotto = generateSixNumbers();
        } while(!printTheErrorMessageIfNotInTheRange(lotto.getNumbers()));
        return lotto;
    }
    public static void initializeBonusNumber(){
        System.out.println(BONUS_NUMBER_MESSAGE);
        do{
            BONUS_NUMBER = Integer.parseInt(Console.readLine());
        } while(!printTheErrorMessageIfNotInTheRange(List.of(BONUS_NUMBER)));
    }

    public static Lotto generateRandomSixNumbers(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lottoNumbers);
    }

    public static void printLottoNumbers(){
        enterTheAmount();
        System.out.println(numberOfPurchasedLotto + LOTTO_PURCHASE_MESSAGE);
        for(int index=0; index<numberOfPurchasedLotto; index++){
            purchasedLotto.add(generateRandomSixNumbers());
            Collections.sort(purchasedLotto.get(index).getNumbers());
            System.out.println(purchasedLotto.get(index).getNumbers().toString());
        }
    }
}
