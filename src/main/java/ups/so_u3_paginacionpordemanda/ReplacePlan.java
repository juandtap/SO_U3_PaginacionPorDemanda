
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
    
    public String optim(){
        
        pageFail = 0;
        int count = 0;
        
        for (int i = 0; i < this.referenceList.size(); i++) {

            if (!exists(this.referenceList.get(i))) {
                
                if (count < frame.getSize()) {
                    
                    frame.add(this.referenceList.get(i), count);
                    count++;
                    pageFail++;

                } else {

                    count = getNextLessUsed(referenceList, i+1);
                    frame.add(this.referenceList.get(i), count);
                    count = frame.getSize();
                    pageFail++;
                   
                }
            }  
        }
        
        String refs = "";
        
       
        for (var re: this.frame.getReferenceArray()) {
            refs = refs + "|_"+re.getId()+"_|"+"\n\t";
        }
        
        String optimResult = "OPTIMO:\n\t" +refs+"\nNumero de Fallos de pagina: "+pageFail;
        System.out.println("fallos de pagina : "+pageFail);
        return optimResult;
    }
    
    private int getNextLessUsed(ArrayList<Reference> refList, int pos){
        
        int sum;
        
        for (int i = 0; i < this.frame.getSize(); i++) {
            sum = 0;
            
            for (int j = pos; j < refList.size(); j++) {
                
                if (this.frame.getReferenceArray()[i].getId() != refList.get(j).getId()) {
                    
                    this.frame.getReferenceArray()[i].setUse(++sum);
                    
                } else{
                   
                    break;
                }
            }
        }
        
        
        var referenceToReplace = getNumMax(this.frame.getReferenceArray());
        
        
        resetUseRefFrame();
        System.out.println(">>>Referencia  a reemplazar :"+referenceToReplace.getId());
        int posReeplace = positionToReplace(referenceToReplace);
        System.out.println(">>> Posicion a reemplazar : "+posReeplace);
        return posReeplace;
    }
    
    
    private int positionToReplace(Reference ref){
        
        int pos2replace = 0;
        
        for (int i = 0; i < frame.getSize(); i++) {
            if (frame.getReferenceArray()[i] == ref) {
                pos2replace = i;
            }
        }
        
        return pos2replace;
    }
    
    private Reference getNumMax(Reference[] arrayRef){
        
        for (var a: arrayRef) {
            System.out.println(a.getId() + " : uso "+a.getUse());
        }
        
        int max = -1;
        
        for (var ref: arrayRef) {
            if (ref.getUse() > max) {
                max = ref.getUse();
            }
        }
        
        System.out.println("maximo "+max);
        
        for (var ref: arrayRef) {
            if (ref.getUse() == max) {
                System.out.println("maxima referencia "+ref);
                return ref;
            }
        }
        
        return null;
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
    
    
    
    private void resetUseRefFrame(){
        for (var r  : frame.getReferenceArray()) {
            r.resetUse();
        }
    }

    
    
}
