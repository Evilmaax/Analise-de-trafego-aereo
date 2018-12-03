/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import connection.Buscas;
import connection.Dados;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Maximiliano Meyer
 */
public class GUI extends JFrame {

    /**
     * Creates new form NovoJFrame
     */
    public GUI() {
        initComponents();
        
        DefaultTableModel modelo = (DefaultTableModel) tableResultados.getModel();
        tableResultados.setRowSorter(new TableRowSorter(modelo));
        tableResultados.setDefaultRenderer(Object.class, new CellRenderer());     // Chamará o método declarado logo abaixo que centraliza os dados inseridos na JTable
        
        setLocationRelativeTo(null);                                              // Chama a JFrame no centro da tela
        setTitle("Sistema de controle aéreo do Max");                             // Define o título
    }

    public void lerJTable(String ano) {                                           // Método utilizado para fazer a busca quando o único dado inserido pelo usuário for o ano
        DefaultTableModel modelo = (DefaultTableModel) tableResultados.getModel();

        Buscas tabela = new Buscas();                                             // Cria um novo objeto do tipo Buscas

        for (Dados x : tabela.busca(ano)) {                                       // Passa o ano como parâmetro

            modelo.addRow(new Object[]{                                           //Chama os getters necessários exigidos por este método
                x.getYear(),
                x.getMonth(),
                x.getDayofMonth(),
                x.getDayofWeek(),
                x.getDepTime(),
                x.getCRSDepTime(),
                x.getArrTime(),
                x.getCRSArrTime(),
                x.getUniqueCarrier(),
                x.getFlightNum(),
                x.getTailNum(),
                x.getActualElapsedTime(),
                x.getCRSElapsedTime(),
                x.getAirTime(),
                x.getArrDelay(),
                x.getDepDelay(),
                x.getOrigin(),
                x.getDest(),
                x.getDistance(),
                x.getTaxiIn(),
                x.getTaxiOut(),
                x.getCancelled(),
                x.getCancellationCode(),
                x.getDiverted(),
                x.getCarrierDelay(),
                x.getWeatherDelay(),
                x.getNASDelay(),
                x.getSecurityDelay(),
                x.getLateAircraftDelay(),});
        }
    }

    public void lerJTableMes(String mesX, String ano) {                           // Quando a busca utilizada for o mês

        DefaultTableModel modelo = (DefaultTableModel) tableResultados.getModel();

        if (!"-".equals(mesX)) {                                                    // If utilizado para ver se a busca por mês está sendo exigida pelo usuário
            modelo.setNumRows(0);                                                   // Para não replicar os dados após aplicar uma nova busca por mês
            Buscas tabela = new Buscas();

            for (Dados x : tabela.buscaMes(mesX, ano)) {

                modelo.addRow(new Object[]{
                    x.getYear(),
                    x.getMonth(),
                    x.getDayofMonth(),
                    x.getDayofWeek(),
                    x.getDepTime(),
                    x.getCRSDepTime(),
                    x.getArrTime(),
                    x.getCRSArrTime(),
                    x.getUniqueCarrier(),
                    x.getFlightNum(),
                    x.getTailNum(),
                    x.getActualElapsedTime(),
                    x.getCRSElapsedTime(),
                    x.getAirTime(),
                    x.getArrDelay(),
                    x.getDepDelay(),
                    x.getOrigin(),
                    x.getDest(),
                    x.getDistance(),
                    x.getTaxiIn(),
                    x.getTaxiOut(),
                    x.getCancelled(),
                    x.getCancellationCode(),
                    x.getDiverted(),
                    x.getCarrierDelay(),
                    x.getWeatherDelay(),
                    x.getNASDelay(),
                    x.getSecurityDelay(),
                    x.getLateAircraftDelay(),});
            }
        }
    }

