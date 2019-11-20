package edu.mcckc.gameoflife.gui;

import edu.mcckc.gameoflife.eventhandling.*;
import edu.mcckc.gameoflife.model.LifeException;
import org.pmw.tinylog.Logger;

import javax.swing.*;
import java.awt.*;

public class FrameApp extends JFrame
{
   private PanelGrid pnlGrid;
   private PanelControl pnlControl;

   public FrameApp(String title) throws LifeException
   {
      this(title, 950, 800);
   }

   public FrameApp(String title, int width, int height) throws LifeException
   {
      pnlGrid = new PanelGrid();
      pnlControl = new PanelControl();

      pnlControl.setListener(new Controllable()
      {
         @Override
         public void controlActionPerformed(ControlEvent evt)
         {
            String btnCmd = evt.getCommand();
            Logger.debug("Inside controlActionPerformed, action command: " + btnCmd);

            if (btnCmd.equals(ControlEvent.INIT_COMMAND))
            {
               try
               {
                  pnlGrid.doCommand(evt);
               } catch (LifeException e)
               {
                  Logger.error(e.toString());
               }
            }
            else if (btnCmd.equals(ControlEvent.START_COMMAND))
            {
               pnlGrid.start();
               pnlControl.setLblThreadStatus("Running", new Color(22, 168, 29, 255));
            }
            else if (btnCmd.equals(ControlEvent.STOP_COMMAND))
            {
               pnlGrid.setContinueSim(false);
               pnlControl.setLblThreadStatus("Stopped", new Color(255, 0, 0, 200));
            }
         }
      });

      add(pnlGrid, BorderLayout.CENTER);
      add(pnlControl, BorderLayout.NORTH);
      Logger.debug("Inside FrameApp, panels added to frame");

      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      setSize(width, height);
      setLocationRelativeTo(null);
      setVisible(true);
   }
}