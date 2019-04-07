<%--
  Created by IntelliJ IDEA.
  User: leovo
  Date: 2019/4/7
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>个人信息</title>
</head>
<link rel="stylesheet" href="${ctx}/public/css/xadmin.css">

<body>
<fieldset class="layui-elem-field">
    <legend>系统信息</legend>
    <div class="layui-field-box">
        <table class="layui-table">
            <tbody>
            <tr>
                <th>员工编号</th>
                <td>${user.id} </td></tr>
            <tr>
                <th>姓名</th>
                <td>${user.loginname} </td></tr>
            <tr>
                <th>性别</th>
                <td> ${personalInfo.gender}</td></tr>
            <tr>
                <th>出生日期</th>
                <td> ${user.id}</td></tr>
            <tr>
                <th>籍贯</th>
                <td> ${user.id}</td>
                <th>身份证号</th>
                <td> ${user.id}</td></tr>
            <tr>
                <th>毕业院校</th>
                <td>${user.id} </td>
                <th>学历</th>
                <td>${user.id} </td></tr>
            <tr>
                <th>联系电话</th>
                <td> ${user.id}</td>
                <th>电子邮箱</th>
                <td>${user.id} </td></tr>
            <tr>
                <th>部门</th>
                <td>${user.id} </td>
                <th>职位</th>
                <td>${user.id} </td><
            <tr>
                <th>入职时间</th>
                <td> ${user.id}</td>
                <th>上级</th>
                <td>${user.id} </td></tr>
            <tr>
                <th>合同期限</th>
                <td> ${user.id}</td>
                <th>在职状态</th>
                <td> ${user.id}</td></tr>
            <tr>
                <th>工作经历</th>
                <td> ${user.id}</td></tr>
            <tr>
                <th>备注</th>
                <td>${user.id} </td></tr>

            </tbody>
        </table>
    </div>
</fieldset>
</body>
</html>
