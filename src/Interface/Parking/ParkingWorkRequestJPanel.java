/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Parking;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import Interface.Caruser.schedulerideJPanel;
import com.teamdev.jxbrowser.chromium.internal.ipc.message.SetDefaultZoomLevelMessage;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vivek
 */
public class ParkingWorkRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ParkingWorkRequestJPanel
     */
    JPanel container;
    UserAccount useraccount;
    Organization organization;
    Enterprise enterprise;
    EcoSystem system;
    
    public ParkingWorkRequestJPanel(JPanel container , UserAccount useraccount , Organization organization, Enterprise enterprise, EcoSystem system ) {
        initComponents();
        this.useraccount = useraccount;
        this.container = container;
        this.enterprise = enterprise;
        this.system = system;
        populateTable();
      //  tablecolorchange();
    }

    public void populateTable(){
    DefaultTableModel model = (DefaultTableModel) parkingjTable.getModel();

        model.setRowCount(0);
       // for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()){    
            
        for(WorkRequest request : enterprise.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[3];
            row[0] = request.getSender();
            row[1] = request;
            row[2] = request.getStatus();
            
            model.addRow(row);
        }
        
        parkingjTable.setSelectionBackground(Color.getHSBColor(0.2F, 0.1F, 0.2F));
        parkingjTable.setSelectionForeground(Color.white);
        
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        parkingjTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        parkingjTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        parkingjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sender", "Parking amount", "Parking Status"
            }
        ));
        jScrollPane1.setViewportView(parkingjTable);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Submitblackbutton.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(153, 204, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("Welcome to Smart Parking");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(169, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addGap(57, 57, 57)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton1)
                .addContainerGap(213, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        int selectedRow = parkingjTable.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(this, "Please select a row.","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        WorkRequest request = (WorkRequest)parkingjTable.getValueAt(selectedRow, 1);
        if(request.getStatus().equals("Waiting")){
        //request.getSender().getPerson().setAmount(request.getSender().getPerson().getAmount() - 20);
        request.getSender().setPayment(request.getSender().getPayment() - 20);
        request.setStatus("Completed");
        
        
        JOptionPane.showMessageDialog(this, "Amount credited from User's account");
        try{
        Thread.sleep(2000);
        } catch(Exception r){}
        
        JOptionPane.showMessageDialog(this, "Procedding to the next page for area selection");
        
        inofficeparingJPanel schedule = new inofficeparingJPanel(container,useraccount);
        container.add("schedule a ride", schedule);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);

        }
        else
            JOptionPane.showMessageDialog(this, "The parking is already booked for this request","Error",JOptionPane.ERROR_MESSAGE);
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable parkingjTable;
    // End of variables declaration//GEN-END:variables
}
