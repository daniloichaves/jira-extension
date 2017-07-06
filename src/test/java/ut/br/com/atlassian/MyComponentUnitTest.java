package ut.br.com.atlassian;

import org.junit.Test;
import br.com.atlassian.api.MyPluginComponent;
import br.com.atlassian.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}