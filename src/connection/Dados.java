/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

/**
 *
 * @author Maximiliano Meyer
 */
public class Dados {

    private int Year;
    private int Month;
    private int DayofMonth;
    private String DayofWeek;
    private int DepTime;
    private int CRSDepTime;
    private int ArrTime;
    private int CRSArrTime;
    private String UniqueCarrier;
    private int FlightNum;
    private String TailNum;
    private int ActualElapsedTime;
    private int CRSElapsedTime;
    private int AirTime;
    private int ArrDelay;
    private int DepDelay;
    private String Origin;
    private String Dest;
    private int Distance;
    private int TaxiIn;
    private int TaxiOut;
    private int Cancelled;
    private String CancellationCode;
    private int Diverted;
    private String CarrierDelay;
    private String WeatherDelay;
    private String NASDelay;
    private String SecurityDelay;
    private String LateAircraftDelay;
    private String Aeroporto;
    private String Cidade;
    private String Estado;
    private String Aeros;

    public int getYear() {
        return Year;
    }

    public String getAeroporto() {
        return Aeroporto;
    }

    public void setAeroporto(String Aeroporto) {
        this.Aeroporto = Aeroporto;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getAeros() {
        return Aeros;
    }

    public void setAeros(String Aeros) {
        this.Aeros = Aeros;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public int getMonth() {
        return Month;
    }

    public void setMonth(int Month) {
        this.Month = Month;
    }

    public int getDayofMonth() {
        return DayofMonth;
    }

    public void setDayofMonth(int DayofMonth) {
        this.DayofMonth = DayofMonth;
    }

    public String getDayofWeek() {
        return DayofWeek;
    }

    public void setDayofWeek(String DayofWeek) {
        this.DayofWeek = DayofWeek;
    }

    public int getDepTime() {
        return DepTime;
    }

    public void setDepTime(int DepTime) {
        this.DepTime = DepTime;
    }

    public int getCRSDepTime() {
        return CRSDepTime;
    }

    public void setCRSDepTime(int CRSDepTime) {
        this.CRSDepTime = CRSDepTime;
    }

    public int getArrTime() {
        return ArrTime;
    }

    public void setArrTime(int ArrTime) {
        this.ArrTime = ArrTime;
    }

    public int getCRSArrTime() {
        return CRSArrTime;
    }

    public void setCRSArrTime(int CRSArrTime) {
        this.CRSArrTime = CRSArrTime;
    }

    public String getUniqueCarrier() {
        return UniqueCarrier;
    }

    public void setUniqueCarrier(String UniqueCarrier) {
        this.UniqueCarrier = UniqueCarrier;
    }

    public int getFlightNum() {
        return FlightNum;
    }

    public void setFlightNum(int FlightNum) {
        this.FlightNum = FlightNum;
    }

    public String getTailNum() {
        return TailNum;
    }

    public void setTailNum(String TailNum) {
        this.TailNum = TailNum;
    }

    public int getActualElapsedTime() {
        return ActualElapsedTime;
    }

    public void setActualElapsedTime(int ActualElapsedTime) {
        this.ActualElapsedTime = ActualElapsedTime;
    }

    public int getCRSElapsedTime() {
        return CRSElapsedTime;
    }

    public void setCRSElapsedTime(int CRSElapsedTime) {
        this.CRSElapsedTime = CRSElapsedTime;
    }

    public int getAirTime() {
        return AirTime;
    }

    public void setAirTime(int AirTime) {
        this.AirTime = AirTime;
    }

    public int getArrDelay() {
        return ArrDelay;
    }

    public void setArrDelay(int ArrDelay) {
        this.ArrDelay = ArrDelay;
    }

    public int getDepDelay() {
        return DepDelay;
    }

    public void setDepDelay(int DepDelay) {
        this.DepDelay = DepDelay;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String Origin) {
        this.Origin = Origin;
    }

    public String getDest() {
        return Dest;
    }

    public void setDest(String Dest) {
        this.Dest = Dest;
    }

    public int getDistance() {
        return Distance;
    }

    public void setDistance(int Distance) {
        this.Distance = Distance;
    }

    public int getTaxiIn() {
        return TaxiIn;
    }

    public void setTaxiIn(int TaxiIn) {
        this.TaxiIn = TaxiIn;
    }

    public int getTaxiOut() {
        return TaxiOut;
    }

    public void setTaxiOut(int TaxiOut) {
        this.TaxiOut = TaxiOut;
    }

    public int getCancelled() {
        return Cancelled;
    }

    public void setCancelled(int Cancelled) {
        this.Cancelled = Cancelled;
    }

    public String getCancellationCode() {
        return CancellationCode;
    }

    public void setCancellationCode(String CancellationCode) {
        this.CancellationCode = CancellationCode;
    }

    public int getDiverted() {
        return Diverted;
    }

    public void setDiverted(int Diverted) {
        this.Diverted = Diverted;
    }

    public String getCarrierDelay() {
        return CarrierDelay;
    }

    public void setCarrierDelay(String CarrierDelay) {
        this.CarrierDelay = CarrierDelay;
    }

    public String getWeatherDelay() {
        return WeatherDelay;
    }

    public void setWeatherDelay(String WeatherDelay) {
        this.WeatherDelay = WeatherDelay;
    }

    public String getNASDelay() {
        return NASDelay;
    }

    public void setNASDelay(String NASDelay) {
        this.NASDelay = NASDelay;
    }

    public String getSecurityDelay() {
        return SecurityDelay;
    }

    public void setSecurityDelay(String SecurityDelay) {
        this.SecurityDelay = SecurityDelay;
    }

    public String getLateAircraftDelay() {
        return LateAircraftDelay;
    }

    public void setLateAircraftDelay(String LateAircraftDelay) {
        this.LateAircraftDelay = LateAircraftDelay;
    }

}
