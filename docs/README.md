# 🔍 기능 목록

## ✏️ Lotto Class


- void validateNumbersSize(List<Integer>)
  -  입력된 로또 번호들이 총 6개인지 검사하는 함수


- void validateNumbersAreInRange(List<Integer>)
  - 입력된 로또 번호들이 각각 1~45 사이의 수인지 검사하는 함수


- void validateNumbersAreDuplicate(List<Integer>)
  - 입력된 로또 번호들 중 중복되는 숫자가 있는지 검사하는 함수


- void checkNumbersAreDuplicate(int, int)
  - 입력된 로또 번호가 중복되는지 실제로 검사하는 함수


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


- void printStats(List<Lotto>, int[], int)
  - 당첨 내역을 출력하는 함수


- void printErrorAboutRange()
  - 예외 상황 발생을 의미하는 에러 문구를 출력하는 함수
  - 입력받은 숫자가 1~45가 아닌 경우 출력되는 문구


- void printErrorAboutInteger()
  - 예외 상황 발생을 의미하는 에러 문구를 출력하는 함수
  - 입력받은 값이 숫자가 아닌 경우 출력되는 문구


- void printErrorAboutDuplicate()
  - 예외 상황 발생을 의미하는 에러 문구를 출력하는 함수
  - 입력받은 숫자가 중복되는 경우 출력되는 문구


- void printErrorAboutDivisionByThousand()
  - 예외 상황 발생을 의미하는 에러 문구를 출력하는 함수
  - 입력된 구입 금액이 1,000으로 나누어떨어지지 않을 경우 출력되는 문구


- void printErrorAboutForm()
  - 예외 상황 발생을 의미하는 에러 문구를 출력하는 함수
  - 입력 형식을 지키지 않았을 경우 출력되는 문구


- void printErrorAboutSize()
  - 예외 상황 발생을 의미하는 에러 문구를 출력하는 함수
  - 숫자의 개수가 게임에서 요구하는 개수와 다를 경우 출력되는 문구

### 🚀 입력

- void inputUserCash(int)
  - 사용자로부터 구입금액을 입력받아 저장하는 함수


- void inputWinningNumbers(int[])
  - 사용자로부터 당첨 번호를 입력받아 저장하는 함수


- void inputBonusNumber(Integer)
  - 사용자로부터 보너스 번호를 입력받아 저장하는 함수

  
### 🚀 핵심 로직

- void playLottoGame()
  - 로또 게임을 시작하는 함수


- List<Integer> issueLottoNumbers()
  - 로또 번호를 발행하는 함수


- void validateCashIsInteger(String)
  - 구입금액으로 입력한 문자열이 숫자로 이루어져있는지 검사하는 함수


- void validateCashIsDividedThousand(String)
  - 입력받은 구입금액이 1,000원으로 나누어지는지 검사하는 함수
  

- void validateWinningNumbersSize(String)
  - 당첨 번호르 입력한 문자열의 길이가 11(숫자 6개+쉼표 5개)인지 검사하는 함수
  

- void validateWinningNumbersAreInteger(String)
  - 당첨 번호 입력 시에 숫자와 쉼표만 사용했는지 검사하는 함수
  - 숫자에 대한 검사만 이루어진다


- void validateWinningNumbersUseComma(String)
  - 당첨 번호 입력 시에 숫자 간의 구분을 위해 쉼표를 이용했는지 검사하는 함수
  

- void validateBonusNumberIsInteger(String)
  - 보너스 번호가 숫자로 이루어져있는지 검사하는 함수


- void validateBonusNumberIsInRange()
  - 보너스 번호가 1~45 사이의 숫자인지 검사하는 함수


- void validateBonusNumberIsDuplicate()
  - 보너스 번호가 당첨 번호와 중복되는지 검사하는 함수


- void calculateSurplus(int, int, int, int, int, int)
  - 수익률을 계산하는 함수


## ✏️ GRADE enum


- First(2,000,000,000), Second(30,000,000), Third(1,500,000), Forth(50,000), Fifth(5,000)