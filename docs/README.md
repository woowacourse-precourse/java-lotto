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
    - [ ] 입력 조건에 맞지 않는 입력에 대해 예외 처리 : IllegalArgumentException("[ERROR] 에러 메시지")
- [x] 보너스 번호 설정
    - [x] 보너스 번호 입력 요청 메시지 출력 : "보너스 번호를 입력해 주세요."
    - [x] 보너스 번호 입력 받기 -> camp.nextstep.edu.missionutils.Console의 readLine() 사용
      - 입력 조건
        - 숫자 범위 : 1 ~ 45
        - 숫자 1개
        - 당첨 번호와 중복 x
      - [x] 입력 조건에 맞지 않는 입력에 대해 예외 처리 : IllegalArgumentException("[ERROR] 에러 메시지")
- [ ] 당첨 통계 출력
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
  - [ ] 수익률 계산
    - [ ] 총 당첨 금액 계산
      - 당첨 번호와 일치하는 로또 번호 개수에 해당하는 당첨 금액 더함
    - (총 당첨 금액 / 로또 총 구입액 * 100)%
    - 소수점 둘째 자리에서 반올림

## 클래스 설계
### Lotto 클래스 요구사항
- 제공된 `Lotto` 클래스를 활용해 구현해야 한다.
- `Lotto`에 매개 변수가 없는 생성자를 추가할 수 없다.
- `numbers`의 접근 제어자인 private을 변경할 수 없다.
- `Lotto`에 필드(인스턴스 변수)를 추가할 수 없다.
- `Lotto`의 패키지 변경은 가능하다.
### Lotto
- numbers : private final List<Integer>
- Lotto(List\<Integer> numbers) : public constructor
- validate(List\<Integer> numbers) : private void
### LottoPurchaser
- purchaseAmount : private final int
- LottoPurchaser() : public constructor
- purchase() : private int
- validate(int purchaseAmount) : private void
- getter
### LottoGenerator
- LOTTO_SIZE : static final int
- LOTTO_PRICE : static final int
- numberOfLotto : private final int
- lottos : private final List\<Lotto>
- LottoGenerator(int purchaseAmount) : public constructor
- generate() : private List\<Lotto> 
- getter
### WinningNumbers
- numbers : private final List<Integer>
- bonus : private final int
- WinningNumbers() : public constructor
- initializeNumbers() : private List\<Integer>
- initializeBonus() : private int
- validateNumbers() : private void
- validateBonus() : private void
- getter
### Statistics
- winningCount : private int[]
- earningRate : private int
- Statistics(List<Integer> winningNumbers, List<Lotto> lottos) : public constructor
- compare() : private void
- calculateEarningRate() : private void
- calculateEarning() : private int
- getter
- toString() : public String
### WinningClass
- FIRST("6개 일치", 2000000000)
- SECOND("5개 일치, 보너스 볼 일치", 30000000)
- THIRD("5개 일치", 1500000)
- FOURTH("4개 일치", 50000)
- FIFTH("3개 일치", 5000)
- condition : private final String
- prize : private final int
- WinningClass(String condition, int prize) : public constructor
- getter
- toString() : public String
### Message
- PURCHASE_AMOUNT_REQUEST :  "구입금액을 입력해 주세요."
- LOTTO_GENERATE_SUCCESS : "개를 구매했습니다."
- WINNING_NUMBERS_REQUEST : "당첨 번호를 입력해 주세요."
- BONUS_NUMBER_REQUEST : "보너스 번호를 입력해 주세요."
- STATISTICS_TITLE : "당첨 통계"
- START_OF_EARNING_RATE : "총 수익률은 "
- END_OF_EARNING_RATE : "%입니다."
### Unit
- MONEY : "원"
- NUMBER : "개"
