package Utilities;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateUtility {
public static String getCurrentDate()
{
    Date date=(Date) new java.util.Date();
	SimpleDateFormat sdf=new SimpleDateFormat("mm/dd/yyyy");
	String formateddate=sdf.format(date);
	return formateddate;
}
}
