import static junit.framework.TestCase.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.rules.ExpectedException;

import java.lang.CharSequence;
import java.util.stream.Stream;

class StrategicPlayerImplementerTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    void testValidBeginGameInput(){
    	StrategicPlayerImplementer player = new StrategicPlayerImplementer();
		player.beginGame(4, 2, 3);
		player.beginGame(1, 0, 0);
		player.beginGame(4, 6, 8);
		
    }
	
	@Test
	void testInvalidBeginGameInput() {
		
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
	void testGetSlotsToRevealOutput() {
		fail("Not yet implemented");
	}
	

	@Test
	void testValidGetNewCoinStatesInput() {
		StrategicPlayerImplementer player = new StrategicPlayerImplementer();

		player.beginGame(4, 4, 4);
		player.getNewCoinStates("HHHH");

		player.beginGame(4,6,4);
		player.getNewCoinStates("HHHH--");

		player.beginGame(1,1,4);
		player.getNewCoinStates("T");
	}
	
	@Test
	void testInvalidGetNewCoinStatesInput() {
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
	void testGetNewCoinStatesOutput(CharSequence cs) {
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
