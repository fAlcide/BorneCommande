package Model;

import javax.swing.*;

public class MyJOptionPane
{
    MyJOptionPane()
    {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame,"Welcome to WayToLearnX!");
    }
    public static void main(String[] args)
    {
        new MyJOptionPane();
    }
}