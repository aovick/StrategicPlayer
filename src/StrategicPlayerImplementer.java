
public class StrategicPlayerImplementer implements StrategicPlayer{
	private int coins, reveals, spins;

	@Override
	public void beginGame(int coinsPerWheel, int revealsPerSpin, int maxNumSpins){
		
		if( coinsPerWheel < 1 || revealsPerSpin < 0 || maxNumSpins < 0) {
			throw new IllegalArgumentException("Game Parameters Not Possible");
		}
		else {
			this.coins = coinsPerWheel;
			this.reveals = revealsPerSpin;
			this.spins = maxNumSpins;
		}
	}

	@Override
	public CharSequence getSlotsToReveal() {
		
		String slotsToReveal = "";

		for(int i = 0; i < coins; i++) {
			if(i < reveals)
				slotsToReveal += "?";
			else
				slotsToReveal += "-";
		}
		CharSequence retVal = slotsToReveal;
		return retVal;
	}

	@Override
	public CharSequence getNewCoinStates(CharSequence revealedPattern) {
		// TODO Check for valid input

		StringBuilder flippedPattern = new StringBuilder();
		for( int i = 0 ; i < revealedPattern.length() ; i++) {
			if(revealedPattern.charAt(i) == '-') {
				flippedPattern.append('-');
			}
			else {
				flippedPattern.append('H');
			}
				
		}
		return flippedPattern;
		
	}

}
