package fr.xebia.mowitnow;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Charles Dufour
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ DirectionTest.class, PositionTest.class, LawnmowerTest.class, LawnTest.class,
        LawnCreatorTest.class })
public class AppTestSuite {
}
