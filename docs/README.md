# Joo Seong Jin (NotableDeveloper)
# Woowacourse - Precourse Week 3 (Web Backend)

## [목표 기능 사항]

### 1. 구매 금액 및 당첨 번호 입력
### 목표
1) 사용자로부터 1,000원으로 나누어 떨어지는 로또 금액을 입력 받는다.
2) 사용자로부터 당첨 번호로 사용하기 위한 중복되지 않는 여섯 개의 로또 번호 및 보너스 번호 하나를 입력 받는다.<br> 
이 때, 각 번호는 반드시 쉼표로 구분 짓는다.

### 발생할 수 있는 예외 사항
- 다음과 같은 예외 사항이 발생하는 경우, IllegalArgumentException을 발생시키고 프로그램이 종료된다.<br>
  또, 모든 예외 사항에는 각각의 메시지가 존재한다.

1) 사용자가 입력한 값에서 가장 앞의 값이 0인 경우에는 <br>
   예외 메시지로 "[Error] 구매 금액을 잘못 입력 하셨습니다." 를 갖는다.


2) 사용자가 입력한 값 중에서 숫자가 아닌 값이 있는 경우에는 <br>
   예외 메시지로 "[Error] 구매 금액을 잘못 입력 하셨습니다." 를 갖는다.


3) 1,000원으로 나누어 떨어지지 않는 로또 금액을 입력한 경우에는 <br>
   예외 메시지로 "[Error] 구매 금액이 천 원으로 나누어 떨어지지 않는 금액입니다." 를 갖는다.


4) 당첨 번호가 쉼표로 구분되어야 한다. 그렇지 않는 경우에는 <br>
   예외 메시지로 "[Error] 당첨 번호가 구별되지 않습니다." 를 갖는다.


5) 당첨 번호로 입력한 값 중에 숫자가 아닌 값이 있는 경우에는 <br>
   예외 메시지로 "[Error] 당첨 번호 중에 숫자가 아닌 값이 존재합니다." 를 갖는다.


6) 보너스 번호의 값의 범위는 1부터 45사이의 값이어야 한다. 그렇지 않은 경우에는 <br>
   예외 메시지로 "[Error] 보너스 번호 값의 범위가 1부터 45 사이의 값이 아닙니다." 를 갖는다.


7) 보너스 번호로 숫자가 아닌 값이 입력된 경우에는 <br>
   예외 메시지로 "[Error] 보너스 번호로 숫자가 아닌 값이 입력 되었습니다." 를 갖는다.


8) 보너스 번호가 이미 당첨 번호에 있는 값을 입력 받은 경우에는 <br>
   예외 메시지로 "[Error] 보너스 번호가 이미 당첨 번호에 있습니다." 를 갖는다.


### 구현 내용
< Class Input >
- Attribute
  - int money : 사용자로부터 입력 받는 로또 구매 금액 <br><br>
  - List\<Integer> numbers : 사용자로부터 입력 받는 로또 당첨 번호 목록 (유효하지 않을 수 있음.) <br><br>
- Method 
  - Input() : 매개 인자가 없는 생성자이다. 인스턴스 생성 시에 enterMethod 메서드를 호출한다. <br><br>
  - void enterMoney() : 사용자로부터 구매 금액을 표준 입력 장치를 통해 입력 받는다. <br>
     입력 받은 값은 validate(String s) 메서드를 통해 유효성 검사를 실시하고, 문제가 없으면 멤버 변수 money에
     사용자 입력 값을 정수형으로 변환하여 저장한다. <br><br>
  - boolean validate(String s) : 문자열 형태인 구매 금액을 인자로 받아서 예외 사항 1 ~ 3번을 검사한다. <br><br>
  - void enterNumbers() : 사용자로부터 당첨 번호를 표준 입력 장치를 통해 입력 받는다. 입력 받은 값은 <br>
    validate(String[] s) 메서드를 통해 유효성 검사를 실시하고(= 예외 사항 5번 검사), 문제가 없으면 멤버 변수 numbers에 사용자 입력 값을 <br>
    parseInputToInt 메서드를 사용하여 저장한다. <br><br>
  - boolean validate(String[] s) : 문자열 배열 형태인 당첨 번호를 인자로 받아서 예외 사항 5번을 검사한다. <br><br>
  - void parseInputToInt(String s) : 당첨 번호로 입력 받은 사용자 입력을 ,(쉼표)로 구분한다. <br>
    또, 그 결과를 바탕으로 예외 사항 4번을 검사한다. 문제가 없다면 구분된 값들을 정수형으로 변환하여 <br>
    멤버 변수 numbers에 저장한다. <br><br>
  - boolean validateBonusNumber(String s) : 사용자가 입력한 보너스 번호를 String형으로 받아서, 예외 사항 6 ~ 8번을 검사한다. <br><br>
  - List\<Integer> getNumbers() : 멤버 변수인 numbers를 반환한다. <br><br>
  - int money() : 멤버 변수인 money를 반환한다.
  
