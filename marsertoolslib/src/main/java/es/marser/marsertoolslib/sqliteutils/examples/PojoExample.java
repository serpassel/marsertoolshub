package es.marser.marsertoolslib.sqliteutils.examples;

import es.marser.marsertoolslib.sqliteutils.annotation.DbColumn;
import es.marser.marsertoolslib.sqliteutils.annotation.DbColumnInclosed;
import es.marser.marsertoolslib.sqliteutils.annotation.DbPrimaryKey;
import es.marser.marsertoolslib.sqliteutils.annotation.DbTable;

/**
 * @author sergio
 *         Created by sergio on 28/09/17.
 *         POJO Mapeado de ejemplo
 *         <p>
 *         [EN]  POJO Sample Mapping
 *
 */

@DbTable(name = "users")
@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class PojoExample {
    @DbPrimaryKey
    private String key;
    @DbColumn(col_name = "name")
    private String name;
    @DbColumn(col_name = "age")
    private String age;

    @DbColumnInclosed(col_name = "creacion")
    private String creacion;

    @DbColumnInclosed(col_name = "modificacion")
    private String modificacion;

    public PojoExample() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public PojoExample setName(String name) {
        this.name = name;
        return this;
    }

    public String getAge() {
        return age;
    }

    public PojoExample setAge(String age) {
        this.age = age;
        return this;
    }

    public String getCreacion() {
        return creacion;
    }

    public PojoExample setCreacion(String creacion) {
        this.creacion = creacion;
        return this;
    }

    public String getModificacion() {
        return modificacion;
    }

    public PojoExample setModificacion(String modificacion) {
        this.modificacion = modificacion;
        return this;
    }

    @Override
    public String toString() {
        return "users|" +
                key + "|" +
                name + '|' +
               age + '|' ;
    }
}
