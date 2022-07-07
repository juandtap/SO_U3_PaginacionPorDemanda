
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
       
        pageFail = 0;
        
        for (int i = 0; i < this.referenceList.size(); i++) {

            if (!exists(this.referenceList.get(i))) {
                
                if (count < frame.getSize()) {
                    
                    frame.add(this.referenceList.get(i), count);
                    count++;
                    pageFail++;

                } else {

                    count = 0;
                    frame.add(this.referenceList.get(i), count);
                    count++;
                    pageFail++;
                    
                }
            }  
        }
        
        String refs = "";
        for (var r : this.frame.getReferenceArray()) {
            refs = refs + "|_"+r.getId()+"_|"+"\n\t";
        }
        
        
        
        String fifoResult = "FIFO:\n\t"+refs+"\nNumero de Fallos de pagina: "+pageFail ;
        
        return fifoResult;
    }
    
    public void optim(){
        
        pageFail = 0;
        int count = 0;
        
        for (int i = 0; i < this.referenceList.size(); i++) {

            if (!exists(this.referenceList.get(i))) {
                
                if (count < frame.getSize()) {
                    
                    frame.add(this.referenceList.get(i), count);
                    count++;
                    pageFail++;

                } else {

                    count = 0;
                    frame.add(this.referenceList.get(i), count);
                    count++;
                    pageFail++;
                   
                }
            }  
        }
        
    }
    
    private int getNextLessUsed(ArrayList<Reference> refList, int pos){
        
        for (int i = pos; i < refList.size(); i++) {
            for (int j = 0; j < this.frame.getSize(); j++) {
                if (this.frame.getReferenceArray()[j].getId() == refList.get(i).getId()) {
                    
                }
            }
        }
        
        
        
        return 0;
    }
    
    
    private boolean exists(Reference reference){
        
             for (int i = 0; i < this.frame.getSize(); i++) {
                    if (this.frame.getReferenceArray()[i] != null) {
                        if (reference.getId() == this.frame.getReferenceArray()[i].getId()) {
                                return true;
                        }
                    }
            }
        return false;
    }
    
    
    
    

    
    
}
