import edu.mcckc.gameoflife.eventhandling.ControlEvent;
import edu.mcckc.gameoflife.gui.ColonyPanel;
import edu.mcckc.gameoflife.model.ControlCommand;
import org.junit.Assert;
import org.junit.Test;
import org.pmw.tinylog.Logger;

public class TestColonyPanel
{
   @Test
   public void testPanelGridConstructor()
   {
      ColonyPanel colonyPanel = null;
      try
      {
         colonyPanel = new ColonyPanel();

         Assert.assertNotNull(colonyPanel);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   @Test
   public void testStartThread()
   {
      ColonyPanel colonyPanel = null;
      try
      {
         colonyPanel = new ColonyPanel();
         colonyPanel.initializePnlGrid(new ControlEvent(this, ControlCommand.INIT, 25, "O"));
         Logger.info(colonyPanel.getContinueSim());

         colonyPanel.start();

         Assert.assertTrue(colonyPanel.getContinueSim());
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   @Test
   public void testStopThread()
   {
      ColonyPanel colonyPanel = null;
      try
      {
         colonyPanel = new ColonyPanel();
         colonyPanel.initializePnlGrid(new ControlEvent(this, ControlCommand.INIT, 25, "O"));
         colonyPanel.start();
         Logger.info(colonyPanel.getContinueSim());

         colonyPanel.setContinueSim(false);

         Assert.assertFalse(colonyPanel.getContinueSim());
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}
