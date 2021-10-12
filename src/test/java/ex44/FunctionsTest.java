package ex44;

import junit.framework.TestCase;

public class FunctionsTest extends TestCase {

    public void testCheckFlag() {
        assertTrue(Functions.checkFlag(1));
        assertFalse(Functions.checkFlag(0));
    }
}