## 🔖 기능 목록

### UI
- [X] 로또 구매 금액 입력 받기 - NumberScanner#inputPayment()
  - [X] 정수로 변환할 수 없는 경우 예외처리 - NumberScanner#validateParseInt(String input, ErrorType errorType)
- [X] 당첨 번호 입력 받기  - NumberScanner#inputwinningLottoNumbers()
  - [X] 쉼표(,)를 기준으로 당첨 번호 입력 값 나누기 - NumberScanner#splitByDelimiter()
  - [X] 각 문자열이 정수로 변환할 수 없는 경우 예외처리 - NumberScanner#validateParseInt(String input, ErrorType errorType)
- [X] 보너스 번호 입력 받기 - NumberScanner#inputBonusNumber()
  - [X] 정수로 변환할 수 없는 경우 예외처리 - NumberScanner#validateParseInt(String input, ErrorType errorType)

- [X] 구입금액 입력 안내 메시지 출력 - MessagePrinter#printStaticPaymentNotification()
- [X] 구매한 로또 수 출력 - MessagePrinter#printDynamicLottoAmount(Buyer buyer)
- [X] 구매한 로또 리스트 출력 - MessagePrinter#printDynamicLottosBought(Buyer buyer)
- [X] 당첨 번호 입력 안내 메시지 출력 - MessagePrinter#printStaticWinningLottoNumbersNotification()
- [X] 보너스 번호 입력 안내 메시지 출력 - MessagePrinter#printStaticBonusNumberNotification()
- [X] 당첨 내역 출력(구매한 로또 리스트가 로또 등수 별로 몇 개씩 당첨 됐는지) - MessagePrinter#printDynamicWinningRecord()
- [X] 당첨 통계 제목 출력 - MessagePrinter#printStaticStatisticsTopic()
- [X] 문단 구분자 출력 - MessagePrinter#printStaticParagraphDivision()
- [ ] 총 수익률 출력 - MessagePrinter#printDynamicEarningsRate()
---


### Domain


#### Buyer
- [X] 구매 금액에 맞춰 구매할 수 있는 로또 수만큼 로또 생성 - Buyer#Buyer(int won)
  - [X] 구매 가능한 수만큼 로또 생성 - Randoms#pickUniqueNumbersInRange()
- [X] 구매 금액을 통해 몇 장의 로또를 구매할 수 있는지 계산 - Buyer#calculateNumberOfLottos(int won)
  - [X] 1,000 미만의 값인 경우 예외처리 - Buyer#validateIsUnderLottoPrice(int won) 
  - [X] 1,000 단위로 나누어 떨어지지 않는 경우, 1,000 단위 아래는 버림 처리 (ex. 1,200 -> 1,000) - Buyer#roundDownLottoPriceUnits(int won)
- [X] 로또 리스트 반환 - Buyer#getLottos() 


#### Lotto
- [X] 로또 생성 Lotto#Lotto(List<Integer> numbers)
  - [X] 로또 번호 리스트의 사이즈가 6인지 검증 Lotto#validateLottoSize(List<Integer> numbers)
  - [X] 로또의 각 번호가 1~45 숫자 범위 내에 있는지 검증 Lotto#validateEachNumberInRange(List<Integer> numbers)
  - [X] 로또의 각 번호가 중복되는지 검증 Lotto#validateHasDuplicate(List<Integer> numbers)
  - [X] 로또 번호 리스트를 오름차순으로 정렬 Lotto#ascendingSort(List<Integer> numbers)
- [X] 로또 1장 가격 상수 처리 (1000) 
- [X] 로또 번호 리스트 사이즈 상수 처리 (6)
- [X] 로또 각 번호 숫자 범위 상수 처리 (1~45)
- [X] 로또 번호 리스트에 보너스 번호가 포함되어 있는지 확인 Lotto#containsBonusNumber(int bonusNumber)
- [X] 로또 번호 리스트 반환 Lotto#getNumbers()


#### Bonus
- [X] 보너스 번호 생성 - Bonus#Bonus(int number)
  - [X] 보너스 번호가 1~45 범위 내의 수인지 검증 - Bonus#validateNumberInRange(int number)
- [X] 보너스 번호 값 반환 - Bonus#getNumber()


#### WinningLotto
- [X] 로또 당첨 정보(로또 번호 + 보너스 번호) 생성 WinningLotto#WinningLotto(Lotto winningLotto, Bonus bonus)
  - [X] 보너스 번호가 로또 당첨 번호에 포함되어 있는지 검증 - WinningLotto#validateWinningLottoContainsBonusNumber(Lotto winningLotto, Bonus bonus)
- [X] 당첨 로또 번호 리스트 반환 - WinningLotto#getWinningLottoNumbers() 
- [X] 보너스 번호 반환 - WinningLotto#getBonusNumber() 

