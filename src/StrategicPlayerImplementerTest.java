import static junit.framework.TestCase.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

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
	
	@Test
	void testGetNewCoinStatesOutput() {
		fail("Not implemented");
	}

}
