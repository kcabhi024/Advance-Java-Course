<!DOCTYPE html>
<html>
    <head>
    <meta  http-equiv ="Content-Type"; charset="UTF-8">
    <title> Processing "get " request with data </title>
    </head>
    <!-- body segment -->

    <body>
        <% // begin scriptlet
        String name = request.getParameter("firstName");

        if(name!= null)
        {
            %>
            <%-- end scriptlet to insert fixed template data --%>

            <h1>
                Hello <%=name %>, </br>
                Welcome to JavaServer pages!

            </h1>

            <% // continue scriptlet

        } // end if
        else{
           %>


                <%-- end scriptlet to insert fixed template data --%>

           <form action ="index.jsp" method ="GET">
           <p> type your first name and press submit </p>

           <p><input type = "text" name ="firstName"/>
           <input type ="submit" value ="submit" />
           </p>

           </form>
         <% // continue scriptlet


         } // else

         %> <%-- end scriptlet --%>
    </body>
  </html>