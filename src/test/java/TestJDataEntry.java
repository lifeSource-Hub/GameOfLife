import edu.mcckc.gameoflife.gui.JDataEntry;
import org.junit.Assert;
import org.junit.Test;

public class TestJDataEntry
{
   @Test
   public void testJDataEntryGetInteger01()
   {
      JDataEntry jDataEntry = new JDataEntry();

      try
      {
         jDataEntry.setInputData("42");

         Assert.assertEquals(jDataEntry.getIntegerData(), 42);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   @Test
   public void testJDataEntryGetInteger02()
   {
      JDataEntry jDataEntry = new JDataEntry();

      try
      {
         jDataEntry.setInputData("25.9");

         Assert.assertEquals(jDataEntry.getIntegerData(), 25);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   @Test
   public void testJDataEntryGetDouble()
   {
      JDataEntry jDataEntry = new JDataEntry();

      try
      {
         jDataEntry.setInputData("3.14");

         Assert.assertEquals(jDataEntry.getDecimalData(),  3.14, 0);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   @Test
   public void testJDataEntryGetString()
   {
      JDataEntry jDataEntry = new JDataEntry();

      try
      {
         jDataEntry.setInputData("Hello");

         Assert.assertEquals(jDataEntry.getStringData(), "Hello");
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}
