<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.personal.app.models.entities.Expense" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>Expense List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>Expense List</h1>
    <form action="app" method="post" class="mb-3">
        <input type="hidden" name="type" value="expense"/>
        <input type="number" step="0.01" name="amount" placeholder="Amount" required/>
        <input type="text" name="description" placeholder="Description" required/>
        <button type="submit" class="btn btn-primary">Add Expense</button>
    </form>

    <table class="table table-bordered">
        <tr>
            <th>ID</th>
            <th>Description</th>
            <th>Amount</th>
        </tr>
        <%
            List<Expense> list = (List<Expense>) request.getAttribute("list");
            for (Expense exp : list) {
        %>
        <tr>
            <td><%= exp.getId() %></td>
            <td><%= exp.getDescription() %></td>
            <td><%= exp.getAmount() %></td>
        </tr>
        <% } %>
    </table>
    <a href="index.jsp" class="btn btn-secondary">Back</a>
</div>
</body>
</html>