    public void lerJTableVoo(String Voo, boolean check1, boolean check2, String ano) {  // Passa também os dados referentes aos JCheckBox "cancelados" e "redirecionados"

        DefaultTableModel modelo = (DefaultTableModel) tableResultados.getModel();

        if (!"".equals(Voo) || "".equals(Voo) && check1 != false || "".equals(Voo) && check2 != false || "".equals(Voo) && check1 != false && check2 != false) {     //Confere se o usuário está solicitando esse tipo de busca                                             
            modelo.setNumRows(0);                                                       // Permite fazer tanto a busca inserindo algum voo específico, como apenas os campos "dir." ou "redir"              
            Buscas tabela = new Buscas();

            for (Dados x : tabela.buscaVoo(Voo, check1, check2, ano)) {

                modelo.addRow(new Object[]{
                    x.getYear(),
                    x.getMonth(),
                    x.getDayofMonth(),
                    x.getDayofWeek(),
                    x.getDepTime(),
                    x.getCRSDepTime(),
                    x.getArrTime(),
                    x.getCRSArrTime(),
                    x.getUniqueCarrier(),
                    x.getFlightNum(),
                    x.getTailNum(),
                    x.getActualElapsedTime(),
                    x.getCRSElapsedTime(),
                    x.getAirTime(),
                    x.getArrDelay(),
                    x.getDepDelay(),
                    x.getOrigin(),
                    x.getDest(),
                    x.getDistance(),
                    x.getTaxiIn(),
                    x.getTaxiOut(),
                    x.getCancelled(),
                    x.getCancellationCode(),
                    x.getDiverted(),
                    x.getCarrierDelay(),
                    x.getWeatherDelay(),
                    x.getNASDelay(),
                    x.getSecurityDelay(),
                    x.getLateAircraftDelay(),});
            }
        }
    }

