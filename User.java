
package assignment3.models;


public class User {
    private String name;
    private String id;
    private String email;
  // constructor  
    public User(String name, String id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }
    // setters
    public void setName(String name) { 
        this.name = name; 
    }
    public void setEmail(String email) {
         this.email = email;
     }
   // getters
    public String getName() { 
        return name; 
    }
    public String getId() { 
        return id; 
    }
    public String getEmail() { 
        return email; 
    } 
}
