package lamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AccessLog {
	private List<String> list;
	
	public AccessLog() {
		list = new ArrayList<>();
	}
	
	public synchronized void add() {
		if (list.size() >= 1000 ) {
			list.remove(0);			
		}
		list.add(LocalDateTime.now().plusHours(1).toString());
	}
	
	public String getLast() {
		if (list.isEmpty()) return "null";
		return list.get(list.size()-1);
	}
	
	public String toString() {
		/*StringBuilder sb = new StringBuilder();
		for (String str : list) {
			sb.append(str);
			sb.append("\n");
		}*/
		return list.toString();
	}
}
