import edu.mcckc.gameoflife.model.LifeCell;
import org.junit.Assert;
import org.junit.Test;
import org.pmw.tinylog.Logger;

public class TestLifeCell
{
   @Test
   public void testCellConstructor()
   {
      LifeCell lifeCell = null;

      lifeCell = new LifeCell();
      Assert.assertNotNull(lifeCell);
   }

   @Test
   public void testIsAlive()
   {
      LifeCell lifeCell = null;

      try
      {
         lifeCell = new LifeCell(true, 0);
         Logger.info(lifeCell.getIsAlive());

         Assert.assertTrue(lifeCell.getIsAlive());
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   @Test
   public void testNeighborCount()
   {
      LifeCell lifeCell = null;

      try
      {
         lifeCell = new LifeCell(false, 3);
         Assert.assertEquals(lifeCell.getNeighborCount(), 3);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   @Test
   public void testRegenerateDeadTwoNeighbors()
   {
      LifeCell lifeCell = null;

      try
      {
         lifeCell = new LifeCell(false, 2);
         Logger.info(lifeCell.getIsAlive());

         lifeCell.regenerate();
         Assert.assertFalse(lifeCell.getIsAlive());
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   @Test
   public void testRegenerateDeadThreeNeighbors()
   {
      LifeCell lifeCell = null;

      try
      {
         lifeCell = new LifeCell(false, 3);
         Logger.info(lifeCell.getIsAlive());

         lifeCell.regenerate();
         Assert.assertTrue(lifeCell.getIsAlive());
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   @Test
   public void testRegenerateDeadFourNeighbors()
   {
      LifeCell lifeCell = null;

      try
      {
         lifeCell = new LifeCell(false, 4);
         Logger.info(lifeCell.getIsAlive());

         lifeCell.regenerate();
         Assert.assertFalse(lifeCell.getIsAlive());
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   @Test
   public void testRegenerateAliveOneNeighbor()
   {
      LifeCell lifeCell = null;

      try
      {
         lifeCell = new LifeCell(true, 1);
         Logger.info(lifeCell.getIsAlive());

         lifeCell.regenerate();
         Assert.assertFalse(lifeCell.getIsAlive());
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   @Test
   public void testRegenerateAliveTwoNeighbors()
   {
      LifeCell lifeCell = null;

      try
      {
         lifeCell = new LifeCell(true, 2);
         Logger.info(lifeCell.getIsAlive());

         lifeCell.regenerate();
         Assert.assertTrue(lifeCell.getIsAlive());
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   @Test
   public void testRegenerateAliveThreeNeighbors()
   {
      LifeCell lifeCell = null;

      try
      {
         lifeCell = new LifeCell(true, 3);
         Logger.info(lifeCell.getIsAlive());

         lifeCell.regenerate();
         Assert.assertTrue(lifeCell.getIsAlive());
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   @Test
   public void testRegenerateAliveFourNeighbors()
   {
      LifeCell lifeCell = null;

      try
      {
         lifeCell = new LifeCell(true, 4);
         Logger.info(lifeCell.getIsAlive());

         lifeCell.regenerate();
         Assert.assertFalse(lifeCell.getIsAlive());
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   @Test
   public void testToString()
   {
      LifeCell lifeCell = null;

      try
      {
         lifeCell = new LifeCell(true, 0);
         Logger.info(lifeCell.getIsAlive());

         Assert.assertEquals(lifeCell.toString(), "O");

         lifeCell = new LifeCell(false, 3);
         Logger.info(lifeCell.getIsAlive());

         Assert.assertEquals(lifeCell.toString(), " ");
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}
