/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ups.so_u3_paginacionpordemanda;


import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class ReplacePlan {
    private Frame frame;
    private ArrayList<Reference> referenceList;

    public ReplacePlan(Frame frame, ArrayList<Reference> referenceList) {
        this.frame = frame;
        this.referenceList = referenceList;
    }
    
    public void fifo(){
        int flag = 0;
        for (int i = 0; i < this.referenceList.size(); i++) {
            
            if (flag < frame.getSize()) {
                frame.add(this.referenceList.get(i).getId(), flag);
            }
        }
        
        
    }
    
    

    

    
    
}
