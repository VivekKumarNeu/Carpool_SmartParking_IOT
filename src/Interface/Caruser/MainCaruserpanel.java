/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Caruser;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.CarUserOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.CarUserWorkRequest;
import Business.WorkQueue.WorkRequest;
import Interface.CarOwner.Userprofile;
import Interface.Help.RatingJPanel;
import Interface.TechSupport.Causerbugreport;
//import static Interface.Caruser.MainCaruserpanel.usersetseat;
import java.awt.CardLayout;
import java.awt.Color;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vivek
 */
public class MainCaruserpanel extends javax.swing.JPanel {

    /**
     * Creates new form MainCaruserpanel
     */
    JPanel container;
    UserAccount userAccount;
    CarUserOrganization organization;
    Enterprise enterprise;
    EcoSystem system;
    public static ArrayList<WorkRequest> usersetseat = new ArrayList<>();
    public static HashMap<WorkRequest,UserAccount> checkseatbook = new HashMap<>();
    
    
    public MainCaruserpanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,EcoSystem system) {
        initComponents();
        this.setSize(450, 500);
        this.container = userProcessContainer;
        this.userAccount = account;
        this.organization = (CarUserOrganization) organization;
        this.enterprise = enterprise;
        this.system = system;
        adminnamejLabel.setText(account.getPerson().getPersonName());
        
        populateTable();
    }

    public void populateTable(){
    DefaultTableModel model = (DefaultTableModel) caruserjTable.getModel();

    
    
        model.setRowCount(0);
       // for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()){
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()){    
        Object[] row = new Object[9];
            row[0] = request;
            row[1] = request.getseats();
            row[2] = request.getSender();
            row[3] = request.getReceiver();
            row[4] = request.getSource();
            row[5] = request.getDestination();
            row[6] = ((CarUserWorkRequest) request).getRideamount();
            Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            row[7] = formatter.format(request.getRequestDate());
            row[8] = request.getcomment();
            model.addRow(row);
        }
        caruserjTable.setSelectionBackground(Color.getHSBColor(0.2F, 0.1F, 0.2F));
        caruserjTable.setSelectionForeground(Color.white);
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        adminnamejLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        caruserjTable = new javax.swing.JTable();
        takeridejButton = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Car user Page");
        add(jLabel2);
        jLabel2.setBounds(240, 50, 270, 60);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Logged in:");
        add(jLabel3);
        jLabel3.setBounds(30, 30, 100, 40);

        adminnamejLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        adminnamejLabel.setForeground(new java.awt.Color(255, 255, 255));
        adminnamejLabel.setText("adminname");
        add(adminnamejLabel);
        adminnamejLabel.setBounds(130, 40, 80, 20);

        caruserjTable.setBackground(new java.awt.Color(153, 204, 255));
        caruserjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Car", "Seats", "Car Owner", "Last Receiver", "Source", "Destination", "Ride Cost", "Date", "Comment"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        caruserjTable.setOpaque(false);
        jScrollPane1.setViewportView(caruserjTable);

        add(jScrollPane1);
        jScrollPane1.setBounds(40, 110, 690, 130);

        takeridejButton.setBackground(new java.awt.Color(255, 255, 255));
        takeridejButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        takeridejButton.setText("Take ride ");
        takeridejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takeridejButtonActionPerformed(evt);
            }
        });
        add(takeridejButton);
        takeridejButton.setBounds(70, 280, 140, 40);

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("Cancel ride");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4);
        jButton4.setBounds(70, 360, 140, 40);

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setText("Schedule ride");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        add(jButton5);
        jButton5.setBounds(500, 320, 210, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Businessman-50.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        add(jLabel4);
        jLabel4.setBounds(620, 20, 40, 40);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Insect.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        add(jLabel5);
        jLabel5.setBounds(670, 20, 40, 40);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Christmas Star-50.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        add(jLabel13);
        jLabel13.setBounds(570, 20, 50, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/caruser1.jpg"))); // NOI18N
        jLabel1.setEnabled(false);
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1050, 650);
    }// </editor-fold>//GEN-END:initComponents

    private void takeridejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takeridejButtonActionPerformed
        
        int selectedRow = caruserjTable.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(this, "Please select a row.","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        WorkRequest request = (WorkRequest)caruserjTable.getValueAt(selectedRow, 0);
        Integer seatnumbers = (Integer)caruserjTable.getValueAt(selectedRow, 1);
       

        if(request.getseats() != 0){
          
        if(checkseatbook.containsKey(request) && checkseatbook.containsValue(userAccount))
        {
            JOptionPane.showMessageDialog(this, "The request is already set","",JOptionPane.ERROR_MESSAGE);
            return;}
        else{
            
        //userAccount.setPayment(userAccount.getPayment() - ((CarUserWorkRequest) request).getRideamount());
        //request.getSender().setPayment(request.getSender().getPayment() + ((CarUserWorkRequest) request).getRideamount());
        
        userAccount.setPayment(userAccount.getPayment() - ((CarUserWorkRequest) request).getRideamount());
        request.getSender().setPayment(request.getSender().getPayment() + ((CarUserWorkRequest) request).getRideamount());
            
            
        checkseatbook.put(request,userAccount);
        caruserjTable.setEnabled(true);

        request.setReceiver(userAccount);
        request.setStatus("Completed");
        /**/
        userAccount.setTrips(true);
        request.getSender().setTrips(true);
        request.setseats(seatnumbers-1);
        
        /**/
        ((CarUserWorkRequest) request).setUserlist(userAccount);
        
        /**/
        
        JOptionPane.showMessageDialog(this, "Seat is booked","",JOptionPane.INFORMATION_MESSAGE);
        }}
        else{
            JOptionPane.showMessageDialog(this, "There are no seats available","",JOptionPane.WARNING_MESSAGE);
        }
        populateTable();
        
    }//GEN-LAST:event_takeridejButtonActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
    int selectedRow = caruserjTable.getSelectedRow();
    if(selectedRow < 0)
    {
        JOptionPane.showMessageDialog(this, "Please select a row","Error",JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    WorkRequest request = (WorkRequest)caruserjTable.getValueAt(selectedRow, 0);
    Integer seatnumbers = (Integer)caruserjTable.getValueAt(selectedRow, 1);

    if(checkseatbook.containsKey(request) && checkseatbook.containsValue(userAccount))
    {
            request.setseats(seatnumbers+1);
            checkseatbook.remove(request);
            request.setStatus("Waiting");
            request.setReceiver(null);
            userAccount.setTrips(false);
            request.getSender().setTrips(false);
            ((CarUserWorkRequest) request).setMaxrides(false);
            userAccount.setPayment(userAccount.getPayment() + ((CarUserWorkRequest) request).getRideamount());
            request.getSender().setPayment(request.getSender().getPayment() - ((CarUserWorkRequest) request).getRideamount());
            
            
            JOptionPane.showMessageDialog(this, "Your booking is canceled.","",JOptionPane.INFORMATION_MESSAGE);
    }else{
            JOptionPane.showMessageDialog(this, "You have no booking for this car.");
    }
    
    populateTable();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
                
        schedulerideJPanel schedule = new schedulerideJPanel(container,userAccount,enterprise,organization);
        container.add("schedule a ride", schedule);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
        
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        
        Userprofile priceest = new Userprofile(container,userAccount);
        container.add("user profile", priceest);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);

        
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        
        Causerbugreport schedule = new Causerbugreport(container,userAccount,enterprise,organization,system);
        container.add("d", schedule);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);

    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked

        RatingJPanel priceest = new RatingJPanel(container,userAccount,enterprise);
        container.add("Parking", priceest);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);

    }//GEN-LAST:event_jLabel13MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminnamejLabel;
    private javax.swing.JTable caruserjTable;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton takeridejButton;
    // End of variables declaration//GEN-END:variables
}
