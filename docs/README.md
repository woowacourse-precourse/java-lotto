## 기능 목록
- [x] 로또 구입
  - [x] 구입 금액 입력 요청 메세지 출력 : "구입금액을 입력해 주세요."
  - [x] 구입 금액 입력 받기 -> camp.nextstep.edu.missionutils.Console의 readLine() 사용
    - 입력 조건
      - 1000원으로 나누어 떨어지는 숫자
    - [x] 입력 조건에 맞지 않는 입력에 대해 예외 처리 : IllegalArgumentException("[ERROR] 에러 메시지")
- [x] 로또 생성
  - [x] 로또 개수 계산 : 구입 금액 / 로또 한장 가격(1000원)
  - [x] 로또 생성 메시지 출력 : "(로또 개수)개를 구매했습니다."
  - [x] 로또 번호 6개 랜덤 생성하여 출력 -> 로또 개수만큼 반복
    - camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange() 사용하여 랜덤 값 추출
    - 오름차순 정렬
    - 로또 번호 조건
      - 숫자 범위 : 1 ~ 45
      - 중복 x
- [x] 당첨 번호 설정
  - [x] 당첨 번호 입력 요청 메시지 출력 : "당첨 번호를 입력해 주세요."
  - [x] 당첨 번호 입력 받기 -> camp.nextstep.edu.missionutils.Console의 readLine() 사용
    - 입력 조건
        - 숫자 범위 : 1 ~ 45
        - 중복 x
        - 쉼표(,)로 구분된 숫자 6개
    - [x] 입력 조건에 맞지 않는 입력에 대해 예외 처리 : IllegalArgumentException("[ERROR] 에러 메시지")
- [x] 보너스 번호 설정
    - [x] 보너스 번호 입력 요청 메시지 출력 : "보너스 번호를 입력해 주세요."
    - [x] 보너스 번호 입력 받기 -> camp.nextstep.edu.missionutils.Console의 readLine() 사용
      - 입력 조건
        - 숫자 범위 : 1 ~ 45
        - 숫자 1개
        - 당첨 번호와 중복 x
      - [x] 입력 조건에 맞지 않는 입력에 대해 예외 처리 : IllegalArgumentException("[ERROR] 에러 메시지")
- [x] 당첨 통계 출력
     ```
    당첨 통계
    ---
    3개 일치 (5,000원) - 1개
    4개 일치 (50,000원) - 0개
    5개 일치 (1,500,000원) - 0개
    5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    6개 일치 (2,000,000,000원) - 0개
    총 수익률은 62.5%입니다.
     ```
  - [x] 당첨 내역 생성
    - [x] 당첨 번호와 일치하는 로또 번호 개수 세기
    - [x] 등수 구하기
  - [x] 수익률 계산
    - [x] 총 당첨 금액 계산
      - 당첨 번호와 일치하는 로또 번호 개수에 해당하는 당첨 금액 더함
    - (총 당첨 금액 / 로또 총 구입액 * 100)%
    - 소수점 둘째 자리에서 반올림

