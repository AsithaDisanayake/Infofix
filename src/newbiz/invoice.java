/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newbiz;

import com.sun.org.apache.xml.internal.dtm.DTM;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperPrintManager;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.design.JasperDesign;
//import net.sf.jasperreports.engine.xml.JRXmlLoader;
//import net.sf.jasperreports.swing.JRViewer;
//import net.sf.jasperreports.view.JasperViewer;
//import org.codehaus.groovy.ast.stmt.WhileStatement;

/**
 *
 * @author Administrator
 */
public class invoice extends javax.swing.JFrame {

    int timeRun = 0;

    /**
     * Creates new form invoice
     */
    public invoice() {
        initComponents();
        loadcustomer();
        setEnterButton();
        autonum();

        f1();
        f2();
        f3();
        f4();
        f5();
        jLabel2.setText(login.username);
        validate();
//        time();
        userpriv();
setTime();
         jList1.setVisible(false);
    }

    public boolean isNumeric(String value) {
        try {
            double d = Double.parseDouble(value);
            return (true);
        } catch (NumberFormatException e) {
            return (false);
        }
    }

    public void userpriv() {
        if (login.usertype.equals("Normal")) {
            jMenuItem1.setVisible(false);
            jMenu3.setEnabled(false);
            jMenu4.setEnabled(false);
            jMenuItem13.setVisible(false);
        }
    }

    public void loadtime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        //   get current date time with Date()
        Date date = new Date();
        //System.out.println(dateFormat.format(date)); don't print it, but save it!
        String yourDate = dateFormat.format(date);
        jLabel3.setText(yourDate);

    }
    public void setTime(){
    
    Date date=new Date();
    jDateChooser1.setDate(date);
    }

