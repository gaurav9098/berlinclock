package com.ubs.opsit.interviews;

import java.util.ArrayList;
import java.util.List;

public class BerlinClock implements TimeConverter{

	@Override
	public String convertTime(String aTime) {
		String berlinClockRepresentation ="";
		List<Integer> intList = new ArrayList<Integer>();
		for (String part : aTime.split(":")) {
			intList.add(Integer.parseInt(part));
		}
		berlinClockRepresentation +=getSeconds(intList.get(2));
		berlinClockRepresentation+='\n';
		berlinClockRepresentation =getFirstRowHour(intList.get(0));
		berlinClockRepresentation+='\n';
		berlinClockRepresentation +=getSecondRowHour(intList.get(0));
		berlinClockRepresentation+='\n';
		berlinClockRepresentation +=getThirdRowMin(intList.get(1));
		berlinClockRepresentation+='\n';
		berlinClockRepresentation +=getFourthRowMin(intList.get(1));
		
	
		
		
		return berlinClockRepresentation;
	}
	
	
	protected String getSeconds(int number) {
        if (number % 2 == 0) return "Y";
        else return "O";
    }
 
    protected String getFirstRowHour(int number) {
        return getOnOff(4, getTopNumberOfOnSigns(number));
    }
 
    protected String getSecondRowHour(int number) {
        return getOnOff(4, number % 5);
    }
 
    protected String getThirdRowMin(int number) {
        return getOnOff(11, getTopNumberOfOnSigns(number), "Y").replaceAll("YYY", "YYR");
    }
 
    protected String getFourthRowMin(int number) {
        return getOnOff(4, number % 5, "Y");
    }
 
    private String getOnOff(int lamps, int onSigns) {
        return getOnOff(lamps, onSigns, "R");
    }
    private String getOnOff(int lamps, int onSigns, String onSign) {
        String out = "";
        for (int i = 0; i < onSigns; i++) {
            out += onSign;
        }
        for (int i = 0; i < (lamps - onSigns); i++) {
            out += "O";
        }
        return out;
    }
 
    private int getTopNumberOfOnSigns(int number) {
        return (number - (number % 5)) / 5;
    }
}
