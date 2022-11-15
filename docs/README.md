 ## 기능 구현 목록
 > ### InputView
> >* 구매 액수를 입력 받는다.
> >* 당첨 숫자 6개를 입력 받는다.
> >* 보너스 번호를 입력 받는다.

> ### LottoNumber
> >* 1~45까자의 범위를 가진 int를 로또 숫자로 정의한다.
> >* 1~45의 범주를 가진 int를 키로, 동일 범주의 lottoNumber를 value로 가지는 map를 클래스 상수로 가진다.
> >* int를 넣으면 lottoNumber를 반환하는 정적 팩토리 메서드를 가진다.

> ### Lotto
> >* 6개의 중복되지 않는 lottoNumber를 가진 list를 로또로 정의한다.
> >* 중복된 숫자를 받으면 IllegalArgumentException을 확장한 LottoInputException을 던지고 예외 문구를 출력한다.
> >* 6개이 이상의 숫자를 받으면 IllegalArgumentException을 확장한 LottoInputException을 던지고 예외 문구를 출력한다.
> >* 다른 로또와 일치하는 개수를 비교한다.
> >* 보너스 번호의 포함 여부를 확인한다.

> ### Lottery
> >* 로또를 산 개수와 CreateStrategy를 매개변수로 받아 로또를 산 개수 만큼 로또를 생성해 List<Lotto>에 넣는다.
> >* 생성한 로또 들과 당첨 숫자, 보너스 번호를 비교한 후, 일치하는 Rank를 찾는다.
> >* 일치하는 숫자와 상금을 상수로 가진 Enum Rank를 키로 당첨 개수를 값으로 가진 Map을 인스턴스 변수로 가진다.
> >* Map에 값을 채운 후 반환한다.

> ### LottoResult
> >* 생성한 list<Lotto>결과를 생성자로 받는다.
> >* list의 size를 반환해 산 로또 개수를 반환한다.
> >* 복사를 허용하지 않게 결과 list<Lotto>를 반환한다.

> ### LottoGame
> >* lottery를 인스턴스 변수로 갖는다.
> >* lotto의 티켓값을 상수로 갖는다.
> >* 금액 Money를 티켓값으로 나눈 후 매개변수 CreateStrategy를 lottery에 전달해 로또들을 생성한다.
> >* LottoResult를 생성하고 lottey의 값을 넣어 반환한다.
> >* WinningLotto를 매개변수로 lottery에 당첨결과 Map을 만들고 RankResult에 생성자 주입으로 RankResult를 반환한다.

> ### WinningLotto
> >* 당첨숫자 6개와 보너스 번호 1개를 생성자 주입으로 받는다.
> >* 일치하는 개수를 비교하여 반환한다.
> >* 매개변수 lotto의 보너스 일치 여부를 반환한다.

> ### RankResult
> >* LottoGame에서 생성한 Rank의 개수를 가진 Map을 생성자 주입으로 받는다.
> >* Rank의 당첨금과 Map 안의 Rank의 당첨 개수를 토대로 수익율을 계산한다.
> >* 계산 결과를 반환한다.

> ### Money
> >* 구입금액이 1000단위로 떨어지지 않을 경우 LottoException을 발생시키고 예외문구를 출력한다.
> >* 구입금액을 반환한다.

> ### ResultView
> >* LottoResult를 받고 결과를 출력한다.
> >* RankResult를 받고 각 Rank의 양식에 맞게 출력한다.

> ### RandomCreateStrategy
> >* 1부터 45까지의 중복되지 않는 랜덤한 6자리의 lottoNumber을 list로 반환한다.

> ### GameFrame
> >* LottoGame, CreateStrategy를 매개변수로 갖는다.
> >* InputView의 구입금액이 형식에 맞지 않다면 예외 문구를 출력하고 종료한다.
> >* 형식에 맞은 입력이라면 Money를 생성하고 LottoGame을 시작한다.
> >* InputView의 당첨숫자, 보너스 번호가 형식에 맞지 않다면 예외 문구를 출력하고 종료한다.
> >* 형식에 맞다면 WinningLotto를 생성하고 Rank결과를 출력한다.