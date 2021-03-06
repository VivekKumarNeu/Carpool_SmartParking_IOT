/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.CarOwner;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.CarUserOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.CarUserWorkRequest;
import Business.WorkQueue.WorkRequest;
import Interface.Caruser.Pendingrequest;
import Interface.Parking.ParkingMainJPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vivek
 */
public class CarOwnerMenuPageJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManuPage
     */
    JPanel container;
    UserAccount userAccount;
    Organization organization;
    Enterprise enterprise;
    EcoSystem system;
    int seats;
    int notification=0;
    boolean flag=false;
    boolean flag1=false;
    double temp=0.0;
    static double carrent=0.0;
    HashMap<String,Object> carsource = new HashMap<>();
    
    public CarOwnerMenuPageJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,EcoSystem system) {
        initComponents();
        this.setSize(600, 600);
        carsource = organization.getsourcedestinationBoston();
        this.container = userProcessContainer;
        this.userAccount = account;
        this.organization = organization;
        this.enterprise = enterprise;
        this.system = system;
        adminnamejLabel.setText(userAccount.toString());
        newrequest();
        populatecartypecombobox();
        populateRequestTable();
        populatesourcecombobox();
        populatedestinationcombobox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    
    public void populatesourcecombobox(){
        Object destobj=null;
        if(flag1)
        destobj = (Object) destinationjComboBox.getSelectedItem();
        Object sourobj = (Object) Sourcecombobox.getSelectedItem();
        
        Sourcecombobox.removeAllItems();
        
        Set set = carsource.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
        Map.Entry mentry = (Map.Entry)iterator.next();
            Sourcecombobox.addItem(mentry.getKey());  
        }
        if(flag1)
        Sourcecombobox.setSelectedItem(destobj);
        flag1=true;
    }
    
    public void populatedestinationcombobox(){
        Object destobj=null;
        if(flag)
        destobj = (Object) destinationjComboBox.getSelectedItem();
        Object sourobj = (Object) Sourcecombobox.getSelectedItem();
        destinationjComboBox.removeAllItems();
        
        Set set = carsource.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
        Map.Entry mentry = (Map.Entry)iterator.next();
        Object strr = (Object) Sourcecombobox.getSelectedItem();
        if(!mentry.getKey().equals(strr.toString()))
            destinationjComboBox.addItem(mentry.getKey());  
        } 
        if(flag)
        destinationjComboBox.setSelectedItem(destobj);
        flag=true;
    }
    
    public void updatvalue()
    {
    rideamountjLabel.setText(String.valueOf(temp));
    }

    public void newrequest()
        {
            for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
                if(request.getStatus().equals("Waiting"))
                        notification++;
                    }
        notificationJLabel.setText(String.valueOf(notification));
    }
    
    
    public void populateRequestTable(){
        DefaultTableModel model = (DefaultTableModel) adminrequestjTable.getModel();
        
        
        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()){
        //    if(request instanceof CarUserWorkRequest){
            if(request instanceof CarUserWorkRequest){
            Object[] row = new Object[8];
            row[0] = request;
            row[1] = request.getSender();
            row[2] = request.getReceiver();
            row[3] = request.getSource();
            row[4] = request.getDestination();
            row[5] = request.getRequestDate();
            //String result = ((CarUserWorkRequest) request).getTestResult();
            row[6] = request.getseats() == 0 ? "Completed" : "Waiting";
            
            //row[6] = request.getStatus() == null ? "Waiting" : "Completed";
            row[7] = request.getcomment();
            model.addRow(row);
            
            
            }
        }
         adminrequestjTable.setSelectionBackground(Color.getHSBColor(0.2F, 0.1F, 0.2F));
        adminrequestjTable.setSelectionForeground(Color.white);
    }
    
    
    
    public void populatecartypecombobox()
    {
        HashMap<String,Integer> cartype = new HashMap<String,Integer>();
        cartype.put("Nisaan Rogue",6);
        cartype.put("Nisaan Chevrolet",4);
        cartype.put("Versa",2);
        cartype.put("Ford Fiesta",4);
        cartype.put("Toyota corolla",5);
        cartype.put("Honda Civic",3);
        cartype.put("GMC Canyon",2);
        cartype.put("Chevrolet silverado",4);

        cartypesjComboBox.removeAllItems();
        
        Set set = cartype.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
        Map.Entry mentry = (Map.Entry)iterator.next();
        cartypesjComboBox.addItem(mentry.getKey());         
      }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        adminnamejLabel = new javax.swing.JLabel();
        accomodatejLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cartypesjComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        requestjButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        adminrequestjTable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        commentjTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        notificationJLabel = new javax.swing.JLabel();
        Sourcecombobox = new javax.swing.JComboBox();
        destinationjComboBox = new javax.swing.JComboBox();
        estimatedpricejButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        seatsbookedjLabel = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        rideamountjLabel = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        userlistjComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("List of users :");
        add(jLabel1);
        jLabel1.setBounds(490, 200, 130, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Car Owner");
        add(jLabel2);
        jLabel2.setBounds(290, 30, 220, 50);

        adminnamejLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        adminnamejLabel.setForeground(new java.awt.Color(255, 255, 255));
        adminnamejLabel.setText("adminname");
        add(adminnamejLabel);
        adminnamejLabel.setBounds(130, 40, 80, 20);

        accomodatejLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        accomodatejLabel.setForeground(new java.awt.Color(255, 255, 255));
        accomodatejLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accomodatejLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(204, 204, 204)));
        add(accomodatejLabel);
        accomodatejLabel.setBounds(180, 340, 40, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Ride details");
        add(jLabel5);
        jLabel5.setBounds(320, 230, 140, 40);

        cartypesjComboBox.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cartypesjComboBox.setForeground(new java.awt.Color(255, 255, 255));
        cartypesjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cartypesjComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartypesjComboBoxActionPerformed(evt);
            }
        });
        add(cartypesjComboBox);
        cartypesjComboBox.setBounds(180, 290, 100, 22);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Car Type");
        add(jLabel6);
        jLabel6.setBounds(70, 260, 80, 70);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Comments");
        add(jLabel7);
        jLabel7.setBounds(440, 390, 100, 40);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Accomodate");
        add(jLabel8);
        jLabel8.setBounds(70, 330, 90, 50);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Source");
        add(jLabel9);
        jLabel9.setBounds(440, 280, 100, 40);

        requestjButton.setBackground(new java.awt.Color(255, 255, 255));
        requestjButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        requestjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Submitblackbutton.png"))); // NOI18N
        requestjButton.setBorder(null);
        requestjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestjButtonActionPerformed(evt);
            }
        });
        add(requestjButton);
        requestjButton.setBounds(340, 460, 90, 40);

        adminrequestjTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        adminrequestjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Car", "Sender", "Last Receiver", "Source", "Destination", "Request Date", "Status", "Comments"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        adminrequestjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminrequestjTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(adminrequestjTable);

        add(jScrollPane1);
        jScrollPane1.setBounds(50, 90, 720, 110);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Destination");
        add(jLabel10);
        jLabel10.setBounds(440, 330, 100, 50);
        add(commentjTextField);
        commentjTextField.setBounds(540, 400, 200, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Appointment Reminders-50.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        add(jLabel4);
        jLabel4.setBounds(680, 10, 50, 40);

        notificationJLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        notificationJLabel.setForeground(new java.awt.Color(255, 255, 153));
        notificationJLabel.setText("<val>");
        notificationJLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notificationJLabelMouseClicked(evt);
            }
        });
        add(notificationJLabel);
        notificationJLabel.setBounds(730, 10, 50, 40);

        Sourcecombobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Sourcecombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SourcecomboboxActionPerformed(evt);
            }
        });
        add(Sourcecombobox);
        Sourcecombobox.setBounds(540, 290, 130, 22);

        destinationjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        destinationjComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinationjComboBoxActionPerformed(evt);
            }
        });
        add(destinationjComboBox);
        destinationjComboBox.setBounds(540, 340, 130, 22);

        estimatedpricejButton.setBackground(new java.awt.Color(255, 255, 255));
        estimatedpricejButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        estimatedpricejButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dollarsign.png"))); // NOI18N
        estimatedpricejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estimatedpricejButtonActionPerformed(evt);
            }
        });
        add(estimatedpricejButton);
        estimatedpricejButton.setBounds(220, 400, 40, 40);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Ride Amount");
        add(jLabel11);
        jLabel11.setBounds(70, 410, 100, 30);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Businessman-50.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        add(jLabel12);
        jLabel12.setBounds(630, 10, 40, 40);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Logged in:");
        add(jLabel14);
        jLabel14.setBounds(30, 30, 100, 40);

        seatsbookedjLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        seatsbookedjLabel.setForeground(new java.awt.Color(255, 255, 255));
        add(seatsbookedjLabel);
        seatsbookedjLabel.setBounds(220, 210, 80, 20);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Paid Parking-50.png"))); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        add(jLabel16);
        jLabel16.setBounds(590, 10, 50, 40);

        rideamountjLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rideamountjLabel.setForeground(new java.awt.Color(255, 255, 255));
        rideamountjLabel.setText("0.0");
        add(rideamountjLabel);
        rideamountjLabel.setBounds(180, 414, 30, 20);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Seats remaining :");
        add(jLabel13);
        jLabel13.setBounds(50, 200, 170, 40);

        userlistjComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userlistjComboBoxActionPerformed(evt);
            }
        });
        add(userlistjComboBox);
        userlistjComboBox.setBounds(630, 210, 80, 22);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/carowner.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.setEnabled(false);
        add(jLabel3);
        jLabel3.setBounds(0, 0, 800, 550);
    }// </editor-fold>//GEN-END:initComponents

    private void cartypesjComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartypesjComboBoxActionPerformed
        HashMap<String,Integer> cartype = new HashMap<String,Integer>();
        cartype.put("Nisaan Rogue",6);
        cartype.put("Nisaan Chevrolet",4);
        cartype.put("Versa",2);
        cartype.put("Ford Fiesta",4);
        cartype.put("Toyota corolla",5);
        cartype.put("Honda Civic",3);
        cartype.put("GMC Canyon",2);
        cartype.put("Chevrolet silverado",4);

        Object strr = (Object) cartypesjComboBox.getSelectedItem();
        if(strr == null)
                return;
        accomodatejLabel.setText(cartype.get(strr).toString());  
        seats = (Integer) cartype.get(strr);
    }//GEN-LAST:event_cartypesjComboBoxActionPerformed

    private void requestjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestjButtonActionPerformed

        Object strr = (Object) cartypesjComboBox.getSelectedItem();
        Object source = (Object) Sourcecombobox.getSelectedItem();
        Object destination = (Object) destinationjComboBox.getSelectedItem();
        
        if(destination == null)
        {
          JOptionPane.showMessageDialog(this, "Please select a destination");
          return;
        }
        
        CarUserWorkRequest request = new CarUserWorkRequest();
        request.setSender(userAccount);
        request.setcar(strr.toString());
        request.setRequestDate(new Date());
        request.setSource(source.toString());
        request.setDestination(destination.toString());
        request.setcomment(commentjTextField.getText());
        request.setseats(seats);
        request.setRideamount(Double.parseDouble(rideamountjLabel.getText()));
        
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof CarUserOrganization){
                org = organization;
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
            userAccount.getWorkQueue().getWorkRequestList().add(request);
        }
        populateRequestTable();
        clearfields();
    }//GEN-LAST:event_requestjButtonActionPerformed

    private void notificationJLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationJLabelMouseClicked
        
        Pendingrequest schedule = new Pendingrequest(container,userAccount,organization);
        container.add("Confirm ride", schedule);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);

        
    }//GEN-LAST:event_notificationJLabelMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        
        Pendingrequest schedule = new Pendingrequest(container,userAccount,organization);
        container.add("Confirm ride", schedule);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
        
    }//GEN-LAST:event_jLabel4MouseClicked

    private void SourcecomboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SourcecomboboxActionPerformed
            
    }//GEN-LAST:event_SourcecomboboxActionPerformed

    private void destinationjComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinationjComboBoxActionPerformed
        
        populatedestinationcombobox();
