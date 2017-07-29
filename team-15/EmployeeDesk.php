<?php
// Start the session
session_start();
if(empty($_SESSION["emp_list"])){
	if(empty($_SESSION["id"])){
		header("Location: /Project/index.php");
	}else{
		header("Location: /Project/selectorWindow.php");
	}
}
?>
<?php
	include 'Mysql_connect.php';
	function fetch_list(){
		include 'Mysql_connect.php';
		$emp_list=$_SESSION["emp_list"];
		$emp_id=$_SESSION["id"];
		
		$sql = "SELECT task_id,task,status FROM EmpTask where emp_list=".$emp_list." and emp_id=".$emp_id."";
		$result = $conn->query($sql);
		if ($result->num_rows > 0) {
			echo "<table><th><b>List</b></th>";
			while($row = $result->fetch_assoc()) {
				echo "<tr><td>";
				if($row['status']==true){
					echo "<span><input type='checkbox' name='chk[]' value='".$row["task_id"]."' checked> <strike>".$row["task"]."</span></strike><br>";
				}
				else{
					echo "<span><input type='checkbox' name='chk[]' value='".$row["task_id"]."'>".$row["task"]."</span><br>";
				}echo "</tr></td>";
			}
			echo "</table>";
		}
		
	}
	if(isset($_POST['submit'])){
		$emp_list=$_SESSION["emp_list"];
		$emp_id=$_SESSION["id"];
		if(!empty($_POST['chk'])) {
			$checked_count = count($_POST['chk']);
			$flag="";
			$sql = "update EmpTask set status= 0 where emp_list=".$emp_list." and emp_id=".$emp_id."";
			$conn->query($sql);
			foreach($_POST['chk'] as $selected) {
				$sql = "update EmpTask set status= 1 where task_id=".$selected."";
				$flag=$conn->query($sql);
			}
			if ($flag === TRUE) {
					
				} else {
					echo '<script language="javascript">';
					echo 'alert("Error updating record: "'. $conn->error.'")';
					echo '</script>';
				}
		}
		else{
			$sql = "update EmpTask set status= 0 where emp_list=".$emp_list." and emp_id=".$emp_id."";
			$conn->query($sql);
		}
		
	}
	if(isset($_POST['setAll'])){
		$emp_list=$_SESSION["emp_list"];
		$emp_id=$_SESSION["id"];
		$sql = "update EmpTask set status= 1 where emp_list=".$emp_list." and emp_id=".$emp_id."";
		if ($conn->query($sql)==true) {
			
		} else {
			echo '<script language="javascript">';
			echo 'alert("Error updating record: "'. $conn->error.'")';
			echo '</script>';
		}
	}
	if(isset($_POST['resetAll'])){
		$emp_list=$_SESSION["emp_list"];
		$emp_id=$_SESSION["id"];
		$sql = "update EmpTask set status= 0 where emp_list=".$emp_list." and emp_id=".$emp_id."";
		if ($conn->query($sql)==true) {
			
		} else {
			echo '<script language="javascript">';
			echo 'alert("Error updating record: "'. $conn->error.'")';
			echo '</script>';
		}
	}
	function displayProjectName(){
		include 'Mysql_connect.php';
		$emp_list=$_SESSION["emp_list"];
		$sql = "select t1.project_name from projectall t1,project_instance t2 where t1.pid=t2.pid and t2.emp_list=".$emp_list."";
		$result = $conn->query($sql);
		if ($result->num_rows > 0) {
			$row = $result->fetch_assoc();
			echo $row["project_name"];
		}
	}
	function displayModuleName(){
		include 'Mysql_connect.php';
		$emp_list=$_SESSION["emp_list"];
		$sql = "select t2.module_name from project_instance t2 where t2.emp_list=".$emp_list."";
		$result = $conn->query($sql);
		if ($result->num_rows > 0) {
			$row = $result->fetch_assoc();
			echo $row["module_name"];
		}
	}
?>
<html>
<head>
<script>
function f1(){
	document.getElementById("d1").style.backgroundColor="";
	document.getElementById("l1").style.backgroundColor="red";
	document.getElementById('container').innerHTML=document.getElementById('list').innerHTML;
}
function f2(){
	document.getElementById("d1").style.backgroundColor="red";
	document.getElementById("l1").style.backgroundColor="";
	document.getElementById('container').innerHTML=document.getElementById('display').innerHTML;
}

</script>
<style>
body {
    font-family: "Lato", sans-serif;
	overflow-y:hidden;
}

