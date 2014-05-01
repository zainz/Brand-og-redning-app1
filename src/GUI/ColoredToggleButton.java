/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import BE.Firemen;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.sql.Time;
import java.sql.Timestamp;
import javax.swing.Action;
import javax.swing.JToggleButton;

/**
 *
 * @author Zainz
 */
class ColoredToggleButton extends JToggleButton {
  Firemen f;
  String s;

  public ColoredToggleButton(Firemen fir) {
    super.setText(fir.getFirstname()+" "+fir.getLastname());
    f = fir;
    
  }
  
  public ColoredToggleButton(String str, Boolean sel) {
    super(str, sel);
    s = str;
  }
  
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        if (this.isSelected())
        {
            int w = getWidth();
            int h = getHeight();
            String s = getText();

            // selected button color
            g.setColor(Color.green);
            g.fillRect(0, 0, w, h);
            // selected text color
            g.setColor(Color.black);
            g.drawString(s,
                         (w - g.getFontMetrics().stringWidth(s)) / 2 + 1,
                         (h + g.getFontMetrics().getAscent()) / 2 - 1);
        }else{
            int w = getWidth();
            int h = getHeight();
            String s = getText();

            // selected button color
            g.setColor(Color.red);
            g.fillRect(0, 0, w, h);
            // selected text color
            g.setColor(Color.black);
            g.drawString(s,
                         (w - g.getFontMetrics().stringWidth(s)) / 2 + 1,
                         (h + g.getFontMetrics().getAscent()) / 2 - 1);
        }
    }
}