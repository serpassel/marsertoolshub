package es.marser.marsertoolslib;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import es.marser.marsertoolslib.jbasicutilstest.BooleanToolsTest;
import es.marser.marsertoolslib.jbasicutilstest.DateToolsTest;
import es.marser.marsertoolslib.jbasicutilstest.MathToolsTest;
import es.marser.marsertoolslib.jbasicutilstest.TextToolsTest;
import es.marser.marsertoolslib.sqliteutils.SQLStringsTest;

/**
 * @author sergio
 *         Created by sergio on 23/09/17.
 *         Suite de tests estáticos
 *         [EN] Static test suite
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        TextToolsTest.class,
        DateToolsTest.class,
        BooleanToolsTest.class,
        MathToolsTest.class,
        SQLStringsTest.class
})
public class StaticSuiteTest {

}