.sidenav {
    height: 100%;
    width: 0;
    position: fixed;
    z-index: 1;
    top: 0;
    left: 0;
    background-color: #111;
    overflow-x: hidden;
    transition: 0.5s;
    padding-top: 60px;
}

.sidenav p {
    padding: 8px 8px 8px 32px;
    text-decoration: none;
    font-size: 25px;
    color: #818181;
    display: block;
    transition: 0.3s
}

.sidenav p:hover, .offcanvas a:focus{
    color: #f1f1f1;
}

.sidenav .closebtn {
    position: absolute;
    top: 0;
    right: 25px;
    font-size: 36px;
    margin-left: 50px;
	text-decoration:none;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}
div.main{
	width:80%;
	
}
span{
	font-size:20px;
	color:black;
	text-shadow: 0 1px 0 #38678f;
	border-left: 6px solid steelblue;
	
}
th{background-color:steelblue;
align:center;
color:white;
font-size:25px;
}
tr{
	border-bottom: 1px solid steelblue;
}
tr:hover{
	background-color:lightgrey;
	
}
span:hover{
	border-left:6px solid red;
}
input[type='checkbox']{
	margin-bottom:10px;
}
table{
	border-collapse: collapse;
    border: 1px solid steelblue;
	width:80%;
	height:20%;
}
input[type='submit']{
	margin-top:20px;
}
/*h1,h3{
	color: white;
}
body {
    margin: 0;
	
}

ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    width: 15%;
    background-color: #0d0d0d;
    position: fixed;
    height: 100%;
    overflow: auto;
}

li a{
	cursor: pointer;
    display: block;
	color: white;
    padding: 8px 16px;
    text-decoration: none;
}


li a:hover:not(.active) {
    background-color: #555;
	text-color: #f1f1f1;
    color: white;
}
li a.selected {
 background-color:red;
}*/
input[type='submit']{
	margin-top:20px;
	border:none;
	color:white;
	background-color:steelblue;
	border-radius:40px;
	width:15%;
	height:5%;
	font-size:15px;
}
#main {
    transition: margin-left .5s;
    padding: 16px;
}
</style>
</head>
<body>
<!--<ul><center>
  <li><h1><p><?php displayProjectName(); ?></p></h1></li>
  <li><h3><p><?php displayModuleName(); ?></p></h3></li></center>
  <br>
  <li id="l1" onclick="f1()"><a>Check List</a></li>
  <br>
  <li id="d1" onclick="f2()"><a>Display</a></li>
  <hr>
  $nbsp;<font color="white">Accounts</font>
  <br>
  <br>
  <li id="d2"><a href=" /Project/selectorWindow.php"> Choice Project</a></li>
  <br>
  <li id="d2"><a href=" /Project/doLogout.php"> Logout</a></li>
</ul>-->
<div id="mySidenav" class="sidenav">
  <a   href="javascript:void(0)" class="closebtn" onclick="closeNav()" style="color:white;">&times;</a>
  <h1 style="color:white; margin-left:20px;"><?php displayProjectName(); ?></h1>
  <h2 style="color:white; margin-left:20px;"><?php displayModuleName(); ?></h2>
  <p id="l1" onclick="f1();closeNav()">Check List</p>
  <p  id="d1" onclick="f2();closeNav()">Display Progress</p>
  <p><a href="selectorWindow.php" style="text-decoration:none; color:white;">Selete Project</a></p>
  <p><a href="profilePage.php" style="text-decoration:none; color:white;">Profile</a></p>
  <p><a  style="text-decoration:none; color:white;" href=" /Project/doLogout.php"> Logout</a><p>
</div>
<div id="main"><span style="font-size:30px;cursor:pointer; border:none;" onclick="openClose()" style="border:none;">&#9776;Developer</span></div>

<script>
var i=0;
function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
    document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
    document.body.style.backgroundColor = "white";
}
function openClose(){
	if(i==0){
		document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
    document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
	i=1;
	}else{
		document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
    document.body.style.backgroundColor = "white";
	i=0;
	}
}
</script>

<div style="margin-left:18%;padding:50px 16px;height:1000px;" id="container">
</div>
<div id="list" style="visibility:hidden;">
<br>
	<form action="EmployeeDesk.php" method="post">
	<?php fetch_list(); ?><div class="main" align="center">
		<input type="submit" value="Save Progress" name="submit">
		<input type="submit" value="Set All" name="setAll">
		<input type="submit" value="Reset All" name="resetAll"></div>
	</form>
</div>
<div id="display" style="visibility:hidden;">
</div>

</body>
</html>
