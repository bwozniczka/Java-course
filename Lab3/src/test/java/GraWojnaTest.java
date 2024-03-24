import org.junit.Test;

import static org.junit.Assert.*;

public class GraWojnaTest {

    @Test
    public void Rozdanie() throws NoCardException {
        GraWojna wojna = new GraWojna();
        assertEquals(wojna.gracze.get(0).reka.size(), 26);
        assertEquals(wojna.gracze.get(1).reka.size(), 26);
        assertNotEquals(wojna.gracze.get(0).reka, wojna.gracze.get(1).reka);
    }

}