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
**Enum Class**
- Winning
  - 1등(FIRST_PLACE) : 6개 번호 일치
  - 2등(SECOND_PLACE) : 5개 번호 일치 + 보너스 번호
  - 3등(THIRD_PLACE) : 5개 번호 일치
  - 4등(FOURTH_PLACE) : 4개 번호 일치
  - 5등(FIFTH_PLACE) : 3개 번호 일치
  - 각 value : 당첨금 반환
- ErrorResponse
  - 사용자가 벗어난 범위의 당첨 번호, 보너스 번호 입력시 : "[Error] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
  - 사용자가 벗어난 경우의 구매 금액 입력시 : "[Error] 1000으로 나누어지는 단위의 구입 금액을 입력해야 합니다."
  - 사용자가 쉽표(,)를 사용하지 않고 당첨 번호 입력시 : "[Error] 당첨번호는 쉼표(,)로 구분하여 입력해야 합니다"
  - 각 경우에 대한 에러 메세지 반환
- BaseResponse(고민중)
  - 사용자가 구입금액을 입력하고 검증이 된 경우 : "N개를 구매했습니다."
  - 보너스 번호까지 입력이 완료된 경우 : "당첨 통게 --- ..."

**Application Class**
- 사용자 입력 구매금액 검증 : validateBuyingPrice(int buyingPrice)
  - 1000으로 나누어지는 단위인지 확인
  - 1000으로 나누어지지 않는 단위이면
  ```java
  throw new IllegalArgumentException();
  ```

- 사용자 입력 당첨번호 검증 : validateWinnerNumber(List[Integer] winnerNumber)
  - winnerNumber의 수가 1~45 사이의 수인지 확인.
  - 보너스 번호 검증 또한 동일한 함수 사용

- 수익률 계산 : calculateEarningRate(int buyingPrice, Winning winningPlace)
  - int buyingPrice : 사용자의 구매
  - Winning winningPlace : 당첨 금액
  - 수익률(earningRate) : winningPlace / buyingPrice
  - String.format("%.1f", double) : 소수 둘째 자리에서 반올림

**Lotto Class**
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
  - Winning(Enum class) : 몇 등인지 반환

## 과제 진행 요구 사항
- 기능별 commit을 진행할 것
- Test Case를 생성해서 기능별 검증을 진행할 것
- 함수의 길이가 15를 넘어가지 않을 것
- else 사용하지 않을 것
- Java Enum 적용할 것
- 도메인 로직에 단위 테스트를 구현해야 한다.