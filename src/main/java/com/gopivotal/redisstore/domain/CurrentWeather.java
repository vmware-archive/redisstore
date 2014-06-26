package com.gopivotal.redisstore.domain;

import java.io.Serializable;


public class CurrentWeather implements Serializable {

private static final long serialVersionUID = 3467609329260240656L;
	
 protected String location;
 protected String stationId;
 protected float latitude;
 protected float longitude;
 protected String observationTime;
 protected String weather;
 protected String temperatureString;
 protected float tempF;
 protected byte relativeHumidity;
 protected String windString;
 protected String windDir;
 protected short windDegrees;
 protected float windMph;
 protected byte windKt;
 protected String pressureString;
 protected float pressureMb;
 protected float pressureIn;
 protected String dewpointString;
 protected float dewpointF;
 protected float dewpointC;
 protected float visibilityMi;
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getStationId() {
	return stationId;
}
public void setStationId(String stationId) {
	this.stationId = stationId;
}
public float getLatitude() {
	return latitude;
}
public void setLatitude(float latitude) {
	this.latitude = latitude;
}
public float getLongitude() {
	return longitude;
}
public void setLongitude(float longitude) {
	this.longitude = longitude;
}
public String getObservationTime() {
	return observationTime;
}
public void setObservationTime(String observationTime) {
	this.observationTime = observationTime;
}
public String getWeather() {
	return weather;
}
public void setWeather(String weather) {
	this.weather = weather;
}
public String getTemperatureString() {
	return temperatureString;
}
public void setTemperatureString(String temperatureString) {
	this.temperatureString = temperatureString;
}
public float getTempF() {
	return tempF;
}
public void setTempF(float tempF) {
	this.tempF = tempF;
}
public byte getRelativeHumidity() {
	return relativeHumidity;
}
public void setRelativeHumidity(byte relativeHumidity) {
	this.relativeHumidity = relativeHumidity;
}
public String getWindString() {
	return windString;
}
public void setWindString(String windString) {
	this.windString = windString;
}
public String getWindDir() {
	return windDir;
}
public void setWindDir(String windDir) {
	this.windDir = windDir;
}
public short getWindDegrees() {
	return windDegrees;
}
public void setWindDegrees(short windDegrees) {
	this.windDegrees = windDegrees;
}
public float getWindMph() {
	return windMph;
}
public void setWindMph(float windMph) {
	this.windMph = windMph;
}
public byte getWindKt() {
	return windKt;
}
public void setWindKt(byte windKt) {
	this.windKt = windKt;
}
public String getPressureString() {
	return pressureString;
}
public void setPressureString(String pressureString) {
	this.pressureString = pressureString;
}
public float getPressureMb() {
	return pressureMb;
}
public void setPressureMb(float pressureMb) {
	this.pressureMb = pressureMb;
}
public float getPressureIn() {
	return pressureIn;
}
public void setPressureIn(float pressureIn) {
	this.pressureIn = pressureIn;
}
public String getDewpointString() {
	return dewpointString;
}
public void setDewpointString(String dewpointString) {
	this.dewpointString = dewpointString;
}
public float getDewpointF() {
	return dewpointF;
}
public void setDewpointF(float dewpointF) {
	this.dewpointF = dewpointF;
}
public float getDewpointC() {
	return dewpointC;
}
public void setDewpointC(float dewpointC) {
	this.dewpointC = dewpointC;
}
public float getVisibilityMi() {
	return visibilityMi;
}
public void setVisibilityMi(float visibilityMi) {
	this.visibilityMi = visibilityMi;
}
public CurrentWeather() {
	super();
}
@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("CurrentWeather [location=").append(location)
			.append(", stationId=").append(stationId).append(", latitude=")
			.append(latitude).append(", longitude=").append(longitude)
			.append(", observationTime=").append(observationTime)
			.append(", weather=").append(weather)
			.append(", temperatureString=").append(temperatureString)
			.append(", tempF=").append(tempF).append(", relativeHumidity=")
			.append(relativeHumidity).append(", windString=")
			.append(windString).append(", windDir=").append(windDir)
			.append(", windDegrees=").append(windDegrees).append(", windMph=")
			.append(windMph).append(", windKt=").append(windKt)
			.append(", pressureString=").append(pressureString)
			.append(", pressureMb=").append(pressureMb).append(", pressureIn=")
			.append(pressureIn).append(", dewpointString=")
			.append(dewpointString).append(", dewpointF=").append(dewpointF)
			.append(", dewpointC=").append(dewpointC).append(", visibilityMi=")
			.append(visibilityMi).append("]");
	return builder.toString();
}
  
}