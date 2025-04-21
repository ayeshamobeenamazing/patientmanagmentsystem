
package assignment3.models;


public class SMSNotification implements Notifyable {

    @Override
    public void sendNotification(String to, String message) {
        System.out.println("\n Sending SMS to " + to);
        System.out.println("Message: " + message);
        
    }
}
    

