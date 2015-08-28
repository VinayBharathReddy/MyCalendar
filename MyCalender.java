import java.text.*;
import java.util.*;
class MyCalendar {
	private String name;
	ArrayList<Appointment> slots = new ArrayList<Appointment>();
	ArrayList<String> slotDur = new ArrayList<String>();
	MyCalendar(String name) {
		this.name = name;
	}

	public boolean createAppointmentSlot(Appointment slot) throws Exception {
		Date dateObj = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date slt = dateformat.parse(slot.getDate());
		Date syt = dateformat.parse(slot.getDate());
		boolean flag = false;
		if (slots.size() == 0) {
			slots.add(slot);
			int m = slt.getMinutes() + slot.getDuration();
			// slt.setMinutes(m);
			if(m >= 60) {
				slt.setHours(slt.getHours()+1);
				slt.setMinutes(m - 60);
			}
			else {
				slt.setMinutes(m);
			}
			// String sht = slt.toString();
			String sht = dateformat.format(slt);
			Date dyt = dateformat.parse(sht);
			slotDur.add(sht);
			// System.out.println(sht);
			return true;
		} else {
			int m = slt.getMinutes() + slot.getDuration();
			if(m >= 60) {
				slt.setHours(slt.getHours()+1);
				slt.setMinutes(m - 60);
			}
			else {
				slt.setMinutes(m);
			}
			String sht = dateformat.format(slt);

			for (int i = 0; i < slots.size(); i++) {
				Date dt = dateformat.parse(slots.get(i).getDate());
				Date dyt = dateformat.parse(slotDur.get(i));

				if(dt.before(slt) && dyt.after(syt)) {

					flag = true;
				}
			}
			if(flag == false) {
				slots.add(slot);
				slotDur.add(sht);
				return true;		
			}
		}
		return false;
	}

	public boolean bookAppointment(String name, String dt, int dur, String plc) {
		for(int i = 0; i < slots.size(); i++){
			if(slots.get(i).getDate().equals(dt)) {
				return true;
			}
		}
		return false;

	}

	public boolean cancelAppointment(String t) {
		for(int i = 0; i < slots.size(); i++){
			if(slots.get(i).getDate().equals(t)) {
				return true;
			}
		}
		return false;
	}
}