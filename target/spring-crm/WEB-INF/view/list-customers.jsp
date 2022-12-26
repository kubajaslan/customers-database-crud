<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

        <!DOCTYPE html>
        <html>

        <head>
            <title>Customer List</title>

            <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />

        </head>

        <body>
            <div id="wrapper">
                <div id="header">
                    <h2>Customer Database</h2>

                </div>
            </div>

            <div id="container">
                <div id="content">

                    <input type="button" value="Add customer"
                        onclick="window.location.href='showFormForAdd'; return false;" class="add-button" />

                    <form:form action="search" method="GET">
                        Search customer by name: <input type="text" name="name" />

                        <input type="submit" value="Search" class="add-button" />

                    </form:form>

                    <form:form action="searchById" method="GET">
                        Search customer by ID: <input type="number" name="id" />

                        <input type="submit" value="Search by ID" class="add-button" />



                    </form:form>


                    <table>
                        <tr>
                            <th> First Name </th>
                            <th> Last Name </th>
                            <th> Email </th>
                            <th> Action </th>
                        </tr>


                        <c:forEach var="tempCustomer" items="${customers}">

                            <c:url var="updateLink" value="/customer/showFormForUpdate">
                                <c:param name="customerId" value="${tempCustomer.id}" />
                            </c:url>

                            <c:url var="deleteLink" value="/customer/delete">
                                <c:param name="customerId" value="${tempCustomer.id}" />
                            </c:url>

                            <tr>
                                <td> ${tempCustomer.firstName} </td>
                                <td> ${tempCustomer.lastName} </td>
                                <td> ${tempCustomer.email} </td>
                                <td>
                                <a href="${updateLink}">
                                Update
                                </a>
                                |
                                <a href="${deleteLink}"
                                 onclick="return confirm('Are you sure you want to delete this customer?');">
                                Delete
                                </a>
                                </td>

                            </tr>
                        </c:forEach>

                    </table>
                </div>

            </div>


        </body>

        </html>