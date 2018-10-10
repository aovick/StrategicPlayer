
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
		CharSequence slotsToReveal = "";

		for(int i = 0; i < coins; i++) {
			if(i < reveals)
				slotsToReveal += "?";
			else
				slotsToReveal += "-";
		}

		return slotsToReveal;
	}

	@Override
	public CharSequence getNewCoinStates(CharSequence revealedPattern) {
		// TODO Auto-generated method stub
		return null;
	}

}
