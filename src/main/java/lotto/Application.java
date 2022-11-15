package lotto;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        try {
            Input input = new Input();
            input.purchaseAmount();
            User user = new User(Integer.parseInt(input.getInput()));
            purchaseLotto(user);
            System.out.println("\n"+user.getLottoPurchaseCount() + LottoPrint.boughtLotto.getDescription());
            printUserLottos(user);
            input.winningNumber();
            Lotto winLotto = new Lotto(makeWinLottoNumber(input.getInput()));
            input.bonusNumber(winLotto.getNumbers());
            int bonusNumber = Integer.parseInt(input.getInput());
            Hashtable<Integer, Integer> counts = countsInitialization();
            userLottoCheck(counts, user.getLottos(),winLotto,bonusNumber);
            System.out.println(LottoPrint.winningStatistics(counts));
            calculateProfit(counts,user.getPurchaseAmount());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static Hashtable<Integer,Integer> countsInitialization(){
        Hashtable<Integer,Integer> counts = new Hashtable<>();
        for (int i = 3; i <= 7; i++){
            counts.put(i,0);
        }
        return counts;
    }

    public static void winningLottoCheck(List<Integer> numbers){
        for (int number: numbers
        ) {
            if (1> number || number > 45){
                throw new IllegalArgumentException(ErrorPrint.lottoNumber.getErrorMessage());
            }
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
        winningLottoCheck(lottoNumber); // 만들어진 로또 번호가 1~45 사이의 값을 가지고 있는 검증
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

    public static void calculateProfit(Hashtable<Integer,Integer> counts, int purchaseAmount){
        double profit = counts.get(7) * 30000000;
        List<Integer> winningAmount = new ArrayList<>(Arrays.asList(5000,50000,150000,2000000000));
        for (int i = 3; i <= 6; i++){
            profit += counts.get(i) * winningAmount.get(i - 3);
        }
        System.out.println(LottoPrint.profitReturn(profit/purchaseAmount*100));
    }
}