<br>

### 2. 당첨 번호 생성
### 목표
1) 사용자의 입력 값을 매개 인자로 받아서 여섯 자리의 당첨 번호를 생성한다.
2) 사용자의 입력 값을 매개 인자로 받아서 한 자리의 보너스 번호를 생성한다.

### 발생할 수 있는 예외 사항
- 다음과 같은 예외 사항이 발생하는 경우, IllegalArgumentException을 발생시키고 프로그램이 종료된다. <br>
또, 모든 예외 사항에는 각각의 메시지가 존재한다.

1) 객체가 생성될 때, 중복되는 당첨 번호가 입력 값으로 들어온 경우에는 <br>
예외 메시지로 "[Error] 중복되는 값이 존재합니다." 를 갖는다.


2) 당첨 번호는 기본 여섯 개의 번호와 보너스 번호를 하나 포함하여 총 일곱 개의 번호를 가져야한다. <br>
그렇지 않을 경우에는 예외 메시지로 "[Error] 당첨 번호의 갯수가 맞지 않습니다." 를 갖는다.


3) 하나의 당첨 번호는 1부터 45까지의 값을 가져야한다. 그렇지 않는 경우에는 <br>
예외 메시지로 "[Error] 입력된 당첨 번호 값의 범위가 1부터 45 사이의 값이 아닙니다." 를 갖는다.


### 구현 내용
< Class Lotto >
- Attribute 
  - List<Integer> numbers : 사용자로부터 입력 받는 유효한 당첨 번호 목록 <br><br>
  
- Method
  - Lotto(List<Integer> numbers) : 사용자로부터 입력 받은 정수형 리스트를 매개 인자로 받는 생성자이다. <br>
    매개 인자에 대해 validate 메서드를 통해 유효성 검사를 실시한다. 이후, 멤버 변수인 numbers에 값을 저장한다. <br><br>
  - void validate(List<Integer> numbers) : 사용자로부터 입력 받은 정수를 매개 인자로 받아서 <br>
    예외 사항 1 ~ 3번을 검사한다. <br><br>
  - List<Integer> getNumbers() : 멤버 변수인 numbers를 반환한다.

<br>

### 3. 추첨 번호 생성 및 통지
### 목표
1) 사용자가 구매한 로또 수량만큼 추첨 번호를 생성한다.
2) 생성한 추첨 번호들은 각각 오름차순으로 정렬되어야 한다.
3) 생성한 추첨 번호들은 로또 수량만큼 List형으로 출력한다.


### 구현 내용
< Class LotteryNumber >
- Attribute
  - ArrayList<ArrayList<Integer>> numbers : 무작위로 생성한 추첨 번호들의 목록 <br><br>

- Method
  - LotteryNumber(int money) : 구매 금액을 매개 인자로 받는 생성자이다. 매개 인자가 무조건 1,000으로 나누어 떨어지는 <br>
    값으로 생각하여 따로 유효성 검사는 하지 않고, 그 값을 1,000으로 나눈 몫을 매개인자로 generateNumbers 메서드를 호출한다. <br><br>
  - generateNumbers(int n) : 매개 인자 n번 만큼 pickUniqueNumbersInRange()의 호출을 반복한다. 생성된 난수 리스트는 <br>
    sortElementsNumbers() 메서드를 통해 정렬하여 멤버 변수 numbers에 넣는다. <br><br>
  - sortElementsNumbers(List<Integer> list) : List<Integer>형의 리스트를 입력으로 받아서 오름차순으로 정렬된 <br>
    ArrayList<Integer>형 리스트로 반환한다. <br><br>
  - void informLotteryNumbers() : 멤버 변수 numbers의 내용을 출력한다.

<br>

### 4. 당첨 결과 및 수익률 계산 및 통지
### 목표
1) 사용자가 입력한 당첨 번호와 컴퓨터가 생성한 추첨 번호를 비교하여 당첨 내역을 출력한다.
2) 당첨 내역에 따른 수익률을 계산하여 출력한다.


### 구현 내용
< Class Judgement >
- Attribute
  - List<HashMap<Integer, Boolean>> resultTable : 당첨 번호와 추첨 번호를 비교한 결과를 담는다. 
    List의 원소 하나가 한 개의 추첨 번호에 대한 추첨 결과를 Key-Value 쌍으로 저장 한다. Key 값에는 해당 회차에서 
    당첨 번호와 추첨 번호가 일치하는 갯수, Value 값으로는 보너스 번호로 맞춘 값이 있는 지 없는 지를 저장한다. <br><br>
  - int requiredMoney : 추첨 결과에 따라 총 얼마의 금액을 로또 구매자에게 주어야 하는 지를 나타낸다. 수익률을 계산하기 위해 <br>
    사용되는 값이다. <br><br>
  - int purchaseMoney : 로또 구매자가 구매한 금액을 저장한다. 수익률 계산에 사용되는 값이다. <br><br>
  - List\<Integer> lotto : 사용자가 입력한 당첨 번호를 저장한다. 당첨 번호와 추첨 번호 비교에 사용 된다. <br><br>
  - int bonusNumber : 사용자가 입력한 보너스 번호를 저장한다. 보너스 번호와 추첨 번호 비교에 사용 된다. <br><br>
