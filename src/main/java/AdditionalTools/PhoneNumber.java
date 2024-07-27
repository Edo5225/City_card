package AdditionalTools;

import java.util.Random;

public interface PhoneNumber {
       Random rand = new Random();
     long tels = Math.abs(rand.nextInt()*rand.nextInt())%10000000 + 9190000000L;
     String randomPhoneNumber = Long.toString(tels);
}
