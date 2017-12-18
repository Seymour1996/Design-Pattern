/* DataWindow.java */
import java.awt.*;
import javax.swing.JFrame;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;


public class DataWindow extends JFrame {

    private static final int MAX_SAMPLES = 10000;
    private int index = 0;
    private long[] time = new long[MAX_SAMPLES];
    private double[] val = new double[MAX_SAMPLES];
    DateFormat fmt = DateFormat.getDateTimeInstance();

    /** Creates new form DataWindow */
    public DataWindow() {
        initComponents();
    }

    public DataWindow(String ieee) {
        initComponents();
        setTitle(ieee);
    }

    public void addData(long t, double v,double begin,double low,double high) {
        time[index] = t;
        val[index++] = v;
        String format0=String.format("%.2f",v);
        String format1=String.format("%.2f",begin);
        String format2=String.format("%.2f",low);
        String format3=String.format("%.2f",high);
        dataTextArea.append(fmt.format(new Date(t)) + "    当前价 = " + format0 + "\n");
        if(v>1.1*begin) dataTextArea.append("股票涨停!");
        if(v<0.9*begin) dataTextArea.append("股票跌停!");
        dataTextArea.setCaretPosition(dataTextArea.getText().length());
        double percent;
        if(v-begin>=0)
            {
                percent = (v - begin) / begin*100;
                String format4=String.format("%.2f",percent);
                jprice.setText(format0 + " +" + format4 + "%  ");
            }
        else
            {
                percent = (begin - v) / begin*100;
                String format4=String.format("%.2f",percent);
                jprice.setText(format0 + " -" + format4 + "%  ");
            }

        jbegin.setText("开盘:"+format1+" ");
        jlow.setText("最低:"+format2+" ");
        jhigh.setText("最高:"+format3);
        repaint();
    }

    // Graph the sensor values in the dataPanel JPanel
    public void paint(Graphics g) {
        super.paint(g);
        int left = dataPanel.getX() + 10;       // get size of pane
        int top = dataPanel.getY() + 30;
        int right = left + dataPanel.getWidth() - 20;
        int bottom = top + dataPanel.getHeight() - 20;

        int y0 = bottom - 20;                   // leave some room for margins
        int yn = top;
        int x0 = left + 33;
        int xn = right;
        double vscale = (yn - y0) / 4.0;      // light values range from 0 to 800
        double tscale = 1.0 / 2000.0;           // 1 pixel = 2 seconds = 2000 milliseconds

        // draw X axis = time
        g.setColor(Color.BLACK);
        g.drawLine(x0, yn, x0, y0);
        g.drawLine(x0, y0, xn, y0);
        int tickInt = 60 / 2;
        for (int xt = x0 + tickInt; xt < xn; xt += tickInt) {   // tick every 1 minute
            g.drawLine(xt, y0 + 5, xt, y0 - 5);
            int min = (xt - x0) / (60 / 2);
            g.drawString(Integer.toString(min), xt - (min < 10 ? 3 : 7) , y0 + 20);
        }

        // draw Y axis = sensor reading
        g.setColor(Color.BLUE);
        for (int vt = 16; vt >= 13; vt -=1 ) {         // tick every 200
            int v = y0 + (int)((vt-13) * vscale);
            g.drawLine(x0 - 1, v, x0 + 1, v);
            g.drawString(Integer.toString(vt), x0 - 20 , v + 5);
        }

        // graph sensor values
        int xp = -1;
        int vp = -1;
        for (int i = 0; i < index; i++) {
            int x = x0 + (int)((time[i] - time[0]) * tscale);
            int v = y0 + (int)((val[i]-13) * vscale);
            if (xp > 0) {
                g.drawLine(xp, vp, x, v);
            }
            xp = x;
            vp = v;
        }
    }
public void setPriceColor(boolean t){
        if(t==true)      jprice.setForeground(new java.awt.Color(255,41,30));
        else       jprice.setForeground(new java.awt.Color(5, 255, 21));
}
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // //GEN-BEGIN:initComponents
    private void initComponents() {
        this.setTitle("股票分析软件");
        dataPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTextArea = new javax.swing.JTextArea();
        labelPanel=new javax.swing.JPanel();
        jprice=new javax.swing.JLabel();
        jbegin=new javax.swing.JLabel();
        jhigh=new javax.swing.JLabel();
        jlow=new javax.swing.JLabel();
        jbegin.setMinimumSize(new java.awt.Dimension(30, 30));
        jbegin.setMaximumSize(new java.awt.Dimension(30, 30));
        jbegin.setFont(new Font("宋体",Font.BOLD, 20));
        jbegin.setForeground(new java.awt.Color(0, 0, 0));

        jlow.setMinimumSize(new java.awt.Dimension(30, 30));
        jlow.setMaximumSize(new java.awt.Dimension(30, 30));
        jlow.setFont(new Font("宋体",Font.BOLD, 20));
        jlow.setForeground(new java.awt.Color(5, 255, 21));

        jhigh.setMinimumSize(new java.awt.Dimension(30, 30));
        jhigh.setMaximumSize(new java.awt.Dimension(30, 30));
        jhigh.setFont(new Font("宋体",Font.BOLD, 20));
        jhigh.setForeground(new java.awt.Color(255,41,30));

        jprice.setMinimumSize(new java.awt.Dimension(30, 30));
        jprice.setMaximumSize(new java.awt.Dimension(30, 30));
        jprice.setFont(new Font("宋体",Font.BOLD, 30));
        //getContentPane().add(jprice, BorderLayout.NORTH);
        labelPanel.add(jprice);
        labelPanel.add(jbegin);
        labelPanel.add(jlow);
        labelPanel.add(jhigh);
        labelPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        getContentPane().add(labelPanel, BorderLayout.NORTH);
        dataPanel.setBackground(new java.awt.Color(255, 255, 255));
        labelPanel.setBackground(new java.awt.Color(255, 255, 255));
        dataPanel.setMinimumSize(new java.awt.Dimension(700, 300));
        dataPanel.setPreferredSize(new java.awt.Dimension(700, 300));
        getContentPane().add(dataPanel, java.awt.BorderLayout.CENTER);

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setMinimumSize(new java.awt.Dimension(400, 100));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(400, 100));

        dataTextArea.setColumns(20);
        dataTextArea.setEditable(false);
        dataTextArea.setRows(4);
        jScrollPane1.setViewportView(dataTextArea);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.SOUTH);

        pack();
    }// //GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel dataPanel;
    private javax.swing.JPanel labelPanel;
    private javax.swing.JTextArea dataTextArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jprice;
    private javax.swing.JLabel jbegin;
    private javax.swing.JLabel jlow;
    private javax.swing.JLabel jhigh;
    // End of variables declaration//GEN-END:variables

}