//       Object sourobj = (Object) Sourcecombobox.getSelectedItem();
//        
//        Set set = carsource.entrySet();
//        Iterator iterator = set.iterator();
//        while(iterator.hasNext()) {
//        Map.Entry mentry = (Map.Entry)iterator.next();
//        if(!mentry.getKey().equals(sourobj.toString()))
//             destinationjComboBox.addItem(mentry.getKey());     
//        }
    }//GEN-LAST:event_destinationjComboBoxActionPerformed

    private void estimatedpricejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estimatedpricejButtonActionPerformed
        
        try{
        Object sourobj = (Object) Sourcecombobox.getSelectedItem();
        Object destobj = (Object) destinationjComboBox.getSelectedItem();
        
        
        Estimatedprice priceest = new Estimatedprice(container,userAccount,organization,sourobj,destobj,this);
        container.add("Price estimate", priceest);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Please select a valid destination");
        }
    }//GEN-LAST:event_estimatedpricejButtonActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        
        Userprofile priceest = new Userprofile(container,userAccount);
        container.add("user profile", priceest);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
        
        
    }//GEN-LAST:event_jLabel12MouseClicked

    private void adminrequestjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminrequestjTableMouseClicked
        
        int selectedRow = adminrequestjTable.getSelectedRow();
         
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(this, "Please select a row.","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        WorkRequest request = (WorkRequest)adminrequestjTable.getValueAt(selectedRow, 0);
        
        HashMap<String,Integer> cartype = new HashMap<String,Integer>();
        cartype.put("Nisaan Rogue",6);
        cartype.put("Nisaan Chevrolet",4);
        cartype.put("Versa",2);
        cartype.put("Ford Fiesta",4);
        cartype.put("Toyota corolla",5);
        cartype.put("Honda Civic",3);
        cartype.put("GMC Canyon",2);
        cartype.put("Chevrolet silverado",4);
        
        
//        seatsbookedjLabel.setText(String.valueOf(totalseatsleft));
            seatsbookedjLabel.setText(String.valueOf(request.getseats()));

            setuserlistcombobox();
            
            
    }//GEN-LAST:event_adminrequestjTableMouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        
        
       try{
      int selectedRow =  adminrequestjTable.getSelectedRow();
        
      if (selectedRow < 0){
            JOptionPane.showMessageDialog(this, "Please select a row to look for parking.","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        WorkRequest request = (WorkRequest)adminrequestjTable.getValueAt(selectedRow, 0);
        
        if(request.getStatus().equals("Completed"))
        {
        ParkingMainJPanel priceest = new ParkingMainJPanel(container,userAccount,(CarUserWorkRequest)request,enterprise,system);
        container.add("Parking", priceest);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
        }
        else
        {
        JOptionPane.showMessageDialog(this, "Trip has not completed yet.");
                
        }
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(this, "Trip has not completed yet.");
       }
      
    }//GEN-LAST:event_jLabel16MouseClicked

    private void userlistjComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userlistjComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userlistjComboBoxActionPerformed

    public void clearfields()
    {
        commentjTextField.setText("");
        rideamountjLabel.setText("0.0");
    }
    
    public void setuserlistcombobox()
    {
        int selectedRow = adminrequestjTable.getSelectedRow();
      
        WorkRequest request = (WorkRequest)adminrequestjTable.getValueAt(selectedRow, 0);
        userlistjComboBox.removeAllItems();
         for(UserAccount ua : ((CarUserWorkRequest) request).getUserlist())
               userlistjComboBox.addItem(ua);
    }
    
    
    
//    public void setcarrentamount(Double x){
//    rideamountjLabel1.setText(x.toString());
//    JOptionPane.showMessageDialog(this, rideamountjLabel1.getText());
//    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Sourcecombobox;
    private javax.swing.JLabel accomodatejLabel;
    private javax.swing.JLabel adminnamejLabel;
    private javax.swing.JTable adminrequestjTable;
    private javax.swing.JComboBox cartypesjComboBox;
    private javax.swing.JTextField commentjTextField;
    private javax.swing.JComboBox destinationjComboBox;
    private javax.swing.JButton estimatedpricejButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel notificationJLabel;
    private javax.swing.JButton requestjButton;
    private javax.swing.JLabel rideamountjLabel;
    private javax.swing.JLabel seatsbookedjLabel;
    private javax.swing.JComboBox userlistjComboBox;
    // End of variables declaration//GEN-END:variables
}
