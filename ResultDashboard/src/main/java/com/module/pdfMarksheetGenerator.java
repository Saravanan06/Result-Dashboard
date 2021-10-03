package com.module;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.buf.C2BConverter;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.ImgCCITT;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPages;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;


/**
 * Servlet implementation class pdfGenerator
 */
@WebServlet("/pdfMarksheetGenerator")
public class pdfMarksheetGenerator extends HttpServlet {
	
	protected String equMark(int mark)
	{
		String result="";
		if(mark<100)result="0"+mark;
		else result=""+mark;
		return result;
	}
	public String numToWord(int mark)
	{
		String nums[]= {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
		String result="";
		int n=mark;
		while(mark!=0)
		{
			int temp=mark%10;
			result=nums[temp]+" "+result;
			mark/=10;
		}
		if(n<100)result=nums[0]+" "+result;
		return result;
	}
	public String resultStatus(int mark)
	{
		if(mark>=35)return "Pass";
		return "Fail";
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		/*Rectangle layout = new Rectangle(PageSize.A4);
	    layout.setBorderColor(BaseColor.BLACK);  //Border color
	    layout.setBorderWidth(6);    
	    layout.setBorder(Rectangle.BOX);*/
	    
	    /*Rectangle rect = new Rectangle(PageSize.A4);
	    
	    System.out.println(rect.getBorder());
	    rect.getLeft(2);
	    rect.getRight(2);
	    rect.getTop(2);
	    rect.getBottom(2);
        rect.setBorder(Rectangle.BOX); // left, right, top, bottom border
        rect.setBorderWidth(5); // a width of 5 user units
        rect.setBorderColor(BaseColor.RED); // a red border
        rect.setUseVariableBorders(true);*/
        
        Document document = new Document();
        student stud1=(student) request.getSession().getAttribute("student");
        String rollno=stud1.getRollno();
        System.out.println(rollno);
        String FILE_NAME = "D:\\Java Pdfs\\"+rollno;
		String base=new String(FILE_NAME);
		String name=new String(FILE_NAME);
		int n=1;
		while (new File(name+".pdf").exists())
		    name=base+"("+ n++ + ")";
		FILE_NAME=name+".pdf";
        	
        	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
    		String url="jdbc:mysql://localhost:3306/school";
    		String uname="root";
    		String password="aladipillaiyar";
    		Connection con=DriverManager.getConnection(url,uname,password);
    		Statement st= con.createStatement();
    		String query="select * from marklist inner join student where student.rollno=marklist.rollno and student.rollno='"+rollno+"'";
    		ResultSet rs=st.executeQuery(query);
    		if(rs.next()) {
    			
    		student stud=new student(rs);
    		
    		
            PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
            document.open();
            
            //Logo
            Image img=Image.getInstance("C:\\Users\\Selvam\\eclipse-workspace\\Java EE Workspace\\ResultDashboard\\src\\main\\webapp\\images\\tamilnadulogo.png");
            img.setAlignment(Image.MIDDLE);
            img.scaleToFit(75, 75);
            document.add(img);
            
            //Header
            Font head=new Font();
            head.setStyle(Font.BOLD);
            head.setSize(20);
            Paragraph p = new Paragraph("Tamilnadu School Education Department",head);
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            document.add(new Paragraph(" "));
            
            head.setSize(15);
            Paragraph p2 = new Paragraph("Statement of marks",head);
            p2.setAlignment(Element.ALIGN_CENTER);
            document.add(p2);
            document.add(new Paragraph(" "));document.add(new Paragraph(" "));
            
            //Name Table
            PdfPTable table1 = new PdfPTable(2);
            table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table1.getDefaultCell().setPadding(10);
            table1.getDefaultCell().setBorderWidth(1.5f);
            Font nameFont=new Font();
            nameFont.setStyle(Font.BOLD);
            PdfPCell c1 = new PdfPCell(new Phrase("Name of the Candidate",nameFont));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setPadding(8);
            c1.setBorderWidth(1.5f);
            c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table1.addCell(c1);
            
            c1 = new PdfPCell(new Phrase("Session",nameFont));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setPadding(8);
            c1.setBorderWidth(1.5f);
            c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table1.addCell(c1);
            
            table1.addCell(""+stud.name);
            table1.addCell("March 2021");
            
            document.add(table1);
            document.add(new Paragraph(" "));
            String cert="This is to Certify that the above mentioned candidate appeared for the examination and obtained the following marks";
            document.add(new Paragraph(cert));
            document.add(new Paragraph(" "));document.add(new Paragraph(" "));
            // Marklist Table
            PdfPTable table = new PdfPTable(4);
            table.getDefaultCell().setBorderWidth(1.5f);
            table.setWidths(new int[]{2, 1, 2, 1});
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table.getDefaultCell().setPadding(10);
            
            PdfPCell c10 = new PdfPCell(new Phrase("Subject",nameFont));
            c10.setBorderWidth(1.5f);
            c10.setHorizontalAlignment(Element.ALIGN_CENTER);
            c10.setPadding(8);
            c10.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(c10);
            
            c10 = new PdfPCell(new Phrase("Marks\n(100)",nameFont));
            c10.setHorizontalAlignment(Element.ALIGN_CENTER);
            c10.setPadding(8);
            c10.setBorderWidth(1.5f);
            c10.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(c10);
            
            c10 = new PdfPCell(new Phrase("Marks\n(in words)",nameFont));
            c10.setHorizontalAlignment(Element.ALIGN_CENTER);
            c10.setPadding(8);
            c10.setBorderWidth(1.5f);
            c10.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(c10);
            
            c10 = new PdfPCell(new Phrase("Result",nameFont));
            c10.setHorizontalAlignment(Element.ALIGN_CENTER);
            c10.setPadding(8);
            c10.setBorderWidth(1.5f);
            c10.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(c10);
            
            table.addCell("Tamil");table.addCell(equMark(stud.tamil));table.addCell(numToWord(stud.tamil));table.addCell(resultStatus(stud.tamil));
            
            table.addCell("English");table.addCell(equMark(stud.english));table.addCell(numToWord(stud.english));table.addCell(resultStatus(stud.english));
            
            table.addCell("Maths");table.addCell(equMark(stud.maths));table.addCell(numToWord(stud.maths));table.addCell(resultStatus(stud.maths));
            
            table.addCell("Science");table.addCell(equMark(stud.science));table.addCell(numToWord(stud.science));table.addCell(resultStatus(stud.science));
            
            table.addCell("Social");table.addCell(equMark(stud.social));table.addCell(numToWord(stud.social));table.addCell(resultStatus(stud.social));
            
            table.addCell(new Phrase("Total",nameFont));
            table.addCell(new Phrase(equMark(stud.total),nameFont));
            PdfPCell cell = new PdfPCell(new Phrase(numToWord(stud.total),nameFont));
            cell.setBorderWidth(1.5f);
            cell.setPadding(8);
            cell.setColspan(2);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
            table.getDefaultCell().setBackgroundColor(BaseColor.BLACK);
            
            Font f1=new Font(Font.getFamily("Times New Roman"));
            f1.setStyle(Font.BOLD);
            cell = new PdfPCell(new Phrase("Overall Result",f1));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setColspan(2);
            cell.setPadding(8);
            cell.setBorderWidth(1.5f);
            table.addCell(cell);
             
            f1.setStyle(Font.BOLD);
            cell = new PdfPCell(new Phrase(""+stud.result,f1));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setColspan(2);
            cell.setPadding(8);
            cell.setBorderWidth(1.5f);
            table.addCell(cell);
            document.add(table);
            
           
            //DOB and Roll no
            document.add(new Paragraph(" "));
            PdfPTable table2 = new PdfPTable(2);
            table2.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table2.getDefaultCell().setPadding(10);
            table2.getDefaultCell().setBorderWidth(1.5f);
            PdfPCell c2 = new PdfPCell(new Phrase("Date of Birth",nameFont));
            c2.setHorizontalAlignment(Element.ALIGN_CENTER);
            c2.setBorderWidth(1.5f);
            c2.setPadding(8);
            c2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table2.addCell(c2);
            
            
            c2 = new PdfPCell(new Phrase("Register Number",nameFont));
            c2.setPadding(8);
            c2.setHorizontalAlignment(Element.ALIGN_CENTER);
            c2.setBorderWidth(1.5f);
            c2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table2.addCell(c2);
            
            table2.addCell(""+stud.dob);
            table2.addCell(""+stud.rollno);
            
            document.add(table2);
            
            //Note
            document.add(new Paragraph(" "));
            Font f2=new Font(Font.getFamily("Times New Roman"));
            f2.setSize(9);
            document.add(new Paragraph("Note: This is System generated certificate. The candidate who have passed in all the subjects is eligible for higher studies. The genuniness of this statement of marks can be verified in the website.",f2));
            document.add(new Paragraph(" "));
            
            
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); 
            LocalDateTime now = LocalDateTime.now();  
            f2.setSize(8);
            Paragraph p3=new Paragraph("\nMarksheet generated on "+dtf.format(now),f2);
            p3.setAlignment(Element.ALIGN_CENTER);
            
            document.add(p3);
    		document.close();
    		
    		
    		}
        	} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	finally
        	{
        		response.sendRedirect("displayMarklist.jsp");
        	}
	}

}
