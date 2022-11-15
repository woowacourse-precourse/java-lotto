# 미션 - 로또



## 🚀 기능 요구 사항

로또 게임 기능을 구현해야 한다. 로또 게임은 아래와 같은 규칙으로 진행된다.

```
- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
```

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.

- 로또 1장의 가격은 1,000원이다.

- 당첨 번호와 보너스 번호를 입력받는다.

- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.

- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료한다.

  

### 입출력 요구 사항

#### 입력

- 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.

```
14000
```

- 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.

```
1,2,3,4,5,6
```

- 보너스 번호를 입력 받는다.

```
7
```

#### 출력

- 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.

```
8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]
```

- 당첨 내역을 출력한다.

```
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
```

- 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)

```
총 수익률은 62.5%입니다.
```

- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.

```java
[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
```

<br>




## 🎯구현 기능 목록

### Class

#### Application

**메소드**

- lottoMachine() : LottoMachine 객체 반환
- person() : Person 객체 반환
- lottoController(LottoMachine, Person) -> LottoController
  -  LottoController 객채를 생성한다.



#### LottoController

**상수**

- String perPrizeStringFormat : 로또 당첨 등수에 따른 문자열 포맷

- String returnRateStringFormat : 수익률 문자열 출력 포맷

- LottoMachine lottoMachine : 로또 기계 객체

- Person person : 사람 객체

**메소드**

- runLotto() : 로또 프로그램 실행시킨다.
- printAggregatedResult() : 로또 구매 결과와 수익률 등 당첨 통계를 출력



#### Lotto 

**상수**

- LottoValidator validator : 로또관련 유효성 검사 실행 객체

**필드**

- List<Integer> numbers : 로또 번호 리스트

**메소드**

- validate(List\<int\> numbers) -> void 
  - 로또 번호 유효성 검사

- getLottoNumbers() -> List<int> numbers 
  - 해당 로또의 번호 반환



#### WinningLotto

**상수**

- WinningLotto winningLotto : 싱글톤 객체

**필드**

- List<Integer> winningLottoNumber : 당첨 로또 번호 리스트

- int winningBonusNumber : 당첨 보너스 번호

**메소드**

- getInstance() -> WinningLotto 
  - 당첨 로또에 해당하는 객체를 반환
- getWinningLottoNumber() -> List<Integer> 
  -  당첨 로또 번호를 반환
- getWinningBonusNumber() -> int 
  - 당첨 보너스 번호를 반환



#### LottoMachine

**메소드**

- generateLottoNumber(int, int, int) -> List<int> 
  - 입력받은 개수의 유효한 로또 번호를 생성하여 리스트로 반환
- isValidUnit(int) -> boolean
  - 입력받은 정수가 로또 가격으로 나누어 지는지 확인
- countPurchaseQuantity(int) -> int 
  -  투입한 금액에 해당하는 로또 개수를 반환
- sellLottos() -> List<Lotto>
  - 사용자로부터 구입 금액을 입력받은 후 해당하는 개수의 로또 리스트 반환



#### Person

**필드**

- List<Integer> lottos : 구매한 로또 객체 리스트
- HashMap<LottoPrize, Integer> lottoResults : 로또 결과와 해당 로또 당첨 개수

**메소드**

- buyLottos(LottoMachine) : 로또기계로부터 로또를 구입한다.
- countCorrectLottoNumber(Lotto) -> int:
  - 맞은 로또 번호 개수를 반환
- countCorrectBonusNumber(Lotto) -> int:
  - 맞은 보너스 번호 개수를 반환
- checkLottoResult(Lotto) -> LottoPrize:
  -  로또의 결과에 맞는 LottoPrize 반환
- resetLottoResult() : person의 로또 결과들을 초기화한다.
- setLottoResult() : person의 로또 리스트들의 결과들을 확인하여 results에 저장
- sumPrize() -> int 
  - 로또 결과들의 총 당첨금을 계산하여 반환
- getReturnRate() -> float
  - 로또의 수익률을 계산하여 반환
- getLottoResult() -> HashMap<LottoPrize, Integer>(당첨 등수, 당첨된 개수)
  - 로또 결과에 해당하는 HashMap을 반환한다.



#### LottoInputFilter

**상수**

- String inputLottoNumberStringFormat : 로또 번호 입력 요청 메세지 출력 포맷
- String inputAmountStringFormat : 구입 금액 입력 요청 메세지 출력 포맷
- String inputBounsNumberStringFormat : 보너스 번호 입력 요청 메세지 출력 포맷
- LottoValidator validator : 로또 번호 validator 객체

**메소드**

- readLottoNumber() -> List<Integer>
  - 사용자로부터 로또 번호를 입력받아 유효성을 검사하여 반환
- readBonusNumber() -> int:
  - 사용자로부터 보너스 번호를 입력받아 유효성 검사하여 반환
- readPurchaseAmount() -> int:
  - 사용자로부터 구입 금액을 입력받아 유효성 검사하여 반환



#### LottoValidator

**상수**

**필드**

**메소드**

- getInstance() -> LottoValidator:
  - validator 객체 반환
- isPositiveInteger(String) -> boolean
  - 입력받은 문자열이 양의 정수 포맷 문자열인지 확인
- isPositiveInteger(int) -> boolean
  - 입력받은 정수가 양의 정수인지 확인
- isValidRange(int) -> boolean
  - 입력받은 정수가 유효한 로또 범위의 수인지 확인
- isValidRangeNumbers(List<Integer>) -> boolean
  - 리스트의 숫자들이 유효한 로또 범위의 수인지 확인
- isDuplicated(List<Integer>) -> boolean
  - 리스트의 숫자들이 중복이 존재하는지 확인



### Enum

#### ErrorEessage Enum

**Types**

NON_POSITIVE_INTEGER : 양의 정수 입력이 아닌 경우

INVALID_RANGE : 유효한 값의 범위가 아닌 경우

DUPLICATED_NUMBER : 중복된 숫자가 존재하는 경우

INVALID_LOTTO_SIZE : 유효한 로또 숫자 개수가 아닌 경우

INVALID_PURCHASE_UNIT : 구매 금액이 유효한 단위가 아닌 경우

NON_POSITIVE_AMOUNT : 구매 금액이 양의 정수가 아닌 경우



**메소드**

getMessage() -> String : 각 에러에 맞는 에러 메세지 반환



#### LottoPrize Enum

**Types**

FIRST_PRIZE

SECOND_PRIZE

THIRD_PRIZE

FOUTH_PRIZE

FIFTH_PRIZE

NO_PRIZE

**메소드**

getPrizeinfo() -> String : 당첨 개수 정보와 상금 정보 문자열 반환

getPrizeMoney() -> int : 당첨금 금액 반환

getPrize(int correctLottoNumberCount, int correctBonusNumberCount) -> LottoPrize : 맞은 로또 번호 개수, 보너스 번호 개수에 맞는 당첨 결과 반환





#### LottoConstant enum

**Types**

SIZE : 로또 번호 개수

STARTFROM : 로또 시작 범위

ENDTO : 로또 종료 범위

PRICE : 로또 가격

**메소드**

getValue() -> int : 해당 값 반환
