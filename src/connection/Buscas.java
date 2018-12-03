/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Maximiliano Meyer
 */
public class Buscas {

    public List<Dados> busca(String ano) {

        Connection con = ConnectionDB.getConnection();                            // Faz a conexão ao BD
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Dados> dados = new ArrayList<>();                                    // Cria um novo array list do tipo Dados

        try {
            stmt = con.prepareStatement("SELECT * FROM `" + ano + "`");           // Usa o ano passado como referência para fazer a busca na tabela correta do banco de dados
            rs = stmt.executeQuery();

            while (rs.next()) {                                                   // Executa a query enquanto tiver valores a seguir

                Dados info = new Dados();

                info.setYear(rs.getInt("Year"));
                info.setMonth(rs.getInt("Month"));
                info.setDayofMonth(rs.getInt("DayofMonth"));
                info.setDayofWeek(rs.getString("DayofWeek"));
                info.setDepTime(rs.getInt("DepTime"));
                info.setCRSDepTime(rs.getInt("CRSDepTime"));
                info.setArrTime(rs.getInt("ArrTime"));
                info.setCRSArrTime(rs.getInt("CRSArrTime"));
                info.setUniqueCarrier(rs.getString("UniqueCarrier"));
                info.setFlightNum(rs.getInt("FlightNum"));
                info.setTailNum(rs.getString("TailNum"));
                info.setActualElapsedTime(rs.getInt("ActualElapsedTime"));
                info.setCRSElapsedTime(rs.getInt("CRSElapsedTime"));
                info.setAirTime(rs.getInt("AirTime"));
                info.setArrDelay(rs.getInt("ArrDelay"));
                info.setDepDelay(rs.getInt("DepDelay"));
                info.setOrigin(rs.getString("Origin"));
                info.setDest(rs.getString("Dest"));
                info.setDistance(rs.getInt("Distance"));
                info.setTaxiIn(rs.getInt("TaxiIn"));
                info.setTaxiOut(rs.getInt("TaxiOut"));
                info.setCancelled(rs.getInt("Cancelled"));
                info.setCancellationCode(rs.getString("CancellationCode"));
                info.setDiverted(rs.getInt("Diverted"));
                info.setCarrierDelay(rs.getString("CarrierDelay"));
                info.setWeatherDelay(rs.getString("WeatherDelay"));
                info.setNASDelay(rs.getString("NASDelay"));
                info.setSecurityDelay(rs.getString("SecurityDelay"));
                info.setLateAircraftDelay(rs.getString("LateAircraftDelay"));

                dados.add(info);                                                   //Coloca no Array as ocorrências certeiras

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum dado localizado para o ano informado");   // Mensagem de erro caso nada seja encontrado ou a conexão não seja bem sucedida
        } finally {                                                                // Processo que será sempre executado. Com sucesso ou erro das partes anteriores. Chama
            ConnectionDB.closeConnection(con, stmt, rs);                           // o método que fechará as conexões abertas
        }

        return dados;
    }

    public List<Dados> buscaMes(String mesX, String ano) {
        Connection con = ConnectionDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Dados> dados = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM `" + ano + "` WHERE Month = " + mesX); // Além do ano utiliza a referência de mês através de um where para fazer uma busca composta
            rs = stmt.executeQuery();

            while (rs.next()) {
                Dados info = new Dados();

                info.setYear(rs.getInt("Year"));
                info.setMonth(rs.getInt("Month"));
                info.setDayofMonth(rs.getInt("DayofMonth"));
                info.setDayofWeek(rs.getString("DayofWeek"));
                info.setDepTime(rs.getInt("DepTime"));
                info.setCRSDepTime(rs.getInt("CRSDepTime"));
                info.setArrTime(rs.getInt("ArrTime"));
                info.setCRSArrTime(rs.getInt("CRSArrTime"));
                info.setUniqueCarrier(rs.getString("UniqueCarrier"));
                info.setFlightNum(rs.getInt("FlightNum"));
                info.setTailNum(rs.getString("TailNum"));
                info.setActualElapsedTime(rs.getInt("ActualElapsedTime"));
                info.setCRSElapsedTime(rs.getInt("CRSElapsedTime"));
                info.setAirTime(rs.getInt("AirTime"));
                info.setArrDelay(rs.getInt("ArrDelay"));
                info.setDepDelay(rs.getInt("DepDelay"));
                info.setOrigin(rs.getString("Origin"));
                info.setDest(rs.getString("Dest"));
                info.setDistance(rs.getInt("Distance"));
                info.setTaxiIn(rs.getInt("TaxiIn"));
                info.setTaxiOut(rs.getInt("TaxiOut"));
                info.setCancelled(rs.getInt("Cancelled"));
                info.setCancellationCode(rs.getString("CancellationCode"));
                info.setDiverted(rs.getInt("Diverted"));
                info.setCarrierDelay(rs.getString("CarrierDelay"));
                info.setWeatherDelay(rs.getString("WeatherDelay"));
                info.setNASDelay(rs.getString("NASDelay"));
                info.setSecurityDelay(rs.getString("SecurityDelay"));
                info.setLateAircraftDelay(rs.getString("LateAircraftDelay"));

                dados.add(info);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum dado localizado para o mês e ano informado");
        } finally {
            ConnectionDB.closeConnection(con, stmt, rs);
        }
        return dados;
    }

    public List<Dados> buscaVoo(String Voo, boolean check1, boolean check2, String ano) {

        Connection con = ConnectionDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        int cancel = 1;                                                           // Criei estas variáveis e atribui valor 1, pois no Banco de dados, 1 é utilizado para 
        int redir = 1;                                                            // representar se o voo está cancelado ou redirecionado

        List<Dados> dados = new ArrayList<>();

        if ("".equals(Voo)) {                                                     // Caso o campo voo esteja em branco ele vai entrar neste if que busca somente pelos critérios de canc. redir, ou ambos
            if (check1 && !check2) {                                              // If para o caso de usuário querer "Cancelados"
                try {
                    stmt = con.prepareStatement("SELECT * FROM `" + ano + "` WHERE Cancelled =" + cancel + " AND Diverted !=" + redir);
                    rs = stmt.executeQuery();

                    while (rs.next()) {

                        Dados info = new Dados();

                        info.setYear(rs.getInt("Year"));
                        info.setMonth(rs.getInt("Month"));
                        info.setDayofMonth(rs.getInt("DayofMonth"));
                        info.setDayofWeek(rs.getString("DayofWeek"));
                        info.setDepTime(rs.getInt("DepTime"));
                        info.setCRSDepTime(rs.getInt("CRSDepTime"));
                        info.setArrTime(rs.getInt("ArrTime"));
                        info.setCRSArrTime(rs.getInt("CRSArrTime"));
                        info.setUniqueCarrier(rs.getString("UniqueCarrier"));
                        info.setFlightNum(rs.getInt("FlightNum"));
                        info.setTailNum(rs.getString("TailNum"));
                        info.setActualElapsedTime(rs.getInt("ActualElapsedTime"));
                        info.setCRSElapsedTime(rs.getInt("CRSElapsedTime"));
                        info.setAirTime(rs.getInt("AirTime"));
                        info.setArrDelay(rs.getInt("ArrDelay"));
                        info.setDepDelay(rs.getInt("DepDelay"));
                        info.setOrigin(rs.getString("Origin"));
                        info.setDest(rs.getString("Dest"));
                        info.setDistance(rs.getInt("Distance"));
                        info.setTaxiIn(rs.getInt("TaxiIn"));
                        info.setTaxiOut(rs.getInt("TaxiOut"));
                        info.setCancelled(rs.getInt("Cancelled"));
                        info.setCancellationCode(rs.getString("CancellationCode"));
                        info.setDiverted(rs.getInt("Diverted"));
                        info.setCarrierDelay(rs.getString("CarrierDelay"));
                        info.setWeatherDelay(rs.getString("WeatherDelay"));
                        info.setNASDelay(rs.getString("NASDelay"));
                        info.setSecurityDelay(rs.getString("SecurityDelay"));
                        info.setLateAircraftDelay(rs.getString("LateAircraftDelay"));

                        dados.add(info);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Nenhum voo encontrado");
                } finally {
                    ConnectionDB.closeConnection(con, stmt, rs);
                }
                return dados;
            } else if (!check1 && check2) {                                       // If para oc aso de busca pelos Redirecionados

                try {
                    stmt = con.prepareStatement("SELECT * FROM `" + ano + "` WHERE Cancelled !=" + cancel + " AND Diverted =" + redir);
                    rs = stmt.executeQuery();

                    while (rs.next()) {

                        Dados info = new Dados();

                        info.setYear(rs.getInt("Year"));
                        info.setMonth(rs.getInt("Month"));
                        info.setDayofMonth(rs.getInt("DayofMonth"));
                        info.setDayofWeek(rs.getString("DayofWeek"));
                        info.setDepTime(rs.getInt("DepTime"));
                        info.setCRSDepTime(rs.getInt("CRSDepTime"));
                        info.setArrTime(rs.getInt("ArrTime"));
                        info.setCRSArrTime(rs.getInt("CRSArrTime"));
                        info.setUniqueCarrier(rs.getString("UniqueCarrier"));
                        info.setFlightNum(rs.getInt("FlightNum"));
                        info.setTailNum(rs.getString("TailNum"));
                        info.setActualElapsedTime(rs.getInt("ActualElapsedTime"));
                        info.setCRSElapsedTime(rs.getInt("CRSElapsedTime"));
                        info.setAirTime(rs.getInt("AirTime"));
                        info.setArrDelay(rs.getInt("ArrDelay"));
                        info.setDepDelay(rs.getInt("DepDelay"));
                        info.setOrigin(rs.getString("Origin"));
                        info.setDest(rs.getString("Dest"));
                        info.setDistance(rs.getInt("Distance"));
                        info.setTaxiIn(rs.getInt("TaxiIn"));
                        info.setTaxiOut(rs.getInt("TaxiOut"));
                        info.setCancelled(rs.getInt("Cancelled"));
                        info.setCancellationCode(rs.getString("CancellationCode"));
                        info.setDiverted(rs.getInt("Diverted"));
                        info.setCarrierDelay(rs.getString("CarrierDelay"));
                        info.setWeatherDelay(rs.getString("WeatherDelay"));
                        info.setNASDelay(rs.getString("NASDelay"));
                        info.setSecurityDelay(rs.getString("SecurityDelay"));
                        info.setLateAircraftDelay(rs.getString("LateAircraftDelay"));

                        dados.add(info);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Nenhum voo encontrado");
                } finally {
                    ConnectionDB.closeConnection(con, stmt, rs);
                }
                return dados;
            }
            if (check1 && check2) {                                                // If para a busca de voos cancelados e redirecionados

                try {
                    stmt = con.prepareStatement("SELECT * FROM `" + ano + "` WHERE Cancelled !=" + cancel + " AND Diverted =" + redir);
                    rs = stmt.executeQuery();
                    // Como aeronaves que foram redirecionadas não foram canceladas ou vice-versa, a mensagem abaixo 
                    // será exibida caso o usuário tente uma busca deste tipo
                    JOptionPane.showMessageDialog(null, "Aeronaves que tiveram o voo cancelado não podem ser redirecionadas" + System.lineSeparator() + "Corrija os seus filtros de busca.", "Erro de filtro", JOptionPane.WARNING_MESSAGE);
                } catch (SQLException ex) {

                } finally {
                    ConnectionDB.closeConnection(con, stmt, rs);
                }
                return dados;
            }
        } else if (check1 && !check2) {                                           // Else que será utilizado caso o usuário faça uma busca especificando o número do voo
            try {                                                                 // As 4 buscas anteriores se repetem abaixo
                stmt = con.prepareStatement("SELECT * FROM `" + ano + "` WHERE FlightNum = " + Voo + " AND Cancelled =" + cancel + " AND Diverted !=" + redir);
                rs = stmt.executeQuery();

                while (rs.next()) {

                    Dados info = new Dados();

                    info.setYear(rs.getInt("Year"));
                    info.setMonth(rs.getInt("Month"));
                    info.setDayofMonth(rs.getInt("DayofMonth"));
                    info.setDayofWeek(rs.getString("DayofWeek"));
                    info.setDepTime(rs.getInt("DepTime"));
                    info.setCRSDepTime(rs.getInt("CRSDepTime"));
                    info.setArrTime(rs.getInt("ArrTime"));
                    info.setCRSArrTime(rs.getInt("CRSArrTime"));
                    info.setUniqueCarrier(rs.getString("UniqueCarrier"));
                    info.setFlightNum(rs.getInt("FlightNum"));
                    info.setTailNum(rs.getString("TailNum"));
                    info.setActualElapsedTime(rs.getInt("ActualElapsedTime"));
                    info.setCRSElapsedTime(rs.getInt("CRSElapsedTime"));
                    info.setAirTime(rs.getInt("AirTime"));
                    info.setArrDelay(rs.getInt("ArrDelay"));
                    info.setDepDelay(rs.getInt("DepDelay"));
                    info.setOrigin(rs.getString("Origin"));
                    info.setDest(rs.getString("Dest"));
                    info.setDistance(rs.getInt("Distance"));
                    info.setTaxiIn(rs.getInt("TaxiIn"));
                    info.setTaxiOut(rs.getInt("TaxiOut"));
                    info.setCancelled(rs.getInt("Cancelled"));
                    info.setCancellationCode(rs.getString("CancellationCode"));
                    info.setDiverted(rs.getInt("Diverted"));
                    info.setCarrierDelay(rs.getString("CarrierDelay"));
                    info.setWeatherDelay(rs.getString("WeatherDelay"));
                    info.setNASDelay(rs.getString("NASDelay"));
                    info.setSecurityDelay(rs.getString("SecurityDelay"));
                    info.setLateAircraftDelay(rs.getString("LateAircraftDelay"));

                    dados.add(info);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Nenhum voo encontrado");
            } finally {
                ConnectionDB.closeConnection(con, stmt, rs);
            }
            return dados;
        } else if (!check1 && check2) {

            try {
                stmt = con.prepareStatement("SELECT * FROM `" + ano + "` WHERE FlightNum = " + Voo + " AND Cancelled !=" + cancel + " AND Diverted =" + redir);
                rs = stmt.executeQuery();

                while (rs.next()) {

                    Dados info = new Dados();

                    info.setYear(rs.getInt("Year"));
                    info.setMonth(rs.getInt("Month"));
                    info.setDayofMonth(rs.getInt("DayofMonth"));
                    info.setDayofWeek(rs.getString("DayofWeek"));
                    info.setDepTime(rs.getInt("DepTime"));
                    info.setCRSDepTime(rs.getInt("CRSDepTime"));
                    info.setArrTime(rs.getInt("ArrTime"));
                    info.setCRSArrTime(rs.getInt("CRSArrTime"));
                    info.setUniqueCarrier(rs.getString("UniqueCarrier"));
                    info.setFlightNum(rs.getInt("FlightNum"));
                    info.setTailNum(rs.getString("TailNum"));
                    info.setActualElapsedTime(rs.getInt("ActualElapsedTime"));
                    info.setCRSElapsedTime(rs.getInt("CRSElapsedTime"));
                    info.setAirTime(rs.getInt("AirTime"));
                    info.setArrDelay(rs.getInt("ArrDelay"));
                    info.setDepDelay(rs.getInt("DepDelay"));
                    info.setOrigin(rs.getString("Origin"));
                    info.setDest(rs.getString("Dest"));
                    info.setDistance(rs.getInt("Distance"));
                    info.setTaxiIn(rs.getInt("TaxiIn"));
                    info.setTaxiOut(rs.getInt("TaxiOut"));
                    info.setCancelled(rs.getInt("Cancelled"));
                    info.setCancellationCode(rs.getString("CancellationCode"));
                    info.setDiverted(rs.getInt("Diverted"));
                    info.setCarrierDelay(rs.getString("CarrierDelay"));
                    info.setWeatherDelay(rs.getString("WeatherDelay"));
                    info.setNASDelay(rs.getString("NASDelay"));
                    info.setSecurityDelay(rs.getString("SecurityDelay"));
                    info.setLateAircraftDelay(rs.getString("LateAircraftDelay"));

                    dados.add(info);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Nenhum voo encontrado");
            } finally {
                ConnectionDB.closeConnection(con, stmt, rs);
            }
            return dados;
        }
        if (check1 && check2) {

            try {
                stmt = con.prepareStatement("SELECT * FROM `" + ano + "` WHERE FlightNum = " + Voo + " AND Cancelled !=" + cancel + " AND Diverted =" + redir);
                rs = stmt.executeQuery();

                JOptionPane.showMessageDialog(null, "Aeronaves que tiveram o voo cancelado não podem ser redirecionadas" + System.lineSeparator() + "Corrija os seus filtros de busca.", "Erro de filtro", JOptionPane.WARNING_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Nenhum voo encontrado");
            } finally {
                ConnectionDB.closeConnection(con, stmt, rs);
            }
            return dados;
        } else {                                                                     // Por fim, a busca apenas por número de voo, sem especificações de redir. ou cancel.
            try {
                stmt = con.prepareStatement("SELECT * FROM `" + ano + "` WHERE FlightNum = " + Voo);
                rs = stmt.executeQuery();

                while (rs.next()) {

                    Dados info = new Dados();

                    info.setYear(rs.getInt("Year"));
                    info.setMonth(rs.getInt("Month"));
                    info.setDayofMonth(rs.getInt("DayofMonth"));
                    info.setDayofWeek(rs.getString("DayofWeek"));
                    info.setDepTime(rs.getInt("DepTime"));
                    info.setCRSDepTime(rs.getInt("CRSDepTime"));
                    info.setArrTime(rs.getInt("ArrTime"));
                    info.setCRSArrTime(rs.getInt("CRSArrTime"));
                    info.setUniqueCarrier(rs.getString("UniqueCarrier"));
                    info.setFlightNum(rs.getInt("FlightNum"));
                    info.setTailNum(rs.getString("TailNum"));
                    info.setActualElapsedTime(rs.getInt("ActualElapsedTime"));
                    info.setCRSElapsedTime(rs.getInt("CRSElapsedTime"));
                    info.setAirTime(rs.getInt("AirTime"));
                    info.setArrDelay(rs.getInt("ArrDelay"));
                    info.setDepDelay(rs.getInt("DepDelay"));
                    info.setOrigin(rs.getString("Origin"));
                    info.setDest(rs.getString("Dest"));
                    info.setDistance(rs.getInt("Distance"));
                    info.setTaxiIn(rs.getInt("TaxiIn"));
                    info.setTaxiOut(rs.getInt("TaxiOut"));
                    info.setCancelled(rs.getInt("Cancelled"));
                    info.setCancellationCode(rs.getString("CancellationCode"));
                    info.setDiverted(rs.getInt("Diverted"));
                    info.setCarrierDelay(rs.getString("CarrierDelay"));
                    info.setWeatherDelay(rs.getString("WeatherDelay"));
                    info.setNASDelay(rs.getString("NASDelay"));
                    info.setSecurityDelay(rs.getString("SecurityDelay"));
                    info.setLateAircraftDelay(rs.getString("LateAircraftDelay"));

                    dados.add(info);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Nenhum voo encontrado");
            } finally {
                ConnectionDB.closeConnection(con, stmt, rs);
            }
            return dados;
        }
    }

    public List<Dados> buscaDatas(String dataX, String dataY, String ano) {

        Connection con = ConnectionDB.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Dados> dados = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM `" + ano + "` WHERE DayofMonth BETWEEN " + dataX + " AND " + dataY);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Dados info = new Dados();

                info.setYear(rs.getInt("Year"));
                info.setMonth(rs.getInt("Month"));
                info.setDayofMonth(rs.getInt("DayofMonth"));
                info.setDayofWeek(rs.getString("DayofWeek"));
                info.setDepTime(rs.getInt("DepTime"));
                info.setCRSDepTime(rs.getInt("CRSDepTime"));
                info.setArrTime(rs.getInt("ArrTime"));
                info.setCRSArrTime(rs.getInt("CRSArrTime"));
                info.setUniqueCarrier(rs.getString("UniqueCarrier"));
                info.setFlightNum(rs.getInt("FlightNum"));
                info.setTailNum(rs.getString("TailNum"));
                info.setActualElapsedTime(rs.getInt("ActualElapsedTime"));
                info.setCRSElapsedTime(rs.getInt("CRSElapsedTime"));
                info.setAirTime(rs.getInt("AirTime"));
                info.setArrDelay(rs.getInt("ArrDelay"));
                info.setDepDelay(rs.getInt("DepDelay"));
                info.setOrigin(rs.getString("Origin"));
                info.setDest(rs.getString("Dest"));
                info.setDistance(rs.getInt("Distance"));
                info.setTaxiIn(rs.getInt("TaxiIn"));
                info.setTaxiOut(rs.getInt("TaxiOut"));
                info.setCancelled(rs.getInt("Cancelled"));
                info.setCancellationCode(rs.getString("CancellationCode"));
                info.setDiverted(rs.getInt("Diverted"));
                info.setCarrierDelay(rs.getString("CarrierDelay"));
                info.setWeatherDelay(rs.getString("WeatherDelay"));
                info.setNASDelay(rs.getString("NASDelay"));
                info.setSecurityDelay(rs.getString("SecurityDelay"));
                info.setLateAircraftDelay(rs.getString("LateAircraftDelay"));

                dados.add(info);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum voo encontrado");
        } finally {
            ConnectionDB.closeConnection(con, stmt, rs);
        }
        return dados;
    }

    public List<Dados> buscaHora(String hora1, String hora2, String ano) {

        Connection con = ConnectionDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Dados> dados = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM `" + ano + "` WHERE DepTime BETWEEN " + hora1 + " AND " + hora2);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Dados info = new Dados();

                info.setYear(rs.getInt("Year"));
                info.setMonth(rs.getInt("Month"));
                info.setDayofMonth(rs.getInt("DayofMonth"));
                info.setDayofWeek(rs.getString("DayofWeek"));
                info.setDepTime(rs.getInt("DepTime"));
                info.setCRSDepTime(rs.getInt("CRSDepTime"));
                info.setArrTime(rs.getInt("ArrTime"));
                info.setCRSArrTime(rs.getInt("CRSArrTime"));
                info.setUniqueCarrier(rs.getString("UniqueCarrier"));
                info.setFlightNum(rs.getInt("FlightNum"));
                info.setTailNum(rs.getString("TailNum"));
                info.setActualElapsedTime(rs.getInt("ActualElapsedTime"));
                info.setCRSElapsedTime(rs.getInt("CRSElapsedTime"));
                info.setAirTime(rs.getInt("AirTime"));
                info.setArrDelay(rs.getInt("ArrDelay"));
                info.setDepDelay(rs.getInt("DepDelay"));
                info.setOrigin(rs.getString("Origin"));
                info.setDest(rs.getString("Dest"));
                info.setDistance(rs.getInt("Distance"));
                info.setTaxiIn(rs.getInt("TaxiIn"));
                info.setTaxiOut(rs.getInt("TaxiOut"));
                info.setCancelled(rs.getInt("Cancelled"));
                info.setCancellationCode(rs.getString("CancellationCode"));
                info.setDiverted(rs.getInt("Diverted"));
                info.setCarrierDelay(rs.getString("CarrierDelay"));
                info.setWeatherDelay(rs.getString("WeatherDelay"));
                info.setNASDelay(rs.getString("NASDelay"));
                info.setSecurityDelay(rs.getString("SecurityDelay"));
                info.setLateAircraftDelay(rs.getString("LateAircraftDelay"));

                dados.add(info);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum voo encontrado");
        } finally {
            ConnectionDB.closeConnection(con, stmt, rs);
        }
        return dados;
    }

    public List<Dados> Recorrentes(String ano) {

        Connection con = ConnectionDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Dados> dados = new ArrayList<>();
        try {

            stmt = con.prepareStatement("select * from `" + ano + "` group by FlightNum order by count(*) desc limit 5"); // Utilizei uma cláusula que limita nos 5 primeiros voos daqueles que mais tiveram ocorrências
            rs = stmt.executeQuery();

            while (rs.next()) {

                Dados info = new Dados();

                info.setUniqueCarrier(rs.getString("UniqueCarrier"));
                info.setFlightNum(rs.getInt("FlightNum"));
                info.setTailNum(rs.getString("TailNum"));

                dados.add(info);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum voo encontrado");
        } finally {
            ConnectionDB.closeConnection(con, stmt, rs);
        }
        return dados;
    }

    public List<Dados> Distancia(String ano) {

        Connection con = ConnectionDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        int dist1 = 0;                                                            // Como este resultado será exibido em um JDialog, criei variáveis que possa chamar 
        int dist2 = 0;
        int dist3 = 0;
        int dist4 = 0;
        int dist5 = 0;
        int dist6 = 0;
        int dist7 = 0;
        int dist8 = 0;
        int dist9 = 0;
        int dist10 = 0;
        int dist11 = 0;
        int dist12 = 0;

        List<Dados> dados = new ArrayList<>();
        try {

            stmt = con.prepareStatement("select * from `" + ano + "` ");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Dados info = new Dados();
                switch (rs.getInt("Month")) {                                     // Utilizei um switch/case que vai somar as distâncias de acordo com os meses em que ocorreram os voos

                    case 1:
                        dist1 = dist1 + rs.getInt("Distance");
                        break;
                    case 2:
                        dist2 = dist2 + rs.getInt("Distance");
                        break;
                    case 3:
                        dist3 = dist3 + rs.getInt("Distance");
                        break;
                    case 4:
                        dist4 = dist4 + rs.getInt("Distance");
                        break;
                    case 5:
                        dist5 = dist5 + rs.getInt("Distance");
                        break;
                    case 6:
                        dist6 = dist6 + rs.getInt("Distance");
                        break;
                    case 7:
                        dist7 = dist7 + rs.getInt("Distance");
                        break;
                    case 8:
                        dist8 = dist8 + rs.getInt("Distance");
                        break;
                    case 9:
                        dist9 = dist9 + rs.getInt("Distance");
                        break;
                    case 10:
                        dist10 = dist10 + rs.getInt("Distance");
                        break;
                    case 11:
                        dist11 = dist11 + rs.getInt("Distance");
                        break;
                    case 12:
                        dist12 = dist12 + rs.getInt("Distance");
                        break;

                }
                dados.add(info);
            }
            JOptionPane.showMessageDialog(null, "A soma combinada das distâncias por mês foi:\n\n" // Por fim um dialog irá printar na tela
                    + "Janeiro: " + dist1 + " milhas\n"
                    + "Fevereiro: " + dist2 + " milhas\n"
                    + "Março: " + dist3 + " milhas\n"
                    + "Abril: " + dist4 + " milhas\n"
                    + "Maio: " + dist5 + " milhas\n"
                    + "Junho: " + dist6 + " milhas\n"
                    + "Julho: " + dist7 + " milhas\n"
                    + "Agosto: " + dist8 + " milhas\n"
                    + "Setembro: " + dist9 + " milhas\n"
                    + "Outuubro: " + dist10 + " milhas\n"
                    + "Novembro: " + dist11 + " milhas\n"
                    + "Dezembro: " + dist12 + " milhas\n", "Relatório de distâncias mensal", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum voo encontrado");
        } finally {
            ConnectionDB.closeConnection(con, stmt, rs);
        }
        return dados;
    }

    public List<Dados> Cancelados(String ano) {

        Connection con = ConnectionDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Dados> dados = new ArrayList<>();
        try {

            stmt = con.prepareStatement("select * from `" + ano + "` where Cancelled = '1' order by DayOfWeek");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Dados info = new Dados();

                info.setDayofWeek(rs.getString("DayOfWeek"));
                info.setFlightNum(rs.getInt("FlightNum"));
                info.setUniqueCarrier(rs.getString("UniqueCarrier"));
                info.setCancellationCode(rs.getString("CancellationCode"));

                dados.add(info);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum voo encontrado");
        } finally {
            ConnectionDB.closeConnection(con, stmt, rs);
        }
        return dados;
    }

    public List<Dados> Atrasados(String ano) {

        Connection con = ConnectionDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Dados> dados = new ArrayList<>();
        try {

            stmt = con.prepareStatement("select * from `" + ano + "` where ArrDelay > 0"); // Como queremos aqueles que atrasaram, o comando busca os voos onde a coluna do atraso tiver valor maior que 0
            rs = stmt.executeQuery();

            while (rs.next()) {

                Dados info = new Dados();

                info.setFlightNum(rs.getInt("FlightNum"));
                info.setCRSArrTime(rs.getInt("CRSArrTime"));
                info.setArrTime(rs.getInt("ArrTime"));
                info.setArrDelay(rs.getInt("ArrDelay"));

                dados.add(info);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum voo encontrado");
        } finally {
            ConnectionDB.closeConnection(con, stmt, rs);
        }
        return dados;
    }

    public List<Dados> BetDist(String Dist1, String Dist2, String ano) {

        Connection con = ConnectionDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Dados> dados = new ArrayList<>();
        try {

            stmt = con.prepareStatement("SELECT * FROM `" + ano + "` WHERE Distance >= " + Dist1 + " AND Distance <= " + Dist2);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Dados info = new Dados();

                info.setFlightNum(rs.getInt("FlightNum"));
                info.setUniqueCarrier(rs.getString("UniqueCarrier"));
                info.setTailNum(rs.getString("TailNum"));
                info.setOrigin(rs.getString("Origin"));
                info.setDest(rs.getString("Dest"));
                info.setDistance(rs.getInt("Distance"));

                dados.add(info);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum voo encontrado");
        } finally {
            ConnectionDB.closeConnection(con, stmt, rs);
        }
        return dados;
    }

    public List<Dados> BetTempo(String Time1, String Time2, String ano) {

        Connection con = ConnectionDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Dados> dados = new ArrayList<>();
        try {

            stmt = con.prepareStatement("SELECT * FROM `" + ano + "` WHERE AirTime >= " + Time1 + " AND AirTime <= " + Time2);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Dados info = new Dados();

                info.setFlightNum(rs.getInt("FlightNum"));
                info.setUniqueCarrier(rs.getString("UniqueCarrier"));
                info.setTailNum(rs.getString("TailNum"));
                info.setOrigin(rs.getString("Origin"));
                info.setDest(rs.getString("Dest"));
                info.setAirTime(rs.getInt("AirTime"));

                dados.add(info);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum voo encontrado");
        } finally {
            ConnectionDB.closeConnection(con, stmt, rs);
        }
        return dados;
    }

    public List<Dados> buscarAero(String aero, boolean check1, boolean check2, String ano) {
        Connection con = ConnectionDB.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Dados> dados = new ArrayList<>();
        if (check1 && !check2) {
            try {

                stmt = con.prepareStatement("SELECT * FROM `" + ano + "` WHERE Origin = '" + aero + "'");
                rs = stmt.executeQuery();

                while (rs.next()) {
                    Dados info = new Dados();

                    info.setFlightNum(rs.getInt("FlightNum"));
                    info.setOrigin(rs.getString("Origin"));
                    info.setDest(rs.getString("Dest"));

                    dados.add(info);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Nenhum voo encontrado1");
            } finally {
                ConnectionDB.closeConnection(con, stmt, rs);
            }
            return dados;
        } else if (!check1 && check2) {

            try {
                stmt = con.prepareStatement("SELECT * FROM `" + ano + "` WHERE Dest = '" + aero + "'"); // Faz a busca de todo o conteúdo da tabela
                rs = stmt.executeQuery();   //Coloca em um resultado para poder exibir

                while (rs.next()) {    //Enquanto tiver valores ele vai executar 

                    Dados info = new Dados();

                    info.setFlightNum(rs.getInt("FlightNum"));
                    info.setOrigin(rs.getString("Origin"));
                    info.setDest(rs.getString("Dest"));

                    dados.add(info);   //Coloca os dados no Array                
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Nenhum voo encontrado2");
            } finally {                 // Processo que será sempre executado. Com sucesso ou erro das partes anteriores
                ConnectionDB.closeConnection(con, stmt, rs);   //Após o uso o finally fechará as conexões abertas por motivos de segurança
            }
            return dados;
        }
        if (check1 && check2) {   // origem e destino

            try {
                stmt = con.prepareStatement("SELECT * FROM `" + ano + "` WHERE Origin = '" + aero + "' OR Dest ='" + aero + "'"); // Faz a busca de todo o conteúdo da tabela
                rs = stmt.executeQuery();   //Coloca em um resultado para poder exibir

                while (rs.next()) {    //Enquanto tiver valores ele vai executar 

                    Dados info = new Dados();

                    info.setFlightNum(rs.getInt("FlightNum"));
                    info.setOrigin(rs.getString("Origin"));
                    info.setDest(rs.getString("Dest"));

                    dados.add(info);   //Coloca os dados no Array                
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Nenhum voo encontrado3");
            } finally {                 // Processo que será sempre executado. Com sucesso ou erro das partes anteriores
                ConnectionDB.closeConnection(con, stmt, rs);   //Após o uso o finally fechará as conexões abertas por motivos de segurança
            }
            return dados;
        }
        return dados;
    }

    public List<Dados> dadosAero(String aero, String ano) {

        Connection con = ConnectionDB.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Dados> dados = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT * FROM `" + ano + "` WHERE Aeros = '" + aero + "'");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Dados info = new Dados();

                info.setAeroporto(rs.getString("Aeroporto"));
                info.setCidade(rs.getString("Cidade"));
                info.setEstado(rs.getString("Estado"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum voo encontrado");
        } finally {
            ConnectionDB.closeConnection(con, stmt, rs);
        }
        return dados;
    }
}
