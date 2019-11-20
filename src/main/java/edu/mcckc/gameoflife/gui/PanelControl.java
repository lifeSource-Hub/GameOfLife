package edu.mcckc.gameoflife.gui;

import edu.mcckc.gameoflife.eventhandling.*;
import edu.mcckc.gameoflife.model.LifeException;
import org.pmw.tinylog.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelControl extends JPanel implements ActionListener
{
   private JDataEntry datMaxSize;
   private JButton btnInit;
   private JButton btnStart;
   private JButton btnStop;
   private JLabel lblMessage;
   private JLabel lblThreadStatus;

   private static final String INIT_COMMAND = "init";
   private static final String START_CMD = "start";
   private static final String STOP_CMD = "stop";
   private static final int MAX_SIZE = 25;

   private Controllable listener;

   public void setListener(Controllable listener)
   {
      this.listener = listener;
   }

   public PanelControl()
   {
      datMaxSize = new JDataEntry("Represent Cells With:", "Set Grid Size:", 6);
      lblMessage = new JLabel("");
      lblThreadStatus = new JLabel("");

      btnInit = new JButton("Init Board");
      btnInit.addActionListener(this);
      btnInit.setActionCommand(INIT_COMMAND);

      btnStart = new JButton("Start SIM");
      btnStart.addActionListener(this);
      btnStart.setActionCommand(START_CMD);
      btnStart.setForeground(new Color(22, 168, 29, 255));

      btnStop = new JButton("Stop SIM");
      btnStop.addActionListener(this);
      btnStop.setActionCommand(STOP_CMD);
      btnStop.setForeground(new Color(255, 0, 0, 200));

      JPanel row1 = new JPanel();
      JPanel row2 = new JPanel();

      this.setLayout(new GridLayout(2, 1));

      row1.add(datMaxSize);
      row1.add(btnInit);
      row1.add(btnStart);
      row1.add(btnStop);
      row1.add(lblMessage);
      row2.add(lblThreadStatus);

      add(row1);
      add(row2);
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
      Logger.debug("Inside actionPerformed");

      setMessage("");
      int inputNum = 0;
      String inputChar = "";

      // Ensure user input does not exceed MAX and send event to listener in FrameApp
      try
      {
         inputNum = datMaxSize.getIntegerData();
         inputChar = datMaxSize.getCharStringData();

         if ((inputNum <= MAX_SIZE) && (inputNum > 0))
         {
            listener.controlActionPerformed(new ControlEvent(this, e.getActionCommand(), inputNum, inputChar));
         }
         else if (inputNum > MAX_SIZE)
         {
            throw new LifeException(MAX_SIZE);
         }
         else
         {
            throw new LifeException("Grid size must be greater than 0");
         }
      } catch (LifeException liex)
      {
         setMessage(liex.getMessage());
         Logger.error(liex.toString());
      }
   }

   public void setLblThreadStatus(String lblThreadStatus, Color lblColor)
   {
      this.lblThreadStatus.setText(lblThreadStatus);
      this.lblThreadStatus.setForeground(lblColor);
   }

   public void setMessage(String message)
   {
      lblMessage.setText(message);
   }
}