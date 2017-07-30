<?php

	$user_id=$_POST['user_id'];
	$type=$_POST['type'];
	$text=$_POST['text'];

$servername = "localhost";
$username = "root";
$password = "";
$dbname = "sanisa";
	$conn = mysqli_connect($servername, $username, $password, $dbname);
	if(!$conn) {
		die("Connection failed" . mysqli_error());
	}
 	$q="insert into feedback values('".$type."','".$user_id."','".$text."')";
	$result = mysqli_query($conn, $q);
	
	
?>