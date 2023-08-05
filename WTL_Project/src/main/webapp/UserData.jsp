<%@ page import="java.sql.*" %>
<%Class.forName("com.mysql.jdbc.Driver") ;%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="index.css">
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Userdata.css">
</head>
<body>
<%
String sql="select * from leaveApplications";
String url="jdbc:mysql://localhost:3306/wtlProject";
String usname="shrushti";
String pw="shrushti@2003";
Connection con=DriverManager.getConnection(url,usname,pw);
PreparedStatement st=con.prepareStatement(sql);
ResultSet rs=st.executeQuery();

%>

<div>
<nav>
            <div class="logo">
                <p>PICT Hostel</p>
            </div>
            <ul>
                <li><a href="index.html">Home</a></li>
                <li><a href="#">About</a></li>
              
                <li><a href="#">Contact</a></li>
                <li><a href="index.html">Log Out</a></li>

            </ul>
           
            <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
            <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
            
        </nav>
</div>
        
   <br> <br>  <br>  <br>  <br>  <br> 
<br>         <br> <br> <br> 
        
 <div style="text-align:"center";">
        <table class="table table-bordered" id="details">
  <thead>
    <tr>
      <th scope="col">Sr.No</th>
      <th scope="col">Address</th>
      <th scope="col">Contact</th>
      <th scope="col">InDate</th>
      <th scope="col">ExitDate</th>
      <th scope="col">Room No.</th>
      <th scope="col">UserName</th>
      <th scope="col">Status</th>
      
      
    </tr>
  </thead>
  
  <% int count = 1 ;
  while(rs.next())
	  {%>
	  <tr>
	  <td><%= count %></td>
	  <td> <%= rs.getString(1) %> </td>
	  <td> <%= rs.getString(2) %> </td>
	  <td> <%= rs.getString(3) %> </td>
	  <td> <%= rs.getString(4) %> </td>
	  <td> <%= rs.getString(5) %> </td>
	  <td> <%= rs.getString(6) %> </td>
	  <td> <%= rs.getString(7) %> </td>
	  </tr>
	  <%
	  count++;}
  %>
	  
	  </table>
	  </div>
	  
	  
	  



</body>
</html>