package smart;
import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import com.credits.scapi.v3.SmartContract;
public class Centr_DNS_Redirect extends SmartContract {
 private Map<String, String> contractversions;
 private String owner;
 private String CurrentVersion;
 
 public Centr_DNS_Redirect() {
    contractversions = new HashMap<String, String>();
    owner = initiator;
    CurrentVersion = "";
 }
 
 public String getVersionContract(String version) {
 return contractversions.get(version);
 }
 
 public String addNewVersionContract(String version, String contractkey) {
 checkIsInitiatorOwner();
 return contractversions.put(version, contractkey);
 }
 
 public void SetnewVersion(String version){
     checkIsInitiatorOwner();
     CurrentVersion = version;
 }

 public String GetCurrentVersion(){
     if(CurrentVersion != ""){
        return contractversions.get(CurrentVersion);
     }
     else{
         throw new RuntimeException("CurrentVersion not set");
     }
 }
 public int RetreiveCount(){
     return contractversions.size();
 }
 
 public void checkIsInitiatorOwner() {
 if (!initiator.contentEquals(owner)) {
 throw new RuntimeException("unable to process Request " + initiator + " is not owner");
 }
 }
}