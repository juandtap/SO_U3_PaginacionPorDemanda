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
    private int pageFail = 0;
    
    public ReplacePlan(Frame frame, ArrayList<Reference> referenceList) {
        this.frame = frame;
        this.referenceList = referenceList;
        
    }
    
    public String fifo(){
        int count = 0;
        int pos = 0;
        pageFail = 0;
        
        for (int i = 0; i < this.referenceList.size(); i++) {

            if (!exists(this.referenceList.get(i).getId())) {
                
                if (count < frame.getSize()) {
                    
                    frame.add(this.referenceList.get(i).getId(), count);
                    count++;
                    pageFail++;

                } else {

                    count = 0;
                    frame.add(this.referenceList.get(i).getId(), count);
                    count++;
                    pageFail++;
                    pos++;
                }
            }  
        }
        
        String refs = "";
        for (var r : this.frame.getReferenceArray()) {
            refs = refs + "|_"+r+"_|"+"\n\t";
        }
        
        
        
        String fifoResult = "FIFO:\n\t"+refs+"\nNumero de Fallos de pagina: "+pageFail ;
        
        return fifoResult;
    }
    
    private boolean exists(int reference){
        for (int i = 0; i < this.frame.getSize(); i++) {
            if (reference == this.frame.getReferenceArray()[i]) {
                return true;
            }
        }
        return false;
    }
    
    

    

    
    
}
