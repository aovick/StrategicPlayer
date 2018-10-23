
public class FourTwoPlayer implements StrategicPlayer {
	private int spin;
	private boolean firstCoinsMatched;
	char goalOrientation;

	@Override
	public void beginGame(int coinsPerWheel, int revealsPerSpin, int maxNumSpins) {
		if( coinsPerWheel != 4 || revealsPerSpin != 2 || maxNumSpins < 0) {
			throw new IllegalArgumentException("Game Parameters Require 4 coins, 2 Revealed and Positive Spin Value");
		}
		else {
			this.spin = 0;
			firstCoinsMatched = true;
			goalOrientation = 'H';
		}

	}

	@Override
	public CharSequence getSlotsToReveal() {
		CharSequence retVal = "??--";
		return retVal;
	}

	@Override
	public CharSequence getNewCoinStates(CharSequence revealedPattern) {
		// TODO Check for valid input
		CharSequence flippedPattern = "";
		if(spin < 2) {
			flippedPattern = initialSpins(revealedPattern);
		}
		else {
			flippedPattern = regularSpin(revealedPattern);
		}

		return flippedPattern;
	}
	
	private CharSequence regularSpin(CharSequence revealedPattern) {
		String returnString = goalOrientation + goalOrientation + "--";
		spin++;
		CharSequence finishedString = returnString;
		return finishedString;
	}
	
	private CharSequence initialSpins(CharSequence revealedPattern) {
		char firstCoin = revealedPattern.charAt(0);
		char secondCoin = revealedPattern.charAt(1);
		
		if(firstCoin == secondCoin && firstCoinsMatched) {
			firstCoinsMatched = true;
			if(firstCoin == 'H') {
				firstCoin = 'T';
				secondCoin = 'T';
				goalOrientation = 'T';
			}
			else {
				firstCoin = 'H';
				secondCoin = 'H';
                goalOrientation = 'H';
			}
		}
		else {
			firstCoinsMatched = false;
			firstCoin = goalOrientation;
			secondCoin = goalOrientation;
		}
		String firstReturnString = firstCoin + secondCoin + "--";
		CharSequence returnSequence = firstReturnString;
		spin++;
		return returnSequence;
		
	}
	
	

}
