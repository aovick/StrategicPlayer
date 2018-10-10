import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StrategicPlayerImplementerTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Test
    public void testValidBeginGameInput(){
    	StrategicPlayerImplementer player = new StrategicPlayerImplementer();
			player.beginGame(4, 2, 3);
			player.beginGame(1, 0, 0);
			player.beginGame(4, 6, 8);
		
    }
	
	@Test
	public void testInvalidBeginGameInput() {
		//thrown.expect(IllegalArgumentException.class);
		//thrown.expectMessage("Game Parameters Not Possible");
		
		StrategicPlayerImplementer player = new StrategicPlayerImplementer();
		assertThrows(IllegalArgumentException.class, () ->{
					 player.beginGame(0, 0, 0);
		});
		assertThrows(IllegalArgumentException.class, () ->{
			 player.beginGame(-10, 5, 3);
		});
		assertThrows(IllegalArgumentException.class, () ->{
			 player.beginGame(6, -5, 3);
		});
		assertThrows(IllegalArgumentException.class, () ->{
			 player.beginGame(6, 5, -3);
		});
		
	}

	@Test
	public void testGetSlotsToRevealOutput() {
    StrategicPlayerImplementer player = new StrategicPlayerImplementer();
    int coinsPerWheel = 4, revealsPerSpin = 2, maxNumSpins = 2;
    player.beginGame(coinsPerWheel, revealsPerSpin, maxNumSpins);
    CharSequence slotsToReveal = player.getSlotsToReveal();

    //Test length equals coinsPerWheel
    assertEquals(slotsToReveal.length(), coinsPerWheel);

    //Test number of '?' equals revealsPerSpin
    int numQuestionMarks = 0;
    for(int i = 0; i < slotsToReveal.length(); i++) {
    	if(slotsToReveal.charAt(i) == '?')
    		numQuestionMarks++;
    }
    assertEquals(numQuestionMarks, revealsPerSpin);

    //TODO test '?'s are in proper place (after we establish strategy)
	}
	
	@Test
	public void testValidGetNewCoinStatesInput() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testInvalidGetNewCoinStatesInput() {
		fail("Not implmented");
	}
	
	@Test
	public void testGetNewCoinStatesOutput() {
		fail("Not implemented");
	}

}
