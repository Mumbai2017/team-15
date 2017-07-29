<?php
	$user_id=$_POST("");//$_SESSION("user_id");
	$item_id=$_POST("");
	$quantity=$_POST("");
	$booked_date=mkdate();
	$status=$_POST("");
	
	$connection=mysqli_connnect("","","");
	if(!$connection){
		die("Data connection failed".mysqli_error($connection));
	}
	$select_db=mysqli_select_db('');
	if(!$select_db){
		die("Database connection failed".mysql_error($select_db));
	}
	
	
	$query="insert into inventory_request values(".$user_id",".$item_id.",".$quantity.",".$booked_date.","$status");"


?>