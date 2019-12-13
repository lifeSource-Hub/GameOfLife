package edu.mcckc.gameoflife.gui;

import edu.mcckc.gameoflife.model.LifeException;

import javax.swing.*;

public class UserInputPanel extends JPanel
{
    private JLabel cellCharLbl;
    private JTextField cellCharInput;
    private JLabel gridSizeLbl;
    private JTextField gridSizeInput;

    public UserInputPanel()
    {
        this("Cell:", "Size: ", 20);
    }

    public UserInputPanel(String charCaption, String sizeCaption, int size)
    {
        cellCharLbl = new JLabel(charCaption);
        cellCharInput = new JTextField(2);
        cellCharInput.setDocument(new TextFieldCharLimit(1));
        cellCharInput.setText("O");
        gridSizeLbl = new JLabel(sizeCaption);
        gridSizeInput = new JTextField(size);
        gridSizeInput.setDocument(new TextFieldCharLimit(2));
        gridSizeInput.setText("25");

        cellCharInput.setBorder(BorderFactory.createEtchedBorder(1));
        gridSizeInput.setBorder(BorderFactory.createEtchedBorder(1));

        JPanel row1 = new JPanel();
        row1.add(cellCharLbl);
        row1.add(cellCharInput);
        row1.add(gridSizeLbl);
        row1.add(gridSizeInput);

        add(row1);
    }

    public int getGridSizeInt() throws LifeException
    {
        int inputNum;
        double tempInputNum;

        try
        {
            // Accept decimal input but convert to integer
            tempInputNum = Math.floor(Double.parseDouble(gridSizeInput.getText()));
            inputNum = (int) tempInputNum;

            return inputNum;
        }
        catch (NumberFormatException nfex)
        {
            throw new LifeException();
        }
    }

    public double getGridSizeDecimal() throws LifeException
    {
        double inputNum;

        try
        {
            inputNum = Double.parseDouble(gridSizeInput.getText());

            return inputNum;

        }
        catch (NumberFormatException nfex)
        {
            throw new LifeException();
        }
    }

    public String getGridSizeStr() throws LifeException
    {
        try
        {
            return gridSizeInput.getText();
        }
        catch (Exception e)
        {
            throw new LifeException();
        }
    }

    public String getCellChar() throws LifeException
    {
        try
        {
            return cellCharInput.getText();
        }
        catch (Exception e)
        {
            throw new LifeException();
        }
    }

    @Override
    public void setEnabled(boolean enabled)
    {
        gridSizeInput.setEnabled(enabled);
    }

    // For tests
    public void setGridSizeInput(String value)
    {
        gridSizeInput.setText(value);
    }
}