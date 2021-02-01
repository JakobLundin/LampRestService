package lamp;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LampController {

    @GetMapping("/lamp/{lampid}/get")
    public boolean lampGet(@PathVariable(value="lampid") String lampId) {
    	Lamp lamp = Lamp.map.get(lampId);
    	if (lamp == null) {
    		lamp = new Lamp();
    		Lamp.map.put(lampId, lamp);
    	}
    	lamp.getLog.add();
        return lamp.check();
    }
    
    @GetMapping("/lamp/{lampid}/add")
    public String lampAdd(@PathVariable(value="lampid") String lampId) {
    	Lamp lamp = Lamp.map.get(lampId);
    	if (lamp == null) {
    		lamp = new Lamp();
    		Lamp.map.put(lampId, lamp);
    	}
    	lamp.activationLog.add();
    	lamp.activate();
    	return "Activated";
    }
    
    @GetMapping("/lamp/{lampid}/lastGet")
    public String lampLastGet(@PathVariable(value="lampid") String lampId) {
    	Lamp lamp = Lamp.map.get(lampId);
    	if (lamp == null) {
    		return lampId + " never used";
    	}
    	return lamp.getLog.getLast();
    }
    
    @GetMapping("/lamp/{lampid}/lastActivation")
    public String lampLastActivation(@PathVariable(value="lampid") String lampId) {
    	Lamp lamp = Lamp.map.get(lampId);
    	if (lamp == null) {
    		return lampId + " never used";
    	}
    	return lamp.activationLog.getLast();
    }
    
    @GetMapping("/lamp/{lampid}/activationDump")
    public String lampActivationLogDump(@PathVariable(value="lampid") String lampId) {
    	Lamp lamp = Lamp.map.get(lampId);
    	if (lamp == null) {
    		return lampId + " never used";
    	}
    	return lamp.activationLog.toString();
    }
    
    @GetMapping("/lamp/{lampid}/getDump")
    public String lampGetLogDump(@PathVariable(value="lampid") String lampId) {
    	Lamp lamp = Lamp.map.get(lampId);
    	if (lamp == null) {
    		return lampId + " never used";
    	}
    	return lamp.getLog.toString();
    }
    
    
}