    public void lerJTableData(String dataX, String dataY, String ano) {           // Passa também os parãmetros de data

        DefaultTableModel modelo = (DefaultTableModel) tableResultados.getModel();

        if (dataX != "-" && dataY != "-") {                                       // Mesma verificação anterior
            modelo.setNumRows(0);

            Buscas tabela = new Buscas();

            for (Dados x : tabela.buscaDatas(dataX, dataY, ano)) {

                modelo.addRow(new Object[]{
                    x.getYear(),
                    x.getMonth(),
                    x.getDayofMonth(),
                    x.getDayofWeek(),
                    x.getDepTime(),
                    x.getCRSDepTime(),
                    x.getArrTime(),
                    x.getCRSArrTime(),
                    x.getUniqueCarrier(),
                    x.getFlightNum(),
                    x.getTailNum(),
                    x.getActualElapsedTime(),
                    x.getCRSElapsedTime(),
                    x.getAirTime(),
                    x.getArrDelay(),
                    x.getDepDelay(),
                    x.getOrigin(),
                    x.getDest(),
                    x.getDistance(),
                    x.getTaxiIn(),
                    x.getTaxiOut(),
                    x.getCancelled(),
                    x.getCancellationCode(),
                    x.getDiverted(),
                    x.getCarrierDelay(),
                    x.getWeatherDelay(),
                    x.getNASDelay(),
                    x.getSecurityDelay(),
                    x.getLateAircraftDelay(),});
            }
        }
        if (dataX != "-" && dataY == "-" || dataX == "-" && dataY != "-") {        // Mesagem de erro caso o usuário selecione apenas uma data na JComboBox
            JOptionPane.showMessageDialog(null, "Você deve selecionar 2 datas", "Inane warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void lerJTableHora(String Hora1, String Hora2, String ano) {

        String hora1 = Hora1.replace(":", "");                                    // Como os valores no banco estão sem o ":", após capturar essa entrada de dados é necessário tratá-la
        String hora2 = Hora2.replace(":", "");                                    // fazendo o replace removendo o ":" antes de enviar ao banco para consulta.

        DefaultTableModel modelo = (DefaultTableModel) tableResultados.getModel();

        if (!"    ".equals(hora1) && !"    ".equals(hora2)) {         
            modelo.setNumRows(0);

            Buscas tabela = new Buscas();

            for (Dados x : tabela.buscaHora(hora1, hora2, ano)) {

                modelo.addRow(new Object[]{
                    x.getYear(),
                    x.getMonth(),
                    x.getDayofMonth(),
                    x.getDayofWeek(),
                    x.getDepTime(),
                    x.getCRSDepTime(),
                    x.getArrTime(),
                    x.getCRSArrTime(),
                    x.getUniqueCarrier(),
                    x.getFlightNum(),
                    x.getTailNum(),
                    x.getActualElapsedTime(),
                    x.getCRSElapsedTime(),
                    x.getAirTime(),
                    x.getArrDelay(),
                    x.getDepDelay(),
                    x.getOrigin(),
                    x.getDest(),
                    x.getDistance(),
                    x.getTaxiIn(),
                    x.getTaxiOut(),
                    x.getCancelled(),
                    x.getCancellationCode(),
                    x.getDiverted(),
                    x.getCarrierDelay(),
                    x.getWeatherDelay(),
                    x.getNASDelay(),
                    x.getSecurityDelay(),
                    x.getLateAircraftDelay(),});
            }
        }
        if (hora1 != "    " && hora2 == "    " || hora1 == "    " && hora2 != "    ") {
            JOptionPane.showMessageDialog(null, "Você deve inserir 2 valores de hora", "Inane warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void Distancia(String ano) {                                          // Método simples que somente passa o ano e chama o método na classe Buscas
                                                                                  // Por ser o resultado desse método exibido em um JDiallog, a "ação" está toda no código da outra classe
        Buscas dist = new Buscas(); 

        for (Dados x : dist.Distancia(ano)) {
        };
    }

    public class CellRenderer extends DefaultTableCellRenderer {                  // Código para centralizar os dados dentro da JTable

        public CellRenderer() {
            super();
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            this.setHorizontalAlignment(CENTER);
            return super.getTableCellRendererComponent(table, value, isSelected,
                    hasFocus, row, column);
        }
    }

    private MaskFormatter setMascara(String mascara) {                            // Máscara utilizada nas JFormattedText utilizadas para receber os dados de hora
        MaskFormatter mask = null;
        try {
            mask = new MaskFormatter(mascara);
        } catch (java.text.ParseException ex) {
        }
        return mask;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        comboMes = new javax.swing.JComboBox<>();
        label2 = new java.awt.Label();
        jLabel2 = new javax.swing.JLabel();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        jButton1 = new javax.swing.JButton();
        comboData1 = new javax.swing.JComboBox<>();
        comboData2 = new javax.swing.JComboBox<>();
        txtVoo = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        check1 = new javax.swing.JCheckBox();
        check2 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        comboAno = new javax.swing.JComboBox<>();
        Hora1 = new javax.swing.JFormattedTextField((setMascara("##:##")));
        Hora2 = new javax.swing.JFormattedTextField((setMascara("##:##")));
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableResultados = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        btnSair = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtros", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mês");

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label1.setText("Datas");

        comboMes.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        comboMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        comboMes.setToolTipText("");
        comboMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMesActionPerformed(evt);
            }
        });

        label2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label2.setText("a");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Voo");

        label3.setAlignment(java.awt.Label.CENTER);
        label3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label3.setText("Horas");

        label4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label4.setText("a");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setText("Filtrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        comboData1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        comboData1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        comboData1.setToolTipText("");
        comboData1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboData1ActionPerformed(evt);
            }
        });

        comboData2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        comboData2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        comboData2.setToolTipText("");
        comboData2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboData2ActionPerformed(evt);
            }
        });

        txtVoo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtVoo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtVoo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVooActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setText("Limpar filtros");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Incluir"));

        check1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        check1.setText("Cancelados");
        check1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check1ActionPerformed(evt);
            }
        });

        check2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        check2.setText("Redirecionados");
        check2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(check1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check2))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(check1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(check2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ano");

        comboAno.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        comboAno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "2006", "2007", "2008" }));
        comboAno.setToolTipText("");
        comboAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAnoActionPerformed(evt);
            }
        });

        Hora1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Hora1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Hora1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Hora1FocusGained(evt);
            }
        });
        Hora1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Hora1ActionPerformed(evt);
            }
        });

        Hora2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Hora2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Hora2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Hora2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboMes, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboData1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboData2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboAno, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Hora1, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(txtVoo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Hora2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jButton2)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addGap(28, 28, 28))))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboMes, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboAno, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(label2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboData1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboData2, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtVoo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Hora1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addGap(0, 2, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(Hora2)))))
                .addGap(21, 21, 21))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tableResultados.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tableResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ano", "Mês", "Dia do Mês", "Dia da Semana", "Decolagem", "Decolagem prevista", "Chegada", "Chegada prevista", "Companhia", "Voo", "Código cauda", "Tempo de Voo", "Tempo de Voo CRS", "Tempo de Voo previsto", "Atraso pouso", "Atraso decolagem", "Origem", "Destino", "Distância", "Taxi pouso", "Taxi decolagem", "Cancelamento", "Motivo", "Redirecionado", "Atraso Companhia", "Atraso clima", "Atraso sistema", "Atraso segurança", "Atraso aeronave"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableResultados.setToolTipText("");
        tableResultados.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableResultados.setName(""); // NOI18N
        jScrollPane1.setViewportView(tableResultados);
        if (tableResultados.getColumnModel().getColumnCount() > 0) {
            tableResultados.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableResultados.getColumnModel().getColumn(1).setPreferredWidth(40);
            tableResultados.getColumnModel().getColumn(3).setPreferredWidth(100);
            tableResultados.getColumnModel().getColumn(5).setPreferredWidth(130);
            tableResultados.getColumnModel().getColumn(6).setPreferredWidth(65);
            tableResultados.getColumnModel().getColumn(7).setPreferredWidth(115);
            tableResultados.getColumnModel().getColumn(9).setPreferredWidth(45);
            tableResultados.getColumnModel().getColumn(10).setPreferredWidth(95);
            tableResultados.getColumnModel().getColumn(11).setPreferredWidth(100);
            tableResultados.getColumnModel().getColumn(12).setPreferredWidth(130);
            tableResultados.getColumnModel().getColumn(13).setPreferredWidth(145);
            tableResultados.getColumnModel().getColumn(14).setPreferredWidth(85);
            tableResultados.getColumnModel().getColumn(15).setPreferredWidth(120);
            tableResultados.getColumnModel().getColumn(16).setPreferredWidth(60);
            tableResultados.getColumnModel().getColumn(17).setPreferredWidth(60);
            tableResultados.getColumnModel().getColumn(18).setPreferredWidth(65);
            tableResultados.getColumnModel().getColumn(19).setPreferredWidth(80);
            tableResultados.getColumnModel().getColumn(20).setPreferredWidth(105);
            tableResultados.getColumnModel().getColumn(21).setPreferredWidth(95);
            tableResultados.getColumnModel().getColumn(22).setPreferredWidth(50);
            tableResultados.getColumnModel().getColumn(23).setPreferredWidth(95);
            tableResultados.getColumnModel().getColumn(24).setPreferredWidth(120);
            tableResultados.getColumnModel().getColumn(25).setPreferredWidth(85);
            tableResultados.getColumnModel().getColumn(26).setPreferredWidth(95);
            tableResultados.getColumnModel().getColumn(27).setPreferredWidth(110);
            tableResultados.getColumnModel().getColumn(28).setPreferredWidth(100);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
        );

        jMenu3.setText("Consultas");
        jMenu3.add(jSeparator1);

        jMenuItem4.setText("Voo mais frequente");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem6.setText("Voos Cancelados");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem5.setText("Distância total dos voos");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem3.setText("Voos Atrasados");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenu5.setText("Consulta personalizada");

        jMenuItem8.setText("Intervalo entre distâncias");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem8);

        jMenuItem9.setText("Duração tempo de voo");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem9);

        jMenuItem10.setText("Entre aeroportos");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem10);

        jMenu3.add(jMenu5);

        jMenuBar1.add(jMenu3);

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jMenuItem2.setText("Sair");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        btnSair.add(jMenuItem2);

        jMenuBar1.add(btnSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

        new Recorrentes().setVisible(true);                                       // Action do item do menu que chama a JFrame dos voos recorrentes

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed

        new Cancelados().setVisible(true);                                        // Action do item do menu que chama a JFrame dos voos cancelados

    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        new BetDist().setVisible(true);                                           // Action do item do menu que chama a JFrame dos voos filtrados por distância

    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed

    }//GEN-LAST:event_btnSairActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
      
        System.exit(0);                                                           // Action do item do menu que fecha a aplicação
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed

        Distancia((String) comboAno.getSelectedItem());                           // Action do item do menu que chama a JFrame dos voos filtrados por distância
        
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        
        new Atrasados().setVisible(true);                                         // Action do item do menu que chama a JFrame dos voos atrasados
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed

        new BetTime().setVisible(true);                                           // Action do item do menu que chama a JFrame dos voos filtrados por tempo de voo

    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed

        new Aeros().setVisible(true);                                             // Action do item do menu que chama a JFrame dos voos filtrados por aeroporto

    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void comboAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboAnoActionPerformed

    private void check2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check2ActionPerformed

    private void check1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        DefaultTableModel modelo = (DefaultTableModel) tableResultados.getModel();
        modelo.setNumRows(0);
        Hora1.setText("");
        Hora2.setText("");                                                        // Action do botão "Limpar filtros" que remove todos os filtros aplicados, os resultados já na tela e
        txtVoo.setText("");                                                       // tudo que tiver sido inserido nos campos de pesquisa das JTextFields, JComboBox e JCheckBox
        comboData1.setSelectedIndex(0);
        comboData2.setSelectedIndex(0);
        comboData2.setSelectedIndex(0);
        comboMes.setSelectedIndex(0);
        comboAno.setSelectedIndex(0);
        check1.setSelected(false);
        check2.setSelected(false);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtVooActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVooActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVooActionPerformed

    private void comboData2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboData2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboData2ActionPerformed

    private void comboData1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboData1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboData1ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed

    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        DefaultTableModel modelo = (DefaultTableModel) tableResultados.getModel();                  // Action do botão "Filtrar" que pega todos os valores inseridos pelos usuários
        modelo.setNumRows(0);                                                                       // e manda para os devidos métodos
        lerJTable((String) comboAno.getSelectedItem());
        lerJTableMes((String) comboMes.getSelectedItem(), (String) comboAno.getSelectedItem());
        lerJTableVoo(txtVoo.getText(), check1.isSelected(), check2.isSelected(), (String) comboAno.getSelectedItem());
        lerJTableData((String) comboData1.getSelectedItem(), (String) comboData2.getSelectedItem(), (String) comboAno.getSelectedItem());
        lerJTableHora(Hora1.getText(), Hora2.getText(), (String) comboAno.getSelectedItem());

    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboMesActionPerformed

    private void Hora2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Hora2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Hora2ActionPerformed

    private void Hora1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Hora1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Hora1ActionPerformed

    private void Hora1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Hora1FocusGained

    }//GEN-LAST:event_Hora1FocusGained

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField Hora1;
    private javax.swing.JFormattedTextField Hora2;
    private javax.swing.JMenu btnSair;
    private javax.swing.JCheckBox check1;
    private javax.swing.JCheckBox check2;
    private javax.swing.JComboBox<String> comboAno;
    public javax.swing.JComboBox<String> comboData1;
    public javax.swing.JComboBox<String> comboData2;
    private javax.swing.JComboBox<String> comboMes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private javax.swing.JTable tableResultados;
    private javax.swing.JTextField txtVoo;
    // End of variables declaration//GEN-END:variables
}
