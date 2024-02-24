package smart;
import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import com.credits.scapi.v3.SmartContract;
import com.credits.scapi.annotations.ContractAddress;
import com.credits.scapi.annotations.ContractMethod;
import com.credits.scapi.annotations.UsingContract;
public class TestContract extends SmartContract {
 
 public TestContract() {
 }
 
 @UsingContract(address = "BCegA8AgrK7PEnGME95NHxJcDxesiYDGGRZSMFnWMMjM", method = "GetCurrentVersion")
 public String externalCallChangeState(@ContractAddress(id = 0) String address, @ContractMethod(id = 0) String method) {
    return (String) invokeExternalContract(address, method).toString();
 }
 public int externalCall(@ContractAddress(id = 0) String address, @ContractMethod(id = 0) String method) {
    return (int) invokeExternalContract(address, method);
}
 

 @Override
 protected String payable(BigDecimal amount, byte[] userData) {
 // TODO Auto-generated method stub
 return null;
 }
}