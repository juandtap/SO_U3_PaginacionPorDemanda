/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ups.so_u3_paginacionpordemanda;

/**
 *
 * @author Diego
 */
public class Frame {
    
    private int size;
    private int[] referenceArray;

    public Frame(int size) {
        this.size = size;
        this.referenceArray = new int[size];
    }

    public void add(int ref, int pos){
        this.referenceArray[pos] = ref;
    }
    
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[] getReferenceArray() {
        return referenceArray;
    }

    public void setReferenceArray(int[] referenceArray) {
        this.referenceArray = referenceArray;
    }

    @Override
    public String toString() {
        return "Frame{" + "size=" + size + ", referenceArray=" + referenceArray + '}';
    }

    
    
    
}
