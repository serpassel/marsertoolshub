package es.marser.marsertoolsproject;

import es.marser.marsertoolslib.jbasicutils.TextTools;
import es.marser.marsertoolslib.sqliteutils.SQLStrings;
import es.marser.marsertoolslib.sqliteutils.examples.PojoExample;

/**
 * @author sergio
 *         Created by sergio on 2/10/17.
 *         Pruebas de compilación de librerías
 */

@SuppressWarnings({"ALL", "unused"})
public class Compilacion {

    public void init() {
        TextTools.nc(null);
        SQLStrings.createTable(PojoExample.class);
    }
}
