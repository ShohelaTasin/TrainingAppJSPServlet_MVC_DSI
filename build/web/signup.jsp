<body>
 <div align="center">
  <h1>Register Page</h1>
  <form action="<%=request.getContextPath()%>/signup" method="post">
   <table style="with: 100%">
    <tr>
     <td>Enter UserName</td>
     <td><input type="text" name="username" /></td>
    </tr>
    <tr>
     <td>Enter Password</td>
     <td><input type="password" name="password" /></td>
    </tr>

   </table>
   <input type="submit" value="Register" />
  </form>
   
 </div>
</body>
</html>
