package com.coms360.batch;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CustomerBusinessEventProcesser {
	
	//private static final String DB_CONNECTION = "jdbc:oracle:thin:@oradbq70:9270:crbqa101";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@172.21.102.41:9270:crbqa101";
	
	//private static final String DB_CONNECTION = "jdbc:oracle:thin:@crbqa101.intranet.local:9270:crbqa101";
	
	//private static final String DB_CONNECTION = "jdbc:oracle:thin:@oradbq70.intranet.local:9270:crbqa101";
	//oradbq70.intranet.local
	//172.21.102.41
	//172.21.102.41
	
	
	
	private static final String DB_USER = "AIUGXJ3";
	private static final String DB_PASSWORD = "welcome123";
	
	//private static final String DB_CONNECTION = "jdbc:oracle:thin:@oradbq70:9270:crbqa101";
		//private static final String DB_CONNECTION = "jdbc:oracle:thin:@172.21.102.41:9270:crbqa101";
		
   //private static final String DB_CONNECTION = "jdbc:oracle:thin:@crbqa101.intranet.local:9270:crbqa101";
		
		//private static final String DB_CONNECTION = "jdbc:oracle:thin:@oradbq70.intranet.local:9270:crbqa101";
	
    public static void main(String[] args) throws ClassNotFoundException, IOException {
    	Class.forName("oracle.jdbc.OracleDriver");
    	String sql = "SELECT CAMP_ID,CAMP_NAME,CAMP_CON_STATUS,GLOBAL_IMC_ID,"
    			+ "CHANNEL_TYPE,SUB_CHANNEL_TYPE,SYSDATE,LAUNCH_TS FROM "
    			+ "Sbl36001.Rmt00050_Cmp_Bus_Event_Stg where camp_id='1-8W9JOU'";
    	 Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
    	 
    	  AWSCredentials credentials = null;
          try {
              credentials = new ProfileCredentialsProvider("default").getCredentials();
          } catch (Exception e) {
              throw new AmazonClientException("");
          }
    	 
    	 AmazonS3 s3 = AmazonS3ClientBuilder.standard()
    	            .withCredentials(new AWSStaticCredentialsProvider(credentials)).build();
    	ArrayList<CustomerBusinessEvent> cbeList=new ArrayList<CustomerBusinessEvent>();
    	try (Connection con = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
    	         PreparedStatement ps = con.prepareStatement(sql)) {
    		System.out.println("print connection information "+con);
    	        try (ResultSet rs = ps.executeQuery()) {
    	            while(rs.next()) {
    	            	CustomerBusinessEvent cbe= new CustomerBusinessEvent(rs.getString(1),rs.getString(2),rs.getString(3),"Campaign Management","NA","NA",
    	            			rs.getString(4),rs.getString(5),"NA","NA",rs.getString(6),rs.getString(7),rs.getString(8),"NA","NA","NA");
    	            	
    	            	cbeList.add(cbe);
    	            	File file = new File("C:\\testFiles\\"+System.currentTimeMillis());
    	            	FileWriter fileWriter = new FileWriter(file);
    	            	String s=gson.toJson(cbeList);
    	            	fileWriter.write(s);
    	        		fileWriter.flush();
    	        		fileWriter.close();
    	        		cbeList.clear();
    	        		s3.putObject(new PutObjectRequest("gldv-360-batch-stream", file.getName(), file));
    	            	
    	            }
    	           // Gson gson = new Gson();
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    }
    	}
}
