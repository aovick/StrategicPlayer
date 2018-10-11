
public class StrategicPlayerImplementer implements StrategicPlayer{
	private int coins, reveals, spins;

	@Override
	public void beginGame(int coinsPerWheel, int revealsPerSpin, int maxNumSpins){
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CharSequence getNewCoinStates(CharSequence revealedPattern) {
		// TODO Auto-generated method stub

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
