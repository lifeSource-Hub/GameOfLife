package edu.mcckc.gameoflife.gui;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class TextFieldCharLimit extends PlainDocument
{
   private int limit;

   TextFieldCharLimit(int limit)
   {
      super();
      this.limit = limit;
   }

   TextFieldCharLimit(int limit, boolean upper)
   {
      super();
      this.limit = limit;
   }

   public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException
   {
      if (str == null)
      {
         return;
      }

      if ((getLength() + str.length()) <= limit)
      {
         super.insertString(offset, str, attr);
      }
   }
}
