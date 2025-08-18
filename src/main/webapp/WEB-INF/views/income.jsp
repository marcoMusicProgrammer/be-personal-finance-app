<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.personal.app.models.entities.Income" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>Income List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>Income List</h1>
    <form action="app" method="post" class="mb-3">
        <input type="hidden" name="type" value="income"/>
        <input type="number" step="0.01" name="amount" placeholder="Amount" required/>
        <input type="text" name="description" placeholder="Descrioption"/>
        <input type="datetime" name="date" placeholder="Date" />
       
        <button type="submit" class="btn btn-primary">Add Income</button>
    </form>

    <table class="table table-bordered">
        <tr>
            <th>ID</th>
            <th>Amount</th>
            <th>Date</th>
        </tr>
        <%
            List<Income> list = (List<Income>) request.getAttribute("list");
            for (Income inc : list) {
        %>
        <tr>
            <td><%= inc.getId() %></td>
            <td><%= inc.getAmount() %></td>
            <td><%= inc.getDate() %></td>
        </tr>
        <% } %>
    </table>
    <a href="index.jsp" class="btn btn-secondary">Back</a>
</div>
</body>
</html>
