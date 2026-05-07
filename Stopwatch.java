///importing of necessary packages

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author rwnja
 */
public class Stopwatch extends javax.swing.JFrame {

    ///declare variables for the stopwatch
    private int hours = 0;
    int minutes = 0;
    int seconds = 0;
    int centiseconds = 0;
    private int laphours = 0;
    int lapminutes = 0;
    int lapseconds = 0;
    int lapcentiseconds = 0;
    

    private boolean start = false;
    private boolean stop = false;
    private boolean resume = false;
    private int numLaps = 0;

    //getter methods for private variables
    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    /**
     * Creates new form Stopwatch
     */
//constructor initializes the components of the stopwatch's GUI.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          constructor
    public Stopwatch() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    ///timer object that performs an action every 10 milliseconds
    Timer timer = new Timer(10, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            centiseconds++;
            //0 is concatenated with the value of the centiseconds if it is a single digit for proper time format 
            if (centiseconds < 10) {
                centisecondsLabel.setText("0" + centiseconds);
            } else if (centiseconds <= 59) {
                centisecondsLabel.setText(String.valueOf(centiseconds));
            } else {
                centiseconds = 0;
                seconds++;
                if (seconds < 10) {
                    secondsLabel.setText("0" + seconds);
                } else if (seconds <= 59) {
                    secondsLabel.setText(String.valueOf(seconds));
                } else {
                    seconds = 0;
                    secondsLabel.setText("00");
                    minutes++;
                    if (minutes < 10) {
                        minutesLabel.setText("0" + minutes);
                    } else if (minutes <= 59) {
                        minutesLabel.setText(String.valueOf(minutes));
                    } else {
                        minutes = 0;
                        minutesLabel.setText("00");
                        hours++;
                        if (hours < 10) {
                            hoursLabel.setText("0" + hours);
                        } else if (hours <= 23) {
                            hoursLabel.setText(String.valueOf(hours));
                            hours = 0;
                        }
                    }
                }
            }
        }

    });

    ///timer object that performs an action every 10 milliseconds
    Timer timer2 = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            lapcentiseconds++;
            //0 is concatenated with the value of the centiseconds if it is a single digit for proper time format 
            if (lapcentiseconds < 10) {
                lapcentisecondsLabel.setText("0" + lapcentiseconds);
            } else if (lapcentiseconds <= 59) {
                lapcentisecondsLabel.setText(String.valueOf(lapcentiseconds));
            } else {
                lapcentiseconds = 0;
                lapseconds++;
                if (lapseconds < 10) {
                    lapsecondsLabel.setText("0" + lapseconds);
                } else if (lapseconds <= 59) {
                    lapsecondsLabel.setText(String.valueOf(lapseconds));
                } else {
                    lapseconds = 0;
                    lapsecondsLabel.setText("00");
                    lapminutes++;
                    if (lapminutes < 10) {
                        lapminutesLabel.setText("0" + lapminutes);
                    } else if (lapminutes <= 59) {
                        lapminutesLabel.setText(String.valueOf(lapminutes));
                    } else {
                        lapminutes = 0;
                        lapminutesLabel.setText("00");
                        laphours++;
                        if (laphours < 10) {
                            laphoursLabel.setText("0" + laphours);
                        } else if (laphours <= 23) {
                            laphoursLabel.setText(String.valueOf(laphours));
                            laphours = 0;
                        }
                    }
                }
            }
        }

    });
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        hoursLabel = new javax.swing.JLabel();
        colon1Label = new javax.swing.JLabel();
        minutesLabel = new javax.swing.JLabel();
        colon2Label = new javax.swing.JLabel();
        secondsLabel = new javax.swing.JLabel();
        fullStopLabel = new javax.swing.JLabel();
        centisecondsLabel = new javax.swing.JLabel();
        lap_resetButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        laphoursLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lapminutesLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lapsecondsLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lapcentisecondsLabel = new javax.swing.JLabel();
        laptime1 = new javax.swing.JLabel();
        laptime3 = new javax.swing.JLabel();
        laptime2 = new javax.swing.JLabel();
        laptime4 = new javax.swing.JLabel();
        laptime6 = new javax.swing.JLabel();
        lap6 = new javax.swing.JLabel();
        laptime7 = new javax.swing.JLabel();
        laptime8 = new javax.swing.JLabel();
        laptime10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        overalltime1 = new javax.swing.JLabel();
        overalltime2 = new javax.swing.JLabel();
        overalltime3 = new javax.swing.JLabel();
        overalltime4 = new javax.swing.JLabel();
        overalltime5 = new javax.swing.JLabel();
        overalltime6 = new javax.swing.JLabel();
        overalltime7 = new javax.swing.JLabel();
        overalltime8 = new javax.swing.JLabel();
        overalltime9 = new javax.swing.JLabel();
        overalltime10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lap1 = new javax.swing.JLabel();
        lap2 = new javax.swing.JLabel();
        lap3 = new javax.swing.JLabel();
        lap4 = new javax.swing.JLabel();
        lap5 = new javax.swing.JLabel();
        laptime5 = new javax.swing.JLabel();
        lap8 = new javax.swing.JLabel();
        lap7 = new javax.swing.JLabel();
        lap9 = new javax.swing.JLabel();
        laptime9 = new javax.swing.JLabel();
        lap10 = new javax.swing.JLabel();
        previousButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        jLabel6.setText("-----------------------------------------------------------------------------------------------------------------------------");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/template for stopwatch.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 600, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hoursLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        hoursLabel.setForeground(new java.awt.Color(255, 255, 255));
        hoursLabel.setText("00");
        jPanel1.add(hoursLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 40, -1));

        colon1Label.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        colon1Label.setForeground(new java.awt.Color(255, 255, 255));
        colon1Label.setText(":");
        jPanel1.add(colon1Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 20, -1));

        minutesLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        minutesLabel.setForeground(new java.awt.Color(255, 255, 255));
        minutesLabel.setText("00");
        jPanel1.add(minutesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, -1));

        colon2Label.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        colon2Label.setForeground(new java.awt.Color(255, 255, 255));
        colon2Label.setText(":");
        jPanel1.add(colon2Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, -1, -1));

        secondsLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        secondsLabel.setForeground(new java.awt.Color(255, 255, 255));
        secondsLabel.setText("00");
        jPanel1.add(secondsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 54, -1));

        fullStopLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        fullStopLabel.setForeground(new java.awt.Color(255, 255, 255));
        fullStopLabel.setText(".");
        jPanel1.add(fullStopLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, -1, -1));

        centisecondsLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        centisecondsLabel.setForeground(new java.awt.Color(255, 255, 255));
        centisecondsLabel.setText("00");
        jPanel1.add(centisecondsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 40, -1));

        lap_resetButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lap_resetButton.setForeground(new java.awt.Color(0, 51, 204));
        lap_resetButton.setText("Lap");
        lap_resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lap_resetButtonActionPerformed(evt);
            }
        });
        jPanel1.add(lap_resetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 110, 30));

        startButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        startButton.setForeground(new java.awt.Color(0, 0, 204));
        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        jPanel1.add(startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, 110, 30));

        laphoursLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        laphoursLabel.setForeground(new java.awt.Color(0, 255, 255));
        laphoursLabel.setText("00");
        jPanel1.add(laphoursLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 255));
        jLabel1.setText(":");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        lapminutesLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lapminutesLabel.setForeground(new java.awt.Color(0, 255, 255));
        lapminutesLabel.setText("00");
        jPanel1.add(lapminutesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 255, 255));
        jLabel8.setText(":");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));

        lapsecondsLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lapsecondsLabel.setForeground(new java.awt.Color(0, 255, 255));
        lapsecondsLabel.setText("00");
        jPanel1.add(lapsecondsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 255, 255));
        jLabel10.setText(".");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, -1, -1));

        lapcentisecondsLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lapcentisecondsLabel.setForeground(new java.awt.Color(0, 255, 255));
        lapcentisecondsLabel.setText("00");
        jPanel1.add(lapcentisecondsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, -1));

        laptime1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        laptime1.setForeground(new java.awt.Color(255, 255, 255));
        laptime1.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(laptime1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 100, 20));

        laptime3.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        laptime3.setForeground(new java.awt.Color(255, 255, 255));
        laptime3.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(laptime3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 110, -1));

        laptime2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        laptime2.setForeground(new java.awt.Color(255, 255, 255));
        laptime2.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(laptime2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 110, 30));

        laptime4.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        laptime4.setForeground(new java.awt.Color(255, 255, 255));
        laptime4.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(laptime4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 110, -1));

        laptime6.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        laptime6.setForeground(new java.awt.Color(255, 255, 255));
        laptime6.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(laptime6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 110, -1));

        lap6.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lap6.setForeground(new java.awt.Color(255, 255, 255));
        lap6.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(lap6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, -1, -1));

        laptime7.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        laptime7.setForeground(new java.awt.Color(255, 255, 255));
        laptime7.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(laptime7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 110, -1));

        laptime8.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        laptime8.setForeground(new java.awt.Color(255, 255, 255));
        laptime8.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(laptime8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 110, -1));

        laptime10.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        laptime10.setForeground(new java.awt.Color(255, 255, 255));
        laptime10.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(laptime10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, 110, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Overall time");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, -1, -1));

        overalltime1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        overalltime1.setForeground(new java.awt.Color(255, 255, 255));
        overalltime1.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(overalltime1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 130, 20));

        overalltime2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        overalltime2.setForeground(new java.awt.Color(255, 255, 255));
        overalltime2.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(overalltime2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 120, -1));

        overalltime3.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        overalltime3.setForeground(new java.awt.Color(255, 255, 255));
        overalltime3.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(overalltime3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 120, -1));

        overalltime4.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        overalltime4.setForeground(new java.awt.Color(255, 255, 255));
        overalltime4.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(overalltime4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 120, 50));

        overalltime5.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        overalltime5.setForeground(new java.awt.Color(255, 255, 255));
        overalltime5.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(overalltime5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 120, -1));

        overalltime6.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        overalltime6.setForeground(new java.awt.Color(255, 255, 255));
        overalltime6.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(overalltime6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 120, -1));

        overalltime7.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        overalltime7.setForeground(new java.awt.Color(255, 255, 255));
        overalltime7.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(overalltime7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 130, -1));

        overalltime8.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        overalltime8.setForeground(new java.awt.Color(255, 255, 255));
        overalltime8.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(overalltime8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 110, -1));

        overalltime9.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        overalltime9.setForeground(new java.awt.Color(255, 255, 255));
        overalltime9.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(overalltime9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 120, -1));

        overalltime10.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        overalltime10.setForeground(new java.awt.Color(255, 255, 255));
        overalltime10.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(overalltime10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 120, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Lap");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 90, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Lap times");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, -1, -1));

        lap1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lap1.setForeground(new java.awt.Color(255, 255, 255));
        lap1.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(lap1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, 20));

        lap2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lap2.setForeground(new java.awt.Color(255, 255, 255));
        lap2.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(lap2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, -1, 30));

        lap3.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lap3.setForeground(new java.awt.Color(255, 255, 255));
        lap3.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(lap3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, -1, 50));

        lap4.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lap4.setForeground(new java.awt.Color(255, 255, 255));
        lap4.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(lap4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, -1, -1));

        lap5.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lap5.setForeground(new java.awt.Color(255, 255, 255));
        lap5.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(lap5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, -1, -1));

        laptime5.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        laptime5.setForeground(new java.awt.Color(255, 255, 255));
        laptime5.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(laptime5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 110, -1));

        lap8.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lap8.setForeground(new java.awt.Color(255, 255, 255));
        lap8.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(lap8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 60, -1));

        lap7.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lap7.setForeground(new java.awt.Color(255, 255, 255));
        lap7.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(lap7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, -1, -1));

        lap9.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lap9.setForeground(new java.awt.Color(255, 255, 255));
        lap9.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(lap9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, -1, -1));

        laptime9.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        laptime9.setForeground(new java.awt.Color(255, 255, 255));
        laptime9.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(laptime9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 110, -1));

        lap10.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lap10.setForeground(new java.awt.Color(255, 255, 255));
        lap10.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(lap10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, -1, -1));

        previousButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        previousButton.setText("<");
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });
        jPanel1.add(previousButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/template for stopwatch.jpg"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 600, 510));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 600, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed

        if (startButton.getText().equals("Start")) {
            startButton.setText("Stop");
            start = true;
            timer.start();
        } else if (startButton.getText().equals("Stop")) {
            stop = true;
            startButton.setText("Resume");
            timer.stop();
            timer2.stop();
            lap_resetButton.setText("Reset");

        } else {
            resume = true;
            startButton.setText("Stop");
            timer.restart();
            timer2.restart();
        }


    }//GEN-LAST:event_startButtonActionPerformed

    private void lap_resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lap_resetButtonActionPerformed
        if (lap_resetButton.getText().equals("Reset")) {
            centisecondsLabel.setText("00");
            secondsLabel.setText("00");
            minutesLabel.setText("00");
            hoursLabel.setText("00");

            lapcentisecondsLabel.setText("00");
            lapsecondsLabel.setText("00");
            lapminutesLabel.setText("00");
            laphoursLabel.setText("00");
            lap_resetButton.setText("Lap");
            startButton.setText("Start");

            centiseconds = 0;
            seconds = 0;
            minutes = 0;
            hours = 0;
            lapcentiseconds = 0;
            lapseconds = 0;
            lapminutes = 0;
            laphours = 0;
            lap1.setText("");
            laptime1.setText("");
            overalltime1.setText("");
            lap2.setText("");
            laptime2.setText("");
            overalltime2.setText("");
            lap3.setText("");
            laptime3.setText("");
            overalltime3.setText("");
            lap4.setText("");
            laptime4.setText("");
            overalltime4.setText("");
            lap5.setText("");
            laptime5.setText("");
            overalltime5.setText("");
            lap6.setText("");
            laptime6.setText("");
            overalltime6.setText("");
            lap7.setText("");
            laptime7.setText("");
            overalltime7.setText("");
            lap8.setText("");
            laptime8.setText("");
            overalltime8.setText("");
            lap9.setText("");
            laptime9.setText("");
            overalltime9.setText("");
            lap9.setText("");
            laptime9.setText("");
            overalltime9.setText("");
            lap10.setText("");
            laptime10.setText("");
            overalltime10.setText("");
            numLaps = 0;
            timer.stop();
            timer2.stop();
        } else if (lap_resetButton.getText().equals("Lap")) {
            numLaps++;
            if (numLaps == 1) {
                timer2.start();
                lap1.setText("01");
                laptime1.setText(hoursLabel.getText() + ":" + minutesLabel.getText() + ":" + secondsLabel.getText() + "." + centisecondsLabel.getText());
                overalltime1.setText(hoursLabel.getText() + ":" + minutesLabel.getText() + ":" + secondsLabel.getText() + "." + centisecondsLabel.getText());
            } else if (numLaps > 1) {

                switch (numLaps) {
                    case 2 -> {
                        lap2.setText("0" + String.valueOf(numLaps));
                        laptime2.setText(laphoursLabel.getText() + ":" + lapminutesLabel.getText() + ":" + lapsecondsLabel.getText() + "." + lapcentisecondsLabel.getText());
                        overalltime2.setText(hoursLabel.getText() + ":" + minutesLabel.getText() + ":" + secondsLabel.getText() + "." + centisecondsLabel.getText());
                    }
                    case 3 -> {
                        lap3.setText("0" + String.valueOf(numLaps));
                        laptime3.setText(laphoursLabel.getText() + ":" + lapminutesLabel.getText() + ":" + lapsecondsLabel.getText() + "." + lapcentisecondsLabel.getText());
                        overalltime3.setText(hoursLabel.getText() + ":" + minutesLabel.getText() + ":" + secondsLabel.getText() + "." + centisecondsLabel.getText());
                    }
                    case 4 -> {
                        lap4.setText("0" + String.valueOf(numLaps));
                        laptime4.setText(laphoursLabel.getText() + ":" + lapminutesLabel.getText() + ":" + lapsecondsLabel.getText() + "." + lapcentisecondsLabel.getText());
                        overalltime4.setText(hoursLabel.getText() + ":" + minutesLabel.getText() + ":" + secondsLabel.getText() + "." + centisecondsLabel.getText());
                    }
                    case 5 -> {
                        lap5.setText("0" + String.valueOf(numLaps));
                        laptime5.setText(laphoursLabel.getText() + ":" + lapminutesLabel.getText() + ":" + lapsecondsLabel.getText() + "." + lapcentisecondsLabel.getText());
                        overalltime5.setText(hoursLabel.getText() + ":" + minutesLabel.getText() + ":" + secondsLabel.getText() + "." + centisecondsLabel.getText());
                    }
                    case 6 -> {
                        lap6.setText("0" + String.valueOf(numLaps));
                        laptime6.setText(laphoursLabel.getText() + ":" + lapminutesLabel.getText() + ":" + lapsecondsLabel.getText() + "." + lapcentisecondsLabel.getText());
                        overalltime6.setText(hoursLabel.getText() + ":" + minutesLabel.getText() + ":" + secondsLabel.getText() + "." + centisecondsLabel.getText());
                    }
                    case 7 -> {
                        lap7.setText("0" + String.valueOf(numLaps));
                        laptime7.setText(laphoursLabel.getText() + ":" + lapminutesLabel.getText() + ":" + lapsecondsLabel.getText() + "." + lapcentisecondsLabel.getText());
                        overalltime7.setText(hoursLabel.getText() + ":" + minutesLabel.getText() + ":" + secondsLabel.getText() + "." + centisecondsLabel.getText());
                    }
                    case 8 -> {
                        lap8.setText("0" + String.valueOf(numLaps));
                        laptime8.setText(laphoursLabel.getText() + ":" + lapminutesLabel.getText() + ":" + lapsecondsLabel.getText() + "." + lapcentisecondsLabel.getText());
                        overalltime8.setText(hoursLabel.getText() + ":" + minutesLabel.getText() + ":" + secondsLabel.getText() + "." + centisecondsLabel.getText());
                    }
                    case 9 -> {
                        lap9.setText("0" + String.valueOf(numLaps));
                        laptime9.setText(laphoursLabel.getText() + ":" + lapminutesLabel.getText() + ":" + lapsecondsLabel.getText() + "." + lapcentisecondsLabel.getText());
                        overalltime9.setText(hoursLabel.getText() + ":" + minutesLabel.getText() + ":" + secondsLabel.getText() + "." + centisecondsLabel.getText());
                    }
                    case 10 -> {
                        lap10.setText(String.valueOf(numLaps));
                        laptime10.setText(laphoursLabel.getText() + ":" + lapminutesLabel.getText() + ":" + lapsecondsLabel.getText() + "." + lapcentisecondsLabel.getText());
                        overalltime10.setText(hoursLabel.getText() + ":" + minutesLabel.getText() + ":" + secondsLabel.getText() + "." + centisecondsLabel.getText());
                    }
                    default -> {
                    }
                }
                if(numLaps > 10){
                    JOptionPane.showMessageDialog(this,"MAXIMUM NUMBER OF LAPS REACHED!","MESSAGE",INFORMATION_MESSAGE);
                }
                lapcentisecondsLabel.setText("00");
                lapsecondsLabel.setText("00");
                lapminutesLabel.setText("00");
                laphoursLabel.setText("00");
                lapcentiseconds = 0;
                lapseconds = 0;
                lapminutes = 0;
                laphours = 0;
                timer2.start();
            }

        }
    }//GEN-LAST:event_lap_resetButtonActionPerformed

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        MenuPage page = new MenuPage();
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_previousButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Stopwatch sw = new Stopwatch();
        // sw.getHours().setText();

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
            java.util.logging.Logger.getLogger(Stopwatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stopwatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stopwatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stopwatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stopwatch().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel centisecondsLabel;
    private javax.swing.JLabel colon1Label;
    private javax.swing.JLabel colon2Label;
    private javax.swing.JLabel fullStopLabel;
    private javax.swing.JLabel hoursLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lap1;
    private javax.swing.JLabel lap10;
    private javax.swing.JLabel lap2;
    private javax.swing.JLabel lap3;
    private javax.swing.JLabel lap4;
    private javax.swing.JLabel lap5;
    private javax.swing.JLabel lap6;
    private javax.swing.JLabel lap7;
    private javax.swing.JLabel lap8;
    private javax.swing.JLabel lap9;
    private javax.swing.JButton lap_resetButton;
    private javax.swing.JLabel lapcentisecondsLabel;
    private javax.swing.JLabel laphoursLabel;
    private javax.swing.JLabel lapminutesLabel;
    private javax.swing.JLabel lapsecondsLabel;
    private javax.swing.JLabel laptime1;
    private javax.swing.JLabel laptime10;
    private javax.swing.JLabel laptime2;
    private javax.swing.JLabel laptime3;
    private javax.swing.JLabel laptime4;
    private javax.swing.JLabel laptime5;
    private javax.swing.JLabel laptime6;
    private javax.swing.JLabel laptime7;
    private javax.swing.JLabel laptime8;
    private javax.swing.JLabel laptime9;
    private javax.swing.JLabel minutesLabel;
    private javax.swing.JLabel overalltime1;
    private javax.swing.JLabel overalltime10;
    private javax.swing.JLabel overalltime2;
    private javax.swing.JLabel overalltime3;
    private javax.swing.JLabel overalltime4;
    private javax.swing.JLabel overalltime5;
    private javax.swing.JLabel overalltime6;
    private javax.swing.JLabel overalltime7;
    private javax.swing.JLabel overalltime8;
    private javax.swing.JLabel overalltime9;
    private javax.swing.JButton previousButton;
    private javax.swing.JLabel secondsLabel;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
