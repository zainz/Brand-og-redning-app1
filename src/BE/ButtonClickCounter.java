 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BE;

import GUI.ResetableCounter;

/**
 *
 * @author Disco
 */
public class ButtonClickCounter implements ResetableCounter
    {
      int counts;
      public ButtonClickCounter(int counts){
          this.counts = 0;
    }
      

    /**
     * reset counter value to 0
     */
      @Override
    public void reset() {
        this.counts = 0;
    }
      
      /**
     * reset counter value to 1
     */
    public void resetCancel() {
        this.counts = 1;
    }

    /**
     *  
     * @return counter value
     */
      @Override
    public int value() {
        return this.counts;
    }

    /**
     * adds 1 to the counter value
     */
      @Override
    public void up() {
        ++this.counts;
    }

    /**
     * subtracts 1 from the counter value
     */
      @Override
    public void down() {
        --this.counts;
    }
    }