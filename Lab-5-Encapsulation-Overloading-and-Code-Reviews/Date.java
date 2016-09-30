/*
	made by Ricafelle Dorothy Z. Fortes
*/
import java.lang.IllegalArgumentException;

public class Date{

	private int year;
	private int month;
	private int day;

	Date() {		
		year = 1000;
		month = 1;
		day = 1;
	}

	Date(int year, int month, int day){
		setYear(year);
		setMonth(month);
		setDay(day);
	}

	int getYear(){
		return year;
	}

	int getMonth(){
		return month;
	}

	int getDay(){
		return day;
	}

	public void setYear(int yearInput){
		// year should be between 1000 and 9999
		if((yearInput >= 1000) && (yearInput <= 9999)){
			year = yearInput;
		} else {
			throw new IllegalArgumentException("Year should be between 1000 and 9999.");
		}
	}

	public void setMonth(int monthInput){
		// month should be 1 to 12 only
		if((monthInput >= 1) && (monthInput <= 12)){
			month = monthInput;
		} else {
			throw new IllegalArgumentException("You entered an invalid month.");
		}
	}

	public void setDay(int dayInput){
		// before setting the day, month should have a value
		if(month != 0){
			if((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)){
				// january, 1-31
				if((dayInput >= 1) && (dayInput <= 31)){
					day = dayInput;
				} else {
					throw new IllegalArgumentException("Invalid day for the month given.");
				}
			} else if(month == 2){
				// february, 1-28
				if((dayInput >= 1) && (dayInput <= 28)){
					day = dayInput;
				} else {
					throw new IllegalArgumentException("Invalid day for the month of February!");
				}
			} else if((month == 4) || (month == 6) || (month == 9) || (month == 11)){
				// april, 1-30
				if((dayInput >= 1) && (dayInput <= 30)){
					day = dayInput;
				} else {
					throw new IllegalArgumentException("Invalid day for the month given");
				}
			}
		} else {
			throw new IllegalArgumentException("Set the value for month first.");
		}
	}

	public String toString(){
		// DD/MM/YYYY
		return String.format("%d/%d/%d", day, month, year);
	}

	public void setDate(int year, int month, int day){
		setYear(year);
		setMonth(month);
		setDay(day);
	}

}
