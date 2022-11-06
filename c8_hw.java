import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
class frame2 extends JFrame implements ListSelectionListener
{
    private JLabel l1=new JLabel("找各地名山");
    private String str="";
    private String str1="";
    JList list=new JList<>();
    int selections[];
    JTextArea jta=new JTextArea(str);
    
    frame2()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("找各地名山");
        setBounds(200, 200, 300, 250);
        setLayout(null);

        String str="可選取地名...";
        jta.setBounds(50, 80, 200, 50);
        jta.setLineWrap(true);  
        jta.setText(str);
        add(jta);
        
        JScrollPane jsp2=new JScrollPane(jta,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jsp2.setBounds(80, 110, 180, 50);
        add(jsp2);

        JLabel lb1=new JLabel(str);
        lb1.setBounds(60,60,80,20);
        add(lb1);

        String[] city={"台北","宜蘭","桃園","台中","彰化","高雄"};
        JList<String> jl1=new JList<>(city);
        jl1.setVisibleRowCount(4);
        jl1.addListSelectionListener(this);

        JScrollPane jsp=new JScrollPane(jl1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jsp.setBounds(150, 10, 100, 80);
        add(jsp);

        setVisible(true);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) 
    {
        // System.out.println(e.getLastIndex());

        boolean adjust = e.getValueIsAdjusting();
        // System.out.println(adjust);
        if(!adjust)
        {
            list = (JList) e.getSource();
            String show="";
            selections = list.getSelectedIndices();
            for (int i = 0, n = selections.length; i < n; i++) 
            {
                str1=String.valueOf(selections[i]);
                System.out.println(str1);
                if(str1.equals("0"))
                    show+="台北名山"+"\n";
                if(str1.equals("1"))
                    show+="宜蘭名山"+"\n";
                if(str1.equals("2"))
                    show+="桃園名山"+"\n";
                if(str1.equals("3"))
                    show+="台中名山"+"\n";
                if(str1.equals("4"))
                    show+="彰化名山"+"\n";
                if(str1.equals("5"))
                    show+="高雄名山"+"\n";
            }
            jta.setText(show);
        }
    }
}
public class c8_hw {
    public static void main(String args[])
    {
        frame2 f = new frame2();
    }
}
