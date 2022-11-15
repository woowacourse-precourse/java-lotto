## 전체 기능 요구사항 List Up
### 로또 게임 기본 기능 요구사항
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
### 로또 발행
- 사용자에게 입력받은 금액만큼 로또 발행
  - 로또 한개의 가격은 개당 1000원
  - 입력 금액이 1000원으로 나누어 떨어지지 않는 경우 예외 처리
- 당첨 번호와 보너스 번호를 입력받는다

### 로또 번호 비교
- 사용자가 구매한 로또 번호와 당첨 번호를 비교
  - 당첨 번호는 사용자로부터 입력 받는다.
    - 쉽표(,)를 기준으로 번호 구분
  - 보너스 번호를 입력 받는다.
- 사용자의 input 문제 발생 시 IllegalArgumentException 발생
  - "[ERROR]" 메세지 출력해야 한다.
  - 당첨 번호 입력 시 잘못된 입력에 대해서는 다음과 같이 출력
  ```
  [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
  ```
  - 마찬가지로 입력받는 부분에 대해서 메세지 처리

### 수익률 계산
- 비교한 결과 당첨 내역 및 수익률을 출력
- 수익률을 출력한 후 로또 게임 종료

### 입출력 요구사항
#### 입력
- 사용자로부터 금액을 입력받는다
  - 1000단위로 나누어지지 않으면 IllegalArgumentException
- 당첨 번호는 사용자로부터 입력 받는다.
  - 쉼표(,)를 기준으로 번호를 구분한다.
- 보너스 번호를 입력 받는다.

#### 출력

- 발행한 로또 수량 및 번호를 출력한다
  - 로또 번호는 오름차순으로 정렬
- 당첨 내역을 출력한다




## 기능 구현 세부사항 List Up
### Enum Class
- Lotto Rank
  - 1등(FIRST_PLACE) : 6개 번호 일치
  - 2등(SECOND_PLACE) : 5개 번호 일치 + 보너스 번호
  - 3등(THIRD_PLACE) : 5개 번호 일치
  - 4등(FOURTH_PLACE) : 4개 번호 일치
  - 5등(FIFTH_PLACE) : 3개 번호 일치
  - 미당첨(NOT_IN_LIST) : 3개 미만 당첨되는 경우
  - ENUM_VALUE(correspondingNumber, correspondingBonusNumber, winnings, message)
  - getWinnings() : 당첨금 반환
  - getMessage() : 당첨 관련 메세지 반환
  - getPlace() : 주어진 당첨 번호 일치 갯수와 보너스 번호 일치 에 해당하는 순위 반환
- ErrorResponse
  - INPUT_LOTTO_RANGE_ERROR
    - "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
  - INPUT_BONUS_NUMBER_RANGE_ERROR
    - "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."
  - INPUT_WRONG_SIZE_ERROR
    - "[ERROR] 로또 당첨 번호느 6개의 수여야 합니다."
  - INPUT_BUYING_RANGE_ERROR
    - "[ERROR] 1000으로 나누어지는 단위의 구입 금액을 입력해야 합니다."
  - INPUT_WITHOUT_COMMA_ERROR
    - "[ERROR] 당첨번호는 쉽표(,)로 구분하여 입력해야 합니다."
  - INPUT_CONTAINS_CHAR_ERROR
    - "[ERROR] 입력은 문자를 포함할 수 없습니다."
  - NOT_IN_WINNING_PLACE
    - "[ERROR] 일치하는 등수에 존재하지 않습니다."

### ValidationUtil Class
- 검증과 관련된 메소드들을 제공하는 클래스
- 사용자 입력 구매금액 숫자만으로 구성되어있는지 검증 : checkUserInputCondition(String input)
  - Character.isDigit() 활용해서 숫자로만 구성되어있는지 검증
