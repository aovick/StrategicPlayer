import static junit.framework.TestCase.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.rules.ExpectedException;

import java.lang.CharSequence;
import java.util.stream.Stream;

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
		StrategicPlayerImplementer player = new StrategicPlayerImplementer();

		player.beginGame(4, 4, 4);
		player.getNewCoinStates("HHHH");

		player.beginGame(4,6,4);
		player.getNewCoinStates("HHHH--");

		player.beginGame(1,1,4);
		player.getNewCoinStates("T");
	}
	
	@Test
	public void testInvalidGetNewCoinStatesInput() {
        StrategicPlayerImplementer player = new StrategicPlayerImplementer();

        player.beginGame(4, 2, 4);
        assertThrows(IllegalArgumentException.class, () ->{
            player.getNewCoinStates("----");
        });
        assertThrows(IllegalArgumentException.class, () ->{
            player.getNewCoinStates("HH");
        });
        assertThrows(IllegalArgumentException.class, () ->{
            player.getNewCoinStates("HHHH");
        });
	}
	

	@ParameterizedTest
	@CsvSource({"------",
				"HHTTHHT",
				"H--H-T--",
				"--HTT--"})
	public void testGetNewCoinStatesOutput(CharSequence cs) {
		StrategicPlayerImplementer player = new StrategicPlayerImplementer();
		CharSequence ret = player.getNewCoinStates(cs);
		assertEquals(cs.length(), ret.length());
		for(int i = 0; i < cs.length(); i++) {
			if(cs.charAt(i) == '-') {
				assertEquals(ret.charAt(i), '-');
			}
			else
				assertTrue(ret.charAt(i) == 'H' || ret.charAt(i) == 'T');
		}		
	}

}
