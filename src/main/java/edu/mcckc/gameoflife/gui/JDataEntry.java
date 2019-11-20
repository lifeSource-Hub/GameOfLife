package edu.mcckc.gameoflife.gui;

import edu.mcckc.gameoflife.model.LifeException;
import org.pmw.tinylog.Logger;

import javax.swing.*;

public class JDataEntry extends JPanel
{
    private JLabel lblCharInput;
    private JTextField txtCharInput;
    private JLabel lblInput;
    private JTextField txtInput;

    public JDataEntry()
    {
        this("Cell:", "Input: ", 20);
    }

    public JDataEntry(String charCaption, String sizeCaption, int size)
    {
        lblCharInput = new JLabel(charCaption);
        txtCharInput = new JTextField(2);
        txtCharInput.setDocument(new JTextFieldLimit(1));
        lblInput = new JLabel(sizeCaption);
        txtInput = new JTextField(size);

        txtCharInput.setBorder(BorderFactory.createEtchedBorder(1));
        txtInput.setBorder(BorderFactory.createEtchedBorder(1));

        JPanel row1 = new JPanel();
        row1.add(lblCharInput);
        row1.add(txtCharInput);
        row1.add(lblInput);
        row1.add(txtInput);
        add(row1);
    }

    public int getIntegerData() throws LifeException
    {
        int inputNum;
        double tempInputNum;

        try
        {
            // Accept decimal input but convert to integer
            tempInputNum = Math.floor(Double.parseDouble(txtInput.getText()));
            inputNum = (int) tempInputNum;

            return inputNum;
        }
        catch (NumberFormatException nfex)
        {
            throw new LifeException();
        }
    }

    public double getDecimalData() throws LifeException
    {
        double inputNum;

        try
        {
            inputNum = Double.parseDouble(txtInput.getText());

            return inputNum;

        }
        catch (NumberFormatException nfex)
        {
            throw new LifeException();
        }
    }

    public String getStringData() throws LifeException
    {
        try
        {
            return txtInput.getText();
        }
        catch (Exception e)
        {
            throw new LifeException();
        }
    }

    public String getCharStringData() throws LifeException
    {
        try
        {
            return txtCharInput.getText();
        }
        catch (Exception e)
        {
            throw new LifeException();
        }
    }

    @Override
    public void setEnabled(boolean enabled)
    {
        txtInput.setEnabled(enabled);
    }

    public void setInputData(String value)
    {
        txtInput.setText(value);
    }
}