- Method
  - Judgement(List<Integer> lotto, int bonusNumber, int money) : 당첨 번호, 보너스 번호, 구매 금액을 매개 인자로 받는
    생성자이다. <br><br>
  - void informLottoResult(ArrayList<ArrayList<Integer>> lotteryNumbers) : 여러 개의 추첨 번호를 매개 인자로 받아서, 그 결과를 통지한다.
    구체적인 동작 순서는 매개 인자로 받은 추첨 번호들을 각각 비교하여 결과 저장 -> 소요해야 하는 당첨 금액의 합계를 구함 -> 수익률 계산 -> 화면에 전체적인 결과 출력의
    순서가 된다. <br><br>
  - void compare(List<Integer> lotteryNumbers) : 매개 인자로 추첨 번호 하나를 받아서 멤버 변수로 갖고 있는 보너스 번호와 당첨 번호를 비교한다.
    비교한 결과를 <일치하는 번호의 갯수, 보너스 번호를 맞췄는 지의 여부> 의 형태로 멤버 변수 resultTable에 저장 한다. <br><br>
  - void sumRequiredMoney() : resultTable을 탐색하여 로또 구매자에게 얼마의 금액을 주어야 하는 지를 멤버변수 requiredMoney에 누적한다. <br><br>
  - void computeReturnRate() : 이익이 얼마인 지를 계산하고, 그 이익의 비율을 구하여 멤버 변수 returnRate에 저장한다. <br><br>
  - void printResult() : 당첨 번호와 추첨 번호가 3개부터 6개까지 각각 몇 개가 일치했는 지의 여부를 search 메서드를 통해 확인하고, 앞서 계산한 수익률과 함께 출력한다. <br><br>
  - int search(int count, boolean flag) : 매개 인자로 몇 개를 맞추었는 지와 보너스 번호를 맞추었는 지에 대한 여부를 매개 인자로 받는다. 매개 인자로 받은 count 값을 토대로 resultTable을
    순차적으로 탐색하면서 Key와 count 값이 일치하는 경우가 얼마나 있는 지를 카운팅하여 반환한다. 이 때, 매개 인자 flag가 true인 경우에는 5개의 번호를 맞추고, 보너스 번호까지 맞추는 경우를 확인하는
    것으로 생각하여 Value와 flag 값이 일치하는 경우가 얼마나 있는 지를 카운팅하여 반환한다. <br><br>

<br>

## [테스트 코드]
- ApplicationTest
  - void normalFlowToSuccessful() : 정상적인 실행 흐름에 대해 확인하는 테스트 메서드이다.

- InputTest
  - void enterPurchaseMoneyByInputFault() : 구매 금액을 잘못 입력한 경우에 대한 테스트 메서드이다.
  - void enterPurchaseMoneyByNotDivide() : 구매 금액이 천 원으로 나누어 떨어지지 않는 경우에 대한 테스트 메서드이다.
  - void enterLottoByNotIdentify() : 당첨 번호들이 쉼표로 구별되지 않는 경우에 대한 테스트 메서드이다.
  - void enterLottoByNotNumber() : 당첨 번호들 중에 숫자가 아닌 값이 입력된 경우에 대한 테스트 메서드이다.
  - void enterLottoByInvalidRange() : 입력한 당첨 번호들 중에 1부터 45 사이의 값이 아닌 값이 있는 경우에 대한 테스트 메서드이다.
  - void enterBonusNumberByInvalidInput() : 보너스 번호가 잘못된 입력인 경우에 대한 테스트 메서드이다.
  - void enterBonusNumberByInvalidRange() : 보너스 번호가 1부터 45 사이의 값이 아닌 경우에 대한 테스트 메서드이다.

- JudgementTest
  - void compareLotteryNumberAndLottoToSuccessful() : 추첨 번호와 당첨 번호가 정상적으로 일치하는 지를 확인하는 테스트 메서드이다.
  - void computeReturnRateToSuccessful() : 수익률이 정상적으로 계산되었는 지를 확인하는 테스트 메서드이다.

- LotteryNumberTest
  - void createLotteryNumberByPurchaseQuantity() : 추첨 번호를 수량에 맞게 생성하는 지를 확인하는 테스트 메서드이다.
  - void createLotteryNumberByAscendingOrder() : 추첨 번호가 오름차순으로 정렬되었는 지를 확인하는 테스트 메서드이다.

- LottoTest
  - createLottoByOverSize() : 당첨 번호의 개수가 6개가 아닌 경우에 대한 테스트 메서드이다.
  - createLottoByDuplicatedNumber() : 당첨 번호에 중복된 숫자가 있는 경우에 대한 테스트 메서드이다.
