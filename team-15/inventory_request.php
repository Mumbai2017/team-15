<?php

$servername = "localhost";
$username = "root";
$password = "pratik12";
$dbname = "sanisa";

	$user_id=$_POST["user_id"];//$_SESSION("user_id");
	$item_id=$_POST["item_id"];
	$quantity=$_POST["quantity"];
	$booked_date=mkdate();
	$status=$_POST["status"];
	
	$connection=mysqli_connnect($servername, $username, $password, $dbname);
	if(!$connection){
		die("Data connection failed".mysqli_error($connection));
	}	
	
	$query="insert into inventory_request values(".$user_id",".$item_id.",".$quantity.",".$booked_date.","$status");"

	$query_run = mysqli_query($connection, $query);
	
?>