#### Rank (Enum)
- [X] 1등부터 5등까지 상수로 선언
- [X] 1등부터 5등까지 각 상수가 가져야 하는 값으로 로또 번호 몇 개를 맞춰야 하는지와 상금 정보 추가 (ex. 6개 일치 (2,000,000,000원))
- [X] 각 상수가 갖고 있는 값 반환
- [X] 3개 미만 일치하는 경우를 표기하기 위한 상수 선언


#### Judgement
- [X] 로또 번호 리스트와 당첨 로또 번호 리스트 + 보너스 번호 비교 후 몇 등인지 확인 - Judgement#getLottoRank(Lotto lotto, Lotto winningLotto)
  - [X] 로또 번호 리스트 중 당첨 번호와 다른 번호만 추출 한 것을 포함하고 있는 리스트 생성 - Judgement#compare(Lotto lotto, Lotto winningLotto)


#### Statistics
- [X] 구매한 모든 로또에 대해 몇 등을 기록했는지 저장 - Statistics#record(Rank rank)
  - [X] Map<Rank, Integer> 자료 구조를 활용해 1~5등까지 각각 0개씩 초기화
- [X] 로또 당첨 내역 자료 구조 반환 - Statistics#getRankRecord()
- [X] 수익률 반환 - Statistics#getEarningsRate()
- [X] 발행된 Lotto 수와 총 당첨금 정보를 활용해 수익률 계산 - Statistics#calculateEarningsRate()
  - [X] 총 몇 개의 로또를 구매 했는지 계산 - Statistics#calculateNumberOfLottosPaid()
  - [X] 로또 등수 별로 상금 정보 초기화
  - [X] 총 당첨 수익 계산 - Statistics#calculateEarnings()
  - [X] 소수점 둘째 자리에서 반올림 처리 (ex. 100.0%, 51.5%, 1,000,000.0%) - Statistics#roundToTwoDecimalPlaces()
  
#### ErrorType 
- [X] 입력 에러 관련 에러 타입 상수 선언
  - [X] 로또 구매 금액 입력 에러 
  - [X] 당첨 번호 입력 에러
  - [X] 보너스 번호 입력 에러
- [X] 도메인 에러 관련 에러 타입 상수 선언
  - [X] 로또 구매 금액이 로또 1매 판매 가격보다 적은 에러
  - [X] 로또 번호 리스트가 6개의 숫자로 구성되지 않은 에러
  - [X] 로또 각 번호가 로또 숫자 범위를 초과하는 에러
  - [X] 로또 각 번호가 중복되는 에러
  - [X] 로또 당첨 번호가 보너스 번호를 포함하는 에러
- [X] 입력 에러 메시지 반환
---


### Domain Test


#### BuyerTest
- [X] 구매자가 로또 한 장 가격인 1,000원 미만의 금액으로 로또를 구매하려고 하면 예외가 발생한다. - BuyerTest#createBuyerByUnderLottoPrice() 
- [X] 구매자가 입력한 구매 금액에 맞춰 몇 장의 로또를 구매할 수 있는지 알 수 있다. - BuyerTest#calculateNumberOfLottos()


#### LottoTest
- [X] 로또 번호의 개수가 6개가 넘어가면 예외가 발생한다. - LottoTest#createLottoByOverSize()
- [X] 로또 번호에 중복된 숫자가 있으면 예외가 발생한다. - LottoTest#createLottoByDuplicatedNumber()
- [X] 로또 번호 중 1~45 숫자 범위 내에 없는 수가 있으면 예외가 발생한다. - LottoTest#createLottoByExceedNumberRange()
- [X] 로또 생성 시 오름차순으로 정렬된다. - LottoTest#createLottoByAscendingOrder()
- [X] 로또 번호 리스트의 보너스 번호 포함 여부를 알 수 있다. - LottoTest#containsBonusNumber()
- [X] 로또 번호 리스트를 조회할 수 있다. - LottoTest#getLottoNumbers()


#### BonusTest
- [X] 보너스 번호가 1~45 숫자 범위에 포함되지 않은 경우 예외가 발생한다. - BonusTest#createBonusByExceedNumberRange()


#### WinningLottoTest
- [X] 당첨 로또 번호 리스트가 보너스 번호를 포함하고 있는 경우 예외가 발생한다. - WinningLottoTest#createWinningLottoByWinningLottoContainsBonusNumber()


#### JudgementTest
- [X] 로또 당첨 번호와 비교하여 구매 로또가 몇 등에 해당하는지 알 수 있다. - JudgementTest#getLottoRank()


#### StatisticsTest
- [X] 기록 전, 1등부터 5등까지 모두 0으로 초기화 상태이다. - StatisticsTest#isInitializedZeroCount()
- [X] 각 등수 별로 몇 번씩 당첨됐는지 기록한다. - StatisticsTest#record()