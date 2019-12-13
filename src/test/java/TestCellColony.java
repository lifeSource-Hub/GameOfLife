import edu.mcckc.gameoflife.model.CellColony;
import org.junit.Assert;
import org.junit.Test;
import org.pmw.tinylog.Logger;

public class TestCellColony
{
   @Test
   public void testCellGridConstructor()
   {
      CellColony cellColony = null;
      try
      {
         cellColony = new CellColony();

         Assert.assertNotNull(cellColony);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   @Test
   public void testInitializeGrid()
   {
      CellColony cellColony = new CellColony(25);

      try
      {
         cellColony.initializeGrid();

         Assert.assertNotNull(cellColony.getCell(24, 24));
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   @Test
   public void testCalcNextGeneration()
   {
      int gridSize = 2;
      CellColony cellColony = new CellColony(gridSize);

      try
      {
         cellColony.initializeGrid();

         cellColony.getCell(0, 0).setIsAlive(true);
         cellColony.getCell(0, 1).setIsAlive(true);
         cellColony.getCell(1, 0).setIsAlive(true);
         cellColony.getCell(1, 1).setIsAlive(false);

         Logger.info(cellColony.getCell(1, 1).getIsAlive());

         cellColony.calcNextGeneration();

         Assert.assertTrue(cellColony.getCell(1, 1).getIsAlive());
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}
