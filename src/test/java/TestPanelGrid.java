import edu.mcckc.gameoflife.eventhandling.ControlEvent;
import edu.mcckc.gameoflife.gui.PanelGrid;
import org.junit.Assert;
import org.junit.Test;
import org.pmw.tinylog.Logger;

public class TestPanelGrid
{
   @Test
   public void testLifeGridConstructor()
   {
      PanelGrid panelGrid = null;
      try
      {
         panelGrid = new PanelGrid();

         Assert.assertNotNull(panelGrid);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   @Test
   public void testStartThread()
   {
      PanelGrid panelGrid = null;
      try
      {
         panelGrid = new PanelGrid();
         panelGrid.doCommand(new ControlEvent(this, "init", 25, "O"));
         Logger.info(panelGrid.getContinueSim());

         panelGrid.start();

         Assert.assertTrue(panelGrid.getContinueSim());
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   @Test
   public void testStopThread()
   {
      PanelGrid panelGrid = null;
      try
      {
         panelGrid = new PanelGrid();
         panelGrid.doCommand(new ControlEvent(this, "init", 25, "O"));
         panelGrid.start();
         Logger.info(panelGrid.getContinueSim());

         panelGrid.setContinueSim(false);

         Assert.assertFalse(panelGrid.getContinueSim());
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}
