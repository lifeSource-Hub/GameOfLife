import edu.mcckc.gameoflife.eventhandling.ControlEvent;
import org.junit.Assert;
import org.junit.Test;

public class TestControlEvent
{
   @Test
   public void testControlEventConstructor()
   {
      ControlEvent controlEvent = null;

      controlEvent = new ControlEvent(this);

      Assert.assertNotNull(controlEvent);
   }

   @Test
   public void testControlEventGetGridSize()
   {
      ControlEvent controlEvent = null;

      try
      {
         controlEvent = new ControlEvent(this, null, 42, "O");

         Assert.assertEquals(controlEvent.getGridSize(), 42);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   @Test
   public void testControlEventCommand()
   {
      ControlEvent controlEvent = null;

      try
      {
         controlEvent = new ControlEvent(this, "init", 0, "O");

         Assert.assertEquals(controlEvent.getCommand(), controlEvent.INIT_COMMAND);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}
