package lotto;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
import java.io.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        System.out.println("구입금액을 입력해 주세요.");
        String input = readLine();
        purchaseAmountValidation(input);
        User user = new User(Integer.parseInt(input));

        purchaseLotto(user);
        System.out.println(user.getLottoPurchaseCount() + "개를 구매했습니다.");
        printUserLottos(user);

        System.out.println("당첨 번호를 입력해 주세요.");
        input = readLine();
        lottoInputValidation(input);
        Lotto winLotto = new Lotto(makeWinLottoNumber(input));


        System.out.println("보너스 번호를 입력해 주세요.");
        input = readLine();
        bonusInputValidation(input);
        int bonusNumber = Integer.parseInt(input);

        Hashtable<Integer, Integer> counts = countsInitialization();
        userLottoCheck(counts, user.getLottos(),winLotto,bonusNumber);
        winningStatistics(counts);

        calculateProfit(counts,user.getPurchaseAmount());

    }

    public static Hashtable<Integer,Integer> countsInitialization(){
        Hashtable<Integer,Integer> counts = new Hashtable<>();
        for (int i = 3; i <= 7; i++){
            counts.put(i,0);
        }
        return counts;
    }

    public static void purchaseAmountValidation(String purchaseAmount) throws IllegalArgumentException{
        if (!purchaseAmount.matches("[0-9]+")){
            System.out.println("[ERROR]");
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public static void lottoInputValidation(String lottoInput) throws IllegalArgumentException{
        if (!lottoInput.matches("[0-9,]+")){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void bonusInputValidation(String bonusInput) throws IllegalArgumentException{
        if (!bonusInput.matches("[0-45]")){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void purchaseLotto(User user){
        Lotto lotto;
        for (int i = 0; i < user.getLottoPurchaseCount(); i++){
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            lotto = new Lotto(numbers);
            user.addLotto(lotto);
        }
    }

    public static void printUserLottos(User user){
        StringBuilder printLottos = new StringBuilder();
        List<Lotto> lottos = user.getLottos();
        Lotto lotto;
        printLottos.append("\n");
        for (Lotto value : lottos) {
            lotto = value;
            printLottos.append(lotto.getNumbers().toString()).append("\n");
        }
        System.out.println(printLottos);
    }

    public static List<Integer> makeWinLottoNumber(String lottoInput){
        List<Integer> lottoNumber = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(lottoInput,",");
        while (stringTokenizer.hasMoreTokens()){
            lottoNumber.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        return lottoNumber;
    }

    public static int checkWinLotto(Lotto userLotto, Lotto winnerLotto, int bonusNumber){
        int count = 0;
        List<Integer> userLottoNumber = userLotto.getNumbers();
        List<Integer> winnerLottoNumber = winnerLotto.getNumbers();
        for (int i = 0; i < 6; i++){
            if (winnerLottoNumber.contains(userLottoNumber.get(i))) {
                count++;
            }
        }
        if (count == 5 && userLottoNumber.contains(bonusNumber)){
            count += 2;
        }
        return count;
    }

    public static void userLottoCheck(Hashtable<Integer,Integer> counts, List<Lotto> userLottos, Lotto winnerLotto, int bonusNumber){
        int count;
        for (Lotto userLotto : userLottos) {
            count = checkWinLotto(userLotto, winnerLotto, bonusNumber);
            if (counts.containsKey(count)) {
                counts.put(count, counts.get(count) + 1);
            }
        }
    }

    public static void winningStatistics(Hashtable<Integer,Integer> counts){
        String stringBuilder = "3개 일치 (5,000원) - " + counts.get(3) + "개\n" +
                "4개 일치 (50,000원) - " + counts.get(4) + "개\n" +
                "5개 일치 (1,500,000원) - " + counts.get(5) + "개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + counts.get(7) + "개\n" +
                "6개 일치 (2,000,000,000원) - " + counts.get(6) + "개\n";
        System.out.println(stringBuilder);
    }

    public static void calculateProfit(Hashtable<Integer,Integer> counts, int purchaseAmount){
        double profit = counts.get(7) * 30000000;
        profit += counts.get(3) * 5000;
        profit += counts.get(4) * 50000;
        profit += counts.get(5) * 150000;
        profit += counts.get(6) * 2000000000;
        System.out.println("총 수익률은 "+String.format("%.1f%%입니다.",profit/purchaseAmount*100));
    }
}
