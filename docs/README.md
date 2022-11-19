### 기능 목록

---
* 핵심 로직 기능
   * 랜덤하게 당첨 번호를 6개를 뽑아 로또를 생성하는 기능 (LottoMachine.generateLotto)
   * 구입한 로또의 개수를 계산하는 기능 (LottoController.computeAmountOfLotto)
   * 구입한 로또 개수만큼 로또 객체 생성하는 기능 (LottoController.generateLotto)
   * 각 로또의 번호와 예측 번호, 보너스 번호를 비교해 맞춘 개수 계산하는 기능 (LottoController.computeMatchCounts)
   * 당첨 내역 기록하는 기능 (LottoController.recordWinningLog)
   * 수익률 계산하는 기능  (LottoController.computeRateOfReturn)
   
* 입출력 기능
   * 사용자가 구입 금액을 입력하는 기능 (InputView.userInputPurchasePrice)
   * 사용자가 예측 번호를 입력하는 기능 (InputView.userInputPredictionNumbers)
   * 사용자가 보너스 번호를 입력하는 기능 (InputView.userInputBonusNumber)
   * 문자열 쉼표 기준으로 분리해 정수 리스트로 변환하는 기능 (InputView.splitStringByCommaAndParseInt)
   * 당첨 내역 출력하는 기능 (OutputView.printWinningLog)
   * 수익률 출력하는 기능 (OutputView.printRateOfReturn)

### 검증 & 예외 처리 목록

---
* 핵심 로직 검증
   * 로또 생성
      * 번호 개수 6개인지 검증 (LottoValidation.validateQuantityOfDigits)
         * ex) numbers = [1,2,3,4,5,6,7] -> 예외처리
         
      * 중복 번호 없는지 검증 (LottoValidation.validateNoDuplicateNumbers)
         * ex) numbers = [1,2,3,4,5,5] -> 예외처리         
         
      * 번호 범위 검증(1 ~ 45) (LottoValidation.validateNumbersRange)
         * ex) numbers = [1,2,3,4,5,50] -> 예외처리

* 입출력 검증
   * 사용자 구입 금액 입력
       * 숫자로만 입력되었는지 검증 (PurchasePriceInputValidation.validateConsistedOnlyOfNumbers)
         * ex) input = 800a -> 예외처리

       * 1000으로 나누어 떨어지는지 검증 (PurchasePriceInputValidation.validateDividedByThousand)
         * ex) input = 8500 -> 예외처리

   * 사용자 예측 번호 입력
       * 형식 검증 (PredictionNumbersInputValidation.validateInputFormat)
         * ex) input = 123456 -> 예외처리
         
       * 중복 없는지 검증 (PredictionNumbersInputValidation.validateNoDuplicateNumbers)
         * ex) input = 1,2,3,4,5,5 -> 예외처리
         
       * 범위 검증(1 ~ 45) (PredictionNumbersInputValidation.validateNumbersRange)
         * ex) input = 1,2,3,4,5,50 -> 예외처리

   * 사용자 보너스 번호 입력
       * 숫자인지 검증 (BonusNumberInputValidation.validateInputIsInteger)
         * ex) input = b -> 예외처리
         
       * 예측 번호와 중복 없는지 검증 (BonusNumberInputValidation.validateNoDuplicationWithPredictionNumbers)
         * ex) 예측 번호와 보너스 번호 겹칠 시 -> 예외처리
         
       * 범위 검증(1 ~ 45) (BonusNumberInputValidation.validateNumberRange)
         * ex) input = 50 -> 예외처리
    