- 사용자 입력 당첨번호 개수 검증: validateWinnerNumberSize(String userInput)
  - 쉽표(,)로 구분 된 로또 번호가 6개인지 확인
  - 6개가 아닐 시 throw new IllegalArgumentException
  - ErrorResponse : INPUT_WRONG_SIZE_ERROR
- 사용자 입력 당첨번호 쉽표 구성 검증: validateWinnerNumberContainsComma()
  - 사용자 입력이 쉽표로 구분되어 입력되는지 검증
  - 아닐 시에 throw new IllegalArgumentException
  - ErrorResponse : INPUT_WITHOUT_COMMA_ERROR

- 사용자 입력 당첨번호 범위 검증 : validateWinnerNumberRange(List[Integer] winnerNumber)
  - winnerNumber의 수가 1~45 사이의 수인지 확인.
  - 범위 벗어날 시 throw IllegalArgumentException
- 사용자 입력 보너스번호 검증 : validateBonusNumber(int bonusNumber)
  - bonusNumber가 1~45 사이의 수인지 확인.
  - 범위 벗어날 시 throw IllegalArgumentException
  - 
### Application Class
- 사용자 입력 구매금액 검증하고 변환: convertBuyingPriceIntoTicketAmount(int buyingPrice)
  - 1000으로 나누어지는 단위인지 확인하고 변환
  - 1000으로 나누어지지 않는 단위이면
  ```java
  throw new IllegalArgumentException();
  ```
- 사용자 당첨번호 입력 : inputWinnerNumber()
- 검증된 구매가격에 맞게 랜덤의 로또 번호 발행
  - ArrayList[ArrayList[Integer]] 형태로 저장
- 사용자 당첨번호 입력 모듈 : inputWinnerNumber()
  - 앞서 정의된 검증 함수 및 입출력 형식 코드 구성
- 사용자 보너스 번호 입력 모듈 : inputBonusNumebr()
  - validateBonusNumberRange() : 보너스번호 범휘 검증
  - 앞서 정의된 검증 함수 및 입출력 형식 코드 구성
- 구매한 로또 번호에 대한 등수 구하기 : getLottoRankByTicket()
  - iter 통한 ticket 순회
  - 각 ticket당 기록 추가: addToHistory()
  - **Streams 리팩토링**
  - 기록 관리하는 winningHistory map에 기록 추가

- 수익률 계산 : printRankOutOfBuyingPrice(int buyingPrice)
  - int buyingPrice : 사용자의 구매
  - 수익률(earningRate) : lottoRank / buyingPrice
  - String.format("%.1f", double) : 소수 둘째 자리에서 반올림

### Lotto Class
- 랜덤 로또 번호 생성 : createRandomUniqueNumbers()
  - Randoms.pickUniqueNumbersInRange() 사용
  - 오름차순 정렬까지 포함 - Collections.sort()
  ```java
    public List<Integer> createRandomLottoNumber(){
        List<Integer> createdRandomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(createdRandomNumbers);
  
        return createdRandomNumbers;
    }
  ```
- 번호 일치 확인 : countCorrespondingNumbers(List[Integer] winnerNumber, List[Integer] checkTargetNumber)
  - winnerNumber와 checkTargetNumber 비교해서 일치하는 수 개수 count
  - LottoRank(Enum class) : 몇 등인지 반환

### LottoException
- IllegalArgumentException을 상속 받는 LottoException 클래스
  - ErrorResponse를 인자로 받는 생성자 오버로딩
  - 위 방식을 통해 단일화된 try-catch 예외 처리 가능
  ```java
  public LottoException(ErrorResponse errorMessage){
    super(errorMessage.getErrorMessage());
  }
  ```

## 과제 진행 요구 사항
- 기능별 commit을 진행할 것
- Test Case를 생성해서 기능별 검증을 진행할 것
- 함수의 길이가 15를 넘어가지 않을 것
- else 사용하지 않을 것
- Java Enum 적용할 것
- 도메인 로직에 단위 테스트를 구현해야 한다.