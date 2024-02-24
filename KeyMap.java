package smart;
import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import com.credits.scapi.v3.SmartContract;
public class Centr_DNS extends SmartContract {
 private Map<String, String> mapNamesToPublicKey;
 private String owner;
 
 public Centr_DNS() {
    mapNamesToPublicKey = new HashMap<String, String>();
    owner = initiator;
 }
 
 public String getPublicKeyFromName(String name) {
 checkIsInitiatorOwner();
 return mapNamesToPublicKey.get(name);
 }
 
 public String addPublicKeyFromName(String name, String publicKey) {
 checkIsInitiatorOwner();
 return mapNamesToPublicKey.put(name, publicKey);
 }
 
//Test Function
 public String addbatch(String name, String publicKey) {
   checkIsInitiatorOwner();
   int count = 0;
   for (int i=0 ; i<5 ; i++){
      Random rand = new Random(); //instance of random class
      int upperbound = 25;
         //generate random values from 0-24
      int int_random = rand.nextInt(upperbound);
      mapNamesToPublicKey.put(Integer.toString(int_random), publicKey);
      count = count + 1;
   }
   return Integer.toString(count);
   //return Integer.toString(int_random);
   }


 public int RetreiveCount(){
     return mapNamesToPublicKey.size();
 }
 
 public void checkIsInitiatorOwner() {
 if (!initiator.contentEquals(owner)) {
 throw new RuntimeException("unable to process Request " + initiator + " is not owner");
 }
 }

 @Override
 protected String payable(BigDecimal amount, byte[] userData) {
 // TODO Auto-generated method stub
 return null;
 }
}