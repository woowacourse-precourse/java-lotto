package lotto;

import java.util.*;

public class Application {
    static int money;   // 돈 액수
    static int[] correctNums;   // 당첨 번호 리스트
    static int bonusNum;    // 보너스 번호

    static int cntLotto;    // 로또 수량
    static List<Lotto> lottos;  // 생성한 로또들의 목록

    /**
     * nums[i]와 nums[0]~nums[i-1] 까지를 비교해서
     * 전부 다르다면 0을 반환하고 하나라도 같다면 1을 반환한다.
     */
    static int subLoop(int i, List<Integer> nums){
        int result = 0;
        for(int idx = 0; idx < i; idx++){
            if(nums.get(i) == nums.get(idx)){
                result = 1;
                break;
            }
        }
        return result;
    }

    /**
     * 중복값 없이 1부터 45 까지의 난수 리스트 6개를 생성해 반환한다.
     */
    static List<Integer> createRandomNumberList(){
        List<Integer> nums = new ArrayList<>(6);
        for(int i = 0; i < nums.size(); i++){
            nums.set(i, (int) (Math.random() * 45 + 1));
            i -= subLoop(i, nums);
        }
        return nums;
    }

    /**
     * List<Integer>을 오름차순으로 정렬해 반환한다.
     */
    static List<Integer> sortRandomNumberList(List<Integer> randomNumberList){
        Collections.sort(randomNumberList);
        return randomNumberList;
    }

    /**
     * 로또 1장을 생성해 Lotto를 반환한다.
     */
    static Lotto createLottoOne(){
        return new Lotto(sortRandomNumberList(createRandomNumberList()));
    }

    /**
     * cntLotto 의 개수만큼 로또를 생성한다.
     */
    static void createLottoList(){
        cntLotto = money / 1000;
        for(int i = 0; i < cntLotto; i++){
            lottos.add(createLottoOne());
        }
    }

    /**
     * 발행한 로또 수량 및 번호를 출력한다.
     * 로또 번호는 오름차순으로 정렬하여 보여준다.
     */
    static void printLotto(){
        System.out.println(cntLotto + "개를 구매했습니다.");   // 로또 수량 출력
        for(int i = 0; i < cntLotto; i++){
            System.out.println(lottos.get(i).toString());
        }
        System.out.println();
    }

    /**
     * 숫자를 입력받아 1000으로 나누어 떨어지지 않을 경우 예외 처리
     * @param num
     */
    static void checkCanDivideBy1000(int num){
        if(num % 1000 != 0){
            System.out.println("[ERROR] 1000원 단위의 금액을 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 로또 구입 금액 입력
        System.out.println("구입 금액을 입력해주세요");
        Scanner sc = new Scanner(System.in);
        money = sc.nextInt();
        System.out.println();

        // 1000원으로 나누어 떨어지지 않는 경우 예외 처리
        checkCanDivideBy1000(money);

        // 사용자가 입력한 금액/1000만큼의 로또를 생성한다.
        createLottoList();

        // 발행한 로또 수량 및 번호를 출력. 로또 번호는 오름차순으로 정렬해서 보여준다.
        printLotto();


        // 당첨 번호를 입력
        String inputNumbers = sc.next();
        String[] splitedNumbers = inputNumbers.split(",");

        correctNums = Arrays.stream(splitedNumbers)
                .mapToInt(Integer::parseInt)
                .toArray();

        // 보너스 번호 입력
        bonusNum = sc.nextInt();

    }
}
