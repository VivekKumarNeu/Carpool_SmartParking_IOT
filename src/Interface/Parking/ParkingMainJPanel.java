/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Parking;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import static Business.Enterprise.Enterprise.EnterpriseType.Parking;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.ParkingOrganization;
import Business.Organization.TechnicalPersonOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.CarUserWorkRequest;
import Business.WorkQueue.ParkingPersonWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Vivek
 */
public class ParkingMainJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ParkingMainJPanel
     */
    JPanel container;
    UserAccount useraccount;
    CarUserWorkRequest caradminrequest;
    Enterprise enterprise;
    EcoSystem system;
    boolean markup = false;
    boolean flag = true;
    ArrayList<Date> parkinghistory;
    
    
    public ParkingMainJPanel(JPanel container,UserAccount useraccount,CarUserWorkRequest request,Enterprise enterprise,EcoSystem system) {
        initComponents();
        this.container = container;
        this.useraccount = useraccount;
        this.enterprise = enterprise;
        this.system = system;
        this.caradminrequest = request;
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
        officeparkingbutton = new javax.swing.JButton();
        outsideparkingbutton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("Parking");

        officeparkingbutton.setBackground(new java.awt.Color(0, 0, 0));
        officeparkingbutton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        officeparkingbutton.setForeground(new java.awt.Color(255, 255, 255));
        officeparkingbutton.setText("Indoor parking");
        officeparkingbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                officeparkingbuttonActionPerformed(evt);
            }
        });

        outsideparkingbutton.setBackground(new java.awt.Color(0, 0, 0));
        outsideparkingbutton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        outsideparkingbutton.setForeground(new java.awt.Color(255, 255, 255));
        outsideparkingbutton.setText("NearBy parking");
        outsideparkingbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outsideparkingbuttonActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(outsideparkingbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(officeparkingbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(286, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addGap(91, 91, 91)
                .addComponent(officeparkingbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(outsideparkingbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jButton1)
                .addContainerGap(49, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void officeparkingbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_officeparkingbuttonActionPerformed

     for(Network network : system.getNetworkList())
        for(Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList())
           if(ent.getEnterpriseType().toString().equals("Parking")){
                   for (WorkRequest wrequest : ent.getWorkQueue().getWorkRequestList())
                       if(((ParkingPersonWorkRequest) wrequest).getParkingdate().contains(caradminrequest.getRequestDate()))
                        {  JOptionPane.showMessageDialog(this, "You have already raised a request for parking.");
                            flag = false;
                        }
                   
                   if(flag){
                            ParkingPersonWorkRequest request = new ParkingPersonWorkRequest();
                            request.setSender(useraccount);
                            request.setParkingamount(20.0);
                            request.setStatus("Waiting");
                           ((ParkingPersonWorkRequest) request).setParkingdate(caradminrequest.getRequestDate());
               
                JOptionPane.showMessageDialog(this, "Parking request initiated");
       Enterprise entt = null;
       for(Network networkc : system.getNetworkList())
            for(Enterprise entc : networkc.getEnterpriseDirectory().getEnterpriseList())
                    if(entc.getEnterpriseType().toString().equals("Parking"))
                    {
                      entt = entc;  
                    }
        if (entt!=null){
            entt.getWorkQueue().getWorkRequestList().add(request);
            useraccount.getWorkQueue().getWorkRequestList().add(request);
                        }
                            }
                                                                      }    
                  // }
                       
/*                       
                       
                       
        for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList())
            if(org instanceof ParkingOrganization)
                for(WorkRequest workr : org.getWorkQueue().getWorkRequestList())
                   if(workr instanceof ParkingPersonWorkRequest){
                       if(((ParkingPersonWorkRequest) workr).getParkingdate().contains(caradminrequest.getRequestDate()))
                       {  JOptionPane.showMessageDialog(this, "You have already raised a request for parking.");
                       } else{
                            ParkingPersonWorkRequest request = new ParkingPersonWorkRequest();
                            request.setSender(useraccount);
                            request.setParkingamount(20.0);
                            request.setStatus("Waiting");
                           ((ParkingPersonWorkRequest) workr).setParkingdate(caradminrequest.getRequestDate());
        
                       Organization orgq = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof ParkingOrganization){
                orgq = organization;
                break;
            }
        }
        if (orgq!=null){
            orgq.getWorkQueue().getWorkRequestList().add(request);
            useraccount.getWorkQueue().getWorkRequestList().add(request);
        }
        
        JOptionPane.showMessageDialog(this, "Request for parking is initiated","Information",JOptionPane.INFORMATION_MESSAGE);
        return;
        }
        return;
                   }
                ParkingPersonWorkRequest request = new ParkingPersonWorkRequest();
                            request.setSender(useraccount);
                            request.setParkingamount(20.0);
                            request.setStatus("Waiting");
                            request.setParkingdate(caradminrequest.getRequestDate());
        
                       Organization orgq = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof ParkingOrganization){
                orgq = organization;
                break;
            }
        }
        if (orgq!=null){
            orgq.getWorkQueue().getWorkRequestList().add(request);
            useraccount.getWorkQueue().getWorkRequestList().add(request);
        }
        
        JOptionPane.showMessageDialog(this, "Request for parking is initiated","Information",JOptionPane.INFORMATION_MESSAGE);

        
                   }
        
        
        */
    }//GEN-LAST:event_officeparkingbuttonActionPerformed

    private void outsideparkingbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outsideparkingbuttonActionPerformed
        
        NearbyParking schedule = new NearbyParking(container);
        container.add("inofficeparking", schedule);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
        
        
    }//GEN-LAST:event_outsideparkingbuttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton officeparkingbutton;
    private javax.swing.JButton outsideparkingbutton;
    // End of variables declaration//GEN-END:variables
}