## 클래스 설계
### controller
#### LottoCOntroller
- private final LottoService lottoService
- private final PurchaseView puchaseView
- private final LottoGenerateView lottoGenerateView
- private final WinningNumbersGenerateView winningNumbersGenerateView
- private final StatisticsView statisticsView
- public Money purchase()
- public List\<Lotto> generateLottos(Money money) 
- public WinningNumbers generateWinningNumbers()
- public void showStatistics(WinningNumbers winningNumbers, List\<Lotto> lottos) 
### service
#### LottoService
- public Money purchase(String purchaseAmount)
- public List\<Lotto> generateLottos(Money money)
- public WinningNumbers generateWinningNumbers(String numbers, String bonus)
- public Statistics generateStatistics(WinningNumbers winningNumbers, List\<Lotto> lottos)
#### LottoGenrateService
- public List\<Lotto> generate(Money money)
- private int calculateNumberOfLotto(Money money) 
- private List\<Integer> getSortedRandomLottoNumbers()
#### StatisticsGenerateService
- public Statistics generate(WinningNumbers winningNumbers, List\<Lotto> lottos)
- private Map<Grade, Integer> countGrade(WinningNumbers winningNumbers, List\<Lotto> lottos)
- private Map<Grade, Integer> initializeGradeCount()
- private Grade getGrade(WinningNumbers winningNumbers, Lotto lotto, int count)
- private float calculateEarningRate(int numberOfLotto, Map\<Grade, Integer> gradeCount)
- private int calculateEarning(Map\<Grade, Integer> gradeCount)
### view
#### PurchaseView
- public voidrequestPurchaseAmount()
- public String getPurchaseAmount()
#### LottoGenerateView
- public void printGeneratedLottos(List\<Lotto> lottos)
#### WinningNumbersGenerateView
- public void requestWinningNumbers() 
- public void requestBonusNumber()
- public String getInput()
#### StatisticsView
- public void printStatistics(Statistics statistics)
#### GuideMessage
- static final String PURCHASE_AMOUNT_REQUEST = "구입금액을 입력해 주세요.";
- static final String LOTTO_GENERATE_SUCCESS = "%d개를 구매했습니다.";
- static final String WINNING_NUMBERS_REQUEST = "당첨 번호를 입력해 주세요.";
- static final String BONUS_NUMBER_REQUEST = "보너스 번호를 입력해 주세요.";
- static final String STATISTICS_TITLE = "당첨 통계";
- static final String LINE = "---";
### domian
#### Money
- private final int amount
- public Money(String amount)
- private int validate(String stringAmount)
- public int getAmount()
#### Lotto 클래스 요구사항
- 제공된 `Lotto` 클래스를 활용해 구현해야 한다.
- `Lotto`에 매개 변수가 없는 생성자를 추가할 수 없다.
- `numbers`의 접근 제어자인 private을 변경할 수 없다.
- `Lotto`에 필드(인스턴스 변수)를 추가할 수 없다.
- `Lotto`의 패키지 변경은 가능하다.
#### Lotto
- private final List\<Integer> numbers
- public Lotto(List\<Integer> numbers)
- private void validate(List\<Integer> numbers)
- public List\<Integer> getNumbers()
- public String toString()
#### WinningNumbers
- private final List<Integer> numbers;
- private final int bonus;
- public WinningNumbers(String numbers, String bonus)
- private List\<Integer> validateNumbers(String stringNumbers)
- private String[] validateNumbersSize(String stringNumbers)
- private List\<Integer> validateIsNumber(String[] arrayNumbers)
- private void validateNumbersIsInRange(List\<Integer> numbers)
- private void validateNumbersIsNotDuplicated(List\<Integer> numbers)
- private int validateBonus(String bonusInput)
- public List\<Integer> getNumbers()
- public int getBonus()
### Statistics
- private Map\<Grade, Integer> gradeCount
- private float earningRate
- public Statistics(Map\<Grade, Integer> gradeCount, float earningRate)
- public Map\<Grade, Integer> getGradeCount()
- public float getEarningRate()
- public String toString()
### Grade
- FIRST("6개 일치", 6, 2000000000)
- SECOND("5개 일치, 보너스 볼 일치", 5, 30000000)
- THIRD("5개 일치", 5, 1500000)
- FOURTH("4개 일치", 4, 50000)
- FIFTH("3개 일치", 3, 5000) 
- NOTHING("", 0, 0)
- private final String condition
- private final int matchCount
- private final int prize
- Grade(String condition, int matchCount, int prize)
- public String getCondition()
- public int getMatchCount()
- public int getPrize()
- public String toString()
- private String getCommaNumber(int number)
#### ErrorMessage
- static final String PURCHASE_AMOUNT_IS_NOT_INT_ERROR_MESSAGE = "[ERROR] 구입금액은 숫자여야 합니다."
- static final String NOT_DEVIDED_BY_LOTTO_PIRCE_ERROR_MESSAGE = "[ERROR] 구입금액은 %d원 단위여야 합니다."
- static final String WINNING_NUMBERS_SIZE_ERROR_MESSAGE = "[ERROR] 당첨 번호의 개수가 %d개가 아닙니다."
- static final String WINNING_NUMBER_IS_NOT_INT_ERROR_MESSAGE = "[ERROR] 당첨 번호는 숫자여야 합니다."
- static final String WINNING_NUMBER_IS_NOT_IN_RANGE_ERROR_MESSAGE = "[ERROR] 당첨 번호는 1~45 사이의 숫자여야 합니다."
- static final String WINNING_NUMBER_IS_DUPLICATED_ERROR_MESSAGE = "[ERROR] 당첨 번호는 중복이 없어야 합니다."
- static final String BONUS_IS_NOT_IN_RANGE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다."
- static final String BONUS_IS_DUPLICATED_ERROR_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다."
- static final String BONUS_IS_NOT_INT_ERROR_MESSAGE = "[ERROR] 보너스 번호는 숫자여야 합니다."
#### LottoSettings
- public static final int LOTTO_SIZE = 6
- public static final int LOTTO_PRICE = 1000
- public static final int LOTTO_NUMBER_RANGE_START = 1
- public static final int LOTTO_NUMBER_RANGE_END = 45
#### Unit
- static final String MONEY = "원"
- static final String NUMBER = "개"
