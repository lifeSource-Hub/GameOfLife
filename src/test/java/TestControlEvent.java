import edu.mcckc.gameoflife.eventhandling.ControlEvent;
import edu.mcckc.gameoflife.model.ControlCommand;
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

         Assert.assertEquals(42, controlEvent.getGridSize());
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
         controlEvent = new ControlEvent(this, ControlCommand.INIT, 0, "O");

         Assert.assertEquals(controlEvent.getCommand(), ControlCommand.INIT);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}
