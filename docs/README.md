## 기능 목록
- 로또 (Lotto)
  - [x] 6자리 로또 번호가 유효한지 판단하는 기능 - validate()
    - [x] 6자리인가? - isSixNumbers()
    - [x] 모두 다른 숫자인가? - isAllDifferentNumbers()


- 로또 기계 (LottoMachine)
  - [x] 중복되지 않는 6개의 숫자 뽑아 로또에 저장하는 기능 - generateLottoNumbers()


- 유저 (User)
  - [x] 수익률을 계산하는 기능 - UserService.calculateYield()


- 로또 관리자 (Manager)
  - [x] 구입 금액에 맞는 로또 장수를 반환하는 기능 - ManagerService.changeLottos()
  - [x] 당첨 번호와 유저의 로또 번호를 비교하여 맞은 개수 구하는 기능 - countCorrect()
  - [x] 보너스 번호가 맞았는지 판단하는 기능 - isCorrectBonus()
  - [x] 몇 등인지 판단하는 기능 - judgeRank()
  - [x] 등수에 따라 당첨 금액을 결정하는 기능 - userService.updateRankAndWinningAmount()


- 입력 (InputUtil)
  - [x] 사용자의 입력을 받는 기능 - getUserInput()


- 예외 (ExceptionHandler)
  - [x] 입력받은 금액이 유효한 입력인지 판단하는 기능 - checkValidationMoney()
  - [x] 입력받은 당첨번호가 유효한 입력인지 판단하는 기능 - checkValidationWinningNumber()
    - [x] 6자리를 입력했는가? - isSixNumbers()
    - [x] 구분자가 콤마이면서 숫자만 입력했는가? - isOnlyCommaAndNumber()
    - [x] 중복되는 숫자가 있는가? - isAllDifferentNumbers()
    - [x] 1부터 45 사이의 숫자인가? - isValidationRange()
  - [x] 입력받은 보너스번호가 유효한 입력인지 판단하는 기능 - checkValidationBonusNumber()
  - [x] 메시지를 입력받아 해당 메시지로 IllegalArgumentException 반환하는 기능 - makeIllegalArgumentException()


- 출력 (OutputUtil)
  - [x] 유저가 발행한 로또 수량을 출력하는 기능 - printUserLottoCount()
  - [x] 유저가 발행한 로또 번호를 모두 출력하는 기능 - printUserLottos()
  - [x] 입력이 잘못되었을 때 출력하는 기능 - printInputWinningNumbersError(), printInputBonusNumberError()
  - [x] 당첨 내역을 출력하는 기능 - printResult()
  - [x] 프로그램 종료될 때 출력하는 기능 - printEndProgram()


