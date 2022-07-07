
package ups.so_u3_paginacionpordemanda;

/**
 *
 * @author Diego
 */
public class Reference {
    private int id;
    private int use;

    public Reference(int id) {
        this.id = id;
        this.use = 0;
    }
    
    public void resetUse(){
        this.use = 0;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUse() {
        return use;
    }

    public void setUse(int use) {
        this.use = use;
    }

    @Override
    public String toString() {
        return "Reference{" + "id=" + id + ", uso=" + use + '}';
    }
    
    
    
    
}
