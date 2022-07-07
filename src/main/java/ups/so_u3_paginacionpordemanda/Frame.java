
package ups.so_u3_paginacionpordemanda;

/**
 *
 * @author Diego
 */
public class Frame {
    
    private int size;
    private Reference[] referenceArray;

    public Frame(int size) {
        this.size = size;
        this.referenceArray = new Reference[size];
    }

    public void add(Reference ref, int pos){
        this.referenceArray[pos] = ref;
    }
    
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Reference[] getReferenceArray() {
        return referenceArray;
    }

    public void setReferenceArray(Reference[] referenceArray) {
        this.referenceArray = referenceArray;
    }

    @Override
    public String toString() {
        return "Frame{" + "size=" + size + ", referenceArray=" + referenceArray + '}';
    }

    
    
    
}