//    public void time() {
//        new Thread() {
//            public void run() {
//                while (timeRun == 0) {
//                    String month = "";
//                    String day_of_week;
//                    Calendar cal = new GregorianCalendar();
//                    int d = cal.get(Calendar.DAY_OF_MONTH);
//                    int mo = cal.get(Calendar.MONTH);
//                    //<editor-fold defaultstate="collapsed" desc="int MONTH">
//                    switch (mo) {
//                        case 0:
//                            month = "JAN";
//                            break;
//                        case 1:
//                            month = "FEB";
//                            break;
//                        case 2:
//                            month = "MAR";
//                            break;
//                        case 3:
//                            month = "APR";
//                            break;
//                        case 4:
//                            month = "MAY";
//                            break;
//                        case 5:
//                            month = "JUNE";
//                            break;
//                        case 6:
//                            month = "JULY";
//                            break;
//                        case 7:
//                            month = "AUG";
//                            break;
//                        case 8:
//                            month = "SEP";
//                            break;
//                        case 9:
//                            month = "OCT";
//                            break;
//                        case 10:
//                            month = "NOV";
//                            break;
//                        case 11:
//                            month = "DEC";
//                            break;
//                    }
//                    //</editor-fold>
//                    int y = cal.get(Calendar.YEAR);
//
//                    int h = ((cal.get(Calendar.HOUR) != 0 ? cal.get(Calendar.HOUR) : 12));
//                    int m = cal.get(Calendar.MINUTE);
//                    int s = cal.get(Calendar.SECOND);
//                    int AM_PM = cal.get(Calendar.AM_PM);
//                    int day_week = cal.get(Calendar.DAY_OF_WEEK);
//
////"C:\Users\Ak\Documents\NetBeansProjects\ClockWidgetUI\cursor2.png"
//                    String dat = d + "";
//                    String year = y + "";
//                    //<editor-fold defaultstate="collapsed" desc="String day_of_week">
//                    switch (day_week) {
//                        case 1:
//                            day_of_week = "Sunday";
//                            break;
//                        case 2:
//                            day_of_week = "Monday";
//                            break;
//                        case 3:
//                            day_of_week = "Tuesday";
//                            break;
//                        case 4:
//                            day_of_week = "Wednesday";
//                            break;
//                        case 5:
//                            day_of_week = "Thursday";
//                            break;
//                        case 6:
//                            day_of_week = "Friday";
//                            break;
//                        default:
//                            day_of_week = "Saturday";
//                            break;
//                    }
//                    //</editor-fold>
//                    String date = String.format(" %s %s %s, %s ", dat, month, year, day_of_week);
//
//                    String hour = ((h < 10 ? ("0" + String.valueOf(h)) : String.valueOf(h)));
//                    String min = ((m < 10 ? ("0" + String.valueOf(m)) : String.valueOf(m)));
//                    String sec = ((s < 10 ? ("0" + String.valueOf(s)) : String.valueOf(s)));
//                    String A_P = ((AM_PM == 0 ? "AM" : "PM"));
//
//                    String time = hour + ":" + min + ":" + sec + " " + A_P;
//                    jLabel3.setText("Time :  " + time);
////                    datePanel.setText(date);
//
//                }
//            }
//        }.start();
//    }

    public void bilprint() {
        try {
            Connection com = DB.conect();
            JasperDesign jasperDesign = JRXmlLoader.load("infofix.jrxml");
            HashMap hm = new HashMap();
            hm.put("parameter1", this.jTextField1.getText());
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hm, com);
            JRViewer jv = new JRViewer(jasperPrint);
            JFrame jf = new JFrame();
            jf.getContentPane().add(jv);
            jf.validate();
            jf.setVisible(true);
            jf.setSize(new Dimension(800, 600));
            jf.setLocation(300, 100);
            jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JasperPrintManager.printPage(jasperPrint, 0, false);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e);
        } catch (Exception ex) {
            Logger.getLogger(invoice.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loadcustomer() {
        try {
            Connection com = DB.conect();
            ResultSet r = com.createStatement().executeQuery("select * from customer");
            while (r.next()) {
                jComboBox1.addItem(r.getString("fname"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEnterButton() {
        JRootPane a = getRootPane();
        InputMap im = a.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = a.getActionMap();
        KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        im.put(enter, "enter");
        am.put("enter", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                //callto  second methard
                moveDataToTable();
            }
        });
    }

    public void f1() {
        JRootPane a = getRootPane();
        InputMap im = a.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = a.getActionMap();
        KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0);
        im.put(enter, "f1");
        am.put("f1", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                //callto  second methard
                new item().setVisible(true);
            }
        });
    }

    public void f2() {
        JRootPane a = getRootPane();
        InputMap im = a.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = a.getActionMap();
        KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0);
        im.put(enter, "f2");
        am.put("f2", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                //callto  second methard
                new supplier().setVisible(true);
            }
        });
    }

    public void f3() {
        JRootPane a = getRootPane();
        InputMap im = a.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = a.getActionMap();
        KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0);
        im.put(enter, "f3");
        am.put("f3", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                //callto  second methard
                new customer().setVisible(true);
            }
        });
    }

    public void f4() {
        JRootPane a = getRootPane();
        InputMap im = a.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = a.getActionMap();
        KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0);
        im.put(enter, "f4");
        am.put("f4", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                //callto  second methard
                new GRN1().setVisible(true);
            }
        });
    }

    public void f5() {
        JRootPane a = getRootPane();
        InputMap im = a.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = a.getActionMap();
        KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0);
        im.put(enter, "f1");
        am.put("f1", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                //callto  second methard
                new paydealer().setVisible(true);
            }
        });
    }

    void autonum() {
        try {
            Connection con = DB.conect();
            ResultSet q = con.createStatement().executeQuery("select invoiceno from invoice");
            int max = 1000;
            int id = 0;
            boolean b = false;
            while (q.next()) {
                b = true;
                id = Integer.parseInt(q.getString("invoiceno"));
                if (id > max) {
                    max = id;
                }
            }
            if (b) {
                jTextField1.setText(max + 1 + "");
            } else {
                jTextField1.setText("1000");
            }
            validate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void moveDataToTable() {
        if (!jTextField2.getText().isEmpty() && !jTextField3.getText().isEmpty() && !jTextField4.getText().isEmpty() && !jTextField5.getText().isEmpty() && !jTextField6.getText().isEmpty() && !jTextField7.getText().isEmpty()) {

            try {
                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
                Vector v = new Vector();
                v.add(jTextField2.getText());
                v.add(jTextField3.getText());

                v.add(jTextField4.getText());
                v.add(jTextField5.getText());
                v.add(jTextField6.getText());
                v.add(jTextField7.getText());
                dtm.addRow(v);

                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
                jTextField5.setText("");
                jTextField6.setText("");
                jTextField7.setText("");
                jTextField12.setText("");
                jTextField2.requestFocus();
                calculateTootalAmount();
jList1.setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Fill All The Data Fiealds !");
        }
    }

    public void calculateTootalAmount() {
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        int i = dtm.getRowCount();
        double tot = 0.0;
        for (int a = 0; a < i; a++) {
            tot += Double.parseDouble(dtm.getValueAt(a, 5).toString());
        }
        jTextField8.setText(tot + "");
        jTextField11.setText(tot + "");
    }

    void catot() {
        try {
            String cash = jTextField9.getText();
            String cheq = jTextField10.getText();
            if (cash.isEmpty()) {
                cash = "0";
            }
            if (cheq.isEmpty()) {
                cheq = "0";
            }
            jTextField11.setText(Double.parseDouble(jTextField8.getText()) - (Double.parseDouble(cash) + Double.parseDouble(cheq)) + "");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem8 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();

        jMenuItem8.setText("jMenuItem8");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 204, 255));
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 0, 0));
        jButton1.setText("EXIT");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newbiz/switch-user.png"))); // NOI18N
        jButton2.setText("Log Off");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("WEL COME :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 165, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton12.setBackground(new java.awt.Color(51, 51, 51));
        jButton12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Current Stock");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(51, 51, 51));
        jButton13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Item Details");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(51, 51, 51));
        jButton14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("Damaged/returned Item");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(51, 51, 51));
        jButton15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("Quatation");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(51, 51, 51));
        jButton16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setText("Pay Dealer");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(56, 56, 56))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, 330, 680));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Invoice", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(153, 0, 0))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Code", "Item Name", "Category", "SUP", "QTY", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Invoice #");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Item Code");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Item Name");

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Category");

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("S.U.P");

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("QTY");

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Total");

        jTextField7.setEditable(false);
        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField7.setText("0.0");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Date");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Customer Name");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "...Select A Customer..." }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel22.setText("Stock");

        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jLabel22)
                        .addGap(24, 24, 24)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(64, 64, 64)
                                .addComponent(jLabel6)
                                .addGap(167, 167, 167)
                                .addComponent(jLabel7)
                                .addGap(50, 50, 50)
                                .addComponent(jLabel8)
                                .addGap(59, 59, 59)
                                .addComponent(jLabel9)
                                .addGap(74, 74, 74)
                                .addComponent(jLabel10))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4))
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel22))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel7)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10)))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 70, 810, 460));

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Update Stock");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Update Customers");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Update Suppliers");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("GRN");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("F1");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("F2");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("F3");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("F4");

        jButton8.setBackground(new java.awt.Color(0, 0, 0));
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Pay Dealer");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("F5");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jButton5)
                .addGap(29, 29, 29)
                .addComponent(jButton4)
                .addGap(30, 30, 30)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel11)
                .addGap(128, 128, 128)
                .addComponent(jLabel12)
                .addGap(141, 141, 141)
                .addComponent(jLabel13)
                .addGap(127, 127, 127)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(122, 122, 122))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton8))
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 0, 810, 60));

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Total ");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Cash");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Discount");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Balance");

        jTextField8.setEditable(false);
        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField8.setText("0.0");

        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField9.setText("0.0");
        jTextField9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextField9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField9MouseExited(evt);
            }
        });
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField9KeyReleased(evt);
            }
        });

        jTextField10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField10.setText("0.0");
        jTextField10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextField10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField10MouseExited(evt);
            }
        });
        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField10KeyReleased(evt);
            }
        });

        jTextField11.setEditable(false);
        jTextField11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField11.setText("0.0");
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newbiz/shopping-card-5120.png"))); // NOI18N
        jButton9.setText("PAY");
        jButton9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newbiz/shop-delete1.png"))); // NOI18N
        jButton10.setText("Delete A Row");
        jButton10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newbiz/refresh.png"))); // NOI18N
        jButton11.setText("Re-Set");
        jButton11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(26, 26, 26)
                        .addComponent(jTextField11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(14, 14, 14)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19))))
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jTextField8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, 800, 140));

        jMenu1.setText("File");

        jMenuItem1.setText("New user");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem2.setText("Item");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Customer");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem5.setText("Supplier");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem4.setText("Stock");
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Admin");

        jMenu5.setText("Customer");

        jMenuItem11.setText("Customer Payment");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem11);

        jMenuItem6.setText("Customer Summery");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem6);

        jMenu3.add(jMenu5);

        jMenu6.setText("Supplier");

        jMenuItem12.setText("Supplier payment");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem12);

        jMenuItem7.setText("Supplier Summary");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem7);

        jMenu3.add(jMenu6);

        jMenuItem10.setText("Income & DailySale");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuItem13.setText("Cheque Info");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem13);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Backup & Restore");

        jMenuItem9.setText("Backup & Restore");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(1365, 721));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Do You Want to Exit");
        if (i == 0) {
            System.exit(0);

        }           // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        try {
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            int i = dtm.getRowCount();
            if (i == 0) {
                JOptionPane.showMessageDialog(null, "No Data To Save.Table Is Empty !");
            } else if (jTextField1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please Enter The INVOICE No !");
                jTextField1.setBackground(Color.red);
            } else if (jComboBox1.getSelectedItem().equals("...Select A Customer...")) {

                JOptionPane.showMessageDialog(null, "Please Select A Customer !");
            } else {

                Connection com = DB.conect();
                String d = jDateChooser1.getDateFormatString();
                String d1[] = d.split("/");
                String realdate = d1[2] + "-" + d1[0] + "-" + d1[1];
                Object ob[] = new Object[6];

                ResultSet r = com.createStatement().executeQuery("select cusid from customer where fname='" + jComboBox1.getSelectedItem() + "'");
                String sid = null;
                boolean b1 = false;
                while (r.next()) {
                    b1 = true;
                    sid = r.getString("cusid");
                }
                if (b1) {
                } else {
                    sid = "0000";
                }

                for (int a = 0; a < i; a++) {
                    for (int b = 0; b <= 5; b++) {
                        ob[b] = dtm.getValueAt(a, b);
                    }

                    ResultSet r3 = com.createStatement().executeQuery("select qty from stock where itemid='" + ob[0] + "'");
                    boolean b3 = false;
                    double tableQty = 0.0;

                    while (r3.next()) {
                        b3 = true;
                        tableQty = Double.parseDouble(r3.getString("qty"));
                    }
                    double newQty = tableQty - Double.parseDouble(ob[4].toString());

                    PreparedStatement p1 = com.prepareStatement("update stock set qty='" + newQty + "' where itemid='" + ob[0] + "'");
                    p1.executeUpdate();
                    p1.close();

                    PreparedStatement p = com.prepareStatement("insert into invoice values('" + jTextField1.getText() + "','" + sid + "','" + ob[0] + "','" + ob[1] + "','" + ob[2] + "','" + ob[3] + "','" + ob[4] + "','" + ob[5] + "','" + realdate + "')");
                    p.executeUpdate();
                    p.close();

//                    PreparedStatement p12 = com.prepareStatement("insert into currentuser values('" + jLabel2.getText() + "','" + jTextField1.getText() + "','" + realdate + "')");      //save to current user
//                    p12.executeUpdate();
//                    p12.close();          //save to current user
                }
                double cash = Double.parseDouble(jTextField9.getText());
                double cheque = Double.parseDouble(jTextField10.getText());

                PreparedStatement p = com.prepareStatement("insert into invoicesummery values('" + jTextField1.getText() + "','" + sid + "','" + jTextField8.getText() + "','" + cash + "','" + cheque + "','" + jTextField11.getText() + "','" + realdate + "')");
                p.executeUpdate();
                p.close();

//                PreparedStatement p12 = com.prepareStatement("insert into currentuser values('" + jLabel2.getText() + "','" + jTextField1.getText() + "','" + realdate + "')");      //save to current user
//                    p12.executeUpdate();
//                    p12.close();          //save to current user
                if (Integer.parseInt(sid) != 0) {
                    PreparedStatement p1 = com.prepareStatement("insert into customerpayment values('" + sid + "','" + jTextField1.getText() + "','" + jTextField8.getText() + "','" + cash + "','" + cheque + "','" + jTextField11.getText() + "','" + realdate + "','" + realdate + "')");
                    p1.executeUpdate();
                    p1.close();
                    PreparedStatement p11 = com.prepareStatement("insert into customerpaymentsummery values('" + sid + "','" + jTextField1.getText() + "','" + jTextField8.getText() + "','" + cash + "','" + cheque + "','" + jTextField11.getText() + "','" + realdate + "','" + realdate + "')");
                    p11.executeUpdate();
                    p11.close();

                    PreparedStatement p13 = com.prepareStatement("insert into currentuser values('" + login.username + "','" + jTextField1.getText() + "','" + realdate + "')");      //save to current user
                    p13.executeUpdate();
                    p13.close();          //save to current user

                }
                int rowcount = dtm.getRowCount();
                while (rowcount > 0) {
                    dtm.removeRow(rowcount - 1);
                    rowcount--;
                }
                jTextField8.setText("0.0");
                jTextField9.setText("0.0");
                jTextField10.setText("0.0");
                jTextField11.setText("0.0");
                bilprint();

            }
