/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ups.so_u3_paginacionpordemanda;

/**
 *
 * @author Diego
 */
public class Reference {
    private int id;
    private int age;

    public Reference(int id) {
        this.id = id;
        this.age = 0;
    }
    
    public void resetAge(){
        this.age = 0;
    }
    
    public void increaseAge(){
        this.age++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Reference{" + "id=" + id + ", age=" + age + '}';
    }
    
    
    
    
}
