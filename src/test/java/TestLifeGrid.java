import edu.mcckc.gameoflife.model.LifeGrid;
import org.junit.Assert;
import org.junit.Test;
import org.pmw.tinylog.Logger;

public class TestLifeGrid
{
   @Test
   public void testLifeGridConstructor()
   {
      LifeGrid lifeGrid = null;
      try
      {
         lifeGrid = new LifeGrid();

         Assert.assertNotNull(lifeGrid);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   @Test
   public void testInitializeGrid()
   {
      LifeGrid lifeGrid = new LifeGrid(25);

      try
      {
         lifeGrid.initializeGrid("");

         Assert.assertNotNull(lifeGrid.getCell(24, 24));
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   @Test
   public void testCalcNextGeneration()
   {
      int gridSize = 2;
      LifeGrid lifeGrid = new LifeGrid(gridSize);

      try
      {
         lifeGrid.initializeGrid("");

         lifeGrid.getCell(0, 0).setIsAlive(true);
         lifeGrid.getCell(0, 1).setIsAlive(true);
         lifeGrid.getCell(1, 0).setIsAlive(true);
         lifeGrid.getCell(1, 1).setIsAlive(false);

         Logger.info(lifeGrid.getCell(1, 1).getIsAlive());

         lifeGrid.calcNextGeneration();

         Assert.assertTrue(lifeGrid.getCell(1, 1).getIsAlive());
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}