//            else{
//            
//            
//            
//            
//            
//             Connection com = DB.conect();
//                String d = dateChooserCombo1.getText();
//                String d1[] = d.split("/");
//                String realdate = d1[2] + "-" + d1[0] + "-" + d1[1];
//                Object ob[] = new Object[6];
//
//                ResultSet r = com.createStatement().executeQuery("select cusid from customer where fname='" + jComboBox1.getSelectedItem() + "'");
//                String sid = null;
//                boolean b1 = false;
//                while (r.next()) {
//                    b1 = true;
//                    sid = r.getString("cusid");
//                }
//                if (b1) {
//                } 
//                else {
//                    sid = "0";
//                }
//
//                for (int a = 0; a < i; a++) {
//                    for (int b = 0; b <= 5; b++) {
//                        ob[b] = dtm.getValueAt(a, b);
//                    }
//
//                    ResultSet r3 = com.createStatement().executeQuery("select qty from stock where itemid='" + ob[0] + "'");
//                    boolean b3 = false;
//                    double tableQty = 0.0;
//
//                    while (r3.next()) {
//                        b3 = true;
//                        tableQty = Double.parseDouble(r3.getString("qty"));
//                    }
//                    double newQty = tableQty - Double.parseDouble(ob[4].toString());
//
//                    PreparedStatement p1 = com.prepareStatement("update stock set qty='" + newQty + "' where itemid='" + ob[0] + "'");
//                    p1.executeUpdate();
//                    p1.close();
//
//                    PreparedStatement p = com.prepareStatement("insert into invoice values('" + jTextField1.getText() + "','" + sid + "','" + ob[0] + "','" + ob[1] + "','" + ob[2] + "','" + ob[3] + "','" + ob[4] + "','" + ob[5] + "','" + realdate + "')");
//                    p.executeUpdate();
//                    p.close();
//
//                }
//                double cash = Double.parseDouble(jTextField9.getText());
//                double cheque = Double.parseDouble(jTextField10.getText());
//
//                PreparedStatement p = com.prepareStatement("insert into invoicesummery values('" + jTextField1.getText() + "','" + sid + "','" + jTextField13.getText() + "','" + cash + "','" + cheque + "','" + jTextField11.getText() + "','" + realdate + "')");
//                p.executeUpdate();
//                p.close();
//
//                if (Integer.parseInt(sid) != 0) {
//                    PreparedStatement p1 = com.prepareStatement("insert into customerpayment values('" + sid + "','" + jTextField1.getText() + "','" + jTextField13.getText() + "','" + cash + "','" + cheque + "','" + jTextField11.getText() + "','" + realdate + "','" + realdate + "')");
//                    p1.executeUpdate();
//                    p1.close();
//                    PreparedStatement p11 = com.prepareStatement("insert into customerpaymentsummery values('" + sid + "','" + jTextField1.getText() + "','" + jTextField13.getText() + "','" + cash + "','" + cheque + "','" + jTextField11.getText() + "','" + realdate + "','" + realdate + "')");
//                    p11.executeUpdate();
//                    p11.close();
//            
//                }
//                int rowcount = dtm.getRowCount();
//                while (rowcount > 0) {
//                    dtm.removeRow(rowcount - 1);
//                    rowcount--;
//                }
//                jTextField8.setText("0.0");
//                jTextField9.setText("0.0");
//                jTextField10.setText("0.0");
//                jTextField11.setText("0.0");
//                jTextField12.setText("0.0");
//                jTextField13.setText("0.0");
//                bilprint();
//            
//            
//            
//            
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        autonum();
        validate();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        try {
            Connection com = DB.conect();
            Object itemname = jTextField2.getText();
            String value = jTextField2.getText().trim();
//Boolean a= isNumeric(value);

            if (isNumeric(value)) {

                ResultSet r1 = com.createStatement().executeQuery("select * from stock where itemid='" + jTextField2.getText() + "'");
                boolean b = false;
                while (r1.next()) {
                    b = true;

                    
                    jTextField3.setText(r1.getString("itemname"));

                    jTextField4.setText(r1.getString("category"));

                    jTextField5.setText(r1.getString("sup"));
                    String qt = r1.getString("qty");

                    jTextField6.requestFocus();
                    int qti = Integer.parseInt(qt);
                    if (qti > 0) {
                        jTextField12.setText(qt);

                    } else {
                        JOptionPane.showMessageDialog(null, "Empty Stock!");
                        jTextField12.setBackground(Color.red);
                        jTextField12.setText(qt);
                        validate();
                    }
                    validate();
                }

                if (b) {
                } else {
                    jTextField3.setText("");
                    jTextField4.setText("");
                    jTextField5.setText("");
                    jTextField12.setText("");
                    jTextField12.setBackground(Color.WHITE);
                }
            } 
            else if(jTextField2.getText().isEmpty())
            {
                
            }
            
            else {
            jList1.setVisible(true);
                ResultSet r = com.createStatement().executeQuery("select * from stock where itemname like'%" + jTextField2.getText() + "%'");
                Vector v = new Vector();
                while (r.next()) {
//                String a = r.getString("itemid");
                    String b = r.getString("itemname");

//                String c = a + "-" + b;
                    v.add(b);

                }
                jList1.setListData(v);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }             // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        try {
            Connection com = DB.conect();
             ResultSet r1 = com.createStatement().executeQuery("select * from stock where itemid='" + jTextField2.getText() + "'");
                boolean b = false;
                while (r1.next()) {
                    b = true;
               
                    String qt = r1.getString("qty");
                    int cqty=Integer.parseInt(qt);
            
            String sup = jTextField5.getText();
            String qty = jTextField6.getText();
            int bqty=Integer.parseInt(qty);
            if(bqty>cqty){
                JOptionPane.showMessageDialog(null, "Not Enough Quantities!");
            }
            else{
            if (sup.isEmpty()) {
                sup = "0";
            }
            if (qty.isEmpty()) {
                qty = "0";
            }
            jTextField7.setText((Double.parseDouble(sup) * Double.parseDouble(qty)) + "");
                
            }
                }
            
            

        } catch (Exception e) {
            e.printStackTrace();
        }           // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jTextField9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyReleased
        catot();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9KeyReleased

    private void jTextField10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyReleased
        catot();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10KeyReleased

    private void jTextField9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField9MouseEntered
        if (jTextField9.getText().equals("0.0")) {
            jTextField9.setText("");
        }          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9MouseEntered

    private void jTextField9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField9MouseExited
        if (jTextField9.getText().isEmpty()) {
            jTextField9.setText("0.0");
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9MouseExited

    private void jTextField10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField10MouseEntered
        if (jTextField10.getText().equals("0.0")) {
            jTextField10.setText("");
        }  // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10MouseEntered

    private void jTextField10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField10MouseExited
        if (jTextField10.getText().isEmpty()) {
            jTextField10.setText("0.0");
        }   // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10MouseExited

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new item().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        new item().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        new Stock().setVisible(true);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        new login().setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new customer().setVisible(true);   // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        new damageitem().setVisible(true);       // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        new quatation().setVisible(true);   // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new supplier().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        new GRN1().setVisible(true);       // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.removeRow(jTable1.getSelectedRow());      // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        int rowCount = dtm.getRowCount();
//Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            dtm.removeRow(i);
        }

    }//GEN-LAST:event_jButton11ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new newuser().setVisible(true);     // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new customer().setVisible(true);     // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new item().setVisible(true);     // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        new supplier().setVisible(true);      // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        new paydealer().setVisible(true);    // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        new customer_payment_summery1().setVisible(true);      // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        new Supplier_payment_summery().setVisible(true);     // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        new back().setVisible(true);    // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        new paydealer().setVisible(true);    // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        this.validate();      // TODO add your handling code here:
    }//GEN-LAST:event_formMouseEntered

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        this.validate();      // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        autonum();
        validate();      // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        new DailySale().setVisible(true);   // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        new SupplierPayments().setVisible(true);     // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        new CustomerPayments().setVisible(true);    // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        new customercheque1().setVisible(true);      // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
     
        try {
            Connection com = DB.conect();

            Object ob = jList1.getSelectedValue();

//            String a[] = b.toString().split("-");
            ResultSet r1 = com.createStatement().executeQuery("select * from stock where itemname='" + ob + "'");
                boolean b = false;
                while (r1.next()) {
                    b = true;

                    jTextField2.setText(r1.getString("itemid"));
                    jTextField3.setText(r1.getString("itemname"));

                    jTextField4.setText(r1.getString("category"));

                    jTextField5.setText(r1.getString("sup"));
                    String qt = r1.getString("qty");

                    jTextField6.requestFocus();
                    int qti = Integer.parseInt(qt);
                    if (qti > 0) {
                        jTextField12.setText(qt);

                    } else {
                        JOptionPane.showMessageDialog(null, "Empty Stock!");
                        jTextField12.setBackground(Color.red);
                        jTextField12.setText(qt);
                        validate();
                    }
                    validate();
                }

                if (b) {
                } else {
                    jTextField3.setText("");
                    jTextField4.setText("");
                    jTextField5.setText("");
                    jTextField12.setText("");
                    jTextField12.setBackground(Color.WHITE);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }



// TODO add your handling code here:
    }//GEN-LAST:event_jList1ValueChanged

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
            java.util.logging.Logger.getLogger(invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new invoice().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
