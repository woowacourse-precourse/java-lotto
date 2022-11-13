# 🔍 기능 목록

## ✏️ Lotto Class


- void validateNumbersSize()
  -  입력된 로또 번호들이 총 6개인지 검사하는 함수


- void validateNumbersAreInRange()
  - 입력된 로또 번호들이 각각 1~45 사이의 수인지 검사하는 함수


- void validateNumbersAreDuplicate()
  - 입력된 로또 번호들 중 중복되는 숫자가 있는지 검사하는 함수


- boolean checkWinningNumberIsInLottoNumbers(int)
  - 당첨 번호가 로또 번호 안에 존재하는지 확인하는 함수


- List<Integer> getNumbers()
  - 로또 번호들을 반환해주는 함수


## ✏️ Application Class

### 🚀 UI

- void printCashInputBox()
  - "구입금액을 입력해 주세요."를 출력하는 함수
  - 구입금액 입력 전 구입금액 입력이 이루어져야함을 알리는 함수
  

- void printLottoQuantity(int)
  - 발행한 로또 수량을 출력하는 함수


- void printLottoNumbers(List<Integer>)
  - 발행한 로또 번호들을 출력하는 함수


- void printWinningNumbersInputBox()
  - "당첨 번호를 입력해 주세요."를 출력하는 함수
  - 당첨 번호 입력 전 당첨 번호 입력이 이루어져야함을 알리는 함수


- void printBonusNumberInputBox()
  - "보너스 번호를 입력해 주세요."를 출력하는 함수
  - 보너스 번호 입력 전 보너스 번호 입력이 이루어져야함을 알리는 함수


- void printStatsPhrase()
  - 당첨 통계를 출력함을 알리는 함수


- void printGradeStats(List<Lotto>, List<Integer>, int, int)
  - 당첨 내역을 출력하는 함수


### 🚀 입력

- String inputUserCash()
  - 사용자로부터 구입금액을 입력받는 함수
  

- String inputWinningNumbers()
  - 사용자로부터 당첨 번호를 입력받는 함수


- String inputBonusNumber()
  - 사용자로부터 보너스 번호를 입력받는 함수

  
### 🚀 핵심 로직

- void playLottoGame()
  - 로또 게임을 시작하는 함수


- void issueLottoTickets(int, List<Lotto>)
  - 로또 번호를 발행하고 이에 대한 정보를 출력이 진행되는 함수


- List<Integer> issueLottoNumbers()
  - 로또 번호를 발행하는 함수


- void validateCashIsInteger(String)
  - 구입금액으로 입력한 문자열이 숫자로 이루어져있는지 검사하는 함수


- void validateCashIsDividedThousand(String)
  - 입력받은 구입금액이 1,000원으로 나누어지는지 검사하는 함수


- Integer changeCashStringToInteger(String)
  - 구입금액으로 입력받은 문자열을 숫자로 바꾸어주는 함수


- Integer getUserCash(String)
  - 입력받은 구입금액에 대한 검사 함수가 수행되고 구입금액을 Integer 자료형으로 반환해주는 함수


- List<Integer> getWinningNumbers(String)
  - 입력받은 당첨 번호 문자열에 대한 검사 함수가 수행되고 당첨 번호를 담은 리스트를 반환해주는 함수


- List<Integer> changeWinningNumbersStringToList(String)
  - 당첨 번호로 입력된 문자열을 Integer 값을 담은 리스트로 변환해주는 함수


- Integer getBonusNumber(String, List<Integer>)
  - 입력받은 보너스 번호 문자열에 대한 검사 함수가 수행되고 이를 Integer 자료형으로 반환해주는 함수


- Integer changeBonusNumberStringToInteger(String)
  - 보너스 번호로 입력된 문자열을 Integer 값으로 변환해주는 함수
  

- void validateWinningNumbersForm(String)
  - 입력받은 당첨 번호 문자열이 형식에 맞게 담겨있수지 검사하는 함수


- void validateNumbersBetweenComma(char, char)
  - 당첨 번호가 쉼표로 구분되어 입력되었는지 검사하는 함수
  

- void validateBonusNumberIsInteger(String)
  - 보너스 번호가 숫자로 이루어져있는지 검사하는 함수


- void validateBonusNumberIsInRange(String)
  - 보너스 번호가 1~45 사이의 숫자인지 검사하는 함수


- void validateBonusNumberIsDuplicate(String, List<Integer>)
  - 보너스 번호가 당첨 번호와 중복되는지 검사하는 함수


- Integer calculateFirst(List<Lotto>, List<Integer>)
  - 1등 로또의 개수를 계산하는 함수


- Integer calculateSecond(List<Lotto>, List<Integer>, int)
  - 2등 로또의 개수를 계산하는 함수


- Integer calculateThird(List<Lotto>, List<Integer>, int)
  - 3등 로또의 개수를 계산하는 함수


- Integer calculateForth(List<Lotto>, List<Integer>)
  - 4등 로또의 개수를 계산하는 함수


- Integer calculateFifth(List<Lotto>, List<Integer>가, int)
  - 5등 로또의 개수를 계산하는 함수


- Integer compareLottoNumbersAndWinningNumbers(Lotto, List<Integer>, int)
  - 로또 번호와 당첨 번호의 같은 숫자 개수를 계산하는 함수


- Double calculateSurplus(int, int, int, int, int, int)
  - 수익률을 계산하는 함수


- void showLotto(int, List<Lotto>)
  - 발행된 로또와 관련된 정보에 대한 출력이 진행되는 함수


- void showStats(List<Lotto>, List<Integer>, int, int)
  - 로또 통계와 관련된 정보에 대한 출력이 진행되는 함수


- void setError(ErrorMessage)
  - 에러 메세지를 설정하는 함수

## ✏️ GRADE enum


- FIRST(2,000,000,000), SECOND(30,000,000), THIRD(1,500,000), FORTH(50,000), FIFTH(5,000)


## ✏️ ErrorMessage enum

- FORM("[ERROR] 올바른 형식으로 입력해야 합니다."), SIZE("[ERROR] 알맞은 개수의 숫자를 입력해야 합니다."), RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
 , DIVIDE("[ERROR] 입력된 값이 1,000으로 나누어 떨어지지 않습니다."), DUPLICATE("[ERROR] 중복된 번호가 존재합니다."), INTEGER("[ERROR] 입력된 값이 숫자가 아닙니다.")