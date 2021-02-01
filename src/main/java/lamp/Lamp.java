package lamp;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Lamp {
	public static Map<String, Lamp> map = new HashMap<>();
	
	boolean b = false;
	AccessLog getLog = new AccessLog();
	AccessLog activationLog = new AccessLog();
	
	public boolean check() {
		if (b) {
			b = false;
			return true;
		}
		
		return false;
	}
	
	public void activate() {
		b = true;
	}
	
	
}
