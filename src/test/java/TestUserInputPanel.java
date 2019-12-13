import edu.mcckc.gameoflife.gui.UserInputPanel;
import org.junit.Assert;
import org.junit.Test;

public class TestUserInputPanel
{
    @Test
    public void testGetGridSizeInt01()
    {
        UserInputPanel userInputPanel = new UserInputPanel();

        try
        {
            userInputPanel.setGridSizeInput("42");

            Assert.assertEquals(42, userInputPanel.getGridSizeInt());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetGridSizeInt02()
    {
        UserInputPanel userInputPanel = new UserInputPanel();

        try
        {
            userInputPanel.setGridSizeInput("25.9");

            Assert.assertEquals(25, userInputPanel.getGridSizeInt());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetGridSizeDecimal()
    {
        UserInputPanel userInputPanel = new UserInputPanel();

        try
        {
            userInputPanel.setGridSizeInput("3.14");

            Assert.assertEquals(3.14, userInputPanel.getGridSizeDecimal(), 0);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetGridSizeStr()
    {
        UserInputPanel userInputPanel = new UserInputPanel();

        try
        {
            userInputPanel.setGridSizeInput("Hi");

            Assert.assertEquals("Hi", userInputPanel.getGridSizeStr());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void testGridSizeInputLength()
    {
        UserInputPanel userInputPanel = new UserInputPanel();

        try
        {
            userInputPanel.setGridSizeInput("123");

            Assert.assertEquals("", userInputPanel.getGridSizeStr());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
