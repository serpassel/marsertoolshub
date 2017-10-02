package es.marser.marsertoolslib.sqliteutils.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Sergio on 01/02/2017.
 Created by Sergio on 01/02/2017.
 *         Anotaciones para mapeo de POJOs  con conexi&oacute;n a bases de datos SQL.
 *         <p>
 *         Registros incluidos por defecto
 *         <ul>
 *             <li>creacion</li>
 *             <li>modificacion</li>
 *         </ul>
 *         <code>SQLStrings.inclosed.CREATION</code>
 *         <p>
 *         Annotations for mapping POJOs with connection to SQL databases. [EN]  Reading of predefined external exchange records
 *         <p>
 *         [EN]  Definition of table columns
 *
 *         <code>&amp@DbColumnInclosed(col_named(creacion))<p>private String creacion;</code>
 *          <code>&amp@DbColumnInclosed(col_named(modificacion))<p>private String modificacion;</code>
 *
 *          @see es.marser.marsertoolslib.sqliteutils.SQLStrings.inclosed#CREATION
 *          @see es.marser.marsertoolslib.sqliteutils.SQLStrings.inclosed#MODIFICATION
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DbColumnInclosed {
    /**
     * Define el nombre del campo de la tabla. Debe de coincidir con el nombre de la variable del POJO
     * <code>&amp@DbColum(col_named(title))<p>private String title;</code>
     *
     * @return Nombre del campo <p>[EN]  Field Name
     */
    String col_name() default "";
}
