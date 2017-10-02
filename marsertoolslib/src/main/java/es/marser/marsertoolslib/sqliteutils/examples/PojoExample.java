package es.marser.marsertoolslib.sqliteutils.examples;

import es.marser.marsertoolslib.sqliteutils.annotation.DbColumn;
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
@SuppressWarnings({"unused", "WeakerAccess"})
public class PojoExample {
    @DbPrimaryKey
    private String key;
    @DbColumn(col_name = "name")
    private String name;
    @DbColumn(col_name = "age")
    private String age;

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

    @Override
    public String toString() {
        return "users|" +
                key + "|" +
                name + '|' +
               age + '|' ;
    }
}
