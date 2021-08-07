<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html>

        <head>
            <title>Dashboard</title>
        </head>

        <body>
            <div align=center>
                <h1>Form</h1>
                <h2>
                    <a href="new">Add New User</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="list">List All Users</a>

                </h2>
            </div>
            <div align="center">
                <c:if test="${user != null}">
                    <form action="update" method="post">
                </c:if>
                <c:if test="${user == null}">
                    <form action="add" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            <c:if test="${user != null}">
                                Edit User
                            </c:if>
                            <c:if test="${user == null}">
                                Add New User
                            </c:if>
                        </h2>
                    </caption>
                    <c:if test="${user != null}">
                        <input type="hidden" name="id" value="<c:out value='${user.userId}' />" />
                    </c:if>
                    <tr>
                        <th>First name: </th>
                        <td>
                            <input type="text" name="firstName" size="50" value="<c:out value='${user.firstName}' />" required/>
                        </td>
                    </tr>
                    <tr>
                        <th>Last name: </th>
                        <td>
                            <input type="text" name="lastName" size="50" value="<c:out value='${user.lastName}' />" required/>
                        </td>
                    </tr>
                    <tr>
                        <th>DoB: </th>
                        <td>
                            <input type="date" name="dob" size="15" value="<c:out value='${user.dob}' />" required/>
                        </td>
                    </tr>
                    <tr>
                        <th>Email: </th>
                        <td>
                            <input type="email" name="email" pattern="/^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/"
                            value="<c:out value='${user.dob}' />" required/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Save" />
                        </td>
                    </tr>
                </table>
                </form>
            </div>
        </body>

        </html>