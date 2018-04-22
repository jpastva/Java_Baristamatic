import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {

    @Test
    public void testGetInstance() {
        Menu instance = null;
        instance = Menu.getInstance();
        assertNotNull(instance);
    }

    @Test
    public void displayMenuTest() {
        assertNotNull("Error, menu should be returned.", Menu.getInstance().displayMenu());
    }
}