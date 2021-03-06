package es.marser.marsertoolslib.sqliteutils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Date;

import es.marser.marsertoolslib.sqliteutils.examples.PojoExample;

import static org.mockito.Mockito.when;

/**
 * @author sergio
 *         Created by sergio on 2/10/17.
 */
@SuppressWarnings("CanBeFinal")
@RunWith(MockitoJUnitRunner.class)
public class SQLStringsTest {


    private PojoExample example;
    private String key;

    @Mock
    PojoExample mockexample;

    @Before
    public void init() {
        when(mockexample.getKey()).thenReturn("keyvalue");

        key = mockexample.getKey();
        example = new PojoExample();
        example.setKey(key);
        example.setName("NOMBRE").setAge("17");
    }

    @Test
    public void channel1() {
        Assert.assertEquals(SQLStrings.createTable(PojoExample.class), "CREATE TABLE IF NOT EXISTS users(key TEXT PRIMARY KEY, name TEXT, age TEXT, creacion INTEGER, modificacion INTEGER)");
        Assert.assertEquals(SQLStrings.dropTable(PojoExample.class), "DROP TABLE IF EXISTS users");
        Assert.assertEquals(SQLStrings.renameTable("old", "new"), "ALTER TABLE old RENAME TO new");
        Assert.assertEquals(SQLStrings.copyTables("old", "new"), "INSERT INTO new SELECT * FROM old");
        Assert.assertEquals(SQLStrings.addColumns(PojoExample.class, -1).get(0), "ALTER TABLE users ADD COLUMN name TEXT");
        Assert.assertEquals(SQLStrings.addColumns(PojoExample.class, -1).get(1), "ALTER TABLE users ADD COLUMN age TEXT");
    }

    @Test
    public void channel2() {
        Assert.assertEquals(SQLStrings.selectAll(PojoExample.class), "SELECT * FROM users");
        Assert.assertEquals(SQLStrings.findRecordSql(key, PojoExample.class), "SELECT * FROM users WHERE key = '" + key + "'");
    }

    @Test
    public void channel3() throws IllegalAccessException {
        Assert.assertEquals(true, SQLStrings.insertRecord(example).startsWith("INSERT INTO users(key, name, age, creacion, modificacion) VALUES ('" + key + "', 'NOMBRE', '17',"));
        Assert.assertEquals(true, SQLStrings.insertOrReplaceRecord(example).startsWith("INSERT OR REPLACE INTO users(key, name, age, creacion, modificacion) VALUES ('" + key + "', 'NOMBRE', '17',"));
        Assert.assertEquals(true, SQLStrings.insertOrIgnoreRecord(example).startsWith("INSERT OR IGNORE INTO users(key, name, age, creacion, modificacion) VALUES ('" + key + "', 'NOMBRE', '17',"));
        Assert.assertEquals(true, SQLStrings.upRecord(example).startsWith("UPDATE users SET name = 'NOMBRE', age = '17', modificacion ="));
        Assert.assertEquals(true, SQLStrings.upRecord(example).endsWith("WHERE key = '" + key + "'"));
        Assert.assertEquals(SQLStrings.deleteRecord(example), "DELETE FROM users WHERE key = '" + key + "'");
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void channel4() throws IllegalAccessException {
        Assert.assertEquals(SQLStrings.transformValuesToDb(true).toString(), "0");
        Assert.assertEquals(SQLStrings.transformValuesToDb(false).toString(), "-1");
        Assert.assertEquals(SQLStrings.transformValuesToDb(10.2).toString(), "10.2");
        Assert.assertEquals(SQLStrings.transformValuesToDb(1).toString(), "1");
        Assert.assertEquals(SQLStrings.transformValuesToDb(key).toString(), "'"+key+"'");
        Assert.assertEquals(SQLStrings.transformValuesToDb(example).toString(), "users|keyvalue|NOMBRE|17|");

        Assert.assertEquals(SQLStrings.getDbCastName(String.class), "TEXT");
        Assert.assertEquals(SQLStrings.getDbCastName(BigDecimal.class), "NUM");
        Assert.assertEquals(SQLStrings.getDbCastName(Double.class), "NUM");
        Assert.assertEquals(SQLStrings.getDbCastName(Boolean.class), "INTEGER");
        Assert.assertEquals(SQLStrings.getDbCastName(Date.class), "INTEGER");
        Assert.assertEquals(SQLStrings.getDbCastName(Object.class), "TEXT");
    }

}