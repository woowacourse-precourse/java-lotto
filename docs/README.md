## 구현할 기능
- JAVA enum을 이용한 등수 처리
- 중복되지 않는 1~45 당첨번호 생성
- 구입금액 입력
- ','로 구분되는 6개의 input
- 보너스 번호 입력
- 로또 번호 출력
- 당첨 내역 출력

## 클래스 정리
- LottoServiceMachine
    - 로또 당첨 번호 입력 및 보너스 번호 입력
    - 사용자의 입력 번호와 로또 번호 비교 및 등수 출력
    - 당첨금 출력
- LottoBuyer
  - 보유 금액 입력
  - 랜덤 로또 번호 생성
- Lotto
  - 로또 티켓과 같은 역할
  - LottoBuyer가 lotto객체를 여러개 가질 수 있음
- InputUtility
  - 사용자 input을 통해 받는 string울 처리하는 유틸리티

##클래스별 메서드 구현 상황
- LottoServiceMachine
  - public void getWinningLottoNumber()
  - public List<Integer> getWinningNumberByCount(int requireCount)
  - public List<Integer> splitLottoInput(String lottoNumbers, int requireCount)
  - private void isValidLottoRange(List<Integer> splitNumber)
- LottoBuyer
  - public void getMoney()
  - public void buyLotto()
  - private List<Integer> makeRandomLottoNumber()
  - private void canDivMoneyByPrice(Integer money)
- InputUtility
  - static List<Integer> convertToIntegerList(String[] splitInput)
  - static Integer convertToInteger(String number)
  - static void isValidLength(String[] splitInput, int testLength)
  - static void isDigit(String input)
  - static void isAllDigit(String[] splitInput)
  - static void testNoDuplicate(List<Integer> splitNumber)