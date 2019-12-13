import edu.mcckc.gameoflife.model.LifeCell;
import edu.mcckc.gameoflife.model.Cell;
import org.junit.Assert;
import org.junit.Test;
import org.pmw.tinylog.Logger;

import java.util.HashMap;
import java.util.Map;

public class TestLifeCell
{
    @Test
    public void testCellConstructor()
    {
        Cell lifeCell = null;

        lifeCell = new LifeCell();
        Assert.assertNotNull(lifeCell);
    }

    @Test
    public void testIsAlive()
    {
        Cell lifeCell = null;
        HashMap<Cell.CellType, Integer> neighborCount = new HashMap<>();

        try
        {
            neighborCount.put(Cell.CellType.LIFE, 0);
            neighborCount.put(Cell.CellType.DOMINANT, 0);

            lifeCell = new LifeCell(true, neighborCount);
            Logger.info(lifeCell.getIsAlive());

            Assert.assertTrue(lifeCell.getIsAlive());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void testNeighborCount()
    {
        Cell lifeCell = null;
        HashMap<Cell.CellType, Integer> neighborCount = new HashMap<>();

        try
        {
            neighborCount.put(Cell.CellType.LIFE, 3);
            neighborCount.put(Cell.CellType.DOMINANT, 0);

            lifeCell = new LifeCell(false, neighborCount);
            Integer count = lifeCell.getNeighborCount().get(Cell.CellType.LIFE);

            Assert.assertEquals(3, (int) count);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //
    @Test
    public void testRegenerateDeadTwoNeighbors()
    {
        Cell lifeCell = null;
        HashMap<Cell.CellType, Integer> neighborCount = new HashMap<>();

        try
        {
            neighborCount.put(Cell.CellType.LIFE, 2);
            neighborCount.put(Cell.CellType.DOMINANT, 0);

            lifeCell = new LifeCell(false, neighborCount);
            Logger.info(lifeCell.getIsAlive());

            lifeCell.regenerate();
            Assert.assertFalse(lifeCell.getIsAlive());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void testRegenerateDeadThreeNeighbors()
    {
        Cell lifeCell = null;
        HashMap<Cell.CellType, Integer> neighborCount = new HashMap<>();

        try
        {
            neighborCount.put(Cell.CellType.LIFE, 3);
            neighborCount.put(Cell.CellType.DOMINANT, 0);

            lifeCell = new LifeCell(false, neighborCount);
            Logger.info(lifeCell.getIsAlive());

            lifeCell.regenerate();
            Assert.assertTrue(lifeCell.getIsAlive());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void testRegenerateDeadFourNeighbors()
    {
        Cell lifeCell = null;
        HashMap<Cell.CellType, Integer> neighborCount = new HashMap<>();

        try
        {
            neighborCount.put(Cell.CellType.LIFE, 4);
            neighborCount.put(Cell.CellType.DOMINANT, 0);

            lifeCell = new LifeCell(false, neighborCount);
            Logger.info(lifeCell.getIsAlive());

            lifeCell.regenerate();
            Assert.assertFalse(lifeCell.getIsAlive());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void testRegenerateAliveOneNeighbor()
    {
        Cell lifeCell = null;
        HashMap<Cell.CellType, Integer> neighborCount = new HashMap<>();

        try
        {
            neighborCount.put(Cell.CellType.LIFE, 1);
            neighborCount.put(Cell.CellType.DOMINANT, 0);

            lifeCell = new LifeCell(true, neighborCount);
            Logger.info(lifeCell.getIsAlive());

            lifeCell.regenerate();
            Assert.assertFalse(lifeCell.getIsAlive());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void testRegenerateAliveTwoNeighbors()
    {
        Cell lifeCell = null;
        HashMap<Cell.CellType, Integer> neighborCount = new HashMap<>();

        try
        {
            neighborCount.put(Cell.CellType.LIFE, 3);
            neighborCount.put(Cell.CellType.DOMINANT, 0);

            lifeCell = new LifeCell(true, neighborCount);
            Logger.info(lifeCell.getIsAlive());

            lifeCell.regenerate();
            Assert.assertTrue(lifeCell.getIsAlive());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void testRegenerateAliveThreeNeighbors()
    {
        Cell lifeCell = null;
        HashMap<Cell.CellType, Integer> neighborCount = new HashMap<>();

        try
        {
            neighborCount.put(Cell.CellType.LIFE, 3);
            neighborCount.put(Cell.CellType.DOMINANT, 0);

            lifeCell = new LifeCell(true, neighborCount);
            Logger.info(lifeCell.getIsAlive());

            lifeCell.regenerate();
            Assert.assertTrue(lifeCell.getIsAlive());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void testRegenerateAliveFourNeighbors()
    {
        Cell lifeCell = null;
        HashMap<Cell.CellType, Integer> neighborCount = new HashMap<>();

        try
        {
            neighborCount.put(Cell.CellType.LIFE, 4);
            neighborCount.put(Cell.CellType.DOMINANT, 0);

            lifeCell = new LifeCell(true, neighborCount);
            Logger.info(lifeCell.getIsAlive());

            lifeCell.regenerate();
            Assert.assertFalse(lifeCell.getIsAlive());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
