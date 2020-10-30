package jenkins.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.io.File;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;


public class IdFromFileNameTest {

    IdStrategy.CaseSensitive IdName;

    @Before
    public void setUp() throws Exception {
        IdName = new IdStrategy.CaseSensitive();
    }

    @Test
    public void testBasicNumber() {
        assertEquals("test1", IdName.idFromFilename("test1"));
    }

    @Test
    public void testBasicSymbol() {
        assertEquals("test_name", IdName.idFromFilename("test_name"));
    }

    @Test
    public void testBasicUppercase() {
        assertEquals("TestName", IdName.idFromFilename("~test~name"));
    }

    @Test
    public void testBasicHex() {
        assertEquals("name", IdName.idFromFilename("nam$0065"));
    }

    @Test
    public void testComplicatedMulti() {
        assertEquals("Test_Name1s", IdName.idFromFilename("~test_~nam$00651$0073"));
    }

}