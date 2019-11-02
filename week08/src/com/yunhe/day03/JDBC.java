package com.yunhe.day03;

public class JDBC {
private String DRIVER;
private String URL;
private String USER;
private String PASSWORD;
public String getDRIVER() {
	return DRIVER;
}
public void setDRIVER(String dRIVER) {
	DRIVER = dRIVER;
}
public String getURL() {
	return URL;
}
public void setURL(String uRL) {
	URL = uRL;
}
public String getUSER() {
	return USER;
}
public void setUSER(String uSER) {
	USER = uSER;
}
public String getPASSWORD() {
	return PASSWORD;
}
public void setPASSWORD(String pASSWORD) {
	PASSWORD = pASSWORD;
}
@Override
public String toString() {
	return "JDBC [DRIVER=" + DRIVER + ", URL=" + URL + ", USER=" + USER + ", PASSWORD=" + PASSWORD + "]";
}


}
